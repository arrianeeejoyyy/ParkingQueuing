package DATABASE;

import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingDataManager {

    private static final String FILE_NAME = "parking_data.txt";

    // Saves the current state of occupied slots to a file
    public static void saveParkingData(HashMap<String, ParkingSlot> occupiedSlots) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(occupiedSlots);
            System.out.println("Parking data saved successfully to " + FILE_NAME);
        } catch (IOException ex) {
            Logger.getLogger(ParkingDataManager.class.getName()).log(Level.SEVERE, "Error saving parking data", ex);
        }
    }

    // Loads parking data from a file
    public static HashMap<String, ParkingSlot> loadParkingData() {
        File file = new File(FILE_NAME);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                HashMap<String, ParkingSlot> loadedData = (HashMap<String, ParkingSlot>) ois.readObject();
                System.out.println("Parking data loaded successfully from " + FILE_NAME);
                return loadedData;
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ParkingDataManager.class.getName()).log(Level.SEVERE, "Error loading parking data", ex);
                return new HashMap<>(); // Return empty if loading fails
            }
        }
        System.out.println("No existing parking data file found or file is empty. Starting with empty data.");
        return new HashMap<>(); // Return empty if file doesn't exist or is empty
    }
}