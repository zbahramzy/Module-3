package rooms;

import java.io.Serializable;

public abstract class Room implements Serializable {
    // To avoid error when deserializing after changes made in class that implements Serializable interface
    static final long serialVersionUID = 40L;

    // Attributes
    protected int roomNumber;
    protected int floorNumber;
    protected int numberOfBeds;
    protected double pricePerNight;
    protected boolean internetAccess;                 // True if the guest wants access to Wi-Fi
    protected boolean isOccupied;                     // True if a guest books the room

    // Constructor
    public Room(int roomNumber, int floorNumber, int numberOfBeds, double pricePerNight) {
        setRoomNumber(roomNumber);
        setFloorNumber(floorNumber);
        setNumberOfBeds(numberOfBeds);
        setPricePerNight(pricePerNight);
        internetAccess = false;
        isOccupied = false;
    }

    // getters
    public int getRoomNumber() {
        return roomNumber;
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    public int getNumberOfBeds() {
        return numberOfBeds;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }
    public boolean getInternetAccess() {
        return internetAccess;
    }
    public boolean getIsOccupied() {
        return isOccupied;
    }
    // setters
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    public void setInternetAccess(boolean internetAccess) {
        this.internetAccess = internetAccess;
    }
    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    // toString
    @Override
    public String toString() {
        return "roomNumber: " + roomNumber +
                "\nfloorNumber: " + floorNumber +
                "\nnumberOfBeds: " + numberOfBeds +
                "\npricePerNight: " + pricePerNight +
                "\ninternetAccess: " + translate(internetAccess)+
                "\nisOccupied: " + translate(isOccupied);
    }

    // translate boolean to string(yes/no)
    public String translate(boolean trueOrFalse) {
        return trueOrFalse ? "Yes" : "No";
    }
    //calculate internet price for room
    public double totalPriceRoom( int numberOfNights, boolean internetAccess) {
        double totalPrice = numberOfNights * pricePerNight;
        if(internetAccess)
            totalPrice += 100;
        return totalPrice;
    }
}