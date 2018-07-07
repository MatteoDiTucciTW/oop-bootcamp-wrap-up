package parkinglot

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{MustMatchers, WordSpec}
import org.mockito.Mockito._

class ParkingLotOwnerSpec extends WordSpec with MustMatchers with MockitoSugar{
  "ParkingOwner" should {

    "delegate the parking of a car to an attendant" in {
      val attendant = mock[Attendant]
      val parkingLotOwner = ParkingLotOwner(attendant = attendant, parkingLots = Seq.empty)
      val car = new Car()

      parkingLotOwner.park(car)

      verify(attendant).park(car)
    }
  }
}
