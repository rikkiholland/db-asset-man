package shops.integration;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import shops.controllers.LocationController;
import shops.models.Shop;
import shops.models.ShopAddress;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

/**
 * Created by admin on 27/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopsIntegrationTest {

    @Autowired
    LocationController locationController;

    @Test
    public void addingAShopReturnsNothing() {
        // Given
        Shop shop = createShop("MyShop", "10", "SW1A 1AA");

        // When
        ResponseEntity<Shop> result = locationController.addOrUpdateLocation(shop);

        // Then
        Assert.assertThat(result.getBody(), nullValue());
        Assert.assertThat(result.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void addingAShopPopulatesTheShopPosition() {
        // Given
        Shop shop = createShop("MyShop", "10", "SW1A 1AA");
        locationController.addOrUpdateLocation(shop);
        Pair<Double, Double> location = new ImmutablePair<>(0D, 0D);

        // When
        ResponseEntity<Shop> result = locationController.getNearestShop(location);

        // Then
        Assert.assertThat(result.getBody(), is(shop));
        Pair<Double, Double> position = result.getBody().getAddress().getPosition();
        Assert.assertThat(position.getLeft(), notNullValue());
        Assert.assertThat(position.getRight(), notNullValue());
        Assert.assertThat(result.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void updatingAShopReturnsTheOldShop() {
        // Given
        Shop shop = createShop("MyShop", "10", "SW1A 1AA");
        locationController.addOrUpdateLocation(shop);
        Shop newShop = createShop("MyShop", "11", "SW1A 1AA");

        // When
        ResponseEntity<Shop> result = locationController.addOrUpdateLocation(newShop);

        // Then
        Assert.assertThat(result.getBody(), is(shop));
        Assert.assertThat(result.getStatusCode(), is(HttpStatus.OK));

    }

    private Shop createShop(String name, String streetNumber, String postCode) {
        Shop shop = new Shop(name);
        ShopAddress address = new ShopAddress(streetNumber, postCode);
        shop.setAddress(address);
        return shop;
    }
}
