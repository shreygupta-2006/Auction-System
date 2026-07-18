package menu;

public class MainMenu implements Menu{
    ProductMenu productMenu=new ProductMenu();
    @Override
    public void display(){
        System.out.println("""
                Welcome to Auction !!
                
                1. Start the Auction
                2. Auction Rules
                3. Quit
                
                Enter:"""+" ");
    }

    @Override
    public void menu(){
        int input;
        do{
            display();
            input=in.nextInt();

            switch(input){
                case 1-> productMenu.menu();
                case 2-> System.out.println();
                case 3-> System.out.println("Thanks for Attending the Auction !! ");
                default -> System.out.println("Enter Valid Entry");
            }
        }while(input!=3);
    }
}
