
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
        Interfacer ui = new Interfacer();
        try {
            ui.welcome();
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
       System.out.println(ANSI.HIGH_INTENSITY 
                          + "         Welcome to Gradebook.");
       System.out.println("--------------------------------------- \n");
       
       System.out.println(ANSI.SANE + "Options:");
       System.out.println("    " + ANSI.GREEN + "1" + ANSI.BLACK + 
                          " - Create an empty Gradebook.");
       System.out.println("        This option will create a new instance of "
               + "a Gradebook that is completely empty.");
       System.out.println("    2 - Create a Gradebook with a file.");
       System.out.println("        This option will create a new instance of "
               + "a Gradebook with the supplied text file."
               + "\n        All content found "
               + "within the file will be put into the Gradebook if properly "
               + "formatted.");
       System.out.println("    3 - Create a Gradebook with a text input.");
    }

}