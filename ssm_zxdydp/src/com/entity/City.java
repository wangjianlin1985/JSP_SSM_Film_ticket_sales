// 
// 
// 

package com.entity;

import com.util.VeDate;

public class City
{
    private String cityid;
    private String cityname;
    
    public City() {
        this.cityid = "C" + VeDate.getStringId();
    }
    
    public String getCityid() {
        return this.cityid;
    }
    
    public void setCityid(final String cityid) {
        this.cityid = cityid;
    }
    
    public String getCityname() {
        return this.cityname;
    }
    
    public void setCityname(final String cityname) {
        this.cityname = cityname;
    }
}
