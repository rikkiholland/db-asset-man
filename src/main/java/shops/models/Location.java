package shops.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by admin on 26/03/2017.
 */
public class Location {

    @JsonIgnore
    protected Pair<Double, Double> position;

    public Location() { }

    public Location(Double lat, Double lng) {
        this.position = new ImmutablePair<>(lat, lng);
    }

    public Pair<Double, Double> getPosition() {
        return position;
    }

    public void setPosition(Pair<Double, Double> position) {
        this.position = position;
    }
}
