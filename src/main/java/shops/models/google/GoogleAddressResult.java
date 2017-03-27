package shops.models.google;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by admin on 26/03/2017.
 */
public class GoogleAddressResult {

    @JsonProperty("formatted_address")
    private String formattedAddress;

    @JsonProperty("address_components")
    private GoogleAddressComponent[] addressComponents;

    private GoogleGeometry geometry;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public GoogleAddressComponent[] getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(GoogleAddressComponent[] addressComponents) {
        this.addressComponents = addressComponents;
    }

    public GoogleGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(GoogleGeometry geometry) {
        this.geometry = geometry;
    }

}
