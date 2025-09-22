
package parkingsystem;

public class PlateNumberHolder {
     private static String plateNumber;

    public static void setPlateNumber(String plate) {
        plateNumber = plate;
    }

    public static String getPlateNumber() {
        return plateNumber;
    }
}
