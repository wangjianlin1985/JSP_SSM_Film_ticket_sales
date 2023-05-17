// 
// 
// 

package com.action;

import com.entity.Topic;
import com.entity.Orders;
import com.entity.Details;
import com.entity.City;
import com.entity.Cart;
import com.util.VeDate;
import com.entity.Users;
import com.entity.Article;
import java.util.Iterator;
import java.util.ArrayList;
import com.entity.Film;
import com.entity.Cate;
import java.util.List;
import com.service.TopicService;
import com.service.DetailsService;
import com.service.OrdersService;
import com.service.CartService;
import com.service.FilmService;
import com.service.CinemaService;
import com.service.CityService;
import com.service.CateService;
import com.service.ArticleService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/index" })
public class IndexAction extends BaseAction
{
    @Autowired
    @Resource
    private UsersService usersService;
    @Autowired
    @Resource
    private ArticleService articleService;
    @Autowired
    @Resource
    private CateService cateService;
    @Autowired
    @Resource
    private CityService cityService;
    @Autowired
    @Resource
    private CinemaService cinemaService;
    @Autowired
    @Resource
    private FilmService filmService;
    @Autowired
    @Resource
    private CartService cartService;
    @Autowired
    @Resource
    private OrdersService ordersService;
    @Autowired
    @Resource
    private DetailsService detailsService;
    @Autowired
    @Resource
    private TopicService topicService;
    
    private void front() {
        this.getRequest().setAttribute("title", (Object)"\u5728\u7ebf\u7535\u5f71\u8ba2\u7968\u7cfb\u7edf");
        final List<Cate> cateList = this.cateService.getAllCate();
        this.getRequest().setAttribute("cateList", (Object)cateList);
        final List<Film> hotList = this.filmService.getFilmByHot();
        this.getRequest().setAttribute("hotList", (Object)hotList);
    }
    
    @RequestMapping({ "index.action" })
    public String index() {
        this.front();
        final List<Cate> cateList = this.cateService.getCateFront();
        final List<Cate> frontList = new ArrayList<Cate>();
        for (final Cate cate : cateList) {
            final List<Film> flimList = this.filmService.getFilmByCate(cate.getCateid());
            cate.setFlimList(flimList);
            frontList.add(cate);
        }
        this.getRequest().setAttribute("frontList", (Object)frontList);
        return "users/index";
    }
    
    @RequestMapping({ "article.action" })
    public String article(String number) {
        this.front();
        final List<Article> articleList = new ArrayList<Article>();
        final List<Article> tempList = this.articleService.getAllArticle();
        int maxPage;
        final int pageNumber = maxPage = tempList.size();
        if (maxPage % 12 == 0) {
            maxPage /= 12;
        }
        else {
            maxPage = maxPage / 12 + 1;
        }
        if (number == null) {
            number = "0";
        }
        final int start = Integer.parseInt(number) * 12;
        int over = (Integer.parseInt(number) + 1) * 12;
        final int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int i = start; i < over; ++i) {
            final Article x = tempList.get(i);
            articleList.add(x);
        }
        String html = "";
        final StringBuffer buffer = new StringBuffer();
        buffer.append("&nbsp;&nbsp;\u5171\u4e3a");
        buffer.append(maxPage);
        buffer.append("\u9875&nbsp; \u5171\u6709");
        buffer.append(pageNumber);
        buffer.append("\u6761&nbsp; \u5f53\u524d\u4e3a\u7b2c");
        buffer.append(Integer.parseInt(number) + 1);
        buffer.append("\u9875 &nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u9996\u9875");
        }
        else {
            buffer.append("<a href=\"index/article.action?number=0\">\u9996\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u4e0a\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/article.action?number=" + (Integer.parseInt(number) - 1) + "\">\u4e0a\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u4e0b\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/article.action?number=" + (Integer.parseInt(number) + 1) + "\">\u4e0b\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u5c3e\u9875");
        }
        else {
            buffer.append("<a href=\"index/article.action?number=" + (maxPage - 1) + "\">\u5c3e\u9875</a>");
        }
        html = buffer.toString();
        this.getRequest().setAttribute("html", (Object)html);
        this.getRequest().setAttribute("articleList", (Object)articleList);
        return "users/article";
    }
    
    @RequestMapping({ "read.action" })
    public String read(final String id) {
        this.front();
        final Article article = this.articleService.getArticleById(id);
        article.setHits(new StringBuilder().append(Integer.parseInt(article.getHits()) + 1).toString());
        this.articleService.updateArticle(article);
        this.getRequest().setAttribute("article", (Object)article);
        return "users/read";
    }
    
    @RequestMapping({ "preLogin.action" })
    public String prelogin() {
        this.front();
        return "users/login";
    }
    
    @RequestMapping({ "login.action" })
    public String login() {
        this.front();
        final String username = this.getRequest().getParameter("username");
        final String password = this.getRequest().getParameter("password");
        final Users u = new Users();
        u.setUsername(username);
        final List<Users> usersList = this.usersService.getUsersByCond(u);
        if (usersList.size() == 0) {
            this.getSession().setAttribute("message", (Object)"\u7528\u6237\u540d\u4e0d\u5b58\u5728");
            return "redirect:/index/preLogin.action";
        }
        final Users users = usersList.get(0);
        if (password.equals(users.getPassword())) {
            this.getSession().setAttribute("userid", (Object)users.getUsersid());
            this.getSession().setAttribute("username", (Object)users.getUsername());
            this.getSession().setAttribute("users", (Object)users);
            return "redirect:/index/index.action";
        }
        this.getSession().setAttribute("message", (Object)"\u5bc6\u7801\u9519\u8bef");
        return "redirect:/index/preLogin.action";
    }
    
    @RequestMapping({ "preReg.action" })
    public String preReg() {
        this.front();
        return "users/register";
    }
    
    @RequestMapping({ "register.action" })
    public String register(final Users users) {
        this.front();
        final Users u = new Users();
        u.setUsername(users.getUsername());
        final List<Users> usersList = this.usersService.getUsersByCond(u);
        if (usersList.size() == 0) {
            users.setRegdate(VeDate.getStringDateShort());
            this.usersService.insertUsers(users);
            return "redirect:/index/preLogin.action";
        }
        this.getSession().setAttribute("message", (Object)"\u7528\u6237\u540d\u5df2\u5b58\u5728");
        return "redirect:/index/preReg.action";
    }
    
    @RequestMapping({ "exit.action" })
    public String exit() {
        this.front();
        this.getSession().removeAttribute("userid");
        this.getSession().removeAttribute("username");
        this.getSession().removeAttribute("users");
        return "index";
    }
    
    @RequestMapping({ "prePwd.action" })
    public String prePwd() {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        return "users/editpwd";
    }
    
    @RequestMapping({ "editpwd.action" })
    public String editpwd() {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final String userid = (String)this.getSession().getAttribute("userid");
        final String password = this.getRequest().getParameter("password");
        final String repassword = this.getRequest().getParameter("repassword");
        final Users users = this.usersService.getUsersById(userid);
        if (password.equals(users.getPassword())) {
            users.setPassword(repassword);
            this.usersService.updateUsers(users);
            return "redirect:/index/prePwd.action";
        }
        this.getSession().setAttribute("message", (Object)"\u65e7\u5bc6\u7801\u9519\u8bef");
        return "redirect:/index/prePwd.action";
    }
    
    @RequestMapping({ "usercenter.action" })
    public String usercenter() {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        return "users/usercenter";
    }
    
    @RequestMapping({ "userinfo.action" })
    public String userinfo() {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final String userid = (String)this.getSession().getAttribute("userid");
        this.getSession().setAttribute("users", (Object)this.usersService.getUsersById(userid));
        return "users/userinfo";
    }
    
    @RequestMapping({ "personal.action" })
    public String personal(final Users users) {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        this.usersService.updateUsers(users);
        return "redirect:/index/userinfo.action";
    }
    
    @RequestMapping({ "addcart.action" })
    public String addcart() {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final String userid = (String)this.getSession().getAttribute("userid");
        final Cart cart = new Cart();
        cart.setFilmid(this.getRequest().getParameter("goodsid"));
        cart.setNum(this.getRequest().getParameter("num"));
        cart.setPrice(this.getRequest().getParameter("price"));
        cart.setUsersid(userid);
        this.cartService.insertCart(cart);
        return "redirect:/index/cart.action";
    }
    
    @RequestMapping({ "cart.action" })
    public String cart() {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final String userid = (String)this.getSession().getAttribute("userid");
        final Cart cart = new Cart();
        cart.setUsersid(userid);
        final List<Cart> cartList = this.cartService.getCartByCond(cart);
        this.getRequest().setAttribute("cartList", (Object)cartList);
        return "users/cart";
    }
    
    @RequestMapping({ "deletecart.action" })
    public String deletecart(final String id) {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        this.cartService.deleteCart(id);
        return "redirect:/index/cart.action";
    }
    
    @RequestMapping({ "preCheckout.action" })
    public String preCheckout() {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final String userid = (String)this.getSession().getAttribute("userid");
        final Cart cart = new Cart();
        cart.setUsersid(userid);
        final List<Cart> cartList = this.cartService.getCartByCond(cart);
        if (cartList.size() == 0) {
            this.getSession().setAttribute("message", (Object)"\u8bf7\u9009\u8d2d\u5546\u54c1");
            return "redirect:/index/cart.action";
        }
        final List<City> cityList = this.cityService.getAllCity();
        this.getRequest().setAttribute("cityList", (Object)cityList);
        return "users/checkout";
    }
    
    @RequestMapping({ "checkout.action" })
    public String checkout() {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final String userid = (String)this.getSession().getAttribute("userid");
        final Cart cart1 = new Cart();
        cart1.setUsersid(userid);
        final List<Cart> cartList = this.cartService.getCartByCond(cart1);
        if (cartList.size() == 0) {
            this.getRequest().setAttribute("message", (Object)"\u8bf7\u9009\u8d2d\u5546\u54c1");
            return "redirect:/index/cart.action";
        }
        final String ordercode = "PD" + VeDate.getStringDatex();
        double total = 0.0;
        for (final Cart cart2 : cartList) {
            final Details details = new Details();
            details.setDetailsid(String.valueOf(VeDate.getStringDatex()) + (Math.random() * 9.0 + 1.0) * 1200.0);
            details.setFilmid(cart2.getFilmid());
            details.setNum(cart2.getNum());
            details.setOrdercode(ordercode);
            details.setPrice(cart2.getPrice());
            details.setCinemaid(this.getRequest().getParameter("cinemaid"));
            details.setCityid(this.getRequest().getParameter("cityid"));
            details.setViewdate(this.getRequest().getParameter("viewdate"));
            this.detailsService.insertDetails(details);
            final Film goods = this.filmService.getFilmById(cart2.getFilmid());
            goods.setSellnum(new StringBuilder().append(Integer.parseInt(goods.getSellnum()) + Integer.parseInt(cart2.getNum())).toString());
            this.filmService.updateFilm(goods);
            total += Double.parseDouble(cart2.getPrice()) * Double.parseDouble(cart2.getNum());
            this.cartService.deleteCart(cart2.getCartid());
        }
        final Orders orders = new Orders();
        orders.setAddtime(VeDate.getStringDateShort());
        orders.setOrdercode(ordercode);
        orders.setStatus("\u672a\u4ed8\u6b3e");
        orders.setTotal(new StringBuilder().append(total).toString());
        orders.setUsersid(userid);
        this.ordersService.insertOrders(orders);
        return "redirect:/index/showOrders.action";
    }
    
    @RequestMapping({ "showOrders.action" })
    public String showOrders(String number) {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final String userid = (String)this.getSession().getAttribute("userid");
        final Orders orders = new Orders();
        orders.setUsersid(userid);
        final List<Orders> ordersList = new ArrayList<Orders>();
        final List<Orders> tempList = this.ordersService.getOrdersByCond(orders);
        int maxPage;
        final int pageNumber = maxPage = tempList.size();
        if (maxPage % 12 == 0) {
            maxPage /= 12;
        }
        else {
            maxPage = maxPage / 12 + 1;
        }
        if (number == null) {
            number = "0";
        }
        final int start = Integer.parseInt(number) * 12;
        int over = (Integer.parseInt(number) + 1) * 12;
        final int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int i = start; i < over; ++i) {
            final Orders o = tempList.get(i);
            ordersList.add(o);
        }
        String html = "";
        final StringBuffer buffer = new StringBuffer();
        buffer.append("&nbsp;&nbsp;\u5171\u4e3a");
        buffer.append(maxPage);
        buffer.append("\u9875&nbsp; \u5171\u6709");
        buffer.append(pageNumber);
        buffer.append("\u6761&nbsp; \u5f53\u524d\u4e3a\u7b2c");
        buffer.append(Integer.parseInt(number) + 1);
        buffer.append("\u9875 &nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u9996\u9875");
        }
        else {
            buffer.append("<a href=\"index/showOrders.action?number=0\">\u9996\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u4e0a\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/showOrders.action?number=" + (Integer.parseInt(number) - 1) + "\">\u4e0a\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u4e0b\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/showOrders.action?number=" + (Integer.parseInt(number) + 1) + "\">\u4e0b\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u5c3e\u9875");
        }
        else {
            buffer.append("<a href=\"index/showOrders.action?number=" + (maxPage - 1) + "\">\u5c3e\u9875</a>");
        }
        html = buffer.toString();
        this.getRequest().setAttribute("html", (Object)html);
        this.getRequest().setAttribute("ordersList", (Object)ordersList);
        return "users/orderlist";
    }
    
    @RequestMapping({ "prePay.action" })
    public String prePay(final String id) {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        this.getRequest().setAttribute("id", (Object)id);
        return "users/pay";
    }
    
    @RequestMapping({ "pay.action" })
    public String pay(final String id) {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
        orders.setStatus("\u5df2\u4ed8\u6b3e");
        this.ordersService.updateOrders(orders);
        return "redirect:/index/showOrders.action";
    }
    
    @RequestMapping({ "over.action" })
    public String over(final String id) {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
        orders.setStatus("\u5df2\u6536\u8d27");
        this.ordersService.updateOrders(orders);
        return "redirect:/index/showOrders.action";
    }
    
    @RequestMapping({ "cancel.action" })
    public String cancel(final String id) {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
        orders.setStatus("\u5df2\u53d6\u6d88");
        this.ordersService.updateOrders(orders);
        return "redirect:/index/showOrders.action";
    }
    
    @RequestMapping({ "orderdetail.action" })
    public String orderdetail(final String id) {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final Details details = new Details();
        details.setOrdercode(id);
        final List<Details> detailsList = this.detailsService.getDetailsByCond(details);
        this.getRequest().setAttribute("detailsList", (Object)detailsList);
        return "users/orderdetail";
    }
    
    @RequestMapping({ "cate.action" })
    public String cate(final String id, String number) {
        this.front();
        final Film goods = new Film();
        goods.setCateid(id);
        final List<Film> flimList = new ArrayList<Film>();
        final List<Film> tempList = this.filmService.getFilmByCond(goods);
        int maxPage;
        final int pageNumber = maxPage = tempList.size();
        if (maxPage % 12 == 0) {
            maxPage /= 12;
        }
        else {
            maxPage = maxPage / 12 + 1;
        }
        if (number == null) {
            number = "0";
        }
        final int start = Integer.parseInt(number) * 12;
        int over = (Integer.parseInt(number) + 1) * 12;
        final int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int i = start; i < over; ++i) {
            final Film x = tempList.get(i);
            flimList.add(x);
        }
        String html = "";
        final StringBuffer buffer = new StringBuffer();
        buffer.append("&nbsp;&nbsp;\u5171\u4e3a");
        buffer.append(maxPage);
        buffer.append("\u9875&nbsp; \u5171\u6709");
        buffer.append(pageNumber);
        buffer.append("\u6761&nbsp; \u5f53\u524d\u4e3a\u7b2c");
        buffer.append(Integer.parseInt(number) + 1);
        buffer.append("\u9875 &nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u9996\u9875");
        }
        else {
            buffer.append("<a href=\"index/cate.action?number=0&id=\" + id+ \"\">\u9996\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u4e0a\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/cate.action?number=" + (Integer.parseInt(number) - 1) + "&id=\" + id+ \"\">\u4e0a\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u4e0b\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/cate.action?number=" + (Integer.parseInt(number) + 1) + "&id=\" + id+ \"\">\u4e0b\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u5c3e\u9875");
        }
        else {
            buffer.append("<a href=\"index/cate.action?number=" + (maxPage - 1) + "&id=\" + id+ \"\">\u5c3e\u9875</a>");
        }
        html = buffer.toString();
        this.getRequest().setAttribute("html", (Object)html);
        this.getRequest().setAttribute("flimList", (Object)flimList);
        return "users/list";
    }
    
    @RequestMapping({ "recommend.action" })
    public String recommend(String number) {
        this.front();
        final Film goods = new Film();
        goods.setRecommend("\u662f");
        final List<Film> flimList = new ArrayList<Film>();
        final List<Film> tempList = this.filmService.getFilmByCond(goods);
        int maxPage;
        final int pageNumber = maxPage = tempList.size();
        if (maxPage % 12 == 0) {
            maxPage /= 12;
        }
        else {
            maxPage = maxPage / 12 + 1;
        }
        if (number == null) {
            number = "0";
        }
        final int start = Integer.parseInt(number) * 12;
        int over = (Integer.parseInt(number) + 1) * 12;
        final int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int i = start; i < over; ++i) {
            final Film x = tempList.get(i);
            flimList.add(x);
        }
        String html = "";
        final StringBuffer buffer = new StringBuffer();
        buffer.append("&nbsp;&nbsp;\u5171\u4e3a");
        buffer.append(maxPage);
        buffer.append("\u9875&nbsp; \u5171\u6709");
        buffer.append(pageNumber);
        buffer.append("\u6761&nbsp; \u5f53\u524d\u4e3a\u7b2c");
        buffer.append(Integer.parseInt(number) + 1);
        buffer.append("\u9875 &nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u9996\u9875");
        }
        else {
            buffer.append("<a href=\"index/recommend.action?number=0\">\u9996\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u4e0a\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/recommend.action?number=" + (Integer.parseInt(number) - 1) + "\">\u4e0a\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u4e0b\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/recommend.action?number=" + (Integer.parseInt(number) + 1) + "\">\u4e0b\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u5c3e\u9875");
        }
        else {
            buffer.append("<a href=\"index/recommend.action?number=" + (maxPage - 1) + "\">\u5c3e\u9875</a>");
        }
        html = buffer.toString();
        this.getRequest().setAttribute("html", (Object)html);
        this.getRequest().setAttribute("flimList", (Object)flimList);
        return "users/list";
    }
    
    @RequestMapping({ "all.action" })
    public String all(String number) {
        this.front();
        final List<Film> flimList = new ArrayList<Film>();
        final List<Film> tempList = this.filmService.getAllFilm();
        int maxPage;
        final int pageNumber = maxPage = tempList.size();
        if (maxPage % 12 == 0) {
            maxPage /= 12;
        }
        else {
            maxPage = maxPage / 12 + 1;
        }
        if (number == null) {
            number = "0";
        }
        final int start = Integer.parseInt(number) * 12;
        int over = (Integer.parseInt(number) + 1) * 12;
        final int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int i = start; i < over; ++i) {
            final Film x = tempList.get(i);
            flimList.add(x);
        }
        String html = "";
        final StringBuffer buffer = new StringBuffer();
        buffer.append("&nbsp;&nbsp;\u5171\u4e3a");
        buffer.append(maxPage);
        buffer.append("\u9875&nbsp; \u5171\u6709");
        buffer.append(pageNumber);
        buffer.append("\u6761&nbsp; \u5f53\u524d\u4e3a\u7b2c");
        buffer.append(Integer.parseInt(number) + 1);
        buffer.append("\u9875 &nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u9996\u9875");
        }
        else {
            buffer.append("<a href=\"index/recommend.action?number=0\">\u9996\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u4e0a\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/recommend.action?number=" + (Integer.parseInt(number) - 1) + "\">\u4e0a\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u4e0b\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"index/recommend.action?number=" + (Integer.parseInt(number) + 1) + "\">\u4e0b\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u5c3e\u9875");
        }
        else {
            buffer.append("<a href=\"index/recommend.action?number=" + (maxPage - 1) + "\">\u5c3e\u9875</a>");
        }
        html = buffer.toString();
        this.getRequest().setAttribute("html", (Object)html);
        this.getRequest().setAttribute("flimList", (Object)flimList);
        return "users/list";
    }
    
    @RequestMapping({ "query.action" })
    public String query(final String name) {
        this.front();
        final Film goods = new Film();
        goods.setFilmname(name);
        final List<Film> flimList = this.filmService.getFilmByLike(goods);
        this.getRequest().setAttribute("flimList", (Object)flimList);
        return "users/list";
    }
    
    @RequestMapping({ "detail.action" })
    public String detail(final String id) {
        this.front();
        final Film goods = this.filmService.getFilmById(id);
        goods.setHits(new StringBuilder().append(Integer.parseInt(goods.getHits()) + 1).toString());
        this.filmService.updateFilm(goods);
        this.getRequest().setAttribute("goods", (Object)goods);
        final Topic topic = new Topic();
        topic.setFilmid(id);
        final List<Topic> topicList = this.topicService.getTopicByCond(topic);
        this.getRequest().setAttribute("topicList", (Object)topicList);
        this.getRequest().setAttribute("tnum", (Object)topicList.size());
        return "users/detail";
    }
    
    @RequestMapping({ "addTopic.action" })
    public String addTopic(final Topic topic) {
        this.front();
        if (this.getSession().getAttribute("userid") == null) {
            return "redirect:/index/preLogin.action";
        }
        final String userid = (String)this.getSession().getAttribute("userid");
        topic.setAddtime(VeDate.getStringDateShort());
        topic.setContents(this.getRequest().getParameter("contents"));
        topic.setFilmid(this.getRequest().getParameter("goodsid"));
        topic.setNum(this.getRequest().getParameter("num"));
        topic.setUsersid(userid);
        this.topicService.insertTopic(topic);
        return "redirect:/index/detail.action?id=" + topic.getFilmid();
    }
}
