/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.config;

import com.facios.reda.config.dto.GlobalConfiguration;
import com.facios.reda.config.dto.ScreenConfiguration;
import com.facios.reda.config.dto.ServiceDefinition;
import com.facios.reda.config.dto.ServiceLocator;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author jvfacio
 */
//@Repository
//@SpringBootApplication
public class LoadConfiguration {
    
    private static LoadConfiguration configurator;
	
    private static String path;
    private static Document document;
	
	static {
		          Properties prop = new Properties();
		try {
			prop.load(LoadConfiguration.class.getResourceAsStream("/reda.properties"));
			path = prop.getProperty("redaConfigPath");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static LoadConfiguration getConfigurador() {
            if (configurator == null) {
                    configurator = new LoadConfiguration();
            }
            return configurator;
	}
	 
	private LoadConfiguration() {
		loadConfig();
	}
	
	private void loadConfig() {
		try {
                    File fXmlFile = new File(LoadConfiguration.path);
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			LoadConfiguration.document = dBuilder.parse(fXmlFile);
			LoadConfiguration.document.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@CachePut(value="globalConfig")
	public GlobalConfiguration getGlobalConfiguration() {
		GlobalConfiguration configuration = new GlobalConfiguration();
		try {			
			                 XPathExpression xpath = XPathFactory.newInstance().newXPath().compile("//global");
			                 Node resultNode = (Node) xpath.evaluate(document, XPathConstants.NODE);
			                 Element eElement = (Element) resultNode;
			
			configuration.setTemplateRepository(eElement.getElementsByTagName("template-repository").item(0).getTextContent());
			configuration.setOnixContext(eElement.getElementsByTagName("onix-context").item(0).getTextContent());
			configuration.setViewerUrl(eElement.getElementsByTagName("viewer-url").item(0).getTextContent());
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		
		return configuration;
	}
	
	@CachePut(value="serviceLocator", key="#alias")
	public ServiceLocator getServiceLocator(String alias) {
		ServiceLocator locator = new ServiceLocator();
		try {
			XPathExpression xpath = XPathFactory.newInstance().newXPath().compile("//service-locator[service-alias='" + alias + "']");
			Node resultNode = (Node) xpath.evaluate(document, XPathConstants.NODE);
			Element eElement = (Element) resultNode;
			
			locator.setAlias(eElement.getElementsByTagName("service-alias").item(0).getTextContent());
			locator.setEndpoint(eElement.getElementsByTagName("service-endpoint").item(0).getTextContent());
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		
		return locator;
	}
	
	@CachePut(value="serviceDefinition", key="#alias")
	public ServiceDefinition getServiceDefinition(String alias) {
		ServiceDefinition definition = new ServiceDefinition();
		try {
			XPathExpression xpath = XPathFactory.newInstance().newXPath().compile("//service-definition[service-alias='" + alias + "']");
			Node resultNode = (Node) xpath.evaluate(document, XPathConstants.NODE);
			Element eElement = (Element) resultNode;
			
			definition.setAlias(eElement.getElementsByTagName("service-alias").item(0).getTextContent());
			definition.setClient(eElement.getElementsByTagName("service-client").item(0).getTextContent());
			definition.setOperation(eElement.getElementsByTagName("service-operation").item(0).getTextContent());
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		
		return definition;
	}
	
	@CachePut(value="screenLayout", key="#implementation")
	public ScreenConfiguration getScreenLayout(String implementation) {
		ScreenConfiguration screen = null;
		try {
			XPathExpression xpath = XPathFactory.newInstance().newXPath().compile("//screen[@implementation='" + implementation + "']");
			Node resultNode = (Node) xpath.evaluate(document, XPathConstants.NODE);
			Element eElement = (Element) resultNode;
			
			if (eElement != null) {
				screen = new ScreenConfiguration();
				
				screen.setProjectId(eElement.getAttribute("projectId"));
				screen.setImplementation(eElement.getAttribute("implementation"));
				screen.setFrontId(eElement.getAttribute("frontId"));
				screen.setName(eElement.getElementsByTagName("screen-name").item(0).getTextContent());
				screen.setTemplate(eElement.getElementsByTagName("screen-template").item(0).getTextContent());
				screen.setDataService(eElement.getElementsByTagName("screen-data-service").item(0).getTextContent());
			} else {
				throw new RuntimeException("Not element found for :" + implementation);
			}
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		
		return screen;
	}
}
