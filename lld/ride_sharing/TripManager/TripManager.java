package lld.ride_sharing.TripManager;

import java.util.*;

import lld.ride_sharing.Location.Location;
import lld.ride_sharing.Vehicle.Vehicle;
import lld.ride_sharing.Vehicle.VehicleManager;

public class TripManager {
    private static TripManager tripManager;
    public static HashMap<Location, List<Trip>> trips = new HashMap<>();
    public static HashMap<String, Integer> usersInTrip = new HashMap<>();

    public static TripManager getTripManager() {
        if (tripManager == null) {
            tripManager = new TripManager();
        }

        return tripManager;
    }

    public Boolean canOfferTrip(String userName) {
        Integer vehicleID = usersInTrip.get(userName);
        return vehicleID == null;
    }

    public Trip createTrip(Location source, Location destination, Integer vehicleID, String userName) {
        VehicleManager vm = VehicleManager.getVehicleManager();
        Vehicle vehicle = vm.getVehicle(vehicleID);

        Trip trip = new Trip(source, destination, userName, vehicleID, vehicle.getNumberOfSeats());

        // add this trip to trips
        List<Trip> tripsFromSource = trips.get(source);
        if (tripsFromSource == null) {
            tripsFromSource = new ArrayList<>();
            trips.put(source, tripsFromSource);
        }
        tripsFromSource.add(trip);

        // mark user in-trip
        usersInTrip.put(userName, vehicleID);
        return trip;
    }

    // usersInTrip holds all the drivers userID and not passengerIDs
    // TODO: passenger can offer/join ride if they are already in a trips
    public void joinTrip(List<Trip> trips, String userName) {
        for (Trip t : trips) {
            t.addPassenger(userName);
        }
    }

    public void clearTrip(Trip trip) {
        List<Trip> tripsFromSource = trips.get(trip.source);
        for (int i = 0; i < tripsFromSource.size(); i++) {
            if (tripsFromSource.get(i).driverName == trip.driverName) {
                if (tripsFromSource.remove(i) != null) {
                    usersInTrip.remove(trip.driverName);
                }
            }
        }
    }

    private List<List<Trip>> searchTrips(Location source, Location destination, Integer numOfSeats, TripFilters filter,
            VehicleSelectionStrategy strategy) {
        List<List<Trip>> ret = new ArrayList<>();

        List<Trip> tripsFromSource = trips.get(source);
        for (int i = 0; i < tripsFromSource.size(); i++) {
            if ((filter == null || filter.isValidTrip(tripsFromSource.get(i)))
                    && tripsFromSource.get(i).availableSeats >= numOfSeats) {
                if (tripsFromSource.get(i).destination == destination) {
                    List<Trip> myTrip = new ArrayList<>();
                    myTrip.add(tripsFromSource.get(i));
                    ret.add(myTrip);
                } else {
                    List<List<Trip>> myTrips = searchTrips(tripsFromSource.get(i).destination, destination, numOfSeats,
                            filter, strategy);
                    for (List<Trip> ts : myTrips) {
                        ts.add(tripsFromSource.get(i));
                        ret.add(ts);
                    }
                }
            }
        }

        return ret;
    }

    public List<Trip> showTrips(Location source, Location destination, Integer numOfSeats, TripFilters filter,
            VehicleSelectionStrategy strategy) {
        List<List<Trip>> ret = searchTrips(source, destination, numOfSeats, filter, strategy);

        if (ret == null)
            return null;

        // selection strategy
        switch (strategy) {
            case MostVacantSeats: {
                Integer mostVacantSeatTrip = -1;
                Integer mostVacantSeatTripIndex = -1;
                for (Integer i = 0; i < ret.size(); i++) {
                    Integer maxVacantSeat = -1;
                    for (Integer j = 0; j < ret.get(i).size(); j++) {
                        maxVacantSeat = Math.max(maxVacantSeat, ret.get(i).get(j).availableSeats);
                    }

                    if (mostVacantSeatTrip < maxVacantSeat) {
                        mostVacantSeatTrip = maxVacantSeat;
                        mostVacantSeatTripIndex = i;
                    }
                }

                return ret.get(mostVacantSeatTripIndex);
            }
        }

        return null;
    }
}
