package parkinglot.attendant

import parkinglot.{Attendant, Car, ParkingLot}

case class OwnerFairAttendant(private val parkingLots: Seq[ParkingLot]) extends Attendant {

  private var nextParkingLotToBeServed = parkingLots.head

  override def park(car: Car): Boolean = {
    parkFairly(car, parkingLots)
  }

  private def parkFairly(car: Car, remainingParkingLots: Seq[ParkingLot]): Boolean = {
    if (remainingParkingLots.isEmpty) {
      return false
    }

    if (remainingParkingLots.head == nextParkingLotToBeServed) {
      remainingParkingLots.head.park(car)
      nextParkingLotToBeServed = findNextParkingLotToBeServed(remainingParkingLots.tail)
      return true
    }

    parkFairly(car, remainingParkingLots.tail)
  }

  private def findNextParkingLotToBeServed(remainingParkingLots: Seq[ParkingLot]) = {
    if (remainingParkingLots.isEmpty){
      parkingLots.head
    } else {
      remainingParkingLots.head
    }
  }
}
