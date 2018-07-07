package parkinglot

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{MustMatchers, WordSpec}

import org.mockito.Mockito._

class ParkingLotSpec extends WordSpec with MustMatchers with MockitoSugar{
  "ParkingLot" should {

    "park a car" in {
      val parkingLot = ParkingLot(owner = mock[ParkingLotOwner])
      val car = new Car()

      parkingLot.park(car) mustBe true
    }

    "retrieve a parked a car" in {
      val parkingLot = ParkingLot(owner = mock[ParkingLotOwner])
      val car = new Car()
      parkingLot.park(car)

      parkingLot.retrieve(car) mustBe Some(car)
    }

    "not retrieve a not parked car" in {
      val parkingLot = ParkingLot(owner = mock[ParkingLotOwner])
      val car = new Car()

      parkingLot.retrieve(car) mustBe None
    }

    "notify its owner when it is full" in {
      val owner = mock[ParkingLotOwner]
      val parkingLot = ParkingLot(capacity = 1, owner = owner)

      parkingLot.park(new Car())

      verify(owner).parkingLotIsFull(parkingLot)
    }

    "notify its owner when it becomes free" in {
      val owner = mock[ParkingLotOwner]
      val parkingLot = ParkingLot(capacity = 1, owner = owner)
      val car = new Car()
      parkingLot.park(car)

      parkingLot.retrieve(car)

      verify(owner).parkingLotHasFreeSlots(parkingLot)
    }
  }
}
