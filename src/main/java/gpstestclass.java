import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class gpstestclass {
    @JsonProperty("gpstestclass")
    private List<tlesat> gpstestclassList;

    // Getter and Setter
    public List<tlesat> getGpstestclassList() {
        return gpstestclassList;
    }

    public void setGpstestclassList(List<tlesat> gpstestclassList) {
        this.gpstestclassList = gpstestclassList;
    }
}
