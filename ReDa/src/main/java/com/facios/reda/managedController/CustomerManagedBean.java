/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.managedController;


import com.facios.reda.config.LoadConfiguration;
import com.facios.reda.config.dto.ServiceDefinition;
import com.facios.reda.spring.model.Customer;
import com.facios.reda.spring.service.CustomerService;
import com.facios.reda.spring.service.impl.SurveyService;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author jvfacio
 */
@ManagedBean(name="customerMB")
@RequestScoped
public class CustomerManagedBean implements Serializable {
    
    private static final Logger log = Logger.getLogger(CustomerManagedBean.class);
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "Success";
    private static final String ERROR   = "error";

    //Spring Customer Service is injected...
    @ManagedProperty(value="#{CustomerService}")
    CustomerService customerService;
    
    //Spring surveyService Service is injected...
    @ManagedProperty(value="#{SurveyService}")
    SurveyService surveyService;

    List<Customer> customerList;

    private int id;
    private String name;
    private String surname;

    public SurveyService getSurveyService() {
        return surveyService;
    }

    public void setSurveyService(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    
    
    /**
     * Add Customer
     *
     * @return String - Response Message
     */
    public String addCustomer() {
        try {
            Customer customer = new Customer();
            customer.setId(getId());
            customer.setName(getName());
            customer.setSurname(getSurname());
            getCustomerService().addCustomer(customer);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    /**
     * Reset Fields
     *
     */
    public void reset() {
        this.setId(0);
        this.setName("");
        this.setSurname("");
    }

    /**
     * Get Customer List
     *
     * @return List - Customer List
     */
    public List<Customer> getCustomerList() {
        log.debug("get the customer List");
        
        surveyService.getSurveys();
        
        customerList = new ArrayList<Customer>();
        customerList.addAll(getCustomerService().getCustomers());
        return customerList;
    }

    /**
     * Get Customer Service
     *
     * @return ICustomerService - Customer Service
     */
    public CustomerService getCustomerService() {
        return customerService;
    }

    /**
     * Set Customer Service
     *
     * @param customerService ICustomerService - Customer Service
     */
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Set Customer List
     *
     * @param customerList List - Customer List
     */
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    /**
     * Get Customer Id
     *
     * @return int - Customer Id
     */
    public int getId() {
        return id;
    }

    /**
     * Set Customer Id
     *
     * @param id int - Customer Id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get Customer Name
     *
     * @return String - Customer Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Customer Name
     *
     * @param name String - Customer Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Customer Surname
     *
     * @return String - Customer Surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set Customer Surname
     *
     * @param surname String - Customer Surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
