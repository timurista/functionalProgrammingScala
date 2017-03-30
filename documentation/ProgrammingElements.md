
# Elements of Programming

## Calculator

functional programming is but like a calculator with a terminal and console. You can combine expressions.

To open REPL for running scala, make sure you have sbt installed (`brew install sbt`) then you can run `sbt console`.

## Call by value vs call by name

**call-by-function** evaluates every function argument once while **call-by-name** is not evaluated if parameter is unused in the body.

```javascript
def text(x: Int, y: Int) = x * x;
    test(2,3) // same complexity in terms of reduction time
    tet(3+4, 8) // call by name takes 1 more step (3+4) * (3+4), so call by value is faster test(7,8) -> 7*7
    test(7, 2*4) // 2*4 is never used so call by name is faster no need to evaluate second argumnet
    test(3+4, 2*4) // same complexity
```




