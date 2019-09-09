package controller;

import DAO.BookDAO;
import DAO.UserDAO;
import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class loginController
{
    @RequestMapping("/submit_login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
    {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        boolean b = new UserDAO().login(user);
        ModelAndView mav;
        if(b) {
            //使用表中插入临时数据的方法
            //new UserDAO().AddLoginUser(user.getName());


            //使用session登陆的方法
            request.getSession().setAttribute("name", user.getName());
            mav = new ModelAndView("list");
            mav.addObject("books",new BookDAO().list());
        }
        else
        {
            mav = new ModelAndView("login");
            if(user != null)
                mav.addObject("message","账号或密码错误，请重新输入");
        }

        return mav;
    }

    //首页 登陆
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView indexShow(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException
    {
        //new UserDAO().RemoveLoginUser();
        ModelAndView mav = new ModelAndView("login");
        return mav;

        //通过此语句访问登陆与注册界面（html） 其他页面使用jsp，添加拦截器验证是否有登陆
//        request.getRequestDispatcher("login.html").forward(request,response);



    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response)
    {
        request.getSession().removeAttribute("name");
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

}
