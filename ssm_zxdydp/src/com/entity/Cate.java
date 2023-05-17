// 
// 
// 

package com.entity;

import java.util.ArrayList;
import com.util.VeDate;
import java.util.List;

public class Cate
{
    private String cateid;
    private String catename;
    private String memo;
    private String addtime;
    private List<Film> flimList;
    
    public Cate() {
        this.cateid = "C" + VeDate.getStringId();
        this.flimList = new ArrayList<Film>();
    }
    
    public List<Film> getFlimList() {
        return this.flimList;
    }
    
    public void setFlimList(final List<Film> flimList) {
        this.flimList = flimList;
    }
    
    public String getCateid() {
        return this.cateid;
    }
    
    public void setCateid(final String cateid) {
        this.cateid = cateid;
    }
    
    public String getCatename() {
        return this.catename;
    }
    
    public void setCatename(final String catename) {
        this.catename = catename;
    }
    
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(final String memo) {
        this.memo = memo;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
}
