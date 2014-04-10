import static org.junit.Assert.*;
import gradebook.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

/** represents the black box tests for MyGradeBook
 * 
 * @author Austin Colcord
 * @author Chris Clark
 * @version 2014-04-09
 */
public class BlackBoxTests {

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

    /** Course 1 studAssignMap **/

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

        this.c1 = this.c1.newGradeBook(map1);
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
        this.c1 = this.c1.newGradeBook();
        assertEquals(Course.initialize(), c1);
    }

    /** test the initializeWithFile method in Course **/
    @Test
    public void testInitializeWithFile() {
        //TODO
    }

    /** test the initializeWithString method in Course **/
    @Test
    public void testInitializeWithString() {
        //TODO
    }

    /** test the processFile method in Course **/
    @Test
    public void testProcessFile() {
        //TODO
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
        assertTrue(c1.changeGrade("Assignment1", "chperrone", 95));
        assertFalse(c1.changeGrade("Assignment4", "chperrone", 10));
        assertFalse(c1.changeGrade("Assignment1", "joeblo", 100));
    }

    /** test the average method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testAverage() {
        reset();
        assertEquals(c1.average("Assignment1"), 77.0, 0);
        assertEquals(c1.average("Assignment2"), 85.83, 0.01);
        assertEquals(c1.average("Assignment3"), 90.0, 0);
    }

    /** test the median method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMedian() {
        reset();
        assertEquals(c1.median("Assignment1"), 90, .0);
        assertEquals(c1.median("Assignment2"), 95, .0);
        assertEquals(c1.median("Assignment3"), 90, .0);

        c1.changeGrade("Assignment1", "chperrone", 25);

        assertEquals(c1.median("Assignment1"), 90, .0);
        assertEquals(c1.median("Assignment1"), 45, .0);
    }

    /** test the min method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMin() {
        reset();
        assertEquals(c1.min("Assignment1"), 45, 0);

        c1.changeGrade("Assignment1", "thmyolk", 55);
        assertEquals(c1.min("Assignment1"), 55, .0001);
    }

    /** test the max method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testMax() {
        reset();
        assertEquals(c1.max("Assignment1"), 96, 0);

        c1.changeGrade("Assignment1", "chperrone", 100);
        assertEquals(c1.max("Assignment1"), 100, .0001);
    }

    /** test the currentGrade method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testCurrentGrade() {
        reset();
        assertEquals(c1.currentGrade("chperrone"), 93.8, 0.1);
        assertEquals(c1.currentGrade("thmyolk"), 67, 0.1);

        c1.changeGrade("Assignment1", "thmyolk", 100);

        assertEquals(c1.currentGrade("thmyolk"), 80.8, 0.1);
    }

    /** test the currentGrades method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testCurrentGrades() {
        reset();
        HashMap<String, Double> c1CurrentGrades = new HashMap<String, Double>();

        c1CurrentGrades.put("chperrone", 93.89);
        c1CurrentGrades.put("thmyolk", 67.08);
        c1CurrentGrades.put("nalekhn", 94.0);

        assertEquals(c1.currentGrades(), c1CurrentGrades);
    }

    /** test the assignmentGrade method in Course
     *
     * @author Chris Clark
     * @version 2014-04-08
     */
    @Test
    public void testAssignmentGrade() {
        //TODO
    }

    /** test the outputCurrentGrades method in Course **/
    @Test
    public void testOutputCurrentGrades() {
        //TODO
    }

    /** test the outputAssignmentGrades method in Course **/
    @Test
    public void testOutputAssignmentGrades() {
        //TODO
    }

    /** test the outputGradebook method in Course **/
    @Test
    public void testOutputGradebook() {
        //TODO
    }
}