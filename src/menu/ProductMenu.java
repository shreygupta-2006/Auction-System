package menu;

import model.Product;

public class ProductMenu implements Menu{

    @Override
    public void display() {
        System.out.println("""
                Enter the details of the product
                """);
    }

    @Override
    public void menu() {
        display();
        System.out.print("Enter Name of Product: ");
        String productName=in.next();
        System.out.print("Enter Base Price of the Product: ");
        int basePrice=in.nextInt();
        Product product = new Product(productName,basePrice);
        BidderMenu bidderMenu=new BidderMenu();
        bidderMenu.menu();
    }
}
