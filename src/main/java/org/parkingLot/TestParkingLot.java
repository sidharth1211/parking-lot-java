package org.parkingLot;

import org.parkingLot.exceptions.InvalidVehicleNumberException;
import org.parkingLot.exceptions.ParkingFullException;
import org.parkingLot.models.Ticket;
import org.parkingLot.models.Vehicle;
import org.parkingLot.models.VehicleType;
import org.parkingLot.services.ParkingLot;
import org.parkingLot.strategy.FourWheelerChargeStrategy;
import org.parkingLot.strategy.TwoWheelerChargeStrategy;

public class TestParkingLot {

  public static void main(String[] args) throws ParkingFullException, InvalidVehicleNumberException {
    ParkingLot parkingLot = ParkingLot.getParkingLot();

    parkingLot.initializeParkingSlot(10, 10);

    Vehicle vehicle = new Vehicle("Mh12", VehicleType.TWO_WHEELER);

    Ticket ticket = parkingLot.park(vehicle);
    System.out.println(ticket);

    Vehicle vehicle2 = new Vehicle("Mh13", VehicleType.TWO_WHEELER);

    Ticket ticket2 = parkingLot.park(vehicle2);
    System.out.println(ticket2);
    int cost1 = parkingLot.unPark(ticket, new TwoWheelerChargeStrategy());
    System.out.println(cost1);

    int cost2 = parkingLot.unPark(ticket2, new TwoWheelerChargeStrategy());
    System.out.println(cost2);
  }

}
