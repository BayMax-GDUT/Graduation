package bean;

import java.util.List;

public class Category {
    private int id;
    private String name;
    private String chinese;
    List<List<Book>> productByRow;
    Book book;

    public int getId() {
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



    public Book getBook()
    {
        return book;
    }
    public void setBook(Book book)
    {
        this.book = book;
    }

    public String getChinese() {
        return chinese;
    }
    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public List<List<Book>> getProductByRow()
    {
        return productByRow;
    }
    public void setProductByRow(List<List<Book>> productByRow)
    {
        this.productByRow = productByRow;
    }
}
