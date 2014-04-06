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
    String name;
    HashMap<String, ArrayList<Assignment>> assignMap;
    
    Student(String name, HashMap<String, ArrayList<Assignment>> assignMap) {
        this.name = name;
        this.assignMap = new HashMap<String, ArrayList<Assignment>>();
    }
}
