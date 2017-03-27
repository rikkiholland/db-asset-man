package shops.models.google;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by admin on 26/03/2017.
 */
public class GoogleAddressComponent {

    @JsonProperty("long_name")
    private String longName;

    @JsonProperty("short_name")
    private String shortName;

    private String[] types;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

}