package menu;

public class MainMenu implements Menu {

    ProductMenu productMenu = new ProductMenu();

    @Override
    public void display() {

        System.out.println("""
                ==============================
                     WELCOME TO AUCTION
                ==============================

                1. Start Auction
                2. Auction Rules
                3. Exit

                Enter Choice:
                """);
    }

    @Override
    public void menu() {

        int choice;

        do {

            display();
            choice = in.nextInt();

            switch (choice) {

                case 1:
                    productMenu.menu();
                    break;

                case 2:
                    System.out.println();
                    System.out.println("1. Every bidder must register before the auction starts.");
                    System.out.println("2. Use the printed Bidder ID to place a bid.");
                    System.out.println("3. Each bid must be a whole number.");
                    System.out.println("4. A bid must be higher than the base price and current highest bid.");
                    System.out.println("5. Every accepted bid resets the timer to 20 seconds.");
                    System.out.println("6. If no valid bid is placed within 20 seconds, the auction ends automatically.");
                    System.out.println("7. Bids submitted after the auction ends are rejected.");
                    System.out.println("8. The bidder with the highest valid bid wins.");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Thank you for using Auction System.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 3);
    }
}