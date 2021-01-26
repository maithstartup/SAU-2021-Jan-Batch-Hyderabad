import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // Import the Scanner class to read text files

public class SingleThread {

    static void countSentences(String filePath) throws Exception {
        Path file = Path.of(filePath);

        String bookString = Files.readString(file);

        int sentenceCount = 0;
        // Using sentence delimiters
        String tmpArray[] = bookString.split("[!.?:]+");
        sentenceCount = tmpArray.length;

        System.out.println("Number of sentences: " + sentenceCount);
    }


    public static void main(String[] args) {
        int count = 0;
        int para_count = 0;
        int words=0;
        Map<String,Integer> wordCount = new HashMap<>();

        Instant start = Instant.now();
        try {
            String filePath = "D:\\side_projext\\IdeaProjects\\multithread\\Book.txt";
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine() ) {
                String data = myReader.nextLine();
                //System.out.println(data);
                count++;
                    String tmpArray[] = data.split(" ");
                    for(String tmp: tmpArray){
                        words++;
                        if(wordCount.containsKey(tmp))
                        {
                            wordCount.put(tmp,wordCount.get(tmp)+1);
                        }
                        else
                        {
                            wordCount.put(tmp,1);
                        }
                    }
                }
            myReader.close();

            System.out.println("Total No of Lines "+count);
            System.out.println("Total No of Words "+words);
            countSentences(filePath);


            int temp_count=1;
            for (Map.Entry<String, Integer> wordEntry : wordCount.entrySet()) {

                System.out.println(wordEntry.getKey() + " :\t" + wordEntry.getValue());
                if(temp_count==10) break;
                temp_count++;
            }
            } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        //System.out.println(empty_lines);
        System.out.println("Time Taken for Single Thread "+ timeElapsed +" ms" );

    }
}
