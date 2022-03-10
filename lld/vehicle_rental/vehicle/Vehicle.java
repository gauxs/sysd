package lld.vehicle_rental.vehicle;

import java.util.concurrent.ThreadLocalRandom;
import lld.vehicle_rental.branch.*;

/*
    vehicle can be created with or without branch
*/
public class Vehicle {
    private Integer id;
    private Integer branchID;
    private VehicleCategory category;

    // vehicle without a branch can exist
    Vehicle(VehicleCategory category) {
        this.id = ThreadLocalRandom.current().nextInt(1001, 10000000 + 1);
        this.branchID = -1;
        this.category = category;
    }

    Vehicle(VehicleCategory category, Integer branchID) {
        this.id = ThreadLocalRandom.current().nextInt(1001, 10000000 + 1);

        this.branchID = branchID;
        this.category = category;
        BranchManager.getBranchManager().addVehicle(branchID, this.id);
    }

    public Integer getID() {
        return this.id;
    }

    void updateCategory(VehicleCategory category) {
        this.category = category;
    }

    public VehicleCategory getCategory() {
        return this.category;
    }

    void updateBranch(Integer branchID) {
        this.branchID = branchID;
    }

    public Integer getBranch() {
        return this.branchID;
    }
}