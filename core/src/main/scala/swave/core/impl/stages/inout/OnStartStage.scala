/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package swave.core.impl.stages.inout

import scala.util.control.NonFatal
import swave.core.impl.{Inport, Outport}
import swave.core.macros.StageImplementation
import swave.core.Stage
import swave.core.impl.stages.InOutStage

// format: OFF
@StageImplementation
private[core] final class OnStartStage(callback: () ⇒ Unit) extends InOutStage {

  def kind = Stage.Kind.InOut.OnStart(callback)

  connectInOutAndSealWith { (in, out) ⇒
    region.impl.registerForXStart(this)
    awaitingXStart(in, out)
  }

  def awaitingXStart(in: Inport, out: Outport) = state(
    xStart = () => {
      try {
        callback()
        running(in, out)
      }
      catch {
        case NonFatal(e) =>
          in.cancel()
          stopError(e, out)
      }
    })

  def running(in: Inport, out: Outport) = state(
    intercept = false,

    request = requestF(in),
    cancel = stopCancelF(in),
    onNext = onNextF(out),
    onComplete = stopCompleteF(out),
    onError = stopErrorF(out))
}
