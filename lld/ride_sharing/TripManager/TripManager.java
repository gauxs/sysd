package lld.ride_sharing.TripManager;

import java.util.*;

import lld.ride_sharing.Location.Location;

public class TripManager {
    private static TripManager tripManager;
    public static HashMap<Location, List<Trip>> trips = new HashMap<>();
    public static HashMap<Integer, Integer> usersInTrip = new HashMap<>();

    public static TripManager getTripManager() {
        if (tripManager == null) {
            tripManager = new TripManager();
        }

        return tripManager;
    }

    public Boolean canOfferTrip(Integer userID) {
        Integer vehicleID = usersInTrip.get(userID);
        return vehicleID == null;
    }

    public Trip createTrip(Location source, Location destination, Integer vehicleID, Integer userID) {
        Trip trip = new Trip(source, destination, userID, vehicleID);

        // add this trip to trips
        List<Trip> tripsFromSource = trips.get(source);
        if (tripsFromSource == null)
            tripsFromSource = new ArrayList<>();
        tripsFromSource.add(trip);

        // mark user in-trip
        usersInTrip.put(userID, vehicleID);

        return trip;
    }

    void clearTrip(Trip trip) {
        List<Trip> tripsFromSource = trips.get(trip.source);
        for (int i = 0; i < tripsFromSource.size(); i++) {
            if (tripsFromSource.get(i).driverUserID == trip.driverUserID) {
                if (tripsFromSource.remove(i) != null) {
                    usersInTrip.remove(trip.driverUserID);
                }
            }
        }
    }

    List<List<Trip>> searchTrips(Location source, Location destination, TripFilters filter, Integer numOfSeats) {
        List<List<Trip>> ret = new ArrayList<>();

        List<Trip> tripsFromSource = trips.get(source);
        for (int i = 0; i < tripsFromSource.size(); i++) {
            if (filter.isValidTrip(tripsFromSource.get(i))) {
                // TODO: filter on basis of seats too
                // use create trip and reduce available seats
                if (tripsFromSource.get(i).destination == destination) {
                    List<Trip> myTrip = new ArrayList<>();
                    myTrip.add(tripsFromSource.get(i));
                    ret.add(myTrip);
                } else {
                    List<List<Trip>> myTrips = searchTrips(source, destination, filter, numOfSeats);
                    for (List<Trip> ts : myTrips) {
                        ts.add(tripsFromSource.get(i));
                        ret.add(ts);
                    }
                }
            }

        }

        return ret;
    }
}
