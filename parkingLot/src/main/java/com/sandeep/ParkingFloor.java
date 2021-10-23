package com.sandeep;

import java.util.HashMap;

public class ParkingFloor {
   private String name;
   private HashMap<Integer, CompactSpot> compactSpots;
   private HashMap<Integer, LargeSpot> largeSpots;
   private HashMap<Integer, BikeSpot> bikeSpots;
   private HashMap<Integer, ElectricSpot> electricSpots;

   public ParkingFloor(String name) {
      this.name = name;
   }

   public void addParkingSpot(ParkingSpot spot) {
      switch(spot.getSpotType()) {
      case BIKE:
         bikeSpots.put(spot.getNumber(), (BikeSpot)spot);
         break;
      case COMPACT:
         compactSpots.put(spot.getNumber(), (CompactSpot)spot);
         break;
      case LARGE:
         largeSpots.put(spot.getNumber(), (LargeSpot)spot);
         break;
      case ELECTRIC:
         electricSpots.put(spot.getNumber(), (ElectricSpot)spot);
         break;
      default:
         System.out.println("Wrong parking spot type!");
      }
   }

   public void addVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
      spot.assignVehicle(vehicle);
   }

   public void freeSpot(ParkingSpot spot) {
      spot.removeVehicle();
   }
}
