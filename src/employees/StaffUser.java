package employees;

public abstract class StaffUser extends Staff {
    // Attributes
    protected String userName;
    protected String password;

    // Constructor
    public StaffUser(String title, String firstName, String lastName, int phoneNumber, double salary, String userName, String password) {
        super(title, firstName, lastName, phoneNumber, salary);
        this.userName = userName;
        this.password = password;
    }

    // getter
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    // setter
    public void setUserName() {
        this.userName = userName;
    }
    public void setPassword() {
        this.password = password;
    }
}