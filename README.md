## Java More Primitive Pairs

Provides pair classes with the same interface as the [Apache Commons Pair
classes](https://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/tuple/package-summary.html),
but with versions specialized to `boolean`, `byte`, `char`, and `float`,
allowing users to avoid the cost of working with boxed types. This library
supplements my [Java Primitive Pairs](http://mintern.net/primitive-pairs)
library, adding to its `double`, `int`, and `long` pair classes.

To include the library in your project (Java 7+ supported), add the following
to your POM:

```xml
<project>
...
    <dependencies>
        ...
        <dependency>
            <groupId>net.mintern</groupId>
            <artifactId>more-primitive-pairs</artifactId>
            <version>1.0</version>
        </dependency>
        ...
    </dependencies>
...
</project>
```

### Sample usage

```java
List<CharIntPair> enumerated = new ArrayList<>();
int i = 0;
for (char c: myString.toCharArray()) {
    enumerated.add(CharIntPair.of(c, i++));
}
```

### Pair types

As with the Apache Commons Pair, each pair type is comprised of a base
`FooPair`, an `ImmutableFooPair`, and a `MutableFooPair`. The supported
combinations are:

- `ObjFloatPair`
- `ObjCharPair`
- `ObjBytePair`
- `ObjBooleanPair`
- `DoubleFloatPair`
- `DoubleCharPair`
- `DoubleBytePair`
- `DoubleBooleanPair`
- `LongFloatPair`
- `LongCharPair`
- `LongBytePair`
- `LongBooleanPair`
- `IntFloatPair`
- `IntCharPair`
- `IntBytePair`
- `IntBooleanPair`
- `FloatLongPair`
- `FloatIntPair`
- `FloatPair` (two `float`s)
- `FloatCharPair`
- `FloatBytePair`
- `FloatBooleanPair`
- `CharLongPair`
- `CharIntPair`
- `CharPair` (two `char`s)
- `CharBytePair`
- `CharBooleanPair`
- `ByteLongPair`
- `ByteIntPair`
- `BytePair` (two `byte`s)
- `ByteBooleanPair`
- `BooleanLongPair`
- `BooleanIntPair`
- `BooleanPair` (two `boolean`s)

In concert with [primitive-pairs](http://mintern.net/primitive-pairs), this
library provides all possible combinations for these 8 types. If you order the
types as `Object`, `Double`, `Long`, `Int`, `Float`, `Char`, `Byte`,
`Boolean`, then the widest type comes first.

The `*IntPair`s and `*LongPair`s are the only exceptions to this pattern.
Because of the shape of classes like `ObjIntPair` and `ObjLongPair`, a pair
that consists of a value and its corresponding index would typically have the
index second. By providing pairs with `int` and `long` as the second item, the
`(value, index)` pattern can be used consistently for all types.

### Contributing

I will happily accept Pull Requests. If you have any questions, ask away.
Please keep changes to a minimum; do not make gratuitous style changes.

#### Building

In the root directory, run `mvn install`. That will build everything.

### Related projects

All of my Java libraries are available in the
[mintern-java](https://github.com/mintern-java) organization.
