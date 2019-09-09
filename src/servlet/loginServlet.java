package servlet;

import bean.*;
import DAO.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet
{
    protected void  doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new UserDAO().login(name,password);
        List<Book> book = new BookDAO().list();
        if(user != null)
        {
            request.setAttribute("books", book);
            request.getRequestDispatcher("list.jsp").forward(request,response);
        }
        else
            //弹出警告
        ;
    }
}
