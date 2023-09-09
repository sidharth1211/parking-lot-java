package org.parkingLot.models;

import java.util.Date;

public class Ticket {
  private String vehicleNumber;
  private int slotNumber;
  private Date date;
  private VehicleType vehicleType;

  public Ticket(int slotNumber, String vehicleNumber, VehicleType vehicleType, Date date) {
    this.vehicleNumber = vehicleNumber;
    this.slotNumber = slotNumber;
    this.date = date;
    this.vehicleType = vehicleType;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public int getSlotNumber() {
    return slotNumber;
  }

  @Override
  public String toString() {
    return "Ticket{" +
            "vehicleNumber='" + vehicleNumber + '\'' +
            ", slotNumber=" + slotNumber +
            ", date=" + date +
            ", vehicleType=" + vehicleType +
            '}';
  }
}
