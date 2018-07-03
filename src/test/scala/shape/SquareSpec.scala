package shape

import org.scalatest.{MustMatchers, WordSpec}

class SquareSpec extends  WordSpec with MustMatchers{
  "Square" should {

    "calculate its perimeter" in {
      val square = Square(side = 2)

      val perimeter = square.perimeter

      perimeter mustBe 8
    }

    "calculate its area" in {
      val square = Square(side = 5)

      val area = square.area

      area mustBe 25
    }

    "not have negative side" in {
      val exception = intercept[IllegalArgumentException] {
        Square(side = -12)
      }

      exception.getMessage mustBe "Side of a square has to be greater than zero"
    }
  }
}
