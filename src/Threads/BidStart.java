package Threads;

public class BidStart extends Thread {

    @Override
    public void run() {

        try {

            for (int i = 10; i >= 1; i--) {
                System.out.print("\rAuction Starts In : " + i);
                Thread.sleep(1000);
            }

            System.out.println("Auction Started !!");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
