package working;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Comparator;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Student implements Serializable {

    @XmlElement(name = "rollno")
    private int rollno;


    @XmlElement(name = "maths")
    private int maths;

    @XmlElement(name = "physics")
    private int physics;

    @XmlElement(name = "chemistry")
    private int chemistry;

    private int total;
    private int rank=-1;

    Student(){this.total=0;}
    Student(int rn, int m, int s, int e){this.rollno=rn;this.maths=m;this.physics=s;this.chemistry=e;}

    public static Comparator<Student> StuMarkComparator = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            int studentMark1 = s1.getTotal();
            int studentMark2 = s2.getTotal();
            return studentMark2-studentMark1;
        }};

    public void calculateTotal(){
        this.total = this.chemistry+this.maths+this.physics;
    }

    public int getRollno() {
        return rollno;
    }


    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}