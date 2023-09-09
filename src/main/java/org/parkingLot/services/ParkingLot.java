package org.parkingLot.services;

import org.parkingLot.exceptions.InvalidVehicleNumberException;
import org.parkingLot.exceptions.ParkingFullException;
import org.parkingLot.models.Slot;
import org.parkingLot.models.Ticket;
import org.parkingLot.models.Vehicle;
import org.parkingLot.models.VehicleType;
import org.parkingLot.strategy.ParkingChargeStrategy;

import java.util.*;

public class ParkingLot implements Parking {
  private static ParkingLot parkingLot;
  private List<Slot> twoWheelerSlots;
  private List<Slot> fourWheelerSlots;

  public static ParkingLot getParkingLot() {
    if (parkingLot == null) parkingLot = new ParkingLot();
    return parkingLot;
  }

  private ParkingLot() {
    this.twoWheelerSlots = new ArrayList<>();
    this.fourWheelerSlots = new ArrayList<>();
  }

  public void initializeParkingSlot(int numberOfTwoWheelerSlots, int numberOfFourWheelerSlots) {
    for (int i = 1; i <= numberOfTwoWheelerSlots; i++) {
      twoWheelerSlots.add(new Slot(i));
    }
    System.out.printf("Created a two wheeler parking lot with %s slots %n", numberOfTwoWheelerSlots);
    for (int i = 1; i <= numberOfFourWheelerSlots; i++) {
      fourWheelerSlots.add(new Slot(i));
    }
    System.out.printf("Created a four wheeler parking lot with %s slots %n", numberOfFourWheelerSlots);
  }

  @Override
  public Ticket park(Vehicle vehicle) throws ParkingFullException {
    Slot nextAvailableSlot;
    if (vehicle.getVehicleType().equals(VehicleType.FOUR_WHEELER)) {
      nextAvailableSlot = getNextAvailableFourWheelerSlot();
    } else {
      nextAvailableSlot = getNextAvailableTwoWheelerSlot();
    }
    nextAvailableSlot.setVehicle(vehicle);
    nextAvailableSlot.setOccupied(true);
    Ticket ticket = new Ticket(nextAvailableSlot.getSlotNumber(), vehicle.getVehicleNumber(),
            vehicle.getVehicleType(), new Date());
    return ticket;
  }

  @Override
  public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException {
    Slot slot;
    int parkingCost=0;
    VehicleType vehicleType = ticket.getVehicleType();
    try{
      if (vehicleType.equals(VehicleType.FOUR_WHEELER)) {
        slot = getFourWheelerSlotByVehicleNumber(ticket.getVehicleNumber());
        slot.setOccupied(false);
        int hours = getHoursParked(ticket.getDate(), new Date());
        parkingCost = parkingCostStrategy.getParkingCost(hours);
        System.out.println(
                "Vehicle with registration " + ticket.getVehicleNumber() + " at slot number " + slot.getSlotNumber()
                        + " was parked for " + hours + " hours and the total charge is " + parkingCost);
      } else {
        slot = getTwoWheelerSlotByVehicleNumber(ticket.getVehicleNumber());
        slot.setOccupied(false);
        int hours = getHoursParked(ticket.getDate(), new Date());
        parkingCost = parkingCostStrategy.getParkingCost(hours);
        System.out.println(
                "Vehicle with registration " + ticket.getVehicleNumber() + " at slot number " + slot.getSlotNumber()
                        + " was parked for " + hours + " hours and the total charge is " + parkingCost);
      }
    }catch (InvalidVehicleNumberException invalidVehicleNumber) {
      System.out.println(invalidVehicleNumber.getMessage());
      throw invalidVehicleNumber;
    }
    return parkingCost;
  }

  private int getHoursParked(Date startDate, Date endDate) {
    long secs = (endDate.getTime() - startDate.getTime()) / 1000;
    int hours = (int) (secs / 3600);
    return hours;
  }

  private Slot getFourWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException {
    for (Slot slot : fourWheelerSlots) {
      Vehicle vehicle = slot.getVehicle();
      if (vehicle != null && vehicle.getVehicleNumber().equals(vehicleNumber)) {
        return slot;
      }
    }
    throw new InvalidVehicleNumberException("Two wheeler with registration number " + vehicleNumber + " not found");
  }
  private Slot getTwoWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException {
    for (Slot slot : twoWheelerSlots) {
      Vehicle vehicle = slot.getVehicle();
      if (vehicle != null && vehicle.getVehicleNumber().equals(vehicleNumber)) {
        return slot;
      }
    }
    throw new InvalidVehicleNumberException("Two wheeler with registration number " + vehicleNumber + " not found");
  }
  private Slot getNextAvailableFourWheelerSlot() throws ParkingFullException {
    for (Slot slot : fourWheelerSlots) {
      if (!slot.isOccupied())
        return slot;
    }
    throw new ParkingFullException("No Empty Slot available");
  }

  private Slot getNextAvailableTwoWheelerSlot() throws ParkingFullException {
    for (Slot slot : twoWheelerSlots) {
      if (!slot.isOccupied())
        return slot;
    }
    throw new ParkingFullException("No Empty Slot available");
  }

}
