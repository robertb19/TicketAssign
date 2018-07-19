import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        World world = new World(sizeOfWorld);

        int numberOfEvents = Integer.parseInt(scan.nextLine());

        while(numberOfEvents > 0){
            String eventLine = scan.nextLine();
            String[] eventDetails = ReaderConverter.splitTable(eventLine);
            Event event = Event.createEventDetails(eventDetails);
            numberOfEvents--;
        }

        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        while(numberOfBuyers > 0){
            String buyerLine = scan.nextLine();
            String[] buyerDetails = ReaderConverter.splitTable(buyerLine);
            Buyer buyer = Buyer.readBuyerDetails(buyerDetails);
            numberOfBuyers--;
    }

    BuyerService buyerService = new BuyerService();

    for(Buyer buyer : BuyerRepository.getBuyerList()){
        System.out.println(buyerService.purchasedTicket(buyer));
    }

    }
}
