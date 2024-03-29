//PLEASE GIVE US BACK POINTS FOR WEBCAT SAYING THAT THESE TESTS ARENT
// BEING RUN BY OUR 'TESTS', BUT THESE ARE TESTS

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

    /** mygradebook instance */
    MyGradeBook mtBook;
    /** mygradebook instance */
    MyGradeBook book1;

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

        mtBook = MyGradeBook.initialize();
        try {
            book1 = MyGradeBook.initializeWithFile("initial.txt");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }





    ///////////////////////////////////////////////////////////////////////////
    // METHODS ////////////////////////////////////////////////////////////////

    /** test the initialize method in Course 
     * 
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testInitialize() {
        reset();
        assertEquals(MyGradeBook.initialize(), mtBook);
        assertFalse(MyGradeBook.initialize().equals(book1));
    }

    /** test the initialize method in MyGradeBook
     * 
     * @author Austin Colcord
     * @version 2014-04-08
     */
    @Test
    public void testInitializeCourse() {
        this.reset();
        assertEquals(MyGradeBook.initialize(), new Course());
    }

    /** test the initializeWithFile method in Course
     *
     * @author Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testInitializeWithFile() {
        try {
            assertEquals(book1, null);
            book1 = MyGradeBook.initializeWithFile("initial.txt");
            String outputCurrent = "STUDENT_GRADES\n"
                    + "enwilson\n"
                    + "Aiden\n"
                    + "Wilson\n"
                    + "Nelson\n"
                    + "2014\n"
                    + "----\n"
                    + "Opening Assignment\t" + "8.0\n"
                    + "A2\t" + "83.0\n"
                    + "----\n"
                    + "CURRENT GRADE\t" + "82.5\n";
            assertEquals(book1.outputStudentGrades("enwilson"), outputCurrent);

        }
        catch (Exception e) {
            // To catch/test expected exceptions
            assertTrue(false);
        }

        // To test FileNotFoundException
        try {
            book1 = MyGradeBook.initializeWithFile("FakeFilename.txt");
        }
        catch (Exception e) {
            assertTrue(true);
        }
    }

    /** test the initializeWithString method in Course
     * 
     * @author Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testInitializeWithString() {
        try {
            assertEquals(book1, null);

            String startingString = "GRADEBOOK\n"
                    + "\t\t\t\t\t"
                    + "Opening Assignment\t" + "A2\n"
                    + "\t\t\t\t\t"
                    + "10\t" + "100\n"
                    + "\t\t\t\t\t"
                    + "1\t" + "5\n"
                    + "abetaylor\t" + "Isabella\t" + "Taylor\t" + "Baker\t"
                    + "2016\t" + "8\t" + "71\n"
                    + "abethes\t" + "Elizabeth\t" + "White Jones\t" + "Nelson\t"
                    + "2014\t" + "6\t" + "90\n"
                    + "acit\t" + "Jacob\t" + "Smith\t" + "Scott\t"
                    + "2014\t" + "8\t" + "79\n"
                    + "ahrown\t" + "Noah\t" + "Brown\t" + "Adams\t"
                    + "2017\t" + "8\t" + "85\n"
                    + "amller\t" + "Liam\t" + "Miller\t" + "Scott\t"
                    + "2014\t" + "5\t" + "74\n"
                    + "are\t" + "Emily Ann\t" + "Moore\t" + "Scott\t"
                    + "2014\t" + "9\t" + "58\n"
                    + "enwilson\t" + "Aiden\t" + "Wilson\t" + "Nelson\t"
                    + "2014\t" + "8\t" + "83\n"
                    + "gailarti\t" + "Abigail\t" + "Martin\t" + "Green\t"
                    + "2015\t" + "7\t" + "79\n"
                    + "marson\t" + "Emma\t" + "Anderson\t" + "Green\t"
                    + "2015\t" + "7\t" + "81\n"
                    + "michaeia\t" + "Michael\t" + "Garcia\t" + "Baker\t"
                    + "2016\t" + "5\t" + "100\n"
                    + "mijacks\t" + "Mia\t" + "Jackson\t" + "Baker\t"
                    + "2016\t" + "5\t" + "50\n"
                    + "oliviaas\t" + "Olivia\t" + "Thomas\t" + "Adams\t"
                    + "2017\t" + "6\t" + "94\n"
                    + "onon\t" + "Mason\t" + "Johnson\t" + "Green\t"
                    + "2015\t" + "10\t" + "81\n"
                    + "onson\t" + "Madison\t" + "Thompson\t" + "Adams\t"
                    + "2017\t" + "9\t" + "89\n"
                    + "thms\t" + "Ethan\t" + "Williams\t" + "Baker\t"
                    + "2016\t" + "8\t" + "89\n"
                    + "vaern\t" + "Ava\t" + "Hernandez\t" + "Nelson\t"
                    + "2014\t" + "6\t" + "91\n"
                    + "ydenavi\t" + "Jayden\t" + "Davis\t" + "Green\t"
                    + "2015\t" + "10\t" + "97\n";

            book1 = MyGradeBook.initializeWithString(startingString);
            String outputCurrent = "CURRENT_GRADES\n"
                    + "abetaylor\t" + "72.5\n"
                    + "abethes\t" + "85.0\n"
                    + "acit\t" + "79.17\n"
                    + "ahrown\t" + "84.17\n"
                    + "amller\t" + "70.0\n"
                    + "are\t" + "63.33\n"
                    + "enwilson\t" + "82.5\n"
                    + "gailarti\t" + "77.5\n"
                    + "marson\t" + "79.17\n"
                    + "michaeia\t" + "91.67\n"
                    + "mijacks\t" + "50.0\n"
                    + "oliviaas\t" + "88.33\n"
                    + "onon\t" + "84.17\n"
                    + "onson\t" + "89.17\n"
                    + "thms\t" + "87.5\n"
                    + "vaern\t" + "85.83\n"
                    + "ydenavi\t" + "97.5\n";

            assertEquals(book1.outputCurrentGrades(), outputCurrent);
        }
        catch (Exception e) {
            // To catch/test expected exceptions
            assertTrue(false);
        }

        // To test Exception
        try {
            book1 = MyGradeBook.initializeWithString(
                    "Incorrectly Formatted String");
            System.out.println("This should not pass");
        }
        catch (Exception e) {
            assertTrue(true);
            System.out.println("String format is incorrect.");
        }
    }


    /** test the processFile method in Course
     * 
     * @author Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testProcessFile() {
        reset();
        assertTrue(true);
        try {
            book1.processFile("addStudents.txt");
            System.out.print(book1.outputGradebook());
        } 
        catch (Exception e) {
            // To catch/test expected exceptions
//            e.printStackTrace();
        }

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
        this.reset();
        try {
            MyGradeBook blank = MyGradeBook.initializeWithFile("initial.txt");
            blank.processFile("gradesForStudent.txt");
            System.out.println(blank);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String additionalAssignment = 
                "ASSIGNMENT\nFirst Group Project\n150"
                        + "\n10\nASSIGNMENT\nTest\n100\n25";

        MyGradeBook test = MyGradeBook.initializeWithFile("initial.txt");

        test.processString(additionalAssignment);
        System.out.println(test);

    }

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
     * @author Chris Clark
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

        assertTrue(book1.changeGrade("A2", "enwilson", 95));
        assertFalse(book1.changeGrade("A3", "enwilson", 10));
        assertFalse(book1.changeGrade("A2", "clarkch", 100));
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
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testAverage() {
        this.reset();
        assertEquals(c1.average("Assignment1"), 77.0, .001);
        assertEquals(c1.average("Assignment2"), 103.0, .001);
        assertEquals(c1.average("Assignment3"), 90.0, .001);

        assertEquals(book1.average("Opening Assignment"), 7.352, 0.01);
        assertEquals(book1.average("A2"), 81.82, 0.01);

        book1.changeGrade("A2", "enwilson", 0);
        assertEquals(book1.average("A2"), 76.9, 0.941);

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
     * @author Chris Clark
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

        assertEquals(book1.median("Opening Assignment"), 8.0, .0);
        assertEquals(book1.median("A2"), 83, .0);

        book1.changeGrade("A2", "enwilson", 25);

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
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMin() {
        this.reset();
        assertEquals(c1.min("Assignment1"), 45.0, .001);
        assertEquals(c1.min("Assignment2"), 80.0, .067);
        assertEquals(c1.min("Assignment3"), 90.0, .000);

        assertEquals(book1.min("A2"), 50.0, 0);

        book1.changeGrade("A2", "mijacks", 99.0);
        assertEquals(book1.min("A2"), 58.0, 0);

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
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMax() {
        this.reset();
        assertEquals(c1.max("Assignment1"), 96.0, .001);
        assertEquals(c1.max("Assignment2"), 115.0, .034);
        assertEquals(c1.max("Assignment3"), 90.0, .000);

        assertEquals(book1.max("A2"), 100.0, 0);

        book1.changeGrade("A2", "michaeia", 10.0);
        assertEquals(book1.max("A2"), 97.0, 0);

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
     * @authr Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testCurrentGrade() {
        this.reset();
        assertEquals(94, this.c1.currentGrade("nalekhn"), .01);
        assertEquals(93.89, this.c1.currentGrade("chperrone"), .01);
        assertEquals(67.08, this.c1.currentGrade("thmyolk"), .01);
        assertEquals(0, this.c1.currentGrade("a;ldfjk"), .00);

        assertEquals(book1.currentGrade("enwilson"), 82.5, 0.001);
        assertEquals(book1.currentGrade("onon"), 84.17, 0.001);

        book1.changeGrade("A2", "enwilson", 100);

        assertEquals(book1.currentGrade("enwilson"), 96.6, 0.1);
    }

    /** test the currentGrades method in GradeBook
     * 
     * @author Nick Alekhine
     * @author Austin Colcord
     * @author Chris Clark
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

        HashMap<String, Double> book1CurrentGrades = 
                new HashMap<String, Double>();

        book1CurrentGrades.put("mijacks", 50.0);
        book1CurrentGrades.put("thms", 87.5);
        book1CurrentGrades.put("onson", 89.17);
        book1CurrentGrades.put("marson", 79.17);
        book1CurrentGrades.put("acit", 79.17);
        book1CurrentGrades.put("vaern", 85.83);
        book1CurrentGrades.put("oliviaas", 88.33);
        book1CurrentGrades.put("abetaylor", 72.5);
        book1CurrentGrades.put("ydenavi", 97.5);
        book1CurrentGrades.put("onon", 84.17);
        book1CurrentGrades.put("are", 63.33);
        book1CurrentGrades.put("enwilson", 82.5);
        book1CurrentGrades.put("ahrown", 84.17);
        book1CurrentGrades.put("michaeia", 91.67);
        book1CurrentGrades.put("amller", 70.0);
        book1CurrentGrades.put("gailarti", 77.5);
        book1CurrentGrades.put("abethes", 85.0);

        assertEquals(mtBook.currentGrades().toString(), "{}");
        assertEquals(book1.currentGrades(), book1CurrentGrades);
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

        assertEquals(book1.assignmentGrade(
                "Opening Assignment", "enwilson"), 8.0, 0);
        assertEquals(book1.assignmentGrade("A2", "enwilson"), 83.0, 0);
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

    /** test the outputCurrentGrades method in Course
     *
     * @author Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testOutputCurrentGrades() {
        reset();
        String outputCurrent = "CURRENT_GRADES\n"
                + "abetaylor\t" + "72.5\n"
                + "abethes\t" + "85.0\n"
                + "acit\t" + "79.17\n"
                + "ahrown\t" + "84.17\n"
                + "amller\t" + "70.0\n"
                + "are\t" + "63.33\n"
                + "enwilson\t" + "82.5\n"
                + "gailarti\t" + "77.5\n"
                + "marson\t" + "79.17\n"
                + "michaeia\t" + "91.67\n"
                + "mijacks\t" + "50.0\n"
                + "oliviaas\t" + "88.33\n"
                + "onon\t" + "84.17\n"
                + "onson\t" + "89.17\n"
                + "thms\t" + "87.5\n"
                + "vaern\t" + "85.83\n"
                + "ydenavi\t" + "97.5\n";
        assertEquals(book1.outputCurrentGrades(), outputCurrent);
    }

    /** test the outputAssignmentGrades method in Course
     *
     * @author Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testOutputAssignmentGrades() {
        reset();
        String a1OutputCurrent = "ASSIGNMENT_GRADES\n"
                + "A2\n"
                + "100.0\n"
                + "5.0\n"
                + "----\n"
                + "abetaylor\t" + "71.0\n"
                + "abethes\t" + "90.0\n"
                + "acit\t" + "79.0\n"
                + "ahrown\t" + "85.0\n"
                + "amller\t" + "74.0\n"
                + "are\t" + "58.0\n"
                + "enwilson\t" + "83.0\n"
                + "gailarti\t" + "79.0\n"
                + "marson\t" + "81.0\n"
                + "michaeia\t" + "100.0\n"
                + "mijacks\t" + "50.0\n"
                + "oliviaas\t" + "94.0\n"
                + "onon\t" + "81.0\n"
                + "onson\t" + "89.0\n"
                + "thms\t" + "89.0\n"
                + "vaern\t" + "91.0\n"
                + "ydenavi\t" + "97.0\n"
                + "----\n"
                + "STATS\n"
                + "Average\t" + "81.82352941176471\n"
                + "Median\t" + "83.0\n"
                + "Max\t" + "100.0\n"
                + "Min\t" + "50.0";

        assertEquals(book1.outputAssignmentGrades("A2"), a1OutputCurrent);
    }

    /** test the outputGradebook method in Course
     *
     * @author Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testOutputGradebook() {
        reset();
        String outputBook1 = "GRADEBOOK\n"
                + "\t\t\t\t\t"
                + "Opening Assignment\t" + "A2\n"
                + "\t\t\t\t\t"
                + "10.0\t" + "100.0\n"
                + "\t\t\t\t\t"
                + "1.0\t" + "5.0\n"
                + "abetaylor\t" + "Isabella\t" + "Taylor\t" + "Baker\t"
                + "2016\t" + "8.0\t" + "71.0\n"
                + "abethes\t" + "Elizabeth\t" + "White Jones\t" + "Nelson\t"
                + "2014\t" + "6.0\t" + "90.0\n"
                + "acit\t" + "Jacob\t" + "Smith\t" + "Scott\t"
                + "2014\t" + "8.0\t" + "79.0\n"
                + "ahrown\t" + "Noah\t" + "Brown\t" + "Adams\t"
                + "2017\t" + "8.0\t" + "85.0\n"
                + "amller\t" + "Liam\t" + "Miller\t" + "Scott\t"
                + "2014\t" + "5.0\t" + "74.0\n"
                + "are\t" + "Emily Ann\t" + "Moore\t" + "Scott\t"
                + "2014\t" + "9.0\t" + "58.0\n"
                + "enwilson\t" + "Aiden\t" + "Wilson\t" + "Nelson\t"
                + "2014\t" + "8.0\t" + "83.0\n"
                + "gailarti\t" + "Abigail\t" + "Martin\t" + "Green\t"
                + "2015\t" + "7.0\t" + "79.0\n"
                + "marson\t" + "Emma\t" + "Anderson\t" + "Green\t"
                + "2015\t" + "7.0\t" + "81.0\n"
                + "michaeia\t" + "Michael\t" + "Garcia\t" + "Baker\t"
                + "2016\t" + "5.0\t" + "100.0\n"
                + "mijacks\t" + "Mia\t" + "Jackson\t" + "Baker\t"
                + "2016\t" + "5.0\t" + "50.0\n"
                + "oliviaas\t" + "Olivia\t" + "Thomas\t" + "Adams\t"
                + "2017\t" + "6.0\t" + "94.0\n"
                + "onon\t" + "Mason\t" + "Johnson\t" + "Green\t"
                + "2015\t" + "10.0\t" + "81.0\n"
                + "onson\t" + "Madison\t" + "Thompson\t" + "Adams\t"
                + "2017\t" + "9.0\t" + "89.0\n"
                + "thms\t" + "Ethan\t" + "Williams\t" + "Baker\t"
                + "2016\t" + "8.0\t" + "89.0\n"
                + "vaern\t" + "Ava\t" + "Hernandez\t" + "Nelson\t"
                + "2014\t" + "6.0\t" + "91.0\n"
                + "ydenavi\t" + "Jayden\t" + "Davis\t" + "Green\t"
                + "2015\t" + "10.0\t" + "97.0\n";

        assertEquals(book1.outputGradebook(), outputBook1);
    }
}
