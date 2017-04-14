package wk3

/**
  * Created by tim.urista on 4/13/17.
  */
class Rational(n: Int, d: Int) {
  require(d != 0, "denominator must be nonzero")

  private val g = gcd(n.abs, d.abs)
  val number = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1) // auxiliary constructor

  def + (that: Rational): Rational =
    new Rational(
      number * that.denom + that.number * denom,
      denom * that.denom
    )

  def + (i: Int): Rational =
    new Rational(number + i * denom, denom)

  def - (that: Rational): Rational =
    new Rational(
      number * that.denom - that.number * denom,
      denom * that.denom
    )

  def - (i: Int): Rational =
    new Rational(number - i * denom, denom)

  def * (that: Rational): Rational =
    new Rational(number * that.number, denom * that.denom)

  def * (i: Int): Rational =
    new Rational(number * i, denom)

  def / (that: Rational): Rational =
    new Rational(number * that.denom, denom * that.number)

  def / (i: Int): Rational =
    new Rational(number, denom * i)

  override def toString = number + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}