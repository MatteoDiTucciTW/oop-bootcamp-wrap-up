package measurement

import org.scalatest.{MustMatchers, WordSpec}

class MeasurementSpec extends WordSpec with MustMatchers{

  "Measurement" should {
    "compare feet with inches" in {
      val ft_1 = Measurement(quantity = 1, unit = Foot)
      val inch_12 = Measurement(quantity = 12, unit = Inch)

      ft_1 == inch_12 mustBe true
    }

    "compare feet with yards" in {
      val ft_3 = Measurement(quantity = 3, unit = Foot)
      val yard_1 = Measurement(quantity = 1, unit = Yard)

      ft_3 == yard_1 mustBe true
    }

    "compare inches with centimeters" in {
      val inch_2 = Measurement(quantity = 2, unit = Inch)
      val cm_5_08 = Measurement(quantity = 5.08, unit = Centimeter)

      inch_2 == cm_5_08 mustBe true
    }

    "add inches with inches" in {
      val inch_2 = Measurement(quantity = 2, unit = Inch)
      val inch_4 = Measurement(quantity = 4, unit = Inch)

      inch_2 + inch_2 mustBe inch_4
    }

    "add inches with centimeters" in {
      val inch_2 = Measurement(quantity = 2, unit = Inch)
      val cm_2_54 = Measurement(quantity = 2.54, unit = Centimeter)
      val inch_3 = Measurement(quantity = 3, unit = Inch)

      inch_2 + cm_2_54 mustBe inch_3
    }

    "compare gallons with liters" in {
      val gal_1 = Measurement(quantity = 1, unit = Gallon)
      val lt_3_79 = Measurement(quantity = 3.79, unit = Liter)

      gal_1 == lt_3_79 mustBe true
    }

    "add gallons with liters" in {
      val gal_1 = Measurement(quantity = 1, unit = Gallon)
      val lt_1 = Measurement(quantity = 1, unit = Liter)
      val lt_4_79 = Measurement(quantity = 4.79, unit = Liter)

      lt_1 + gal_1 mustBe lt_4_79
    }

    "compare Fahrenheit with Celsius" in {
      val f_212 = Measurement(quantity = 212, unit = Fahrenheit)
      val c_100 = Measurement(quantity = 100, unit = Celsius)

      f_212 == c_100 mustBe true
    }

      // show use of generic for compilation time check
//    "add liters with centimeters" in {
//      val oneLiter = Measurement(quantity = 1, unit = Liter)
//      val oneCentimeter = Measurement(quantity = 1, unit = Centimeter)
//
//      oneLiter + oneCentimeter
//    }
  }

}
