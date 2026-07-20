package Threads;

import model.Auction;

public class AuctionStart extends Thread {

    private final Auction auction;

    public AuctionStart(Auction auction) {
        this.auction = auction;
    }

    @Override
    public void run() {

        synchronized (auction.consoleLock) {
            System.out.println("You have 20 seconds to bid.");
        }

        while (auction.auctionRunning) {

            long remaining = (auction.endTime - System.currentTimeMillis() + 999) / 1000;

            if (remaining <= 0) {
                // End the auction before waiting for the console. A bidder may
                // still be typing, but their bid must not be accepted after time
                // has expired.
                auction.stopAuction();
                synchronized (auction.consoleLock) {
                    System.out.println();
                    System.out.println("Auction Ended !!");
                }
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
