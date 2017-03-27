package shops.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by admin on 27/03/2017.
 */
public class ShopAddressTest {

    @Test
    public void equalsAndHashCodeAreImplemented() {
        Pair<Double, Double> p1 = new ImmutablePair<>(-4D, 51D);
        Pair<Double, Double> p2 = new ImmutablePair<>(-2D, 52.5D);
        EqualsVerifier.forClass(ShopAddress.class).withPrefabValues(Pair.class, p1, p2)
                .suppress(Warning.NONFINAL_FIELDS)
                .withIgnoredFields("position")
                .verify();
    }
}
