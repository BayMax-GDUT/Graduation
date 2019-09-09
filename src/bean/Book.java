package bean;

import DAO.*;

public class Book
{
    //字段
    private int id;
    private String name;
    private String publisher;
    private int seller_id;
    private String image_path;
    private int category_id;
    private float price;
    public String category;
    public String seller;

    //get and set
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    public int getSeller_id()
    {
        return seller_id;
    }
    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
        this.seller = new UserDAO().idToName(seller_id);
    }
    public String getSeller(){return seller;}
    public String getImage_path()
    {
        return image_path;
    }
    public void setImage_path(String image_path)
    {
        this.image_path = image_path;
    }
    public int getCategory_id()
    {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
        this.category = new CategoryDAO().idToName(category_id);
    }
    public String getCategory(){return category;}
    public float getPrice(){return price;}
    public void setPrice(float price){this.price = price;}
}
