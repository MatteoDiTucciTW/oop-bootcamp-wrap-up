package parkinglot.attendant

import parkinglot.{Attendant, Car, ParkingLot}

case class OwnerFairAttendant(private val parkingLots: Seq[ParkingLot]) extends Attendant {

  private var nextParkingLotToBeServed = parkingLots.head

  override def park(car: Car): Boolean = {
    val circularIterator = Iterator.continually(parkingLots).flatten
    val parkingLot = circularIterator.find(_ == nextParkingLotToBeServed)
    nextParkingLotToBeServed = circularIterator.next()
    parkingLot.fold(false)(_.park(car))
  }
}
