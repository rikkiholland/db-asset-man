package shops.models;

/**
 * Created by admin on 26/03/2017.
 */
public class AbstractVersionedEntity {

    protected int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
