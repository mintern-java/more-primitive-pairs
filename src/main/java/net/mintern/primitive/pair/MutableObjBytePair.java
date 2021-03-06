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

import org.apache.commons.lang3.tuple.MutablePair;

/**
 * A mutable pair consisting of an {@code Object} element and a {@code byte} element, providing a
 * version of {@link MutablePair} that avoids unnecessary {@code Byte} boxing.
 * <p>
 * Not #ThreadSafe#
 *
 * @param <L> the left element type
 * @author Brandon Mintern
 */
public class MutableObjBytePair<L> extends ObjBytePair<L> {

    private static final long serialVersionUID = 1;

    public L left;
    public byte right;

    /**
     * Obtains a mutable pair of the given {@code Object} and {@code byte} values.
     *
     * @param <L> the left element type
     * @param left  the left element, may be null
     * @param right  the right element
     * @return a pair formed from the two parameters, not null
     */
    public static <L> MutableObjBytePair<L> of(L left, byte right) {
        return new MutableObjBytePair<>(left, right);
    }

    /**
     * Creates a new pair instance of {@code (null, 0L)}.
     */
    public MutableObjBytePair(){}

    /**
     * Creates a new pair instance.
     *
     * @param left  the left value, may be null
     * @param right  the right value
     */
    public MutableObjBytePair(L left, byte right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public L getLeft() {
        return left;
    }

    /**
     * Sets the left element of the pair.
     *
     * @param left  the new value of the left element, may be null
     */
    public void setLeft(L left) {
        this.left = left;
    }

    @Override
    public byte getRight() {
        return right;
    }

    /**
     * Sets the right element of the pair.
     *
     * @param right  the new value of the right element
     */
    public void setRight(byte right) {
        this.right = right;
    }

    @Override
    public MutablePair<L, Byte> boxed() {
        return new MutablePair<>(left, right);
    }
}
