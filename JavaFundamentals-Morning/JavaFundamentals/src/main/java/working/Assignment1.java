package working;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Assignment1 {

    private String xmlFilePath = "D:\\side_projext\\IdeaProjects\\JavaFundamentals\\src\\main\\java\\working\\Data.xml";
    private String filename = "stuObject.txt";
    private String csvfilename = "top5students.csv";
    private Students students;

    public void readXml(){
        System.out.println("Reading XML Data");
        File xmlFile = new File(xmlFilePath);
        JAXBContext jaxbContext;
        try{
            jaxbContext = JAXBContext.newInstance(Students.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            this.students = (Students) jaxbUnmarshaller.unmarshal(xmlFile);
            this.students.calculateRankAndTotal();
            this.students.printDetails();
        }
        catch(JAXBException e){
            e.printStackTrace();
        }
    }

    public void deSerialize(){
        System.out.println("De Serialization");
        try{
            FileOutputStream fileout = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(this.students);
            out.close();
            fileout.close();
        }catch(Exception e){
            System.out.println("kn serialization Exception occured:"+e);
        }
    }

    public void serialize(){
        System.out.println("Serializing");
        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.students = (Students) in.readObject();
            in.close();
            fileIn.close();
        }catch(Exception e){
            System.out.println("kn serialization Exception occured:"+e);
        }
    }

    public void printTop5Ranks(){
        System.out.println("Top 5 Rank Holders");
        this.students.printTop5();
    }

    public void writeToCSV(){
        try{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvfilename));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Rank", "RollNo", "Total Marks out of 300"));
            this.students.writeTop5(csvPrinter);
            csvPrinter.flush();
            writer.flush();
        }catch(Exception e){
            System.out.println("kn Write to csv exception:"+e);
        }
    }

    public void singletonExample(){
        AUSingleton inst = AUSingleton.getInstance();
        inst.exampleFuntion();
        inst.setSingletonVar(3);
        inst.exampleFuntion();
        AUSingleton inst2 = AUSingleton.getInstance();
        inst.exampleFuntion();
    }

}