import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
//Main Method for the Calender
public class MainCalender {
    private Map<String, String> events;

    public MainCalender() {
        events = new HashMap<String, String>();
    }

    public void addEvent(String date, String event) {
        EventAdder eventAdder = new EventAdder();
        eventAdder.addEvent(events, date, event);
    }

    public void deleteEvent(String date) {
        EventDeleter eventDeleter = new EventDeleter();
        eventDeleter.deleteEvent(events, date);
        eventDeleter.deleteEventFromFile(events, date);
    }

    public void printEvents() {
        EventPrinter eventPrinter = new EventPrinter();
        eventPrinter.printEvents(events);
        EventFilePrinter eventFilePrinter = new EventFilePrinter();
        eventFilePrinter.printEventsToFile(events);
    }

    public void readEventsFromFile() {
        EventFileReader eventFileReader = new EventFileReader();
        eventFileReader.readEventsFromFile(this);
    }
    

    public static void main(String[] args) {
        MainCalender myCalendar = new MainCalender();
        EventFileReader eventFileReader = new EventFileReader();
        eventFileReader.readEventsFromFile(myCalendar);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add event");
            System.out.println("2. Delete event");
            System.out.println("3. Print events");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter date and time (dd/mm/yyyy)(hh:mm): ");
                String date = input.nextLine();
                System.out.print("Enter event: ");
                String event = input.nextLine();
                myCalendar.addEvent(date, event);
            } else if (choice == 2) {
                System.out.print("Enter date (dd/mm/yyyy)(hh:mm): ");
                String date = input.nextLine();
                myCalendar.deleteEvent(date);
            } else if (choice == 3) {
                myCalendar.printEvents();
            } else if (choice == 4) {
                break;
            }
        }
    }
}
