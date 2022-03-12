package lld.ride_sharing.Vehicle;

import java.util.concurrent.ThreadLocalRandom;

public class Vehicle {
    Integer ownerID;
    Integer vehicleID;
    Integer numberOfSeats;
    VehicleCategory category;

    Vehicle(Integer ownerID, Integer numberOfSeats, VehicleCategory category) {
        this.ownerID = ownerID;
        this.vehicleID = ThreadLocalRandom.current().nextInt(101, 200);
        this.numberOfSeats = numberOfSeats;
        this.category = category;
    }

    public Integer getOwnerID() {
        return ownerID;
    }

    public Integer getVehicleID() {
        return vehicleID;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public VehicleCategory getCategory() {
        return category;
    }
}
