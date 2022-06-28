package booking;

import java.util.concurrent.ThreadLocalRandom;

/*
 * Holds all the booking info of the vehicle
 */
class VehicleBookingInfo {
    private Integer VehicleID;
    private Integer StartTime;
    private Integer EndTime;

    public String toString() {
        String bookingInfo = "Vehicle Booking Info: \n";
        bookingInfo += "Vehicle ID: " + this.VehicleID + "\n";
        bookingInfo += "Vehicle start Time: " + this.StartTime + "\n";
        bookingInfo += "Vehicle end Time: " + this.EndTime + "\n";
        return bookingInfo;
    }

    void setVehicleID(Integer vehicleID) {
        this.VehicleID = vehicleID;
    }

    Integer getVehicleID() {
        return this.VehicleID;
    }

    void setStartTime(Integer startTime) {
        this.StartTime = startTime;
    }

    Integer getStartTime() {
        return this.StartTime;
    }

    void setEndTime(Integer endTime) {
        this.EndTime = endTime;
    }

    Integer getEndTime() {
        return this.EndTime;
    }
}

/*
 * Generates a new booking with the information
 * provided
 */
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
        booking += this.vehicleInfo.toString();
        return booking;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public VehicleBookingInfo getVehicleInfo() {
        return vehicleInfo;
    }
}
