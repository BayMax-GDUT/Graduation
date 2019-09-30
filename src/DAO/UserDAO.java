package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Ban_user;
import bean.User;
import com.sun.xml.internal.ws.util.xml.XMLReaderComposite;

public class UserDAO extends BaseDAO {
    public UserDAO() {
        super();
    }

    public void Add(User user) {
        String sql = "insert into user(id,name,school,number,password,address,phone_number) " +
                "values(null,?,?,?,?,?,?)";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSchool());
            ps.setLong(3, user.getNumber());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getPhone_number());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //更改参数 只使用密码、地址、电话号码三个参数进行用户更新
    public void Update(String name,String password,String address,int phone_number) {
        String sql = "update user set password = ? ,address = ? ,phone_number = ? where name = ?";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,password);
            ps.setString(2,address);
            ps.setInt(3,phone_number);
            ps.setString(4,name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String name) {
        String sql = "delete from user where name = ?";
        try(Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,name);
            ps.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String sql = "delete from user where id = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public int getId(String name) {
        String sql = "select id from user where name = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("id");
                return id;
            }
            return 0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public List<User> list()
    {
        return list(0,Short.MAX_VALUE);
    }

    public List<User> list(int start,int count) {
        List<User> list = new ArrayList<>();
        String sql = "select * from user order by id desc limit ?,?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setPhone_number(rs.getInt("phone_number"));
                user.setAddress(rs.getString("address"));
                user.setId(rs.getInt("id"));
                user.setNumber(rs.getLong("number"));
                user.setPassword(rs.getString("password"));
                user.setSchool(rs.getString("school"));
                list.add(user);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public User login(String name,String password) {
        String sql = "select * from user where name = ? and password = ?";
        try(Connection c = GetConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        )
        {
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                User user = new User();
                user.setName(name);
                user.setSchool(rs.getString("school"));
                user.setPassword(password);
                user.setPhone_number(rs.getInt("phone_number"));
                user.setNumber(rs.getLong("number"));
                user.setId(rs.getInt("id"));
                user.setAddress(rs.getString("address"));
                return user;
            }
            return null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }

    }

    public boolean login(User user) {
        String sql = "select * from user where name = ? and password = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2,user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {

                return true;
            }
            else
                return false;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }


    public String getPassword(String name) {
        String sql = "select * from user where name = " + name;
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return rs.getString("password");
            }
            return null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void AddLoginUser(String name) {

        //1.userDAO对象问题
        //2.获取到的user对象问题


        String sql = "insert into currentUser values(?,?)";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(2,name);
            ps.setInt(1,this.getId(name));

            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void RemoveLoginUser(String name) {
        String sql = "delete from current where name = " + name;
        try(Connection c = GetConnection();
        Statement s = c.createStatement())
        {
            s.execute(sql);

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void RemoveLoginUser(int id) {
        String sql = "delete from currentUser where id = " + id;
        try(Connection c = GetConnection();
        Statement s = c.createStatement())
        {
            s.execute(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void RemoveLoginUser() {
        String sql = "delete from currentUser where id >= 0";
        try(Connection c = GetConnection();
        Statement s =c.createStatement())
        {
            s.execute(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public String idToName(int id) {
        String sql = "select * from user where id = " + id;
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return rs.getString("name");
            }
            return null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public User getCurrentUser(String name) {
        String sql = "select * from user where name = ?";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhone_number(rs.getInt("phone_number"));
                user.setAddress(rs.getString("address"));
                user.setSchool(rs.getString("school"));
                user.setNumber(rs.getLong("number"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            return null;
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public User getCurrentUser(int id){
        String sql = "select * from user where id = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSchool(rs.getString("school"));
                user.setNumber(rs.getLong("number"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setPhone_number(rs.getInt("phone_number"));
                return user;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void add(Ban_user ban_user){
        String sql = "insert into user(id,name,school,number,password,address,phone_number) " +
                "values(?,?,?,?,?,?,?)";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1,ban_user.getId());
            ps.setString(2, ban_user.getName());
            ps.setString(3, ban_user.getSchool());
            ps.setLong(4, ban_user.getNumber());
            ps.setString(5, ban_user.getPassword());
            ps.setString(6, ban_user.getAddress());
            ps.setInt(7, ban_user.getPhone_number());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*查询是否存在此用户
        若未存在则报错
        若存在则查看密码是否正确
    */




/*
    //通过构造函数创建数据库驱动
    public UserDAO()
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

    //获取连接
    public Connection getConnection()throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop?CharacterEncoding=utf-8","root","liziyang");
    }

    public boolean isExist(String name)
    {
        try(Connection c = this.getConnection(); Statement s = c.createStatement())
        {
            String sql = "SELECT * FROM USER WHERE NAME = " + name;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next())
            {
                    return true;
            }
            return false;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public User getUser(String name,String password)
    {
        if(!isExist(name))
        {
            return null;
        }
        else
        {
            try(Connection c = getConnection();
                Statement s = c.createStatement()
            )
            {
                String sql = "select * from user where name = " + name;
                ResultSet rs = s.executeQuery(sql);
                if(rs.getString("password").equals(password))
                {
                    User user = new User();
                    user.setBought(rs.getInt("bought"));
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setNumber(rs.getLong("number"));
                    user.setPassword(rs.getString("password"));
                    user.setSchool(rs.getString("school"));
                    user.setSold(rs.getInt("sold"));
                    return user;
                }
                else
                    return null;
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    */
}

