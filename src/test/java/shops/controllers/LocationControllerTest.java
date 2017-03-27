package shops.controllers;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import shops.models.Shop;
import shops.services.LocationService;

import static org.mockito.BDDMockito.given;

/**
 * Created by admin on 27/03/2017.
 */
public class LocationControllerTest {

    @Mock
    LocationService locationService;

    @InjectMocks
    LocationController locationController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addingAShopReturnsNull() {
        // Given
        Shop testShop = new Shop("MyShop");
        given(locationService.addOrUpdateShop(testShop)).willReturn(null);

        // When
        ResponseEntity<Shop> response = locationController.addOrUpdateLocation(new Shop());

        // Then
        Assert.assertThat(response.getBody(), Matchers.nullValue());
        Assert.assertThat(response.getStatusCode(), Matchers.is(HttpStatus.OK));
    }

    @Test
    public void updatingAShopReturnsPreviousVersion() {
        // Given
        Shop testShop1 = new Shop("MyOldShop");
        Shop testShop2 = new Shop("MyNewShop");
        given(locationService.addOrUpdateShop(testShop1)).willReturn(null);
        given(locationService.addOrUpdateShop(testShop2)).willReturn(testShop1);

        // When
        ResponseEntity<Shop> response = locationController.addOrUpdateLocation(testShop2);

        // Then
        Assert.assertThat(response.getBody(), Matchers.is(testShop1));
        Assert.assertThat(response.getStatusCode(), Matchers.is(HttpStatus.OK));
    }

    @Test
    public void getNearestShopReturnsShop() {
        // Given
        Shop testShop = new Shop("MyShop");
        Pair<Double, Double> location = new ImmutablePair<>(52.5, 0.00);
        given(locationService.getNearestShop(location)).willReturn(testShop);

        // When
        ResponseEntity<Shop> response = locationController.getNearestShop(location);

        // Then
        Assert.assertThat(response.getBody(), Matchers.is(testShop));
        Assert.assertThat(response.getStatusCode(), Matchers.is(HttpStatus.OK));
    }

    @Test
    public void getNearestShopReturnsNullForNullLocation() {
        // Given
        given(locationService.getNearestShop(null)).willReturn(null);

        // When
        ResponseEntity<Shop> response = locationController.getNearestShop(null);

        // Then
        Assert.assertThat(response.getBody(), Matchers.nullValue());
        Assert.assertThat(response.getStatusCode(), Matchers.is(HttpStatus.OK));
    }


}
