package parkinglot

import org.scalatest.{FeatureSpec, GivenWhenThen, MustMatchers}
import parkinglot.attendant.{DriverFairAttendant, HandicappedCarAttendant, LargeCarAttendant, OwnerFairAttendant}

class ParkingServiceSpec extends FeatureSpec with MustMatchers with GivenWhenThen{
  feature("Parking service") {
    scenario("As a parking lot owner I want the parking service to be fair with regard to the clients") {
      val nearParkingLot = new ParkingLot(capacity = 10, owner = ParkingLotOwner())
      val farParkingLot = new ParkingLot(capacity = 10, owner = ParkingLotOwner())
      val attendant = DriverFairAttendant(Seq(nearParkingLot, farParkingLot))

      attendant.park(new Car())
      attendant.park(new Car())
      attendant.park(new Car())

      nearParkingLot.freeSlots mustBe 7
      farParkingLot.freeSlots mustBe 10
    }

    scenario("As a parking lot owner I want the parking service to be fair with regard to the owners") {
      val robertParkingLot = new ParkingLot(capacity = 10, owner = ParkingLotOwner())
      val emilyParkingLot = new ParkingLot(capacity = 10, owner = ParkingLotOwner())
      val attendant = OwnerFairAttendant(Seq(robertParkingLot, emilyParkingLot))

      attendant.park(new Car())
      attendant.park(new Car())
      attendant.park(new Car())

      robertParkingLot.freeSlots mustBe 8
      emilyParkingLot.freeSlots mustBe 9
    }

    scenario("As a parking lot owner I want the parking service to be fair with regard to large cars") {
      val lowFreeSlotsParkingLot = new ParkingLot(capacity = 5, owner = ParkingLotOwner())
      val highFreeSlotsParkingLot = new ParkingLot(capacity = 10, owner = ParkingLotOwner())
      val attendant = LargeCarAttendant(Seq(lowFreeSlotsParkingLot, highFreeSlotsParkingLot))

      attendant.park(new LargeCar())
      attendant.park(new LargeCar())
      attendant.park(new LargeCar())

      lowFreeSlotsParkingLot.freeSlots mustBe 5
      highFreeSlotsParkingLot.freeSlots mustBe 7
    }

    scenario("As a parking lot owner I want the parking service to be fair with regard to handicapped cars") {
      val nearParkingLot = new ParkingLot(capacity = 10, owner = ParkingLotOwner())
      val farParkingLot = new ParkingLot(capacity = 10, owner = ParkingLotOwner())
      val attendant = HandicappedCarAttendant(Seq(nearParkingLot, farParkingLot))

      attendant.park(new HandicappedCar())
      attendant.park(new HandicappedCar())
      attendant.park(new HandicappedCar())

      nearParkingLot.freeSlots mustBe 7
      farParkingLot.freeSlots mustBe 10
    }
  }
}
