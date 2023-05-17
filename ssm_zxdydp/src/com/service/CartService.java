// 
// 
// 

package com.service;

import java.util.List;
import com.entity.Cart;
import org.springframework.stereotype.Service;

@Service("cartService")
public interface CartService
{
    int insertCart(Cart p0);
    
    int updateCart(Cart p0);
    
    int deleteCart(String p0);
    
    List<Cart> getAllCart();
    
    List<Cart> getCartByCond(Cart p0);
    
    List<Cart> getCartByLike(Cart p0);
    
    Cart getCartById(String p0);
}
