package booking;

import java.util.*;
import vehicle.*;
import exceptions.*;

/*
 * Holds filter for booking
 * Facilitates booking
 */
public class BookingManager {
    public static Booking bookVehicle(Integer startTime, Integer endTime, VehicleCategory category) throws BookingException{
        // get all vehicles from Inventory
        VehicleManager vm = VehicleManager.getVehicleManager();
        List<Vehicle> vehicles = vm.getAvailaibility(startTime, endTime);

        // filter vehicles
        List<Vehicle> filteredVehicles = VehicleFilter.filter(vehicles, VehicleFilter.Filter.LowestRentalPrice, category);

        // select a vehicle based on filter
        if(filteredVehicles.size()==0)
            throw new BookingException("No vehicle of type "+ category + " availaible!!");

        Vehicle choosenVehicle = filteredVehicles.get(0);

        // update Inventory and block time slot for this vehicle
        vm.blockVehicle(choosenVehicle.getID(), startTime, endTime);

        // create a new booking
        Booking booking = new Booking(choosenVehicle.getID(), startTime, endTime);

        return booking;
    }
}
