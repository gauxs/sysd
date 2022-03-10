package lld.vehicle_rental.booking;

import java.util.*;
import java.time.*;
import java.util.concurrent.ThreadLocalRandom;

class VehicleBookingInfo {
    private Integer VehicleID;
    private LocalDate StartTime;
    private LocalDate EndTime;

    public void setVehicleID(Integer vehicleID) {
        VehicleID = vehicleID;
    }

    public Integer getVehicleID() {
        return VehicleID;
    }

    public void setStartTime(LocalDate startTime) {
        StartTime = startTime;
    }

    public LocalDate getStartTime() {
        return StartTime;
    }

    public void setEndTime(LocalDate endTime) {
        EndTime = endTime;
    }

    public LocalDate getEndTime() {
        return EndTime;
    }
}

public class Booking {
    private Integer bookingID;
    private VehicleBookingInfo vehicleInfo;

    Booking(Integer vehicleID, LocalDate startTime, LocalDate endTime) {
        this.bookingID = ThreadLocalRandom.current().nextInt(1001, 10000000 + 1);
        this.vehicleInfo = new VehicleBookingInfo();
        this.vehicleInfo.setVehicleID(vehicleID);
        this.vehicleInfo.setStartTime(startTime);
        this.vehicleInfo.setEndTime(endTime);
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public VehicleBookingInfo getVehicleInfo() {
        return vehicleInfo;
    }
}
