// 
// 
// 

package com.entity;

import com.util.VeDate;

public class Admin
{
    private String adminid;
    private String username;
    private String password;
    private String realname;
    private String contact;
    private String addtime;
    
    public Admin() {
        this.adminid = "A" + VeDate.getStringId();
    }
    
    public String getAdminid() {
        return this.adminid;
    }
    
    public void setAdminid(final String adminid) {
        this.adminid = adminid;
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
    
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(final String contact) {
        this.contact = contact;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
}
