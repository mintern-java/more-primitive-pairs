/*
 * Derived from code that was licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with Apache Commons Lang 3 for
 * additional information regarding copyright ownership.
 *
 * Brandon Mintern and the ASF license this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.  You may obtain a
 * copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package net.mintern.primitive.pair;

import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 * An immutable pair consisting of an {@code char} element and a {@code int} element, providing a
 * version of {@link ImmutablePair} that avoids unnecessary {@code Character} and {@code Integer}
 * boxing.
 * <p>
 * The class is {@code final}, so a subclass cannot add undesirable behavior.
 * <p>
 * #ThreadSafe#
 *
 * @author Brandon Mintern
 */
public final class ImmutableCharIntPair extends CharIntPair {

    private static final long serialVersionUID = 1;

    /**
     * Obtains an immutable pair of the given {@code char} and {@code int} values.
     *
     * @param left  the left element
     * @param right  the right element
     * @return a pair formed from the two parameters, not null
     */
    public static ImmutableCharIntPair of(char left, int right) {
        return new ImmutableCharIntPair(left, right);
    }

    public final char left;
    public final int right;

    /**
     * Create a new pair instance.
     *
     * @param left  the left value
     * @param right  the right value
     */
    public ImmutableCharIntPair(char left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public char getLeft() {
        return left;
    }

    @Override
    public int getRight() {
        return right;
    }

    @Override
    public ImmutablePair<Character, Integer> boxed() {
        return new ImmutablePair<>(left, right);
    }
}
