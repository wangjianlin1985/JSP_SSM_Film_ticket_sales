// 
// 
// 

package com.action;

import java.util.ArrayList;
import java.util.List;
import com.util.PageHelper;
import com.util.VeDate;
import com.entity.Article;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/article" }, produces = { "text/plain;charset=utf-8" })
public class ArticleAction extends BaseAction
{
    @Autowired
    @Resource
    private ArticleService articleService;
    
    @RequestMapping({ "createArticle.action" })
    public String createArticle() {
        return "admin/addarticle";
    }
    
    @RequestMapping({ "addArticle.action" })
    public String addArticle(final Article article) {
        article.setAddtime(VeDate.getStringDateShort());
        article.setHits("0");
        this.articleService.insertArticle(article);
        return "redirect:/article/createArticle.action";
    }
    
    @RequestMapping({ "deleteArticle.action" })
    public String deleteArticle(final String id) {
        this.articleService.deleteArticle(id);
        return "redirect:/article/getAllArticle.action";
    }
    
    @RequestMapping({ "deleteArticleByIds.action" })
    public String deleteArticleByIds() {
        final String[] ids = this.getRequest().getParameterValues("articleid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String articleid = array[i];
            this.articleService.deleteArticle(articleid);
        }
        return "redirect:/article/getAllArticle.action";
    }
    
    @RequestMapping({ "updateArticle.action" })
    public String updateArticle(final Article article) {
        this.articleService.updateArticle(article);
        return "redirect:/article/getAllArticle.action";
    }
    
    @RequestMapping({ "getAllArticle.action" })
    public String getAllArticle(final String number) {
        final List<Article> articleList = this.articleService.getAllArticle();
        PageHelper.getPage(articleList, "article", null, null, 10, number, this.getRequest(), null);
        return "admin/listarticle";
    }
    
    @RequestMapping({ "queryArticleByCond.action" })
    public String queryArticleByCond(String cond, String name, final String number) {
        final Article article = new Article();
        if (cond != null) {
            if ("title".equals(cond)) {
                article.setTitle(name);
            }
            if ("image".equals(cond)) {
                article.setImage(name);
            }
            if ("contents".equals(cond)) {
                article.setContents(name);
            }
            if ("addtime".equals(cond)) {
                article.setAddtime(name);
            }
            if ("hits".equals(cond)) {
                article.setHits(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.articleService.getArticleByLike(article), "article", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/queryarticle";
    }
    
    @RequestMapping({ "getArticleById.action" })
    public String getArticleById(final String id) {
        final Article article = this.articleService.getArticleById(id);
        this.getRequest().setAttribute("article", (Object)article);
        return "admin/editarticle";
    }
    
    public ArticleService getArticleService() {
        return this.articleService;
    }
    
    public void setArticleService(final ArticleService articleService) {
        this.articleService = articleService;
    }
}
