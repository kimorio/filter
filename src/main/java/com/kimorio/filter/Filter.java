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

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * A filter is something that can respond with either "yes", "no", or "don't care" to a question.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface Filter {
  /**
   * Query this filter for a response.
   *
   * @param query the query
   * @return the response
   * @since 1.0.0
   */
  @NotNull FilterResponse query(final @NotNull FilterQuery query);

  /**
   * Query this filter for a response.
   *
   * @param query the query
   * @return the response
   * @since 1.0.0
   */
  @ApiStatus.NonExtendable
  default @NotNull FilterResponse query(final @NotNull FilterQueryLike query) {
    return this.query(query.asFilterQuery());
  }

  /**
   * Query this filter and return {@code true} if the response is {@link FilterResponse#ALLOW}, and {@code false} otherwise.
   *
   * @param query the query
   * @return {@code true} if allowed, {@code false} otherwise
   * @since 1.0.0
   */
  @ApiStatus.NonExtendable
  default boolean allows(final @NotNull FilterQueryLike query) {
    return this.query(query) == FilterResponse.ALLOW;
  }

  /**
   * Query this filter and return {@code true} if the response is {@link FilterResponse#ABSTAIN}, and {@code false} otherwise.
   *
   * @param query the query
   * @return {@code true} if abstained, {@code false} otherwise
   * @since 1.0.0
   */
  @ApiStatus.NonExtendable
  default boolean abstains(final @NotNull FilterQueryLike query) {
    return this.query(query) == FilterResponse.ABSTAIN;
  }

  /**
   * Query this filter and return {@code true} if the response is {@link FilterResponse#DENY}, and {@code false} otherwise.
   *
   * @param query the query
   * @return {@code true} if denied, {@code false} otherwise
   * @since 1.0.0
   */
  @ApiStatus.NonExtendable
  default boolean denies(final @NotNull FilterQueryLike query) {
    return this.query(query) == FilterResponse.DENY;
  }
}
