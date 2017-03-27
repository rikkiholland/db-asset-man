package shops.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

/**
 * Created by admin on 27/03/2017.
 */
public class ShopTest {

    @Test
    public void equalsAndHashCodeAreImplemented() {
        EqualsVerifier.forClass(Shop.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

}
