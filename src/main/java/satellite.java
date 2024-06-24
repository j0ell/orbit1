import java.util.List;

public class satellite {
    double absv;
    double period;
    double biga;
    double radius;
    double mue;


    public satellite(tlesat tlesat) {
        orbit_1 orbit = tlesat.getOrbit();
        this.period = orbit.getPeriod();
        this.biga = orbit.getBiga();
        this.mue = orbit.getMue();
        ;


    }

    public static double DistanceGetter(List<vortex> pointlist, int index) {
        vortex point1 = pointlist.get(index);
        vortex point2 = pointlist.get(index + 1);
        double x1 = point1.getXval();
        double y1 = point1.getYval();
        double z1 = point1.getZval();
        double x2 = point2.getXval();
        double y2 = point2.getYval();
        double z2 = point2.getZval();

        //DISTANCES
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);
        double dz = Math.abs(z2 - z1);
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        return distance;
    }

    public static void Distancer(List<vortex> pointlist) {
        int i = pointlist.size() - 1;
        for (int j = 0; j < i - 1; j++) { //für j = i PROBLEM!!!! da kein nächster pubkt in liste
            double distance = DistanceGetter(pointlist, j); //should work
            vortex point1 = pointlist.get(j);
            point1.setDistance(distance);
        }
        vortex point2 = pointlist.get(i); //ab hier nur für letzten punkt der liste
        double x1 = point2.getXval();
        double y1 = point2.getYval();
        double z1 = point2.getZval();

        vortex point0 = pointlist.get(0);
        double x2 = point0.getXval();
        double y2 = point0.getYval();
        double z2 = point0.getZval();

        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);
        double dz = Math.abs(z2 - z1);

        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        point2.setDistance(distance);
    }

    public static void Showtimer(List<vortex> pointlist) { //sets showtime for every point of the list
        int i = pointlist.size(); //- 1;
        for (int j = 0; j < i; j++) {
            double distance = pointlist.get(j).getDistance(); //gets distance
            double velo = orbit_1.getVelocity(pointlist.get(j));
            double showtime = distance / velo;
            vortex point1 = pointlist.get(j);
            point1.setShowtime(showtime); //sets showtime for every point

        }
    }



}
