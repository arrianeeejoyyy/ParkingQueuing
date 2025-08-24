package DATABASE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class QUEUE_NUMBER {

    private static final String FILE_PATH = "plate_number_log.txt";

    public static void savePlateNumber(String plateNumber) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(plateNumber + " - " + timestamp);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
