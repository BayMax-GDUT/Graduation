package controller;

import DAO.*;
import bean.*;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class managerController {

    //管理员登录
    @RequestMapping("/manager_login")
    public ModelAndView managerLogin(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mav = new ModelAndView("manager_login");
        return mav;
    }

    //登录提交
    @RequestMapping("/submit_manager_login")
    public ModelAndView submit_manager_login(HttpServletRequest request, HttpServletResponse response)
    {
        boolean b = new ManagerDAO().login(request.getParameter("name"),request.getParameter("password"));
        if(b)
        {
            request.getSession().setAttribute("manager", new ManagerDAO().getManager(request.getParameter("name")));
            ModelAndView mav = new ModelAndView("control_page");
            mav.addObject("users",new UserDAO().list());
            mav.addObject("ban_users",new Ban_UserDAO().list());
            mav.addObject("books",new BookDAO().list());
            mav.addObject("categories",new CategoryDAO().list());
            mav.addObject("sold_books",new Sold_BookDAO().list());
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("manager_login");
            mav.addObject("message","账号或密码错误，请重新输入");
            return mav;
        }
    }

    //管理员注册
    @RequestMapping("/add_manager")
    public ModelAndView add_manager()
    {
        ModelAndView mav = new ModelAndView("add_manager");
        return mav;
    }

    //注册提交
    @RequestMapping("submit_add_manager")
    public ModelAndView submit_add_manager(HttpServletRequest request,HttpServletResponse response)
    {
        String father = request.getParameter("father");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String e_mail_address = request.getParameter("e_mail_address");
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));
        if(father == null || name == null || password == null || e_mail_address == null || e_mail_address == null)
        {
            //phone_number没有判断 parseInt方法中若无法转换会抛出异常
            ModelAndView mav = new ModelAndView("add_manager");
//            mav.addObject("message","信息填写不完整，请重新填写");
            request.getSession().setAttribute("message", "信息填写不完整，请重新填写");
            return mav;
        }
        else if(new ManagerDAO().getManager(father) == null)
        {
            ModelAndView mav = new ModelAndView("add_manager");
//            mav.addObject("message","没有找到推荐者账号");
            request.getSession().setAttribute("message", "没有找到推荐者账号");
            return mav;
        }
        else if(new ManagerDAO().getManager(name) != null)
        {
            ModelAndView mav = new ModelAndView("add_manager");
//            mav.addObject("message","此账号已被注册");
            request.getSession().setAttribute("message", "此账号已被注册");
            return mav;
        }
        else {
            ModelAndView mav = new ModelAndView("add_manager_jump");
            mav.addObject("message","注册成功");
            return mav;
        }
    }

    //注销
    @RequestMapping("/manager_logout")
    public ModelAndView manager_logout(HttpServletRequest request,HttpServletResponse response)
    {
        request.getSession().removeAttribute("manager");
        ModelAndView mav = new ModelAndView("manager_login");
        return mav;
    }

    //普通用户管理
    @RequestMapping("/user_manage")
    public ModelAndView user_manage(HttpServletRequest request,HttpServletResponse response)
    {
        return new ModelAndView("user_manage").addObject("users",new UserDAO().list());
    }

    //封禁用户管理
    @RequestMapping("/ban_user_manage")
    public ModelAndView ban_user_manage(HttpServletRequest request,HttpServletResponse response)
    {
        return new ModelAndView("ban_user_manage").addObject("ban_users",new Ban_UserDAO().list());
    }

    //图书管理
    @RequestMapping("/book_manage")
    public ModelAndView book_manage(HttpServletRequest request,HttpServletResponse response)
    {
        return new ModelAndView("book_manage").addObject("books",new BookDAO().list());
    }

    //图书类型管理
    @RequestMapping("/category_manage")
    public ModelAndView category_manage(HttpServletRequest request,HttpServletResponse response)
    {
        return new ModelAndView("category_manage").addObject("categories",new CategoryDAO().list());
    }

    //订单查询
    @RequestMapping("/sold_book_manage")
    public ModelAndView sold_book_mange(HttpServletRequest request,HttpServletResponse response)
    {
        return new ModelAndView("sold_book_manage").addObject("sold_books",new Sold_BookDAO().list());
    }

    @RequestMapping("/manager_search")
    public ModelAndView manager_search(HttpServletRequest request,HttpServletResponse response)
    {
        String name = request.getParameter("name");
        String hidden = request.getParameter("hidden");

        //user页面
        if(hidden.equals("user"))
        {
            if(name.equals("") || name == null)
            {
                return new ModelAndView("user_manage").addObject("users",new UserDAO().list());
            }
            else
            {
                List<User> users = new UserDAO().list();
                for(Iterator<User> iterator = users.iterator(); iterator.hasNext();)
                {
                    User user = iterator.next();
                    if(user.getName().contains(name))
                        continue;
                    else
                        iterator.remove();
                }
                return new ModelAndView("user_manage").addObject("users",users);
            }
        }
        //ban_user界面
        else if(hidden.equals("ban_user"))
        {
            if(name.equals("") || name == null)
            {
                return new ModelAndView("ban_user_manage").addObject("ban_users",new Ban_UserDAO().list());
            }
            else
            {
                List<Ban_user> ban_users = new Ban_UserDAO().list();
                for(Iterator<Ban_user> iterator = ban_users.iterator();iterator.hasNext();)
                {
                    Ban_user ban_user = iterator.next();
                    if(ban_user.getName().contains(name))
                        continue;
                    else
                        iterator.remove();
                }
                return new ModelAndView("ban_user_manage").addObject("ban_users",ban_users);
            }
        }
        //book界面
        else if(hidden.equals("book"))
        {
            if(name.equals("") || name == null)
            {
                return new ModelAndView("book_manage").addObject("books",new BookDAO().list());
            }
            else
            {
                List<Book> books = new BookDAO().list();
                for(Iterator<Book> iterator = books.iterator();iterator.hasNext();)
                {
                    Book book = iterator.next();
                    if(book.getName().contains(name))
                        continue;
                    else
                        iterator.remove();
                }
                return new ModelAndView("book_manage").addObject("books",books);
            }
        }
        //category界面
        else if(hidden.equals("category"))
        {
            if(name.equals("") || name == null)
            {
                return new ModelAndView("category_manage").addObject("categories",new CategoryDAO().list());
            }
            else
            {
                List<Category> categories = new CategoryDAO().list();
                for(Iterator<Category> iterator = categories.iterator();iterator.hasNext();)
                {
                    Category category = iterator.next();
                    if(category.getName().contains(name))
                        continue;
                    else
                        iterator.remove();
                }
                return new ModelAndView("category_manage").addObject("categories",categories);
            }
        }
        //sold_book界面
        else if(hidden.equals("sold_book"))
        {
            if(name.equals("") || name == null)
            {
                return new ModelAndView("sold_book_manage").addObject("sold_books",new Sold_BookDAO().list());
            }
            else
            {
                List<Sold_book> sold_books = new Sold_BookDAO().list();
                for(Iterator<Sold_book> iterator = sold_books.iterator();iterator.hasNext();)
                {
                    Sold_book sold_book = iterator.next();
                    if(sold_book.getName().contains(name))
                        continue;
                    else
                        iterator.remove();
                }
                return new ModelAndView("sold_book_manage").addObject("sold_books",sold_books);
            }
        }
        //其他
        else
        {
            return new ModelAndView("control_page");
        }
    }

    //封禁用户
    @RequestMapping("/ban_user")
    public ModelAndView ban_user(HttpServletRequest request,HttpServletResponse response)
    {
        //先跳转 待加上原因
        ModelAndView mav = new ModelAndView("ban_user");
        User user = new UserDAO().getCurrentUser(Integer.parseInt(request.getParameter("id")));
        mav.addObject("user",user);
        return mav;
    }

    //提交封禁用户
    @RequestMapping("submit_ban_user")
    public ModelAndView submit_ban_user(HttpServletRequest request,HttpServletResponse response) {
        //从user表删除，加上时间、原因与管理员信息 并加入ban_user表
        User user = new UserDAO().getCurrentUser(Integer.parseInt(request.getParameter("id")));
        if(user != null) {
            Ban_user ban_user = new Ban_user(user);
            ban_user.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
            ban_user.setManager(((Manager) request.getSession().getAttribute("manager")).getName());
            ban_user.setReason(request.getParameter("reason"));
            new Ban_UserDAO().add(ban_user);
            new UserDAO().delete(user.getName());
        }
        ModelAndView mav = new ModelAndView("control_page");
        mav.addObject("users", new UserDAO().list());
        mav.addObject("ban_users", new Ban_UserDAO().list());
        mav.addObject("books", new BookDAO().list());
        mav.addObject("categories", new CategoryDAO().list());
        mav.addObject("sold_books",new Sold_BookDAO().list());
        return mav;
    }

    //解封用户
    @RequestMapping("/unban_user")
    public ModelAndView unban_user(HttpServletRequest request,HttpServletResponse response)
    {
//        从ban_user表删除 加入user表
        Ban_user ban_user = new Ban_UserDAO().get(Integer.parseInt(request.getParameter("id")));
        if(ban_user != null) {
            new UserDAO().add(ban_user);
            new Ban_UserDAO().delete(Integer.parseInt(request.getParameter("id")));
        }
        ModelAndView mav = new ModelAndView("control_page");
        mav.addObject("users", new UserDAO().list());
        mav.addObject("ban_users", new Ban_UserDAO().list());
        mav.addObject("books", new BookDAO().list());
        mav.addObject("categories", new CategoryDAO().list());
        mav.addObject("sold_books",new Sold_BookDAO().list());
        return mav;
    }

    //下架图书
    @RequestMapping("delete_book")
    public ModelAndView delete_book(HttpServletRequest request,HttpServletResponse response)
    {
        new BookDAO().delete(Integer.parseInt(request.getParameter("id")));
        ModelAndView mav = new ModelAndView("control_page");
        mav.addObject("users", new UserDAO().list());
        mav.addObject("ban_users", new Ban_UserDAO().list());
        mav.addObject("books", new BookDAO().list());
        mav.addObject("categories", new CategoryDAO().list());
        mav.addObject("sold_books",new Sold_BookDAO().list());
        return mav;
    }

    //增加图书类型
    @RequestMapping("add_category")
    public ModelAndView add_category(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView mav = new ModelAndView("/add_category");
        return mav;
    }

    //提交增加图书类型
    @RequestMapping("submit_add_category")
    public ModelAndView submit_add_caetgory(HttpServletRequest request,HttpServletResponse response)
    {
        Category category = new Category();
        category.setName(request.getParameter("name"));
        category.setChinese(request.getParameter("chinese"));
        new CategoryDAO().add(category);
        ModelAndView mav = new ModelAndView("control_page");
        mav.addObject("users", new UserDAO().list());
        mav.addObject("ban_users", new Ban_UserDAO().list());
        mav.addObject("books", new BookDAO().list());
        mav.addObject("categories", new CategoryDAO().list());
        mav.addObject("sold_books",new Sold_BookDAO().list());
        return mav;
    }

    @RequestMapping("manager_personal_page")
    public ModelAndView manager_personal_page(HttpServletRequest request,HttpServletResponse response)
    {
        return new ModelAndView("/manager_personal_page");
    }

//    首页按钮跳转
    @RequestMapping("control_page")
    public ModelAndView control_page(HttpServletRequest request,HttpServletResponse response)
    {
        //request.getSession().setAttribute("manager", new ManagerDAO().getManager(request.getParameter("name")));
        ModelAndView mav = new ModelAndView("control_page");
        mav.addObject("users",new UserDAO().list());
        mav.addObject("ban_users",new Ban_UserDAO().list());
        mav.addObject("books",new BookDAO().list());
        mav.addObject("categories",new CategoryDAO().list());
        mav.addObject("sold_books",new Sold_BookDAO().list());
        return mav;
    }
}
