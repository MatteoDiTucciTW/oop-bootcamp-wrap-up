package parkinglot

case class ParkingLotOwner(private val attendant: Attendant, private val parkingLots: Seq[ParkingLot]) {

  def park(car: Car): Boolean = attendant.park(car)

  def parkingLotIsFull(parkingLot: ParkingLot): Unit = ()

  def parkingLotHasFreeSlots(parkingLot: ParkingLot): Unit = ()
}
