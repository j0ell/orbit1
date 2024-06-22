import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)



public class tlesat {
    @JsonProperty("OBJECT_NAME")
    private String OBJECT_NAME;
    @JsonProperty("OBJECT_ID")
    private String OBJECT_ID;
    @JsonProperty("EPOCH")
    private String EPOCH;
    @JsonProperty("MEAN_MOTION")
    private double MEAN_MOTION;
    @JsonProperty("ECCENTRICITY")
    private double ECCENTRICITY;
    @JsonProperty("INCLINATION")
    private double INCLINATION;
    @JsonProperty("RA_OF_ASC_NODE")
    private double RA_OF_ASC_NODE;
    @JsonProperty("ARG_OF_PERICENTER")
    private double ARG_OF_PERICENTER;
    @JsonProperty("MEAN_ANOMALY")
    private double MEAN_ANOMALY;
    @JsonProperty("EPHEMERIS_TYPE")
    private double EPHEMERIS_TYPE;
    @JsonProperty("CLASSIFICATION_TYPE")
    private String CLASSIFICATION_TYPE;
    @JsonProperty("NORAD_CAT_ID")
    private int NORAD_CAT_ID;
    @JsonProperty("ELEMENT_SET_NO")
    private int ELEMENT_SET_NO;
    @JsonProperty("REV_AT_EPOCH")
    private int REV_AT_EPOCH;
    @JsonProperty("BSTAR")
    private double BSTAR;
    @JsonProperty("MEAN_MOTION_DOT")
    private double MEAN_MOTION_DOT;
    @JsonProperty("MEAN_MOTION_DDOT")
    private double MEAN_MOTION_DDOT;

    private orbit_1 orbit;


//BUILD CONSTRUCTOR FOR JSON FILE!!!!!!!!!!

public String getOBJECT_NAME() { return OBJECT_NAME; }
public void setOBJECT_NAME(String OBJECT_NAME) { this.OBJECT_NAME = OBJECT_NAME; }

public String getOBJECT_ID() { return OBJECT_ID; }
public void setOBJECT_ID(String OBJECT_ID) { this.OBJECT_ID = OBJECT_ID; }

public String getEPOCH() { return EPOCH; }
public void setEPOCH(String EPOCH) { this.EPOCH = EPOCH; }

public double getMEAN_MOTION() { return MEAN_MOTION; }
public void setMEAN_MOTION(double MEAN_MOTION) { this.MEAN_MOTION = MEAN_MOTION; }

public double getECCENTRICITY() { return ECCENTRICITY; }
public void setECCENTRICITY(double ECCENTRICITY) { this.ECCENTRICITY = ECCENTRICITY; }

public double getINCLINATION() { return INCLINATION; }
public void setINCLINATION(double INCLINATION) { this.INCLINATION = INCLINATION; }

public double getRA_OF_ASC_NODE() { return RA_OF_ASC_NODE; }
public void setRA_OF_ASC_NODE(double RA_OF_ASC_NODE) { this.RA_OF_ASC_NODE = RA_OF_ASC_NODE; }

public double getARG_OF_PERICENTER() { return ARG_OF_PERICENTER; }
public void setARG_OF_PERICENTER(double ARG_OF_PERICENTER) { this.ARG_OF_PERICENTER = ARG_OF_PERICENTER; }

public double getMEAN_ANOMALY() { return MEAN_ANOMALY; }
public void setMEAN_ANOMALY(double MEAN_ANOMALY) { this.MEAN_ANOMALY = MEAN_ANOMALY; }

public double getEPHEMERIS_TYPE() { return EPHEMERIS_TYPE; }
public void setEPHEMERIS_TYPE(double EPHEMERIS_TYPE) { this.EPHEMERIS_TYPE = EPHEMERIS_TYPE; }

public String getCLASSIFICATION_TYPE() { return CLASSIFICATION_TYPE; }
public void setCLASSIFICATION_TYPE(String CLASSIFICATION_TYPE) { this.CLASSIFICATION_TYPE = CLASSIFICATION_TYPE; }

public int getNORAD_CAT_ID() { return NORAD_CAT_ID; }
public void setNORAD_CAT_ID(int NORAD_CAT_ID) { this.NORAD_CAT_ID = NORAD_CAT_ID; }

public int getELEMENT_SET_NO() { return ELEMENT_SET_NO; }
public void setELEMENT_SET_NO(int ELEMENT_SET_NO) { this.ELEMENT_SET_NO = ELEMENT_SET_NO; }

public int getREV_AT_EPOCH() { return REV_AT_EPOCH; }
public void setREV_AT_EPOCH(int REV_AT_EPOCH) { this.REV_AT_EPOCH = REV_AT_EPOCH; }

public double getBSTAR() { return BSTAR; }
public void setBSTAR(double BSTAR) { this.BSTAR = BSTAR; }

public double getMEAN_MOTION_DOT() { return MEAN_MOTION_DOT; }
public void setMEAN_MOTION_DOT(double MEAN_MOTION_DOT) { this.MEAN_MOTION_DOT = MEAN_MOTION_DOT; }

public double getMEAN_MOTION_DDOT() { return MEAN_MOTION_DDOT; }
public void setMEAN_MOTION_DDOT(double MEAN_MOTION_DDOT) { this.MEAN_MOTION_DDOT = MEAN_MOTION_DDOT; }

public orbit_1 getOrbit() { return  orbit; }
public void setOrbit(orbit_1 orbit) { this.orbit = orbit; }
}
