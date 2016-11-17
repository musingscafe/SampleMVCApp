package com.sampleapp.controllers;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;


/**
 * Created by nrsharma on 15/11/16.
 */
public class RequestSender implements Runnable{

    private String SERVER_URL= "http://localhost:8000/rest";
    int numOfRequest = 1;

	@Override
	public void run() {
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
            System.out.println("Request num : " + numOfRequest + " " +request1.getRequestLine() + "->" + response1.getStatusLine());
            numOfRequest ++;
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
