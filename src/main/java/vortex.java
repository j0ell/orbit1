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


    public vortex(double x, double y, double z){
        this.xval =  x ;//(int) x; //forces double to int
        this.yval = y;//(int) y; //
        this.zval = z;//(int) z; //
        this.theta = 0;
        this.radius = Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public void setRadius(double radius){
        this.radius = radius;
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
}
