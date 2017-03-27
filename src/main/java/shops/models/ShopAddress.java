package shops.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

/**
 * Created by admin on 26/03/2017.
 */
public class ShopAddress extends Location {

    @JsonProperty("number")
    private String streetNumber;

    private String postCode;

    public ShopAddress() { }

    public ShopAddress(String streetNumber, String postCode) {
        streetNumber = streetNumber;
        postCode = postCode;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public final boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof ShopAddress)) {
            return false;
        }
        ShopAddress thatShopAddress = (ShopAddress) o;
        return Objects.equals(streetNumber, thatShopAddress.streetNumber) &&
                Objects.equals(postCode, thatShopAddress.postCode);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(streetNumber, postCode);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("streetNumber", streetNumber)
                .append("postCode", postCode)
                .append("position", position)
                .toString();
    }
}
