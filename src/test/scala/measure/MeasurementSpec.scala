package measure

import org.scalatest.{MustMatchers, WordSpec}

class MeasurementSpec extends WordSpec with MustMatchers{

  "Measurement" should {
    "compare feet with inches" in {
      val oneFoot = Measurement(quantity = 1, unit = Foot)
      val twelveInches = Measurement(quantity = 12, unit = Inch)

      oneFoot == twelveInches mustBe true
    }

    "compare feet with yards" in {
      val threeFeet = Measurement(quantity = 3, unit = Foot)
      val oneYard = Measurement(quantity = 1, unit = Yard)

      threeFeet == oneYard mustBe true
    }

    "compare inches with centimeters" in {
      val twoInches = Measurement(quantity = 2, unit = Inch)
      val fivePointHeightCentimeters = Measurement(quantity = 5.08, unit = Centimeter)

      twoInches == fivePointHeightCentimeters mustBe true
    }

    "add inches with inches" in {
      val twoInches = Measurement(quantity = 2, unit = Inch)
      val fourInches = Measurement(quantity = 4, unit = Inch)

      twoInches + twoInches mustBe fourInches
    }

    "add inches with centimeters" in {
      val twoInches = Measurement(quantity = 2, unit = Inch)
      val twoPointFiftyFourCentimeters = Measurement(quantity = 2.54, unit = Centimeter)
      val threeInches = Measurement(quantity = 3, unit = Inch)

      twoInches + twoPointFiftyFourCentimeters mustBe threeInches
    }

    "compare gallons with liters" in {
      val oneGallon = Measurement(quantity = 1, unit = Gallon)
      val threePointSeventyHeightLiters = Measurement(quantity = 3.7854, unit = Liter)

      oneGallon == threePointSeventyHeightLiters mustBe true
    }

    "add gallons with liters" in {
      val oneGallon = Measurement(quantity = 1, unit = Gallon)
      val oneLiter = Measurement(quantity = 1, unit = Liter)
      val fourPointSeventyEightLiters = Measurement(quantity = 4.7854, unit = Liter)

      oneGallon + oneLiter mustBe fourPointSeventyEightLiters
    }

    "compare Fahrenheit with Celsius" in {
      val twoHundredTwelveFahrenheit = Measurement(quantity = 212, unit = Fahrenheit)
      val oneHundredCelsius = Measurement(quantity = 100, unit = Celsius)

      twoHundredTwelveFahrenheit == oneHundredCelsius mustBe true
    }

//    "add liters with centimeters" in {
//      val oneLiter = Measurement(quantity = 1, unit = Liter)
//      val oneCentimeter = Measurement(quantity = 1, unit = Centimeter)
//
//      oneLiter + oneCentimeter
//    }
  }

}
