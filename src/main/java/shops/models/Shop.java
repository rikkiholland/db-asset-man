package shops.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

/**
 * Created by admin on 26/03/2017.
 */
public class Shop extends AbstractVersionedEntity {

    @JsonProperty("shopName")
    private String name;

    @JsonProperty("shopAddress")
    private ShopAddress address;

    public Shop() { }

    public Shop(String shopName) {
        name = shopName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShopAddress getAddress() {
        return address;
    }

    public void setAddress(ShopAddress address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Shop)) {
            return false;
        }
        Shop thatShop = (Shop) o;
        return Objects.equals(version, thatShop.version) &&
                Objects.equals(name, thatShop.name) &&
                Objects.equals(address, thatShop.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, name, address);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("version", version)
                .append("name", name)
                .append("address", address)
                .toString();
    }
}
