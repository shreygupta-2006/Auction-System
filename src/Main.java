import menu.MainMenu;
import menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu=new MainMenu();
        mainMenu.menu();

    }
}



/*
Flow ->

Welcome to Auction

Enter Product to be Auctioned : {Product Name}

Enter Base Price of the product : {Price}

Enter Number of Bidders : {Number of Bidders}

Enter Name of Bidder 1 : {Name}

...
...
...

Enter Name of model.Bidder N: {Name}

Bid Start !!

.
.
.
.
.

 */