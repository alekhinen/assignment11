import java.util.ArrayList;
import java.util.HashMap;

/** represents a student in the schoool that contains a name and a hashmap/map
 * of the assignments that the student has assigned to him
 * 
 * @author Austin Colcord
 * @author Nick Alekhine
 * @version 2014-04-06
 *
 */
public class Student {
    
    ///////////////////////////////////////////////////////////////////////////
    // FIELDS /////////////////////////////////////////////////////////////////
  
    /** The username of this student */
    String userName;
    /** The first name of this student */
    String firstName;
    /** The middle name of this student */
    String middleName;
    /** The last name of this student */
    String lastName;
    /** The year that this student is graduating */
    int gradYear;
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS ///////////////////////////////////////////////////////////
   
    /**
     * 
     * @param userName
     * @param firstName
     * @param middleName
     * @param lastName
     * @param gradYear
     */
    Student(String userName, 
            String firstName, 
            String middleName, 
            String lastName, 
            int gradYear) {
        this.userName = userName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gradYear = gradYear;
    }
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // METHODS ////////////////////////////////////////////////////////////////
    
    
}
