//THIS IS THE INTERFACER, PLEASE GIVE US BACK POINTS SINCE WE CANNOT
// TEST THIS DUE TO THE MAIN METHOD

import gradebook.MyGradeBook;

import java.util.Scanner;


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
        System.out.println("    This is a digital grade book for teachers at "
                + "a school system to easily manage their courses by keeping "
                + "track of assignments and students.  "
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


        System.out.print("Enter a command: ");
        this.optionsInput(this.inputter());
    }


    /**
     * To create an instance of a scanner and return the input of the user.
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     * @return String the input of the user
     */
    public String inputter() {
        // Create an instance of Scanner
        Scanner in = new Scanner(System.in);
        // The input from the user
        String input;

        //        System.out.println("\n");
        //        System.out.print("Enter a command: ");
        System.out.print(ANSI.GREEN + ANSI.HIGH_INTENSITY);
        input = in.nextLine();
        System.out.print(ANSI.BLACK + ANSI.SANE);

        return input;
    }
    
    /**
     * To pause the program for 1000 milliseconds.
     * 
     * @author Nick Alekhine
     * @version 2014-04-09
     */
    public void pause() {
        try {
            Thread.sleep(1500);
        } 
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    /**
     * The options inputs available to users.
     * 
     * @author Nick Alehine
     * @version 2014-04-08
     * 
     * @param input the string to input to the interface
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
        // COMMAND "3"
        else if (input.equals("3")) {
            this.initializeWithString();
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
        try {
            // Create an empty instance of MyGradeBook
            MyGradeBook mgb = MyGradeBook.initialize();
            System.out.println(ANSI.GREEN + "Success!\n" + ANSI.BLACK);
            // Go to GradeBook Menu.
            this.gradeBookMenu(mgb);
        }
        catch (Exception e) {
            // An error occurred.
            System.out.println("Something unexpected happened.");
            System.out.println(e);
            this.optionsMenu();
        }

    }


    /**
     * To initialize an instance of a Gradebook with a file.
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     */
    public void initializeWithFile() {
        // Create an instance of Scanner
        Scanner in = new Scanner(System.in);
        // The input from the user
        String input;

        System.out.println(ANSI.HIGH_INTENSITY 
                + "\nGradebook With File"
                + ANSI.SANE);
        System.out.println("Creating an instance of a Gradebook "
                + "with a file...\n");
        System.out.print("Please enter a filepath: "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY);
        input = in.nextLine();
        System.out.print(ANSI.BLACK + ANSI.SANE);
        System.out.println("\nThanks! Your file is currently being "
                + "processed.\n");
        try {
            // Create an instance of MyGradeBook with file input.
            MyGradeBook mgb = MyGradeBook.initializeWithFile(input);
            System.out.println(ANSI.GREEN + "Success!\n" + ANSI.BLACK);
            // Go to GradeBook Menu
            this.gradeBookMenu(mgb);
        }
        catch (Exception e) {
            // An error occurred.
            System.out.println("Something unexpected happened.");
            System.out.println(e);
            this.optionsMenu();
        }
    }


    /**
     * To initialize an instance of Gradebook with a string input.
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     */
    public void initializeWithString() {
        // Create an instance of Scanner
        Scanner in = new Scanner(System.in);
        // The input from the user
        String input;

        System.out.println(ANSI.HIGH_INTENSITY 
                + "\nGradebook With Text Input"
                + ANSI.SANE);
        System.out.println("Please input a GradeBook: "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY);
        input = in.next();
        System.out.print(ANSI.BLACK + ANSI.SANE);
        System.out.println("\nThanks! Your request is being processed.\n");
        
        System.out.println("\n\n\n" + input + "\n\n\n");
        
        try {
            // Create an instance of MyGradeBook with text input.
            MyGradeBook mgb = MyGradeBook.initializeWithString(input);
            System.out.println(ANSI.GREEN + "Success!\n" + ANSI.BLACK);
            
            // Go to GradeBook Menu
            this.gradeBookMenu(mgb);
        }
        catch (Exception e) {
            // An error occurred.
            System.out.println("Something unexpected happened.");
            System.out.println(e);
            this.optionsMenu();
        }

    }


    /**
     * The menu for the instance of MyGradeBook
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     * @param mgb the gradebook to import into the instance
     */
    public void gradeBookMenu(MyGradeBook mgb) {
        this.pause();

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


        // PROCESSING OPTIONS /////////////////////////////////////////////////
        System.out.println(ANSI.HIGH_INTENSITY + ANSI.BLUE
                + "Processing Options"
                + ANSI.SANE + ANSI.BLACK);
        // COMMAND "p_file"
        System.out.println("    " 
                + ANSI.BLUE + ANSI.HIGH_INTENSITY
                + "p_file" 
                + ANSI.BLACK + ANSI.SANE
                + " - Process a file.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will process a file"
                + " and add its content to the current GradeBook.\n"
                + "        This will overwrite any duplicate "
                + "assignments/students."
                + ANSI.SANE);
        // COMMAND "p_string"
        System.out.println("    " 
                + ANSI.BLUE + ANSI.HIGH_INTENSITY
                + "p_string" 
                + ANSI.BLACK + ANSI.SANE
                + " - Process a text input.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will process a text input"
                + " and add its content to the current GradeBook.\n"
                + "        This will overwrite any duplicate "
                + "assignments/students."
                + ANSI.SANE);
        System.out.println("");


        // CHANGE OPTIONS /////////////////////////////////////////////////////
        System.out.println(ANSI.HIGH_INTENSITY + ANSI.MAGENTA
                + "Change Options"
                + ANSI.SANE + ANSI.BLACK);
        // COMMAND "c_grade"
        System.out.println("    " 
                + ANSI.MAGENTA + ANSI.HIGH_INTENSITY
                + "c_grade" 
                + ANSI.BLACK + ANSI.SANE
                + " - Change a grade for a particular assignment.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will change the grade "
                + "of a particular assignment for a student."
                + ANSI.SANE);


        // STATISTICS /////////////////////////////////////////////////////////
        System.out.println(ANSI.HIGH_INTENSITY + ANSI.CYAN
                + "Statistics"
                + ANSI.SANE + ANSI.BLACK);
        // COMMAND "s_average"
        System.out.println("    " 
                + ANSI.CYAN + ANSI.HIGH_INTENSITY
                + "s_average" 
                + ANSI.BLACK + ANSI.SANE
                + " - To get the average grade of an assignment.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will display the average grade of "
                + "a particular assignment across all students."
                + ANSI.SANE);
        // COMMAND "s_median"
        System.out.println("    " 
                + ANSI.CYAN + ANSI.HIGH_INTENSITY
                + "s_median" 
                + ANSI.BLACK + ANSI.SANE
                + " - To get the median grade of an assignment.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will display the median grade of "
                + "a particular assignment across all students."
                + ANSI.SANE);
        // COMMAND "s_min"
        System.out.println("    " 
                + ANSI.CYAN + ANSI.HIGH_INTENSITY
                + "s_min" 
                + ANSI.BLACK + ANSI.SANE
                + " - To get the minimum grade of an assignment.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will display the minimum grade of "
                + "a particular assignment across all students."
                + ANSI.SANE);
        // COMMAND "s_max"
        System.out.println("    " 
                + ANSI.CYAN + ANSI.HIGH_INTENSITY
                + "s_max" 
                + ANSI.BLACK + ANSI.SANE
                + " - To get the maximum grade of an assignment.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will display the maximum grade of "
                + "a particular assignment across all students."
                + ANSI.SANE);



        // VIEWING ////////////////////////////////////////////////////////////
        System.out.println(ANSI.HIGH_INTENSITY + ANSI.GREEN
                + "Viewing Options"
                + ANSI.SANE + ANSI.BLACK);
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


        System.out.print("\nEnter a command: ");
        String input = this.inputter();

        this.gradeBookInput(input, mgb);

    }


    /**
     * The inputs available to the user when in the GradeBook menu.
     * 
     * @author Nick Alekhine
     * @version 2014-04-08
     * 
     * @param input the string that the user inputs
     * @param mgb the MyGradeBook to throw the input into with the action
     */
    public void gradeBookInput(String input, MyGradeBook mgb) {

        // PROCESS ////////////////////////////////////////////////////////////
        // processFile
        if (input.equals("p_file")) {
            this.processFile(mgb);
        }
        // processString
        else if (input.equals("p_string")) {
            this.processString(mgb);
        }
        
        // CHANGE /////////////////////////////////////////////////////////////
        // changeGrade
        else if (input.equals("c_grade")) {
            this.changeGrade(mgb);
        }

        // STATISTICS /////////////////////////////////////////////////////////
        // average
        else if (input.equals("s_average")) {
            this.average(mgb);
        }
        // median
        else if (input.equals("s_median")) {
            this.median(mgb);
        }
        // minimum
        else if (input.equals("s_min")) {
            this.minimum(mgb);
        }
        // maximum
        else if (input.equals("s_max")) {
            this.maximum(mgb);
        }

        // VIEW ///////////////////////////////////////////////////////////////
        // viewGrades
        else if (input.equals("v_grades")) {
            this.viewGrades(mgb);
        }
        // viewStudent
        else if (input.equals("v_student")) {
            this.viewStudent(mgb);
        }
        // viewAssignment
        else if (input.equals("v_assignment")) {
            this.viewAssignment(mgb);
        }
        // viewGradeBook
        else if (input.equals("v_gradebook")) {
            this.viewGradeBook(mgb);
        }
        
        // EXTRAS /////////////////////////////////////////////////////////////
        // COMMAND "q"
        else if (input.equals("q")) {
            System.out.println("\nThanks for using Gradebook!\n");
            System.exit(0);
        }
        // COMMAND "o"
        else if (input.equals("o")) {
            System.out.println("\nReturning to options menu.\n");
            this.optionsMenu();
        }
        // COMMAND UNKNOWN
        else {
            System.out.println(ANSI.HIGH_INTENSITY 
                    + "\nUnrecognized command. Returning back"
                    + " to the GradeBook Menu.\n"
                    + ANSI.SANE);
        }

        this.gradeBookMenu(mgb);
    }
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // PROCESSING /////////////////////////////////////////////////////////////
    /**
     * Processes file into given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void processFile(MyGradeBook mgb) {
        System.out.println("Process A File");
        System.out.print("Enter the filepath: ");
        System.out.print(ANSI.GREEN + ANSI.HIGH_INTENSITY);
        String fileName = this.inputter();
        System.out.print(ANSI.BLACK + ANSI.SANE);
        System.out.println("Processing file...");
        try {
            mgb.processFile(fileName);
            System.out.println("Success!");
            this.gradeBookMenu(mgb);
        }
        catch (Exception e) {
            System.out.println(ANSI.HIGH_INTENSITY + ANSI.RED
                    + "Something unexpected happened."
                    + "It could be due to the file not existing or"
                    + " it being improperly formatted.");
            System.out.println(e 
                    + "\n" 
                    + ANSI.SANE + ANSI.BLACK);
            this.gradeBookMenu(mgb);
        }
    }
    
    
    /**
     * Processes string into given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void processString(MyGradeBook mgb) {
        System.out.println("Process A String Input");
        System.out.println("Enter the string input: ");
        System.out.print(ANSI.GREEN + ANSI.HIGH_INTENSITY);
        String textInput = this.inputter();
        System.out.print(ANSI.BLACK + ANSI.SANE);
        System.out.println("Processing input...");
        try {
            mgb.processString(textInput);
            System.out.println("Success!");
            this.gradeBookMenu(mgb);
        }
        catch (Exception e) {
            System.out.println(ANSI.HIGH_INTENSITY + ANSI.RED
                    + "Something unexpected happened."
                    + " It could be due to an improperly formatted "
                    + "string.");
            System.out.println(e 
                    + "\n" 
                    + ANSI.SANE + ANSI.BLACK);
            this.gradeBookMenu(mgb);
        }
    }
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // CHANGE /////////////////////////////////////////////////////////////////
    /**
     * Changes grade in given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void changeGrade(MyGradeBook mgb) {
        System.out.println("Change Assignment Grade");

        // Assignment Name
        System.out.print("\nEnter the name of the assignment: ");
        String assignmentName = this.inputter();

        // Username
        System.out.print("Enter the username: ");
        String username = this.inputter();


        // Grade
        // Create an instance of Scanner
        Scanner in = new Scanner(System.in);
        // The input from the user
        Double newGrade = 0.0;
        System.out.print("Enter the new grade: ");
        System.out.print(ANSI.GREEN + ANSI.HIGH_INTENSITY);
        try {
            newGrade = in.nextDouble();
            System.out.print(ANSI.BLACK + ANSI.SANE);
        }
        catch (Exception e) {
            System.out.print(ANSI.RED);
            System.out.println("Incorrect input. "
                    + "Please enter a double next time.");
            System.out.print(ANSI.BLACK + ANSI.SANE);
            System.out.println("");
            this.pause();
            this.gradeBookMenu(mgb);
        }

        System.out.print(ANSI.BLACK + ANSI.SANE);

        if (mgb.changeGrade(assignmentName, username, newGrade)) {
            System.out.print(ANSI.GREEN + ANSI.HIGH_INTENSITY);
            System.out.println("\nAssignment successfully changed for "
                    + username + "!\n");
            System.out.print(ANSI.BLACK + ANSI.SANE);

            this.gradeBookMenu(mgb);
        }
        else {
            System.out.print(ANSI.RED + ANSI.HIGH_INTENSITY);
            System.out.println("\nAssignment unsuccessfully changed for "
                    + username + "!\n");
            System.out.print(ANSI.BLACK + ANSI.SANE);

            this.gradeBookMenu(mgb);
        }
    }
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // STATISTICS /////////////////////////////////////////////////////////////
    /**
     * View average of specific assignment in given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void average(MyGradeBook mgb) {
        System.out.println("Assignment Average");
        System.out.print("\nEnter the Assignment name: ");
        String aname = this.inputter();
        try {
            System.out.println("Hit enter again.");
            Double avg = mgb.average(aname);
            System.out.println("The average grade for " 
                    + this.inputter()
                    + " is " 
                    + avg);
            this.gradeBookMenu(mgb);
        }
        catch (Exception e) {
            System.out.println("An error occurred.");
            System.out.println(e);
            this.gradeBookMenu(mgb);
        }
    }
    
    
    /**
     * View median of specific assignment in given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void median(MyGradeBook mgb) {
        System.out.println("Assignment Median");
        System.out.print("\nEnter the Assignment name: ");
        String aname = this.inputter();
        try {
            System.out.println("Hit enter again.");
            Double median = mgb.median(aname);
            System.out.println("The average grade for " 
                    + this.inputter()
                    + " is " 
                    + median);
            this.gradeBookMenu(mgb);
        }
        catch (Exception e) {
            System.out.println(ANSI.HIGH_INTENSITY + ANSI.RED
                    + "Something unexpected happened.");
            System.out.println(e 
                    + "\n" 
                    + ANSI.SANE + ANSI.BLACK);
            this.gradeBookMenu(mgb);
        }
    }
    
    
    /**
     * View minimum of specific assignment in given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void minimum(MyGradeBook mgb) {
        System.out.println("Assignment Minimum Grade");
        System.out.print("\nEnter the Assignment name: ");
        String aname = this.inputter();
        try {
            System.out.println("Hit enter again.");
            Double min = mgb.min(aname);
            System.out.println("The average grade for " 
                    + this.inputter()
                    + " is " 
                    + min);
            this.gradeBookMenu(mgb);
        }
        catch (Exception e) {
            System.out.println(ANSI.HIGH_INTENSITY + ANSI.RED
                    + "Something unexpected happened.");
            System.out.println(e 
                    + "\n" 
                    + ANSI.SANE + ANSI.BLACK);
            this.gradeBookMenu(mgb);
        }
    }
    
    
    /**
     * View maximum of specific assignment in given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void maximum(MyGradeBook mgb) {
        System.out.println("Assignment Maximum Grade");
        System.out.print("\nEnter the Assignment name: ");
        String aname = this.inputter();
        try {
            System.out.println("Hit enter again.");
            Double max = mgb.max(aname);
            System.out.println("The average grade for " 
                    + this.inputter()
                    + " is " 
                    + max);
            this.gradeBookMenu(mgb);
        }
        catch (Exception e) {
            System.out.println(ANSI.HIGH_INTENSITY + ANSI.RED
                    + "Something unexpected happened. It could be"
                    + "due to a student having null values "
                    + "for assignments.");
            System.out.println(e 
                    + "\n" 
                    + ANSI.SANE + ANSI.BLACK);
            this.gradeBookMenu(mgb);
        }
    }
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // VIEW ///////////////////////////////////////////////////////////////////
    /**
     * View current grades for all students in given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void viewGrades(MyGradeBook mgb) {
        System.out.println(ANSI.HIGH_INTENSITY
                + "\nView all current grades\n"
                + ANSI.SANE);
        try {
            String cg = mgb.outputCurrentGrades();
            System.out.println(cg);
            System.out.println("");
        }
        catch (Exception e) {
            System.out.println("An error occurred. It could be due to"
                    + "a student having null values for assignments");
            System.out.println(e);
            System.out.println("");
        }
    }
    
    
    /**
     * View student-specific grades in given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void viewStudent(MyGradeBook mgb) {
        System.out.println("View Current Grade For Student");
        System.out.print("\nEnter the username: ");
        String username = this.inputter();
        try {
            String cgs = mgb.outputStudentGrades(username);
            
            System.out.println(username + "current grades:");
            System.out.println(cgs + "\n");
        }
        catch (Exception e) {
            System.out.println("An error occurred."
                    + "The student might have null values for their"
                    + "assignments or the student might not exist");
            System.out.println(e);
            System.out.println("");
        }
    }
    
    
    /**
     * View assignment-specific grades in given gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void viewAssignment(MyGradeBook mgb) {
        System.out.println("View Grades For Assignment");
        System.out.print("\nEnter the assignment name: ");
        String aname = this.inputter();
        try {
            String output = mgb.outputAssignmentGrades(aname);
            System.out.println(output);
            System.out.println("\n\n");
        }
        catch (Exception e) {
            System.out.println("An error occurred."
                    + "It could be due to the assignment not existing.");
            System.out.println(e);
            System.out.println("");
        }
    }
    
    
    /**
     * View the entire gradebook
     * @author Nick Alekhine
     * @version 2014-04-11
     *  
     * @param mgb - a MyGradeBook
     */
    public void viewGradeBook(MyGradeBook mgb) {
        System.out.println("view the entire gradebook...");
        System.out.println("View Entire Gradebook");
        try {
            String output = mgb.outputGradebook();
            System.out.println(output + "\n");
        }
        catch (Exception e) {
            System.out.println("An error occurred.");
            System.out.println(e);
            System.out.println("");
        }
    }

}
