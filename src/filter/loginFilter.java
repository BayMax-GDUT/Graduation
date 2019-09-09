package filter;

import DAO.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;
import java.io.IOException;

public class loginFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String uri = request.getRequestURI();
        if(uri.endsWith("/") || uri.endsWith("/login"))
        {
            filterChain.doFilter(request,response);
            return;
        }
        String name = request.getSession().getAttribute("name").toString();
        String password = request.getSession().getAttribute("password").toString();

        //判断是否名字非空且密码与数据库中一样
        if(null == name)
        {
            response.sendRedirect("/");
            return;
        }
        else if(!password.equals(new UserDAO().getPassword(name)))
        {
            response.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
