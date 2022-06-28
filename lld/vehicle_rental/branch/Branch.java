package branch;

import java.util.HashMap;
import vehicle.*;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Holds vehicle pricing at a category level
 */
class VehicleCategoryPricing {
    HashMap<VehicleCategory, Integer> vehicleCategoryPrices;

    VehicleCategoryPricing() {
        this.vehicleCategoryPrices = new HashMap<>();
    }

    public String toString() {
        String pricing = "Vehicle pricing Info: \n";
        for (HashMap.Entry<VehicleCategory, Integer> entry : this.vehicleCategoryPrices.entrySet()) {
            VehicleCategory key = entry.getKey();
            Integer value = entry.getValue();
            pricing += key.toString() + " " + value + "\n";
        }
        pricing += "\n";

        return pricing;
    }

    void allocatePrice(VehicleCategory category, Integer newPrice) {
        vehicleCategoryPrices.put(category, newPrice);
    }

    Integer getVehicleCategoryPrice(VehicleCategory category) {
        return vehicleCategoryPrices.get(category);
    }
}

/* 
 * add more methods for analysis on vehicles
 * holds all the vehicle currently registered 
 * in this branch 
 */
class VehicleInfo {
    HashMap<Integer, Boolean> vehicleInfoDB;

    VehicleInfo() {
        this.vehicleInfoDB = new HashMap<>();
    }

    void addVehicle(Integer vehicleID) {
        this.vehicleInfoDB.put(vehicleID, true);
    }

    void removeVehicle(Integer vehicleID) {
        this.vehicleInfoDB.remove(vehicleID);
    }
}

/*
 * Represents a branch
 * holds all the vehicle categories
 * holds all the vehicle ID's
 */
public class Branch {
    private Integer id;
    private String name;
    private VehicleInfo vehicleInfo;
    private VehicleCategoryPricing vehiclePricing;

    public Branch(String name) {
        this.id = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
        this.name = name;
        this.vehiclePricing = new VehicleCategoryPricing();
        this.vehicleInfo = new VehicleInfo();
    }

    public String toString() {
        String branch = "Branch Description\n";
        branch += "Brnach ID: " + this.id + "\n";
        branch += "Branch Name: " + this.name + "\n";
        branch += "All vehicles in this branch: ";
        for (Integer vehicleID : this.vehicleInfo.vehicleInfoDB.keySet()) {
            branch += vehicleID + " ";
        }
        branch += "\n";
        branch += this.vehiclePricing.toString();
        return branch;
    }

    public Integer getID() {
        return this.id;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    void allocatePrice(VehicleCategory category, Integer newPrice) {
        this.vehiclePricing.allocatePrice(category, newPrice);
    }

    public Integer getVehicleCategoryPrice(VehicleCategory category) {
        return this.vehiclePricing.getVehicleCategoryPrice(category);
    }

    void addVehicle(Integer vehicleID) {
        this.vehicleInfo.addVehicle(vehicleID);
    }

    void removeVehicle(Integer vehicleID) {
        this.vehicleInfo.removeVehicle(vehicleID);
    }
}
