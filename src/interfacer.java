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

        // OPTIONS
        System.out.println(ANSI.HIGH_INTENSITY + "Options" + ANSI.SANE);
        System.out.println("    " 
                + ANSI.GREEN + ANSI.HIGH_INTENSITY
                + "1" 
                + ANSI.BLACK + ANSI.SANE
                + " - Create an empty Gradebook.");
        System.out.println(ANSI.LOW_INTESITY 
                + "        This option will create a new instance of"
                + " a Gradebook that is completely empty."
                + ANSI.SANE);
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
        System.out.println("    "
                + ANSI.GREEN + ANSI.HIGH_INTENSITY 
                + "3"
                + ANSI.BLACK + ANSI.SANE
                + " - Create a Gradebook with a text input.");
        System.out.println(ANSI.LOW_INTESITY
                + "        This option will create a new instance of"
                + " a Gradebook with the supplied text content."
                + ANSI.SANE);
    }
    
    
   /**
    * The screen that awaits a response from the User.
    * 
    *  @author Nick Alekhine
    *  @version 2014-04-08
    *  
    */
    public void initialInputter() {
        // Create an instance of Scanner
        Scanner in = new Scanner(System.in);
        // The input from the user
        int input;
        
        System.out.println("\n");
        System.out.print("Enter a number from one of the 3 options above: "
                         + ANSI.GREEN + ANSI.HIGH_INTENSITY);
        input = in.nextInt();
        System.out.println(ANSI.BLACK + ANSI.SANE + "you entered" + input);
    }

}