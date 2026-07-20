package token;
import model.Bidder;

public class IDGenerate {
    private static int bidderID=1;
    static public void generateID(Bidder bidder){
        bidder.id= "B"+bidderID++;
    }
}
