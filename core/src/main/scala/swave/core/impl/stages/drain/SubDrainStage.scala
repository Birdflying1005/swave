/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package swave.core.impl.stages.drain

import scala.util.control.NonFatal
import swave.core.impl.stages.{DrainStage, StageImpl}
import swave.core.impl.{Inport, RunSupport, StreamRunner}
import swave.core.macros.StageImplementation
import swave.core.{Cancellable, Stage, SubscriptionTimeoutException}

// format: OFF
@StageImplementation(fullInterceptions = true)
private[core] final class SubDrainStage(runContext: RunSupport.RunContext, val out: StageImpl) extends DrainStage {
  import SubDrainStage._

  def kind = Stage.Kind.Drain.Sub(out)

  initialState(awaitingOnSubscribe(false, null))

  def sealAndStart() =
    try RunSupport.sealAndStartSubStream(this, runContext)
    catch {
      case NonFatal(e) => out.onError(e)
    }

  def awaitingOnSubscribe(cancelled: Boolean, timer: Cancellable): State = state(
    cancel = _ => awaitingOnSubscribe(cancelled = true, timer),

    onSubscribe = from ⇒ {
      if (timer ne null) timer.cancel()
      _inputStages = from.stageImpl :: Nil
      xEvent(DoOnSubscribe) // schedule event for after the state transition
      ready(from, cancelled)
    },

    xEvent = {
      case EnableSubscriptionTimeout if timer eq null =>
        val t = runContext.scheduleSubscriptionTimeout(this)
        awaitingOnSubscribe(cancelled, t)
      case RunSupport.SubscriptionTimeout =>
        val msg = s"Subscription attempt from SubDrainStage timed out after ${runContext.env.settings.subscriptionTimeout}"
        stopError(new SubscriptionTimeoutException(msg), out)
    })

  def ready(in: Inport, cancelled: Boolean): State = state(
    cancel = _ => ready(in, true),

    xSeal = ctx ⇒ {
      configureFrom(ctx)
      ctx.assignRunContext(runContext)
      if (out.hasRunner) ctx.registerRunnerAssignment(StreamRunner.Assignment.Runner(this, out.runner))
      in.xSeal(ctx)
      if (cancelled) {
        ctx.registerForXStart(this)
        awaitingXStart(in)
      } else running(in)
    },

    xEvent = {
      case DoOnSubscribe => { out.onSubscribe(); stay() }
      case EnableSubscriptionTimeout => stay() // ignore
      case RunSupport.SubscriptionTimeout => stay() // ignore
    })

  def awaitingXStart(in: Inport) = state(
    xStart = () => stopCancel(in),

    xEvent = {
      case EnableSubscriptionTimeout => stay() // ignore
      case RunSupport.SubscriptionTimeout => stay() // ignore
    })

  def running(in: Inport) = state(
    intercept = false,

    request = requestF(in),
    cancel = stopCancelF(in),
    onNext = onNextF(out),
    onComplete = stopCompleteF(out),
    onError = stopErrorF(out),

    xEvent = {
      case EnableSubscriptionTimeout => stay() // ignore
      case RunSupport.SubscriptionTimeout => stay() // ignore
    })
}

private[core] object SubDrainStage {

  case object EnableSubscriptionTimeout
  private case object DoOnSubscribe
}
