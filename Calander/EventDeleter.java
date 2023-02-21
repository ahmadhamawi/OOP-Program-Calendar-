import java.util.Map;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class EventDeleter {
    // This method deletes the event from the given map
    public void deleteEvent(Map<String, String> events, String date) {
        // Check if the event exists
        if (events.containsKey(date)) {
            events.remove(date);
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("No event found on this date.");
        }
    }

    // This method deletes the event from the file
    public void deleteEventFromFile(Map<String, String> events, String date) {
        try {
            // Read the contents of the file into a string buffer
            StringBuffer buffer = new StringBuffer();
            try (BufferedReader reader = new BufferedReader(new FileReader("events.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + System.lineSeparator());
                }
            }

            // Delete the specified event from the string buffer
            events.remove(date);
            StringBuffer newBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : events.entrySet()) {
                newBuffer.append(entry.getKey() + "-" + entry.getValue() + System.lineSeparator());
            }

            // Write the updated contents to the file
            try (FileWriter writer = new FileWriter("events.txt")) {
                writer.write(newBuffer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
