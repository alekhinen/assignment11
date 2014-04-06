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

    ///////////////////////////////////////////////////////////////////////////
    // FIELDS /////////////////////////////////////////////////////////////////

    /** The name of the course for this GradeBook */
    String courseName;
    /** The mapping of students and assignments. */
    HashMap<Student, ArrayList<Assignment>> studAssignMap;





    ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS ///////////////////////////////////////////////////////////

    /**
     * 
     * @param courseName
     * @param studAssignMap
     */
    GradeBook(String courseName, 
            HashMap<Student, ArrayList<Assignment>> studAssignMap) {
        this.courseName = courseName;
        this.studAssignMap = new HashMap<Student, ArrayList<Assignment>>();
    }





    ///////////////////////////////////////////////////////////////////////////
    // METHODS ////////////////////////////////////////////////////////////////

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
        //create a duplicate of the assignment list at the given student
        ArrayList<Assignment> assignList = this.studAssignMap.get(username);
        //set the result
        boolean result = false;
        //for every assignment in assignmentlist of the student
        for (Assignment a : assignList) {
            //if the given assignmentname equals this current name, change it
            // and break
            if (a.name.equals(assignmentName)) {
                a.score = newGrade;
                result = true;
                break;
            }
        }
        this.studAssignMap.put(username, assignList);
        return result;
    }


    /**
     * To return a mapping of all students and grades associated with 
     * each student.
     */
    public HashMap<String, ArrayList<Assignment>> currentGrades() {
        HashMap<String, ArrayList<Assignment>> result 
        = new HashMap<String, ArrayList<Assignment>>();

        for (Student s : this.studAssignMap.keySet()) {

        }
        return this.studAssignMap;
    }
}
