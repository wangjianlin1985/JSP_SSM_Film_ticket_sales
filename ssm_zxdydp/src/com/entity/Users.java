// 
// 
// 

package com.entity;

import com.util.VeDate;

public class Users
{
    private String usersid;
    private String username;
    private String password;
    private String realname;
    private String sex;
    private String birthday;
    private String contact;
    private String regdate;
    
    public Users() {
        this.usersid = "U" + VeDate.getStringId();
    }
    
    public String getUsersid() {
        return this.usersid;
    }
    
    public void setUsersid(final String usersid) {
        this.usersid = usersid;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getRealname() {
        return this.realname;
    }
    
    public void setRealname(final String realname) {
        this.realname = realname;
    }
    
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(final String sex) {
        this.sex = sex;
    }
    
    public String getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(final String birthday) {
        this.birthday = birthday;
    }
    
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(final String contact) {
        this.contact = contact;
    }
    
    public String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(final String regdate) {
        this.regdate = regdate;
    }
}
