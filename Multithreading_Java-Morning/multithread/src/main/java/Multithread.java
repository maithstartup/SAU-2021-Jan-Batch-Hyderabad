import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

public class Multithread extends Thread {


    static void wordFrequency(String filePath) throws Exception {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Map<String, Integer> wordCount = new HashMap<>();
        int words=0;
        String line;

        while ((line = reader.readLine()) != null) {
            // System.out.println(line);

            String tmpArray[] = line.split(" ");

            for (String temp : tmpArray) {
                words++;

                if (temp.length() != 0) {
                    if (wordCount.containsKey(temp))
                        wordCount.put(temp, wordCount.get(temp) + 1);
                    else
                        wordCount.put(temp, 1);
                }
            }
        }
        System.out.println("Total No of Words "+ words);
        int temp_count=0;
        for (Map.Entry<String, Integer> wordEntry : wordCount.entrySet()) {
            System.out.println(wordEntry.getKey() + " :\t" + wordEntry.getValue());
            if(temp_count==10)break;
            temp_count++;
        }

        reader.close();
    }

    static void countSentences(String filePath) throws Exception {
        Path file = Path.of(filePath);

        String bookString = Files.readString(file);

        int sentenceCount = 0;
        // Using sentence delimiters
        String tmpArray[] = bookString.split("[!.?:]+");
        sentenceCount = tmpArray.length;

        System.out.println("Number of sentences: " + sentenceCount);
    }

    static void countParagraphs(String filePath) throws Exception {
        Path file = Path.of(filePath);

        String bookString = Files.readString(file);

        String paragraphs[] = bookString.split("\n");

        System.out.println("Number of Lines: " + paragraphs.length);
    }

    public static void main(String[] args) throws Exception {
        Instant start = Instant.now();

        String filePath = "D:\\side_projext\\IdeaProjects\\multithread\\Book.txt";

        Thread countWordThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    wordFrequency(filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        countWordThread.start();
        // countWordThread.join();

        Thread countSentencesThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    countSentences(filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        countSentencesThread.start();
        // countSentencesThread.join();
        Thread countParagraphsThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    countParagraphs(filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        countParagraphsThread.start();
        // countParagraphsThread.join();

        countWordThread.join();
        countParagraphsThread.join();
        countSentencesThread.join();

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Taken for MultiThread "+ timeElapsed +" ms" );

    }
}