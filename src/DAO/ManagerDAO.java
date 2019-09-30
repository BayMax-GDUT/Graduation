package DAO;

import bean.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO extends BaseDAO{

    public ManagerDAO(){super();}

    public void add(Manager manager) {
        String sql = "insert into manager values(null,?,?,?,?)";
        try(Connection c = GetConnection();
            PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1,manager.getName());
            ps.setString(2,manager.getPassword());
            ps.setString(3,manager.getE_mail_address());
            ps.setInt(4,manager.getPhone_number());
            ps.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(String name){

        String sql = "delete from manager where name = " + name;
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Manager manager){

        String sql = "update manager set password = ? e_mail_address = ? phone_number = ? where name = ?";
        try(Connection c = GetConnection();
            PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1,manager.getPassword());
            ps.setString(2,manager.getE_mail_address());
            ps.setInt(3,manager.getPhone_number());
            ps.setString(4,manager.getName());
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public boolean login(String name,String password){

        String sql = "select * from manager where name = ? and password = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public List<Manager> list(){
        List<Manager> list = new ArrayList<>();
        String sql = "select * from manager";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Manager manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setName(rs.getString("name"));
                manager.setPassword(rs.getString("password"));
                manager.setE_mail_address(rs.getString("e_mail_address"));
                manager.setPhone_number(rs.getInt("phone_number"));
                list.add(manager);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Manager getManager(String name) {
        String sql = "select * from manager where name = ?";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Manager manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setName(rs.getString("name"));
                manager.setPassword(rs.getString("password"));
                manager.setE_mail_address(rs.getString("e_mail_address"));
                manager.setPhone_number(rs.getInt("phone_number"));
                return manager;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();

        }
        return null;
    }


}
