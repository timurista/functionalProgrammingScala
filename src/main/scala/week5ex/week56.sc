object main {

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y*y :: squareList(ys)
  }

  def squareListM(xs: List[Int]): List[Int] =
    xs map (x => x * x)

  def posElems(xs: List[Int]): List[Int] =
    xs filter (x => x > 0)

  val nums = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pinneable", "orange", "mango", "bannana")

  nums filter (x => x > 0)
  nums filterNot (x => x > 0)
  // 1 traversal
  nums partition (x => x > 0)

  // only longest prefix of list
  nums takeWhile (x => x > 0)

  // dropwhile
  nums dropWhile (x => x > 0)

  val data = List("a", "a", "a", "b", "b", "c")
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case (x :: xs1) =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))


  pack(data)
  encode(data)

}