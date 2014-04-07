
import static org.junit.Assert.*;

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
    
    /** Gradebook 1 */
    GradeBook gb1;
    
    /** 
     * To set values to each variable. 
     * */
    public void reset() {
        /** Students */
        s1 = new Student("chperrone", "Charles", "Haydon", "Perrone", 2017);
        s2 = new Student("thmyolk", "Thom", "Mearle", "Yorke", 2017);
        s3 = new Student("nalekhn", "Nick", "Alex", "Alekhine", 2017);

        /** Assignments */
        a1 = new Assignment("Assignment1", 100, 90, .25);
        a2 = new Assignment("Assignment2", 120, 115, .50);
        a3 = new Assignment("Assignment1", 100, 45, .25);
        a4 = new Assignment("Assignment2", 120, 80, .50);
        a5 = new Assignment("Assignment3", 100, 90, .25);
        a6 = new Assignment("Assignment1", 100, 96, .25);
        a7 = new Assignment("Assignment2", 120, 114, .50);
        a8 = new Assignment("Assignment3", 100, 90, .25);
        
        
        /** Populate Assignment Lists */
        aList1 = new ArrayList<Assignment>();
        aList1.add(a1);
        aList1.add(a2);
        
        aList2 = new ArrayList<Assignment>();
        aList2.add(a3);
        aList2.add(a4);
        aList2.add(a5);
        
        aList3 = new ArrayList<Assignment>();
        aList3.add(a6);
        aList3.add(a7);
        aList3.add(a8);
        
        map1 = new HashMap<Student, ArrayList<Assignment>>();
        map1.put(this.s1, this.aList1);
        map1.put(this.s2, this.aList2);
        map1.put(this.s3, this.aList3);
        
        gb1 = new GradeBook("GRADEBOOK1", map1);
    }
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // METHODS ////////////////////////////////////////////////////////////////

    @Test
    public void testChangeGrade() {
        reset();
        assertEquals(this.a1.score, new Double(90));
        this.gb1.changeGrade("Assignment1", "chperrone", new Double(100));
        assertEquals(this.a1.score, new Double(100));
    }
    
    /** test the changeScore grade in Assignment */
    @Test
    public void testChangeScore() {
        this.reset();
        Double d1 = new Double(9);
        assertEquals(this.a1.score, new Double(90));
        this.a1.changeScore(d1);
        assertEquals(this.a1.score, d1);
    }
    
    @Test
    public void testAverage() {
        //assertEquals(gb1.average("Assignment1"), 77, .001);
        
    }
    
    /**
     * To test the getStudent method in GradeBook.
     */
    @Test
    public void testGetStudent() {
        this.reset();
        assertEquals(this.s3, this.gb1.getStudent("nalekhn"));
        assertEquals(null, this.gb1.getStudent("blah"));
        assertEquals(this.s1, this.gb1.getStudent("chperrone"));
    }
    
    /**
     * To test the currentGrade method in GradeBook
     */
    @Test
    public void testCurrentGrade() {
        this.reset();
        assertEquals(94, this.gb1.currentGrade("nalekhn"), .01);
        assertEquals(93.89, this.gb1.currentGrade("chperrone"), .01);
        assertEquals(67.08, this.gb1.currentGrade("thmyolk"), .01);
    }
    
    /**
     * To test the currentGrades method in GradeBook
     */
    @Test
    public void testCurrentGrades() {
        this.reset();
        HashMap<String, Double> result = new HashMap<String, Double>();
        result.put("chperrone", 93.89);
        result.put("thmyolk", 67.08);
        result.put("nalekhn", (double) 94);
        assertEquals(result, this.gb1.currentGrades());
    }

}
