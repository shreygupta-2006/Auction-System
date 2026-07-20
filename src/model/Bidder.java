package model;

public class Bidder {

    public String name;
    public String phone;
    public String mail;
    public String token;
    public String id;

    public Bidder(String name, String phone, String mail) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Bidder ID : " + id +
                "\nName : " + name +
                "\nPhone : " + phone +
                "\nToken : " + token;
    }
}