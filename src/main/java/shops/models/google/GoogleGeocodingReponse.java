package shops.models.google;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by admin on 26/03/2017.
 */
public class GoogleGeocodingReponse {

    private String status;

    @JsonProperty("results")
    private GoogleAddressResult[] addressResults;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GoogleAddressResult[] getAddressResults() {
        return addressResults;
    }

    public void setAddressResults(GoogleAddressResult[] addressResults) {
        this.addressResults = addressResults;
    }
}
