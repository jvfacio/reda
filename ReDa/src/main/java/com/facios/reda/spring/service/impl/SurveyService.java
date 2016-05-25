/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.spring.service.impl;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.ws.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.glassfish.jersey.client.ClientConfig;

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
    
    public static String API_KEY = "x24ntnw7nyepnrx8m3rgveqf";
    public static String TOKEN = "3tVas2LwmdfVycD6JONXt0Y4XCtSxX1AJy8GW376Ceoj.jRWRsHoMT5tJiGFpW457Bb6-frGstgxCR1SXJzUHA3WCtMcEnlg73z4HwsXJguJlAcqbphPXF9ploZSPrYLTGwOmd8vcNOlWAJ1gq.D8eA5aOl202jW9ojmZ-QnQZv3d90LLghn5BJfr3pGDHSV";
    
    
    public void getSurveys() {
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
            
            
            
    public void getSurveysJersey() {
    
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(getBaseURI());
        
       // target.request().accept(MediaType.APPLICATION_JSON_TYPE).header(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN);
        
       
//       target.request().header(HttpHeaders.AUTHORIZATION, "bearer " + TOKEN)
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
       
       String response = target.request().header(HttpHeaders.AUTHORIZATION, "bearer " + TOKEN)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).get(Response.class).toString();
//       
//        String plainAnswer = 
//            target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
//        String xmlAnswer = 
//            target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
//        
//        String htmlAnswer= 
//            target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);

        System.out.println(response);
//        System.out.println(plainAnswer);
//        System.out.println(xmlAnswer);
//        System.out.println(htmlAnswer);  
    }
    
    private static URI getBaseURI() {
        return UriBuilder.fromUri("https://api.surveymonkey.net/v3/surveys?api_key=" + API_KEY).build();
    }
    
}
