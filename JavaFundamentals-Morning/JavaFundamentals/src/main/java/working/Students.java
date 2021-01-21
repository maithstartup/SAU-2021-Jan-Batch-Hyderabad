package working;

import org.apache.commons.csv.CSVPrinter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Students implements Serializable {

    @XmlElement(name = "student")
    private List<Student> student;

    Students(){}
    Students(List<Student> stu){this.student=stu;}

    public List<Student> getStudent(){
        return this.student;
    }

    public void calculateRankAndTotal(){
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i=0; i < this.student.size(); i++) {
            this.student.get(i).calculateTotal();
        }
        Collections.sort(this.student,Student.StuMarkComparator);
        this.assignRanks();
    }

    public void assignRanks(){
        this.student.get(0).setRank(1);
        int lastTot=this.student.get(0).getTotal();
        int lastRank=this.student.get(0).getRank();
        for(int i=0; i < this.student.size(); ++i){
            if(this.student.get(i).getTotal()<lastTot){
                ++lastRank;
                this.student.get(i).setRank(lastRank);
                lastTot = this.student.get(i).getTotal();
            }else{
                this.student.get(i).setRank(lastRank);
            }
        }
    }

    public void writeTop5(CSVPrinter csvPrinter) throws IOException {
        for(int i=0; i < this.student.size() && this.student.get(i).getRank() < 6; ++i){
            Student s = this.student.get(i);
            csvPrinter.printRecord(s.getRank(),s.getRollno(),s.getTotal());
        }
        System.out.println("CSV writing done");
        csvPrinter.flush();
    }

    public void printTop5(){
        System.out.println("Rank\tRollNo\tTotalMarks(out of 300)");
        for(int i=0; i < this.student.size() && this.student.get(i).getRank() < 6; ++i){
            Student s = this.student.get(i);
            System.out.println(s.getRank()+"\t\t"+s.getRollno()+"\t\t"+s.getTotal());
        }
    }

    public void printDetails(){
        System.out.println("Rank\tRollNo\tTotalMarks(out of 300)");
        for(Student s:this.student){
            System.out.println(s.getRank()+"\t\t"+s.getRollno()+"\t\t"+s.getTotal());
        }
    }

    @Override
    public String toString() {
        if(this.student!=null)
            return "Students{" +
                    "students=" + this.student.size() +
                    '}';
        return "null";
    }
}
