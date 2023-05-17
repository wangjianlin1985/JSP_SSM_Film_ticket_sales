// 
// 
// 

package com.action;

import java.util.ArrayList;
import com.util.PageHelper;
import com.entity.Film;
import com.entity.Cate;
import java.util.List;
import com.service.CateService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.FilmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/film" }, produces = { "text/plain;charset=utf-8" })
public class FilmAction extends BaseAction
{
    @Autowired
    @Resource
    private FilmService filmService;
    @Autowired
    @Resource
    private CateService cateService;
    
    @RequestMapping({ "createFilm.action" })
    public String createFilm() {
        final List<Cate> cateList = this.cateService.getAllCate();
        this.getRequest().setAttribute("cateList", (Object)cateList);
        return "admin/addfilm";
    }
    
    @RequestMapping({ "addFilm.action" })
    public String addFilm(final Film film) {
        film.setHits("0");
        film.setSellnum("0");
        this.filmService.insertFilm(film);
        return "redirect:/film/createFilm.action";
    }
    
    @RequestMapping({ "deleteFilm.action" })
    public String deleteFilm(final String id) {
        this.filmService.deleteFilm(id);
        return "redirect:/film/getAllFilm.action";
    }
    
    @RequestMapping({ "deleteFilmByIds.action" })
    public String deleteFilmByIds() {
        final String[] ids = this.getRequest().getParameterValues("filmid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String filmid = array[i];
            this.filmService.deleteFilm(filmid);
        }
        return "redirect:/film/getAllFilm.action";
    }
    
    @RequestMapping({ "updateFilm.action" })
    public String updateFilm(final Film film) {
        this.filmService.updateFilm(film);
        return "redirect:/film/getAllFilm.action";
    }
    
    @RequestMapping({ "getAllFilm.action" })
    public String getAllFilm(final String number) {
        final List<Film> filmList = this.filmService.getAllFilm();
        PageHelper.getPage(filmList, "film", null, null, 10, number, this.getRequest(), null);
        return "admin/listfilm";
    }
    
    @RequestMapping({ "queryFilmByCond.action" })
    public String queryFilmByCond(String cond, String name, final String number) {
        final Film film = new Film();
        if (cond != null) {
            if ("filmname".equals(cond)) {
                film.setFilmname(name);
            }
            if ("image".equals(cond)) {
                film.setImage(name);
            }
            if ("cateid".equals(cond)) {
                film.setCateid(name);
            }
            if ("price".equals(cond)) {
                film.setPrice(name);
            }
            if ("recommend".equals(cond)) {
                film.setRecommend(name);
            }
            if ("thestart".equals(cond)) {
                film.setThestart(name);
            }
            if ("theend".equals(cond)) {
                film.setTheend(name);
            }
            if ("hits".equals(cond)) {
                film.setHits(name);
            }
            if ("sellnum".equals(cond)) {
                film.setSellnum(name);
            }
            if ("contents".equals(cond)) {
                film.setContents(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.filmService.getFilmByLike(film), "film", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/queryfilm";
    }
    
    @RequestMapping({ "getFilmById.action" })
    public String getFilmById(final String id) {
        final Film film = this.filmService.getFilmById(id);
        this.getRequest().setAttribute("film", (Object)film);
        final List<Cate> cateList = this.cateService.getAllCate();
        this.getRequest().setAttribute("cateList", (Object)cateList);
        return "admin/editfilm";
    }
    
    public FilmService getFilmService() {
        return this.filmService;
    }
    
    public void setFilmService(final FilmService filmService) {
        this.filmService = filmService;
    }
}
