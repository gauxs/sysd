package lld.ride_sharing.User;

import java.util.*;

import lld.ride_sharing.Location.Location;
import lld.ride_sharing.TripManager.Trip;
import lld.ride_sharing.TripManager.TripFilters;
import lld.ride_sharing.TripManager.TripManager;
import lld.ride_sharing.TripManager.VehicleSelectionStrategy;
import lld.ride_sharing.Vehicle.*;

public class User {
    private String name;
    private List<Integer> vehicles;

    User(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getVehicles() {
        return vehicles;
    }

    public void registerVehicle(Integer vehicleID, VehicleCategory category, Integer numOfSeats) {
        VehicleManager.getVehicleManager().addVehicle(this.name, vehicleID, numOfSeats,
                category);
        this.vehicles.add(vehicleID);
    }

    public Trip offerRide(Location source, Location destination, Integer vehicleID) {
        TripManager tm = TripManager.getTripManager();

        // user ineligible if already in a trip
        if (tm.canOfferTrip(this.name)) {
            // generate a trip
            return tm.createTrip(source, destination, vehicleID, this.name);
        }

        return null;
    }

    public void endRide(Trip trip) {
        // trip manager will end this trip
        TripManager tm = TripManager.getTripManager();
        tm.clearTrip(trip);
    }

    public List<Trip> selectRide(Location source, Location destination, Integer numOfSeats, TripFilters filter) {
        if (numOfSeats > 2)
            return null;

        TripManager tm = TripManager.getTripManager();

        // trip manager will send all the eligible trips
        List<Trip> myTrip = tm.showTrips(source, destination, numOfSeats, filter,
                VehicleSelectionStrategy.MostVacantSeats);

        // use create trip and reduce available seats
        tm.joinTrip(myTrip, this.name);

        return myTrip;
    }
}