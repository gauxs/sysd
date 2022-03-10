package lld.vehicle_rental.branch;

import java.util.HashMap;
import lld.vehicle_rental.vehicle.*;
import java.util.concurrent.ThreadLocalRandom;

class VehicleCategoryPricing {
    HashMap<VehicleCategory, Integer> vehicleCategoryPrices;

    void updateVehicleCategoryPrice(VehicleCategory category, Integer newPrice) {
        vehicleCategoryPrices.put(category, newPrice);
    }

    Integer getVehicleCategoryPrice(VehicleCategory category) {
        return vehicleCategoryPrices.get(category);
    }
}

// add more methods for analysis on vehicles
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

    public Integer getID() {
        return this.id;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    void updateVehicleCategoryPrice(VehicleCategory category, Integer newPrice) {
        this.vehiclePricing.updateVehicleCategoryPrice(category, newPrice);
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
