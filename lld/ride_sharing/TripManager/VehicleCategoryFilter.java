package lld.ride_sharing.TripManager;

import java.util.*;

import lld.ride_sharing.Vehicle.Vehicle;
import lld.ride_sharing.Vehicle.VehicleCategory;
import lld.ride_sharing.Vehicle.VehicleManager;

public class VehicleCategoryFilter implements TripFilters {
    private static VehicleCategoryFilter vehicleCategoryFilter;
    public static List<VehicleCategory> eligibleCategories;

    public static VehicleCategoryFilter getVehicleCategoryFilter() {
        if (vehicleCategoryFilter == null) {
            vehicleCategoryFilter = new VehicleCategoryFilter();
        }

        return vehicleCategoryFilter;
    }

    public void addEligibleCategory(VehicleCategory category) {
        eligibleCategories.add(category);
    }

    public Boolean isValidTrip(Trip trip) {
        VehicleManager vm = VehicleManager.getVehicleManager();
        Vehicle vehicle = vm.getVehicle(trip.vehicleID);
        return eligibleCategories.contains(vehicle.getCategory());
    }
}
