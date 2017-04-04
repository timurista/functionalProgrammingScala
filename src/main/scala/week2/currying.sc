object main {
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)

  sum((x:Int) => x)(0, 10)
  sum((x) => x*x*x)(1,3)
}