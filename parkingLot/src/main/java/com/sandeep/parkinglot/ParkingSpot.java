package com.sandeep.parkinglot;

public abstract class ParkingSpot {
   private int number;
   private ParkingSpotType spotType;
   private boolean free;
   private Vehicle vehicle;

   public ParkingSpot(ParkingSpotType spotType) {
      this.spotType = spotType;
   }

   public boolean isFree() {
      return this.free;
   }

   public void assignVehicle(Vehicle vehicle) {
      this.vehicle = vehicle;
      free = false;
   }

   public void removeVehicle() {
      this.vehicle = null;
      free = true;
   }

   public int getNumber() {

      return number;
   }

   public ParkingSpotType getSpotType() {

      return spotType;
   }

   public Vehicle getVehicle() {

      return vehicle;
   }
}
