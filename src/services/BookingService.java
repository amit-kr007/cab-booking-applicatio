package services;

import exceptions.DriverNotFoundException;
import models.Driver;
import models.Location;
import models.Ride;
import models.Rider;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private UserService userService = null;
    private static BookingService bookingService = null;

    public static BookingService getBookingServiceInstance() {
        if(bookingService == null) {
            bookingService = new BookingService();
        }
        return bookingService;
    }



    public Driver bookRide(int riderId, Location source, Location destination) throws DriverNotFoundException{
        Rider rider = UserService.getUserServiceInstance().getRiderMap().get(riderId);
        List<Driver> drivers = getAvailableDriver();
        //System.out.println("available drivers" + drivers.size());
        if(drivers != null && drivers.size() > 0) {
            double min = Double.MAX_VALUE;
            int minIndex = 0;
            for(int index=0;index<drivers.size();index++) {
//                System.out.println("sx"+ source.getX()+ "sy"+source.getY()+"dx"+drivers.get(index).getVehical().getLocation().getY()+
//                        "dy"+drivers.get(index).getVehical().getLocation().getX());
                double dist = distance(drivers.get(index).getVehical().getLocation(), source);
//                System.out.println("distance" + dist);
                if( dist < min) {
                    min = dist;
                    minIndex = index;
                }
            }
            Driver nearestDriver = drivers.get(minIndex);
            nearestDriver.setAvailable(false);
            Ride ride = new Ride(rider, nearestDriver, source, destination );
            rider.getRideList().add(ride);
            return nearestDriver;
        } else {
            throw new DriverNotFoundException("Driver Not available");
        }
    }

    public double distance(Location source, Location dest) {
//        System.out.println("sx"+ source.getX()+ "sy"+source.getY()+"dx"+dest.getY()+
//                "dy"+dest.getX());
//        System.out.println(Math.pow(dest.getY() - source.getY(),2));
//        System.out.println(Math.pow(dest.getY() - source.getY(),2) - Math.pow(dest.getX() - source.getX(),2));
        double dist = Math.sqrt(Math.abs(Math.pow(dest.getY() - source.getY(),2) - Math.pow(dest.getX() - source.getX(),2)));
//                System.out.println("distance" + dist);
        return dist;
    }


    public List<Driver> getAvailableDriver() {
        this.userService = UserService.getUserServiceInstance();
        List<Driver> drivers = new ArrayList<>();
        this.userService.getDriverMap().values().forEach(driver -> {
            if(driver.isAvailable()) {
                drivers.add(driver);
            }
        });
        return drivers;
    }
}
