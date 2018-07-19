import java.util.*;

public class BuyerService {

    private int cheapestTicket = Integer.MAX_VALUE;

    public String purchasedTicket(Buyer buyer) {

        Event event = findClosestEventToBuyer(buyer);

        StringBuilder sb = new StringBuilder();

        sb.append(event.getEventid() + " " + cheapestTicket);

        Iterator<Ticket> iter = event.getTickets().iterator();

        while (iter.hasNext()) {
            Ticket t = iter.next();
            if (t.getPrice() == cheapestTicket)
                iter.remove();
        }

        cheapestTicket = Integer.MAX_VALUE;

        return sb.toString();
    }

    public Event findClosestEventToBuyer(Buyer buyer) {

        Map<Event, Integer> buyerDistanceMap = new HashMap<>();

        int buyerx = buyer.getCoordinates().getX();
        int buyery = buyer.getCoordinates().getY();

        for (Event event : EventRepository.getEventList()) {
            int distance = Coordinates.calculateManhattanDistance(buyerx, buyery, event.getCoordinates().getX(), event.getCoordinates().getY());
            buyerDistanceMap.put(event, distance);
        }

        int smallestDistance = Integer.MAX_VALUE;

        for (Integer i : buyerDistanceMap.values()) {
            if (i < smallestDistance) smallestDistance = i;
        }

        int count = 0;

        for (Integer i : buyerDistanceMap.values()) {
            if (i == smallestDistance) count += 1;
        }

        List<Event> listOfClosestEvents = new ArrayList<>();

        for (Map.Entry<Event, Integer> entry : buyerDistanceMap.entrySet()) {
            if (entry.getValue() == smallestDistance) listOfClosestEvents.add(entry.getKey());
            else ;
        }

        if (listOfClosestEvents.size() > 1) {

            int counter = 0;
            int realIndex = 0;

            for (Event e : listOfClosestEvents) {
                counter += 1;
                for (Ticket t : e.getTickets()) {
                    if (t.getPrice() < cheapestTicket) {
                        cheapestTicket = t.getPrice();
                        realIndex = counter;
                    }
                }
            }

            return listOfClosestEvents.get(realIndex);

        } else {

            for (Ticket t : listOfClosestEvents.get(0).getTickets()) {
                if (t.getPrice() < cheapestTicket) {
                    cheapestTicket = t.getPrice();
                }
            }
            return listOfClosestEvents.get(0);
        }
    }
}
