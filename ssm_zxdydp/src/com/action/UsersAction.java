// 
// 
// 

package com.action;

import java.util.ArrayList;
import java.util.List;
import com.util.PageHelper;
import com.util.VeDate;
import com.entity.Users;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/users" }, produces = { "text/plain;charset=utf-8" })
public class UsersAction extends BaseAction
{
    @Autowired
    @Resource
    private UsersService usersService;
    
    @RequestMapping({ "createUsers.action" })
    public String createUsers() {
        return "admin/addusers";
    }
    
    @RequestMapping({ "addUsers.action" })
    public String addUsers(final Users users) {
        users.setRegdate(VeDate.getStringDateShort());
        this.usersService.insertUsers(users);
        return "redirect:/users/createUsers.action";
    }
    
    @RequestMapping({ "deleteUsers.action" })
    public String deleteUsers(final String id) {
        this.usersService.deleteUsers(id);
        return "redirect:/users/getAllUsers.action";
    }
    
    @RequestMapping({ "deleteUsersByIds.action" })
    public String deleteUsersByIds() {
        final String[] ids = this.getRequest().getParameterValues("usersid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String usersid = array[i];
            this.usersService.deleteUsers(usersid);
        }
        return "redirect:/users/getAllUsers.action";
    }
    
    @RequestMapping({ "updateUsers.action" })
    public String updateUsers(final Users users) {
        this.usersService.updateUsers(users);
        return "redirect:/users/getAllUsers.action";
    }
    
    @RequestMapping({ "getAllUsers.action" })
    public String getAllUsers(final String number) {
        final List<Users> usersList = this.usersService.getAllUsers();
        PageHelper.getPage(usersList, "users", null, null, 10, number, this.getRequest(), null);
        return "admin/listusers";
    }
    
    @RequestMapping({ "queryUsersByCond.action" })
    public String queryUsersByCond(String cond, String name, final String number) {
        final Users users = new Users();
        if (cond != null) {
            if ("username".equals(cond)) {
                users.setUsername(name);
            }
            if ("password".equals(cond)) {
                users.setPassword(name);
            }
            if ("realname".equals(cond)) {
                users.setRealname(name);
            }
            if ("sex".equals(cond)) {
                users.setSex(name);
            }
            if ("birthday".equals(cond)) {
                users.setBirthday(name);
            }
            if ("contact".equals(cond)) {
                users.setContact(name);
            }
            if ("regdate".equals(cond)) {
                users.setRegdate(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.usersService.getUsersByLike(users), "users", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/queryusers";
    }
    
    @RequestMapping({ "getUsersById.action" })
    public String getUsersById(final String id) {
        final Users users = this.usersService.getUsersById(id);
        this.getRequest().setAttribute("users", (Object)users);
        return "admin/editusers";
    }
    
    public UsersService getUsersService() {
        return this.usersService;
    }
    
    public void setUsersService(final UsersService usersService) {
        this.usersService = usersService;
    }
}
