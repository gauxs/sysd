package lld.ride_sharing.TripManager;

import lld.ride_sharing.Location.Location;

public class Trip {
    Location source;
    Location destination;
    Integer driverUserID;
    Integer passengerUserID[];
    Integer totalSeats;
    Integer availableSeats;
    Integer vehicleID;

    Trip(Location source, Location destination, Integer driverUserID, Integer vehicleID) {
        this.source = source;
        this.destination = destination;
        this.driverUserID = driverUserID;
        this.vehicleID = vehicleID;
    }
}
