/*
 * Copyright © 2016 Mathias Doenitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package swave.core.impl.stages.source

import scala.annotation.tailrec
import swave.core.PipeElem
import swave.core.impl.Outport

// format: OFF
private[core] final class RepeatStage(element: AnyRef) extends SourceStage with PipeElem.Source.Repeat {

  def pipeElemType: String = "Stream.repeat"
  def pipeElemParams: List[Any] = element :: Nil

  connectOutAndStartWith { (ctx, out) ⇒ running(out) }

  def running(out: Outport): State =
    state(name = "running",

      request = (n, _) ⇒ {
        @tailrec def rec(n: Int): State =
          if (n > 0) {
            out.onNext(element)
            rec(n - 1)
          } else stay()
        rec(n)
      },

      cancel = stopF)
}

