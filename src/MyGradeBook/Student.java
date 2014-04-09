package MyGradeBook;
import java.util.ArrayList;
import java.util.HashMap;

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
	/** The middle name of this student */
	String middleName;
	/** The last name of this student */
	String lastName;
	/** The year that this student is graduating */
	int gradYear;





	///////////////////////////////////////////////////////////////////////////
	// CONSTRUCTORS ///////////////////////////////////////////////////////////

	/**
	 * 
	 * @param userName
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param gradYear
	 */
	Student(String userName, 
			String firstName, 
			String middleName, 
			String lastName, 
			int gradYear) {
		this.userName = userName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
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
					this.middleName.equals(((Student) other).middleName) &&
					this.lastName.equals(((Student) other).lastName)&&
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
				this.middleName.hashCode() +
				this.lastName.hashCode() +
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
		return this.userName;
	}

}
