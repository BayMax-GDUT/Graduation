package controller;

import DAO.CategoryDAO;
import DAO.UserDAO;
import DAO.BookDAO;
import bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class bookController {

    @RequestMapping("/visitor_list")
    public ModelAndView visitor_list(HttpServletRequest request,HttpServletResponse response)
    {
        request.getSession().removeAttribute("name");
        List<Book> books = new BookDAO().list();
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("books",books);
        return mav;
    }

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav;
            List<Book> books = new BookDAO().list();
            mav = new ModelAndView("list");
            mav.addObject("books",books);
        return mav;
    }

    @RequestMapping("/submit_add_book")
    public ModelAndView submit_add_book(HttpServletRequest request,HttpServletResponse response) {

        String name = request.getParameter("name");
        String publisher = request.getParameter("publisher");
        String priceStr = request.getParameter("price");
        String category_idStr = request.getParameter("category_id");
        String Username = (String) request.getSession().getAttribute("name");
        int seller_id = new UserDAO().getId(Username);
        if( null != name && null != publisher && null != priceStr && null != category_idStr)
        {
            Book book = new Book();
            book.setName(name);
            book.setPublisher(publisher);
            book.setPrice(Float.parseFloat(priceStr));
            book.setCategory_id(Integer.parseInt(category_idStr));
            //获取当前用户
            //book.setSeller_id(new UserDAO().getCurrentUser().getId());
            book.setSeller_id(seller_id);
            new BookDAO().Add(book);
            ModelAndView mav = new ModelAndView("jump");
            mav.addObject("message","上传成功");
            return mav;
        }
        else {
            ModelAndView mav = new ModelAndView("add_book");
            mav.addObject("message","信息填写不完整，请重新填写");
            return mav;
        }
    }

    @RequestMapping("/add_book")
    public ModelAndView add_book(HttpServletRequest request, HttpServletResponse response)
    {
        if(request.getSession().getAttribute("name") == null)
        {
            //弹出提示框提示需要登录 点击确认后跳转到登录界面

        }
        ModelAndView mav = new ModelAndView("add_book");
        return mav;
    }



    @RequestMapping("/delete_book")
    public ModelAndView deleteBook(HttpServletRequest request,HttpServletResponse response)
    {
        int id = Integer.parseInt(request.getParameter("id"));
        new BookDAO().delete(id);
        List<Book> books = new BookDAO().personalBook((String) request.getSession().getAttribute("name"));
        ModelAndView mav = new ModelAndView("personal_page");
        mav.addObject("books",books);
        return mav;
    }

    @RequestMapping("/buy_book")
    public ModelAndView buy_book(HttpServletRequest request,HttpServletResponse response)
    {
        Book book = new BookDAO().IdGetBook(Integer.parseInt(request.getParameter("id")));
        String category = new CategoryDAO().getCategoryName(book.getId());
        String seller = new UserDAO().idToName(book.getId());
        ModelAndView mav = new ModelAndView("/pay");
        mav.addObject("book",book);
        mav.addObject("category",category);
        mav.addObject("seller",seller);
        return mav;
    }
}
