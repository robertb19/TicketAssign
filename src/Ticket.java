import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private int price;

    public Ticket(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static List<Ticket> readTicketInformation(String[] eventInput){

        List<Ticket> ticketList = new ArrayList<>();

        for(int i = 3; i < eventInput.length; i++){
           Ticket ticket = new Ticket(Integer.parseInt(eventInput[i]));
           ticketList.add(ticket);
        }

        return ticketList;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                '}';
    }
}
