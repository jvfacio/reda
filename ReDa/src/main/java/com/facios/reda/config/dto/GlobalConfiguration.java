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
public class GlobalConfiguration implements Serializable{
    
    	
	private static final long serialVersionUID = 5804700329117385374L;
	
	private String templateRepository;
	
	private String onixContext;
	
	private String viewerUrl;

	public String getTemplateRepository() {
		return templateRepository;
	}

	public void setTemplateRepository(String templateRepository) {
		this.templateRepository = templateRepository;
	}

	public String getOnixContext() {
		return onixContext;
	}

	public void setOnixContext(String onixContext) {
		this.onixContext = onixContext;
	}

	public String getViewerUrl() {
		return viewerUrl;
	}

	public void setViewerUrl(String viewerUrl) {
		this.viewerUrl = viewerUrl;
	}
}
