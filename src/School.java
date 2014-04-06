import java.util.ArrayList;

/** represents the starting point for the grade system that contains a
 * name for the school, a list of instructors, and a list of students in 
 * the school
 * @author Austin Colcord
 * @version 2014-04-06
 *
 */
public class School {
    String name;
    ArrayList<Instructor> instructorList;
    ArrayList<Student> studentList;
    
    School(String name, 
            ArrayList<Instructor> instructor, 
            ArrayList<Student> student) {
        this.name = name;
        this.instructorList = new ArrayList<Instructor>();
        this.studentList = new ArrayList<Student>();
    }
}
