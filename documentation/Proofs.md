# Proofs and Correctness for Functional Progamming


## Concatenation on lists?
What does it mean in this case to say a program is "correct."
recall that concatenation looks like this:

```scala
(xs ++ ys) ++ zs = xs ++ (ys ++ zs)
    xs ++ Nil = xs
    Nil ++ xs = xs
```

Proof principle

## Natural Induction
To show a property P(n) for all integers n >= b
- show we have P(b) (base case)
- for all integers n >= b show inductive step:
    if one has P(n) then one also has P(n +1)

example
Given:
```scala
def factorial(n: Int): Int =
    if (n == 0) 1
    else n * factorial(n - 1)
```

Show that for all n>= 4
factorial(n) >= power(2, n)

```
base case: n=4, factorial(n) => 4 * 3 * 2 * 1 * 1 = 24
power(2, 4) => 2 ** 4 => 16
so 24 >= 16 // base case holds
```
inductive step
```
facotrial(n +1) >= (n+1) * factorial(n)
> 2 * factorial(n) // by calculating
>= 2 * power(2, n) // by inductive hypothesis
= power(2, n + 1) // by definition of power
```

Above we have applied reducton steps as equalities to some part of a term. This works because there are no side effects for a functional program; a term is equivalent to the term to which it reduces. This principle is called **referntial transparency**

## Structural Induction

Principle is analogous to natrual induction:
to prove a property P(xs) for all lists xs

- show P(Nil) holds // base
- for a list xs and some element x, show the induction step
    if P(xs) holds, then P(x :: xs) also holds

```scala
    def concat[T](xs: List[T], ys: List[T]) = xs match {
        case List() => ys
        case x :: xs1 => x :: concat(xs1, ys)
    }

    Nil ++ ys = ys // case 1
    (xs :: xs1) ++ ys = x :: (xs1 ++ ys) // case 2
```

base case nil
(Nil ++ ys) ++ zs // by clause 2
= ys ++ zs
Nil ++ (ys ++ zs) // by clause 1
= ys ++ zs


Induction step: x :: xs
((x :: xs) ++ ys) ++ zs
= (x :: (xs ++ ys)) ++ zs // second case
= x :: ((xs ++ ys) ++ zs) // second case
= x :: (xs ++ (ys ++ zs)) // by inductive hypothesis
= x :: ( (x:: xs) ++ (ys ++ zs) ) // second clause


prove xs ++ Nil = xs

Base case : xs = Nil
Nil ++ Nil
= Nil // by first clause

induction step, x::xs
(x :: xs ) ++ Nil = x :: xs
= x :: (xs ++ Nil) // base case
= x :: xs // by inductive hypothesis


## Larger Proofs - Law of Reverse
Nil.reverse = Nil // 1st clause
(x :: xs).reverse = xs.reverse ++ List(x) // second clause

We'd like to prove the following:
xs.reverse.reverse = xs

### Base case
Nil.reverse.reverse
=   Nil.reverse // by 1
=   Nil // by 1
### Inductive step
(x :: xs).reverse.reverse
=   (xs.reverse ++ List(x)).reverse // by 2

// nothing else we can do seems obvious, so let's look at right hand side

x :: xs = x :: xs.reverse.reverse // by inductive hypothesis

(xs.reverse ++ List(x)).reverse = x :: xs.reverse.reverse

// induction doesn't work, we need to generalize the equation
(ys ++ List(x)).reverse = x :: ys.reverse
// where ys = x.reverse

Base case
ys = Nil
(Nil ++ List(x)).reverse
= List(x).reverse // 1
= (x :: Nil).reverse // definition of List
    = Nil reverse ++ List(x)
= Nil ++ (x :: Nil)
= x :: Nil
= x :: Nil.reverse

So Now we need to show
((y :: yx) ++ List(x)).reverse // to show = x :: y(y :: ys).reverse
= (y :: (ys ++ List(x))).reverse // by 2 of ++, using unfold step
= (ys ++ List(x)).reverse ++ List(y) // by 2 of reserve
= (x :: ys.reverse) ++ List(y) // by inductive step
= x :: (y :: ys).reverse // by 2 of reverse fold step

this proof method is sometimes called fold/unfold method



