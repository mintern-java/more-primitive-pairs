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

/**
 * A pair modeled after {@link org.apache.commons.lang3.tuple.Pair} that consists of a
 * {@code double} and a {@code byte} element that allows users to avoid {@code Double} and
 * {@code Byte} boxing. It refers to the elements as 'left' and 'right'.
 * <p>
 * Subclass implementations may be mutable or immutable.
 *
 * @author Brandon Mintern
 */
public abstract class DoubleBytePair implements PrimitivePair<Double, Byte>, Comparable<DoubleBytePair> {

    private static final long serialVersionUID = 1;

    /**
     * Obtains an immutable pair of the given {@code double} and {@code byte} values.
     *
     * @param left  the left element
     * @param right  the right element
     * @return a pair formed from the two parameters, not null
     */
    public static DoubleBytePair of(double left, byte right) {
        return ImmutableDoubleBytePair.of(left, right);
    }

    /**
     * Gets the left element from this pair.
     *
     * @return the left element
     */
    public abstract double getLeft();

    /**
     * Gets the right element from this pair.
     *
     * @return the right element
     */
    public abstract byte getRight();

    /**
     * Compares the pair based on the left element followed by the right element.
     *
     * @param other  the other pair, not null
     * @return negative if this is less, zero if equal, positive if greater
     */
    @Override
    public int compareTo(DoubleBytePair other) {
        int cmp = Double.compare(getLeft(), other.getLeft());
        return cmp != 0 ? cmp : Byte.compare(getRight(), other.getRight());
    }

    /**
     * Compares this pair to another based on the two elements.
     *
     * @param obj  the object to compare to, null returns false
     * @return true if the elements of the pair are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DoubleBytePair) {
            DoubleBytePair o = (DoubleBytePair) obj;
            return getLeft() == o.getLeft() && getRight() == o.getRight();
        }
        return false;
    }

    /**
     * Returns a hash code that follows the definition in {@link java.util.Map.Entry#hashCode()}.
     *
     * @return the hash code
     * @see Double#hashCode(double)
     * @see Byte#hashCode(byte)
     */
    @Override
    public int hashCode() {
        return Double.hashCode(getLeft()) ^ Byte.hashCode(getRight());
    }

    /**
     * Returns a String representation of this pair using the format {@code ($left,$right)}.
     *
     * @return a string describing this object, not null
     */
    @Override
    public String toString() {
        return "(" + getLeft() + "," + getRight() + ")";
    }
}
