# Scala as pure object

## Pure Object Orientation
* Every value is an object
* Each type of value is a class

Standard classes like Int or Boolean are optimized, but they can be thought of as normal objects.

functions are objects
Function A => B
abv
Function[A, B]

```scala
trait Function[A, B] {
    def apply(x: A): B
}
```