// 
// 
// 

package com.action;

import java.util.ArrayList;
import com.util.PageHelper;
import com.entity.Topic;
import com.entity.Film;
import com.entity.Users;
import java.util.List;
import com.service.FilmService;
import com.service.UsersService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.TopicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/topic" }, produces = { "text/plain;charset=utf-8" })
public class TopicAction extends BaseAction
{
    @Autowired
    @Resource
    private TopicService topicService;
    @Autowired
    @Resource
    private UsersService usersService;
    @Autowired
    @Resource
    private FilmService filmService;
    
    @RequestMapping({ "createTopic.action" })
    public String createTopic() {
        final List<Users> usersList = this.usersService.getAllUsers();
        this.getRequest().setAttribute("usersList", (Object)usersList);
        final List<Film> filmList = this.filmService.getAllFilm();
        this.getRequest().setAttribute("filmList", (Object)filmList);
        return "admin/addtopic";
    }
    
    @RequestMapping({ "addTopic.action" })
    public String addTopic(final Topic topic) {
        this.topicService.insertTopic(topic);
        return "redirect:/topic/createTopic.action";
    }
    
    @RequestMapping({ "deleteTopic.action" })
    public String deleteTopic(final String id) {
        this.topicService.deleteTopic(id);
        return "redirect:/topic/getAllTopic.action";
    }
    
    @RequestMapping({ "deleteTopicByIds.action" })
    public String deleteTopicByIds() {
        final String[] ids = this.getRequest().getParameterValues("topicid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String topicid = array[i];
            this.topicService.deleteTopic(topicid);
        }
        return "redirect:/topic/getAllTopic.action";
    }
    
    @RequestMapping({ "updateTopic.action" })
    public String updateTopic(final Topic topic) {
        this.topicService.updateTopic(topic);
        return "redirect:/topic/getAllTopic.action";
    }
    
    @RequestMapping({ "getAllTopic.action" })
    public String getAllTopic(final String number) {
        final List<Topic> topicList = this.topicService.getAllTopic();
        PageHelper.getPage(topicList, "topic", null, null, 10, number, this.getRequest(), null);
        return "admin/listtopic";
    }
    
    @RequestMapping({ "queryTopicByCond.action" })
    public String queryTopicByCond(String cond, String name, final String number) {
        final Topic topic = new Topic();
        if (cond != null) {
            if ("usersid".equals(cond)) {
                topic.setUsersid(name);
            }
            if ("filmid".equals(cond)) {
                topic.setFilmid(name);
            }
            if ("num".equals(cond)) {
                topic.setNum(name);
            }
            if ("contents".equals(cond)) {
                topic.setContents(name);
            }
            if ("addtime".equals(cond)) {
                topic.setAddtime(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.topicService.getTopicByLike(topic), "topic", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/querytopic";
    }
    
    @RequestMapping({ "getTopicById.action" })
    public String getTopicById(final String id) {
        final Topic topic = this.topicService.getTopicById(id);
        this.getRequest().setAttribute("topic", (Object)topic);
        final List<Users> usersList = this.usersService.getAllUsers();
        this.getRequest().setAttribute("usersList", (Object)usersList);
        final List<Film> filmList = this.filmService.getAllFilm();
        this.getRequest().setAttribute("filmList", (Object)filmList);
        return "admin/edittopic";
    }
    
    public TopicService getTopicService() {
        return this.topicService;
    }
    
    public void setTopicService(final TopicService topicService) {
        this.topicService = topicService;
    }
}
