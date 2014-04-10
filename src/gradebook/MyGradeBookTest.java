package gradebook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Test;


/**
 * The testing class for all classes and methods associated with the Gradebook.
 * @author Nick Alekhine
 * @author Charles Perrone
 * @author Austin Colcord
 * @version 2014-04-06
 * 
 */
public class MyGradeBookTest {

    ///////////////////////////////////////////////////////////////////////////
    // FIELDS /////////////////////////////////////////////////////////////////

    /** Student 1 */
    Student s1;
    /** Student 2 */
    Student s2;
    /** Student 3 */
    Student s3;

    /** Assignment 0  (empty assignment score) */
    Assignment a0;
    /** Assignment 1 */
    Assignment a1;
    /** Assignment 2 */
    Assignment a2;
    /** Assignment 3 */
    Assignment a3;
    /** Assignment 4 */
    Assignment a4;
    /** Assignment 5 */
    Assignment a5;
    /** Assignment 6 */
    Assignment a6;
    /** Assignment 7 */
    Assignment a7;
    /** Assignment 8 */
    Assignment a8;


    /** Assignments List 1 */
    ArrayList<Assignment> aList1;
    /** Assignments List 2 */
    ArrayList<Assignment> aList2;
    /** Assignments List 3 */
    ArrayList<Assignment> aList3;

    /** Student => Assignments 1 */
    HashMap<Student, ArrayList<Assignment>> map1;

    /** Course 1 */
    Course c1;
    /** Course 2 */
    Course c2;


    /** 
     * To set values to each variable. 
     * */
    public void reset() {
        /** Students */
        this.s1 = 
                new Student("chperrone", "Charles", "Haydon", "Perrone", 2017);
        this.s2 = new Student("thmyolk", "Thom", "Mearle", "Yorke", 2017);
        this.s3 = new Student("nalekhn", "Nick", "Alex", "Alekhine", 2017);

        /** Assignments */
        this.a0 = new Assignment("Assignment0", 100, .25);

        this.a1 = new Assignment("Assignment1", 100, 90, .25);
        this.a2 = new Assignment("Assignment2", 120, 115, .50);

        this.a3 = new Assignment("Assignment1", 100, 45, .25);
        this.a4 = new Assignment("Assignment2", 120, 80, .50);
        this.a5 = new Assignment("Assignment3", 100, 90, .25);

        this.a6 = new Assignment("Assignment1", 100, 96, .25);
        this.a7 = new Assignment("Assignment2", 120, 114, .50);
        this.a8 = new Assignment("Assignment3", 100, 90, .25);


        /** Populate Assignment Lists */
        this.aList1 = new ArrayList<Assignment>();
        this.aList1.add(this.a1);
        this.aList1.add(this.a2);

        this.aList2 = new ArrayList<Assignment>();
        this.aList2.add(this.a3);
        this.aList2.add(this.a4);
        this.aList2.add(this.a5);

        this.aList3 = new ArrayList<Assignment>();
        this.aList3.add(this.a6);
        this.aList3.add(this.a7);
        this.aList3.add(this.a8);

        this.map1 = new HashMap<Student, ArrayList<Assignment>>();
        this.map1.put(this.s1, this.aList1);
        this.map1.put(this.s2, this.aList2);
        this.map1.put(this.s3, this.aList3);

        this.c1 = new Course(this.map1);

        this.c2 = new Course(this.map1);
    }





    ///////////////////////////////////////////////////////////////////////////
    // METHODS ////////////////////////////////////////////////////////////////


    /** test the equals method in gradeBook, assignment, and student 
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     * */
    @Test
    public void testEquals() {
        reset();
        //test for null
        assertFalse(this.a1.equals(null));
        assertFalse(this.aList1.equals(null));
        assertFalse(this.c1.equals(null));
        assertFalse(this.map1.equals(null));
        assertFalse(this.s1.equals(null));

        //test against other object types
        assertFalse(this.a1.equals("1"));
        assertFalse(this.aList1.equals(2));
        assertFalse(this.c1.equals(new Double(4)));
        assertFalse(this.map1.equals("asd;lfkj"));
        assertFalse(this.s1.equals(new ArrayList<Integer>()));

        //test nonequal types
        assertFalse(this.a1.equals(this.a2));
        assertFalse(this.a1.equals(
                new Assignment("Assignment1", 100, 80, .25)));
        assertFalse(new Assignment(
                "TestNew", 90.0, 0.25).equals(this.a2));
        assertFalse(this.a1.equals(
                new Assignment(
                        "TestNew", 90.0, 0.25)));
        assertFalse(this.a3.equals(this.a2));
        assertFalse(this.aList1.equals(this.aList2));
        assertFalse(this.c1.equals(
                this.c1.changeGrade("Assignment1", "chperrone", 90)));

        //test equal types
        assertTrue(this.a1.equals(
                new Assignment("Assignment1", 100, 90, .25)));
        assertTrue(this.a2.equals(
                new Assignment("Assignment2", 120, 115, .50)));
        assertTrue(this.c1.equals(this.c2));
        assertTrue(this.s1.equals(
                new Student(
                        "chperrone", "Charles", "Haydon", "Perrone", 2017)));
    }

    /** test the hashCode method in gradebook, assignment, and student
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testHashCode() {
        reset();
        assertEquals(this.a1.hashCode(), -1943110940);
        assertEquals(this.a2.hashCode(), -1941325083);
        assertEquals(this.aList1.hashCode(), -2048221118);
        assertEquals(this.c1.hashCode(), this.c2.hashCode());
        assertEquals(this.c1.hashCode(), -371929608);
        assertEquals(this.map1.hashCode(), -371929608);
        assertEquals(this.s1.hashCode(), -1409632251);
        assertEquals(new Assignment(
                "TestNew", 90.0, 0.25).hashCode(), -1902779506);
    }



    /** test the changeGrade method in GradeBook 
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     * */
    @Test
    public void testChangeGrade() {
        this.reset();
        assertEquals(this.a1.score, new Double(90));
        this.c1.changeGrade("Assignment1", "chperrone", new Double(100));
        assertEquals(this.a1.score, new Double(100));

        assertEquals(this.a3.score, new Double(45));
        this.c1.changeGrade("Assignment1", "thmyolk", new Double(50));
        assertEquals(this.a3.score, new Double(50));

        assertEquals(this.a4.score, new Double(80));
        this.c1.changeGrade("Assignment2", "thmyolk", new Double(70));
        assertEquals(this.a4.score, new Double(70));
    }

    /** test the changeScore grade in Assignment 
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testChangeScore() {
        this.reset();
        assertEquals(this.a0.score, null);
        this.a0.changeScore(new Double(100));
        assertEquals(this.a0.score, 100, .0);
        assertEquals(this.a1.score, new Double(90));
        this.a1.changeScore(new Double(9));
        assertEquals(this.a1.score, new Double(9));

        assertEquals(this.a3.score, new Double(45));
        this.a1.changeScore(new Double(20));
        assertEquals(this.a1.score, new Double(20));
    }

    /** test the makeList method
     * 
     * @author Charles Perrone
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testMakeList() {
        this.reset();
        assertEquals(this.c1.makeList("Assignment1"), 
                new ArrayList<Double>(Arrays.asList(45.0, 90.0, 96.0)));
        this.reset();
        assertEquals(this.c1.makeList("AssignmentNull"),
                new ArrayList<Double>());
        this.reset();
        assertEquals(this.c1.makeList("Assignment2"),
                new ArrayList<Double>(
                        Arrays.asList(
                                80.0, 114.0, 115.0)));
    }

    /** test the average method
     * 
     * @author Charles Perrone
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testAverage() {
        this.reset();
        assertEquals(c1.average("Assignment1"), 77.0, .001);
        assertEquals(c1.average("Assignment2"), 103.0, .001);
        assertEquals(c1.average("Assignment3"), 90.0, .001);
        try {
            Course.newGradeBook().average("TEST");
            System.out.println("Should throw an exception.");
            assertTrue(false);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
            System.out.println("Correctly throws exception.");
            System.out.println(e);
        }
        try {
            this.c1.average("NOT HERE");
            System.out.println("Should throw an exception.");
            assertTrue(false);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
            System.out.println("Correctly throws exception.");
            System.out.println(e);
        }
    }

    /** test the median method
     * 
     * @author Charles Perrone
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testMedian() {
        this.reset();
        
        HashMap<Student, ArrayList<Assignment>> newHash = 
                new HashMap<Student, ArrayList<Assignment>>();
        newHash.put(this.s1, this.aList1);
        newHash.put(this.s2, this.aList1);
        
        Course newCourse = Course.newGradeBook(newHash);
        
        //list with an even size
        assertEquals(c1.median("Assignment1"), 90.0, .001);
        assertEquals(c1.median("Assignment3"), 90.0, .001);
        assertEquals(newCourse.median("Assignment1"), 90, .00);
        assertEquals(c1.median("Assignment2"), 114.0, .001);
        
        try {
            Course.newGradeBook().median("TEST");
            System.out.println("Should throw an exception.");
            assertTrue(false);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
            System.out.println("Correctly throws exception.");
            System.out.println(e);
        }
        try {
            this.c1.median("NOT HERE");
            System.out.println("Should throw an exception.");
            assertTrue(false);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
            System.out.println("Correctly throws exception.");
            System.out.println(e);
        }
    }

    /** test the min method
     * 
     * @author Charles Perrone
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testMin() {
        this.reset();
        assertEquals(c1.min("Assignment1"), 45.0, .001);
        assertEquals(c1.min("Assignment2"), 80.0, .067);
        assertEquals(c1.min("Assignment3"), 90.0, .000);
        
        try {
            Course.newGradeBook().min("TEST");
            System.out.println("Should throw an exception.");
            assertTrue(false);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
            System.out.println("Correctly throws exception.");
            System.out.println(e);
        }
        try {
            this.c1.min("NOT HERE");
            System.out.println("Should throw an exception.");
            assertTrue(false);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
            System.out.println("Correctly throws exception.");
            System.out.println(e);
        }
    }

    /** test the max method
     * 
     * @author Charles Perrone
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testMax() {
        this.reset();
        assertEquals(c1.max("Assignment1"), 96.0, .001);
        assertEquals(c1.max("Assignment2"), 115.0, .034);
        assertEquals(c1.max("Assignment3"), 90.0, .000);
        
        try {
            Course.newGradeBook().max("TEST");
            System.out.println("Should throw an exception.");
            assertTrue(false);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
            System.out.println("Correctly throws exception.");
            System.out.println(e);
        }
        try {
            this.c1.max("NOT HERE");
            System.out.println("Should throw an exception.");
            assertTrue(false);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
            System.out.println("Correctly throws exception.");
            System.out.println(e);
        }
    }

    /** test the getStudent method in GradeBook
     * 
     * @author Nick Alekhine
     * @author Austin Colcord
     * @version 2014-04-09
     */
    @Test
    public void testGetStudent() {
        this.reset();
        assertEquals(this.s3, this.c1.getStudent("nalekhn"));
        assertEquals(null, this.c1.getStudent("blah"));
        assertEquals(this.s1, this.c1.getStudent("chperrone"));
        assertEquals(this.s2, this.c1.getStudent("thmyolk"));
    }

    /** test the currentGrade method in GradeBook
     * 
     * @author Nick Alekhine
     * @author Austin Colcord
     * @version 2014-04-09
     */
    @Test
    public void testCurrentGrade() {
        this.reset();
        assertEquals(94, this.c1.currentGrade("nalekhn"), .01);
        assertEquals(93.89, this.c1.currentGrade("chperrone"), .01);
        assertEquals(67.08, this.c1.currentGrade("thmyolk"), .01);
        assertEquals(0, this.c1.currentGrade("a;ldfjk"), .00);
    }

    /** test the currentGrades method in GradeBook
     * 
     * @author Nick Alekhine
     * @author Austin Colcord
     * @version 2014-04-09
     */
    @Test
    public void testCurrentGrades() {
        this.reset();
        HashMap<String, Double> result = new HashMap<String, Double>();
        result.put("chperrone", 93.89);
        result.put("thmyolk", 67.08);
        result.put("nalekhn", (double) 94);
        assertEquals(result, this.c1.currentGrades());
        assertEquals(this.c1.currentGrades(), this.c2.currentGrades());
    }

    /** test the assignmentGrade method in GradeBook
     *
     * @author Nick Alekhine
     * @author Austin Colcord
     * @version 2014-04-09
     */
    @Test
    public void testAssignmentGrade() {
        this.reset();
        assertEquals(90, 
                this.c1.assignmentGrade("Assignment1", "chperrone"), .01);
        assertEquals(115.0,
                this.c1.assignmentGrade("Assignment2", "chperrone"), .01);
        assertEquals(0, 
                this.c1.assignmentGrade("Assignment3", "chperrone"), .01);
        assertEquals(this.c1.assignmentGrade("asldfjk", "chperrone"), 0, .00);
        assertEquals(this.c1.assignmentGrade("Assignment1", "als;dkjf"), 0, .0);
    }

    /** test the processFile method
     * 
     * @author Charles Perrone
     * @version 2014-04-09
     */
    @Test
    public void testProcessFile() {
        this.reset();

        try {
            MyGradeBook blank = MyGradeBook.initialize();
            blank.processFile("addAssignments.txt");
            
        }
        catch (Exception e) {
            System.out.println("File not found");
        }

        try {
            this.c1.processFile("addStudents.txt");
            System.out.println(this.c1);
        }
        catch (Exception e) {
            System.out.println("File not Found");
        }
    }

    /** test the processString method
     * 
     * @author Charles Perrone
     * @version 2014-04-09
     */
    @Test
    public void testProcessString() {
        this.reset();
        String additionalAssignment = 
                "ASSIGNMENT\nFirst Group Project\n150"
                + "\n10\nASSIGNMENT\nTest\n100\n25";

        MyGradeBook test = MyGradeBook.initializeWithFile("initial.txt");
        
        test.processString(additionalAssignment);
        System.out.println(test);
        
        
    }


    /** To test the addStudents method
     * 
     * @author Austin Colcord
     * @author Charles Perrone
     * @version 2014-04-09
     */
    @Test
    public void testAddStudents() {
        this.reset();

        ArrayList<Student> stud = new ArrayList<Student>();
        stud.add(this.s2);
        stud.add(this.s1);

        Course testCourse = new Course();

        testCourse.addStudents(stud);

        Set<Student> tCourseSet = testCourse.studAssignMap.keySet();
        List<Student> tCourseList = new ArrayList<Student>(tCourseSet);

        Set<Student> c1CourseSet = this.c1.studAssignMap.keySet();
        List<Student> c1CourseList = new ArrayList<Student>(c1CourseSet);

        assertEquals(tCourseList, stud);
        assertFalse(c1CourseList.equals(stud));
        assertTrue(tCourseList.equals(stud));


        MyGradeBook mtbook = MyGradeBook.initialize();
        try {
            System.out.println("Should throw an exception.");
            MyGradeBook notmt = MyGradeBook.initializeWithFile("initial.txt");
            notmt.addStudents(stud);
        } 
        catch (Exception e) {
            assertTrue(true);
            System.out.println("Correctly throws exception.");
            System.out.println(e);
        }
        
       

        mtbook.addStudents(stud);


    }

    /** test the addgrades method in course
     * 
     * @author Austin Colcord
     * @version 2014-04-09
     */
    @Test
    public void testAddGrades() {
        this.reset();
        ArrayList<Assignment> testAssignment = new ArrayList<Assignment>();
        testAssignment.add(new Assignment("TestAssignment", 100, .50));
        assertEquals(this.c1.studAssignMap.get(this.s1).size(), 2);
        assertEquals(this.c1.studAssignMap.get(this.s2).size(), 3);
        assertEquals(this.c1.studAssignMap.get(this.s3).size(), 3);
        assertEquals(this.c1, this.c2);
        this.c1.addGrades(testAssignment);
        assertEquals(this.c1.studAssignMap.get(this.s1).size(), 3);
        assertEquals(this.c1.studAssignMap.get(this.s2).size(), 4);
        assertEquals(this.c1.studAssignMap.get(this.s3).size(), 4);
    }

    /** test the newGradeBook method in Course
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testNewGradeBook() {
        this.reset();
        assertEquals(Course.newGradeBook(), new Course());
        assertFalse(Course.newGradeBook().equals(this.c1));
        assertEquals(Course.newGradeBook(this.map1), this.c1);
        assertFalse(Course.newGradeBook(this.map1).equals(
                Course.newGradeBook()));
    }

    /** test the initialize method in MyGradeBook
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testInitialize() {
        this.reset();
        assertEquals(MyGradeBook.initialize(), new Course());
    }

    /** test the method initializeFile
     * 
     * @author Charles Perrone
     * @version 2014-04-09
     */
    @Test
    public void testInitializeFile() {
        this.reset();
        assertTrue(true);

        try {
            MyGradeBook.initializeWithFile("initial.txt");
        } 
        catch (Exception e) {
            System.out.println("File Not Found");
        }
    }

    /** test the initialize with string method in MyGradeBook
     * 
     * @author Charles Perrone
     * @version 2014-04-09
     */
    @Test
    public void testInitializeString() {
        this.reset();
        assertTrue(true);
        String test = 
                "GRADEBOOK\n\t\t\tOpening Assignment\tA2\n10\t100"
                + "\n1\t5\nabetaylor\tIsabella\tTaylor\tBaker\t2016\t8\t71";
        
        MyGradeBook.initializeWithString(test);
    }
    /** test the studentcomparator 
     * 
     * @author Austin Colcord
     * @version 2014-04-09
     */
    @Test
    public void testStudentComparator() {
        this.reset();
        StudentComparator sComp = new StudentComparator();
        assertEquals(sComp.compare(this.s1, this.s2), -17);
        assertEquals(sComp.compare(this.s1, this.s3), -11);
        assertEquals(sComp.compare(this.s2, this.s3), 6);
        assertEquals(sComp.compare(this.s3, this.s1), 11);
        assertEquals(sComp.compare(this.s3, this.s2), -6);
    }
    
}
