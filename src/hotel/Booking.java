package hotel;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
    // To avoid error when deserializing after changes made in class that implements Serializable interface
    static final long serialVersionUID = 43L;

    // Attributes
    private int recordRoomNumber;
    private int numberOfNights;
    private Date startDate;
    private Date endDate;
    private Guest registeredGuest;

    // Constructor
    public Booking(int recordRoomNumber, int numberOfNights, Date startDate, Date endDate, Guest registeredGuest) {
        setRecordRoomNumber(recordRoomNumber);
        setNumberOfNights(numberOfNights);
        setStartDate(startDate);
        setEndDate(endDate);
        setRegisteredGuest(registeredGuest);
    }

    // getters
    public int getRecordRoomNumber() {
        return recordRoomNumber;
    }
    public int getNumberOfNights() {
        return numberOfNights;
    }
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public Guest getRegisteredGuest() {
        return registeredGuest;
    }
    // setters
    public void setRecordRoomNumber(int recordRoomNumber) {
        this.recordRoomNumber = recordRoomNumber;
    }
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setRegisteredGuest(Guest registeredGuest) {
        this.registeredGuest = registeredGuest;
    }

    // toString
}