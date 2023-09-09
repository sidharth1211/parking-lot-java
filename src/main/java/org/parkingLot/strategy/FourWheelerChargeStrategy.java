package org.parkingLot.strategy;

public class FourWheelerChargeStrategy implements ParkingChargeStrategy {

  @Override
  public int getParkingCost(int parkingHours) {
    if (parkingHours < 1) {
      return 20;
    }
    return parkingHours * 20;
  }
}
