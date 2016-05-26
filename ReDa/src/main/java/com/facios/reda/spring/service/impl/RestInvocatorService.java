/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.spring.service.impl;

import com.facios.reda.config.LoadConfiguration;
import com.facios.reda.config.dto.ServiceDefinition;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

/**
 *
 * @author jvfacio
 */
public class RestInvocatorService {
    
    
    public void invoke(){
        try {
        /**
         * mandar llamar la invoacion a surveymokey 
         * 
         **/
        LoadConfiguration configuration = LoadConfiguration.getConfigurador();
        ServiceDefinition service = configuration.getServiceDefinition("READ_PROPOSAL");
        
        if (service != null) {
                Class<?> clazz = Class.forName(service.getClient());
                Constructor<?> cons = clazz.getConstructor(String.class);
                Object object = cons.newInstance();
                Method method = clazz.getDeclaredMethod(service.getOperation(), String.class);	
                //Response response = (Response) method.invoke(object, message);
                //return Response.status(200).type(MediaType.TEXT_PLAIN).entity(response.readEntity(String.class)).build();
        } else {
                //return Response.status(404).type(MediaType.TEXT_PLAIN).entity("{\"error\":\"Service not found\"}").build();
        }
        } catch(Exception e) {
            StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			//LOGGER.log(Level.SEVERE, sw.toString());
			//return Response.status(500).type(MediaType.TEXT_PLAIN).entity("{\"exeption\":\"Exception found while invoking service: " + e.getCause() + "\"}").build();
            
        }
    }
}
