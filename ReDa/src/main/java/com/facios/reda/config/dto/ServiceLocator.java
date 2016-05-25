/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.config.dto;

import java.io.Serializable;

/**
 *
 * @author jvfacio
 */
public class ServiceLocator implements Serializable {

	private static final long serialVersionUID = -8891885581034997803L;
	
	private String alias;
	private String endpoint;
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getEndpoint() {
		return endpoint;
	}
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
    
}
