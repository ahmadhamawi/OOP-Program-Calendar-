import java.util.Map;

public class EventPrinter {
    // Printing the Dates with the Events
    public void printEvents(Map<String, String> events) {
        for (String date : events.keySet()) {
            System.out.println(date + "-" + events.get(date));
        }
    }

}
