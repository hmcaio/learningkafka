package chm.cookieproducerservice.controller;

import chm.cookieproducerservice.model.CookieOrder;
import chm.cookieproducerservice.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {

    @Autowired
    private CookieService cookieService;


    @PostMapping(path="/cookie-request")
    public void receiveCookieRequest(@RequestBody CookieOrder cookieOrder) {
        System.out.println("Received post request: " + cookieOrder);
        cookieService.sendToKafka(cookieOrder);
    }
}
