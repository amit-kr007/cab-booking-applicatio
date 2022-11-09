package models;

import enums.Gender;

public class Driver extends User{
    private Vehicle vehical;
    private boolean isAvailable;

    public Driver(int id, String name, int age, Gender gender, Vehicle vehical, boolean isAvailable) {
        super(id, name, age, gender);
        this.vehical = vehical;
        this.isAvailable = isAvailable;
    }

    public Vehicle getVehical() {
        return vehical;
    }

    public void setVehical(Vehicle vehical) {
        this.vehical = vehical;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
