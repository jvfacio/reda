/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.spring.service.impl;



import com.facios.reda.managedController.CustomerManagedBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;


//import org.glassfish.jersey.client.ClientConfig;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jvfacio
 */
@Service("SurveyService")
@Transactional(readOnly = true)
public class SurveyService {
    private static final Logger log = Logger.getLogger(SurveyService.class);
    public static String API_KEY = "x24ntnw7nyepnrx8m3rgveqf";
    public static String TOKEN = "3tVas2LwmdfVycD6JONXt0Y4XCtSxX1AJy8GW376Ceoj.jRWRsHoMT5tJiGFpW457Bb6-frGstgxCR1SXJzUHA3WCtMcEnlg73z4HwsXJguJlAcqbphPXF9ploZSPrYLTGwOmd8vcNOlWAJ1gq.D8eA5aOl202jW9ojmZ-QnQZv3d90LLghn5BJfr3pGDHSV";
    
    
    public void getSurveys() {
        log.debug("Get the surveys");
        try {
			
			// create HTTP Client
			         HttpClient httpClient = HttpClientBuilder.create().build();
 
			// Create new getRequest with below mentioned URL
			         HttpGet getRequest = new HttpGet("https://api.surveymonkey.net/v3/surveys?api_key=" + API_KEY);
 
			// Add additional header to getRequest which accepts application/xml data
			getRequest.addHeader("Content-Type", "application/json");
                        getRequest.addHeader("Authorization", "bearer " + TOKEN);
 
			// Execute your request and catch response
			         HttpResponse response = httpClient.execute(getRequest);
 
			// Check for HTTP response code: 200 = success
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
 
			// Get-Capture Complete application/xml body response
			         BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("============Output:============");
 
			// Simply iterate through XML response and show on console.
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
 
		} catch (ClientProtocolException e) {
			e.printStackTrace();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
            
            
            
    
    
    
}
