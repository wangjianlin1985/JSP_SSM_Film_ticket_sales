// 
// 
// 

package com.action;

import java.util.ArrayList;
import java.util.List;
import com.util.PageHelper;
import com.entity.City;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/city" }, produces = { "text/plain;charset=utf-8" })
public class CityAction extends BaseAction
{
    @Autowired
    @Resource
    private CityService cityService;
    
    @RequestMapping({ "createCity.action" })
    public String createCity() {
        return "admin/addcity";
    }
    
    @RequestMapping({ "addCity.action" })
    public String addCity(final City city) {
        this.cityService.insertCity(city);
        return "redirect:/city/createCity.action";
    }
    
    @RequestMapping({ "deleteCity.action" })
    public String deleteCity(final String id) {
        this.cityService.deleteCity(id);
        return "redirect:/city/getAllCity.action";
    }
    
    @RequestMapping({ "deleteCityByIds.action" })
    public String deleteCityByIds() {
        final String[] ids = this.getRequest().getParameterValues("cityid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String cityid = array[i];
            this.cityService.deleteCity(cityid);
        }
        return "redirect:/city/getAllCity.action";
    }
    
    @RequestMapping({ "updateCity.action" })
    public String updateCity(final City city) {
        this.cityService.updateCity(city);
        return "redirect:/city/getAllCity.action";
    }
    
    @RequestMapping({ "getAllCity.action" })
    public String getAllCity(final String number) {
        final List<City> cityList = this.cityService.getAllCity();
        PageHelper.getPage(cityList, "city", null, null, 10, number, this.getRequest(), null);
        return "admin/listcity";
    }
    
    @RequestMapping({ "queryCityByCond.action" })
    public String queryCityByCond(String cond, String name, final String number) {
        final City city = new City();
        if (cond != null && "cityname".equals(cond)) {
            city.setCityname(name);
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.cityService.getCityByLike(city), "city", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/querycity";
    }
    
    @RequestMapping({ "getCityById.action" })
    public String getCityById(final String id) {
        final City city = this.cityService.getCityById(id);
        this.getRequest().setAttribute("city", (Object)city);
        return "admin/editcity";
    }
    
    public CityService getCityService() {
        return this.cityService;
    }
    
    public void setCityService(final CityService cityService) {
        this.cityService = cityService;
    }
}
