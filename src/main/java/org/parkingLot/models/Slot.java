package org.parkingLot.models;

public class Slot {
    private int slotNumber;
    private boolean occupied;
    private Vehicle vehicle;

    public Slot(int slotNumber){
        this.slotNumber = slotNumber;
        this.occupied = false;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
