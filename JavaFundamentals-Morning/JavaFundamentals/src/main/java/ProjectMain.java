import working.Assignment1;

public class ProjectMain {

        public static void func(){
            Assignment1 ass1 = new Assignment1();
            ass1.readXml();
            ass1.deSerialize();
            ass1.serialize();
            ass1.printTop5Ranks();
            ass1.writeToCSV();
             ass1.singletonExample();
        }




        public static void main(String[] args) {

            func();

        }

    }

