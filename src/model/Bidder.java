package model;

public class Bidder {
    public String name; //First Name only
    public String phone;
    String mail;
    public String token;

    public Bidder(String name, String phone, String mail){
        this.name=name;
        this.phone=phone;
        this.mail=mail;
    }
    public Bidder(){

    }
}
