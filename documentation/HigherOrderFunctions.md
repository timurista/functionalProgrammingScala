
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

