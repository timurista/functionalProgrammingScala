object main {
  val t1 = new NonEmpty(3, Empty, Empty)
  val t2 = t1 incl 4
  val t3 = new NonEmpty(5, Empty, Empty)
  val t4 = t1 union t2
  val t5 = t1 union t3
  println("worksheet")

  // Implementing binary tree

  abstract class IntSet {
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean
    def union(other: IntSet): IntSet
  }

  // object says only ONE of them
  object Empty extends IntSet {
    def contains(x: Int): Boolean = false;
    def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
    def union(other: IntSet): IntSet = other
    override def toString = "."
  }

  class NonEmpty(
                  elem: Int,
                  left: IntSet,
                  right: IntSet
                ) extends IntSet {

    def contains(x: Int): Boolean =
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true

    def incl(x: Int): IntSet =
      if (x < elem) new NonEmpty(elem, left incl x, right)
      else if (x > elem) new NonEmpty(elem, left, right incl x)
      else this

    def union(other: IntSet): IntSet =
      // every set is smaller than the other
      // sets so we will reach empty
      ((left union right) union other) incl elem
    override def toString = "{" + left + elem + right + "}"
  }

}
