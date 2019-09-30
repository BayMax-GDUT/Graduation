package bean;

public class Manager {

    private int id;
    private String name;
    private String password;
    private String e_mail_address;
    private int phone_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getE_mail_address() {
        return e_mail_address;
    }

    public void setE_mail_address(String e_mail_address) {
        this.e_mail_address = e_mail_address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
}
