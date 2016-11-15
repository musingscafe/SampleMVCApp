package com.sampleapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by nrsharma on 15/11/16.
 */
@RestController
public class HomeController {

    @Autowired
    RequestSender requestSender;

    @RequestMapping(value="/sendDataUsingThreadPool", method={RequestMethod.GET, RequestMethod.POST})
    public String sendDataUsingThreadPool() {
            requestSender.sendData();
        return "Success";
    }

    @RequestMapping(value="/sendData", method={RequestMethod.GET, RequestMethod.POST})
    public String sendDataUsingThread() {
        requestSender.sendData();
        return "Success";
    }

}
