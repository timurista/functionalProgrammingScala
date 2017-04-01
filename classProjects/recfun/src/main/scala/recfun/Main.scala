package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) return 1
      else return pascal(c - 1, r - 1) + pascal(c, r - 1)
    }


  def isClosed(chars: List[Char]): Boolean = chars.contains(")")

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

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
