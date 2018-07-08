package parkinglot.attendant

import parkinglot.{Attendant, Car, LargeCar, ParkingLot}

case class LargeCarAttendant(private val parkingLots: Seq[ParkingLot]) extends Attendant {
  override def park(car: Car): Boolean = {
    car match {
      case _: LargeCar => parkLargeCar(car)
      case __          => parkOtherCar(car)
    }
  }

  private def parkLargeCar(car: Car): Boolean = {
    parkingLots.maxBy(_.freeSlots).park(car)
    true
  }

  private def parkOtherCar(car: Car): Boolean = parkingLots.find(_.park(car)).fold(false)(_ => true)
}
