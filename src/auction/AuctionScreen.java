package auction;

import model.Auction;
import model.Bidder;
import model.Product;

import java.util.List;

public class AuctionScreen {

    public void displayWinner(Auction auction) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("Winner");
        System.out.println("==============================");

        Bidder winner = auction.highestBidder;

        if (winner == null) {
            System.out.println("No bids were placed. Auction closed without a winner.");
            return;
        }

        System.out.println("Bidder Token : " + winner.token);
        System.out.println("Bidder ID : " + winner.id);
        System.out.println("Winning Amount : " + auction.highestBid);
        System.out.println("Product Name : " + auction.product.productName);
    }

    public void displaySummary(Auction auction, List<Bidder> bidderList) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("Auction Summary");
        System.out.println("==============================");

        Product product = auction.product;
        Bidder winner = auction.highestBidder;

        System.out.println("Product : " + product.productName);
        System.out.println("Base Price : " + product.basePrice);
        System.out.println("Winning Bid : " + (winner == null ? "No Bids Placed" : String.valueOf(auction.highestBid)));
        System.out.println("Winner Token : " + (winner == null ? "N/A" : winner.token));
        System.out.println("Winner ID : " + (winner == null ? "N/A" : winner.id));
        System.out.println("Total Registered Bidders : " + bidderList.size());
        System.out.println("==============================");
    }

}
