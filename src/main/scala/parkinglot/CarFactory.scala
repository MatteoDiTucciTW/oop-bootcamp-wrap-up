package parkinglot

object CarFactory {
  def createHandicappedCar(): HandicappedCar = new HandicappedCar()

  def createLargeCar(): LargeCar = new LargeCar()

  def createCar(): Car = new Car()
}
