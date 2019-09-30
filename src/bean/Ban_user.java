package bean;

import java.util.List;

public class Ban_user {
    private int id;
    private String name;
    private String school;
    private long number;
    private String password;
    private String address;
    private int phone_number;
    private String reason;
    private String manager;
    private String date;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Ban_user(){}

    public Ban_user(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.school = user.getSchool();
        this.number = user.getNumber();
        this.password = user.getPassword();
        this.address = user.getAddress();
        this.phone_number = user.getPhone_number();
    }
}
