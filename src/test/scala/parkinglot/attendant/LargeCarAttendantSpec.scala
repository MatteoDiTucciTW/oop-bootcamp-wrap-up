package parkinglot.attendant

import org.scalatest.{MustMatchers, WordSpec}
import parkinglot.{Car, LargeCar, ParkingLot}
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.scalatest.mockito.MockitoSugar

class LargeCarAttendantSpec extends WordSpec with MustMatchers with MockitoSugar {

  "LargeCarAttendant" should {
    "park large car in the parking lot with the most free space" in {
      val threeSlotsLeftParkingLot = createThreeSlotsLeftParkingLot()
      val twoSlotsLeftParkingLot = createTwoSlotsLeftParkingLot()
      val attendant = LargeCarAttendant(Seq(twoSlotsLeftParkingLot, threeSlotsLeftParkingLot))

      attendant.park(new LargeCar()) mustBe true
      verify(threeSlotsLeftParkingLot).park(any[LargeCar])
      verify(twoSlotsLeftParkingLot, never()).park(any[LargeCar])
    }

    "park a car in the first parking lot available" in {
      val threeSlotsLeftParkingLot = createThreeSlotsLeftParkingLot()
      val twoSlotsLeftParkingLot = createTwoSlotsLeftParkingLot()
      val attendant = LargeCarAttendant(Seq(twoSlotsLeftParkingLot, threeSlotsLeftParkingLot))

      attendant.park(new Car()) mustBe true
      verify(twoSlotsLeftParkingLot).park(any[Car])
      verify(threeSlotsLeftParkingLot, never()).park(any[Car])
    }
  }

  private def createThreeSlotsLeftParkingLot() = {
    val parkingLot = mock[ParkingLot]
    when(parkingLot.freeSlots).thenReturn(3)
    when(parkingLot.park(any[Car])).thenReturn(true)
    parkingLot
  }

  private def createTwoSlotsLeftParkingLot() = {
    val parkingLot = mock[ParkingLot]
    when(parkingLot.freeSlots).thenReturn(2)
    when(parkingLot.park(any[Car])).thenReturn(true)
    parkingLot
  }
}
