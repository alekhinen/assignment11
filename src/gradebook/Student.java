package gradebook;

/** represents a student in the schoool that contains a name and a hashmap/map
 * of the assignments that the student has assigned to him
 * 
 * @author Austin Colcord
 * @author Nick Alekhine
 * @author Charles Perrone
 * @version 2014-04-06
 *
 */
public class Student {

    ///////////////////////////////////////////////////////////////////////////
    // FIELDS /////////////////////////////////////////////////////////////////

    /** The username of this student */
    String userName;
    /** The first name of this student */
    String firstName;
    /** The last name of this student */
    String lastName;
    /** The advisor name of this student */
    String advisor;
    /** The year that this student is graduating */
    int gradYear;





    ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS ///////////////////////////////////////////////////////////

    /** creates a new student with username, firstname, lastname, advisor, and
     * gradyear
     * 
     * @param userName the username for the student
     * @param firstName the first name for the student
     * @param lastName the last name for the student
     * @param advisor the student's advisor
     * @param gradYear the student's graduation year
     */
    public Student(String userName, 
            String firstName, 
            String lastName, 
            String advisor, 
            int gradYear) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.advisor = advisor;
        this.gradYear = gradYear;
    }





    ///////////////////////////////////////////////////////////////////////////
    // METHODS ////////////////////////////////////////////////////////////////

    /** overriding the equals method for student class
     * 
     * @author Austin Colcord
     * 
     * @param other the object to compare to this student
     * @return boolean true if the other object is equal to this student
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Student) {
            return this.userName.equals(((Student) other).userName) &&
                    this.firstName.equals(((Student) other).firstName) &&
                    this.lastName.equals(((Student) other).lastName) &&
                    this.advisor.equals(((Student) other).advisor) &&
                    this.gradYear == ((Student) other).gradYear;
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
        return this.userName.hashCode() +
                this.firstName.hashCode() +
                this.lastName.hashCode() +
                this.advisor.hashCode() +
                this.gradYear;
    }

    /**
     * override the toString method
     * 
     * @author charlesperrone
     * 
     * @return this Student's userName
     */
    @Override
    public String toString() {
        return this.userName + this.firstName;
    }

}
