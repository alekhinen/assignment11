package gradebook;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

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
                                66.66666666666666, 95.0, 95.83333333333334)));   
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
        assertEquals(c1.average("Assignment2"), 85.833, .001);
        assertEquals(c1.average("Assignment3"), 90.0, .001);
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
        //list with an even size
        assertEquals(c1.median("Assignment1"), 90.0, .001);
        assertEquals(c1.median("Assignment3"), 90.0, .001);
        assertEquals(c1.median("Assignment2"), 95.0, .001);
    }
    
    /** test the min method
     * 
     * @author Charles Perrone
     * @version 2014-04-08
     */
    @Test
    public void testMin() {
        this.reset();
        assertEquals(c1.min("Assignment1"), 45.0, .001);
    }

    /** test the max method
     * 
     * @author Charles Perrone
     * @version 2014-04-08
     */
    @Test
    public void testMax() {
        this.reset();
        assertEquals(c1.max("Assignment1"), 96.0, .001);
    }

    /** test the getStudent method in GradeBook
     * 
     * @author Nick Alekhine
     * @version 2014-04-07
     */
    @Test
    public void testGetStudent() {
        this.reset();
        assertEquals(this.s3, this.c1.getStudent("nalekhn"));
        assertEquals(null, this.c1.getStudent("blah"));
        assertEquals(this.s1, this.c1.getStudent("chperrone"));
    }
    
    /** test the currentGrade method in GradeBook
     * 
     * @author Nick Alekhine
     * @version 2014-04-07
     */
    @Test
    public void testCurrentGrade() {
        this.reset();
        assertEquals(94, this.c1.currentGrade("nalekhn"), .01);
        assertEquals(93.89, this.c1.currentGrade("chperrone"), .01);
        assertEquals(67.08, this.c1.currentGrade("thmyolk"), .01);
    }
    
    /** test the currentGrades method in GradeBook
     * 
     * @author Nick Alekhine
     * @version 2014-04-07
     */
    @Test
    public void testCurrentGrades() {
        this.reset();
        HashMap<String, Double> result = new HashMap<String, Double>();
        result.put("chperrone", 93.89);
        result.put("thmyolk", 67.08);
        result.put("nalekhn", (double) 94);
        assertEquals(result, this.c1.currentGrades());
    }
    
    /** test the assignmentGrade method in GradeBook
     *
     * @author Nick Alekhine
     * @version 2014-04-07
     */
    @Test
    public void testAssignmentGrade() {
        this.reset();
        assertEquals((double) 90, 
                     this.c1.assignmentGrade("Assignment1", "chperrone"), .01);
        assertEquals(95.83,
                    this.c1.assignmentGrade("Assignment2", "chperrone"),.01);
        assertEquals(0, 
                     this.c1.assignmentGrade("Assignment3", "chperrone"), .01);
    }
    
    /**
     * To test the processFile method
     */
    @Test
    public void testProcessFile() {
        this.reset();
        
        try {
        MyGradeBook.initialize().processFile("addAssignments.txt");
        }
        catch(Exception e) {
            System.out.println("File not found");
        }
        
        
        try {
            this.c1.processFile("addStudents.txt");
            }
            catch(Exception e) {
                System.out.println("File not Found");
            }
        
    }
    
    /**
     * To test the addGrades method
     */
    @Test
    public void testAddGrades() {
        MyGradeBook book = MyGradeBook.initialize();
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
    
    @Test
    public void testInitializeFile() {
        this.reset();
        try {
            MyGradeBook.initializeWithFile("initial.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
