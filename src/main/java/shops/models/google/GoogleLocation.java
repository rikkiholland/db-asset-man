package shops.models.google;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by admin on 26/03/2017.
 */
public class GoogleLocation {

    private Double lat;
    private Double lng;

    public Pair<Double, Double> getPosition() {
        return new ImmutablePair<>(lat, lng);
    }

}
