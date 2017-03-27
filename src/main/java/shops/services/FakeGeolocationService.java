package shops.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;
import shops.models.Shop;
import shops.models.ShopAddress;
import shops.util.ShopLocationComparator;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by admin on 27/03/2017.
 */
@Service
public class FakeGeolocationService implements GeolocationService  {

    protected static final Double LAT_MIN = 50D;
    protected static final Double LAT_MAX = 60D;
    protected static final Double LONG_MIN = -6D;
    protected static final Double LONG_MAX = 2D;

    @Override
    public Pair<Double, Double> getPositionForAddress(ShopAddress address) {
        return generateFakePosition();
    }

    private Pair<Double, Double> generateFakePosition() {
        double fakeLat = ThreadLocalRandom.current().nextDouble(LAT_MIN, LAT_MAX);
        double fakeLong = ThreadLocalRandom.current().nextDouble(LONG_MIN, LONG_MAX);
        return new ImmutablePair<>(fakeLat, fakeLong);
    }

    @Override
    public Shop findClosestNeighbour(Map<String, Shop> knownShops, Pair<Double, Double> position) {
        if (knownShops.isEmpty()) {
            return null;
        }
        List<Shop> shops = new ArrayList(knownShops.values());
        Collections.sort(shops, new ShopLocationComparator(position));
        return shops.get(0);
    }


}
