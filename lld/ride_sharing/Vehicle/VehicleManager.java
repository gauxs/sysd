package lld.ride_sharing.Vehicle;

import java.util.*;

public class VehicleManager {
    private static VehicleManager vehicleManager;
    public static HashMap<Integer, Vehicle> vehicleDB = new HashMap<>();

    public static VehicleManager getVehicleManager() {
        if (vehicleManager == null) {
            vehicleManager = new VehicleManager();
        }

        return vehicleManager;
    }

    public Vehicle getVehicle(Integer vehicleID) {
        return vehicleDB.get(vehicleID);
    }

    public Integer addVehicle(String ownerName, Integer vehicleID, Integer numberOfSeats, VehicleCategory category) {
        Vehicle newVehicle = new Vehicle(ownerName, vehicleID, numberOfSeats, category);
        vehicleDB.put(newVehicle.vehicleID, newVehicle);
        return newVehicle.getVehicleID();
    }
}
