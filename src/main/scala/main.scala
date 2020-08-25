object main extends App {

  val menu = Map[String, List[String]](
    "cola" -> List("cold", "0.50"),
    "coffee" -> List("hot", "1.00"),
    "cheese Sandwich" -> List("cold", "2.00"),
    "steak Sandwich" -> List("hot", "4.50")
  )

  def formatInput(input: String): List[String] = {
    val formatted = input.split(",").map(_.trim).toList
    formatted
  }

  def inputItems(): List[String] = {
    println("What do you want to order?")
    val input = scala.io.StdIn.readLine()
    formatInput(input)
  }

  def totalBill(items: List[String]): Double = {
    var total = 0.00
    if (!items.contains("cheese Sandwich") && !items.contains("steak Sandwich")) {
      total = itemsCost(items)
    }
    else {
      for (i <- 1 to items.length) {
        if (items(i - 1) == "steak Sandwich") {
          total = itemsCost(items)
          val serviceCharge = 0.2 * total
          if (serviceCharge >= 20) {
            total = (total + 20)
          }
          else {
            total = (total + serviceCharge)
          }
        }
        else {
          val foodBill = itemsCost(items)
          total = (foodBill + (0.1 * foodBill))
        }
      }
    }
    total
  }

  def itemsCost(items: List[String]): Double = {
    var total = 0.00
    for (i <- 1 to items.length) {
      items(i - 1) match {
        case "cola" => total += 0.50
        case "coffee" => total += 1.00
        case "cheese Sandwich" => total += 2.00
        case "steak Sandwich" => total += 4.50
        case _ => total += 0
      }
    }
    total
  }

  var billOne = totalBill(List("cola", "coffee", "cheeseSandwich"))
  println(billOne)
  totalBill(List("cola", "steak Sandwich"))
}
