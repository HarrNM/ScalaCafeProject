object main extends App {

  val cola = MenuItem(false, false, 0.50)
  val coffee = MenuItem(false, true, 1.00)
  val cheeseSandwich = MenuItem(true, false, 2.00)
  val steakSandwich = MenuItem(true, true, 4.50)

  val menuItems = Map(
    "cola" -> cola,
    "coffee" -> coffee,
    "cheese Sandwich" -> cheeseSandwich,
    "steak Sandwich" -> steakSandwich
  )

  def formatInput(input: String): Seq[String] = {
    val formatted = input.split(",").map(_.trim).toSeq
    formatted
  }

  def inputItems(): Seq[String] = {
    println("What do you want to order?")
    val input = scala.io.StdIn.readLine()
    formatInput(input)
  }

  def serviceCharge(items: Seq[MenuItem]): Double = {
    if (items.exists(menuItems => menuItems.isHot) && items.exists(menuItems => menuItems.isFood)) {
      val serviceCost = itemsCost(items) * 0.2
      if (serviceCost >= 20) {
        val maxServiceCost = 20
        maxServiceCost
      }
      else {
        serviceCost
      }
    }
    else if (items.exists(menuItems => menuItems.isFood)) {
      val serviceCost = itemsCost(items) * 0.1
      serviceCost
    }
    else {
      val serviceCost = 0
      serviceCost
    }
  }

  def itemsCost(items: Seq[MenuItem]): Double = {
    val total = items.map(menuItems => menuItems.price).sum
    total
  }

  def totalBill(items: Seq[MenuItem]): Double = {
    val bill = itemsCost(items) + serviceCharge(items)
    bill
  }

}
