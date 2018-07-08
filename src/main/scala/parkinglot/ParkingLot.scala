package parkinglot

import scala.collection.mutable

class ParkingLot(private val capacity: Int = 100, owner: ParkingLotOwner) {
  val parkedCars: mutable.Set[Car] = mutable.HashSet[Car]()

  def park(car: Car): Boolean = {
    if (parkingLotIsFull) {
      return false
    }
    parkedCars.add(car)
    notifyOwnerIfParkingLotIsFull()
    true
  }

  def retrieve(car: Car): Option[Car] = {
    val parkedCar = removeCarFromParking(car)
    notifyOwnerIfParkingLotHasFreeSlots()
    parkedCar
  }

  def freeSlots: Int = capacity - parkedCars.size

  private def notifyOwnerIfParkingLotIsFull(): Unit = {
    if (parkingLotIsFull) {
      owner.parkingLotIsFull(this)
    }
  }

  private def removeCarFromParking(carToRetrieve: Car) = {
    val parkedCar = parkedCars.find(parkedCar => parkedCar == carToRetrieve)
    parkedCar.foreach(parkedCars -= _)
    parkedCar
  }

  private def notifyOwnerIfParkingLotHasFreeSlots(): Unit = {
    if (parkingLotHasFreeSlots) {
      owner.parkingLotHasFreeSlots(this)
    }
  }

  private def parkingLotIsFull = {
    parkedCars.size == capacity
  }

  private def parkingLotHasFreeSlots = !parkingLotIsFull
}
