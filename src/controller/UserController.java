package controller;

import DAO.Ban_UserDAO;
import DAO.BookDAO;
import DAO.Sold_BookDAO;
import DAO.UserDAO;
import bean.Ban_user;
import bean.Book;
import bean.Sold_book;
import bean.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/submit_add_user")
    public ModelAndView submit_add_user(
            @RequestParam("name")String name,
            @RequestParam("password")String password,
            @RequestParam("school")String school,
            @RequestParam("number")String number,
            @RequestParam("address")String address,
            @RequestParam("phone_number")String phone_number,
            HttpServletRequest request
    ) {
        if(null != name && null != password && null != school && null != number && null != address && null != phone_number
         && "" != name && "" != password && "" != school && "" != number && "" != address && "" != phone_number
        )
        {
            //确认name属性的唯一性
            List<User> list1 = new UserDAO().list();
            List<Ban_user> list2 = new Ban_UserDAO().list();
            for(User user:list1)
            {
                if(user.getName().equals(name))
                {
                    ModelAndView mav = new ModelAndView("add_user");
//                    mav.addObject("message","此名字已被注册，请更换");
                    request.getSession().setAttribute("message", "此名字已被注册，请更换");
                    return mav;
                }
            }
            for(Ban_user ban_user:list2){
                if(ban_user.getName().equals(name))
                {
                    ModelAndView mav = new ModelAndView("add_user");
//                    mav.addObject("message","此名字已被注册，请更换");
                    request.getSession().setAttribute("message", "此名字已被注册，请更换");
                    return mav;
                }
            }
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setNumber(Long.parseLong(number));
            user.setSchool(school);
            user.setAddress(address);
            user.setPhone_number(Integer.parseInt(phone_number));
            new UserDAO().Add(user);
            ModelAndView mav = new ModelAndView("add_user_jump");
            mav.addObject("message","注册成功");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("add_user");
//            mav.addObject("message","注册失败，信息填写不完整，请重新填写");
            request.getSession().setAttribute("message", "注册失败，信息填写不完整，请重新填写");
            return mav;
        }
    }

    @RequestMapping("/add_user")
    public ModelAndView add_user() {
        ModelAndView mav = new ModelAndView("add_user");
        return mav;
    }

    @RequestMapping("/update_user")
    public ModelAndView update_user(HttpServletRequest request,HttpServletResponse response) {
        //从个人中心处修改个人信息
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));
        String name = (String)request.getSession().getAttribute("name");
        new UserDAO().Update(name,password,address,phone_number);
        List<Book> books = new BookDAO().personalBook((String) request.getSession().getAttribute("name"));
        List<Sold_book> finishs = new Sold_BookDAO().list(new UserDAO().getId((String) request.getSession().getAttribute("name")));
        ModelAndView mav = new ModelAndView("personal_page");
        mav.addObject("books",books);
        mav.addObject("finishs",finishs);
        return mav;
    }

    @RequestMapping("/personal_page")
    public ModelAndView personal_page(HttpServletRequest request, HttpServletResponse response) {
        String name = (String) request.getSession().getAttribute("name");
        //通过user名字将其正在出售的书查找出来
        List<Book> books = new BookDAO().personalBook(name);

        //通过id查找已完成订单
        int id = new UserDAO().getCurrentUser(name).getId();
        List<Sold_book> finish = new Sold_BookDAO().list(id);

        ModelAndView mav = new ModelAndView("personal_page");
        mav.addObject("books",books);
        mav.addObject("finishs",finish);
        return mav;
    }
}
