// 
// 
// 

package com.action;

import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import com.entity.Cinema;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.CinemaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/ajax" }, produces = { "text/plain;charset=utf-8" })
public class AjaxAction extends BaseAction
{
    @Autowired
    @Resource
    private CinemaService cinemaService;
    
    @RequestMapping({ "getCinema.action" })
    @ResponseBody
    public String getCinema() throws JSONException {
        final String cityid = this.getRequest().getParameter("cityid");
        final Cinema cinema = new Cinema();
        cinema.setCityid(cityid);
        final List<Cinema> cinemaList = this.cinemaService.getCinemaByCond(cinema);
        final JSONArray cinemaid = new JSONArray();
        final JSONArray cinemaname = new JSONArray();
        for (final Cinema c : cinemaList) {
            cinemaid.put((Object)c.getCinemaid());
            cinemaname.put((Object)c.getCinemaname());
        }
        final JSONObject json = new JSONObject();
        json.put("cinemaid", (Object)cinemaid.toString().replaceAll("\"", ""));
        json.put("cinemaname", (Object)cinemaname.toString().replaceAll("\"", ""));
        System.out.println(json.toString());
        return json.toString();
    }
}
