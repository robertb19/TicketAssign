import java.util.ArrayList;
import java.util.List;

public class BuyerRepository {

    private static List<Buyer> buyerList = new ArrayList<>();

    public static List<Buyer> getBuyerList() {
        return buyerList;
    }

    public static void addToList(Buyer buyer){
        buyerList.add(buyer);
    }
}
