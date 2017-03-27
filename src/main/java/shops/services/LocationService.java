package shops.services;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shops.models.Shop;
import shops.models.ShopAddress;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 26/03/2017.
 */
@Service
public class LocationService {

    private static final Logger LOG = LoggerFactory.getLogger(LocationService.class);

    @Autowired
    private GeolocationService geolocationService;

    private Map<String, Shop> knownShops = new HashMap<>();

    public Shop addOrUpdateShop(Shop shop) {
        if (knownShops.containsKey(shop.getName())) {
            return updateShop(shop);
        }
        return addShop(shop);
    }

    public Shop getNearestShop(Pair<Double, Double> location) {
        return geolocationService.findClosestNeighbour(knownShops, location);
    }

    protected synchronized Shop addShop(Shop newShop) {
        newShop.setVersion(1);
        injectPosition(newShop);
        LOG.info("Adding new shop: " + newShop);
        return knownShops.put(newShop.getName(), newShop);
    }

    protected synchronized Shop updateShop(Shop newShop) {
        String shopName = newShop.getName();
        Shop prevShop = knownShops.get(shopName);
        int newVersion = prevShop.getVersion() + 1;
        newShop.setVersion(newVersion);
        newShop.getAddress().setPosition(prevShop.getAddress().getPosition());
        LOG.info("Updating shop: " + newShop);
        return knownShops.put(shopName, newShop);
    }

    private void injectPosition(Shop newShop) {
        ShopAddress address = newShop.getAddress();
        Pair<Double, Double> position = geolocationService.getPositionForAddress(address);
        address.setPosition(position);
    }

}
