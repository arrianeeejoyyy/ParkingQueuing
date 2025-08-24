package DATABASE;

import java.io.*;

public class SlotServed {

    private static final String FILE_PATH = "slot_served_count.txt";

    public static int getCount() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            return line != null ? Integer.parseInt(line.trim()) : 0;
        } catch (IOException | NumberFormatException e) {
            return 0; 
        }
    }

    public static void incrementCount() {
        int currentCount = getCount();
        currentCount++;
        saveCount(currentCount);
    }

    private static void saveCount(int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(String.valueOf(count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
