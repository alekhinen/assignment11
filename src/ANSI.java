
/**
 * A set of ANSI escaped color codes.
 * 
 * these are escape code sequences for coloring the interface
 * 
 * @author milliway of tupmudsites forum.
 * source: http://www.topmudsites.com/forums/mud-coding/413-java-ansi.html
 * @version 2014-04-08
 *
 */
public final class ANSI {

    /** Standard font weight */
    public static final String SANE = "\u001B[0m";
    
    /** Bold font weight */
    public static final String HIGH_INTENSITY = "\u001B[1m";
    /** Light font weight */
    public static final String LOW_INTESITY = "\u001B[2m";

    /** Italics */
    public static final String ITALIC = "\u001B[3m";
    /** Underline */
    public static final String UNDERLINE = "\u001B[4m";
    /** Blinking text */
    public static final String BLINK = "\u001B[5m";
    /** Rapid blinking text */
    public static final String RAPID_BLINK = "\u001B[6m";
    /** Invisible text */
    public static final String INVISIBLE_TEXT = "\u001B[8m";
    
    /** Black text */
    public static final String BLACK = "\u001B[30m";
    /** Red text */
    public static final String RED = "\u001B[31m";
    /** Green text */
    public static final String GREEN = "\u001B[32m";
    /** Yellow text */
    public static final String YELLOW = "\u001B[33m";
    /** Blue text */
    public static final String BLUE = "\u001B[34m";
    /** Magenta text */
    public static final String MAGENTA = "\u001B[35m";
    /** Cyan text */
    public static final String CYAN = "\u001B[36m";
    /** White text */
    public static final String WHITE = "\u001B[37m";

    /** Black background */
    public static final String BACKGROUND_BLACK = "\u001B[40m";
    /** Red background */
    public static final String BACKGROUND_RED = "\u001B[41m";
    /** Green background */
    public static final String BACKGROUND_GREEN = "\u001B[42m";
    /** Yellow background */
    public static final String BACKGROUND_YELLOW = "\u001B[43m";
    /** Blue background */
    public static final String BACKGROUND_BLUE = "\u001B[44m";
    /** Magenta background */
    public static final String BACKGROUND_MAGENTA = "\u001B[45m";
    /** Cyan background */
    public static final String BACKGROUND_CYAN = "\u001B[46m";
    /** White background */
    public static final String BACKGROUND_WHITE = "\u001B[47m";

    /** Disable automatic constructor */
    private ANSI() { }
    
    /** create a new ANSI (to fix webcat testing issue)
     * 
     * @author Austin Colcord
     * @version 2014-04-10
     * 
     * @return ANSI the new ANSI instance
     */
    public static ANSI newANSI() {
        return new ANSI();
    }
    

}