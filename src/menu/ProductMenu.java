package menu;

import Threads.AuctionStart;
import Threads.Bid;
import Threads.BidStart;
import auction.AuctionScreen;
import model.Auction;
import model.Product;

public class ProductMenu implements Menu {

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
        String productName = in.nextLine();

        if (productName.isBlank()) {
            productName = in.nextLine();
        }

        System.out.print("Enter Base Price of the Product: ");
        int basePrice = in.nextInt();

        Product product = new Product(productName, basePrice);

        BidderMenu bidderMenu = new BidderMenu();
        bidderMenu.menu();

        System.out.println();

        BidStart bidStart = new BidStart();
        bidStart.start();

        try {
            bidStart.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Auction auction = new Auction(product);

        AuctionStart auctionStart = new AuctionStart(auction);
        Bid bid = new Bid(auction);

        auctionStart.start();
        bid.start();

        try {
            auctionStart.join();
            bid.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        AuctionScreen auctionScreen = new AuctionScreen();
        auctionScreen.displayWinner(auction);
        auctionScreen.displaySummary(auction, BidderMenu.bidderList);
    }
}
