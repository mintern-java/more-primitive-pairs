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
 * A mutable pair consisting of {@code byte} elements, providing a version of {@link MutablePair}
 * that avoids unnecessary {@code Byte} boxing.
 * <p>
 * Not #ThreadSafe#
 *
 * @author Brandon Mintern
 */
public class MutableBytePair extends BytePair {

    private static final long serialVersionUID = 1;

    public byte left;
    public byte right;

    /**
     * Obtains a mutable pair of the given {@code byte} values.
     *
     * @param left  the left element
     * @param right  the right element
     * @return a pair formed from the two parameters, not null
     */
    public static MutableBytePair of(byte left, byte right) {
        return new MutableBytePair(left, right);
    }

    /**
     * Creates a new pair instance of {@code (0.0, 0L)}.
     */
    public MutableBytePair(){}

    /**
     * Creates a new pair instance.
     *
     * @param left  the left value
     * @param right  the right value
     */
    public MutableBytePair(byte left, byte right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public byte getLeft() {
        return left;
    }

    /**
     * Sets the left element of the pair.
     *
     * @param left  the new value of the left element
     */
    public void setLeft(byte left) {
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
    public MutablePair<Byte, Byte> boxed() {
        return new MutablePair<>(left, right);
    }
}
