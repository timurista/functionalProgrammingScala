# Other types

## Vectors
in chunks of 32, access grows log32(n)
more evenly access size

why keep lists?
constant time operation if you need to access first elements

Vectors
+:  element to right
:+  trailing element

complexity is log32(n)... so object creation
    [ Sequence ]
    /          \
[ List ]       [ Vectors ]

Sequence, Set, Map
Base class is Iterable

Arrays and Strings look like Sequence