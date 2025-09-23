
package parkingsystem;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class P10_RECEIPT extends javax.swing.JFrame {
  private String paymentType;
    
    public static int Counter = 0;
   
    
    public P10_RECEIPT() {
        initComponents();

        
        Date now = new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateLabel.setText(df.format(now));

        
        SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss a");
        TimeLabel.setText( tf.format(now));
        
        
        Random rand = new Random();
        int ticketCode = 100000 + rand.nextInt(900000); 
        
        String trxNumber = generateTransactionNumber();
        transactionNumber.setText(trxNumber);
        
        TicketCode.setText(" " + ticketCode);
        
        PaymentTypeLabel.setText(paymentType);
        
    }
    
    public void setPlateNumber(String plate) {
    Platenumber_receipt.setText(plate);
}
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TicketCode = new javax.swing.JLabel();
        tn = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        Platenumber_receipt = new javax.swing.JLabel();
        pl = new javax.swing.JLabel();
        unitcostlabel = new javax.swing.JLabel();
        DiscTypeLabel = new javax.swing.JLabel();
        DiscountLabel = new javax.swing.JLabel();
        subtotallabel = new javax.swing.JLabel();
        VatsalesLabel = new javax.swing.JLabel();
        VatLabel = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        PaymentTypeLabel = new javax.swing.JLabel();
        ryy3 = new javax.swing.JLabel();
        ryy4 = new javax.swing.JLabel();
        ryy5 = new javax.swing.JLabel();
        ryy6 = new javax.swing.JLabel();
        ryy7 = new javax.swing.JLabel();
        ryy8 = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        ryy9 = new javax.swing.JLabel();
        Time2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TicketCode.setFont(new java.awt.Font("Arial", 1, 70)); // NOI18N
        TicketCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TicketCode.setText("R NO.");
        TicketCode.setToolTipText("");
        getContentPane().add(TicketCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 310, 60));

        tn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tn.setText("Transaction Number:");
        getContentPane().add(tn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 196, 20));

        Date.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Date.setText("Date:");
        getContentPane().add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, 20));

        Time.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time.setText("Time:");
        getContentPane().add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 53, 20));

        Platenumber_receipt.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Platenumber_receipt.setText("Plate Number:");
        getContentPane().add(Platenumber_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 150, 20));

        pl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pl.setText("Payment Type:");
        getContentPane().add(pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 142, 20));

        unitcostlabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        unitcostlabel.setText("Unit Cost/Price :");
        getContentPane().add(unitcostlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 153, 20));

        DiscTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscTypeLabel.setText("Discount Type:");
        getContentPane().add(DiscTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 145, -1));

        DiscountLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscountLabel.setText("Discount:");
        getContentPane().add(DiscountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 94, -1));

        subtotallabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        subtotallabel.setText("Subtotal:");
        getContentPane().add(subtotallabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 94, 20));

        VatsalesLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatsalesLabel.setText("VAT Sales:");
        getContentPane().add(VatsalesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 118, 20));

        VatLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatLabel.setText("VAT:");
        getContentPane().add(VatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 59, -1));

        totalAmount.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        totalAmount.setText("Total Amount: ");
        getContentPane().add(totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 650, -1, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("-------------------------------------------------------------------------");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        transactionNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionNumber.setText("number");
        getContentPane().add(transactionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 196, 20));

        DateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DateLabel.setText("Date");
        getContentPane().add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 226, 20));

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TimeLabel.setText("Tim");
        getContentPane().add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 170, 20));

        PaymentTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PaymentTypeLabel.setText("Payment Type");
        getContentPane().add(PaymentTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 142, 20));

        ryy3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy3.setText("₱5.36");
        getContentPane().add(ryy3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, -1, 20));

        ryy4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy4.setText("None");
        getContentPane().add(ryy4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, -1, 20));

        ryy5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy5.setText("₱0.00");
        getContentPane().add(ryy5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, -1, 20));

        ryy6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy6.setText("₱50.00");
        getContentPane().add(ryy6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, -1, 20));

        ryy7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy7.setText("₱44.64");
        getContentPane().add(ryy7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, -1, 20));

        ryy8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ryy8.setText("₱50.00");
        getContentPane().add(ryy8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 640, 120, 40));

        print.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        print.setContentAreaFilled(false);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 680, 420, 90));

        ryy9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy9.setText("₱50.00");
        getContentPane().add(ryy9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, -1, 20));

        Time2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time2.setText("Plate Number:");
        getContentPane().add(Time2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 150, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/RECEIPT.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 910));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
    String ticketCode = TicketCode.getText();
    String slot = P03_SELECTPARK.ParkingData.selectedSlot;
    String plate = Platenumber_receipt.getText().trim();

            // Step 2: Save Slot to Database
            if (slot != null) {
                P03_SELECTPARK.ParkingData.occupiedSlots.put(slot, ticketCode);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/DATABASE/Intheslot.txt", true))) {
                    String status = "Occupied";  
                    String slotColor = "RED";    
                    writer.write(slot + " - " + plate + " - " + status + " - " + slotColor + " - TicketCode: " + ticketCode);
                    writer.newLine();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error saving to Intheslot database: " + e.getMessage());
                }

                P03_SELECTPARK selectParkFrame = new P03_SELECTPARK();
                selectParkFrame.setSlotColor(slot, Color.RED);
            }

            // Step 3: Update Counter (local counter, not serve)
            loadCounter();  
            Counter++;      
            saveCounter();  

            // Step 4: Show Thank You Screen
            new P15_TY_IN().setVisible(true);
            this.dispose();

            // Step 5: Generate PDF
            PDFreceipt pdf = new PDFreceipt();
            pdf.TicketNumber.setText(this.TicketCode.getText());
            pdf.transactionNumber.setText(this.transactionNumber.getText());
            pdf.DateLabel.setText(this.DateLabel.getText());
            pdf.platenumber.setText(this.Platenumber_receipt.getText());
            pdf.TimeLabel.setText(this.TimeLabel.getText());
            pdf.PaymentTypeLabel.setText(this.PaymentTypeLabel.getText());
            pdf.setVisible(true);  
            pdf.savePanelImageAsPDF();

            this.setVisible(false);

            // Step 6: Update QN_ticket
            File inputFile = new File("src/DATABASE/QN_ticket.txt");
            File tempFile = new File("src/DATABASE/QN_ticket_temp.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String line;
                boolean firstLineSkipped = false;

                while ((line = reader.readLine()) != null) {
                    if (!firstLineSkipped) {
                        firstLineSkipped = true;
                        continue;
                    }
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Step 7: Update counterServe correctly
            try {
                File counterFile = new File("src/DATABASE/CounterServe.txt");
                int currentServe = 0;

                if (counterFile.exists()) {
                    try (Scanner scanner = new Scanner(counterFile)) {
                        if (scanner.hasNextInt()) {
                            currentServe = scanner.nextInt();
                        }
                    }
                }

                currentServe++;  // increment properly
                P02_IN_OUT.counterServe = currentServe;

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(counterFile))) {
                    writer.write(String.valueOf(currentServe));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            // Step 8: Replace Ticket File
            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
            }
            QN_panel.Helper.clearNextTicketField();
    }//GEN-LAST:event_printActionPerformed
    
   public class ParkingSystemData {
    public static int Counter = 0;  // Public static counter
}
   
    // Helper method to load the counter from the file
    public void loadCounter() {
        try {
            File file = new File("src/DATABASE/Counter_P02.txt");
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                if (scanner.hasNextInt()) {
                    Counter = scanner.nextInt(); // Read the counter from the file
                }
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Helper method to save the updated counter to the file
    public void saveCounter() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/DATABASE/Counter_P02.txt"))) {
            writer.write(String.valueOf(Counter)); // Save the counter value to the text file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Load the counter for the current year
private int loadYearlyCounter() {
    int currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
    int counter = 0;

    File file = new File("src/DATABASE/TransactionCounter.txt");
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(currentYear + "=")) {
                    counter = Integer.parseInt(line.split("=")[1]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return counter;
}

// Save/update the counter for the current year
private void saveYearlyCounter(int counter) {
    int currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
    File file = new File("src/DATABASE/TransactionCounter.txt");
    StringBuilder content = new StringBuilder();
    boolean updated = false;

    // Read old content and replace if year found
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(currentYear + "=")) {
                    content.append(currentYear).append("=").append(counter).append("\n");
                    updated = true;
                } else {
                    content.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // If year not found, append new
    if (!updated) {
        content.append(currentYear).append("=").append(counter).append("\n");
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write(content.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// Generate transaction number with yearly counter
private String generateTransactionNumber() {
    int counter = loadYearlyCounter(); // load saved counter
    counter++; // increment
    saveYearlyCounter(counter); // save updated value

    String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
    return String.format("PARK-%s-%04d", date, counter);
}
    
    
   
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P10_RECEIPT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    public javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DiscTypeLabel;
    private javax.swing.JLabel DiscountLabel;
    public javax.swing.JLabel PaymentTypeLabel;
    private javax.swing.JLabel Platenumber_receipt;
    public javax.swing.JLabel TicketCode;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel Time2;
    public javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel VatLabel;
    private javax.swing.JLabel VatsalesLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel pl;
    private javax.swing.JButton print;
    private javax.swing.JLabel ryy3;
    private javax.swing.JLabel ryy4;
    private javax.swing.JLabel ryy5;
    private javax.swing.JLabel ryy6;
    private javax.swing.JLabel ryy7;
    private javax.swing.JLabel ryy8;
    private javax.swing.JLabel ryy9;
    private javax.swing.JLabel subtotallabel;
    private javax.swing.JLabel tn;
    private javax.swing.JLabel totalAmount;
    public javax.swing.JLabel transactionNumber;
    private javax.swing.JLabel unitcostlabel;
    // End of variables declaration//GEN-END:variables

}
