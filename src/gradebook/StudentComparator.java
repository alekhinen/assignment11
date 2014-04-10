package gradebook;

import java.util.Comparator;

/** represents the comparator for two students that sorts alphabetically
 * based on their usernames
 * 
 * @author Austin Colcord
 * @version 2014-04-09
 */
public class StudentComparator implements Comparator<Student> {

    /** implementing the compare method for this comparator
     * 
     * @author Austin Colcord
     * @version 2014-04-09
     */
    public int compare(Student o1, Student o2) {
        return o1.userName.compareTo(o2.userName);
    }
}
