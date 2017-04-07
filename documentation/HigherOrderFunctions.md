
# Higher Order Functions

## Functions are first class values
In scala, functions can be passed as a parameter or returned as a result. These kinds of functions which take functions and return functions are called *higher order functions*.

## Example:
```scala
def sumInts(a: Int, b:Int): Int = 
    if (a >b) 0 else a + sumInts(a + 1, b)
```
You can abstract the common fuction which operates on a into a function. So you might get 
```scala
def sumFactorial(a: int, b: Int): Int = 
    if (a > b ) 0 else fact(a) + sumFactorials(a +1, b)
```


But you see the common pattern? Can we factor this out.

![repeated sum](https://latex.codecogs.com/gif.latex?\sum&space;f(x))

## We can try to generalize this formula
```scala
def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a+1, b)
```

So now we can write our sums like this
```scala
def sumInts(a: Int, b: Int) = sum(id, a, b)
def sumCubes(a: Int, b:Int) = sum(cube, a, b)
def sumFactorials(a: Int, b:Int) = sum(fact, a, b)

def id(x: Int): Int = x
def cube(x: Int): Int = x*x*x
def fact(x: Int): Int = if(x==0) 1 else fact(x-1)
```

## Function Type
A => B, takes argument of type A and returns result of type B.

### Problem: Now we have a number of tedius smaller functions
Anonymous functions can replace our functions and make this easier to read. `(x: Int) => x*x*x`

*Note* type of parameter can be ommitted if it can be inferred.

## Syntatic Sugar
Anonymous function (x1: T1... xn) can always be expressed like def f(x1: T1...) = E;f. Because they can always be rewritten using larger function body, then it is just **syntactic sugar**.

```scala
def sumInts(a: Int, b:Int) = sum(x => x, a, b)
def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
```

## Tail Recursive Sum
```scala
def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a+1, f(a) + acc)
  }
  loop(a, 0)
}
```
1. loop with a as starting value
2. then 0 as value of accumulator
3. then if a > terminating value, return accumulator
4. else run loop, incremeting a and adding the result of f(a) to the accumualtor

## Currying
Above, each function takes two params. But can't we rewrite them to make even shorter?

```scala
def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int=
        if (a>b) 0
        else f(a) + sumF(a +1, b)
    sumF
}
```

so it defines sumF, then returns it from sum. Therefore sum is a function which returns another function. 

### Avoiding middle man
sum(cube) (1, 10)

This applies sum function to the cube function. Sum cube is therefore the same as sumCubes, then we apply to arguments (1, 10). Why do this? You can now have 2 parameters sum(cube)(1,10) and the second parameter (1,10) can be deferred to use later. Another example of syntactic sugar.

### Currying syntax
`def f(arg1)...f(argsn-1)(argsn) = E`
is the same as
`def f = (args => (args2 =>... (argsn => E)))`

1. Write product?
```scala
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  product(x => x)(3, 7);

  def fact(a: Int): Int =
    product(x => x)(1, a)

  fact(3)
  fact(5)
```

But can we replace the product in terms of another more general function? Yes...
```scala
  // we want map reduce
  def mapReduce(f: Int => Int,
                combine: (Int, Int) => Int,
                zero: Int)(a: Int, b:Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1,b))

  def product2(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x,y) => x*y, 1)(a, b)

  product2(x => x*x)(3, 4) // 144
}
```

## Practical Application, SQRT

Now we can define sqrt with functional composition:
```scala
  val tolerance = 0.0001
  def isCloseEnough(x: Double, y:Double) =
    abs((x-y) / x) < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }
  def sqrt(x: Double) =
    fixedPoint(y => (y + x / y) / 2)(1)

  sqrt(2) // 1.4142...
```

## Categories of Expressions
An identifier such as x, isGoodEnough. A literal, function applciation, etc.
