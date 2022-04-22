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

import org.jetbrains.annotations.NotNull;

record ConstantFilterImpl(@NotNull FilterResponse response) implements ConstantFilter {
  static final ConstantFilterImpl ALLOW = new ConstantFilterImpl(FilterResponse.ALLOW);
  static final ConstantFilterImpl ABSTAIN = new ConstantFilterImpl(FilterResponse.ABSTAIN);
  static final ConstantFilterImpl DENY = new ConstantFilterImpl(FilterResponse.DENY);

  @Override
  public @NotNull FilterResponse query(final @NotNull FilterQuery query) {
    return this.response;
  }
}
