object main {

  println("worksheet")
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

