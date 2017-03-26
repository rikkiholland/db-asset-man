package shops.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import shops.models.Shop;
import shops.models.ShopAddress;
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
    public ResponseEntity<Shop> getShop() {
        return new ResponseEntity<>(getTestShop(), HttpStatus.OK);
    }

    @RequestMapping(method=POST)
    public ResponseEntity<Shop> addOrUpdateLocation(@RequestBody Shop shop) {
        System.out.println(">>++>>" + shop.toString());
        return new ResponseEntity<>(locationService.addOrUpdateShop(shop), HttpStatus.OK);
    }

    private Shop getTestShop() {
        Shop testShop = new Shop("MyNewShop");
        ShopAddress address = new ShopAddress();
        address.setStreetNumber("10");
        address.setPostCode("SW1");
        return testShop;
    }

}
