package controller;

import DAO.CategoryDAO;
import DAO.Sold_BookDAO;
import DAO.UserDAO;
import DAO.BookDAO;
import bean.Book;
import bean.Category;
import bean.Manager;
import bean.Sold_book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

@Controller
public class bookController {

    @RequestMapping("/visitor_list")
    public ModelAndView visitor_list(HttpServletRequest request,HttpServletResponse response)
    {
        request.getSession().removeAttribute("name");
        request.getSession().setAttribute("name", null);
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

    @RequestMapping("/search")
    public ModelAndView search(HttpServletRequest request,HttpServletResponse response) {
        String name = request.getParameter("name");
        if(name.equals("") || name == null)
        {
            List<Book> books = new BookDAO().list();
            ModelAndView mav = new ModelAndView("list");
            mav.addObject("books",books);
            return mav;
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
            ModelAndView mav = new ModelAndView("list");
            mav.addObject("books",books);
            return mav;
        }
    }

    @RequestMapping("/submit_add_book")
    public ModelAndView submit_add_book(HttpServletRequest request,HttpServletResponse response) {

        String name = request.getParameter("name");
        String publisher = request.getParameter("publisher");
        String priceStr = request.getParameter("price");
        String category_idStr = request.getParameter("category_id");
        String Username = (String) request.getSession().getAttribute("name");
        if( null != name && null != publisher && null != priceStr && null != category_idStr)
        {
            Book book = new Book();
            book.setName(name);
            book.setPublisher(publisher);
            book.setPrice(Float.parseFloat(priceStr));
            book.setCategory_id(Integer.parseInt(category_idStr));
            //获取当前用户
            //book.setSeller_id(new UserDAO().getCurrentUser().getId());
            book.setSeller_id(new UserDAO().getId(Username));
            new BookDAO().Add(book);
            ModelAndView mav = new ModelAndView("add_book_jump");
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
    public ModelAndView add_book(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categories = new CategoryDAO().list();
        ModelAndView mav = new ModelAndView("add_book");
        mav.addObject("categories",categories);
        return mav;
    }

    @RequestMapping("/unsell_book")
    public ModelAndView unsell_book(HttpServletRequest request,HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        new BookDAO().delete(id);
        List<Book> books = new BookDAO().personalBook((String) request.getSession().getAttribute("name"));
        List<Sold_book> finish = new Sold_BookDAO().list(new UserDAO().getId((String)request.getSession().getAttribute("name")));
        ModelAndView mav = new ModelAndView("personal_page");
        mav.addObject("books",books);
        mav.addObject("finishs",finish);
        return mav;
    }

    @RequestMapping("/buy_book")
    public ModelAndView buy_book(HttpServletRequest request,HttpServletResponse response) {
        Book book = new BookDAO().IdGetBook(Integer.parseInt(request.getParameter("id")));
        ModelAndView mav = new ModelAndView("pay");
        mav.addObject("book",book);
        return mav;
    }

    @RequestMapping("/paid")
    public ModelAndView paid(HttpServletRequest request,HttpServletResponse response) {
        //生成订单
        int bookId = Integer.parseInt(request.getParameter("id"));
        Book book = new BookDAO().IdGetBook(bookId);
        String receiver_name = request.getParameter("receiver_name");
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));
        String address = request.getParameter("address");
        Sold_book sold_book = new Sold_book();
        sold_book.setName(book.getName());
        sold_book.setId(book.getId());
        sold_book.setPublisher(book.getPublisher());
        sold_book.setPrice(book.getPrice());
        sold_book.setCategory_id(book.getCategory_id());
        sold_book.setSeller_id(book.getSeller_id());
        sold_book.setBuyer_id(new UserDAO().getId((String) request.getSession().getAttribute("name")));
        sold_book.setImage_path(book.getImage_path());
        sold_book.setReceiver_name(receiver_name);
        sold_book.setAddress(address);
        sold_book.setPhone_number(phone_number);
        new Sold_BookDAO().Add(sold_book);
        new BookDAO().delete(bookId);

        ModelAndView mav = new ModelAndView("paid");
        mav.addObject("sold_book",sold_book);
        return mav;
    }
}
