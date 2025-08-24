package DATABASE;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class QUEUE_NUMBER {
    private static final String SLOT_FILE_PATH = "slot_status.txt";
    private static final String PLATE_FILE_PATH = "plate_numbers.txt";
    private static final Map<String, Boolean> slots = new HashMap<>();

    static {
        loadSlots(); // Load slots on class load
    }

    private static void loadSlots() {
        File file = new File(SLOT_FILE_PATH);
        if (!file.exists()) return; // No file yet — assume all slots are available

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String slotId = parts[0].trim();
                    boolean isTaken = Boolean.parseBoolean(parts[1].trim());
                    slots.put(slotId, isTaken);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveSlots() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SLOT_FILE_PATH))) {
            for (Map.Entry<String, Boolean> entry : slots.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSlotTaken(String slotId) {
        return slots.getOrDefault(slotId, false);
    }

    public static void markSlotAsTaken(String slotId) {
        slots.put(slotId, true);
        saveSlots();
    }

    public static void markSlotAsAvailable(String slotId) {
        slots.put(slotId, false);
        saveSlots();
    }

    public static Map<String, Boolean> getAllSlots() {
        return new HashMap<>(slots); // Return a copy
    }

    // ✅ Save plate number with slot ID and timestamp
    public static void savePlateNumber(String plate, String slotId) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String entry = "Plate: " + plate + " | Slot: " + slotId + " | Time: " + timeStamp;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PLATE_FILE_PATH, true))) {
            writer.write(entry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
