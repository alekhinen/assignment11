/** represents a single assignment that is assigned under a course
 * containing a name for the assignment, a weight for the total course grade,
 * and a score that the individual received. the score will only be set
 * under the specific student, and will start as 'null' when the instructor
 * creates the course
 *
 * @author Austin Colcord
 * @author Charles Perrone
 * @version 2014-04-06
 *
 */
public class Assignment {

    ///////////////////////////////////////////////////////////////////////////
    // FIELDS /////////////////////////////////////////////////////////////////
   
    /** The name of this assignment */
    String name;
    /** The total points of this assignment */
    Double total;
    /** the weight of this assignment on the full grade */
    Double weight;
    /** The score received on this assignment */
    Double score;





    ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS ///////////////////////////////////////////////////////////
  
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

    
    


    ///////////////////////////////////////////////////////////////////////////
    // METHODS ////////////////////////////////////////////////////////////////
    
    /** overriding the equals method for assignment class
     * 
     * @author Austin Colcord
     * 
     * @param other the object to compare to this assignment
     * @return boolean true if the other object is equal to this assignment
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Assignment) {
            return this.name.equals(((Assignment) other).name) &&
                    this.total == ((Assignment) other).total &&
                    this.weight == ((Assignment) other).weight &&
                    this.score == ((Assignment) other).score;
        }
        else {
            return false;
        }
    }
    
    /** override the hashcode method for student class
     * 
     * @author Austin Colcord
     * 
     * @return int the hashcode for this student
     */
    @Override
    public int hashCode() {
        return this.name.hashCode() +
                this.total.hashCode() +
                this.weight.hashCode() +
                this.score.hashCode();
    }
    
    /** write the method that changes the grade of this assignment to the given
     * score that the student receives
     * 
     * @author Austin Colcord
     * 
     * @param newScore the new score that the student receives (Double)
     */
    public void changeScore(Double newScore) {
        this.score = newScore;
    }
}
