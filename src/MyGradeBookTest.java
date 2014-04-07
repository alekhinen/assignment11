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

    /** Student => Assignments 1 */
    HashMap<Student, ArrayList<Assignment>> map1;
    
    /** Gradebook 1 */
    GradeBook gb1;

    /** 
     * To set values to each variable. 
     * */
    public void reset() {
        s1 = new Student("chperrone", "Charles", "Haydon", "Perrone", 2017);
        s2 = new Student("thmyolk", "Thom", "Mearle", "Yorke", 2017);
        s3 = new Student("nalekhn", "Nick", "Alex", "Alekhine", 2017);

        a1 = new Assignment("Assignment1", 100, .25);
        a2 = new Assignment("Assignment2", 120, .45);
        
        aList1 = new ArrayList<Assignment>();
        aList1.add(a1);
        aList1.add(a2);
        
        map1 = new HashMap<Student, ArrayList<Assignment>>();
        map1.put(this.s1, this.aList1);
        
        gb1 = new GradeBook("GRADEBOOK1", this.map1);
        
        
    }
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // METHODS ////////////////////////////////////////////////////////////////
    
    @Test
    public void testChangeGrade() {
        reset();
        this.gb1.changeGrade("Assignment1", "chperrone", 90);
    }

}
