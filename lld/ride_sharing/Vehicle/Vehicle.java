package lld.ride_sharing.Vehicle;

public class Vehicle {
    String ownerName;
    Integer vehicleID;
    Integer numberOfSeats;
    VehicleCategory category;

    Vehicle(String ownerName, Integer vehicleID, Integer numberOfSeats, VehicleCategory category) {
        this.ownerName = ownerName;
        this.vehicleID = vehicleID;
        this.numberOfSeats = numberOfSeats;
        this.category = category;
    }

    public String getOwnerName() {
        return ownerName;
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
