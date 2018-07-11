package parkinglot

import org.scalatest.{MustMatchers, WordSpec}

class CarFactorySpec extends WordSpec with MustMatchers{

  "CarFactory" should {
    "create a car" in {
      CarFactory.createCar() mustBe a [Car]
    }

    "create a large car" in {
      CarFactory.createLargeCar() mustBe a [LargeCar]
    }

    "create a handicapped car" in {
      CarFactory.createHandicappedCar() mustBe a [HandicappedCar]
    }
  }

}
