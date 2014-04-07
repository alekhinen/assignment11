import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

/**
 * A testing suite for our GradeBook implementation 
 * 
 * @author Charles Perrone
 * @version 4-6-2014
 *
 */
public class MyGradeBookTests {

    Student s1;
    Student s2;
    Student s3;

    Assignment a1;
    Assignment a2;
    
    ArrayList<Assignment> aList1;

    HashMap<Student, ArrayList<Assignment>> map1;
    
    GradeBook gb1;

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
    
    public void testChangeGrade() {
        reset();
        this.gb1.changeGrade("Assignment1", "chperrone", 90);
    }

}
