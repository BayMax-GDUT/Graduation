package DAO;

import bean.Category;
import bean.Sold_book;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Sold_BookDAO extends BaseDAO
{
    public Sold_BookDAO()
    {
        super();
    }

    public void Add(Sold_book sold_book) {
        String sql = "insert into sold_book(id,name,publisher,image_path,category_id,seller_id,buyer_id,price)" +
                " values(?,?,?,?,?,?,?,?)";
        try(Connection c = GetConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,sold_book.getId());
            ps.setString(2,sold_book.getName());
            ps.setString(3,sold_book.getPublisher());
            ps.setString(4,sold_book.getImage_path());
            ps.setInt(5,sold_book.getCategory_id());
            ps.setInt(6,sold_book.getSeller_id());
            ps.setInt(7,sold_book.getBuyer_id());
            ps.setFloat(8,sold_book.getPrice());
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "delete from sold_book where id = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setInt(1,id);
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Sold_book sold_book) {
        String sql = "update sold_book set name = ?,publisher = ?,image_path = ?,category_id = ?," +
                "seller_id = ?,buyer_id = ?,price = ? where id = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1,sold_book.getName());
            ps.setString(2,sold_book.getPublisher());
            ps.setString(3,sold_book.getImage_path());
            ps.setInt(4, sold_book.getCategory_id());
            ps.setInt(5,sold_book.getSeller_id() );
            ps.setInt(6,sold_book.getBuyer_id() );
            ps.setFloat(7,sold_book.getPrice());
            ps.setInt(8,sold_book.getId());
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Sold_book> list() {
        List<Sold_book> list = new ArrayList<>();
        String sql = "select * from sold_book";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Sold_book sold_book = new Sold_book();
                sold_book.setId(rs.getInt("id"));
                sold_book.setName(rs.getString("name"));
                sold_book.setPublisher(rs.getString("publisher"));
                sold_book.setImage_path(rs.getString("image_path"));
                sold_book.setCategory_id(rs.getInt("category_id"));
                sold_book.setSeller_id(rs.getInt("seller_id"));
                sold_book.setBuyer_id(rs.getInt("buyer_id"));
                sold_book.setPrice(rs.getFloat("price"));
                list.add(sold_book);
            }
            return list;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return list;
        }
    }

    public List<Sold_book> listFinish(int id){

        List<Sold_book> finish = new ArrayList<>();
        String sql = "select * from sold_book where seller_id = ? or buyer_id = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setInt(1,id);
            ps.setInt(2,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Sold_book sold_book = new Sold_book();
                sold_book.setId(rs.getInt("id"));
                sold_book.setName(rs.getString("name"));
                sold_book.setPublisher(rs.getString("publisher"));
                sold_book.setImage_path(rs.getString("image_path"));
                sold_book.setCategory_id(rs.getInt("category_id"));
                sold_book.setSeller_id(rs.getInt("seller_id"));
                sold_book.setBuyer_id(rs.getInt("buyer_id"));
                sold_book.setPrice(rs.getFloat("price"));
                finish.add(sold_book);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return finish;
    }
    }
