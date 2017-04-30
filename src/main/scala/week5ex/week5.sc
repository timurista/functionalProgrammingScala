import math.Ordering

object mergesort {
  def msort[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case(xs, Nil) => xs
        case(x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)

      }

    val (fst, snd) = xs splitAt n
    merge(msort(fst)(lt), msort(snd)(lt))
    }

    // how can we make merge sort generaalizable?
    // apply generic T, and then pass less than function

  }

  def msortordering[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case(xs, Nil) => xs
        case(x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)

      }

      val (fst, snd) = xs splitAt n
      merge(msortordering(fst), msortordering(snd))
    }

    // how can we make merge sort generaalizable?
    // apply generic T, and then pass less than function

  }

  val nums = List(2, -4, 5, 7, 1)
  msort(nums)((x: Int, y:Int) => x < y)

  // now we can do fruits
  val fruits = List("apple", "pinneable", "orange", "mango", "bannana")
  msort(fruits)((x, y) => x.compareTo(y) < 0) // -1 for ascending when x < y

  // we could also use oredering of T
  msortordering(nums)(Ordering.Int)
  msortordering(fruits)(Ordering.String)

  // but we can make ord an implicit parameter
  msortordering(nums)
  msortordering(fruits)

  // implicit parameter
  /*
   * If you use implicit, you can have scala
   * figure out which method to use
   * for ordering based on inference of the two types you pass in
   * Search for defition with a type compatible of t, and is visible at function call
   * 
   */
}
