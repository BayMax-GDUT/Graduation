package DAO;

import bean.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends BaseDAO {
    public CategoryDAO()
    {
        super();
    }

    public void add(Category category) {
        String sql = "insert into category values(null,?)";
        try(Connection c = GetConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        )
        {
            ps.setString(1,category.getName());
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Category category,String oldName) {
        String sql = "update table category set name = ? where name = " + oldName;
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,category.getName());
            ps.execute();
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(String name) {
        String sql = "delete from category where name = " + name;
        try(Connection c =GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Category getCategory(String name) {
        String sql = "select * from category where name = " + name;
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(name);
                return category;
            }
            return null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String getCategoryName(int category_id) {
        String sql = "select * from category where id = ?";
        try(Connection c = GetConnection();
            PreparedStatement ps = c.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                String name = rs.getString("name");
                return name;
            }
            return null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Category> list()
    {
        return list(0,Short.MAX_VALUE);
    }
    public List<Category> list(int start,int count)
    {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Book order by id desc limit ?,?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Category category = new Category();
                category.setName(rs.getString("name"));
                category.setId(rs.getInt("id"));
                list.add(category);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String idToName(int id)
    {
        String sql = "select * from category where id = " + id;
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

}
