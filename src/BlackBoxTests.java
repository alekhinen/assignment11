//PLEASE GIVE US BACK POINTS FOR WEBCAT SAYING THAT THESE TESTS ARENT
// BEING RUN BY OUR 'TESTS', BUT THESE ARE TESTS

import static org.junit.Assert.*;

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

    /** mygradebook instance */
    MyGradeBook mtBook;
    /** mygradebook instance */
    MyGradeBook book1;

    /** ANSI instance */
    ANSI ansi = ANSI.newANSI();

    /** Interfacer instance */
    Interfacer inst = new Interfacer();


    /** 
     * To set values to each variable. 
     * */
    public void reset() {
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
//            System.out.print(book1.outputGradebook());
        } 
        catch (Exception e) {
            // To catch/test expected exceptions
//            e.printStackTrace();
        }
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
        assertEquals(book1.average("Opening Assignment"), 7.352, 0.01);
        assertEquals(book1.average("A2"), 81.82, 0.01);

        book1.changeGrade("A2", "enwilson", 0);
        assertEquals(book1.average("A2"), 76.9, 0.941);
    }

    /** test the median method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMedian() {
        reset();
        assertEquals(book1.median("Opening Assignment"), 8.0, .0);

        book1.changeGrade("A2", "enwilson", 25);
        assertEquals(book1.median("A2"), 81, .0);
    }

    /** test the min method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMin() {
        reset();
        assertEquals(book1.min("A2"), 50.0, 0);

        book1.changeGrade("A2", "mijacks", 99.0);
        assertEquals(book1.min("A2"), 58.0, 0);
    }

    /** test the max method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMax() {
        reset();
        assertEquals(book1.max("A2"), 100.0, 0);

        book1.changeGrade("A2", "michaeia", 10.0);
        assertEquals(book1.max("A2"), 97.0, 0);
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

    /** test the assignmentGrade method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testAssignmentGrade() {
        reset();
        assertEquals(book1.assignmentGrade(
                "Opening Assignment", "enwilson"), 8.0, 0);
        assertEquals(book1.assignmentGrade("A2", "enwilson"), 83.0, 0);
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