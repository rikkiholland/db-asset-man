package shops.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 26/03/2017.
 */
@RestController
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "There was an error in the Shops application. Please try again later.";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}