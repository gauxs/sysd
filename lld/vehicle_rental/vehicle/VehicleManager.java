package lld.vehicle_rental.vehicle;

import java.util.*;

import lld.vehicle_rental.branch.*;

// TODO: implement this
class SegmentNode {
    private Integer startHour;
    private Integer endHour;
    private SegmentNode leftChild;
    private SegmentNode rightChild;
    private List<Integer> vehicles;

    SegmentNode(Integer startHour, Integer endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.leftChild = null;
        this.rightChild = null;
        this.vehicles = new ArrayList<>();
    }

    public Integer getStartHour() {
        return startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public List<Integer> getVehicles() {
        return vehicles;
    }

    public void setLeftChild(SegmentNode leftChild) {
        this.leftChild = leftChild;
    }

    public SegmentNode getLeftChild() {
        return leftChild;
    }

    public void setRightChild(SegmentNode rightChild) {
        this.rightChild = rightChild;
    }

    public SegmentNode getRightChild() {
        return rightChild;
    }
}

// TODO: implement this
class SegementDB {
    SegmentNode root;

    SegementDB() {
        this.root = new SegmentNode(0, 23);
        buildTree(this.root);
    }

    void buildTree(SegmentNode root) {
        if (root.getStartHour() == root.getEndHour())
            return;

        Integer mid = root.getStartHour() + (root.getEndHour() - root.getStartHour()) / 2;
        root.setLeftChild(new SegmentNode(root.getStartHour(), mid));
        root.setLeftChild(new SegmentNode(mid + 1, root.getEndHour()));
        buildTree(root.getLeftChild());
        buildTree(root.getRightChild());
    }
}

public class VehicleManager {
    List<List<Integer>> availabilityDB;
    HashMap<Integer, Vehicle> vehicleDB;
    private static VehicleManager vehicleManager;

    public static VehicleManager getVehicleManager() {
        if (vehicleManager == null) {
            vehicleManager = new VehicleManager();
            vehicleManager.vehicleDB = new HashMap<>();
            vehicleManager.availabilityDB = new ArrayList<>();
            for (Integer i = 0; i < 24; i++) {
                vehicleManager.availabilityDB.add(new ArrayList<>());
            }
        }

        return vehicleManager;
    }

    public Integer addVehicle(VehicleCategory category) {
        Vehicle v = new Vehicle(category);
        this.vehicleDB.put(v.getID(), v);

        // initially vehicle is available in all time slots
        for (Integer i = 0; i < 24; i++) {
            this.availabilityDB.get(i).add(v.getID());
        }

        return v.getID();
    }

    public Integer addVehicle(VehicleCategory category, Integer branchID) {
        Vehicle v = new Vehicle(category, branchID);
        this.vehicleDB.put(v.getID(), v);

        // initially vehicle is available in all time slots
        for (Integer i = 0; i < 24; i++) {
            this.availabilityDB.get(i).add(v.getID());
        }

        return v.getID();
    }

    public Vehicle getVehicle(Integer vehicleID) {
        return this.vehicleDB.get(vehicleID);
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
    // currently using basic search, segment tree can optimize it
    public List<Vehicle> getAvailaibility(Integer startTime, Integer endTime) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Map.Entry<Integer, Vehicle> entry : vehicleDB.entrySet()) {
            Boolean vehicleEligible = true;
            Integer vehicleID = entry.getKey();
            Vehicle vehicle = entry.getValue();
            for (Integer i = startTime; i <= endTime; i++) {
                if (!this.availabilityDB.get(i).contains(vehicleID)) {
                    vehicleEligible = false;
                    break;
                }
            }

            if (vehicleEligible) {
                availableVehicles.add(vehicle);
            }
        }

        return availableVehicles;
    }

    public void blockVehicle(Integer vehicleID, Integer startTime, Integer endTime) {
        for (Integer i = startTime; i <= endTime; i++) {
            this.availabilityDB.get(i).remove(vehicleID);
        }
    }

    public void getOverview(Integer startTime, Integer endTime) {
        HashMap<VehicleCategory, List<Vehicle>> available = new HashMap<>();
        HashMap<VehicleCategory, List<Vehicle>> unavailable = new HashMap<>();

        for (Map.Entry<Integer, Vehicle> entry : this.vehicleDB.entrySet()) {
            Boolean vehicleEligible = true;
            Integer vehicleID = entry.getKey();
            Vehicle vehicle = entry.getValue();
            for (Integer i = startTime; i <= endTime; i++) {
                if (!this.availabilityDB.get(i).contains(vehicleID)) {
                    vehicleEligible = false;
                    break;
                }
            }

            if (vehicleEligible) {
                if (!available.containsKey(vehicle.getCategory()))
                    available.put(vehicle.getCategory(), new ArrayList<Vehicle>());

                available.get(vehicle.getCategory()).add(vehicle);
            } else {
                if (!unavailable.containsKey(vehicle.getCategory()))
                    unavailable.put(vehicle.getCategory(), new ArrayList<Vehicle>());

                unavailable.get(vehicle.getCategory()).add(vehicle);
            }
        }

        for (Map.Entry<VehicleCategory, List<Vehicle>> entry : available.entrySet()) {
            VehicleCategory key = entry.getKey();
            List<Vehicle> value = entry.getValue();
            System.out.println("Available vehicles of category " + key + " from [" + startTime + ", " + endTime + "]");
            for (int i = 0; i < value.size(); i++) {
                System.out.print(value.get(i).getID());
                System.out.print(" ");
            }
            System.out.println();
        }

        for (Map.Entry<VehicleCategory, List<Vehicle>> entry : unavailable.entrySet()) {
            VehicleCategory key = entry.getKey();
            List<Vehicle> value = entry.getValue();
            System.out
                    .println("Unavailable vehicles of category " + key + " from [" + startTime + ", " + endTime + "]");
            for (int i = 0; i < value.size(); i++) {
                System.out.print(value.get(i).getID());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
