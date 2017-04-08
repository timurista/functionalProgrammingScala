object main {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.add(y)
  x.neg
  x.sub(y).sub(y)
  y.add(y)

  class Rational(x: Int, y: Int) {
    private def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a% b)
    private val g = gcd(x, y)

    def num = x / g
    def denom = y / g

    def neg: Rational = new Rational(-num, denom)
    def add(that: Rational) =
      new Rational(
        num * that.denom + that.num * denom,
        denom * that.denom
      )

    def sub(that: Rational) =
      add(that.neg)

    // simplification


    override def toString() = this.num + "/" + this.denom

  }
}