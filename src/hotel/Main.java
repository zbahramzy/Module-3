package hotel;
import employees.Staff;
import employees.StaffAccountant;
import employees.StaffCleaningLady;
import employees.StaffDirector;
import employees.StaffReceptionist;
import employees.StaffUser;
import rooms.RoomDoubleBed;
import rooms.RoomOneBed;
import rooms.RoomSuite;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;

public class Main {
    // Writes an object to a .ser file
    public static void serialize(Hotel data, String fileName) {
        try {
            // Create a file
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
            //System.out.println("Serialized data is saved in " + fileName);
        } catch (IOException i) {
            System.out.println("error!");
            i.printStackTrace();
        }
        //return fileName;
    }

    // Reads an object from a .ser file
    public static Hotel deSerialize(String fileName) {
        Hotel f1;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            f1 = (Hotel) in.readObject(); // type casting
            in.close();
            fileIn.close();
        } catch (FileNotFoundException f) {
            System.out.println("No such file or directory!");
            f.printStackTrace();
            return null;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Application class not found!");
            c.printStackTrace();
            return null;
        }
        //System.out.println(f1);
        //System.out.println("Deserialized plex...");
        /*
        System.out.println("Employees in Hotel Plaza:\n");
        for (Staff currentStaff: f1.getListOfStaff()) {
            System.out.println(currentStaff);
        }
        */
        return f1;
    }

    public static void main(String[] args) {
        // The Hotel Plaza object containing staff objects and room objects that can contain guest objects
        Hotel hotelPlaza = new Hotel("The Plaza Hotel");
        UserInterface menu = new UserInterface();
        Staff loggedInEmployee = null;                  // need this to know which staff user is logged in
        //Scanner inputString = new Scanner(System.in);   // need this when taking a string input from

        /*
        // Create 4 staff objects
        StaffAccountant accountant = new StaffAccountant("Accountant", "Peter", "Jonson", 13563463, 26000);
        StaffCleaningLady cleaningLady = new StaffCleaningLady("Housekeeper Executive","Lisa","Hansen",12345678,13000);
        StaffDirector director = new StaffDirector("Director","Erica","Malissa",87654321,45000, "admin", "admin");
        StaffReceptionist receptionist = new StaffReceptionist("Receptionist","Michael","Myers",13572468,19000, "mich", "mich");

        // Add these 4 employees to listOfStaff in hotel
        hotelPlaza.getListOfStaff().add(accountant);
        hotelPlaza.getListOfStaff().add(cleaningLady);
        hotelPlaza.getListOfStaff().add(director);
        hotelPlaza.getListOfStaff().add(receptionist);

        RoomSuite roomSuite1 = new RoomSuite(13 ,3,2, 1500.00,
                true, true, true, true, true, true, true, true, true, true);
        RoomSuite roomSuite2 = new RoomSuite( 23,3,2, 1000.00,
                false, false, true, true, false, true, false, false, true, false);

        RoomDoubleBed roomDoubleBed1 = new RoomDoubleBed(12,2,2, 850.00,
                true, true, true, true, true, true, true);
        RoomDoubleBed roomDoubleBed2 = new RoomDoubleBed(22,2, 2, 750.00,
                false, false, true, false, false, false, true);

        RoomOneBed roomOneBed1 = new RoomOneBed(11,1,1, 500.00,
                true, true, true, true, true);
        RoomOneBed roomOneBed2 = new RoomOneBed(21,1,1, 450.00,
                false, false, false, false, true);

        // Add these 6 rooms to listOfStaff in hotel
        hotelPlaza.getListOfRooms().add(roomSuite1);
        hotelPlaza.getListOfRooms().add(roomSuite2);
        hotelPlaza.getListOfRooms().add(roomOneBed1);
        hotelPlaza.getListOfRooms().add(roomOneBed2);
        hotelPlaza.getListOfRooms().add(roomDoubleBed1);
        hotelPlaza.getListOfRooms().add(roomDoubleBed2);

        // Write to the Database.ser file
        serialize(hotelPlaza, "Database.ser");
        */

        // Read from the Database.ser file
        hotelPlaza = deSerialize( "Database.ser");
        //hotelPlaza.getListOfRooms().forEach(System.out::println);
        //System.out.println(hotelPlaza.getListOfRooms().get(1).totalPriceRoom(12,true));

        //menu.userInterface(hotelPlaza.getListOfStaff(), loggedInEmployee);

    } // main method ends here

    // (1) Verify employee exists in hotelPlaza.listOfStaff and return that employee
    public static Staff employeeExists(ArrayList<Staff> listOfStaff, String userName, String password) {
        Staff loggedInEmployee = null;

        // Go through the Staff user list and check if username and password exist
        for (Staff currentEmployee : listOfStaff) {
            if (currentEmployee instanceof StaffUser) {
                StaffUser user = (StaffUser) currentEmployee;
                if (userName.equalsIgnoreCase(user.getUserName()) && password.equals(user.getPassword())) {
                    loggedInEmployee = currentEmployee;
                    break;
                }
            }
        }
        return loggedInEmployee;
    }
} // Main Class ends here