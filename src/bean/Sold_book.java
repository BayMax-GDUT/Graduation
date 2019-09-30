package bean;


import DAO.Ban_UserDAO;
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
    private String receiver_name;
    private String address;
    private int phone_number;
    private Category realCategory;

    public int getId() {return id;}
    public void setId(int id) { this.id = id; }
    public String getName() {return name;}
    public void setName(String name){this.name = name;}
    public String getPublisher(){return publisher;}
    public void setPublisher(String publisher){this.publisher = publisher;}
    public String getImage_path(){return image_path;}
    public void setImage_path(String image_path){this.image_path = image_path;}
    public int getCategory_id(){return category_id;}
    public void setCategory_id(int category_id){
        this.category_id = category_id;
        this.category = new CategoryDAO().idToChinese(category_id);
    }
    public String getCategory(){return this.category;}
    public int getSeller_id(){return seller_id;}
    public void setSeller_id(int seller_id){this.seller_id = seller_id;
    this.seller = new UserDAO().idToName(seller_id);
    if(this.seller == null)
    {
        this.seller = new Ban_UserDAO().get(seller_id).getName();
    }
    }
    public String getSeller(){return this.seller;}
    public int getBuyer_id(){return buyer_id;}
    public void setBuyer_id(int buyer_id){this.buyer_id = buyer_id;
    this.buyer = new UserDAO().idToName(buyer_id);
    if(this.buyer == null)
    {
        this.buyer = new Ban_UserDAO().get(buyer_id).getName();
    }
    }
    public String getBuyer(){return this.buyer;}
    public float getPrice(){return price;}
    public void setPrice(float price){this.price = price;}
    public String getReceiver_name() {
        return receiver_name;
    }
    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public Category getRealCategory() {
        return realCategory;
    }

    public void setRealCategory(Category realCategory) {
        this.realCategory = realCategory;
    }
}
