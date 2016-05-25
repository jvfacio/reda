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
public class ServiceDefinition implements Serializable{
    
    private static final long serialVersionUID = 9195542522009357185L;

    private String alias;
    private String client;
    private String operation;

    public String getAlias() {
            return alias;
    }

    public void setAlias(String alias) {
            this.alias = alias;
    }

    public String getClient() {
            return client;
    }

    public void setClient(String client) {
            this.client = client;
    }

    public String getOperation() {
            return operation;
    }

    public void setOperation(String operation) {
            this.operation = operation;
    }
}
