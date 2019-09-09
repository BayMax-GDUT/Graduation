package bean;


import DAO.CategoryDAO;
import DAO.UserDAO;

public class Sold_book
{
    private int id;
    private String name;
    private String publisher;
    private String image_path;
    private int category_id;
    public String category;
    private int seller_id;
    public String seller;
    private int buyer_id;
    public String buyer;
    private float price;

    public int getId() {return id;}
    public void setId(int id) { this.id = id; }
    public String getName() {return name;}
    public void setName(String name){this.name = name;}
    public String getPublisher(){return publisher;}
    public void setPublisher(String publisher){this.publisher = publisher;}
    public String getImage_path(){return image_path;}
    public void setImage_path(String image_path){this.image_path = image_path;}
    public int getCategory_id(){return category_id;}
    public void setCategory_id(int category_id){this.category_id = category_id;
    this.category = new CategoryDAO().getCategoryName(category_id); }
    public int getSeller_id(){return seller_id;}
    public void setSeller_id(int seller_id){this.seller_id = seller_id;
    this.seller = new UserDAO().idToName(seller_id);}
    public int getBuyer_id(){return buyer_id;}
    public void setBuyer_id(int buyer_id){this.buyer_id = buyer_id;
    this.buyer = new UserDAO().idToName(buyer_id);}
    public float getPrice(){return price;}
    public void setPrice(float price){this.price = price;}
}
