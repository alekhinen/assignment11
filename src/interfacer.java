
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
    // TODO gotta build this out.
    public static void main(String[] args) {
        // Create an instance of Interfacer
        Interfacer ui = new Interfacer();

        try {
            ui.welcome();
            ui.initialInputter();
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
    public void initialInputter() {
        
        // OPTIONS
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
        
        
        // Create an instance of Scanner
        Scanner in = new Scanner(System.in);
        // The input from the user
        String input;
        
        System.out.println("\n");
        System.out.print("Enter a command: "
                         + ANSI.GREEN + ANSI.HIGH_INTENSITY);
        input = in.nextLine();
        System.out.print(ANSI.BLACK + ANSI.SANE);
        
        if (input.equals("q")) {
            System.out.println("\nThanks for using Gradebook!\n");
            System.exit(0);
        }
        else if (input.equals("1")) {
            System.out.println("\nCreating an empty instance of a "
                    + "Gradebook...\n");
        }
        else if (input.equals("2")) {
            System.out.println("\nCreating a");
        }
        else {
            System.out.println("\nUnrecognized command. Returning back"
                    + " to options menu.\n");
            this.initialInputter();
        }
    }

}