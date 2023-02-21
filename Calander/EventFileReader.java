import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class EventFileReader{
    
    public void readEventsFromFile(MainCalender mainCalendar) {
        //Here to Read the Dates and Events from the File
        try {
            Scanner fileScanner = new Scanner(new File("events.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                //Splitting the Date and Event with (-) 
                String[] parts = line.split("-");
                String date = parts[0];
                String event = parts[1];
                //After splitting will add to the Map
                mainCalendar.addEvent(date, event);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.");
        }
    }
    
}
