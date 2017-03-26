package shops.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

/**
 * Created by admin on 26/03/2017.
 */
public class ShopAddress extends AbstractVersionedEntity {

    @JsonProperty("number")
    private String streetNumber;

    private String postCode;

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
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof ShopAddress)) {
            return false;
        }
        ShopAddress thatShopAddress = (ShopAddress) o;
        return Objects.equals(version, thatShopAddress.version) &&
                Objects.equals(streetNumber, thatShopAddress.streetNumber) &&
                Objects.equals(postCode, thatShopAddress.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, streetNumber, postCode);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("version", version)
                .append("streetNumber", streetNumber)
                .append("postCode", postCode)
                .toString();
    }
}
