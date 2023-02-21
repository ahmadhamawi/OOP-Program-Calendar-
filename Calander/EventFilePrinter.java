import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class EventFilePrinter {
    public void printEventsToFile(Map<String, String> events) {
        // Printing the Dates and Events to the File (events.txt)
        try {
            FileWriter writer = new FileWriter("events.txt", true);
            for (String date : events.keySet()) {
                writer.write(date + "-" + events.get(date) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
