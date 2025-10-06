package parkingsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JOptionPane;

public class P13_QN_TICKET extends javax.swing.JFrame {
    
    private final String plate;   // store plate number
    private final String ticketCode; // store ticket code
    
    
    public P13_QN_TICKET(String plate) {
         initComponents(); // initialize UI first

    // Set class field
    this.plate = plate;

    // Set plate number label
    platenumber.setText("" + this.plate);

    // Generate ticket code and set label
    this.ticketCode = String.valueOf(100000 + new Random().nextInt(900000));
    TicketNumber.setText(this.ticketCode);

    // Generate transaction number
    String trxNumber = generateTransactionNumber();
    transactionNumber.setText(trxNumber);

    // Set date and time
    Date now = new Date();
    DateLabel.setText(new SimpleDateFormat("yyyy-MM-dd").format(now));
    TimeLabel.setText(new SimpleDateFormat("hh:mm:ss a").format(now));

     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PRINTTICKET = new javax.swing.JButton();
        TicketNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        platenumber = new javax.swing.JLabel();
        DL = new javax.swing.JLabel();
        TL = new javax.swing.JLabel();
        TNL = new javax.swing.JLabel();
        VSL = new javax.swing.JLabel();
        TNL1 = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        TL1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PRINTTICKET.setBorderPainted(false);
        PRINTTICKET.setContentAreaFilled(false);
        PRINTTICKET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINTTICKETActionPerformed(evt);
            }
        });
        getContentPane().add(PRINTTICKET, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 680, 410, 90));

        TicketNumber.setFont(new java.awt.Font("Arial", 1, 70)); // NOI18N
        TicketNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TicketNumber.setText("Ticket C");
        TicketNumber.setToolTipText("");
        getContentPane().add(TicketNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 310, 60));

        DateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DateLabel.setText("Date");
        getContentPane().add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 140, 20));

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TimeLabel.setText("Time");
        getContentPane().add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, 290, 20));

        platenumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        platenumber.setText("Transaction Number");
        getContentPane().add(platenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 200, 20));

        DL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DL.setText("Date:");
        getContentPane().add(DL, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 60, 20));

        TL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TL.setText("PLEASE TAKE CARE OF THIS TICKET");
        getContentPane().add(TL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 340, 20));

        TNL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TNL.setText("Plate Number:");
        getContentPane().add(TNL, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 150, 20));

        VSL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(VSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, 310, 20));

        TNL1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TNL1.setText("Transaction Number:");
        getContentPane().add(TNL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 200, 20));

        transactionNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionNumber.setText("Transaction Number");
        getContentPane().add(transactionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 200, 20));

        TL1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TL1.setText("Time:");
        getContentPane().add(TL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 290, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/QUEUING_NUMBER _ FULL .png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PRINTTICKETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINTTICKETActionPerformed
    PDFticket pdf = new PDFticket();

    // Pass the values from P13_QN_TICKET to PDFticket
    pdf.TicketNumber.setText(this.TicketNumber.getText());
    pdf.platenumber.setText(this.platenumber.getText());
    pdf.transactionNumber.setText(this.transactionNumber.getText());
    pdf.DateLabel.setText(this.DateLabel.getText());
    pdf.TimeLabel.setText(this.TimeLabel.getText());
    

     // --- Save to text file database ---
     try {
        // --- Save ticket code to NEXTTOSERVE.txt ---
        File nextFile = new File("src/DATABASE/NEXTTOSERVE.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nextFile, true))) {
            bw.write(this.ticketCode); // 6-digit ticket code only
            bw.newLine();
        }

        // --- Save ticket code + plate number to QN_PANEL_DB.txt ---
        File dbFile = new File("src/DATABASE/QN_ticket.txt");
        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(dbFile, true))) {
            bw2.write(this.ticketCode + " | " + this.plate); 
            bw2.newLine();
        }

        // --- Update QN_panel immediately ---
        QN_panel qnPanel = QN_panel.getInstance();
        qnPanel.loadTicketsFromFile(); // refresh stacked labels
        
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error saving ticket data!");
    }

    pdf.savePanelImageAsPDF();
        
    this.setVisible(false);
    P14_WaitQueue p14 = new P14_WaitQueue();
    p14.setVisible(true);
    }//GEN-LAST:event_PRINTTICKETActionPerformed

    // Load counter for the current year from QN_TransactionCounter.txt
    private int loadYearlyCounter() {
        int currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
        int counter = 0;
        File file = new File("src/DATABASE/QN_TransactionCounter.txt");

        if (file.exists()) {
            try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith(currentYear + "=")) {
                        counter = Integer.parseInt(line.split("=")[1]);
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        return counter;
    }

    // Save/update the counter for the current year
    private void saveYearlyCounter(int counter) {
        int currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
        File file = new File("src/DATABASE/QN_TransactionCounter.txt");
        StringBuilder content = new StringBuilder();
        boolean updated = false;

        if (file.exists()) {
            try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith(currentYear + "=")) {
                        content.append(currentYear).append("=").append(counter).append("\n");
                        updated = true;
                    } else {
                        content.append(line).append("\n");
                    }
                }
            } catch (Exception e) {
            }
        }

        if (!updated) {
            content.append(currentYear).append("=").append(counter).append("\n");
        }

        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(file))) {
            writer.write(content.toString());
        } catch (Exception e) {
        }
    }

    // Generate a transaction number with persistent yearly counter
    private String generateTransactionNumber() {
        int counter = loadYearlyCounter();
        counter++;
        saveYearlyCounter(counter);

        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return String.format("Queue-%s-%04d", date, counter); 
    }
    
  
    
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new P13_QN_TICKET("test123").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DL;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JButton PRINTTICKET;
    private javax.swing.JLabel TL;
    private javax.swing.JLabel TL1;
    private javax.swing.JLabel TNL;
    private javax.swing.JLabel TNL1;
    private javax.swing.JLabel TicketNumber;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel VSL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel platenumber;
    private javax.swing.JLabel transactionNumber;
    // End of variables declaration//GEN-END:variables
}
