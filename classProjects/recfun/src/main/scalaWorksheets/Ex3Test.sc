object Ex3 {

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

  countChange(4,List(1,2))
}