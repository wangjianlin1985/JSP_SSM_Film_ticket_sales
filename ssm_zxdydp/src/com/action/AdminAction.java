// 
// 
// 

package com.action;

import java.util.ArrayList;
import com.util.PageHelper;
import com.util.VeDate;
import java.util.List;
import com.entity.Admin;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/admin" }, produces = { "text/plain;charset=utf-8" })
public class AdminAction extends BaseAction
{
    @Autowired
    @Resource
    private AdminService adminService;
    
    @RequestMapping({ "login.action" })
    public String login() {
        final String username = this.getRequest().getParameter("username");
        final String password = this.getRequest().getParameter("password");
        final Admin adminEntity = new Admin();
        adminEntity.setUsername(username);
        final List<Admin> adminlist = this.adminService.getAdminByCond(adminEntity);
        if (adminlist.size() == 0) {
            this.getRequest().setAttribute("message", (Object)"\u7528\u6237\u540d\u4e0d\u5b58\u5728");
            return "admin/index";
        }
        final Admin admin = adminlist.get(0);
        if (password.equals(admin.getPassword())) {
            this.getSession().setAttribute("adminid", (Object)admin.getAdminid());
            this.getSession().setAttribute("adminname", (Object)admin.getUsername());
            this.getSession().setAttribute("realname", (Object)admin.getRealname());
            return "admin/main";
        }
        this.getRequest().setAttribute("message", (Object)"\u5bc6\u7801\u9519\u8bef");
        return "admin/index";
    }
    
    @RequestMapping({ "editpwd.action" })
    public String editpwd() {
        final String adminid = (String)this.getSession().getAttribute("adminid");
        final String password = this.getRequest().getParameter("password");
        final String repassword = this.getRequest().getParameter("repassword");
        final Admin admin = this.adminService.getAdminById(adminid);
        if (password.equals(admin.getPassword())) {
            admin.setPassword(repassword);
            this.adminService.updateAdmin(admin);
        }
        else {
            this.getRequest().setAttribute("message", (Object)"\u65e7\u5bc6\u7801\u9519\u8bef");
        }
        return "admin/editpwd";
    }
    
    @RequestMapping({ "exit.action" })
    public String exit() {
        this.getSession().removeAttribute("adminid");
        this.getSession().removeAttribute("adminname");
        this.getSession().removeAttribute("realname");
        return "admin/index";
    }
    
    @RequestMapping({ "createAdmin.action" })
    public String createAdmin() {
        return "admin/addadmin";
    }
    
    @RequestMapping({ "addAdmin.action" })
    public String addAdmin(final Admin admin) {
        admin.setAddtime(VeDate.getStringDateShort());
        this.adminService.insertAdmin(admin);
        return "redirect:/admin/createAdmin.action";
    }
    
    @RequestMapping({ "deleteAdmin.action" })
    public String deleteAdmin(final String id) {
        this.adminService.deleteAdmin(id);
        return "redirect:/admin/getAllAdmin.action";
    }
    
    @RequestMapping({ "deleteAdminByIds.action" })
    public String deleteAdminByIds() {
        final String[] ids = this.getRequest().getParameterValues("adminid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String adminid = array[i];
            this.adminService.deleteAdmin(adminid);
        }
        return "redirect:/admin/getAllAdmin.action";
    }
    
    @RequestMapping({ "updateAdmin.action" })
    public String updateAdmin(final Admin admin) {
        this.adminService.updateAdmin(admin);
        return "redirect:/admin/getAllAdmin.action";
    }
    
    @RequestMapping({ "getAllAdmin.action" })
    public String getAllAdmin(final String number) {
        final List<Admin> adminList = this.adminService.getAllAdmin();
        PageHelper.getPage(adminList, "admin", null, null, 10, number, this.getRequest(), null);
        return "admin/listadmin";
    }
    
    @RequestMapping({ "queryAdminByCond.action" })
    public String queryAdminByCond(String cond, String name, final String number) {
        final Admin admin = new Admin();
        if (cond != null) {
            if ("username".equals(cond)) {
                admin.setUsername(name);
            }
            if ("password".equals(cond)) {
                admin.setPassword(name);
            }
            if ("realname".equals(cond)) {
                admin.setRealname(name);
            }
            if ("contact".equals(cond)) {
                admin.setContact(name);
            }
            if ("addtime".equals(cond)) {
                admin.setAddtime(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.adminService.getAdminByLike(admin), "admin", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/queryadmin";
    }
    
    @RequestMapping({ "getAdminById.action" })
    public String getAdminById(final String id) {
        final Admin admin = this.adminService.getAdminById(id);
        this.getRequest().setAttribute("admin", (Object)admin);
        return "admin/editadmin";
    }
    
    public AdminService getAdminService() {
        return this.adminService;
    }
    
    public void setAdminService(final AdminService adminService) {
        this.adminService = adminService;
    }
}
