/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.managedController;

import com.facios.reda.spring.model.Customer;
import com.facios.reda.spring.service.CustomerService;
import com.facios.reda.spring.service.impl.SurveyService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jvfacio
 */
@ManagedBean(name="surveyMB")
@RequestScoped
public class SurveyManagedBean implements Serializable {
    private static final String SUCCESS = "Success";
    private static final String ERROR   = "error";

    //Spring Customer Service is injected...
    @ManagedProperty(value="#{SurveyService}")
    SurveyService surveyService;

    public SurveyService getSurveyService() {
        return surveyService;
    }

    public void setSurveyService(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
    

    public void getSurveys() {
        getSurveyService().getSurveys();
    }
    
}
