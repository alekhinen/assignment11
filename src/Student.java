import java.util.ArrayList;
import java.util.HashMap;

/** represents a student in the schoool that contains a name and a hashmap/map
 * of the assignments that the student has assigned to him
 * 
 * @author Austin Colcord
 * @version 2014-04-06
 *
 */
public class Student {
    String userName;
    String firstName;
    String middleName;
    String lastName;
    int gradYear;
    
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
}
