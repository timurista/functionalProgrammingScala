
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

A recursive approach with scala. Here you have to declare the return type to break the cycle of analysis of the return value of the right hand method.

```javascript
def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(imrpove(guess, x), x)
    ...
```

To deal with isGoodEnough recursively, we would see if the difference between guess^2 and x is less than a smalle number, while improve would simply return the guess + x then divide by the guess and find the average (divide by 2).

Here's the full scala iplementation:

```javascript
object session {
  def abs(x: Double) = if (x < 0) -x else x;

  def sqrtIter(guess: Double, x: Double): Double =
    if(isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.001

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def sqrt(x: Double) = sqrtIter(1.0, x)

  // testing
  sqrt(2)
  sqrt(4)
}
```

## How to improve? 
The isGoodEnough test is not very precise for small number and can lead to infinite loop for very large numbers. This is because the size of x compared to the value of 0.001 could be much smaller even if you subtract out the guess. This would lead to an incorrect return value. Alternatively, the value of x could be so large that the computation runs into a memory overflow issue.

So you need to make the abs value relative to x. You can do this by simply dividing the absolute value by x: 
```javascript
def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) / x < 0.001
```

## Blocks and Lexical Scoping
You can nest functions in order to not pollute the name space. You can do this with a block of code. Javascript does it like this:
```javascript
function myFunc() {
  function subFunc() {
    ...
  }
  ...
}
```

And in scala
```scala
def myFunc(guess: Double) {
  def subFunc(guess: Double) {
    ...
  }
  ...
}
```
