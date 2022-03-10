package lld.vehicle_rental.booking;

import java.util.*;

import lld.vehicle_rental.branch.Branch;
import lld.vehicle_rental.branch.BranchManager;
import lld.vehicle_rental.vehicle.*;

public class VehicleFilter {
    public enum Filter {
        LowestRentalPrice
    }

    public static List<Vehicle> filter(List<Vehicle> vehicles, Filter filter) {
        List<Vehicle> selectedVehicles = new ArrayList<Vehicle>();

        switch (filter) {
            case LowestRentalPrice: {
                Integer minPrice = Integer.MAX_VALUE;
                for (int i = 0; i < vehicles.size(); i++) {
                    Branch b = BranchManager.getBranchManager().getBranch(vehicles.get(i).getBranch());
                    Integer price = b.getVehicleCategoryPrice(vehicles.get(i).getCategory());

                    if (minPrice > price) {
                        selectedVehicles.clear();
                        minPrice = price;
                        selectedVehicles.add(vehicles.get(i));
                    } else if (minPrice == price) {
                        selectedVehicles.add(vehicles.get(i));
                    }
                }

                break;
            }
        }

        return selectedVehicles;
    }
}
