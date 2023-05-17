// 
// 
// 

package com.action;

import java.util.ArrayList;
import com.util.PageHelper;
import com.entity.Orders;
import com.entity.Users;
import java.util.List;
import com.service.UsersService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.OrdersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/orders" }, produces = { "text/plain;charset=utf-8" })
public class OrdersAction extends BaseAction
{
    @Autowired
    @Resource
    private OrdersService ordersService;
    @Autowired
    @Resource
    private UsersService usersService;
    
    @RequestMapping({ "createOrders.action" })
    public String createOrders() {
        final List<Users> usersList = this.usersService.getAllUsers();
        this.getRequest().setAttribute("usersList", (Object)usersList);
        return "admin/addorders";
    }
    
    @RequestMapping({ "addOrders.action" })
    public String addOrders(final Orders orders) {
        this.ordersService.insertOrders(orders);
        return "redirect:/orders/createOrders.action";
    }
    
    @RequestMapping({ "deleteOrders.action" })
    public String deleteOrders(final String id) {
        this.ordersService.deleteOrders(id);
        return "redirect:/orders/getAllOrders.action";
    }
    
    @RequestMapping({ "deleteOrdersByIds.action" })
    public String deleteOrdersByIds() {
        final String[] ids = this.getRequest().getParameterValues("ordersid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String ordersid = array[i];
            this.ordersService.deleteOrders(ordersid);
        }
        return "redirect:/orders/getAllOrders.action";
    }
    
    @RequestMapping({ "updateOrders.action" })
    public String updateOrders(final Orders orders) {
        this.ordersService.updateOrders(orders);
        return "redirect:/orders/getAllOrders.action";
    }
    
    @RequestMapping({ "getAllOrders.action" })
    public String getAllOrders(final String number) {
        final List<Orders> ordersList = this.ordersService.getAllOrders();
        PageHelper.getPage(ordersList, "orders", null, null, 10, number, this.getRequest(), null);
        return "admin/listorders";
    }
    
    @RequestMapping({ "queryOrdersByCond.action" })
    public String queryOrdersByCond(String cond, String name, final String number) {
        final Orders orders = new Orders();
        if (cond != null) {
            if ("ordercode".equals(cond)) {
                orders.setOrdercode(name);
            }
            if ("usersid".equals(cond)) {
                orders.setUsersid(name);
            }
            if ("total".equals(cond)) {
                orders.setTotal(name);
            }
            if ("status".equals(cond)) {
                orders.setStatus(name);
            }
            if ("addtime".equals(cond)) {
                orders.setAddtime(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.ordersService.getOrdersByLike(orders), "orders", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/queryorders";
    }
    
    @RequestMapping({ "getOrdersById.action" })
    public String getOrdersById(final String id) {
        final Orders orders = this.ordersService.getOrdersById(id);
        this.getRequest().setAttribute("orders", (Object)orders);
        final List<Users> usersList = this.usersService.getAllUsers();
        this.getRequest().setAttribute("usersList", (Object)usersList);
        return "admin/editorders";
    }
    
    public OrdersService getOrdersService() {
        return this.ordersService;
    }
    
    public void setOrdersService(final OrdersService ordersService) {
        this.ordersService = ordersService;
    }
}
