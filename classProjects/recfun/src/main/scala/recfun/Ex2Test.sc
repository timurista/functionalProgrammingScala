object Main {
  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def findBalance(chars: List[Char], numOpens: Int): Boolean = {
      if (chars.isEmpty) return numOpens == 0
      val n =
        if (chars.head == '(') numOpens + 1
        else if (chars.head == ')') numOpens - 1
        else numOpens

      if (n >= 0) findBalance(chars.tail, n)
      else return false
    }

    findBalance(chars, 0)
  }
  balance("())(".toList)
  balance(":-)".toList)
//  balance("(if (zero? x) max (/ 1 x))".toList)
//  balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList)

}