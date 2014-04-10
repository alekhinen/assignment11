package gradebook;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
     * @param studAssignMap the hashmap of students and lists of assignments
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
     * @return Course a new empty instance of a course
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
     * @return Course a new instance of a course with a hashmap
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
    public double average(
            String assignmentName) throws NoSuchElementException {
        if (this.studAssignMap.isEmpty()) {
            throw new NoSuchElementException("This Gradebook is Empty");
        }
        
        ArrayList<Student> studList =
                new ArrayList<Student>(this.studAssignMap.keySet());

        Student firstStudent = studList.get(0);

        ArrayList<Assignment> firstAssignList = 
                this.studAssignMap.get(firstStudent);


        boolean hasFoundAssignment = false;

        for (Assignment a : firstAssignList) {
            if (a.name.equals(assignmentName)) {
                hasFoundAssignment = true;
                break;
            }
        }
        
        if (!hasFoundAssignment) {
            throw new NoSuchElementException(
                    "The given assignment does not exist");
        }

        ArrayList<Double> list = this.makeList(assignmentName);
        double totalStudents = list.size();
        double sum = 0;

        for (Double d : list) {
            if (d != null) {
                sum += d;
            }
        }
        return sum / totalStudents;
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

            for (int i = 0; i < ass.size(); i++) {
                Assignment current = ass.get(i);

                if (current.name.equals(assignmentName)) {
                    double percent = current.score;
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
    public double median(String assignmentName) throws NoSuchElementException {
        
        if (this.studAssignMap.isEmpty()) {
            throw new NoSuchElementException("This Gradebook is Empty");
        }
        
        ArrayList<Student> studList =
                new ArrayList<Student>(this.studAssignMap.keySet());

        Student firstStudent = studList.get(0);

        ArrayList<Assignment> firstAssignList = 
                this.studAssignMap.get(firstStudent);


        boolean hasFoundAssignment = false;

        for (Assignment a : firstAssignList) {
            if (a.name.equals(assignmentName)) {
                hasFoundAssignment = true;
                break;
            }
        }
        
        if (!hasFoundAssignment) {
            throw new NoSuchElementException(
                    "The given assignment does not exist");
        }

        ArrayList<Double> list = this.makeList(assignmentName);

        list.removeAll(Collections.singleton(null));

        //if x is even, take the higher value
        if (list.size() % 1 == 1) {
            int x = list.size() / 2;
            return list.get(x + 1);
        }
        //else return the middle
        else {
            return list.get(list.size() / 2);
        }
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
    public double min(String assignmentName) throws NoSuchElementException {

        if (this.studAssignMap.isEmpty()) {
            throw new NoSuchElementException("This Gradebook is Empty");
        }
        
        ArrayList<Student> studList =
                new ArrayList<Student>(this.studAssignMap.keySet());

        Student firstStudent = studList.get(0);

        ArrayList<Assignment> firstAssignList = 
                this.studAssignMap.get(firstStudent);


        boolean hasFoundAssignment = false;

        for (Assignment a : firstAssignList) {
            if (a.name.equals(assignmentName)) {
                hasFoundAssignment = true;
                break;
            }
        }
        
        if (!hasFoundAssignment) {
            throw new NoSuchElementException(
                    "The given assignment does not exist");
        }
        
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
    public double max(String assignmentName) throws NoSuchElementException {

        if (this.studAssignMap.isEmpty()) {
            throw new NoSuchElementException("This Gradebook is Empty");
        }
        
        ArrayList<Student> studList =
                new ArrayList<Student>(this.studAssignMap.keySet());

        Student firstStudent = studList.get(0);

        ArrayList<Assignment> firstAssignList = 
                this.studAssignMap.get(firstStudent);


        boolean hasFoundAssignment = false;

        for (Assignment a : firstAssignList) {
            if (a.name.equals(assignmentName)) {
                hasFoundAssignment = true;
                break;
            }
        }
        
        if (!hasFoundAssignment) {
            throw new NoSuchElementException(
                    "The given assignment does not exist");
        }
        
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
     * @param username the username to search for in this gradebook
     * @return Student the student that is found out of the gradebook
     */
    protected Student getStudent(String username) {
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
    @Override
    public double assignmentGrade(String assignmentName, String username) {
        
        double result = 0;
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        Student s = this.getStudent(username);

        if (s != null) {
            assignments = this.studAssignMap.get(s);

            for (Assignment a : assignments) {
                if (a.name.equals(assignmentName)) {
                    result = a.score;
                    break;
                }
            }
        }

        //result = Math.round( result * 100.0 ) / 100.0;
        return result;
    }




    /**
     * Provide a String that contains the current grades of all students in the
     * course
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     * 
     * @return a String that contains the current grades of all students in the
     *         course. The String should be formatted like
     *         currentGrades.txt---CURRENT_GRADES heading and each row: username
     *         followed by tab and current grade. The usernames will be listed
     *         alphabetically.
     */
    @Override
    public String outputCurrentGrades() throws NoSuchElementException {
        if (this.studAssignMap.isEmpty()) {
            throw new NoSuchElementException("THIS GRADEBOOK IS EMPTY");
        }

        String result = "CURRENT_GRADES\n";

        ArrayList<Student> studList =
                new ArrayList<Student>(this.studAssignMap.keySet());
        Collections.sort(studList, new StudentComparator());

        for (Student s : studList) {
            result = result +
                    s.userName + 
                    "\t" + 
                    this.currentGrade(s.userName) + "\n";
        }
        return result;
    }




    /**
     * Provide a String that contains the current grades of the given student
     * 
     * @author Austin Colcord
     * @version 2014-04-09
     * 
     * @param username
     *            username for student
     * @return a String that contains the current grades of username. The String
     *         should be formatted like studentGrades.txt---STUDENT_GRADES
     *         heading, student info, dividers, each assignment (assignment name
     *         followed by tab and assignment grade), and current grade.
     *         Assignments are to remain in the same order as given.
     */
    @Override
    public String outputStudentGrades(String u) throws NoSuchElementException {

        if (this.studAssignMap.isEmpty()) {
            throw new NoSuchElementException("THIS GRADEBOOK IS EMPTY");
        }

        String result;
        boolean hasFoundStudent = false;

        for (Student s : this.studAssignMap.keySet()) {
            if (u.equals(s.userName)) {
                hasFoundStudent = true;
                break;
            }
        }

        if (!hasFoundStudent) {
            throw new NoSuchElementException("Student does not exist!");
        }


        result = "STUDENT_GRADES\n";

        ArrayList<Student> studList =
                new ArrayList<Student>(this.studAssignMap.keySet());

        Collections.sort(studList, new StudentComparator());


        for (Student s : studList) {

            ArrayList<Assignment> ass = this.studAssignMap.get(s);

            if (s.userName.equals(u)) {
                String assString = "";
                for (Assignment a : ass) {
                    assString = assString + a.name + "\t" + a.score + "\n";
                }
                result = 
                        result + 
                        s.userName + "\n" +
                        s.firstName + "\n" +
                        s.lastName + "\n" +
                        s.advisor + "\n" +
                        s.gradYear + "\n" +
                        "----\n" +
                        assString +
                        "----\n" +
                        "CURRENT GRADE" + "\t" + 
                        this.currentGrade(s.userName) + "\n";
                break;
            }
        }



        return result;
    }




    /**
     * Provide a String that contains the assignment grades of all students in
     * the course for the given assignment
     * 
     * @author Austin Colcord
     * @version 2014-04-09
     * 
     * @param assignName
     *            name of the assignment
     * @return a String that contains the assignment grades of all students in
     *         the course for assignName. The String should be formatted like
     *         assignmentGrade.txt---ASSIGNMENT_GRADES heading, assignment info,
     *         dividers, each student (username followed by tab and assignment
     *         grade), and assignment stats. The usernames will be listed
     *         alphabetically while assignments are to remain in the same 
     *         order as given.
     */
    @Override
    public String outputAssignmentGrades(
            String assignName) throws NoSuchElementException {
        String result = "ASSIGNMENT_GRADES\n";

        if (this.studAssignMap.isEmpty()) {
            throw new NoSuchElementException("THIS GRADEBOOK IS EMPTY");
        }



        ArrayList<Student> studList =
                new ArrayList<Student>(this.studAssignMap.keySet());

        Collections.sort(studList, new StudentComparator());

        Student firstStudent = studList.get(0);

        ArrayList<Assignment> firstAssignList = 
                this.studAssignMap.get(firstStudent);


        boolean hasFoundAssignment = false;

        for (Assignment a : firstAssignList) {
            if (a.name.equals(assignName)) {
                hasFoundAssignment = true;
                break;
            }
        }

        if (!hasFoundAssignment) {
            throw new NoSuchElementException("The assignment does not exist!");
        }


        String assignInfo = "";

        for (Assignment a : firstAssignList) {
            if (a.name.equals(assignName)) {
                assignInfo = 
                        assignInfo + a.name + "\n" +
                                a.total + "\n" +
                                a.weight;
            }
        }


        result = result + assignInfo + "\n----\n";

        for (Student s : studList) {
            result = result + s.userName + "\t" +
                    this.assignmentGrade(assignName, s.userName) + "\n";
        }
        result = result + "----\n" + "STATS\n" + 
                "Average\t" + this.average(assignName) + "\n" +
                "Median\t" + this.median(assignName) + "\n" +
                "Max\t" + this.max(assignName) + "\n" +
                "Min\t" + this.min(assignName);
        return result;
    }




    /**
     * Provide a String that contains the current grade book. This String could
     * be used to initialize a new grade book.
     * 
     * @author Austin Colcord
     * @version 2014-04-09
     * 
     * @return a String that contains the current grade book. This String could
     *         be used to initialize a new grade book. The String should be
     *         formatted like gradebook.txt. The usernames will be listed
     *         alphabetically.
     */
    @Override
    public String outputGradebook() throws NoSuchElementException {

        if (this.studAssignMap.isEmpty()) {
            throw new NoSuchElementException("THIS GRADEBOOK IS EMPTY");
        }

        ///GETTING THE ASSIGNMENT NAMES, TOTALS, AND WEIGHTS FOR TOP ROW//////

        ArrayList<Student> studList =
                new ArrayList<Student>(this.studAssignMap.keySet());

        Student firstStudent = studList.get(0);

        ArrayList<Assignment> firstAssignList = 
                this.studAssignMap.get(firstStudent);

        String assigns = "";
        String totals = "";
        String weights = "";


        for (Assignment a : firstAssignList) {
            assigns = assigns + "\t" + a.name;
            totals = totals + "\t" + a.total;
            weights = weights + "\t" + a.weight;
        }


        //////////////////////////////////////////////////////////////////////

        //////GRABBING THE STUDENT'S INFO WITH RESPECTIVE ASSIGNMENT GRADES///
        Collections.sort(studList, new StudentComparator());

        String totalStudInfo = "";

        for (Student s : studList) {
            String thisStudAssInfo = "";
            for (Assignment ass : this.studAssignMap.get(s)) {
                thisStudAssInfo = thisStudAssInfo + "\t" + ass.score;
            }

            totalStudInfo =
                    totalStudInfo +
                    s.userName + "\t" + 
                    s.firstName + "\t" +
                    s.lastName + "\t" +
                    s.advisor + "\t" +
                    s.gradYear + thisStudAssInfo + "\n";
        }




        //////////////////////////////////////////////////////////////////////

        ///PUTTING ALL OF THE INFORMATION INTO THE RESULT STRING, RETURNING///
        String result = "GRADEBOOK\n";
        result = result + "\t" + "\t" + "\t" + "\t" + assigns + "\n" +
                "\t" + "\t" + "\t" + "\t" + totals + "\n" +
                "\t" + "\t" + "\t" + "\t" + weights + "\n" +
                totalStudInfo;

        return result;
    }

    @Override
    public String toString() {
        return this.studAssignMap.toString();
    }

    /**
     * Add all of the elements in the given arrayList to 
     * every student's assignment list
     * 
     * @author Charles Perrone
     * @version 2014-04-09
     * 
     * @param assList the assignment list to add grades from
     */
    public void addGrades(ArrayList<Assignment> assList) {
        HashMap<Student, ArrayList<Assignment>> map = this.studAssignMap;
        Set<Student> studs = this.studAssignMap.keySet();

        for (Student s : studs) {
            ArrayList<Assignment> current = map.get(s);
            ArrayList<Assignment> result = new ArrayList<Assignment>();
            result.addAll(current);
            result.addAll(assList);

            this.studAssignMap.put(s, result);
        }
    }
    
    /** adds an arrayList of students to the current course
     * 
     * @author Charles Perrone
     * @version 2014-04-09
     * 
     * @param studList the arraylist of students to add
     */
    public void addStudents(ArrayList<Student> studList) {
        Set<Student> studSet = this.studAssignMap.keySet();
        Iterator<Student> it = studSet.iterator();
        ArrayList<Assignment> newStudList = new ArrayList<Assignment>();
        
        if (this.studAssignMap.isEmpty()) {
            for (Student s : studList) {
                this.studAssignMap.put(s, new ArrayList<Assignment>());
            }
        }
        
        else {
            Student template = it.next();
            ArrayList<Assignment> tempList = this.studAssignMap.get(template);
            
            for (Assignment a : tempList) {
                Assignment neu = new Assignment(a.name, a.total, a.weight);
                newStudList.add(neu);
            }
            
            for (Student s : studList) {
                this.studAssignMap.put(s, newStudList);
            }
        }
    }
}
