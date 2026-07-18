package token;
import model.Bidder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;

public class TokenGenerate {
    static HashMap<String,String> hm = new HashMap<>();
    static public void generateToken(Bidder bidder){
        LocalDateTime now= LocalDateTime.now();
        DateTimeFormatter dtm=DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSS");
        String time = dtm.format(now);
        Random random = new Random();
        bidder.token= "AUC"+time+random.nextInt(1,100);
        hm.put(bidder.token,bidder.name);
    }
}
