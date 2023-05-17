// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Article;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.ArticleDAO;
import org.springframework.stereotype.Service;
import com.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService
{
    @Autowired
    @Resource
    private ArticleDAO articleDAO;
    
    @Override
    public int insertArticle(final Article article) {
        return this.articleDAO.insertArticle(article);
    }
    
    @Override
    public int updateArticle(final Article article) {
        return this.articleDAO.updateArticle(article);
    }
    
    @Override
    public int deleteArticle(final String articleid) {
        return this.articleDAO.deleteArticle(articleid);
    }
    
    @Override
    public List<Article> getAllArticle() {
        return this.articleDAO.getAllArticle();
    }
    
    @Override
    public List<Article> getArticleByCond(final Article article) {
        return this.articleDAO.getArticleByCond(article);
    }
    
    @Override
    public List<Article> getArticleByLike(final Article article) {
        return this.articleDAO.getArticleByLike(article);
    }
    
    @Override
    public Article getArticleById(final String articleid) {
        return this.articleDAO.getArticleById(articleid);
    }
}
