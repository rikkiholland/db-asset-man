package shops.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import shops.models.Shop;
import shops.models.ShopAddress;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by admin on 27/03/2017.
 */
public class LocationServiceTest {

    Shop shop1;
    Shop shop2;

    @Mock
    GeolocationService geoLocationService;

    @InjectMocks
    LocationService locationService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addingNewShopGetsLatitudeAndLongitudeAndReturnsNull() {
        // Given
        shop1 = new Shop("Shop1");
        ShopAddress address1 = new ShopAddress("25", "SW1A 1AA");
        Pair<Double, Double> position1 = new ImmutablePair<>(52.5, -2.5);
        address1.setPosition(position1);
        shop1.setAddress(address1);
        given(geoLocationService.getPositionForAddress(address1)).willReturn(position1);

        // When
        Shop result = locationService.addOrUpdateShop(shop1);

        // Then
        verify(geoLocationService).getPositionForAddress(address1);
        Assert.assertThat(result, Matchers.nullValue());
    }

    @Test
    public void updatingShopDoesNotCallGeolocationServiceAndReturnsOldShop() {
        // Given
        shop1 = new Shop("Shop1");
        ShopAddress address1 = new ShopAddress("25", "SW1A 1AA");
        Pair<Double, Double> position1 = new ImmutablePair<>(52.5, -2.5);
        address1.setPosition(position1);
        shop1.setAddress(address1);
        given(geoLocationService.getPositionForAddress(address1)).willReturn(position1);
        locationService.addOrUpdateShop(shop1);

        shop2 = new Shop("Shop1");
        shop2.setAddress(new ShopAddress("27", "SW1A 1AA"));

        // When
        Shop result = locationService.addOrUpdateShop(shop2);

        // Then
        verify(geoLocationService).getPositionForAddress(address1);
        verifyNoMoreInteractions(geoLocationService);
        Assert.assertThat(result, Matchers.is(shop1));
    }

}
