package shops.util;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shops.models.Shop;
import shops.models.ShopAddress;

import java.util.*;

/**
 * Created by admin on 27/03/2017.
 */
public class ShopLocationComparatorTest {

    List<Shop> shops = new ArrayList<>();

    // Trafalgar Square
    Pair<Double, Double> testLocation = new ImmutablePair(51.507962, -0.127836);

    // Slough
    Shop shop1;
    Pair<Double, Double> testPosition1 = new ImmutablePair(51.5105, -0.5950);
    // Bristol
    Shop shop2;
    Pair<Double, Double> testPosition2 = new ImmutablePair(51.4545, -2.5879);
    // Newcastle
    Shop shop3;
    Pair<Double, Double> testPosition3 = new ImmutablePair(54.9783, -1.6178);
    // Edinburgh
    Shop shop4;
    Pair<Double, Double> testPosition4 = new ImmutablePair(55.9533, -3.1883);

    @Before
    public void setUp() {
        shop1 = createShop("Shop1", testPosition1);
        shop2 = createShop("Shop2", testPosition2);
        shop3 = createShop("Shop3", testPosition3);
        shop4 = createShop("Shop4", testPosition4);
        shops.addAll(Arrays.asList(shop3, shop4, shop1, shop2));
    }

    @Test
    public void comparatorReturnsCorrectlySortedList() {
        ShopLocationComparator shopComparator = new ShopLocationComparator(testLocation);
        Collections.sort(shops, shopComparator);
        Assert.assertThat(shops, Matchers.contains(shop1, shop2, shop3, shop4));
    }

    private Shop createShop(String name, Pair<Double, Double> position) {
        Shop shop = new Shop(name);
        shop.setAddress(new ShopAddress());
        shop.getAddress().setPosition(position);
        return shop;
    }
}
