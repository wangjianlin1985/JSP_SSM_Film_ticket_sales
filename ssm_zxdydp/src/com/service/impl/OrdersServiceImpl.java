// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Orders;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.OrdersDAO;
import org.springframework.stereotype.Service;
import com.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService
{
    @Autowired
    @Resource
    private OrdersDAO ordersDAO;
    
    @Override
    public int insertOrders(final Orders orders) {
        return this.ordersDAO.insertOrders(orders);
    }
    
    @Override
    public int updateOrders(final Orders orders) {
        return this.ordersDAO.updateOrders(orders);
    }
    
    @Override
    public int deleteOrders(final String ordersid) {
        return this.ordersDAO.deleteOrders(ordersid);
    }
    
    @Override
    public List<Orders> getAllOrders() {
        return this.ordersDAO.getAllOrders();
    }
    
    @Override
    public List<Orders> getOrdersByCond(final Orders orders) {
        return this.ordersDAO.getOrdersByCond(orders);
    }
    
    @Override
    public List<Orders> getOrdersByLike(final Orders orders) {
        return this.ordersDAO.getOrdersByLike(orders);
    }
    
    @Override
    public Orders getOrdersById(final String ordersid) {
        return this.ordersDAO.getOrdersById(ordersid);
    }
}
