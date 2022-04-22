/*
 * This file is part of filter, licensed under the MIT License.
 *
 * Copyright (c) 2021-2022 Kimorio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.kimorio.filter;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConstantFilterTest {
  private static final int REPETITIONS = 100;

  @RepeatedTest(REPETITIONS)
  void testQueryAllowsEverything() {
    record Query() implements FilterQuery {
    }
    assertTrue(Filters.allow().allows(new Query()));
  }

  @RepeatedTest(REPETITIONS)
  void testQueryAbstainsEverything() {
    record Query() implements FilterQuery {
    }
    assertTrue(Filters.abstain().abstains(new Query()));
  }

  @RepeatedTest(REPETITIONS)
  void testQueryDeniesEverything() {
    record Query() implements FilterQuery {
    }
    assertTrue(Filters.deny().denies(new Query()));
  }

  @Test
  void testResponse() {
    assertEquals(FilterResponse.ALLOW, Filters.allow().response());
    assertEquals(FilterResponse.ABSTAIN, Filters.abstain().response());
    assertEquals(FilterResponse.DENY, Filters.deny().response());
  }

  @Test
  void testEquality() {
    new EqualsTester()
      .addEqualityGroup(
        Filters.allow(),
        Filters.always(FilterResponse.ALLOW)
      )
      .addEqualityGroup(
        Filters.abstain(),
        Filters.always(FilterResponse.ABSTAIN)
      )
      .addEqualityGroup(
        Filters.deny(),
        Filters.always(FilterResponse.DENY)
      )
      .testEquals();
  }
}
