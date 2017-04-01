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
    def pascal(c: Int, r: Int): Int =
      if (c == 0 || c == r) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)

  
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
  def countChange(money: Int, coins: List[Int]): Int = {
    // if money < 0, (we have subtracted too much)
    // or we don't have any more coins, return 0 ways
    if (money < 0 || coins.isEmpty) return 0

    // there is only 1 way if there is 0 money
    else if (money == 0) return 1

    // We will subtract the first coin in our list from the money
    // then we will see if we can keep doing that with the first coin
    // until we get down to 0 exactly
    // if we subtract too much, then this "path" isn't valid
    val allWaysWithFirstCoin = countChange(money - coins.head, coins)

    // then we will do the same thing and find the ways for the other
    // coins in the list to bring down money to a value of exactly 0
    // which means we have spent all the coins perfectly
    val allWaysWithOtherCoins = countChange(money, coins.tail)

    return allWaysWithFirstCoin + allWaysWithOtherCoins
  }

}
