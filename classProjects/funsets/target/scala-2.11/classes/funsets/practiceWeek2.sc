object main {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x + y
  -x
  x - y - y
  y + y
  x < y
  x > y

  x + y //infix works too
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
    def < (that: Rational) =
      num * that.denom < that.num * denom

    def > (that: Rational) =
      if(this < that) that else this

    def unary_- : Rational = new Rational(-num, denom)

    def + (that: Rational) =
      new Rational(
        num * that.denom + that.num * denom,
        denom * that.denom
      )

    def - (that: Rational) =
      this + -that

    override def toString() = this.num + "/" + this.denom

  }
}