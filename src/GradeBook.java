import java.util.ArrayList;

/** represents the grade book for each course that an instructor teaches
 * There can be multiple gradebooks for one instructor
 * this contains an arraylist of assignments that are in the course, as well
 * as the list of students assigned to this course
 * 
 * @author Austin Colcord
 * @version 2014-04-06
 *
 */
public class GradeBook {
    String courseName;
    ArrayList<Assignment> assignList;
    ArrayList<Student> studList;
    
    GradeBook(String courseName,
            ArrayList<Assignment> assignList,
            ArrayList<Student> studList) {
        this.courseName = courseName;
        this.assignList = new ArrayList<Assignment>();
        this.studList = new ArrayList<Student>();
    }
}
