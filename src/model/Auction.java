package model;

public class Auction {

    public static final long BID_DURATION_MS = 20000;

    public final Object consoleLock = new Object();

    public Product product;
    public int highestBid;
    public Bidder highestBidder;
    public volatile long endTime;
    public volatile boolean auctionRunning;

    public Auction(Product product) {
        this.product = product;
        this.highestBid = product.basePrice;
        this.auctionRunning = true;
        this.endTime = System.currentTimeMillis() + BID_DURATION_MS;
    }

    public synchronized BidResult placeBid(Bidder bidder, int bid) {

        if (!auctionRunning || System.currentTimeMillis() >= endTime) {
            auctionRunning = false;
            return BidResult.AUCTION_ENDED;
        }

        if (bid < product.basePrice) {
            return BidResult.BELOW_BASE_PRICE;
        }

        if (bid <= highestBid) {
            return BidResult.NOT_HIGHEST;
        }

        highestBid = bid;
        highestBidder = bidder;
        endTime = System.currentTimeMillis() + BID_DURATION_MS;

        return BidResult.ACCEPTED;
    }

    public void stopAuction() {
        auctionRunning = false;
    }

}
