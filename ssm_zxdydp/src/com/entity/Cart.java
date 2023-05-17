// 
// 
// 

package com.entity;

import com.util.VeDate;

public class Cart
{
    private String cartid;
    private String usersid;
    private String filmid;
    private String num;
    private String price;
    private String username;
    private String filmname;
    private String image;
    
    public Cart() {
        this.cartid = "C" + VeDate.getStringId();
    }
    
    public String getImage() {
        return this.image;
    }
    
    public void setImage(final String image) {
        this.image = image;
    }
    
    public String getCartid() {
        return this.cartid;
    }
    
    public void setCartid(final String cartid) {
        this.cartid = cartid;
    }
    
    public String getUsersid() {
        return this.usersid;
    }
    
    public void setUsersid(final String usersid) {
        this.usersid = usersid;
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
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getFilmname() {
        return this.filmname;
    }
    
    public void setFilmname(final String filmname) {
        this.filmname = filmname;
    }
}
