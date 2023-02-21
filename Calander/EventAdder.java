import java.util.Scanner;
import java.util.Map;

public class EventAdder {
    public void addEvent(Map<String, String> events, String date, String event) {
        //Here to see if the Key is already used or not
        if (events.containsKey(date)) {
            System.out.println("There is already an event on this date. Do you want to replace it? (y/n)");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if (answer.equals("y")) {
                // if yes then will Replace the Event with the same Key
                events.put(date, event);
                System.out.println("Event replaced successfully.");
            }
        } else {
            //if not then will add a new Event for the new Key
            events.put(date, event);
            System.out.println("Event added successfully.");
        }
    }
}
