/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.spring.service;


import com.facios.reda.spring.dao.CustomerDAO;
import com.facios.reda.spring.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jvfacio
 */
@Service("CustomerService")
@Transactional(readOnly = true)
public class CustomerService {
    // CustomerDAO is injected...
    @Autowired
    CustomerDAO customerDAO;

    /**
     * Add Customer
     *
     * @param  customer Customer
     */
    @Transactional(readOnly = false)
    public void addCustomer(Customer customer) {
        getCustomerDAO().addCustomer(customer);
    }

    /**
     * Delete Customer
     *
     * @param   customer  Customer
     */
    @Transactional(readOnly = false)
    public void deleteCustomer(Customer customer) {
        getCustomerDAO().deleteCustomer(customer);
    }

    /**
     * Update Customer
     *
     * @param customer  Customer
     */
    @Transactional(readOnly = false)
    public void updateCustomer(Customer customer) {
        getCustomerDAO().updateCustomer(customer);
    }

    /**
     * Get Customer
     *
     * @param  id int Customer Id
     */

    public Customer getCustomerById(int id) {
        return getCustomerDAO().getCustomerById(id);
    }

    /**
     * Get Customer List
     *
     */

    public List<Customer> getCustomers() {
        return getCustomerDAO().getCustomers();
    }

    /**
     * Get Customer DAO
     *
     * @return customerDAO - Customer DAO
     */
    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    /**
     * Set Customer DAO
     *
     * @param  customerDAO - CustomerDAO
     */
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    
    
}
