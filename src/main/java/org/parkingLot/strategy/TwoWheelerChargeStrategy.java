package org.parkingLot.strategy;

public class TwoWheelerChargeStrategy implements ParkingChargeStrategy{
  @Override
  public int getParkingCost(int parkingHours) {
    if (parkingHours < 1) {
      return 10;
    }
    return parkingHours * 10;
  }
}
