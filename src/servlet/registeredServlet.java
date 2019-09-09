package servlet;

import DAO.UserDAO;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registeredServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String school = request.getParameter("school");
        //使用了getLong方法
        long number = Long.parseLong(request.getParameter("number"));
        //Long number = Long.getLong(request.getParameter("number"));
        String address = request.getParameter("address");
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));
        User user = new User();
        user.setName(name);
        user.setPhone_number(phone_number);
        user.setAddress(address);
        user.setPassword(password);
        user.setSchool(school);
        user.setNumber(number);
        new UserDAO().Add(user);
        //request.getRequestDispatcher("jump.html").forward(request,response);
        response.sendRedirect("jump.html");
    }
}
