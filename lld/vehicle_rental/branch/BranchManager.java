package lld.vehicle_rental.branch;

import java.util.HashMap;
import lld.vehicle_rental.vehicle.*;

public class BranchManager {
    HashMap<Integer, Branch> branchDB;
    private static BranchManager branchManager;

    public static BranchManager getBranchManager() {
        if (branchManager == null) {
            branchManager = new BranchManager();
            branchManager.branchDB = new HashMap<>();
        }

        return branchManager;
    }

    public Integer addBranch(String name) {
        Branch b = new Branch(name);
        this.branchDB.put(b.getID(), b);

        return b.getID();
    }

    public Branch getBranch(Integer branchID) {
        return this.branchDB.get(branchID);
    }

    public void updateVehicleCategoryPrice(Integer branchID, VehicleCategory category, Integer newPrice) {
        Branch branch = this.branchDB.get(branchID);
        branch.updateVehicleCategoryPrice(category, newPrice);
    }

    public void addVehicle(Integer branchID, Integer vehicleID) {
        Branch branch = this.branchDB.get(branchID);
        branch.addVehicle(vehicleID);
    }

    public void removeVehicle(Integer branchID, Integer vehicleID) {
        Branch branch = this.branchDB.get(branchID);
        branch.removeVehicle(vehicleID);
    }
}
