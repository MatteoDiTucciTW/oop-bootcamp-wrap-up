package parkinglot.attendant

import parkinglot.{Attendant, Car, HandicappedCar, ParkingLot}

case class HandicappedCarAttendant(parkingLots: Seq[ParkingLot]) extends Attendant {

  override def park(car: Car): Boolean = {
    car match {
      case _: HandicappedCar => parkHandicappedCar(car)
      case __                => parkOtherCar(car)
    }
  }

  private def parkHandicappedCar(car: Car) = {
    parkingLots.find(_.park(car)).fold(false)(_ => true)
  }

  private def parkOtherCar(car: Car) = {
    parkingLots.reverse.find(_.park(car)).fold(false)(_ => true)
  }
}
