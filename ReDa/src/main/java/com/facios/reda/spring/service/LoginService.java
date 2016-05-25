/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.spring.service;

import com.facios.reda.spring.dao.UserDao;
import com.facios.reda.spring.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jvfacio
 */
@Service("LoginService")
@Transactional(readOnly = true)
public class LoginService {
    
    // CustomerDAO is injected...
    @Autowired
    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    
    public boolean validate (String uname, String psw){
        Users user = userDao.getUsersByUserName(uname);
        /**
         * jvfacio 
         * cambiar la implementacion del metodo para validar
         */
        boolean res = false;
        if (user.getPassword().equals(psw)) {
            res = true;
        } 
        
        return res;
    }
    
}
