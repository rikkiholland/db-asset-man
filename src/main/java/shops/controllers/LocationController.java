package shops.controllers;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import shops.models.Shop;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shops.services.LocationService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by admin on 26/03/2017.
 */
@RestController
@RequestMapping(value = "/shops")
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(method=GET)
    public ResponseEntity<Shop> getNearestShop(@RequestBody Pair<Double, Double> location) {
        Shop nearestShop = locationService.getNearestShop(location);
        return new ResponseEntity<>(nearestShop, HttpStatus.OK);
    }

    @RequestMapping(method=POST)
    public ResponseEntity<Shop> addOrUpdateLocation(@RequestBody Shop shop) {
        return new ResponseEntity<>(locationService.addOrUpdateShop(shop), HttpStatus.OK);
    }

}
