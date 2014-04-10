import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;

import gradebook.*;

/**
 * The blackbox testing class for all methods 
 * associated with the MyGradeBook class.
 * @author Chris Clark
 * @version 2014-04-09
 */
public class BlackBoxTests {

    ///////////////////////////////////////////////////////////////////////////
    // FIELDS /////////////////////////////////////////////////////////////////

    /**
     * MyGradeBook Instances
     */
    MyGradeBook mtBook;
    MyGradeBook book1;
    MyGradeBook testBook;

    /** 
     * To set values to each variable. 
     * */
    public void reset() {
        mtBook = MyGradeBook.initialize();
        try {
            book1 = MyGradeBook.initializeWithFile("initial.txt");
            testBook = MyGradeBook.initializeWithFile("testFile.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
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

    /** test the initializeWithFile method in Course
     *
     * @author Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testInitializeWithFile() {
        assertTrue(testBook == null);
        try {
            testBook = MyGradeBook.initializeWithFile("testFile.txt");
            String outputCurrent = "CURRENT_GRADES\n"
                    + "chperrone\t" + "75.5\n"
                    + "nalekhn\t" + "79.5\n"
                    + "thmyolk\t" + "75.0\n";
            assertEquals(testBook.outputCurrentGrades(), outputCurrent);

            // To test FileNotFoundException
            book1 = MyGradeBook.initializeWithFile("FakeFilename.txt");
        }
        catch (FileNotFoundException e) {
            // To catch/test expected exceptions
            assertTrue(false);
        }
    }

    /** test the initializeWithString method in Course
     * 
     * @author Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testInitializeWithString() {
        assertTrue(testBook == null);
        String startingString = "GRADEBOOK\n"
                + "\t\t\t\t\t"
                + "A1\t" + "A2\n"
                + "\t\t\t\t\t"
                + "100.0\t" + "100.0\n"
                + "\t\t\t\t\t"
                + "5.0\t" + "5.0\n"
                + "chperrone\t" + "Charles\t" + "Haydon\t" + "Perrone\t"
                + "2017\t" + "80.0\t" + "71.0\n"
                + "nalekhn\t" + "Nick\t" + "Alex\t" + "Alekhine\t"
                + "2017\t" + "80.0\t" + "79.0\n"
                + "thmyolk\t" + "Thom\t" + "Mearle\t" + "Yorke\t"
                + "2017\t" + "60.0\t" + "90.0\n";
        try {
            testBook = MyGradeBook.initializeWithString(startingString);
            String outputCurrent = "CURRENT_GRADES\n"
                    + "chperrone\t" + "75.5\n"
                    + "nalekhn\t" + "79.5\n"
                    + "thmyolk\t" + "75.0\n";
            assertEquals(testBook.outputCurrentGrades(), outputCurrent);

            // To test Exception
            book1 = MyGradeBook.initializeWithString(
                    "Incorrectly Formatted String");
        }
        catch (Exception e) {
            // To catch/test expected exceptions
            assertTrue(false);
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
//        try {
//            testBook.processFile("addStudents.txt");
//            System.out.print(testBook.outputGradebook());
//        } catch (FileNotFoundException e) {
//         // To catch/test expected exceptions
//            e.printStackTrace();
//        }
    }

    /** test the processString method in Course **/
    @Test
    public void testProcessString() {
        //TODO
    }

    /** test the changeGrade method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testChangeGrade() {
        reset();
        assertTrue(book1.changeGrade("A2", "enwilson", 95));
        assertFalse(book1.changeGrade("A3", "enwilson", 10));
        assertFalse(book1.changeGrade("A2", "clarkch", 100));
    }

    /** test the average method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testAverage() {
        reset();
        assertEquals(book1.average("Opening Assignment"), 73.52, 0.01);
        assertEquals(book1.average("A2"), 81.82, 0.01);

        book1.changeGrade("A2", "enwilson", 0);
        assertFalse(book1.average("A2") == 80);
    }

    /** test the median method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMedian() {
        reset();
        assertEquals(book1.median("Opening Assignment"), 80, .0);
        assertEquals(book1.median("A2"), 83, .0);

        book1.changeGrade("A2", "enwilson", 25);
        assertFalse(book1.median("A2") == 80);
    }

    /** test the min method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMin() {
        reset();
        assertEquals(testBook.min("A1"), 60, 0);

        testBook.changeGrade("A1", "thmyolk", 99);
        assertEquals(testBook.min("A1"), 80, 0);
    }

    /** test the max method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMax() {
        reset();
        assertEquals(testBook.max("A1"), 80, 0);

        testBook.changeGrade("A1", "chperrone", 100);
        assertEquals(testBook.max("A1"), 100, 0);
    }

    /** test the currentGrade method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testCurrentGrade() {
        reset();
        assertEquals(book1.currentGrade("enwilson"), 82.5, 0.001);
        assertEquals(book1.currentGrade("onon"), 84.17, 0.001);

        book1.changeGrade("A2", "enwilson", 100);

        assertEquals(book1.currentGrade("enwilson"), 96.6, 0.1);
    }

    /** test the currentGrades method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testCurrentGrades() {
        reset();
        HashMap<String, Double> testBookCurrentGrades = 
                new HashMap<String, Double>();

        testBookCurrentGrades.put("chperrone", 75.5);
        testBookCurrentGrades.put("thmyolk", 75.0);
        testBookCurrentGrades.put("nalekhn", 79.5);

        assertEquals(mtBook.currentGrades().toString(), "{}");
        assertEquals(testBook.currentGrades(), testBookCurrentGrades);
    }

    /** test the assignmentGrade method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testAssignmentGrade() {
        reset();
        assertEquals(testBook.assignmentGrade("A1", "chperrone"), 80, 0);
        assertEquals(testBook.assignmentGrade("A2", "chperrone"), 71, 0);
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
                + "chperrone\t" + "75.5\n"
                + "nalekhn\t" + "79.5\n"
                + "thmyolk\t" + "75.0\n";
        assertEquals(testBook.outputCurrentGrades(), outputCurrent);
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
                + "A1\n"
                + "100.0\n"
                + "5.0\n"
                + "----\n"
                + "chperrone\t" + "80.0\n"
                + "nalekhn\t" + "80.0\n"
                + "thmyolk\t" + "60.0\n"
                + "----\n"
                + "STATS\n"
                + "Average\t" + "73.33333333333333\n"
                + "Median\t" + "80.0\n"
                + "Max\t" + "80.0\n"
                + "Min\t" + "60.0";

        assertEquals(testBook.outputAssignmentGrades("A1"), a1OutputCurrent);
    }

    /** test the outputGradebook method in Course
     *
     * @author Chris Clark
     * @version 2014-04-09
     */
    @Test
    public void testOutputGradebook() {
        reset();
        String outputTestBook = "GRADEBOOK\n"
                + "\t\t\t\t\t"
                + "A1\t" + "A2\n"
                + "\t\t\t\t\t"
                + "100.0\t" + "100.0\n"
                + "\t\t\t\t\t"
                + "5.0\t" + "5.0\n"
                + "chperrone\t" + "Charles\t" + "Haydon\t" + "Perrone\t"
                + "2017\t" + "80.0\t" + "71.0\n"
                + "nalekhn\t" + "Nick\t" + "Alex\t" + "Alekhine\t"
                + "2017\t" + "80.0\t" + "79.0\n"
                + "thmyolk\t" + "Thom\t" + "Mearle\t" + "Yorke\t"
                + "2017\t" + "60.0\t" + "90.0\n";

        assertEquals(testBook.outputGradebook(), outputTestBook);
    }
}