object main {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.add(y)
  x.neg
  x.sub(y).sub(y)
  y.add(y)
  x.less(y)
  x.max(y)

  x add y //infix works too
//  val strange = new Rational(1, 0)
//  strange.add(strange)
  new Rational(2)

  new Rational(1, 2).num



  class Rational(x: Int, y: Int) {
    require( y != 0, "denominator must be nonzero")

    // this is class constructor
    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a% b)
    private val g = gcd(x, y)

    // always simplify as early as possible to avoid
    // overflows
    val num = x / g
    val denom = y / g

//    Public methods
    def less(that: Rational) =
      num * that.denom < that.num * denom

    def max(that: Rational) =
      if(this.less(that)) that else this

    def neg: Rational = new Rational(-num, denom)

    def add(that: Rational) =
      new Rational(
        num * that.denom + that.num * denom,
        denom * that.denom
      )

    def sub(that: Rational) =
      add(that.neg)

    override def toString() = this.num + "/" + this.denom

  }
}