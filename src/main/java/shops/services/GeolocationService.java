package shops.services;

import org.apache.commons.lang3.tuple.Pair;
import shops.models.Shop;
import shops.models.ShopAddress;

import java.util.Map;

/**
 * Created by admin on 26/03/2017.
 */
public interface GeolocationService {

    Pair<Double, Double> getPositionForAddress(ShopAddress address);

    Shop findClosestNeighbour(Map<String, Shop> knownShops, Pair<Double, Double> position);

}
