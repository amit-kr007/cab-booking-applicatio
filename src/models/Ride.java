package models;

public class Ride {
    private Rider rider;
    private Driver driver;
    private Location fromLocation;
    private Location toLocation;

    public Ride(Rider rider, Driver driver, Location fromLocation, Location toLocation) {
        this.rider = rider;
        this.driver = driver;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Location fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }
}
