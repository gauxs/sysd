package lld.ride_sharing;

import java.util.List;
import java.util.Scanner;

import lld.ride_sharing.Location.Location;
import lld.ride_sharing.TripManager.*;
import lld.ride_sharing.User.User;
import lld.ride_sharing.User.UserManager;
import lld.ride_sharing.Vehicle.VehicleCategory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ride Sharing 1.0");

        UserManager um = UserManager.getUserManager();
        TripFilters tf = new VehicleCategoryFilter(VehicleCategory.HATCHBACK, VehicleCategory.SEDAN,
                VehicleCategory.SUV);
        Scanner in = new Scanner(System.in);

        while (true) {
            switch (in.next()) {
                case "ADDU": {
                    um.addUser(in.next());
                    break;
                }
                case "ADDV": {
                    User u = um.getUser(in.next());
                    u.registerVehicle(in.nextInt(), VehicleCategory.valueOf(in.next()), in.nextInt());
                    break;
                }
                case "OFFER": {
                    User u = um.getUser(in.next());
                    u.offerRide(Location.valueOf(in.next()), Location.valueOf(in.next()), in.nextInt());
                    break;
                }
                case "BOOK": {
                    User u = um.getUser(in.next());
                    List<Trip> trips = u.selectRide(Location.valueOf(in.next()), Location.valueOf(in.next()),
                            in.nextInt(), tf);
                    for (Trip t : trips) {
                        System.out.println(t);
                    }
                    break;
                }
            }
        }

        // closing scanner
        // in.close();
    }
}
