package gradebook;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Nick Alekhine
 * @author Austin Colcord
 * @author Charles Perrone
 * @version 2014-04-06
 *
 */

public abstract class MyGradeBook {

    ///////////////////////////////////////////////////////////////////////////
    // STATIC METHODS /////////////////////////////////////////////////////////

    /**Factory method to construct an empty MyGradebook 
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     * 
     * @return an empty MyGradeBook
     */
    public static MyGradeBook initialize() {
        return Course.newGradeBook();
    }


    /**
     * Factory method to construct a MyGradebook that contains the grade book
     * from filename
     * 
     * @param filename
     *            the filename for the file that contains the initial grade
     *            book, which is formatted like initial.txt
     * @return a MyGradebook that contains the grade book from filename
     * @throws FileNotFoundException 
     */
    public static MyGradeBook initializeWithFile(
            String filename) {

        HashMap<Student, ArrayList<Assignment>> map = 
                new HashMap<Student, ArrayList<Assignment>>();


        try {
            
        File file = new File(filename);
        Scanner fileSC = new Scanner(file).useDelimiter("\t");

        fileSC.next();

        String line1 = fileSC.nextLine().trim();
        String line2 = fileSC.nextLine().trim();
        String line3 = fileSC.nextLine().trim();

        Scanner scanLine1 = new Scanner(line1.trim()).useDelimiter("\t");
        Scanner scanLine2 = new Scanner(line2.trim()).useDelimiter("\t");
        Scanner scanLine3 = new Scanner(line3.trim()).useDelimiter("\t");

        //Accumulator lists
        ArrayList<Assignment> assList = new ArrayList<Assignment>();
        ArrayList<Student> studList = new ArrayList<Student>();

        //build the list of assignments
        while (scanLine1.hasNext()) {
            try {
                String assName = scanLine1.next();
                double total = scanLine2.nextDouble();
                double weight = scanLine3.nextDouble();

                Assignment ass = new Assignment(assName, total, weight);
                assList.add(ass);
            }
            catch (Exception e) {
                System.out.println("File formatted incorrectly");
            }
        }

        // Create student object
        while (fileSC.hasNextLine()) {
            ArrayList<Assignment> urList = new ArrayList<Assignment>();

            String line = fileSC.nextLine();
            Scanner studScan = new Scanner(line).useDelimiter("\t");

            String user = studScan.next();
            String first = studScan.next();
            String last = studScan.next();
            String advisor = studScan.next();
            int year = studScan.nextInt();

            Student stud = new Student(user, first, last, advisor, year);
            studList.add(stud);


            int count = 0;
            while (studScan.hasNextDouble()) {

                if (count > assList.size()) {
                    throw new RuntimeException("assignment list number error");
                }

                else {
                    double next = studScan.nextDouble();
                    Assignment current = assList.get(count);
                    String name = current.name;
                    double weight = current.weight;
                    double total = current.total;
                    count++;

                    Assignment newass = 
                            new Assignment(name, total, next, weight);
                    urList.add(newass);
                }
            }
            map.put(stud, urList);
        }
        
        }
        
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return new Course(map);
    }

    /**
     * Factory method to construct a MyGradebook that contains the grade book
     * from startingString
     * 
     * @param startingString
     *            String that contains the initial grade book, which is
     *            formatted like initial.txt
     * @return a MyGradebook that contains the grade book from startingString
     */
    public static MyGradeBook initializeWithString(
            String startingString) {
        
        HashMap<Student, ArrayList<Assignment>> map = 
                new HashMap<Student, ArrayList<Assignment>>();

        Scanner fileSC = new Scanner(startingString).useDelimiter("\t");

        fileSC.next();
        
        if (fileSC.hasNextLine()) {
        String line1 = fileSC.nextLine().trim();
        String line2 = fileSC.nextLine().trim();
        String line3 = fileSC.nextLine().trim();

        Scanner scanLine1 = new Scanner(line1).useDelimiter("\t");
        Scanner scanLine2 = new Scanner(line2).useDelimiter("\t");
        Scanner scanLine3 = new Scanner(line3).useDelimiter("\t");

        //Accumulator lists
        ArrayList<Assignment> assList = new ArrayList<Assignment>();
        ArrayList<Student> studList = new ArrayList<Student>();

        while (scanLine1.hasNext()) {
            try {
                String assName = scanLine1.next();
                double total = scanLine2.nextDouble();
                double weight = scanLine3.nextDouble();

                Assignment ass = new Assignment(assName, total, weight);
                assList.add(ass);
            }
            catch (Exception e) {
                System.out.println("File formatted incorrectly");
            }
        }

        // Create student object
        while (fileSC.hasNextLine()) {
            ArrayList<Assignment> urList = new ArrayList<Assignment>();

            String line = fileSC.nextLine();
            Scanner studScan = new Scanner(line).useDelimiter("\t");

            String user = studScan.next();
            String first = studScan.next();
            String last = studScan.next();
            String advisor = studScan.next();
            int year = studScan.nextInt();

            Student stud = new Student(user, first, last, advisor, year);
            studList.add(stud);

            int count = 0;
            while (studScan.hasNextDouble()) {

                if (count > assList.size()) {
                    throw new RuntimeException("assignment list number error");
                }

                else {
                    double next = studScan.nextDouble();
                    Assignment current = assList.get(count);
                    String name = current.name;
                    double weight = current.weight;
                    double total = current.total;
                    count++;

                    Assignment newass = 
                            new Assignment(name, total, next, weight);
                    urList.add(newass);
                }
            }
            map.put(stud, urList);
        }
        
        return new Course(map);
        }
        
        else {
            return new Course();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // DYNAMIC METHODS ////////////////////////////////////////////////////////

    /**
     * Add to the state of this grade book---new assignments, new students, new
     * grades---by processing filename
     * 
     * @param filename
     *            the filename for a file that contains information that will be
     *            added to the grade book. The file could contain several
     *            different types of information---new assignments, new
     *            students, new grades. The file will be formatted like
     *            addAssignments.txt, addStudents.txt, gradesForAssignment1.txt,
     *            and gradesForStudent.txt.
     * @throws FileNotFoundException 
     */
    public void processFile(String filename) {

        // load the file
        File file = new File(filename);
        Scanner sc;
        try {
            sc = new Scanner(file).useDelimiter("\n");

            ArrayList<Assignment> assList = new ArrayList<Assignment>();
            ArrayList<Student> studList = new ArrayList<Student>();

            // Pick the first String (the type of processing)
            String type = sc.next();

            //Add a list of grades to GradeBook
            if (type.equals("ASSIGNMENT")) {

                while (sc.hasNext()) {
                    String name = sc.next();
                    double total = sc.nextDouble();
                    double weight = sc.nextDouble();

                    Assignment made = new Assignment(name, total, weight);
                    assList.add(made);

                    try {
                        sc.next();
                    }
                    catch (Exception e) { }
                }
                this.addGrades(assList);
            }

            //Add a list of students to the GradeBook
            else if (type.equals("STUDENT")) {

                while (sc.hasNext()) {
                    String username = sc.next();
                    String firstName = sc.next();
                    String middleName = sc.next();
                    String lastName = sc.next();
                    int year = sc.nextInt();

                    Student stud = new Student(username, firstName,
                            middleName, lastName, year);

                    studList.add(stud);

                    try {
                        sc.next(); 
                    }
                    catch (Exception e) { }
                }
                this.addStudents(studList);
            }

            else if (type.equals("GRADES_FOR_STUDENT")) {
                String username = sc.next();

                while (sc.hasNext()) {
                    String assName = sc.next();
                    double grade = sc.nextInt();

                    this.changeGrade(assName, username, grade);
                }
            }

            else if (type.equals("GRADES_FOR_ASSIGNMENT")) {
                String assName = sc.next();

                while (sc.hasNext()) {
                    String username = sc.next();
                    double grade = sc.nextInt();

                    this.changeGrade(assName, username, grade);
                }
            }

            else {
                throw new RuntimeException();
            }
        }

        catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }




    /**
     * Add to the state of this grade book---new assignments, new students, new
     * grades---by processing additionalString
     * 
     * @param additionalString
     *            String that contains information that will be added to the
     *            grade book. The String could contain several different types
     *            of information---new assignments, new students, new grades.
     *            The String will be formatted like addAssignments.txt,
     *            addStudents.txt, gradesForAssignment1.txt, and
     *            gradesForStudent.txt.
     */
    public void processString(String additionalString) {
        
        // load the file
        Scanner sc = new Scanner(additionalString).useDelimiter("\n");

        ArrayList<Assignment> assList = new ArrayList<Assignment>();
        ArrayList<Student> studList = new ArrayList<Student>();

        // Pick the first String (the type of processing)
        String type = sc.next();

        //Add a list of grades to GradeBook
        if (type.equals("ASSIGNMENT")) {

            while (sc.hasNext()) {
                String name = sc.next();
                double total = sc.nextDouble();
                double weight = sc.nextDouble();

                Assignment made = new Assignment(name, total, weight);
                assList.add(made);

                try {
                    sc.next();
                }
                catch (Exception e) { }
            }
            this.addGrades(assList);
        }

        //Add a list of students to the GradeBook
        else if (type.equals("STUDENT")) {

            while (sc.hasNext()) {
                String username = sc.next();
                String firstName = sc.next();
                String middleName = sc.next();
                String lastName = sc.next();
                int year = sc.nextInt();

                Student stud = new Student(username, firstName,
                        middleName, lastName, year);

                studList.add(stud);

                try {
                    sc.next(); 
                }
                catch (Exception e) { }
            }
            this.addStudents(studList);
        }

        else if (type.equals("GRADES_FOR_STUDENT")) {
            String username = sc.next();

            while (sc.hasNext()) {
                String assName = sc.next();
                double grade = sc.nextInt();

                this.changeGrade(assName, username, grade);
            }
        }

        else if (type.equals("GRADES_FOR_ASSIGNMENT")) {
            String assName = sc.next();

            while (sc.hasNext()) {
                String username = sc.next();
                double grade = sc.nextInt();

                this.changeGrade(assName, username, grade);
            }
        }
        else {
            throw new RuntimeException();
        }
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
     *         assignment/student combination exists, and username’s 
     *         assignmentName grade is now newGrade, returns false otherwise
     */
    // TODO ...
    public abstract boolean changeGrade(String assignmentName,
            String username, double newGrade);


    /**
     * Calculates the average across all students for a given assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the average across all students for assignmentName
     */
    // TODO ...
    public abstract double average(String assignmentName);


    /**
     * Calculates the median across all students for a given assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the median across all students for assignmentName
     */
    // TODO ...
    public abstract double median(String assignmentName);


    /**
     * Calculates the min across all students for a given assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the min across all students for assignmentName
     */
    // TODO ...
    public abstract double min(String assignmentName);


    /**
     * Calculates the max across all students for a given assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the max across all students for assignmentName
     */
    // TODO ...
    public abstract double max(String assignmentName);


    /**
     * Calculates the current grade for the given student
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
    public abstract double currentGrade(String username);


    /**
     * Calculates the current grade for all students
     * 
     * @return HashMap of the current grades for all students. The key of the
     *         HashMap is the username of the student. The value is the current
     *         grade for the associated student. The current grade is calculated
     *         based on the current assignment grades, assignment total points,
     *         assignment percent of semester. The current grade for a student
     *         is the sum of the relative assignment grades divided by the
     *         current percent of semester time 100. Since all grades may not
     *         currently be entered, we have to divide by the current percent.
     *         The relative assignment grade is the student's assignment grade
     *         divide by total point value for the assignment times the percent
     *         of semester.
     */
    public abstract HashMap<String, Double> currentGrades(); 


    /**
     * Provides the grade earned by the given student for the given assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @param username
     *            username for the student
     * @return the grade earned by username for assignmentName
     */
    public abstract double assignmentGrade(String assignmentName,
            String username);


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
    public abstract String outputCurrentGrades();


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
    public abstract String outputStudentGrades(String username);


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
    public abstract String outputAssignmentGrades(String assignName);


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
    public abstract String outputGradebook(); 

    /**
     * Add a list of Assignments to every student's list of assignments
     * 
     * @param aList the list of assignments to add to every student
     */
    public abstract void addGrades(ArrayList<Assignment> aList);

    /**
     * add students to the student list
     * @param studList the students to add
     */
    public abstract void addStudents(ArrayList<Student> studList);
}
