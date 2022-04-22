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
package com.kimorio.filter.typed;

import com.kimorio.filter.FilterQuery;
import com.kimorio.filter.FilterResponse;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * A filter that <b>always</b> responds to queries of type {@code Q}.
 *
 * @param <Q> the query type
 * @since 1.0.0
 */
public interface StronglyTypedFilter<Q extends FilterQuery> extends TypedFilter<Q> {
  @Override
  default @NotNull FilterResponse typedQuery(final @NotNull Q query) {
    return FilterResponse.fromBoolean(this.queryResponse(query));
  }

  /**
   * Query this filter for a response.
   *
   * @param query the query
   * @return the response
   * @since 1.0.0
   */
  @ApiStatus.OverrideOnly
  boolean queryResponse(final @NotNull Q query);
}