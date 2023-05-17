// 
// 
// 

package com.action;

import java.util.ArrayList;
import java.util.List;
import com.util.PageHelper;
import com.util.VeDate;
import com.entity.Cate;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.CateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/cate" }, produces = { "text/plain;charset=utf-8" })
public class CateAction extends BaseAction
{
    @Autowired
    @Resource
    private CateService cateService;
    
    @RequestMapping({ "createCate.action" })
    public String createCate() {
        return "admin/addcate";
    }
    
    @RequestMapping({ "addCate.action" })
    public String addCate(final Cate cate) {
        cate.setAddtime(VeDate.getStringDateShort());
        this.cateService.insertCate(cate);
        return "redirect:/cate/createCate.action";
    }
    
    @RequestMapping({ "deleteCate.action" })
    public String deleteCate(final String id) {
        this.cateService.deleteCate(id);
        return "redirect:/cate/getAllCate.action";
    }
    
    @RequestMapping({ "deleteCateByIds.action" })
    public String deleteCateByIds() {
        final String[] ids = this.getRequest().getParameterValues("cateid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String cateid = array[i];
            this.cateService.deleteCate(cateid);
        }
        return "redirect:/cate/getAllCate.action";
    }
    
    @RequestMapping({ "updateCate.action" })
    public String updateCate(final Cate cate) {
        this.cateService.updateCate(cate);
        return "redirect:/cate/getAllCate.action";
    }
    
    @RequestMapping({ "getAllCate.action" })
    public String getAllCate(final String number) {
        final List<Cate> cateList = this.cateService.getAllCate();
        PageHelper.getPage(cateList, "cate", null, null, 10, number, this.getRequest(), null);
        return "admin/listcate";
    }
    
    @RequestMapping({ "queryCateByCond.action" })
    public String queryCateByCond(String cond, String name, final String number) {
        final Cate cate = new Cate();
        if (cond != null) {
            if ("catename".equals(cond)) {
                cate.setCatename(name);
            }
            if ("memo".equals(cond)) {
                cate.setMemo(name);
            }
            if ("addtime".equals(cond)) {
                cate.setAddtime(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.cateService.getCateByLike(cate), "cate", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/querycate";
    }
    
    @RequestMapping({ "getCateById.action" })
    public String getCateById(final String id) {
        final Cate cate = this.cateService.getCateById(id);
        this.getRequest().setAttribute("cate", (Object)cate);
        return "admin/editcate";
    }
    
    public CateService getCateService() {
        return this.cateService;
    }
    
    public void setCateService(final CateService cateService) {
        this.cateService = cateService;
    }
}
