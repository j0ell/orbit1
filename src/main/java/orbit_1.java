import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import static sun.awt.windows.ThemeReader.getPoint;

public class orbit_1 {
    double hperi; //height peri
    double hapo; //height apo
    double rperi; //radius peri
    double rapo; //radius apo
    double biga; //große halbachse
    double lin_e; //lineare exzentrität
    double num_e; //numerische exzentrität
    double incl; //inclination
    double mue = 398600.44; //mue erde
    double mean_motion; //n = sqrt(mue / a^3)
    double Period;
    double Re = 6378;
    double smallb;
    List<vortex> FlatOrbit;
    double mean_motion_rads;
    //double sday;
    //double radius;
    double argperi;
    double RAAN;

    public orbit_1(tlesat tlesat) {

        //this.biga = (rperi + rapo) / 2; //große halbachse = (radius peri + radius apo) / 2
        this.incl = tlesat.getINCLINATION(); //inclination
        //this.sday = 86164.1;
        this.mean_motion = tlesat.getMEAN_MOTION();
        this.mean_motion_rads = tlesat.getMEAN_MOTION() * (2 * Math.PI / 86400);
        this.num_e = tlesat.getECCENTRICITY(); //wirkliche TLE exzentrität
        //this.biga = Math.pow((mue / Math.pow(tlesat.getMEAN_MOTION(), (2))), (1/3) ); //große halbachse //hier fehler???
        this.biga = Math.pow((mue / Math.pow(mean_motion_rads, 2)), (1.0 / 3));
        this.Period = 2 * Math.PI * Math.sqrt((mue/Math.pow(biga, (3))));
        this.rperi = biga * (1 - tlesat.getECCENTRICITY());
        this.rapo = biga * (1 + tlesat.getECCENTRICITY());
        this.hperi = rperi - Re;
        this.hapo = rapo - Re;
        this.lin_e = num_e * biga; //c = a * e
        this.smallb = Math.sqrt((Math.pow(biga, (2))) - Math.pow(lin_e, (2))); //b = sqrt(a^2 - c^2)
        this.FlatOrbit = getFlatOrbit(tlesat); //Flat Orbit
        //this.radius = (biga * (1 - (num_e * num_e)))/(1)
        this.argperi = tlesat.getARG_OF_PERICENTER(); //argument of perigee (should be in degrees here)
        this.RAAN = tlesat.getRA_OF_ASC_NODE(); //RAAN, should be degrees here
    }

    public vortex getPoint(double theta) { //calculates radius for every winkel theta
        double radius = ((biga * (1 - (num_e * num_e)))/(1 + num_e * Math.cos(theta)));
        double x = radius * Math.cos(theta); //radius(theta)  * xprojection
        double y = radius * Math.sin(theta); //radius(theta) * yprojection
        //double x = biga * Math.cos(theta); //ÜBERPTÜFEN OB DAS SO STIMMT
        //double y = smallb * Math.sin(theta); //hier muss die kleine halbachse berechnet werden
        double z = 0;
        vortex vortex = new vortex(x, y, z);
        vortex.setRadius(radius);
        return vortex;
    }


    public double getVelocity(vortex point) {
        double radius = point.getRadius();
        double a = getBiga();
        double insqrt = mue * ((2 / radius) - (1 / a)); //numbers in square root
        double velocity = Math.sqrt(insqrt); //visviva
        return velocity;
        }




    public List<vortex> getFlatOrbit(tlesat tlesat) {
        List<vortex> flatorbit = new ArrayList<>();
        //double argperi = Math.toRadians(tlesat.getARG_OF_PERICENTER()); //Arg of Pericenter in radians
        for (double i = 0; i < 2 * Math.PI; i = i + ((2 * Math.PI) / 720) ) { //was 360!! test!!//for every degree in 360 degrees
            vortex point = getPoint(i); //berechnet x und y mit getpoint funktion
            point.setTheta(i); //setzt hoffentlich jeden point seinen winkel zu
            flatorbit.add(point); //added point zur liste

            /*
            double x = point.getXval();
            double y = point.getYval();
            double z = point.getZval();

            //Rotation um z Achse mit Arg of peri
            double newx = x * Math.cos(argperi) - y * Math.sin(argperi);
            double newy = x * Math.sin(argperi) + y * Math.cos(argperi);

            point.setXval(newx);
            point.setYval(newy);

            flatorbit.add(point);
            */

        }

        return flatorbit; //hat für jeden winkel einen 2d vortex
    }



    /*
    public List<vortex> PeriArg(List<vortex>){ //rotieren um argument of perigee zu finden
        //argument des perigees rotieren
    }
    */

    public List<vortex> RotateIncl(List<vortex> flatorbit){
        double inc = incl;
        double incrad = Math.toRadians(inc); //inclination in radians
        double RAANrad = Math.toRadians(RAAN);
        double argperirad = Math.toRadians(argperi);
        List<vortex> inclorbit = new ArrayList<>();
        for (vortex point : flatorbit) { //für jeden point in flatorbit
            //double r =  Math.sqrt((point.getXval() * point.getXval()) + (point.getYval() * point.getYval())); //Radius als Hypothenuse benutzen um Projektionen zu errechnen
            //double r = point.getRadius(); //kriegt radius vom vortex jetzt
            //double zpoint =  r * Math.sin(incrad); //Hypo (r) * sin(theta) (sin(incl)) FUNKTIONIERT FALSCH!
            //double zpoint = point.getXval() * Math.sin(incrad); // TEST
            //point.setZval(zpoint); //Jetzt x und y ausrechnen ???? WIE???
            //double newflatr = r * Math.cos(incrad); //Projektion des inklinierten radius auf xy ebene, jetzt daraus x und y
            //MIT THETA POINT UND INCL X UND Y BERECHNEN
            //double zpoint = point.getYval() * Math.sin(incrad); // TEST
            //double zpoint = r * Math.sin(incrad);
            //oint.setZval(zpoint); //Jetzt x und y ausrechnen ???? WIE???
            //double theta = point.getTheta();
            //double xpoint = newflatr * Math.cos(theta); //calculate new x point with theta and flatr?
            //double ypoint = newflatr * Math.sin(theta); //calculate new y point with theta and flatr?
            //point.setXval(xpoint); //sets xval for point
            //point.setYval(ypoint); //sets yval for point
            double x = point.getXval();
            double y = point.getYval();
            double z = point.getZval();

            //rotation around z to get arg of perigee
            double xpeg = x * Math.cos(argperirad) - y * Math.sin(argperirad);
            double ypeg = x * Math.sin(argperirad) + y * Math.cos(argperirad);

            //rotation around y to get inclination
            double xnew = xpeg * Math.cos(incrad) + z * Math.sin(incrad);
            double znew = -xpeg * Math.sin(incrad) + z * Math.cos(incrad);



            //rotation around z for RAAN
            double xnew2 = xnew * Math.cos(RAANrad) - ypeg * Math.sin(RAANrad); //x transformation
            double ynew2 = xnew * Math.sin(RAANrad) + ypeg * Math.cos(RAANrad);

            vortex realpoint = new vortex(xnew2, ynew2, znew); //should work?

            inclorbit.add(realpoint); //adds point to inclorbit list
        }
        return inclorbit; //returned die fertige liste
    }

    public double getRadius(vortex point){
        double x = point.getXval();
        double y = point.getYval();
        double z = point.getZval();
        double radius = Math.sqrt((x * x) + (y * y) + (z * z));
        return radius;
    }

    public void setBiga () {
        this.biga = Math.pow((mue / Math.pow(mean_motion, (2))), (1/3) );
    }

    public void setPeriod() {
        this.Period = 2 * Math.PI * Math.sqrt((mue/Math.pow(biga, (3))));
    }

    public void setRadius() {
        this.rperi = biga * (1 - num_e);
        this.rapo = biga * (1 + num_e);
        this.hperi = rperi - Re;
        this.hapo = rapo - Re;
    }

    public double getHperi() {
        return hperi;
    }

    public double getHapo() {
        return hapo;
    }

    public double getRperi() {
        return rperi;
    }

    public double getRapo() {
        return rapo;
    }

    public double getBiga() {
        return biga;
    }

    public double getLin_e() {
        return lin_e;
    }

    public double getNum_e() {
        return num_e;
    }

    public double getIncl() {
        return incl;
    }

    public double getMue() {
        return mue;
    }

    public double getMean_motion() {
        return mean_motion;
    }

    public double getPeriod() {
        return Period;
    }

    public double getRe() {
        return Re;
    }
}


