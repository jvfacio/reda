package com.facios.reda.spring.model;
// Generated May 23, 2016 8:27:20 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Users")
public class Users {


     private Integer uid;
     private String uname;
     private String password;

   
   
    @Id
    @Column(name="UID")
    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    @Column(name="UNAME")
    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }
    
    @Column(name="PASSWORD")
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}


