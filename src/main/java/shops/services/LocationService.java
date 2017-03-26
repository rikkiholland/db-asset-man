package shops.services;

import org.springframework.stereotype.Service;
import shops.models.Shop;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 26/03/2017.
 */
@Service
public class LocationService {

    public Map<String, Shop> knownShops = new HashMap<>();

    public Shop addOrUpdateShop(Shop shop) {
        if (knownShops.containsKey(shop.getName())) {
            return updateShop(shop);
        }
        return addShop(shop);
    }

    public Shop getShop(String shopName) {
        return knownShops.get(shopName);
    }

    protected synchronized Shop addShop(Shop newShop) {
        System.out.println("Adding new shop: " + newShop);
        newShop.setVersion(1);
        return knownShops.put(newShop.getName(), newShop);
    }

    protected synchronized Shop updateShop(Shop newShop) {
        System.out.println("Updating shop: " + newShop);
        String shopName = newShop.getName();
        Shop prevShop = knownShops.get(shopName);
        int newVersion = prevShop.getVersion() + 1;
        newShop.setVersion(newVersion);
        return knownShops.put(shopName, newShop);
    }

}
