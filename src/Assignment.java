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
    double weight;
    Double score;
    
    Assignment(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.score = null;
    }
}
