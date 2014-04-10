package gradebook;
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
     * The constructor for Assignment that does not accept a score
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

    /**
     * The constructor for Assignment that accepts a score
     * @param name the name of the assignment
     * @param total the total points possible for the student to get
     * @param weight the weight of this assignment on
     *               the overall grade of the student
     * @param score the scored grade for the assignment
     */
    public Assignment(String name, double total, double score, double weight) {
        this.name = name;
        this.total = total;
        this.weight = weight;
        this.score = score;
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
            if (this.score == null) {
                return this.name.equals(((Assignment) other).name) &&
                        this.total.equals(((Assignment) other).total) &&
                        this.weight.equals(((Assignment) other).weight) &&
                        ((Assignment) other).score == null;
            }
            else {
                return this.name.equals(((Assignment) other).name) &&
                        this.total.equals(((Assignment) other).total) &&
                        this.weight.equals(((Assignment) other).weight) &&
                        this.score.equals(((Assignment) other).score);
            }
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
        if (this.score == null) {
            return this.name.hashCode() +
                    this.total.hashCode() +
                    this.weight.hashCode();
        }
        else {
            return this.name.hashCode() +
                    this.total.hashCode() +
                    this.weight.hashCode() +
                    this.score.hashCode();
        }
    }

    /**
     * override the toString method
     * 
     * @author charlesperrone
     * 
     * @return the name of the assignment
     */
    @Override
    public String toString() {
        return this.name + " total:" + this.total + 
                " weight:" + this.weight + " score:" + this.score;
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
