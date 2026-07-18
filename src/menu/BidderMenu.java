package menu;
import  model.Bidder;
import token.IDGenerate;
import token.TokenGenerate;

import java.util.ArrayList;
import java.util.List;

public class BidderMenu implements Menu{
    static public List<Bidder> bidderList=new ArrayList<>();
    @Override
    public void display(){
        System.out.println();
        System.out.println("""
                Enter Bidder Details, Make sure to double check your details
                """);
    }

    @Override
    public void menu() {
        System.out.print("Enter Number of bidders: ");
        int bidders = in.nextInt();

        for(int i=0;i<bidders;i++) {
            display();
            System.out.println("Bidder Number "+(i+1));
            System.out.print("Enter Your First Name: ");
            String name = in.next();
            System.out.print("Enter Your Phone Number: ");
            String phone = in.next();
            String maskedPhone=phone.replaceAll("[0-9](?=[0-9]{3})","X");
            System.out.print("Enter Your Email: ");
            String mail = in.next();
            Bidder bidder=new Bidder(name, phone, mail);

            bidderList.add(bidder);
            TokenGenerate.generateToken(bidder);
            IDGenerate.generateID(bidder);
            System.out.println("""
                    --------------------------------------------
                    Registration Successful !!!!
                    """);
            System.out.println("Name: "+bidder.name);
            System.out.println("Phone Number: "+maskedPhone);
            System.out.println("Token: "+bidder.token);
            System.out.println("Bidder ID: "+bidder.id);
            System.out.println("--------------------------------------------");
        }
    }

}
