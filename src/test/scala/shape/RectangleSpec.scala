package shape

import org.scalatest.{MustMatchers, WordSpec}

class RectangleSpec extends WordSpec with MustMatchers {
  "Rectangle" should {

    "calculate its perimeter" in {
      val rectangle = new Rectangle(base = 2, height = 3)

      val perimeter = rectangle.perimeter

      perimeter mustBe 10
    }

    "calculate its area" in {
      val rectangle = new Rectangle(base = 2, height = 5)

      val area = rectangle.area

      area mustBe 10
    }

    "not have negative base" in {
      val exception = intercept[IllegalArgumentException] {
        new Rectangle(base = -3, height = 4)
      }

      exception.getMessage mustBe "Base of a rectangle has to be greater than zero"
    }

    "not have negative height" in {
      val exception = intercept[IllegalArgumentException] {
        new Rectangle(base = 5, height = -1)
      }

      exception.getMessage mustBe "Height of a rectangle has to be greater than zero"
    }
  }
}
