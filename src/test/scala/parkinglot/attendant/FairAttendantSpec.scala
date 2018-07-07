package parkinglot.attendant

import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.when
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{MustMatchers, WordSpec}
import parkinglot.{Car, ParkingLot}
import org.mockito.Mockito._

class FairAttendantSpec extends WordSpec with MustMatchers with MockitoSugar{
  "EventAttendant" should {
    "park car evenly among parking lots" in {
      val firstParkingLot = mockFreeSlotsParkingLot()
      val secondParkingLot = mockFreeSlotsParkingLot()
      val attendant = FairAttendant(Seq(firstParkingLot, secondParkingLot))

      attendant.park(new Car())
      attendant.park(new Car())

      verify(firstParkingLot).park(any[Car])
      verify(secondParkingLot).park(any[Car])
    }

    // 3 cars and two parking lots

    // empty sequence of parking lot in the constructor
  }

  private def mockFreeSlotsParkingLot(): ParkingLot = {
    val parkingLot = mock[ParkingLot]
    when(parkingLot.park(any[Car])).thenReturn(true)
    parkingLot
  }
}
