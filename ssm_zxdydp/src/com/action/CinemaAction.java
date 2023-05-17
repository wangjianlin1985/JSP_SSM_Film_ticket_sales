// 
// 
// 

package com.action;

import java.util.ArrayList;
import com.util.PageHelper;
import com.entity.Cinema;
import com.entity.City;
import java.util.List;
import com.service.CityService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.CinemaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/cinema" }, produces = { "text/plain;charset=utf-8" })
public class CinemaAction extends BaseAction
{
    @Autowired
    @Resource
    private CinemaService cinemaService;
    @Autowired
    @Resource
    private CityService cityService;
    
    @RequestMapping({ "createCinema.action" })
    public String createCinema() {
        final List<City> cityList = this.cityService.getAllCity();
        this.getRequest().setAttribute("cityList", (Object)cityList);
        return "admin/addcinema";
    }
    
    @RequestMapping({ "addCinema.action" })
    public String addCinema(final Cinema cinema) {
        this.cinemaService.insertCinema(cinema);
        return "redirect:/cinema/createCinema.action";
    }
    
    @RequestMapping({ "deleteCinema.action" })
    public String deleteCinema(final String id) {
        this.cinemaService.deleteCinema(id);
        return "redirect:/cinema/getAllCinema.action";
    }
    
    @RequestMapping({ "deleteCinemaByIds.action" })
    public String deleteCinemaByIds() {
        final String[] ids = this.getRequest().getParameterValues("cinemaid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String cinemaid = array[i];
            this.cinemaService.deleteCinema(cinemaid);
        }
        return "redirect:/cinema/getAllCinema.action";
    }
    
    @RequestMapping({ "updateCinema.action" })
    public String updateCinema(final Cinema cinema) {
        this.cinemaService.updateCinema(cinema);
        return "redirect:/cinema/getAllCinema.action";
    }
    
    @RequestMapping({ "getAllCinema.action" })
    public String getAllCinema(final String number) {
        final List<Cinema> cinemaList = this.cinemaService.getAllCinema();
        PageHelper.getPage(cinemaList, "cinema", null, null, 10, number, this.getRequest(), null);
        return "admin/listcinema";
    }
    
    @RequestMapping({ "queryCinemaByCond.action" })
    public String queryCinemaByCond(String cond, String name, final String number) {
        final Cinema cinema = new Cinema();
        if (cond != null) {
            if ("cinemaname".equals(cond)) {
                cinema.setCinemaname(name);
            }
            if ("cityid".equals(cond)) {
                cinema.setCityid(name);
            }
            if ("address".equals(cond)) {
                cinema.setAddress(name);
            }
            if ("contact".equals(cond)) {
                cinema.setContact(name);
            }
            if ("memo".equals(cond)) {
                cinema.setMemo(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.cinemaService.getCinemaByLike(cinema), "cinema", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/querycinema";
    }
    
    @RequestMapping({ "getCinemaById.action" })
    public String getCinemaById(final String id) {
        final Cinema cinema = this.cinemaService.getCinemaById(id);
        this.getRequest().setAttribute("cinema", (Object)cinema);
        final List<City> cityList = this.cityService.getAllCity();
        this.getRequest().setAttribute("cityList", (Object)cityList);
        return "admin/editcinema";
    }
    
    public CinemaService getCinemaService() {
        return this.cinemaService;
    }
    
    public void setCinemaService(final CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }
}
