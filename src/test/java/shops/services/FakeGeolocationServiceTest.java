package shops.services;

import org.apache.commons.lang3.tuple.Pair;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 27/03/2017.
 */
public class FakeGeolocationServiceTest {

    FakeGeolocationService service = new FakeGeolocationService();

    @Test
    public void serviceGeneratesPosition() {
        Pair<Double, Double> fakePosition = service.getPositionForAddress(null);
        Assert.assertThat(fakePosition.getLeft(), Matchers.notNullValue());
        Assert.assertThat(fakePosition.getRight(), Matchers.notNullValue());
    }

    @Test
    public void latitudeIsWithinBounds() {
        Pair<Double, Double> fakePosition = service.getPositionForAddress(null);
        Assert.assertThat(fakePosition.getLeft(), Matchers.greaterThanOrEqualTo(FakeGeolocationService.LAT_MIN));
        Assert.assertThat(fakePosition.getLeft(), Matchers.lessThan(FakeGeolocationService.LAT_MAX));
    }

    @Test
    public void longitudeIsWithinBounds() {
        Pair<Double, Double> fakePosition = service.getPositionForAddress(null);
        Assert.assertThat(fakePosition.getRight(), Matchers.greaterThanOrEqualTo(FakeGeolocationService.LONG_MIN));
        Assert.assertThat(fakePosition.getRight(), Matchers.lessThan(FakeGeolocationService.LONG_MAX));
    }

}
