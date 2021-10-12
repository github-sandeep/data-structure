package com.sandeep.parkinglot;

public abstract class Vehicle {
   private String vehicleNumber;
   private VehicleType vehicleType;
   private ParkingTicket ticket;

   public Vehicle(VehicleType vehicleType) {
      this.vehicleType = vehicleType;
   }

   public void assignTicket(ParkingTicket ticket) {
      this.ticket = ticket;
   }

   public String getVehicleNumber() {

      return vehicleNumber;
   }

   public VehicleType getVehicleType() {

      return vehicleType;
   }

   public ParkingTicket getTicket() {

      return ticket;
   }
}
