package lld.ride_sharing.TripManager;

import java.util.ArrayList;
import java.util.List;

import lld.ride_sharing.Location.Location;

public class Trip {
    Location source;
    Location destination;
    String driverName;
    List<String> passengers;
    Integer totalSeats;
    Integer availableSeats;
    Integer vehicleID;

    Trip(Location source, Location destination, String driverName, Integer vehicleID, Integer totalSeats) {
        this.source = source;
        this.destination = destination;
        this.driverName = driverName;
        this.vehicleID = vehicleID;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats - 1;
        this.passengers = new ArrayList<>();
    }

    public String toString() {
        String trip = "Trip details: \n";
        trip += "Source: " + this.source.toString() + "\n";
        trip += "Destination: " + this.destination.toString() + "\n";
        trip += "Driver: " + this.driverName + "\n";
        trip += "Total seats: " + this.totalSeats + "\n";
        trip += "Available seats: " + this.availableSeats + "\n";
        trip += "VehicleID: " + this.vehicleID + "\n";
        trip += "Passengers: ";
        for (String p : this.passengers) {
            trip += p + " ";
        }
        trip += "\n";
        return trip;
    }

    public void addPassenger(String passengerName) {
        this.passengers.add(passengerName);
        this.availableSeats -= 1;
    }
}
