/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

/*

Copyright (c) 2007-2016, Rickard Nilsson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
      this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
      this list of conditions and the following disclaimer in the documentation
      and/or other materials provided with the distribution.
    * Neither the name of the EPFL nor the names of its contributors
      may be used to endorse or promote products derived from this software
      without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.scalacheck

private[scalacheck] abstract class CogenArities{

  
  implicit final def tuple1[T1](implicit c1:Cogen[T1]): Cogen[Tuple1[T1]] =
    Cogen((seed: rng.Seed, t: Tuple1[T1]) =>
      c1.perturb(seed, t._1)
    )

  implicit final def tuple2[T1,T2](implicit c1:Cogen[T1], c2:Cogen[T2]): Cogen[Tuple2[T1,T2]] =
    Cogen((seed: rng.Seed, t: Tuple2[T1,T2]) =>
      c2.perturb(c1.perturb(seed, t._1), t._2)
    )

  implicit final def tuple3[T1,T2,T3](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3]): Cogen[Tuple3[T1,T2,T3]] =
    Cogen((seed: rng.Seed, t: Tuple3[T1,T2,T3]) =>
      c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3)
    )

  implicit final def tuple4[T1,T2,T3,T4](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4]): Cogen[Tuple4[T1,T2,T3,T4]] =
    Cogen((seed: rng.Seed, t: Tuple4[T1,T2,T3,T4]) =>
      c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4)
    )

  implicit final def tuple5[T1,T2,T3,T4,T5](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5]): Cogen[Tuple5[T1,T2,T3,T4,T5]] =
    Cogen((seed: rng.Seed, t: Tuple5[T1,T2,T3,T4,T5]) =>
      c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5)
    )

  implicit final def tuple6[T1,T2,T3,T4,T5,T6](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6]): Cogen[Tuple6[T1,T2,T3,T4,T5,T6]] =
    Cogen((seed: rng.Seed, t: Tuple6[T1,T2,T3,T4,T5,T6]) =>
      c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6)
    )

  implicit final def tuple7[T1,T2,T3,T4,T5,T6,T7](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7]): Cogen[Tuple7[T1,T2,T3,T4,T5,T6,T7]] =
    Cogen((seed: rng.Seed, t: Tuple7[T1,T2,T3,T4,T5,T6,T7]) =>
      c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7)
    )

  implicit final def tuple8[T1,T2,T3,T4,T5,T6,T7,T8](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8]): Cogen[Tuple8[T1,T2,T3,T4,T5,T6,T7,T8]] =
    Cogen((seed: rng.Seed, t: Tuple8[T1,T2,T3,T4,T5,T6,T7,T8]) =>
      c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8)
    )

  implicit final def tuple9[T1,T2,T3,T4,T5,T6,T7,T8,T9](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9]): Cogen[Tuple9[T1,T2,T3,T4,T5,T6,T7,T8,T9]] =
    Cogen((seed: rng.Seed, t: Tuple9[T1,T2,T3,T4,T5,T6,T7,T8,T9]) =>
      c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9)
    )

  implicit final def tuple10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10]): Cogen[Tuple10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]] =
    Cogen((seed: rng.Seed, t: Tuple10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]) =>
      c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10)
    )

  implicit final def tuple11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11]): Cogen[Tuple11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]] =
    Cogen((seed: rng.Seed, t: Tuple11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]) =>
      c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11)
    )

  implicit final def tuple12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12]): Cogen[Tuple12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]] =
    Cogen((seed: rng.Seed, t: Tuple12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]) =>
      c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12)
    )

  implicit final def tuple13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13]): Cogen[Tuple13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]] =
    Cogen((seed: rng.Seed, t: Tuple13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]) =>
      c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13)
    )

  implicit final def tuple14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13], c14:Cogen[T14]): Cogen[Tuple14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]] =
    Cogen((seed: rng.Seed, t: Tuple14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]) =>
      c14.perturb(c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13), t._14)
    )

  implicit final def tuple15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13], c14:Cogen[T14], c15:Cogen[T15]): Cogen[Tuple15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]] =
    Cogen((seed: rng.Seed, t: Tuple15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]) =>
      c15.perturb(c14.perturb(c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13), t._14), t._15)
    )

  implicit final def tuple16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13], c14:Cogen[T14], c15:Cogen[T15], c16:Cogen[T16]): Cogen[Tuple16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]] =
    Cogen((seed: rng.Seed, t: Tuple16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]) =>
      c16.perturb(c15.perturb(c14.perturb(c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13), t._14), t._15), t._16)
    )

  implicit final def tuple17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13], c14:Cogen[T14], c15:Cogen[T15], c16:Cogen[T16], c17:Cogen[T17]): Cogen[Tuple17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]] =
    Cogen((seed: rng.Seed, t: Tuple17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]) =>
      c17.perturb(c16.perturb(c15.perturb(c14.perturb(c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13), t._14), t._15), t._16), t._17)
    )

  implicit final def tuple18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13], c14:Cogen[T14], c15:Cogen[T15], c16:Cogen[T16], c17:Cogen[T17], c18:Cogen[T18]): Cogen[Tuple18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]] =
    Cogen((seed: rng.Seed, t: Tuple18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]) =>
      c18.perturb(c17.perturb(c16.perturb(c15.perturb(c14.perturb(c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13), t._14), t._15), t._16), t._17), t._18)
    )

  implicit final def tuple19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13], c14:Cogen[T14], c15:Cogen[T15], c16:Cogen[T16], c17:Cogen[T17], c18:Cogen[T18], c19:Cogen[T19]): Cogen[Tuple19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]] =
    Cogen((seed: rng.Seed, t: Tuple19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]) =>
      c19.perturb(c18.perturb(c17.perturb(c16.perturb(c15.perturb(c14.perturb(c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13), t._14), t._15), t._16), t._17), t._18), t._19)
    )

  implicit final def tuple20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13], c14:Cogen[T14], c15:Cogen[T15], c16:Cogen[T16], c17:Cogen[T17], c18:Cogen[T18], c19:Cogen[T19], c20:Cogen[T20]): Cogen[Tuple20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]] =
    Cogen((seed: rng.Seed, t: Tuple20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]) =>
      c20.perturb(c19.perturb(c18.perturb(c17.perturb(c16.perturb(c15.perturb(c14.perturb(c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13), t._14), t._15), t._16), t._17), t._18), t._19), t._20)
    )

  implicit final def tuple21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13], c14:Cogen[T14], c15:Cogen[T15], c16:Cogen[T16], c17:Cogen[T17], c18:Cogen[T18], c19:Cogen[T19], c20:Cogen[T20], c21:Cogen[T21]): Cogen[Tuple21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]] =
    Cogen((seed: rng.Seed, t: Tuple21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]) =>
      c21.perturb(c20.perturb(c19.perturb(c18.perturb(c17.perturb(c16.perturb(c15.perturb(c14.perturb(c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13), t._14), t._15), t._16), t._17), t._18), t._19), t._20), t._21)
    )

  implicit final def tuple22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](implicit c1:Cogen[T1], c2:Cogen[T2], c3:Cogen[T3], c4:Cogen[T4], c5:Cogen[T5], c6:Cogen[T6], c7:Cogen[T7], c8:Cogen[T8], c9:Cogen[T9], c10:Cogen[T10], c11:Cogen[T11], c12:Cogen[T12], c13:Cogen[T13], c14:Cogen[T14], c15:Cogen[T15], c16:Cogen[T16], c17:Cogen[T17], c18:Cogen[T18], c19:Cogen[T19], c20:Cogen[T20], c21:Cogen[T21], c22:Cogen[T22]): Cogen[Tuple22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]] =
    Cogen((seed: rng.Seed, t: Tuple22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]) =>
      c22.perturb(c21.perturb(c20.perturb(c19.perturb(c18.perturb(c17.perturb(c16.perturb(c15.perturb(c14.perturb(c13.perturb(c12.perturb(c11.perturb(c10.perturb(c9.perturb(c8.perturb(c7.perturb(c6.perturb(c5.perturb(c4.perturb(c3.perturb(c2.perturb(c1.perturb(seed, t._1), t._2), t._3), t._4), t._5), t._6), t._7), t._8), t._9), t._10), t._11), t._12), t._13), t._14), t._15), t._16), t._17), t._18), t._19), t._20), t._21), t._22)
    )


  import Arbitrary.arbitrary
  import Gen.Parameters.{ default => params }
  import rng.Seed

  
  implicit final def function1[T1, Z](implicit a1:Arbitrary[T1], z: Cogen[Z]): Cogen[Function1[T1, Z]] =
    Cogen { (seed: Seed, f: Function1[T1, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get))
    }

  implicit final def function2[T1,T2, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], z: Cogen[Z]): Cogen[Function2[T1,T2, Z]] =
    Cogen { (seed: Seed, f: Function2[T1,T2, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get))
    }

  implicit final def function3[T1,T2,T3, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], z: Cogen[Z]): Cogen[Function3[T1,T2,T3, Z]] =
    Cogen { (seed: Seed, f: Function3[T1,T2,T3, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get))
    }

  implicit final def function4[T1,T2,T3,T4, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], z: Cogen[Z]): Cogen[Function4[T1,T2,T3,T4, Z]] =
    Cogen { (seed: Seed, f: Function4[T1,T2,T3,T4, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get))
    }

  implicit final def function5[T1,T2,T3,T4,T5, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], z: Cogen[Z]): Cogen[Function5[T1,T2,T3,T4,T5, Z]] =
    Cogen { (seed: Seed, f: Function5[T1,T2,T3,T4,T5, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get))
    }

  implicit final def function6[T1,T2,T3,T4,T5,T6, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], z: Cogen[Z]): Cogen[Function6[T1,T2,T3,T4,T5,T6, Z]] =
    Cogen { (seed: Seed, f: Function6[T1,T2,T3,T4,T5,T6, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get))
    }

  implicit final def function7[T1,T2,T3,T4,T5,T6,T7, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], z: Cogen[Z]): Cogen[Function7[T1,T2,T3,T4,T5,T6,T7, Z]] =
    Cogen { (seed: Seed, f: Function7[T1,T2,T3,T4,T5,T6,T7, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get))
    }

  implicit final def function8[T1,T2,T3,T4,T5,T6,T7,T8, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], z: Cogen[Z]): Cogen[Function8[T1,T2,T3,T4,T5,T6,T7,T8, Z]] =
    Cogen { (seed: Seed, f: Function8[T1,T2,T3,T4,T5,T6,T7,T8, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get))
    }

  implicit final def function9[T1,T2,T3,T4,T5,T6,T7,T8,T9, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], z: Cogen[Z]): Cogen[Function9[T1,T2,T3,T4,T5,T6,T7,T8,T9, Z]] =
    Cogen { (seed: Seed, f: Function9[T1,T2,T3,T4,T5,T6,T7,T8,T9, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get))
    }

  implicit final def function10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], z: Cogen[Z]): Cogen[Function10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10, Z]] =
    Cogen { (seed: Seed, f: Function10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get))
    }

  implicit final def function11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], z: Cogen[Z]): Cogen[Function11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11, Z]] =
    Cogen { (seed: Seed, f: Function11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get))
    }

  implicit final def function12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], z: Cogen[Z]): Cogen[Function12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12, Z]] =
    Cogen { (seed: Seed, f: Function12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get))
    }

  implicit final def function13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], z: Cogen[Z]): Cogen[Function13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13, Z]] =
    Cogen { (seed: Seed, f: Function13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get))
    }

  implicit final def function14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], a14:Arbitrary[T14], z: Cogen[Z]): Cogen[Function14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14, Z]] =
    Cogen { (seed: Seed, f: Function14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)
      val r14 = arbitrary[T14].doPureApply(params, r13.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get, r14.retrieve.get))
    }

  implicit final def function15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], a14:Arbitrary[T14], a15:Arbitrary[T15], z: Cogen[Z]): Cogen[Function15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15, Z]] =
    Cogen { (seed: Seed, f: Function15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)
      val r14 = arbitrary[T14].doPureApply(params, r13.seed)
      val r15 = arbitrary[T15].doPureApply(params, r14.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get, r14.retrieve.get, r15.retrieve.get))
    }

  implicit final def function16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], a14:Arbitrary[T14], a15:Arbitrary[T15], a16:Arbitrary[T16], z: Cogen[Z]): Cogen[Function16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16, Z]] =
    Cogen { (seed: Seed, f: Function16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)
      val r14 = arbitrary[T14].doPureApply(params, r13.seed)
      val r15 = arbitrary[T15].doPureApply(params, r14.seed)
      val r16 = arbitrary[T16].doPureApply(params, r15.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get, r14.retrieve.get, r15.retrieve.get, r16.retrieve.get))
    }

  implicit final def function17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], a14:Arbitrary[T14], a15:Arbitrary[T15], a16:Arbitrary[T16], a17:Arbitrary[T17], z: Cogen[Z]): Cogen[Function17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17, Z]] =
    Cogen { (seed: Seed, f: Function17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)
      val r14 = arbitrary[T14].doPureApply(params, r13.seed)
      val r15 = arbitrary[T15].doPureApply(params, r14.seed)
      val r16 = arbitrary[T16].doPureApply(params, r15.seed)
      val r17 = arbitrary[T17].doPureApply(params, r16.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get, r14.retrieve.get, r15.retrieve.get, r16.retrieve.get, r17.retrieve.get))
    }

  implicit final def function18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], a14:Arbitrary[T14], a15:Arbitrary[T15], a16:Arbitrary[T16], a17:Arbitrary[T17], a18:Arbitrary[T18], z: Cogen[Z]): Cogen[Function18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18, Z]] =
    Cogen { (seed: Seed, f: Function18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)
      val r14 = arbitrary[T14].doPureApply(params, r13.seed)
      val r15 = arbitrary[T15].doPureApply(params, r14.seed)
      val r16 = arbitrary[T16].doPureApply(params, r15.seed)
      val r17 = arbitrary[T17].doPureApply(params, r16.seed)
      val r18 = arbitrary[T18].doPureApply(params, r17.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get, r14.retrieve.get, r15.retrieve.get, r16.retrieve.get, r17.retrieve.get, r18.retrieve.get))
    }

  implicit final def function19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], a14:Arbitrary[T14], a15:Arbitrary[T15], a16:Arbitrary[T16], a17:Arbitrary[T17], a18:Arbitrary[T18], a19:Arbitrary[T19], z: Cogen[Z]): Cogen[Function19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19, Z]] =
    Cogen { (seed: Seed, f: Function19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)
      val r14 = arbitrary[T14].doPureApply(params, r13.seed)
      val r15 = arbitrary[T15].doPureApply(params, r14.seed)
      val r16 = arbitrary[T16].doPureApply(params, r15.seed)
      val r17 = arbitrary[T17].doPureApply(params, r16.seed)
      val r18 = arbitrary[T18].doPureApply(params, r17.seed)
      val r19 = arbitrary[T19].doPureApply(params, r18.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get, r14.retrieve.get, r15.retrieve.get, r16.retrieve.get, r17.retrieve.get, r18.retrieve.get, r19.retrieve.get))
    }

  implicit final def function20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], a14:Arbitrary[T14], a15:Arbitrary[T15], a16:Arbitrary[T16], a17:Arbitrary[T17], a18:Arbitrary[T18], a19:Arbitrary[T19], a20:Arbitrary[T20], z: Cogen[Z]): Cogen[Function20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20, Z]] =
    Cogen { (seed: Seed, f: Function20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)
      val r14 = arbitrary[T14].doPureApply(params, r13.seed)
      val r15 = arbitrary[T15].doPureApply(params, r14.seed)
      val r16 = arbitrary[T16].doPureApply(params, r15.seed)
      val r17 = arbitrary[T17].doPureApply(params, r16.seed)
      val r18 = arbitrary[T18].doPureApply(params, r17.seed)
      val r19 = arbitrary[T19].doPureApply(params, r18.seed)
      val r20 = arbitrary[T20].doPureApply(params, r19.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get, r14.retrieve.get, r15.retrieve.get, r16.retrieve.get, r17.retrieve.get, r18.retrieve.get, r19.retrieve.get, r20.retrieve.get))
    }

  implicit final def function21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], a14:Arbitrary[T14], a15:Arbitrary[T15], a16:Arbitrary[T16], a17:Arbitrary[T17], a18:Arbitrary[T18], a19:Arbitrary[T19], a20:Arbitrary[T20], a21:Arbitrary[T21], z: Cogen[Z]): Cogen[Function21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21, Z]] =
    Cogen { (seed: Seed, f: Function21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)
      val r14 = arbitrary[T14].doPureApply(params, r13.seed)
      val r15 = arbitrary[T15].doPureApply(params, r14.seed)
      val r16 = arbitrary[T16].doPureApply(params, r15.seed)
      val r17 = arbitrary[T17].doPureApply(params, r16.seed)
      val r18 = arbitrary[T18].doPureApply(params, r17.seed)
      val r19 = arbitrary[T19].doPureApply(params, r18.seed)
      val r20 = arbitrary[T20].doPureApply(params, r19.seed)
      val r21 = arbitrary[T21].doPureApply(params, r20.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get, r14.retrieve.get, r15.retrieve.get, r16.retrieve.get, r17.retrieve.get, r18.retrieve.get, r19.retrieve.get, r20.retrieve.get, r21.retrieve.get))
    }

  implicit final def function22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22, Z](implicit a1:Arbitrary[T1], a2:Arbitrary[T2], a3:Arbitrary[T3], a4:Arbitrary[T4], a5:Arbitrary[T5], a6:Arbitrary[T6], a7:Arbitrary[T7], a8:Arbitrary[T8], a9:Arbitrary[T9], a10:Arbitrary[T10], a11:Arbitrary[T11], a12:Arbitrary[T12], a13:Arbitrary[T13], a14:Arbitrary[T14], a15:Arbitrary[T15], a16:Arbitrary[T16], a17:Arbitrary[T17], a18:Arbitrary[T18], a19:Arbitrary[T19], a20:Arbitrary[T20], a21:Arbitrary[T21], a22:Arbitrary[T22], z: Cogen[Z]): Cogen[Function22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22, Z]] =
    Cogen { (seed: Seed, f: Function22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22, Z]) =>
      val r1 = arbitrary[T1].doPureApply(params, seed)
      val r2 = arbitrary[T2].doPureApply(params, r1.seed)
      val r3 = arbitrary[T3].doPureApply(params, r2.seed)
      val r4 = arbitrary[T4].doPureApply(params, r3.seed)
      val r5 = arbitrary[T5].doPureApply(params, r4.seed)
      val r6 = arbitrary[T6].doPureApply(params, r5.seed)
      val r7 = arbitrary[T7].doPureApply(params, r6.seed)
      val r8 = arbitrary[T8].doPureApply(params, r7.seed)
      val r9 = arbitrary[T9].doPureApply(params, r8.seed)
      val r10 = arbitrary[T10].doPureApply(params, r9.seed)
      val r11 = arbitrary[T11].doPureApply(params, r10.seed)
      val r12 = arbitrary[T12].doPureApply(params, r11.seed)
      val r13 = arbitrary[T13].doPureApply(params, r12.seed)
      val r14 = arbitrary[T14].doPureApply(params, r13.seed)
      val r15 = arbitrary[T15].doPureApply(params, r14.seed)
      val r16 = arbitrary[T16].doPureApply(params, r15.seed)
      val r17 = arbitrary[T17].doPureApply(params, r16.seed)
      val r18 = arbitrary[T18].doPureApply(params, r17.seed)
      val r19 = arbitrary[T19].doPureApply(params, r18.seed)
      val r20 = arbitrary[T20].doPureApply(params, r19.seed)
      val r21 = arbitrary[T21].doPureApply(params, r20.seed)
      val r22 = arbitrary[T22].doPureApply(params, r21.seed)

      Cogen[Z].perturb(seed, f(r1.retrieve.get, r2.retrieve.get, r3.retrieve.get, r4.retrieve.get, r5.retrieve.get, r6.retrieve.get, r7.retrieve.get, r8.retrieve.get, r9.retrieve.get, r10.retrieve.get, r11.retrieve.get, r12.retrieve.get, r13.retrieve.get, r14.retrieve.get, r15.retrieve.get, r16.retrieve.get, r17.retrieve.get, r18.retrieve.get, r19.retrieve.get, r20.retrieve.get, r21.retrieve.get, r22.retrieve.get))
    }


}
