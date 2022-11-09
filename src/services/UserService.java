package services;

import enums.Gender;
import exceptions.CreateException;
import models.Driver;
import models.Rider;
import models.Vehicle;

import java.util.HashMap;

public class UserService  {

    public static UserService userService = null;
    private HashMap<Integer, Rider> riderMap = new HashMap<>();
    private HashMap<Integer, Driver> driverMap = new HashMap<>();
    private HashMap<Integer, Vehicle> vehicalMap = new HashMap<>();

    public UserService() {
    }

    public static UserService getUserServiceInstance() {
        if(userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public HashMap<Integer, Rider> getRiderMap() {
        return riderMap;
    }

    public void setRiderMap(HashMap<Integer, Rider> riderMap) {
        this.riderMap = riderMap;
    }

    public HashMap<Integer, Driver> getDriverMap() {
        return driverMap;
    }

    public void setDriverMap(HashMap<Integer, Driver> driverMap) {
        this.driverMap = driverMap;
    }

    public HashMap<Integer, Vehicle> getVehicalMap() {
        return vehicalMap;
    }

    public void setVehicalMap(HashMap<Integer, Vehicle> vehicalMap) {
        this.vehicalMap = vehicalMap;
    }



    public Rider registerRider(int id, String name, int age, Gender gender) throws CreateException {
        Rider rider = new Rider(id,name,age,gender);
        if(!riderMap.containsKey(id)) {
            riderMap.put(id,rider);
            return rider;
        } else {
            throw new CreateException("Rider already present");
        }
    }


    public Driver registerDriver(int id, String name, int age, Gender gender, Vehicle vehical, boolean isAvailable) throws CreateException {
        Driver driver = new Driver(id, name, age, gender, vehical, isAvailable);
        if(!driverMap.containsKey(id)) {
            driverMap.put(id, driver);
            return driver;
        } else {
            throw new CreateException("Driver already present");
        }
    }
}
