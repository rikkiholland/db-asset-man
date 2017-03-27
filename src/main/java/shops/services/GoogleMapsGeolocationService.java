package shops.services;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shops.models.Shop;
import shops.models.ShopAddress;
import shops.models.google.GoogleGeocodingReponse;

import java.util.Map;

/**
 * Created by admin on 26/03/2017.
 */
//@Service
public class GoogleMapsGeolocationService implements GeolocationService {

    private static final String GOOGLE_MAPS_URI = "https://maps.googleapis.com/maps/api/geocode/json?" +
            "address={address}&key={apiKey}";

    private RestTemplate template = new RestTemplate();

    @Value("#{environment['shops.services.google.apikey']}")
    private String apiKey;

    @Override
    public Pair<Double, Double> getPositionForAddress(ShopAddress address) {
        GoogleGeocodingReponse response = template.getForObject(GOOGLE_MAPS_URI,
                                                                GoogleGeocodingReponse.class,
                                                                address.getPostCode(),
                                                                apiKey);
        return getPositionFromGeocoding(response);
    }

    @Override
    public Shop findClosestNeighbour(Map<String, Shop> knownShops, Pair<Double, Double> position) {
        // Not implemented
        return null;
    }

    private Pair<Double, Double> getPositionFromGeocoding(GoogleGeocodingReponse response) {
        return response.getAddressResults()[0].getGeometry().getLocation().getPosition();
    }
}
