package driver;

import exceptions.CreateException;
import exceptions.DriverNotFoundException;
import models.Driver;
import models.Location;
import models.Vehicle;
import services.BookingService;
import services.UserService;

import static enums.Gender.FEMALE;
import static enums.Gender.MALE;

public class DriverMain {
    public static void main(String[] args) {
        UserService userService = UserService.getUserServiceInstance();

        // Register Rider
        try{
            userService.registerRider(1,"Amit",24, MALE);
        } catch (CreateException ex) {
            System.out.println(ex.getMessage());
        }
        try{
            userService.registerRider(2,"Oats",21, FEMALE);
        } catch (CreateException ex) {
            System.out.println(ex.getMessage());
        }
        try{
            userService.registerRider(3,"Amit Kumar",24, MALE);
        } catch (CreateException ex) {
            System.out.println(ex.getMessage());
        }

        // Register Driver
        Location location1 = new Location(1,1);
        Vehicle vehicle1 = new Vehicle(11,"Swift", location1, "0001");

        try{
            userService.registerDriver(1, "vivek", 35, MALE, vehicle1, true);
        } catch (CreateException ex) {
            System.out.println(ex.getMessage());
        }

        Location location2 = new Location(2,2);
        Vehicle vehicle2 = new Vehicle(12,"Swift2", location2, "0002");
        try{
            userService.registerDriver(2, "vikas", 35, MALE, vehicle2, true);
        } catch (CreateException ex) {
            System.out.println(ex.getMessage());
        }

        Location location3 = new Location(3,3);
        Vehicle vehicle3 = new Vehicle(13,"Swift3", location3, "0003");
        try{
            userService.registerDriver(3, "Ravi", 35, MALE, vehicle3, true);
        } catch (CreateException ex) {
            System.out.println(ex.getMessage());
        }

        // Find Ride
        BookingService bookingService = BookingService.getBookingServiceInstance();
        Location source1 = new Location(3, 2);
        Location dest1 = new Location(1, 3);
        try{
            Driver comingDriver = bookingService.bookRide(1,source1, dest1);
            System.out.println(comingDriver.getId());
        } catch (DriverNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        Location source2 = new Location(3, 2);
        Location dest2 = new Location(1, 3);
        try{
            Driver comingDriver2 = bookingService.bookRide(2,source2, dest2);
            System.out.println(comingDriver2.getId());
        } catch (DriverNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        Location source3 = new Location(3, 2);
        Location dest3 = new Location(1, 3);
        try{
            Driver comingDriver3 = bookingService.bookRide(2,source3, dest3);
            System.out.println(comingDriver3.getId());
        } catch (DriverNotFoundException ex) {
            System.out.println(ex.getMessage());
        }


        Location source4 = new Location(3, 2);
        Location dest4 = new Location(1, 3);
        try{
            Driver comingDriver4 = bookingService.bookRide(3,source4, dest4);
            System.out.println(comingDriver4 == null);
        } catch (DriverNotFoundException ex) {
            System.out.println(ex.getMessage());
        }


//        System.out.println(userService.getDriverMap().get(3).isAvailable());


    }
}
