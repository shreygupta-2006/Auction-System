package menu;

import model.Bidder;
import token.IDGenerate;
import token.TokenGenerate;

import java.util.ArrayList;
import java.util.List;

public class BidderMenu implements Menu {

    public static List<Bidder> bidderList = new ArrayList<>();

    @Override
    public void display() {

        System.out.println();
        System.out.println("""
                Enter Bidder Details
                """);
    }

    @Override
    public void menu() {

        bidderList.clear();

        System.out.print("Enter Number of Bidders: ");
        int bidders = in.nextInt();

        for (int i = 0; i < bidders; i++) {

            display();

            System.out.println("Bidder " + (i + 1));

            System.out.print("Enter First Name: ");
            String name = in.next();

            System.out.print("Enter Phone Number: ");
            String phone = in.next();

            String maskedPhone = phone.replaceAll("[0-9](?=[0-9]{3})", "X");

            System.out.print("Enter Email: ");
            String mail = in.next();

            Bidder bidder = new Bidder(name, phone, mail);

            IDGenerate.generateID(bidder);
            TokenGenerate.generateToken(bidder);

            bidderList.add(bidder);

            System.out.println("----------------------------------");
            System.out.println("Registration Successful");
            System.out.println("Name : " + bidder.name);
            System.out.println("Phone : " + maskedPhone);
            System.out.println("Bidder ID : " + bidder.id);
            System.out.println("Token : " + bidder.token);
            System.out.println("----------------------------------");
        }

        System.out.println();
        System.out.println("All bidders registered successfully.");
    }
}