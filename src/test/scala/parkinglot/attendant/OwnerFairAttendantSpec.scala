package parkinglot.attendant

import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.when
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{MustMatchers, WordSpec}
import parkinglot.{Car, ParkingLot}
import org.mockito.Mockito._

class OwnerFairAttendantSpec extends WordSpec with MustMatchers with MockitoSugar{
  "OwnerFairAttendant" should {
    "park car evenly among parking lots" when {

      "parking two cars in two parking lots" in {
        val firstParkingLot = mockFreeSlotsParkingLot()
        val secondParkingLot = mockFreeSlotsParkingLot()
        val attendant = OwnerFairAttendant(Seq(firstParkingLot, secondParkingLot))

        attendant.park(new Car()) mustBe true
        attendant.park(new Car()) mustBe true
        verify(firstParkingLot).park(any[Car])
        verify(secondParkingLot).park(any[Car])
      }

      "parking three cars in two parking lots" in {
        val firstParkingLot = mockFreeSlotsParkingLot()
        val secondParkingLot = mockFreeSlotsParkingLot()
        val attendant = OwnerFairAttendant(Seq(firstParkingLot, secondParkingLot))

        attendant.park(new Car()) mustBe true
        attendant.park(new Car()) mustBe true
        attendant.park(new Car()) mustBe true
        verify(firstParkingLot, times(2)).park(any[Car])
        verify(secondParkingLot).park(any[Car])
      }
    }
  }

  private def mockFreeSlotsParkingLot(): ParkingLot = {
    val parkingLot = mock[ParkingLot]
    when(parkingLot.park(any[Car])).thenReturn(true)
    parkingLot
  }
}
