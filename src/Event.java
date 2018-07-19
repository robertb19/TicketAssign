import java.util.List;

public class Event {

    int eventid;
    Coordinates coordinates = new Coordinates();
    List<Ticket> tickets;

    public Event(String[] eventDetails){
        readId(eventDetails);
        coordinates.setEventCoordinates(eventDetails);
        this.tickets = Ticket.readTicketInformation(eventDetails);
        EventRepository.addElementToList(this);
    }

    public static Event createEventDetails(String[] eventDetails) throws Exception {

        for(Event e : EventRepository.getEventList()){
            if(e.getCoordinates().getX() == Integer.parseInt(eventDetails[1]) && e.getCoordinates().getY() == Integer.parseInt(eventDetails[2]) || Integer.parseInt(eventDetails[1]) > World.getWorld().length || Integer.parseInt(eventDetails[2]) > World.getWorld().length){
                throw new Exception ("Element Already Exists at this spot or is out of bounds of the world!");
            }
        }
    return new Event(eventDetails);
    }

    public void purchaseTicketsFromEvent(Ticket ticket){
        tickets.remove(ticket);
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void readId(String[] eventDetails){
        this.eventid = Integer.parseInt(eventDetails[0]);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventid=" + eventid +
                ", coordinates=" + coordinates +
                ", tickets=" + tickets +
                '}';
    }
}
