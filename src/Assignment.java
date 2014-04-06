/** represents a single assignment that is assigned under a course
 * containing a name for the assignment, a weight for the total course grade,
 * and a score that the individual received. the score will only be set
 * under the specific student, and will start as 'null' when the instructor
 * creates the course
 *
 * @author Austin Colcord
 * @version 2014-04-06
 *
 */
public class Assignment {
    String name;
    double total;
    double weight;
    Double score;
    
    /**
     * The constructor for Assignment that works for addAssignments.txt
     * @param name the name of the assignment
     * @param total the total points possible for the student to get
     * @param weight the weight of this assignment on
     *               the overall grade of the student
     * The score will be set when the instructor changes the student's grade
     */
    Assignment(String name, double total, double weight) {
        this.name = name;
        this.total = total;
        this.weight = weight;
        this.score = null;
    }
}
