object main {
  val x = new Rational(1, 2)
  x.num
  x.denom

  val y = new Rational(2,3)
  x.add(y)

  class Rational(x: Int, y: Int) {
    def num = x
    def denom = y

    def add(that: Rational) =
      new Rational(
        num * that.denom + that.num * denom,
        denom * that.denom)

    def neg(that: Rational) =
      new Rational(
        num * that.denom + that.num * denom,
        denom * that.denom)

    override def toString = num + "/" + denom
  }
}


