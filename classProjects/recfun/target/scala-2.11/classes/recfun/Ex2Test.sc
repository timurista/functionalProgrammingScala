object Main {
  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
//    println("CHARS> " + chars.mkString("") + " HAS PARENS " + chars.contains('('))

    def findBalance(chars: List[Char],
                    numParensOpen: Int): Boolean = {
        if (chars.isEmpty) return numParensOpen == 0
        val h = chars.head
        val num =
          if (h == '(') numParensOpen + 1
          else if (h == '(') numParensOpen - 1
          else numParensOpen
        if (num >= 0) findBalance(chars, num)
        else return false
    }

    findBalance(chars, 0);
  }


  balance("())(".toList)
  balance(":-)".toList)
//  balance("(if (zero? x) max (/ 1 x))".toList)
//  balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList)

}