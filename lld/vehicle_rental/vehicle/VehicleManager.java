package lld.vehicle_rental.vehicle;

import java.time.*;
import java.util.*;

import lld.vehicle_rental.branch.*;

public class VehicleManager {
    HashMap<Integer, Vehicle> vehicleDB;
    List<List<Integer>> vehiclesAvailablilty;

    private static VehicleManager vehicleManager;

    public static VehicleManager getVehicleManager() {
        if (vehicleManager == null) {
            vehicleManager = new VehicleManager();
            vehicleManager.vehicleDB = new HashMap<>();
            vehicleManager.vehiclesAvailablilty = new ArrayList<>(24);
        }

        return vehicleManager;
    }

    public void addVehicle(VehicleCategory category) {
        Vehicle v = new Vehicle(category);
        vehicleDB.put(v.getID(), v);

        for (int i = 0; i < 24; i++) {
            vehiclesAvailablilty.get(i).add(v.getID());
        }
    }

    public Integer addVehicle(VehicleCategory category, Integer branchID) {
        Vehicle v = new Vehicle(category, branchID);
        vehicleDB.put(v.getID(), v);

        for (int i = 0; i < 24; i++) {
            vehiclesAvailablilty.get(i).add(v.getID());
        }

        return v.getID();
    }

    public Vehicle getVehicle(Integer vehicleID) {
        return vehicleDB.get(vehicleID);
    }

    public void updateBranch(Integer vehicleID, Integer branchID) {
        Vehicle v = this.vehicleDB.get(vehicleID);

        // removing this vehicle from current branch
        BranchManager.getBranchManager().removeVehicle(v.getBranch(), v.getID());

        // updating branch of the vehicle to specified
        v.updateBranch(branchID);

        // adding this vehicle to specified branch
        BranchManager.getBranchManager().removeVehicle(branchID, v.getID());
    }

    public void updateCategory(Integer vehicleID, VehicleCategory category) {
        Vehicle v = this.vehicleDB.get(vehicleID);
        v.updateCategory(category);
    }

    // queries DB for all the vehicles between startTime and endTime
    public List<Vehicle> getAvailaibility(LocalDate startTime, LocalDate endTime) {
        Integer startHour = 0;
        Integer endHour = 0;

        List<Vehicle> availableVehicles = new ArrayList<>();
        for (int i = startHour; i <= endHour; i++) {
            List<Integer> curAvailaibleVehicles = vehiclesAvailablilty.get(i);
            for (int j = 0; j < curAvailaibleVehicles.size(); j++) {

            }
        }

        return availableVehicles;
    }

    public void blockVehicle(Integer vehicleID, LocalDate startTime, LocalDate endTime) {

    }
}
