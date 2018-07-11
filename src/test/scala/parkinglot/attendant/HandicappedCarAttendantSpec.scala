package parkinglot.attendant

import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.when
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{MustMatchers, WordSpec}
import parkinglot.{Car, CarFactory, HandicappedCar, ParkingLot}
import org.mockito.Mockito._

class HandicappedCarAttendantSpec extends WordSpec with MustMatchers with MockitoSugar{
  "HandicappedCarAttendant" should {
    "park a handicapped car in the nearest available parking lot" in {
      val nearParkingLot = mockFreeSlotsParkingLot()
      val farParkingLot = mockFreeSlotsParkingLot()
      val attendant = HandicappedCarAttendant(Seq(nearParkingLot, farParkingLot))

      attendant.park(CarFactory.createHandicappedCar()) mustBe true
      verify(nearParkingLot).park(any[HandicappedCar])
    }

    "park a car in the farthest available parking lot" in {
      val nearParkingLot = mockFreeSlotsParkingLot()
      val farParkingLot = mockFreeSlotsParkingLot()
      val attendant = HandicappedCarAttendant(Seq(nearParkingLot, farParkingLot))

      attendant.park(CarFactory.createCar()) mustBe true
      verify(farParkingLot).park(any[HandicappedCar])
    }
  }

  private def mockFreeSlotsParkingLot(): ParkingLot = {
    val parkingLot = mock[ParkingLot]
    when(parkingLot.park(any[Car])).thenReturn(true)
    parkingLot
  }
}
