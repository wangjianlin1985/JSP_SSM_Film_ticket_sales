// 
// 
// 

package com.entity;

import com.util.VeDate;

public class Orders
{
    private String ordersid;
    private String ordercode;
    private String usersid;
    private String total;
    private String status;
    private String addtime;
    private String username;
    
    public Orders() {
        this.ordersid = "O" + VeDate.getStringId();
    }
    
    public String getOrdersid() {
        return this.ordersid;
    }
    
    public void setOrdersid(final String ordersid) {
        this.ordersid = ordersid;
    }
    
    public String getOrdercode() {
        return this.ordercode;
    }
    
    public void setOrdercode(final String ordercode) {
        this.ordercode = ordercode;
    }
    
    public String getUsersid() {
        return this.usersid;
    }
    
    public void setUsersid(final String usersid) {
        this.usersid = usersid;
    }
    
    public String getTotal() {
        return this.total;
    }
    
    public void setTotal(final String total) {
        this.total = total;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
}
