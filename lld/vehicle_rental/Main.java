package lld.vehicle_rental;

import java.util.*;
import lld.vehicle_rental.branch.*;
import lld.vehicle_rental.booking.*;
import lld.vehicle_rental.vehicle.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Vehicle Rental System 1.0");

        VehicleManager vehicleM = VehicleManager.getVehicleManager();
        BranchManager branchM = BranchManager.getBranchManager();

        // adding 3 branches
        Integer branch1ID = branchM.addBranch("Branch1");
        branchM.updateVehicleCategoryPrice(branch1ID, VehicleCategory.HATCHBACK, 10);
        branchM.updateVehicleCategoryPrice(branch1ID, VehicleCategory.SEDAN, 20);
        branchM.updateVehicleCategoryPrice(branch1ID, VehicleCategory.SUV, 30);

        Integer branch2ID = branchM.addBranch("Branch2");
        branchM.updateVehicleCategoryPrice(branch2ID, VehicleCategory.HATCHBACK, 15);
        branchM.updateVehicleCategoryPrice(branch2ID, VehicleCategory.SEDAN, 25);
        branchM.updateVehicleCategoryPrice(branch2ID, VehicleCategory.SUV, 35);

        Integer branch3ID = branchM.addBranch("Branch3");
        branchM.updateVehicleCategoryPrice(branch3ID, VehicleCategory.HATCHBACK, 20);
        branchM.updateVehicleCategoryPrice(branch3ID, VehicleCategory.SEDAN, 30);
        branchM.updateVehicleCategoryPrice(branch3ID, VehicleCategory.SUV, 40);

        // adding 6 cars, 2 in each branches
        Integer vehicle1ID = vehicleM.addVehicle(VehicleCategory.HATCHBACK, branch1ID);
        Integer vehicle2ID = vehicleM.addVehicle(VehicleCategory.SEDAN, branch1ID);
        Integer vehicle3ID = vehicleM.addVehicle(VehicleCategory.SUV, branch2ID);
        Integer vehicle4ID = vehicleM.addVehicle(VehicleCategory.HATCHBACK, branch2ID);
        Integer vehicle5ID = vehicleM.addVehicle(VehicleCategory.SEDAN, branch3ID);
        Integer vehicle6ID = vehicleM.addVehicle(VehicleCategory.SUV, branch3ID);

        branchM.addVehicle(branch1ID, vehicle1ID);
        branchM.addVehicle(branch1ID, vehicle2ID);

        branchM.addVehicle(branch2ID, vehicle3ID);
        branchM.addVehicle(branch2ID, vehicle4ID);

        branchM.addVehicle(branch3ID, vehicle5ID);
        branchM.addVehicle(branch3ID, vehicle6ID);

        System.out.println(branchM.getBranch(branch1ID));
        System.out.println(branchM.getBranch(branch2ID));
        System.out.println(branchM.getBranch(branch3ID));

        // booking
        System.out.println(BookingManager.bookVehicle(1, 2, VehicleCategory.HATCHBACK));
        vehicleM.getOverview(0, 0);

    }
}