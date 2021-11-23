package hotel;
import employees.Staff;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface implements Serializable {
    // To avoid error when deserializing after changes made in class that implements Serializable interface
    static final long serialVersionUID = 44L;
    public void displayLogInMenu() {
        System.out.println("=============== The Plaza Hotel - Login MENU ================");
        System.out.println("* PRESS 1: LOG IN");
        System.out.println("* PRESS 2: SHUT DOWN");
        System.out.println("=============================================================");
        System.out.print("ENTER HERE: ");
    }
    public void displayAdminMenu() {
        System.out.println("=============== The Plaza Hotel - Main MENU =================");
        System.out.println("* PRESS 1: MAKE A BOOKING");
        System.out.println("* PRESS 2: REGISTER A GUEST");
        System.out.println("* PRESS 3: UPDATE A BOOKING");
        System.out.println("* PRESS 4: CHANGE GUEST INFO");
        System.out.println("* PRESS 5: CHANGE ROOM PRICE");
        System.out.println("* PRESS 6: CHANGE STAFF INFO");
        System.out.println("* PRESS 7: REGISTER NEW STAFF MEMBER");
        System.out.println("* PRESS 8: LOG OUT");
        System.out.println("=============================================================");
        System.out.print("ENTER HERE: ");
    }
    public void displayUserMenu() {
        System.out.println("=============== The Plaza Hotel - Main MENU =================");
        System.out.println("* PRESS 1: MAKE A BOOKING");
        System.out.println("* PRESS 2: REGISTER A GUEST");
        System.out.println("* PRESS 3: UPDATE A BOOKING");
        System.out.println("* PRESS 4: CHANGE GUEST INFO");
        System.out.println("* PRESS 5: LOG OUT");
        System.out.println("=============================================================");
        System.out.print("ENTER HERE: ");
    }

    public void userInterface(ArrayList<Staff> listOfStaff, Staff loggedInEmployee) {
        boolean quit = false;
        boolean choose1 = true;
        while(choose1) {
            displayLogInMenu();

            // Use try & catch here if user gives a non-int input
            try {
                Scanner inputString = new Scanner(System.in);
                Scanner inputInt = new Scanner(System.in);
                switch (inputInt.nextInt()) {
                    case 1 -> {
                        System.out.print("ENTER USERNAME: ");
                        String userName = inputString.nextLine();
                        System.out.print("ENTER PASSWORD: ");
                        String password = inputString.nextLine();

                        loggedInEmployee = Main.employeeExists(listOfStaff, userName, password);
                        if (loggedInEmployee == null) {
                            System.out.println("\n******** INCORRECT USERNAME OR PASSWORD. TRY AGAIN! *********\n");
                        } else {
                            System.out.println("\n---------------- YOU LOGGED IN SUCCESSFULLY -----------------\n");
                            choose1 = false;
                        }
                    }
                    case 2 -> {
                        quit = true;
                        choose1 = false;
                        System.out.println("\n------------ THE PROGRAM SHUT DOWN SUCCESSFULLY -------------");
                    }
                    default -> System.out.println("\n***************** INVALID INPUT. TRY AGAIN! *****************\n");
                }
            } catch (InputMismatchException mismatchException) {
                System.out.println("\n***************** INVALID INPUT. TRY AGAIN! *****************\n");
            }

            ///*
            // Menu 2 only runs if quit = false and choose1 = true
            if (quit == false && choose1 == false) {
                boolean choose2 = true;
                while(choose2) {
                    if(loggedInEmployee.getTitle().equalsIgnoreCase("director")) {
                        displayAdminMenu();

                    }
                    else {
                        displayUserMenu();
                    }
                    try {
                        Scanner inputInt = new Scanner(System.in);
                        switch (inputInt.nextInt()) {
                            case 1: // MAKE A BOOKING
                                // code block
                                break;
                            case 2: // REGISTER A GUEST
                                // code block
                                break;
                            case 3: // UPDATE A BOOKING
                                // code block
                                break;
                            case 4: // CHANGE GUEST INFO
                                // code block
                                break;
                            case 5: // CHANGE ROOM PRICE
                                // code block
                                break;
                            case 6: // CHANGE STAFF INFO
                                // code block
                                break;
                            case 7: // REGISTER NEW STAFF MEMBER
                                // code block
                                break;
                            case 8: // LOG OUT
                                choose2 = false;
                                choose1 = true;
                                System.out.println("\n---------------- YOU LOGGED OUT SUCCESSFULLY ----------------\n");
                                break;
                            default:
                                System.out.println("\n***************** INVALID INPUT. TRY AGAIN! *****************\n");
                        }
                    } catch (InputMismatchException mismatchException) {
                        System.out.println("\n***************** INVALID INPUT. TRY AGAIN! *****************\n");
                    }
                }
            }
        }
    }
}