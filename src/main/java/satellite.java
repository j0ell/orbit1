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


    }



}
