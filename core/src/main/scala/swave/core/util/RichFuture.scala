/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package swave.core.util

import java.util.concurrent.TimeoutException
import scala.concurrent.duration._
import scala.concurrent.{Await, Future, Promise}
import swave.core.StreamEnv

final class RichFuture[T](val underlying: Future[T]) extends AnyVal {

  def await(timeout: FiniteDuration = 1.second): T =
    underlying.value match {
      case Some(t)                          ⇒ t.get
      case None if timeout == Duration.Zero ⇒ throw new TimeoutException(s"Future was not completed")
      case _                                ⇒ Await.result(underlying, timeout)
    }

  def delay(duration: FiniteDuration)(implicit env: StreamEnv): Future[T] = {
    import env.defaultDispatcher
    val promise = Promise[T]()
    underlying.onComplete { value ⇒
      env.scheduler.scheduleOnce(duration) { promise.complete(value); () }
    }
    promise.future
  }
}
