package shops.util;

import org.apache.commons.lang3.tuple.Pair;
import shops.models.Shop;

import java.util.Comparator;

/**
 * Created by admin on 27/03/2017.
 */
public class ShopLocationComparator implements Comparator<Shop> {

    Pair<Double, Double>  location;

    public ShopLocationComparator(Pair<Double, Double> current){
        location = current;
    }

    @Override
    public int compare(final Shop shop1, final Shop shop2) {
        double lat1 = shop1.getAddress().getPosition().getLeft();
        double lng1 = shop1.getAddress().getPosition().getRight();
        double lat2 = shop2.getAddress().getPosition().getLeft();
        double lng2 = shop2.getAddress().getPosition().getRight();

        double distanceToShop1 = distance(location.getLeft(), location.getRight(), lat1, lng1);
        double distanceToShop2 = distance(location.getLeft(), location.getRight(), lat2, lng2);
        return (int) (distanceToShop1 - distanceToShop2);
    }

    public double distance(double fromLat, double fromLng, double toLat, double toLng) {
        double deltaLat = toLat - fromLat;
        double deltaLng = toLng - fromLng;
        // Use Pythagorus as an approximation
        return Math.sqrt(Math.pow(deltaLat, 2) + Math.pow(deltaLng, 2));
    }
}