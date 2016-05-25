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
public class ScreenConfiguration implements Serializable{
    
    private static final long serialVersionUID = -8979369726816881105L;
	
	private String projectId;
	private String implementation;
	private String frontId;
	private String name;
	private String template;
	private String dataService;
	
	public String getProjectId() {
		return projectId;
	}
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getImplementation() {
		return implementation;
	}
	
	public void setImplementation(String implementation) {
		this.implementation = implementation;
	}
	
	public String getFrontId() {
		return frontId;
	}
	
	public void setFrontId(String frontId) {
		this.frontId = frontId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTemplate() {
		return template;
	}
	
	public void setTemplate(String template) {
		this.template = template;
	}
	
	public String getDataService() {
		return dataService;
	}
	
	public void setDataService(String dataService) {
		this.dataService = dataService;
	}
}
