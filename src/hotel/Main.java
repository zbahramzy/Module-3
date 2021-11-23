package hotel;
import employees.Staff;
import employees.StaffUser;
import employees.StaffAccountant;
import employees.StaffCleaningLady;
import employees.StaffDirector;
import employees.StaffReceptionist;
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

        // Create 6 room objects
        RoomOneBed rOB0 = new RoomOneBed(01,0,1,300);
        RoomDoubleBed rDB0 = new RoomDoubleBed(02, 0, 2, 450);
        RoomSuite rS0 = new RoomSuite(03, 0,2,700);
        RoomOneBed rOB1 = new RoomOneBed(14,1,1,300);
        RoomDoubleBed rDB1 = new RoomDoubleBed(15, 1, 2, 450);
        RoomSuite rS1 = new RoomSuite(16, 1,2,700);

        // Add these 6 rooms to listOfStaff in hotel
        hotelPlaza.getListOfRooms().add(rOB0);
        hotelPlaza.getListOfRooms().add(rDB0);
        hotelPlaza.getListOfRooms().add(rS0);
        hotelPlaza.getListOfRooms().add(rOB1);
        hotelPlaza.getListOfRooms().add(rDB1);
        hotelPlaza.getListOfRooms().add(rS1);

        // Write to the Database.ser file
        serialize(hotelPlaza, "Database.ser");
        */

        // Read from the Database.ser file
        hotelPlaza = deSerialize( "Database.ser");

        menu.userInterface(hotelPlaza.getListOfStaff(), loggedInEmployee);



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