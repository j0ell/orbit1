



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
            InputStream fileInputStream = JsonArrayToList.class.getClassLoader().getResourceAsStream("gpstest.json"); //hier wird dataset definiert3
            if (fileInputStream == null) {
                throw new IllegalArgumentException("file not found!");
            }



            /*
            Um Geschwindigikeit zu berechnen: Abstand von Punkt zu nächsten Pubkt berechnene
            mit Abstand / geschwindigkeit verhältnis berechnen, wie lange der punkt angezeigt werden muss
             */
            // Read the JSON file and map to SatelliteData class
            //gpstestclass satelliteData = objectMapper.readValue(new File(fileUrl.getFile()), gpstestclass.class);
            //gpstestclass satelliteData = objectMapper.readValue(fileInputStream, gpstestclass.class);
            List<tlesat> satelliteDataList = objectMapper.readValue(fileInputStream, new TypeReference<List<tlesat>>() {});

            tlesat tlesat = satelliteDataList.get(5);
            String name = tlesat.getOBJECT_NAME();
            System.out.println("object name: " + name);
            String id = tlesat.getOBJECT_ID();
            System.out.println("object id: " + id);
            orbit_1 orbit = new orbit_1(tlesat);
            tlesat.setOrbit(orbit);
            double biga = tlesat.getOrbit().getBiga();
            System.out.println("große halbachse a: " + biga);
            double ecc = tlesat.getOrbit().getNum_e();
            System.out.println("num_e: " + ecc);
            double rperi = tlesat.getOrbit().getRperi();
            System.out.println("rperi: " + rperi);
            double rapo = tlesat.getOrbit().getRapo();
            System.out.println("rapo: " + rapo);
            double n = tlesat.getMEAN_MOTION();
            System.out.println("mean motion n: " + n);
            double hapo = tlesat.getOrbit().getHapo();
            System.out.println("hapo: " + hapo);
            double hperi = tlesat.getOrbit().getHperi();
            System.out.println("hperi: " + hperi);
            List<vortex> flatorbit = tlesat.getOrbit().getFlatOrbit(tlesat);
            List<vortex> inclorbit = tlesat.getOrbit().RotateIncl(flatorbit);
            double testdistance = satellite.DistanceGetter(inclorbit, 0);
            System.out.println("testdistance: " + testdistance);
            vortex testvortex = inclorbit.get(90); //geht
            double zval = testvortex.getZval();
            System.out.println("zval: " + zval);
            double testradius = orbit.getRadius(testvortex); //ca. 2 km of of periapsis? why? FIXED RE=6378 and r in vortex
            System.out.println("radius: " + testradius);
            double inc = orbit.getIncl();
            System.out.println("inclination: " + inc);
            double x = testvortex.getXval();
            System.out.println("x: " + x);
            double y = testvortex.getYval();
            System.out.println("y: " + y);
            double z = testvortex.getZval();
            System.out.println("z: " + z);
            //System.out.println(testradius); //FALSCH!!!!!!!!! Z NEU BERECHNEN!!!!!!!!
            double velocity = orbit.getVelocity(testvortex);
            System.out.println("velocity: " + velocity);
            double smallestradius = rapo;
            for (vortex point : inclorbit) {
                double rad = orbit.getRadius(point);
                if (rad < smallestradius) {
                    smallestradius = rad;
                }
                //System.out.println(smallestradius);
            }
            System.out.println("calculated rperi: " + smallestradius);

            double biggestradius = rperi;

            for (vortex point : inclorbit) {
                double rad = orbit.getRadius(point);
                if (rad > biggestradius) {
                    biggestradius = rad;
                }
            }
            System.out.println("calculated rapo: " + biggestradius);
            satellite.Distancer(inclorbit);
            double distance1 = inclorbit.get(0).getDistance();
            System.out.println("distance1: " + distance1);
            double distance2 = inclorbit.get(719).getDistance();
            System.out.println("distance2: " + distance2);
            satellite.Showtimer(inclorbit);
            double showtime1 = inclorbit.get(0).getShowtime();
            System.out.println("showtime1: " + showtime1);
            double showtime2 = inclorbit.get(719).getShowtime();
            System.out.println("showtime2: " + showtime2); //check if calculation works!!!! METHOD IS NOT WORKING FOR LAST POINT!!! FIXED
            double testx = inclorbit.get(0).getXval();
            double testx2 = inclorbit.get(719).getXval();
            System.out.println("testx: " + testx);
            System.out.println("testx2: " + testx2);
            double testvelo = orbit_1.getVelocity(inclorbit.get(719));
            System.out.println("testvelo: " + testvelo);


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
