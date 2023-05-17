// 
// 
// 

package com.action;

import java.util.ArrayList;
import com.util.PageHelper;
import com.entity.Cart;
import com.entity.Film;
import com.entity.Users;
import java.util.List;
import com.service.FilmService;
import com.service.UsersService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.CartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = { "/cart" }, produces = { "text/plain;charset=utf-8" })
public class CartAction extends BaseAction
{
    @Autowired
    @Resource
    private CartService cartService;
    @Autowired
    @Resource
    private UsersService usersService;
    @Autowired
    @Resource
    private FilmService filmService;
    
    @RequestMapping({ "createCart.action" })
    public String createCart() {
        final List<Users> usersList = this.usersService.getAllUsers();
        this.getRequest().setAttribute("usersList", (Object)usersList);
        final List<Film> filmList = this.filmService.getAllFilm();
        this.getRequest().setAttribute("filmList", (Object)filmList);
        return "admin/addcart";
    }
    
    @RequestMapping({ "addCart.action" })
    public String addCart(final Cart cart) {
        this.cartService.insertCart(cart);
        return "redirect:/cart/createCart.action";
    }
    
    @RequestMapping({ "deleteCart.action" })
    public String deleteCart(final String id) {
        this.cartService.deleteCart(id);
        return "redirect:/cart/getAllCart.action";
    }
    
    @RequestMapping({ "deleteCartByIds.action" })
    public String deleteCartByIds() {
        final String[] ids = this.getRequest().getParameterValues("cartid");
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String cartid = array[i];
            this.cartService.deleteCart(cartid);
        }
        return "redirect:/cart/getAllCart.action";
    }
    
    @RequestMapping({ "updateCart.action" })
    public String updateCart(final Cart cart) {
        this.cartService.updateCart(cart);
        return "redirect:/cart/getAllCart.action";
    }
    
    @RequestMapping({ "getAllCart.action" })
    public String getAllCart(final String number) {
        final List<Cart> cartList = this.cartService.getAllCart();
        PageHelper.getPage(cartList, "cart", null, null, 10, number, this.getRequest(), null);
        return "admin/listcart";
    }
    
    @RequestMapping({ "queryCartByCond.action" })
    public String queryCartByCond(String cond, String name, final String number) {
        final Cart cart = new Cart();
        if (cond != null) {
            if ("usersid".equals(cond)) {
                cart.setUsersid(name);
            }
            if ("filmid".equals(cond)) {
                cart.setFilmid(name);
            }
            if ("num".equals(cond)) {
                cart.setNum(name);
            }
            if ("price".equals(cond)) {
                cart.setPrice(name);
            }
        }
        final List<String> nameList = new ArrayList<String>();
        final List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.cartService.getCartByLike(cart), "cart", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/querycart";
    }
    
    @RequestMapping({ "getCartById.action" })
    public String getCartById(final String id) {
        final Cart cart = this.cartService.getCartById(id);
        this.getRequest().setAttribute("cart", (Object)cart);
        final List<Users> usersList = this.usersService.getAllUsers();
        this.getRequest().setAttribute("usersList", (Object)usersList);
        final List<Film> filmList = this.filmService.getAllFilm();
        this.getRequest().setAttribute("filmList", (Object)filmList);
        return "admin/editcart";
    }
    
    public CartService getCartService() {
        return this.cartService;
    }
    
    public void setCartService(final CartService cartService) {
        this.cartService = cartService;
    }
}
