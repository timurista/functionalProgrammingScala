
# Elements of Programming

## Calculator

functional programming is but like a calculator with a terminal and console. You can combine expressions.

To open REPL for running scala, make sure you have sbt installed (`brew install sbt`) then you can run `sbt console`.

## Call by value vs call by name

**call-by-function** evaluates every function argument once while **call-by-name** is not evaluated if parameter is unused in the body.

```javascript
def text(x: Int, y: Int) = x * x;
    test(2,3) // same complexity in terms of reduction time
    test(3+4, 8) // call by name takes 1 more step (3+4) * (3+4), so call by value is faster test(7,8) -> 7*7
    test(7, 2*4) // 2*4 is never used so call by name is faster no need to evaluate second argumnet
    test(3+4, 2*4) // same complexity
```

## Scala uses call by value
In practice, call by value tends to be much faster for development purposes. This is mainly because call by name requires the repeated evaluation of expressions when evaluating the code. Also, unused variables are typically flagged as a problem by linters or compile-time errors, so the advantage saved by not evaluating them is usually not realized.

### Scala forcing call by name
You can force this behavior by using the arrow. `def constOne(x: Int, y: => Int) = 1`.

## Call By Value  / By Name in Assignments
Right hand side of a value definition aka an assignment is also called by-value. So `val x = 2; val y = square(x);` evaluates right here when y is initialized and assigned a value. But `def x = loop` will only assign by name, so that when you write x it will evaluate x at that time not in it's definition.

## Square Root using Newton's approximation

A recursive approach with scala. Here you have to declare the return type to break the cycle.

```javascript
def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(imrpove(guess, x), x)
    ...
```

