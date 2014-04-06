import java.util.ArrayList;

/** represents an instructor inside the school, that has a name and a 
 * list of gradebooks for the courses that they teach
 * 
 * @author Austin Colcord
 * @version 2014-04-06
 *
 */
public class Instructor {
    String name;
    ArrayList<GradeBook> gBookList;
    
    Instructor(String name, ArrayList<GradeBook> gBookList) {
        this.name = name;
        this.gBookList = new ArrayList<GradeBook>();
    }
}
