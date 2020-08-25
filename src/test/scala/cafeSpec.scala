import org.scalatest.flatspec.AnyFlatSpec

class cafeSpec extends AnyFlatSpec {

  "total bill" should
    "be £1.50" in {
        assert(main.totalBill(List("cola", "coffee")) == 1.50)
      }
    it should "be £3.30" in {
      assert(main.totalBill(List("cola", "cheese Sandwich", "cola")) == 3.30)
    }
    it should "be £6.60" in {
      assert(main.totalBill(List("coffee", "steak Sandwich")) == 6.60)
  }
    it should "be £137.00" in {
      assert(main.totalBill(List(
        "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich",
        "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich",
        "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich", "steak Sandwich")) == 137.00)
    }
}
