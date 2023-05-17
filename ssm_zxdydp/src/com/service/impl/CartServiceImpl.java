// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Cart;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.CartDAO;
import org.springframework.stereotype.Service;
import com.service.CartService;

@Service("cartService")
public class CartServiceImpl implements CartService
{
    @Autowired
    @Resource
    private CartDAO cartDAO;
    
    @Override
    public int insertCart(final Cart cart) {
        return this.cartDAO.insertCart(cart);
    }
    
    @Override
    public int updateCart(final Cart cart) {
        return this.cartDAO.updateCart(cart);
    }
    
    @Override
    public int deleteCart(final String cartid) {
        return this.cartDAO.deleteCart(cartid);
    }
    
    @Override
    public List<Cart> getAllCart() {
        return this.cartDAO.getAllCart();
    }
    
    @Override
    public List<Cart> getCartByCond(final Cart cart) {
        return this.cartDAO.getCartByCond(cart);
    }
    
    @Override
    public List<Cart> getCartByLike(final Cart cart) {
        return this.cartDAO.getCartByLike(cart);
    }
    
    @Override
    public Cart getCartById(final String cartid) {
        return this.cartDAO.getCartById(cartid);
    }
}
