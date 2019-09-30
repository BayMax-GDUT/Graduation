package DAO;

import bean.Book;
import bean.Category;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends BaseDAO
{
    public BookDAO()
    {
        super();
    }
    public void Add(Book book) {
        String sql = "insert into book(id,name,publisher,image_path,category_id,seller_id,price) " +
                "values(null,?,?,?,?,?,?)";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, book.getName());
            ps.setString(2, book.getPublisher());
            ps.setString(3, book.getImage_path());
            ps.setInt(4, book.getCategory_id());
            ps.setInt(5,book.getSeller_id());
            ps.setFloat(6,book.getPrice());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update(Book book) {
        String sql = "update table book set name = ?,publisher = ?,image_path = ?,category_id = ?,seller_id = ? price = ? where id = ?";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(5, book.getSeller_id());
            ps.setInt(4, book.getCategory_id());
            ps.setString(1, book.getName());
            ps.setString(2, book.getPublisher());
            ps.setString(3, book.getImage_path());
            ps.setFloat(6,book.getPrice());
            ps.setInt(7, book.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "delete from book where id = ?";
        try (Connection c = GetConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public Book get(String name)
//    {
//        try(Connection c = GetConnection();
//            Statement s = c.createStatement())
//        {
//            String sql = "select * from user where name = " + name;
//            ResultSet rs = s.executeQuery(sql);
//            Book book = new Book();
//            book.id
//        }
//        catch(SQLException e)
//        {
//            e.printStackTrace();
//            return null;
//        }
//    }
    //所有图书全部展示
    public List<Book> list() {
        List<Book> list = new ArrayList<>();
        String sql = "select * from book";
        try(Connection c = GetConnection();
            Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            while(rs.next())
            {
                Book book = new Book();
                book.setSeller_id(rs.getInt("seller_id"));
                if(book.getSeller() == null || book.getSeller() == "")
                    continue;
                book.setPublisher(rs.getString("publisher"));
                book.setName(rs.getString("name"));
                book.setImage_path(rs.getString("image_path"));
                book.setId(rs.getInt("id"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setPrice(rs.getFloat("price"));
                list.add(book);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //特定名字(图书名字)的所有图书
    public List<Book> list(String name)
    {
        return list(name,0,Short.MAX_VALUE);
    }

    //特定名字的、指定数量的图书
    public List<Book> list(String name,int start,int count) {
        List<Book> list = new ArrayList<>();
        String sql = "select * from Book where name = ? order by id desc limit ?,?";
        try(Connection c = GetConnection();
            PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1,name);
            ps.setInt(2, start);
            ps.setInt(3, count);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Book book = new Book();
                book.setCategory_id(rs.getInt("category_id"));
                book.setId(rs.getInt("id"));
                book.setImage_path(rs.getString("image_path"));
                book.setName(rs.getString("name"));
                book.setPublisher(rs.getString("publisher"));
                book.setSeller_id(rs.getInt("seller_id"));
                if(book.getSeller() == "" || book.getSeller() == null)
                    continue;
                book.setPrice(rs.getFloat("price"));
                list.add(book);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //根据用户名搜索其出售的所有图书
    public List<Book> personalBook(String name) {
        int userId = nameToId(name);
        if(userId == 0)return null;

        String sql = "select * from book where seller_id = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            List<Book> books = new ArrayList<>();
            while(rs.next())
            {
                Book book = new Book();
                book.setSeller_id(rs.getInt("seller_id"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setPrice(rs.getFloat("price"));
                book.setImage_path(rs.getString("image_path"));
                book.setPublisher(rs.getString("publisher"));
                book.setName(rs.getString("name"));
                book.setId(rs.getInt("id"));
                books.add(book);
            }
            return books;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //根据用户名搜索其User.Id
    public int nameToId(String name) {
        String sql = "select id from user where name = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return rs.getInt("id");
            }
            return 0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    //根据id搜索图书
    public Book IdGetBook(int id) {
        String sql = "select * from book where id = ?";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Book book = new Book();
                book.setId(id);
                book.setName(rs.getString("name"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getFloat("price"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setSeller_id(rs.getInt("seller_id"));
                book.setImage_path(rs.getString("image_path"));
                return book;
            }
            return null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /*
     *特定卖家id出售的图书
     */
    public List<Book> get_book(int UserId){
        List<Book> list = new ArrayList<>();
        String sql = "select * from book where seller_id = ?";
        try(Connection c = GetConnection())
        {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,UserId);
            c.setAutoCommit(false);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Book book = new Book();
                book.setSeller_id(rs.getInt("seller_id"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setPrice(rs.getFloat("price"));
                book.setImage_path(rs.getString("image_path"));
                book.setPublisher(rs.getString("publisher"));
                book.setName(rs.getString("name"));
                book.setId(rs.getInt("id"));
                list.add(book);
            }
            PreparedStatement ps1 = c.prepareStatement("delete from book where seller_id = " + UserId);
            ps1.execute();
            c.commit();
            c.setAutoCommit(true);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public void put_ban_book(List<Book> books){
        String sql = "insert into ban_book values(?,?,?,?,?,?,?)";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            for(Book book:books)
            {
                ps.setInt(1,book.getId());
                ps.setString(2,book.getName());
                ps.setString(3,book.getPublisher());
                ps.setString(4,book.getImage_path());
                ps.setInt(5,book.getCategory_id());
                ps.setInt(6,book.getSeller_id());
                ps.setFloat(7,book.getPrice());
                ps.execute();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Book> get_ban_book(int UserId) {
        List<Book> list = new ArrayList<>();
        String sql = "select * from ban_book where seller_id = " + UserId;
        try(Connection c = GetConnection()
        ) {
            PreparedStatement ps = c.prepareStatement(sql);
            //添加事务，两个sql语句都成功才执行，否则都不执行
            c.setAutoCommit(false);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setImage_path(rs.getString("image_path"));
                book.setSeller_id(UserId);
                book.setCategory_id(rs.getInt("category_id"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getFloat("price"));
                list.add(book);
            }
            //获取完之后进行删除
            PreparedStatement ps1 = c.prepareStatement("delete from ban_book where seller_id = " + UserId);
            ps1.execute();
            c.commit();
            ps.close();
            ps1.close();
            c.setAutoCommit(true);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            return list;
        }
    }

    public void put_book(List<Book> books){
        String sql = "insert into book values(?,?,?,?,?,?,?)";
        try(Connection c = GetConnection();
        PreparedStatement ps = c.prepareStatement(sql))
        {
            for(Book book:books)
            {
                ps.setInt(1,book.getId());
                ps.setString(2,book.getName());
                ps.setString(3,book.getPublisher());
                ps.setString(4,book.getImage_path());
                ps.setInt(5,book.getCategory_id());
                ps.setInt(6,book.getSeller_id());
                ps.setFloat(7,book.getPrice());
                ps.execute();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
