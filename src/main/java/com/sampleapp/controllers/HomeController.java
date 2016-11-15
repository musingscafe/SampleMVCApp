package com.sampleapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by nrsharma on 15/11/16.
 */
@RestController
public class HomeController {

    @RequestMapping(value="/sendDataUsingThreadPool", method={RequestMethod.GET, RequestMethod.POST})
    public String sendDataUsingThreadPool() {

        return "welcome";
    }

    @RequestMapping(value="/sendData", method={RequestMethod.GET, RequestMethod.POST})
    public String sendDataUsingThread() {

        return "welcome";
    }

}
