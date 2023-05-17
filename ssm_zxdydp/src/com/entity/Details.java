// 
// 
// 

package com.entity;

import com.util.VeDate;

public class Details
{
    private String detailsid;
    private String ordercode;
    private String filmid;
    private String num;
    private String price;
    private String cityid;
    private String cinemaid;
    private String viewdate;
    private String filmname;
    private String cityname;
    private String cinemaname;
    
    public Details() {
        this.detailsid = "D" + VeDate.getStringId();
    }
    
    public String getDetailsid() {
        return this.detailsid;
    }
    
    public void setDetailsid(final String detailsid) {
        this.detailsid = detailsid;
    }
    
    public String getOrdercode() {
        return this.ordercode;
    }
    
    public void setOrdercode(final String ordercode) {
        this.ordercode = ordercode;
    }
    
    public String getFilmid() {
        return this.filmid;
    }
    
    public void setFilmid(final String filmid) {
        this.filmid = filmid;
    }
    
    public String getNum() {
        return this.num;
    }
    
    public void setNum(final String num) {
        this.num = num;
    }
    
    public String getPrice() {
        return this.price;
    }
    
    public void setPrice(final String price) {
        this.price = price;
    }
    
    public String getCityid() {
        return this.cityid;
    }
    
    public void setCityid(final String cityid) {
        this.cityid = cityid;
    }
    
    public String getCinemaid() {
        return this.cinemaid;
    }
    
    public void setCinemaid(final String cinemaid) {
        this.cinemaid = cinemaid;
    }
    
    public String getViewdate() {
        return this.viewdate;
    }
    
    public void setViewdate(final String viewdate) {
        this.viewdate = viewdate;
    }
    
    public String getFilmname() {
        return this.filmname;
    }
    
    public void setFilmname(final String filmname) {
        this.filmname = filmname;
    }
    
    public String getCityname() {
        return this.cityname;
    }
    
    public void setCityname(final String cityname) {
        this.cityname = cityname;
    }
    
    public String getCinemaname() {
        return this.cinemaname;
    }
    
    public void setCinemaname(final String cinemaname) {
        this.cinemaname = cinemaname;
    }
}
