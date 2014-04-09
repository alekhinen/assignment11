package MyGradeBook;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/** represents the grade book of a course that holds a hashmap of the students
 * and their respective assignment lists with the contained grades
 * 
 * @author Austin Colcord
 * @author Charles Perrone
 * @version 2014-04-06
 *
 */
public class Course extends MyGradeBook {

    ///////////////////////////////////////////////////////////////////////////
    // FIELDS /////////////////////////////////////////////////////////////////

    /** The mapping of students and assignments. */
    HashMap<Student, ArrayList<Assignment>> studAssignMap;

    ///////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS ///////////////////////////////////////////////////////////

    /** Creates a new instance of a GradeBook that contains a
     * a hashmap of student as a key and assignment array as val
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     * 
     * @param studAssignMap
     */
    Course(HashMap<Student, ArrayList<Assignment>> studAssignMap) {
        this.studAssignMap = studAssignMap;
    }

    /** Creates an empty instance of a GradeBook that contains a
     *  empty hashmap of student as a key and assignment array as val
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     * 
     * @param studAssignMap
     */
    Course() {
        this.studAssignMap = new HashMap<Student, ArrayList<Assignment>>();
    }





    ///////////////////////////////////////////////////////////////////////////
    // METHODS ////////////////////////////////////////////////////////////////

    /** create a new instance of an empty gradeBook (the factory method)
     * 
     * @author Austin Colcord
     * @version 2014-04-08 TESTED
     * 
     * 
     */
    public static Course newGradeBook() {
        return new Course();
    }

    /** create a new instance of a gradeBook with 
     * the given HashMap<Student, ArrayList<Assignment>> (factory method)
     * 
     * @author Chris Clark
     * @version 2014-04-08
     * 
     * @param map the HashMap<Student, ArrayList <Assignment>>
     *               to create the course with
     */
    public static Course newGradeBook(
            HashMap<Student, ArrayList<Assignment>> map) {
        return new Course(map);
    }

    /** overriding the equals method for GradeBook class
     * 
     * @author Austin Colcord
     * @version 2014-04-07 TESTED
     * 
     * @param other the object to compare to this gradebook
     * @return boolean true if the other object is equal to this gradebook
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Course) {
            return this.studAssignMap.equals(((Course) other).studAssignMap);
        }
        else {
            return false;
        }
    }


    /** override the hashcode method for student class
     * 
     * @author Austin Colcord
     * @version 2014-04-07 TESTED
     * 
     * @return int the hashcode for this student
     */
    @Override
    public int hashCode() {
        return this.studAssignMap.hashCode();
    }


    /**
     * Changes the assignment (named assignmentName) grade for student (whose
     * username is equal to username) to newGrade
     * 
     * @author Austin Colcord
     * @version 2014-04-08 TESTED
     * 
     * @param assignmentName - name of the assignment
     * @param username - username for the student
     * @param newGrade - the new grade for the given assignment and student
     * @return whether there was a grade to change. Returns true if the given
     *         assignment/student combination exists, returns false otherwise
     */
    public boolean changeGrade(String assignmentName,
            String username, double newGrade) {
        //set the result
        boolean result = false;

        Set<Student> students = this.studAssignMap.keySet();

        for (Student s : students) {
            if (s.userName.equals(username)) {
                //for every assignment in assignmentlist of the student
                for (Assignment a : this.studAssignMap.get(s)) {
                    //if the given assignmentname 
                    //equals this current name, change it
                    // and break
                    if (a.name.equals(assignmentName)) {
                        if (a.score.equals(newGrade)) {
                            a.changeScore(newGrade);
                            result = false;
                        }
                        else {
                            a.changeScore(newGrade);
                            result = true;
                        }
                    }
                }
            }
        }
        return result;
    }


    /**
     * Calculates the average across all students for a given assignment
     * 
     * @author Charles Perrone
     * @author Austin Colcord
     * @version 2014-04-08 TESTED
     * 
     * @param assignmentName - name of the assignment
     * @return the average across all students for assignmentName
     */
    public double average(String assignmentName) {

        ArrayList<Double> list = this.makeList(assignmentName);
        double totalStudents = list.size();
        double sum = 0;

        for (Double d : list) {
            if (!d.equals(null)) {
                sum += d;
            }
        }
        return sum/totalStudents;
    }

    /**
     * Return a sorted ArrayList that contains
     * all student's grades for the given assignment
     * 
     * @author Charles Perrone
     * @version 2014-04-07 TESTED
     * 
     * @param assignmentName the assignment we are searching for
     * @return the sorted ArrayList
     */
    public ArrayList<Double> makeList(String assignmentName) {

        Set<Student> students = this.studAssignMap.keySet();

        ArrayList<Double> result = new ArrayList<Double>();

        for (Student s : students) {
            ArrayList<Assignment> ass = this.studAssignMap.get(s);

            for(int i = 0; i < ass.size(); i++) {
                Assignment current = ass.get(i);

                if (current.name.equals(assignmentName)) {
                    double percent = 100 * (current.score/current.total);
                    result.add(percent);
                }
            }
        }
        Collections.sort(result);
        return result;
    }


    /**
     * Calculates the median across all students for a given assignment
     * 
     * @author Charles Perrone
     * @version 2014-04-07 TESTED
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the median across all students for assignmentName
     */
    public double median(String assignmentName) {

        ArrayList<Double> list = this.makeList(assignmentName);
        
        list.removeAll(Collections.singleton(null));
        
        //if x is even, take the higher value
        if (list.size() % 1 == 1) {
            int x = list.size()/2;
            return list.get(x + 1);
        }
        //else return the middle
        else return list.get(list.size()/2);
    }


    /**
     * Calculates the min across all students for a given assignment
     * 
     * @author Charles Perrone
     * @version 2014-04-07 TESTED
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the min across all students for assignmentName
     */
    public double min(String assignmentName) {

        ArrayList<Double> list = this.makeList(assignmentName);
        
        list.removeAll(Collections.singleton(null));
        
        return list.get(0);
    }

    /**
     * Calculates the max across all students for a given assignment
     * 
     * @author Charles Perrone
     * @version 2014-04-07 TESTED
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the max across all students for assignmentName
     */
    public double max(String assignmentName) {

        ArrayList<Double> list = this.makeList(assignmentName);

        list.removeAll(Collections.singleton(null));
        
        return list.get(list.size() - 1);
    }


    /**
     * Calculates the current grade for the given student
     * 
     * @author Nick Alekhine
     * @version 2012-04-06 TESTED
     * 
     * @param username
     *            username for the student
     * @return the current grade for student with username. The current grade is
     *         calculated based on the current assignment grades, assignment
     *         total points, assignment percent of semester. The current grade
     *         for a student is the sum of the relative assignment grades
     *         divided by the current percent of semester time 100. Since all
     *         grades may not currently be entered, we have to divide by the
     *         current percent. The relative assignment grade is the student's
     *         assignment grade divide by total point value for the assignment
     *         times the percent of semester.
     */
    // TODO return a println when there is no result?
    public double currentGrade(String username) {
        // Get the student with the given username
        Student s = this.getStudent(username); 
        ArrayList<Assignment> assignments = this.studAssignMap.get(s);
        double result = 0; 
        double weight = 0;

        // If the user exists, total the grade.
        if (s != null) {
            for (Assignment a : assignments) {
                weight += a.weight;
                result += (((a.score / a.total) * 100) * a.weight);
            }
        }

        result = result / weight;
        result = Math.round( result * 100.0 ) / 100.0;
        return result;
    }

    /** 
     * To get the Student with the given username from the student mapping.
     * 
     * @author Nick Alekhine
     * @version 2014-04-07 TESTED
     * @param username
     * @return
     */
    // TODO return a println when there is no result?
    public Student getStudent(String username) {
        // Get all students 
        Set<Student> students = this.studAssignMap.keySet();

        // Go through each element of the keySet and check if there is a match.
        for (Student s : students) {
            if (s.userName.equals(username)) {
                return s;
            }
        }
        return null;
    }


    /**
     * To return a mapping of all students and their grade
     * 
     * @author Nick Alekhine
     * @version 2014-04-07 TESTED
     * 
     * @return a mapping of all students and their grades.
     */
    public HashMap<String, Double> currentGrades() {
        HashMap<String, Double> result = new HashMap<String, Double>();

        for (Student s : this.studAssignMap.keySet()) {
            result.put(s.userName, this.currentGrade(s.userName));
        }
        return result;
    }


    /**
     * Provides the grade earned by the given student for the given assignment
     * 
     * @author Nick Alekhine
     * @version 2014-04-07 TESTED
     * 
     * @param assignmentName - name of the assignment
     * @param username - username for the student
     * @return the grade earned by username for assignmentName
     */
    // TODO return a println when there is no result?
    @Override
    public double assignmentGrade(String assignmentName, String username) {
        double result = 0;
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        Student s = this.getStudent(username);

        if (s != null) {
            assignments = this.studAssignMap.get(s);

            for (Assignment a : assignments) {
                if (a.name.equals(assignmentName)) {
                    result = ((a.score / a.total) * 100);
                    break;
                }
            }
        }

        result = Math.round( result * 100.0 ) / 100.0;
        return result;
    }





    @Override
    public String outputCurrentGrades() {
        // TODO Auto-generated method stub
        return null;
    }





    @Override
    public String outputStudentGrades(String username) {
        // TODO Auto-generated method stub
        return null;
    }





    @Override
    public String outputAssignmentGrades(String assignName) {
        // TODO Auto-generated method stub
        return null;
    }





    @Override
    public String outputGradebook() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return this.studAssignMap.toString();
    }
}
