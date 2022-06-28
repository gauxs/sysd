// package main;

import branch.*;
import exceptions.BookingException;
import booking.*;
import vehicle.*;

public class Main {
    private void TestcaseI(){
        System.out.println("Testcase-I");
        VehicleManager vehicleM = VehicleManager.getVehicleManager();
        BranchManager branchM = BranchManager.getBranchManager();

        // adding 3 branches
        Integer branch1ID = branchM.addBranch("Branch1");
        branchM.allocatePrice(branch1ID, VehicleCategory.HATCHBACK, 10);
        branchM.allocatePrice(branch1ID, VehicleCategory.SEDAN, 20);
        branchM.allocatePrice(branch1ID, VehicleCategory.SUV, 30);

        Integer branch2ID = branchM.addBranch("Branch2");
        branchM.allocatePrice(branch2ID, VehicleCategory.HATCHBACK, 15);
        branchM.allocatePrice(branch2ID, VehicleCategory.SEDAN, 25);
        branchM.allocatePrice(branch2ID, VehicleCategory.SUV, 35);

        Integer branch3ID = branchM.addBranch("Branch3");
        branchM.allocatePrice(branch3ID, VehicleCategory.HATCHBACK, 20);
        branchM.allocatePrice(branch3ID, VehicleCategory.SEDAN, 30);
        branchM.allocatePrice(branch3ID, VehicleCategory.SUV, 40);

        // adding 6 cars, 2 in each branches
        Integer vehicle1ID = vehicleM.addVehicle(VehicleCategory.HATCHBACK, branch1ID);
        Integer vehicle2ID = vehicleM.addVehicle(VehicleCategory.SEDAN, branch1ID);
        Integer vehicle3ID = vehicleM.addVehicle(VehicleCategory.SUV, branch2ID);
        Integer vehicle4ID = vehicleM.addVehicle(VehicleCategory.HATCHBACK, branch2ID);
        Integer vehicle5ID = vehicleM.addVehicle(VehicleCategory.SEDAN, branch3ID);
        Integer vehicle6ID = vehicleM.addVehicle(VehicleCategory.SUV, branch3ID);

        System.out.println(branchM.getBranch(branch1ID));
        System.out.println(branchM.getBranch(branch2ID));
        System.out.println(branchM.getBranch(branch3ID));

        // booking
        try {
            System.out.println(BookingManager.bookVehicle(1, 2, VehicleCategory.HATCHBACK));
        }catch(BookingException bookExp){
            System.out.println(bookExp);
        }
        
        vehicleM.viewVehicleInventory(0, 0);
    }

    private void TestcaseII(){
        System.out.println("Testcase-II");
        VehicleManager vehicleM = VehicleManager.getVehicleManager();
        BranchManager branchM = BranchManager.getBranchManager();

        // adding 3 branches
        Integer vasanthVihar = branchM.addBranch("Vasanth Vihar");
        branchM.allocatePrice(vasanthVihar, VehicleCategory.SEDAN, 100);
        branchM.allocatePrice(vasanthVihar, VehicleCategory.HATCHBACK, 80);

        Integer cyberCity = branchM.addBranch("Cyber City");
        branchM.allocatePrice(cyberCity, VehicleCategory.SEDAN, 200);
        branchM.allocatePrice(cyberCity, VehicleCategory.HATCHBACK, 50);

        Integer vehicle1ID = vehicleM.addVehicle(VehicleCategory.SEDAN, vasanthVihar);
        Integer vehicle2ID = vehicleM.addVehicle(VehicleCategory.HATCHBACK, cyberCity);
        Integer vehicle3ID = vehicleM.addVehicle(VehicleCategory.SEDAN, cyberCity);

        System.out.println(branchM.getBranch(vasanthVihar));
        System.out.println(branchM.getBranch(cyberCity));

        vehicleM.describeAllVehicles();

        // booking
        try {
            System.out.println(BookingManager.bookVehicle(2, 3, VehicleCategory.SEDAN));
        }catch(BookingException bookExp){
            System.out.println(bookExp);
        }

        try {
            System.out.println(BookingManager.bookVehicle(2, 3, VehicleCategory.SEDAN));
        }catch(BookingException bookExp){
            System.out.println(bookExp);
        }
        
        vehicleM.viewVehicleInventory(2, 3);
        
        try {
            System.out.println(BookingManager.bookVehicle(2, 3, VehicleCategory.SEDAN));
        }catch(BookingException bookExp){
            System.out.println(bookExp);
        }
    }

    private void TestcaseIII(){
        System.out.println("Testcase-III");
        VehicleManager vehicleM = VehicleManager.getVehicleManager();
        BranchManager branchM = BranchManager.getBranchManager();

        // adding 3 branches
        Integer vasanthVihar = branchM.addBranch("Vasanth Vihar");
        branchM.allocatePrice(vasanthVihar, VehicleCategory.SEDAN, 100);
        branchM.allocatePrice(vasanthVihar, VehicleCategory.HATCHBACK, 80);

        Integer cyberCity = branchM.addBranch("Cyber City");
        branchM.allocatePrice(cyberCity, VehicleCategory.SEDAN, 200);
        branchM.allocatePrice(cyberCity, VehicleCategory.HATCHBACK, 50);

        Integer vehicle1ID = vehicleM.addVehicle(VehicleCategory.SEDAN, vasanthVihar);
        Integer vehicle2ID = vehicleM.addVehicle(VehicleCategory.HATCHBACK, cyberCity);
        Integer vehicle3ID = vehicleM.addVehicle(VehicleCategory.SEDAN, cyberCity);

        System.out.println(branchM.getBranch(vasanthVihar));
        System.out.println(branchM.getBranch(cyberCity));

        vehicleM.describeAllVehicles();

        // booking
        try {
            System.out.println(BookingManager.bookVehicle(0, 1, VehicleCategory.HATCHBACK));
        }catch(BookingException bookExp){
            System.out.println(bookExp);
        }

        try {
            System.out.println(BookingManager.bookVehicle(1, 2, VehicleCategory.HATCHBACK));
        }catch(BookingException bookExp){
            System.out.println(bookExp);
        }
        
        vehicleM.viewVehicleInventory(2, 3);
        
        try {
            System.out.println(BookingManager.bookVehicle(1, 2, VehicleCategory.HATCHBACK));
        }catch(BookingException bookExp){
            System.out.println(bookExp);
        }
    }

    /* 
     * Drawbacks:
     * 1 - Time is assumed to be of type Integer representing only hours of a single day
     *     thus, interday bookings will not work
     * 2 - Tried implementing(partially implemented) segment tree to answer availability queries in a more
     *     optimal way, hence reveted back to more straightforward approach
     */
    public static void main(String[] args) {
        System.out.println("Vehicle Rental System 1.0");
        Main driver = new Main();
        driver.TestcaseIII();
    }
}
