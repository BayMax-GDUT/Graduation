package DAO;

import bean.Ban_user;
import bean.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ban_UserDAO extends BaseDAO{

    public Ban_UserDAO(){
        super();
    }

    public void add(Ban_user ban_user){
        String sql = "insert into ban_user values(?,?,?,?,?,?,?,?,?,?)";
        try(Connection c = GetConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1,ban_user.getId());
            ps.setString(2,ban_user.getName());
            ps.setString(3,ban_user.getSchool());
            ps.setLong(4,ban_user.getNumber());
            ps.setString(5,ban_user.getPassword());
            ps.setString(6,ban_user.getAddress());
            ps.setString(7,ban_user.getReason());
            ps.setInt(8,ban_user.getPhone_number());
            ps.setString(9,ban_user.getManager());
            ps.setString(10,ban_user.getDate());
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(String name){
        String sql = "delete from ban_user where name = " + name;
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)){
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String sql = "delete from ban_user where id = ?";
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

    public List<Ban_user> list() {
        List<Ban_user> list = new ArrayList<>();
        String sql = "select * from ban_user";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Ban_user ban_user = new Ban_user();
                ban_user.setId(rs.getInt("id"));
                ban_user.setName(rs.getString("name"));
                ban_user.setNumber(rs.getLong("number"));
                ban_user.setAddress(rs.getString("address"));
                ban_user.setPassword(rs.getString("password"));
                ban_user.setPhone_number(rs.getInt("phone_number"));
                ban_user.setSchool(rs.getString("school"));
                ban_user.setReason(rs.getString("reason"));
                ban_user.setManager(rs.getString("manager"));
                ban_user.setDate(rs.getString("date"));
                list.add(ban_user);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public Ban_user get(int id) {
        String sql = "select * from ban_user where id = ?";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Ban_user ban_user = new Ban_user();
                ban_user.setReason(rs.getString("reason"));
                ban_user.setManager(rs.getString("manager"));
                ban_user.setDate(rs.getString("date"));
                ban_user.setSchool(rs.getString("school"));
                ban_user.setPhone_number(rs.getInt("phone_number"));
                ban_user.setPassword(rs.getString("password"));
                ban_user.setAddress(rs.getString("address"));
                ban_user.setNumber(rs.getLong("number"));
                ban_user.setName(rs.getString("name"));
                ban_user.setId(rs.getInt("id"));
                return ban_user;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean login(String name,String password) {
        String sql = "select * from ban_user where name = ? and password = ?";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
