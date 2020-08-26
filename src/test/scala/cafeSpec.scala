import org.scalatest.flatspec.AnyFlatSpec

class cafeSpec extends AnyFlatSpec {

  val cola = MenuItem(false, false, 0.50)
  val coffee = MenuItem(false, true, 1.00)
  val cheeseSandwich = MenuItem(true, false, 2.00)
  val steakSandwich = MenuItem(true, true, 4.50)

  "total bill" should
    "be £1.50" in {
        assert(main.totalBill(List(cola, coffee)) == 1.50)
      }
    it should "be £3.30" in {
      assert(main.totalBill(List(cola, cheeseSandwich, cola)) == 3.30)
    }
    it should "be £6.60" in {
      assert(main.totalBill(List(coffee, steakSandwich)) == 6.60)
  }
    it should "be £137.00" in {
      assert(main.totalBill(List(
        steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich,
        steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich,
        steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich, steakSandwich)) == 137.00)
    }
}
