import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    private static List<Event> eventList = new ArrayList<>();

    public static List<Event> getEventList() {
        return eventList;
    }

    public static void addElementToList(Event event){
        eventList.add(event);
    }
}
