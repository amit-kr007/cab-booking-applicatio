package models;

import enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Rider extends User{
    Location currentSource;
    Location currentDestination;

    public List<Ride> getRideList() {
        return rideList;
    }

    public void setRideList(List<Ride> rideList) {
        this.rideList = rideList;
    }

    private List<Ride> rideList = new ArrayList<Ride>();



    public Rider(int id, String name, int age, Gender gender) {
        super(id, name, age, gender);
    }

    public Location getCurrentSource() {
        return currentSource;
    }

    public void setCurrentSource(Location currentSource) {
        this.currentSource = currentSource;
    }

    public Location getCurrentDestination() {
        return currentDestination;
    }

    public void setCurrentDestination(Location currentDestination) {
        this.currentDestination = currentDestination;
    }


}
