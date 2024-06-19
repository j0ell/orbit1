import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JSONsave {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON from resources folder
            InputStream fileInputStream = JsonArrayToList.class.getClassLoader().getResourceAsStream("gpstest.json");
            if (fileInputStream == null) {
                throw new IllegalArgumentException("File not found!");
            }

            // Deserialize JSON to gpstestclass object
            gpstestclass gpstestData = objectMapper.readValue(fileInputStream, gpstestclass.class);

            // Get the list of tlesat objects from gpstestclass
            List<tlesat> satelliteDataList = gpstestData.getGpstestclassList();

            // Process and print satellite data
            for (tlesat satellite : satelliteDataList) {
                System.out.println("Satellite Name: " + satellite.getOBJECT_NAME());
                System.out.println("Satellite ID: " + satellite.getOBJECT_ID());
                // Print other properties as needed
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//DOESNT SAVE ANYTHING YET