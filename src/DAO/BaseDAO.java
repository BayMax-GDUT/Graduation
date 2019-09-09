package DAO;

import java.sql.*;

public class BaseDAO {

    //连接数据库驱动初始化
    protected BaseDAO()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    protected Connection GetConnection()
    {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop?CharacterEncoding=utf-8","root","liziyang");
            return c;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
