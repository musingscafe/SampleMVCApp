package com.sampleapp.controllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by nrsharma on 15/11/16.
 */
@RestController
public class HomeController {

    final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @RequestMapping(value="/sendDataUsingThreadPool", method={RequestMethod.GET, RequestMethod.POST})
    public String sendDataUsingThreadPool() {
    	forwardRequestWithThreadPool();
        return "Success";
    }

    @RequestMapping(value="/sendData", method={RequestMethod.GET, RequestMethod.POST})
    public String sendDataUsingThread() {
    	forwardRequest();
        return "Success";
    }
    
    private void forwardRequestWithThreadPool(){
    	executorService.execute(new RequestSender());
    }
    
    private void forwardRequest(){
    	new RequestSender().run();
    }

}
