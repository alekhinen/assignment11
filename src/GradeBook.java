import java.util.ArrayList;
import java.util.HashMap;

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
    HashMap<Student, ArrayList<Assignment>> studAssignMap;
    
    GradeBook(String courseName, 
            HashMap<Student, ArrayList<Assignment>> studAssignMap) {
        this.courseName = courseName;
        this.studAssignMap = new HashMap<Student, ArrayList<Assignment>>();
    }
    
    /**
     * Changes the assignment (named assignmentName) grade for student (whose
     * username is equal to username) to newGrade
     * 
     * @param assignmentName
     *            name of the assignment
     * @param username
     *            username for the student
     * @param newGrade
     *            the new grade for the given assignment and student
     * @return whether there was a grade to change. Returns true if the given
     *         assignment/student combination exists, returns false otherwise
     */
    public boolean changeGrade(String assignmentName,
            String username, double newGrade) {
        for (Assignment a : )
        this.studAssignMap.entrySet(username, newArray)
    }
}
