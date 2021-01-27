import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;



public class InitialTask {


    public static HashMap<String, String[]> getCities() {
        HashMap<String, String[]> countryCity = new HashMap<>();

        countryCity.put("Somalia", new String[]{"Cadale", "Ceel Huur", "Dhahar", "Dhamasa", "Docol"});
        countryCity.put("Vietnam", new String[]{"Can Tho", "Da Nang", "Hanoi", "Haiphong", "Ho Chi Minh City"});
        countryCity.put("Japan", new String[]{"Nagoya", "Tokyo", "Date", "Hiroshima", "Kure"});
        countryCity.put("India", new String[]{"Mumbai", "Bangalore", "Chennai", "Pune", "Patna"});
        countryCity.put("Nepal", new String[]{"Kathamandu", "Pokhara", "Lalithpur", "Bharatpur", "Birgunj"});
        return countryCity;
    }

       public static String getCountry(String contents){
        String arr[];
        arr=contents.split("<title>");
        contents = arr[1];
        arr=contents.split("</title>");
        return arr[0];

    }

    public static void main(String[] args) throws URISyntaxException, IOException {

        Path path = Paths.get(InitialTask.class.getClassLoader().getResource("sample.html").toURI());

        String contents = new String(Files.readAllBytes(path));


        //Your logic goes here

        String countryName = getCountry(contents);

        HashMap<String, String[]>list=getCities();

        String[] cities=list.get(countryName);

        for(int i=0;i<cities.length;i++)
        {
            System.out.println(cities[i]);
        }

    }
}
