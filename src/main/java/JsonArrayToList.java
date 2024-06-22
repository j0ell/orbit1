



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonArrayToList {

    public List<tlesat> satlist;
    public JsonArrayToList() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream fileInputStream = JsonArrayToList.class.getClassLoader().getResourceAsStream("gpstest.json"); //hier wird dataset definiert3
            if (fileInputStream == null) {
                throw new IllegalArgumentException("file not found!");
            }
            satlist = objectMapper.readValue(fileInputStream, new TypeReference<List<tlesat>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<tlesat> getSatlist() {
        return satlist;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        //List<gpstestclass> satelliteDataList = objectMapper.readValue(jsonString, new TypeReference<List<gpstestclass>>() {});

        try {
            // Get the URL of the JSON file from the resources folder
            /*URL fileUrl = JsonArrayToList.class.getClassLoader().getResource("gpstest.json");
            //URL fileUrl = Main.class.getClassLoader().getResource("gpstest.json");
            if (fileUrl == null) {
                throw new IllegalArgumentException("file not found!");
                */
            InputStream fileInputStream = JsonArrayToList.class.getClassLoader().getResourceAsStream("dataset1.json"); //hier wird dataset definiert3
            if (fileInputStream == null) {
                throw new IllegalArgumentException("file not found!");
            }

            // Read the JSON file and map to SatelliteData class
            //gpstestclass satelliteData = objectMapper.readValue(new File(fileUrl.getFile()), gpstestclass.class);
            //gpstestclass satelliteData = objectMapper.readValue(fileInputStream, gpstestclass.class);
            List<tlesat> satelliteDataList = objectMapper.readValue(fileInputStream, new TypeReference<List<tlesat>>() {});

            tlesat tlesat = satelliteDataList.get(10);
            orbit_1 orbit = new orbit_1(tlesat);
            tlesat.setOrbit(orbit);
            double biga = tlesat.getOrbit().getBiga();
            System.out.println(biga);
            double ecc = tlesat.getOrbit().getNum_e();
            System.out.println(ecc);
            double rperi = tlesat.getOrbit().getRperi();
            System.out.println(rperi);
            double rapo = tlesat.getOrbit().getRapo();
            System.out.println(rapo);
            double n = tlesat.getMEAN_MOTION();
            System.out.println(n);
            double hapo = tlesat.getOrbit().getHapo();
            System.out.println(hapo);
            double hperi = tlesat.getOrbit().getHperi();
            System.out.println(hperi);
            List<vortex> flatorbit = tlesat.getOrbit().getFlatOrbit(tlesat);
            List<vortex> inclorbit = tlesat.getOrbit().RotateIncl(flatorbit);
            vortex testvortex = inclorbit.get(90); //geht
            double zval = testvortex.getZval();
            System.out.println(zval);
            double testradius = orbit.getRadius(testvortex); //ca. 2 km of of periapsis? why? FIXED RE=6378 and r in vortex
            System.out.println(testradius);
            double inc = orbit.getIncl();
            System.out.println(inc);
            double x = testvortex.getXval();
            System.out.println(x);
            double y = testvortex.getYval();
            System.out.println(y);
            double z = testvortex.getZval();
            System.out.println(z);
            System.out.println(testradius); //FALSCH!!!!!!!!! Z NEU BERECHNEN!!!!!!!!
            double smallestradius = rapo;
            for (vortex point : inclorbit) {
                double rad = orbit.getRadius(point);
                if (rad < smallestradius) {
                    smallestradius = rad;
                }
                //System.out.println(smallestradius);
            }
            System.out.println(smallestradius);

            double biggestradius = rperi;

            for (vortex point : inclorbit) {
                double rad = orbit.getRadius(point);
                if (rad > biggestradius) {
                    biggestradius = rad;
                }
            }
            System.out.println(biggestradius);

            /*
            for (vortex point : inclorbit) {
                System.out.println(point.getXval());
                System.out.println(point.getYval());
                System.out.println(point.getZval());
            }
            */

            /*
            int firstxpoint = flatorbit.get(180).getXval();
            System.out.println(firstxpoint);
            int ypoint = flatorbit.get(90).getYval();
            System.out.println(ypoint);
            */
            //test inclorbit function, if it doesnt work, calculate with proper cylindrical coordinate logic

            // Process the satellite data
            /*
            for (tlesat satellite : satelliteDataList) {
                System.out.println("Satellite Name: " + satellite.getOBJECT_NAME());
                System.out.println("Satellite ID: " + satellite.getOBJECT_ID());
                System.out.println("Epoch: " + satellite.getEPOCH());
                System.out.println("Mean Motion: " + satellite.getMEAN_MOTION());
                System.out.println("Eccentricity: " + satellite.getECCENTRICITY());
                System.out.println("Inclination: " + satellite.getINCLINATION());
                System.out.println("RA of Ascending Node: " + satellite.getRA_OF_ASC_NODE());
                System.out.println("Arg of Pericenter: " + satellite.getARG_OF_PERICENTER());
                System.out.println("Mean Anomaly: " + satellite.getMEAN_ANOMALY());
                System.out.println("Ephemeris Type: " + satellite.getEPHEMERIS_TYPE());
                System.out.println("Classification Type: " + satellite.getCLASSIFICATION_TYPE());
                System.out.println("NORAD Catalog ID: " + satellite.getNORAD_CAT_ID());
                System.out.println("Element Set Number: " + satellite.getELEMENT_SET_NO());
                System.out.println("Rev at Epoch: " + satellite.getREV_AT_EPOCH());
                System.out.println("BSTAR: " + satellite.getBSTAR());
                System.out.println("Mean Motion Dot: " + satellite.getMEAN_MOTION_DOT());
                System.out.println("Mean Motion DDOT: " + satellite.getMEAN_MOTION_DDOT());
                System.out.println();
                */


            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
