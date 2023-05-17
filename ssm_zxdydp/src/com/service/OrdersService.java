// 
// 
// 

package com.service;

import java.util.List;
import com.entity.Orders;
import org.springframework.stereotype.Service;

@Service("ordersService")
public interface OrdersService
{
    int insertOrders(Orders p0);
    
    int updateOrders(Orders p0);
    
    int deleteOrders(String p0);
    
    List<Orders> getAllOrders();
    
    List<Orders> getOrdersByCond(Orders p0);
    
    List<Orders> getOrdersByLike(Orders p0);
    
    Orders getOrdersById(String p0);
}
