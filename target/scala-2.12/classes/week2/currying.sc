object main {
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)

  sum((x:Int) => x)(0, 10)
  sum((x) => x*x*x)(1,3)

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  product(x => x)(3, 7);

  def fact(a: Int): Int =
    product(x => x)(1, a)

  fact(3)
  fact(5)

  def common(f: Int => Int)(g: Int => Int)(a: Int, b: Int, c: Int): Int =
    if (a > b) c else common(f)(g)(a + 1, b, c)

  // we want map reduce
  def mapReduce(f: Int => Int,
                combine: (Int, Int) => Int,
                zero: Int)(a: Int, b:Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1,b))

  def product2(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x,y) => x*y, 1)(a, b)
  //  def common(f: Int =>)
//  def fact(x => x)(1,2)

  product2(x => x*x)(3, 4)
}