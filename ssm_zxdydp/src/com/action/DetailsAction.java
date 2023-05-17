// 
// 
// 

package com.action;

import java.util.ArrayList;
import com.util.PageHelper;
import com.entity.Details;
import com.entity.Cinema;
import com.entity.City;
import com.entity.Film;
import java.util.List;
import com.service.CinemaService;
import com.service.CityService;
import com.service.FilmService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.DetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/details" }, produces = { "text/plain;charset=utf-8" })
public class DetailsAction extends BaseAction
{
    @Autowired
    @Resource
    private DetailsService detailsService;
    @Autowired
    @Resource
    private FilmService filmService;
    @Autowired
    @Resource
    private CityService cityService;
    @Autowired
    @Resource
    private CinemaService cinemaService;
    
    @RequestMapping({ "createDetails.action" })
    public String createDetails() {
        final List<Film> filmList = this.filmService.getAllFilm();
        this.getRequest().setAttribute("filmList", (Object)filmList);
        final List<City> cityList = this.cityService.getAllCity();
        this.getRequest().setAttribute("cityList", (Object)cityList);
        final List<Cinema> cinemaList = this.cinemaService.getAllCinema();
        this.getRequest().setAttribute("cinemaList", (Object)cinemaList);
        return "admin/adddetails";
    }
    
    @RequestMapping({ "addDetails.action" })
    public String addDetails(final Details details) {
        this.detailsService.insertDetails(details);
        return "redirect:/details/createDetails.action";
    }
    
    @RequestMapping({ "deleteDetails.action" })
    public String deleteDetails(final String id) {
        this.detailsService.deleteDetails(id);
        return "redirect:/details/getAllDetails.action";
    }
    
    @RequestMapping({ "deleteDetailsByIds.action" })
    public String deleteDetailsByIds() {
        final String[] ids = this.getRequest().getParameterValues("detailsid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String detailsid = array[i];
            this.detailsService.deleteDetails(detailsid);
        }
        return "redirect:/details/getAllDetails.action";
    }
    
    @RequestMapping({ "updateDetails.action" })
    public String updateDetails(final Details details) {
        this.detailsService.updateDetails(details);
        return "redirect:/details/getAllDetails.action";
    }
    
    @RequestMapping({ "getAllDetails.action" })
    public String getAllDetails(final String number) {
        final List<Details> detailsList = this.detailsService.getAllDetails();
        PageHelper.getPage(detailsList, "details", null, null, 10, number, this.getRequest(), null);
        return "admin/listdetails";
    }
    
    @RequestMapping({ "queryDetailsByCond.action" })
    public String queryDetailsByCond(String cond, String name, final String number) {
        final Details details = new Details();
        if (cond != null) {
            if ("ordercode".equals(cond)) {
                details.setOrdercode(name);
            }
            if ("filmid".equals(cond)) {
                details.setFilmid(name);
            }
            if ("num".equals(cond)) {
                details.setNum(name);
            }
            if ("price".equals(cond)) {
                details.setPrice(name);
            }
            if ("cityid".equals(cond)) {
                details.setCityid(name);
            }
            if ("cinemaid".equals(cond)) {
                details.setCinemaid(name);
            }
            if ("viewdate".equals(cond)) {
                details.setViewdate(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.detailsService.getDetailsByLike(details), "details", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/querydetails";
    }
    
    @RequestMapping({ "getDetailsById.action" })
    public String getDetailsById(final String id) {
        final Details details = this.detailsService.getDetailsById(id);
        this.getRequest().setAttribute("details", (Object)details);
        final List<Film> filmList = this.filmService.getAllFilm();
        this.getRequest().setAttribute("filmList", (Object)filmList);
        final List<City> cityList = this.cityService.getAllCity();
        this.getRequest().setAttribute("cityList", (Object)cityList);
        final List<Cinema> cinemaList = this.cinemaService.getAllCinema();
        this.getRequest().setAttribute("cinemaList", (Object)cinemaList);
        return "admin/editdetails";
    }
    
    public DetailsService getDetailsService() {
        return this.detailsService;
    }
    
    public void setDetailsService(final DetailsService detailsService) {
        this.detailsService = detailsService;
    }
}
