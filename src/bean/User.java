package bean;

import java.util.List;

public class User
{
    //property
    private int id;
    private String name;
    private String school;
    private long number;
    private List<Book> bought;
    private List<Book> sold;
    private String password;
    private String address;
    private int phone_number;

    //Get and Set
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getSchool()
    {
        return this.school;
    }
    public void setSchool(String school)
    {
        this.school = school;
    }
    public long getNumber()
    {
        return this.number;
    }
    public void setNumber(long number)
    {
        this.number = number;
    }
    public List<Book> getBought()
    {
        return this.bought;
    }
    public void setBought(List<Book> bought)
    {
        this.bought = bought;
    }
    public List<Book> getSold()
    {
        return this.sold;
    }
    public void setSold(List<Book> sold)
    {
        this.sold = sold;
    }
    public String getPassword()
    {
        return this.password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public int getPhone_number()
    {
        return phone_number;
    }
    public void setPhone_number(int phone_number)
    {
        this.phone_number = phone_number;
    }

}
