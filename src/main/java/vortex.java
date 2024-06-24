import java.lang.reflect.Array;

public class vortex {
    //int xval;
    //int yval;
    //int zval;
    double xval;
    double yval;
    double zval;
    double theta; // winkel wird benötigt für projektion
    double radius;
    double distance;
    double showtime;
    double velocity;


    public vortex(double x, double y, double z){
        this.xval =  x ;//(int) x; //forces double to int
        this.yval = y;//(int) y; //
        this.zval = z;//(int) z; //
        this.theta = 0;
        this.radius = Math.sqrt((x * x) + (y * y) + (z * z));
        this.distance = 0;
        this.showtime = 0;
        this.velocity = 0;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setShowtime(double showtime) {
        this.showtime = showtime;
    }

    public void setXval(double xval) {
        this.xval = xval;//(int) xval;
    }

    public void setYval(double yval) {
        this.yval = yval;//(int) yval;
    }

    public void setZval(double zval) {
        this.zval = zval;//(int) zval;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getXval() {
        return xval;
    }

    public double getYval() {
        return yval;
    }

    public double getZval() {
        return zval;
    }

    /*
    public int[] getVals() {
        int [] valArray = {xval, yval, zval};
        return valArray;
    }
    */


    public double getTheta() {
        return theta;
    }

    public double getRadius() {
        return radius;
    }

    public double getDistance() {
        return distance;
    }

    public double getShowtime() {
        return showtime;
    }

    public double getVelocity() {
        return velocity;
    }
}
