// 
// 
// 

package com.entity;

import com.util.VeDate;

public class Cinema
{
    private String cinemaid;
    private String cinemaname;
    private String cityid;
    private String address;
    private String contact;
    private String memo;
    private String cityname;
    
    public Cinema() {
        this.cinemaid = "C" + VeDate.getStringId();
    }
    
    public String getCinemaid() {
        return this.cinemaid;
    }
    
    public void setCinemaid(final String cinemaid) {
        this.cinemaid = cinemaid;
    }
    
    public String getCinemaname() {
        return this.cinemaname;
    }
    
    public void setCinemaname(final String cinemaname) {
        this.cinemaname = cinemaname;
    }
    
    public String getCityid() {
        return this.cityid;
    }
    
    public void setCityid(final String cityid) {
        this.cityid = cityid;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(final String contact) {
        this.contact = contact;
    }
    
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(final String memo) {
        this.memo = memo;
    }
    
    public String getCityname() {
        return this.cityname;
    }
    
    public void setCityname(final String cityname) {
        this.cityname = cityname;
    }
}
