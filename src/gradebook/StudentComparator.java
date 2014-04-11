package gradebook;

import java.util.Comparator;

/** represents the comparator for two students that sorts alphabetically
 * based on their usernames
 * 
 * @author Austin Colcord
 * @version 2014-04-09
 */
class StudentComparator implements Comparator<Student> {

    /** implementing the compare method for this comparator
     * 
     * @author Austin Colcord
     * @version 2014-04-09
     * 
     * @param o1 the first student to compare
     * @param o2 the second student to compare
     * @return int negative if o1 is before o2, else positive
     */
    public int compare(Student o1, Student o2) {
        return o1.userName.compareTo(o2.userName);
    }
}
