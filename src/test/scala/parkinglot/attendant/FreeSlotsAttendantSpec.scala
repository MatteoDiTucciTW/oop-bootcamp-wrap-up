package parkinglot.attendant

import org.mockito.ArgumentMatchers._
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{MustMatchers, WordSpec}
import parkinglot.{Car, ParkingLot}

class FreeSlotsAttendantSpec extends WordSpec with MustMatchers with MockitoSugar {
  "FreeSlotsAttendant" should {

    "park a car in a parking lot with free slots" in {
      val freeSlotsParkingLot = mockFreeSlotsParkingLot()
      val fullParkingLot = mockFullParkingLot()
      val attendant = FreeSlotsAttendant(Seq(fullParkingLot, freeSlotsParkingLot))

      attendant.park(new Car()) mustBe true
      verify(freeSlotsParkingLot).park(any[Car])
    }
  }

  private def mockFreeSlotsParkingLot(): ParkingLot = {
    val parkingLot = mock[ParkingLot]
    when(parkingLot.park(any[Car])).thenReturn(true)
    parkingLot
  }

  private def mockFullParkingLot(): ParkingLot = {
    val parkingLot = mock[ParkingLot]
    when(parkingLot.park(any[Car])).thenReturn(false)
    parkingLot
  }
}
