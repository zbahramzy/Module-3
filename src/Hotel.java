import java.util.ArrayList;
import java.io.Serializable;

public class Hotel implements Serializable {
    // To avoid error when deserializing after changes made in class that implements Serializable interface
    static final long serialVersionUID = 45L;

    // Attributes
    private String name;
    private ArrayList<Room> listOfRooms;
    private ArrayList<Staff> listOfStaff;
    private ArrayList<Booking> listOfBookings;

    // Constructor
    public Hotel(String name) {
        setName(name);
        listOfRooms = null;
        listOfStaff = null;
        listOfBookings = null;
    }

    // getters
    public String getName() {
        return name;
    }
    public ArrayList<Room> getListOfRooms() {
        return listOfRooms;
    }
    public ArrayList<Staff> getListOfStaff() {
        return listOfStaff;
    }
    public ArrayList<Booking> getListOfBookings() {
        return listOfBookings;
    }
    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setListOfRooms(ArrayList<Room> listOfRooms) {
        this.listOfRooms = listOfRooms;
    }
    public void setListOfStaff(ArrayList<Staff> listOfStaff) {
        this.listOfStaff = listOfStaff;
    }
    public void setListOfBookings(ArrayList<Booking> listOfBookings) {
        this.listOfBookings = listOfBookings;
    }

    // toString
}