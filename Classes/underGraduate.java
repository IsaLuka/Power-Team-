package student2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Demonstration of Error handling, abstract class and interface implementation.
 * This class has only two catch block, 2 getter/setter method, of 1 method for our String line input(perform collection of many string in single input) and implementation of the interface.
 *We have a plan to  implement 4 method in the next concrete class 
 */
abstract class underGraduate implements Student {
    //here we declare our variables(properties)
    private String fname;
    private String lname;
    private String faculty;
    private String dept;
    private String gender;
    private String id;
    private int age;
    private int level;
    boolean status = false;

    public abstract void registercourses();
    public abstract void dispalyCourses();

    //input stream function
    public static String getInput(String message) {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(message);
        System.out.print("\033[H\033[2J");
        System.out.flush();

        try {
            return sc.readLine();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }

    }

    @Override
    public boolean registerStudent() {
        //we do some ERROR HANDLING TO AVOID PROGRAM INTERRUPTION while user enter a wrong input
        try {
            System.out.println("________REGISTRATION___________ \n");
            System.out.println("     *FILL IN THIS FORM*          ");
            System.out.println("NOTE: FILL IN EVERY INFORMATION IS IMPORTANT\n");
            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER YOUR FIRST NAME");
            fname = sc.next().toUpperCase();
            System.out.println("ENTER YOUR LAST NAME");
            lname = sc.next().toUpperCase();
            System.out.println("ENTER YOUR GENDER ~~ [MALE/FEMALE] :");
            gender = sc.next().toUpperCase();
            System.out.println("ENTER YOUR ID NUMBER");
            id = sc.next().toUpperCase();
            System.out.println("ENTER YOUR AGE");
            age = sc.nextInt();
            System.out.println("ENTER YOUR FACULTY NAME");
            faculty = sc.next().toUpperCase();

            dept = getInput("ENTER YOUR DEPARTMENT NAME").toUpperCase();
            System.out.println("ENTER YOUR LEVEL");
            level = sc.nextInt();
            System.out.println("SUCCESSFULLY REGISTERED");

        } catch (InputMismatchException e) {
            System.out.println(e + ": Enter an interger value for age and level");
        } catch (Exception e) {
            System.out.println("Unknown Error");

        }
        return status = true;
    }

    @Override
    public void displayStudentinfo() {
            System.out.println("________INFORMATION___________ ");

        if (status == true) {
            System.out.println("NAME : " + fname + " " + lname);
            System.out.println("AGE : " + age);
            System.out.println("GENDER : " + gender);
            System.out.println("ID NUMBER : " + id);
            System.out.println("FACULTY : " + faculty);
            System.out.println("DEPARTMENT : " + dept);
            System.out.println("LEVEL : " + level + " Level");

        } else {
            System.out.println("         *NO DATA FOUND*          \n");
            System.out.println("STATUS : Not yet register, Go back to the MAIN MENU to register:\n");
        }
    }
}