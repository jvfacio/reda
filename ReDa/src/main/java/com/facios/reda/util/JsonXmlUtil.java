/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;



/**
 *
 * @author jvfacio
 */
public class JsonXmlUtil {
    
    //private static final Logger LOGGER = LoggerFactory.getLogger(JsonXmlUtil.class);
	
	public static JSONObject jsonStringToJsonObject(String parentElement, String json) {
		JSONObject objectJSON = new JSONObject();
		return objectJSON.put(parentElement, (new JSONObject(json)));
	}
	
	public static JSONObject jsonStringToJsonObject(String json) {
		return new JSONObject(json);
	}
	
	public static String jsonToXml(JSONObject objectJSON) {
		return org.json.XML.toString(objectJSON);
	}
	
//	public static Node stringToElement(String xml) throws ParserConfigurationException, SAXException, IOException {
//		          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
//            DocumentBuilder builder;  
//        try {  
//            builder = factory.newDocumentBuilder();  
//            Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()), "UTF-8"); 
//            return doc.getDocumentElement();
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } 
//        return null;
//	}
	
	public static String documentToString(Document doc) throws TransformerFactoryConfigurationError, TransformerException {
		          StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        transformer.transform(new DOMSource(doc), new StreamResult(sw));
        return sw.toString();
	}
	
//	public static String transformXmtWithXslt(Source xml, Source xsl) throws TransformerException {
//		TransformerFactory factory = TransformerFactory.newInstance();
//		StringWriter writer = new StringWriter();
//		StreamResult result = new StreamResult(writer);
//		
//		try {
//		      Templates template = factory.newTemplates(xsl);
//		      Transformer transformer = template.newTransformer();
//		      transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//		      transformer.transform(xml, result);
//		      
//		      return writer.toString();
//	    } catch(TransformerConfigurationException tce) {
//	        throw new TransformerException(tce.getMessageAndLocation());
//	    } catch (TransformerException te) {
//	      throw new TransformerException(te.getMessageAndLocation());
//	    }
//	}
//	
//	public static String getResponseHandleIBMJDKIssue(Response response) {
//		String webResource = null;
//		try {
//			if (response instanceof org.apache.cxf.jaxrs.impl.ResponseImpl) {
//				webResource = ((org.apache.cxf.jaxrs.impl.ResponseImpl) response).readEntity(String.class);
//			} else {
//				webResource = response.readEntity(String.class);
//			}
//		} catch (Throwable e) {
//			LOGGER.trace("IBM JDK ISSUE: will try to call 'readEntity' via reflection", e);
//		}
//
//		if (webResource == null) {
//			try {
//				if (response.getClass().getDeclaredMethods()[31].getName().equals("readEntity")) {
//					webResource = (String) response.getClass().getDeclaredMethods()[31].invoke(response, String.class);
//				}
//
//				if (webResource == null) {
//					Method[] declaredMethods = response.getClass().getDeclaredMethods();
//					for (Method method : declaredMethods) {
//						if (method.getName().equals("readEntity")) {
//							webResource = (String) method.invoke(response, String.class);
//						}
//					}
//				}
//			} catch (Throwable e) {
//				//LOGGER.error("IBM JDK ISSUE: tried to call 'readEntity' via reflection, didnt work.", e);
//			}
//		}
//		return webResource;
//	}
}
