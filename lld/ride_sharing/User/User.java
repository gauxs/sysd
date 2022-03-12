package lld.ride_sharing.User;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import lld.ride_sharing.Location.Location;
import lld.ride_sharing.TripManager.Trip;
import lld.ride_sharing.TripManager.TripManager;
import lld.ride_sharing.Vehicle.*;

public class User {
    String name;
    Integer userID;
    List<Integer> vehicles;

    User(String name) {
        this.name = name;
        this.userID = ThreadLocalRandom.current().nextInt(1, 100);
        this.vehicles = new ArrayList<>();
    }

    void registerVehicle(VehicleCategory category, Integer numOfSeats) {
        VehicleManager vm = VehicleManager.getVehicleManager();
        Integer newVehicleID = vm.addVehicle(this.userID, numOfSeats, category);
        this.vehicles.add(newVehicleID);
    }

    Trip offerRide(Location source, Location destination, Integer vehicleID) {
        TripManager tm = TripManager.getTripManager();

        // user ineligible if already in a trip
        if (tm.canOfferTrip(this.userID)) {
            // generate a trip
            return tm.createTrip(source, destination, vehicleID, this.userID);
        }

        return null;
    }

    void endRide(Trip trip) {
        // trip manager will end this trip
    }

    void selectRide() {
        // trip manager will send all the eligible trips
        // select on the basis of criteria
    }
}