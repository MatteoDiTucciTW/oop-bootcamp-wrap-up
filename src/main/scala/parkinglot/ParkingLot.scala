package parkinglot

import scala.collection.mutable

case class ParkingLot(capacity: Int = 100, owner: ParkingLotOwner) {

  val parkedCars: mutable.Set[Car] = mutable.HashSet[Car]()

  def park(car: Car): Boolean = {
    parkedCars.add(car)
    notifyOwnerIfFull()
    true
  }

  private def notifyOwnerIfFull(): Unit = {
    if (parkedCars.size == capacity) {
      owner.parkingLotIsFull(this)
    }
  }

  def retrieve(car: Car): Option[Car] = {
    val parkedCar = removeCarFromParking(car)
    notifyOwnerIfFree()
    parkedCar
  }

  private def removeCarFromParking(carToRetrieve: Car) = {
    val parkedCar = parkedCars.find(parkedCar => parkedCar == carToRetrieve)
    parkedCar.foreach(parkedCars -= _)
    parkedCar
  }

  private def notifyOwnerIfFree(): Unit = {
    if (parkedCars.size != capacity) {
      owner.parkingLotIsFree(this)
    }
  }
}
