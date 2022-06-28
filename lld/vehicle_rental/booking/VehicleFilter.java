package booking;

import java.util.*;

import branch.Branch;
import branch.BranchManager;
import vehicle.*;

/*
 * Holds filters which can be applied while booking
 * Can hold new filters for future usecases
 */
public class VehicleFilter {
    public enum Filter {
        LowestRentalPrice
    }

    public static List<Vehicle> filter(List<Vehicle> vehicles, Filter filter, VehicleCategory category) {
        List<Vehicle> selectedVehicles = new ArrayList<Vehicle>();

        switch (filter) {
            case LowestRentalPrice: {
                Integer minPrice = Integer.MAX_VALUE;
                for (int i = 0; i < vehicles.size(); i++) {
                    Vehicle vehicle = vehicles.get(i);
                    if(vehicle.getCategory()!=category)
                        continue;

                    Branch b = BranchManager.getBranchManager().getBranch(vehicle.getBranch());
                    Integer price = b.getVehicleCategoryPrice(vehicle.getCategory());

                    if (minPrice > price) {
                        selectedVehicles.clear();
                        minPrice = price;
                        selectedVehicles.add(vehicle);
                    } else if (minPrice == price) {
                        selectedVehicles.add(vehicle);
                    }
                }

                break;
            }
        }

        return selectedVehicles;
    }
}
