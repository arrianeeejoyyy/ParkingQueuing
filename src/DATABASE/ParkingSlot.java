package DATABASE;

import java.io.Serializable;

public class ParkingSlot implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization

    private String slotName;
    private String plateNumber;
    private String ticketCode;
    private String transactionNumber;
    private String paymentType;
    private String entryDateTime;

    public ParkingSlot(String slotName, String plateNumber, String ticketCode, String transactionNumber, String paymentType, String entryDateTime) {
        this.slotName = slotName;
        this.plateNumber = plateNumber;
        this.ticketCode = ticketCode;
        this.transactionNumber = transactionNumber;
        this.paymentType = paymentType;
        this.entryDateTime = entryDateTime;
    }

    // Getters
    public String getSlotName() {
        return slotName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getEntryDateTime() {
        return entryDateTime;
    }

    // Setters (if needed, but often not for immutable data like this)
    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setEntryDateTime(String entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    @Override
    public String toString() {
        return slotName + "," + plateNumber + "," + ticketCode + "," + transactionNumber + "," + paymentType + "," + entryDateTime;
    }
}