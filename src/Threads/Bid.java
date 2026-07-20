package Threads;

import menu.BidderMenu;
import model.Auction;
import model.BidResult;
import model.Bidder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bid extends Thread {

    private final Auction auction;
    private final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public Bid(Auction auction) {
        this.auction = auction;
    }

    @Override
    public void run() {

        while (auction.auctionRunning) {

            String bidderID;

            synchronized (auction.consoleLock) {
                System.out.println();
                System.out.print("Enter Bidder ID : ");
            }
            // Do not hold consoleLock while waiting. The timer must be able to
            // end the auction even when a bidder never submits this field.
            bidderID = readTokenUntilAuctionEnds();

            if (bidderID == null) {
                break;
            }

            if (!auction.auctionRunning) {
                synchronized (auction.consoleLock) {
                    System.out.println("Auction has already ended.");
                }
                break;
            }

            Bidder currentBidder = null;

            for (Bidder bidder : BidderMenu.bidderList) {
                if (bidder.id.equalsIgnoreCase(bidderID)) {
                    currentBidder = bidder;
                    break;
                }
            }

            if (currentBidder == null) {
                synchronized (auction.consoleLock) {
                    System.out.println("Invalid Bidder ID");
                }
                continue;
            }

            int bidAmount;

            synchronized (auction.consoleLock) {
                System.out.print("Enter Bid Amount : ");
            }
            String bidText = readTokenUntilAuctionEnds();
            if (bidText == null) {
                break;
            }

            try {
                bidAmount = Integer.parseInt(bidText);
            } catch (NumberFormatException e) {
                synchronized (auction.consoleLock) {
                    System.out.println("Bid amount must be a whole number.");
                }
                continue;
            }

            if (!auction.auctionRunning) {
                synchronized (auction.consoleLock) {
                    System.out.println("Auction has already ended.");
                }
                break;
            }

            BidResult result = auction.placeBid(currentBidder, bidAmount);

            synchronized (auction.consoleLock) {

                switch (result) {

                    case ACCEPTED:
                        System.out.println("Bid Accepted");
                        System.out.println("Highest Bid : " + auction.highestBid);
                        System.out.println("Highest Bidder : " + auction.highestBidder.id);
                        System.out.println("Time has been reset. You have 20 seconds to place the next bid.");
                        break;

                    case BELOW_BASE_PRICE:
                        System.out.println("Bid Rejected - Bid is below the base price of " + auction.product.basePrice);
                        break;

                    case NOT_HIGHEST:
                        System.out.println("Bid Rejected - Bid must be higher than current highest bid of " + auction.highestBid);
                        break;

                    case AUCTION_ENDED:
                        System.out.println("Bid Rejected - Auction has already ended");
                        break;
                }
            }
        }
    }

    /** Reads a complete submitted line without blocking the auction timer. */
    private String readTokenUntilAuctionEnds() {
        while (auction.auctionRunning) {
            try {
                if (input.ready()) {
                    String line = input.readLine();
                    if (line == null) {
                        return null;
                    }
                    line = line.trim();
                    if (!line.isEmpty()) {
                        return line;
                    }
                }
                Thread.sleep(50);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to read bid input.", e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        return null;
    }

}
