package lld.ride_sharing.TripManager;

import java.util.*;

import lld.ride_sharing.Vehicle.Vehicle;
import lld.ride_sharing.Vehicle.VehicleCategory;
import lld.ride_sharing.Vehicle.VehicleManager;

public class VehicleCategoryFilter implements TripFilters {
    private List<VehicleCategory> eligibleCategories;

    public VehicleCategoryFilter(VehicleCategory... categories) {
        this.eligibleCategories = new ArrayList<>();
        for (int i = 0; i < categories.length; i++) {
            this.eligibleCategories.add(categories[i]);
        }
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
