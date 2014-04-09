
import java.util.Scanner;

import MyGradeBook.MyGradeBook;


/**
 * This is the main class that users will be able to interface with the 
 * classes and methods found in this program. 
 * 
 * @author Nick Alekhine
 * @version 2014-04-08
 *
 */
public class Interfacer {

    /**
     * Runs the program
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     * @param args - command line arguments
     */
    // TODO gotta build this out.
    public static void main(String[] args) {
        // Create an instance of Interfacer
        Interfacer ui = new Interfacer();

        try {
            ui.welcome();
            ui.optionsMenu();
        }
        catch (Exception e) {
            System.out.println("Something unexpected happened...");
            System.out.println(e);
        }
    }


    /**
     * The welcome screen. First thing the user sees when they run the program.
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     */
    public void welcome() {
        // WELCOME 
        System.out.println(ANSI.HIGH_INTENSITY 
                + "\n" 
                + "--------------------------------------- \n"
                + "         Welcome to Gradebook.");
        System.out.println("--------------------------------------- \n");

        // ABOUT
        System.out.println(ANSI.HIGH_INTENSITY + "About" + ANSI.SANE);
        System.out.println("    This is a short description about what this "
                + "is."
                + "\n");

    }


    /**
     * The screen that awaits a response from the User.
     * 
     *  @author Nick Alekhine
     *  @version 2014-04-08
     *  
     */
    public void optionsMenu() {

        ///////////////////////////////////////////////////////////////////////
        // OPTIONS ////////////////////////////////////////////////////////////
        System.out.println(ANSI.HIGH_INTENSITY + "Options" + ANSI.SANE);
        // COMMAND "1"
        System.out.println("    " 
                + ANSI.GREEN + ANSI.HIGH_INTENSITY
                + "1" 
                + ANSI.BLACK + ANSI.SANE
                + " - Create an empty Gradebook.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will create a new instance of"
                + " a Gradebook that is completely empty."
                + ANSI.SANE);
        // COMMAND "2"
        System.out.println("    "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY
                + "2"
                + ANSI.BLACK + ANSI.SANE
                + " - Create a Gradebook with a file.");
        System.out.println(ANSI.LOW_INTESITY
                + "        This option will create a new instance of"
                + " a Gradebook with the supplied text file."
                + "\n        All content found "
                + "within the file will be put into the Gradebook if "
                + "properly formatted."
                + ANSI.SANE);
        // COMMAND "3"
        System.out.println("    "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY 
                + "3"
                + ANSI.BLACK + ANSI.SANE
                + " - Create a Gradebook with a text input.");
        System.out.println(ANSI.LOW_INTESITY
                + "        This option will create a new instance of"
                + " a Gradebook with the supplied text content."
                + ANSI.SANE);
        // COMMAND "o"
        System.out.println("    "
                + ANSI.BLUE + ANSI.HIGH_INTENSITY 
                + "o"
                + ANSI.BLACK + ANSI.SANE
                + " - Return to options menu.");
        System.out.println(ANSI.LOW_INTESITY
                + "        This option will return you to the options menu"
                + ANSI.SANE);
        // COMMAND "q"
        System.out.println("    "
                + ANSI.RED + ANSI.HIGH_INTENSITY 
                + "q"
                + ANSI.BLACK + ANSI.SANE
                + " - Exit the program.");
        System.out.println(ANSI.LOW_INTESITY
                + "        This option will end the current session."
                + ANSI.SANE);



        this.optionsInput(this.inputter());
    }

    
    /**
     * To create an instance of a scanner and return the input of the user.
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     */
    public String inputter() {
        // Create an instance of Scanner
        Scanner in = new Scanner(System.in);
        // The input from the user
        String input;

        System.out.println("\n");
        System.out.print("Enter a command: "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY);
        input = in.nextLine();
        System.out.print(ANSI.BLACK + ANSI.SANE);

        return input;
    }

    
    /**
     * The options inputs available to users.
     * 
     * @author Nick Alehine
     * @version 2014-04-08
     * 
     */
    public void optionsInput(String input) {
        ///////////////////////////////////////////////////////////////////////
        // USER INPUT /////////////////////////////////////////////////////////

        // COMMAND "q"
        if (input.equals("q")) {
            System.out.println("\nThanks for using Gradebook!\n");
            System.exit(0);
        }
        // COMMAND "o"
        if (input.equals("o")) {
            System.out.println("\nReturning to options menu.\n");
            this.optionsMenu();
        }
        // COMMAND "1"
        else if (input.equals("1")) {
            this.initialize();
        }
        // COMMAND "2"
        else if (input.equals("2")) {
            this.initializeWithFile();
        }
        // COMMAND UNKNOWN
        else {
            System.out.println("\nUnrecognized command. Returning back"
                    + " to options menu.\n");
            this.optionsMenu();
        }
    }


    /**
     * To initialize an empty instance of a Gradebook.
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     */
    public void initialize() {
        System.out.println("\nCreating an empty instance of a "
                + "Gradebook...");

        // Create an empty instance of MyGradeBook
        MyGradeBook mgb = MyGradeBook.initialize();

        System.out.println(ANSI.GREEN + "Success!\n" + ANSI.BLACK);

        this.gradeBookMenu(mgb);
    }


    /**
     * To initialize an instance of a Gradebook with a file.
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     */
    public void initializeWithFile() {

        System.out.println(ANSI.HIGH_INTENSITY 
                + "\nGradebook with File"
                + ANSI.SANE);
        System.out.println("Creating an instance of a Gradebook "
                + "with a file...\n");
        System.out.print("Please enter a filepath: "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY);
        String input = this.inputter();
        System.out.print(ANSI.BLACK + ANSI.SANE);

        System.out.println("\nThanks! Your file is currently being "
                + "processed.\n");
    }


    /**
     * The menu for the instance of MyGradeBook
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     */
    public void gradeBookMenu(MyGradeBook mgb) {

        System.out.println(ANSI.HIGH_INTENSITY 
                + "------------------------------\n"
                + "        GradeBook Menu        \n"
                + "------------------------------\n"
                + ANSI.SANE);

        ///////////////////////////////////////////////////////////////////////
        // OPTIONS ////////////////////////////////////////////////////////////
        System.out.println(ANSI.HIGH_INTENSITY 
                + "GradeBook Options" 
                + ANSI.SANE);

        // COMMAND "v_grades"
        System.out.println("    " 
                + ANSI.GREEN + ANSI.HIGH_INTENSITY
                + "v_grades" 
                + ANSI.BLACK + ANSI.SANE
                + " - View all current grades.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will display all current grades"
                + " for all students."
                + ANSI.SANE);

        // COMMAND "v_student"
        System.out.println("    "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY
                + "v_student"
                + ANSI.BLACK + ANSI.SANE
                + " - View all grades for a particular student.");
        System.out.println(ANSI.LOW_INTESITY
                + "        This option will display all grades"
                + " for a specific student."
                + ANSI.SANE);

        // COMMAND "v_assignment"
        System.out.println("    "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY 
                + "v_assignment"
                + ANSI.BLACK + ANSI.SANE
                + " - View all grades of a particular assignment.");
        System.out.println(ANSI.LOW_INTESITY
                + "        This option will display all grades for a "
                + "particular assignment."
                + ANSI.SANE);

        // COMMAND "v_gradebook"
        System.out.println("    "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY 
                + "v_gradebook"
                + ANSI.BLACK + ANSI.SANE
                + " - View the entire gradebook.");
        System.out.println(ANSI.LOW_INTESITY
                + "        This option will display the entire gradebook."
                + ANSI.SANE);


        String input = this.inputter();
        
        this.gradeBookInput(input);

    }
    
    
    /**
     * The inputs available to the user when in the GradeBook menu.
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     */
    public void gradeBookInput(String input) {
        if (input.equals("v_grades")) {
            System.out.println("view all grades...");
        }
        else if (input.equals("v_student")) {
            System.out.println("view student-specific grades...");
        }
        else if (input.equals("v_assignment")) {
            System.out.println("view assignment-specific grades...");
        }
        else if (input.equals("v_gradebook")) {
            System.out.println("view the entire gradebook...");
        }
        else {
            this.optionsInput(input);
        }
    }

}