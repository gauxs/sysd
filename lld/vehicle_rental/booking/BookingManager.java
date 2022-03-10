package lld.vehicle_rental.booking;

import java.util.*;
import java.time.*;
import lld.vehicle_rental.vehicle.*;

public class BookingManager {
    public Booking bookVehicle(LocalDate startTime, LocalDate endTime, VehicleCategory category) {
        // get all vehicles from Inventory
        VehicleManager vm = VehicleManager.getVehicleManager();
        List<Vehicle> vehicles = vm.getAvailaibility(startTime, endTime);

        // filter vehicles
        List<Vehicle> filteredVehicles = VehicleFilter.filter(vehicles, VehicleFilter.Filter.LowestRentalPrice);

        // select a vehicle based on filter
        Vehicle choosenVehicle = filteredVehicles.get(0);

        // update Inventory and block time slot for this vehicle
        vm.blockVehicle(choosenVehicle.getID(), startTime, endTime);

        // create a new booking
        Booking b = new Booking(choosenVehicle.getID(), startTime, endTime);

        return b;
    }
}
