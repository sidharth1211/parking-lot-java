package org.parkingLot.services;

import org.parkingLot.exceptions.InvalidVehicleNumberException;
import org.parkingLot.exceptions.ParkingFullException;
import org.parkingLot.models.Ticket;
import org.parkingLot.models.Vehicle;
import org.parkingLot.strategy.ParkingChargeStrategy;

public interface Parking {
  public Ticket park(Vehicle vehicle) throws ParkingFullException;
  public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException;

}
