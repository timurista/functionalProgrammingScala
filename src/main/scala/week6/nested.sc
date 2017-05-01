object main {
  def isPrime(n: Int): Boolean =
    (2 until n) forall (n % _ != 0)

  // make pairs of integers (i, j)
  // 1 <= j < i < n
  // filter where i + j is prime
  def pairs_notflapped(n: Int): IndexedSeq[IndexedSeq[(Int, Int)]] =
    (1 until n) map (i =>
      (2 until i) map (j => (i, j)))

  def pairs(n: Int): IndexedSeq[(Int, Int)] =
    (1 until n) flatMap (i =>
      (1 until i) map (j => (i, j)))

//  pairs(7)

  def primes(vector: IndexedSeq[(Int, Int)]): IndexedSeq[(Int, Int)] =
    vector filter (pair => isPrime(pair._1 + pair._2))

  pairs(7)
  primes(pairs(7))

  // For expressions
  // case class Person(name: String, age: Int)
  // for ( p <- persons if p.age > 20) yield p.name

  // for expression produces new result
  // for (s) yield e
  // generators and filters, p is pattern and e is expression


  def primeGen(n: Int) =
    for {
      i <- 1 until n
      j <- 1 until i
      if isPrime(i + j)
    }
      yield (i, j)

  primeGen(7)

  def scalarGen(xs: List[Double], ys: List[Double]): Double =
    (for {
      (x, y) <- xs zip ys
    }
      yield x * y).sum

  scalarGen(List(1,2,3), List(2,3,4))
}