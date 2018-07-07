package parkinglot.attendant

import parkinglot.{Attendant, Car, ParkingLot}

case class FreeSlotsAttendant(private val parkingLots: Seq[ParkingLot]) extends Attendant {

  override def park(car: Car): Boolean = {
    parkingLots.foreach(parkingLot => {
      if (parkingLot.park(car)) {
        return true
      }
    })
    false
  }
}
