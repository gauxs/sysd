package lld.vehicle_rental.booking;

import java.util.concurrent.ThreadLocalRandom;

class VehicleBookingInfo {
    private Integer VehicleID;
    private Integer StartTime;
    private Integer EndTime;

    public void setVehicleID(Integer vehicleID) {
        VehicleID = vehicleID;
    }

    public Integer getVehicleID() {
        return VehicleID;
    }

    public void setStartTime(Integer startTime) {
        StartTime = startTime;
    }

    public Integer getStartTime() {
        return StartTime;
    }

    public void setEndTime(Integer endTime) {
        EndTime = endTime;
    }

    public Integer getEndTime() {
        return EndTime;
    }
}

public class Booking {
    private Integer bookingID;
    private VehicleBookingInfo vehicleInfo;

    Booking(Integer vehicleID, Integer startTime, Integer endTime) {
        this.bookingID = ThreadLocalRandom.current().nextInt(1001, 10000000 + 1);
        this.vehicleInfo = new VehicleBookingInfo();
        this.vehicleInfo.setVehicleID(vehicleID);
        this.vehicleInfo.setStartTime(startTime);
        this.vehicleInfo.setEndTime(endTime);
    }

    public String toString() {
        String booking = "Booking Info\n";
        booking += "Booking ID: " + this.bookingID + "\n";
        booking += "Vehicle ID: " + this.vehicleInfo.getVehicleID() + "\n";
        booking += "Vehicle start Time: " + this.vehicleInfo.getStartTime() + "\n";
        booking += "Vehicle end Time: " + this.vehicleInfo.getEndTime() + "\n";
        return booking;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public VehicleBookingInfo getVehicleInfo() {
        return vehicleInfo;
    }
}
