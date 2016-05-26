/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facios.reda.spring.dao;


import com.facios.reda.managedController.CustomerManagedBean;
import com.facios.reda.spring.model.User;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jvfacio
 */
@Repository
public class UserDao {
    private static final Logger log = Logger.getLogger(UserDao.class);
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Get Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Set Hibernate Session Factory
     *
     * @param sessionFactory SessionFactory - Hibernate Session Factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public User getUsersByUserName(String uname){
        
        List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from Users where uname = ? ")
                                            .setParameter(0, uname).list();
        
        return (User)list.get(0);
    }
    
    public User validateUser(String uname, String psw){
        log.debug("Validando Usuario " + uname);
        List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from User where username = ? and password = ?")
                                            .setParameter(0, uname).setParameter(1, psw).list();
        if (list.isEmpty()) {
            return null;
        } else {
            return (User)list.get(0);
        }
    }
    
}
