// 
// 
// 

package com.entity;

import com.util.VeDate;

public class Article
{
    private String articleid;
    private String title;
    private String image;
    private String contents;
    private String addtime;
    private String hits;
    
    public Article() {
        this.articleid = "A" + VeDate.getStringId();
    }
    
    public String getArticleid() {
        return this.articleid;
    }
    
    public void setArticleid(final String articleid) {
        this.articleid = articleid;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public String getImage() {
        return this.image;
    }
    
    public void setImage(final String image) {
        this.image = image;
    }
    
    public String getContents() {
        return this.contents;
    }
    
    public void setContents(final String contents) {
        this.contents = contents;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
    
    public String getHits() {
        return this.hits;
    }
    
    public void setHits(final String hits) {
        this.hits = hits;
    }
}
