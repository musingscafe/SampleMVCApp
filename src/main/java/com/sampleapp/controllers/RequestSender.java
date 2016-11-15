package com.sampleapp.controllers;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;


/**
 * Created by nrsharma on 15/11/16.
 */
@Component
public class RequestSender {

    private String SERVER_URL= "http://amit-mac:8000/rest";

    public void sendData(){
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        try {
            // Start the client
            httpclient.start();

            // Execute request
            final HttpGet request1 = new HttpGet(SERVER_URL);
            httpclient.execute(request1, null);
            Future<HttpResponse> future = httpclient.execute(request1, null);
            // and wait until a response is received
            HttpResponse response1 = future.get();
            System.out.println(request1.getRequestLine() + "->" + response1.getStatusLine());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
