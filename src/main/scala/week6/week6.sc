//package week6
import scala.Range

object test {

  val xs = Array(1, 2, 3, 44)
  xs map (_ * 2)

  val s = "Hello World"
  s filter (_.isUpper)

  // other sequences

  // Range
  val r: Range = 1 until 5 by 2
  val d: Range = 1 to 5 by 3
  r map (_*2)

  // More operations
  xs exists (_>1)
  s exists (_.isUpper)
  s forall (_.isUpper)

  val pairs = List(1, 2, 3) zip s
  pairs.unzip

  s flatMap (List('.', _))

  xs.sum
  xs.max

  // list all combination of numbers x, y
  // (1 to M) flatMap (x => (1 to N) map (y => (x,y))
  def scalarProd(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum

  def scalarProd2(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{ case(x, y) => x * y}.sum


  def isPrime(n: Int): Boolean =
    (2 until n) forall (n % _ != 0)

  isPrime(7)
}