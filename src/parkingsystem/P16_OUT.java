
package parkingsystem;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import parkingsystem.P03_SELECTPARK.ParkingData;
import static parkingsystem.P03_SELECTPARK.ParkingData.occupiedSlots;
import static parkingsystem.QN_panel.nextTicketField;

public class P16_OUT extends javax.swing.JFrame {

     private P03_SELECTPARK selectParkPanel; // reference to the existing P03 panel
    private P03_SELECTPARK panel;
     
    public P16_OUT() {
        initComponents();
        this.selectParkPanel = panel;
        
        
        
        RECEIPTCODE.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();

            // Allow only digits
            if (!Character.isDigit(c)) {
                evt.consume(); // block non-digits
            }

            // Limit to 6 digits only
            if (RECEIPTCODE.getText().length() >= 6) {
                evt.consume(); // block extra input
            }
        }
    });
        
    }

    public static boolean releaseSlot(String slot, String code) {
        if (occupiedSlots.containsKey(slot) && occupiedSlots.get(slot).equals(code)) {
//            occupiedSlots.remove(slot); 
            return true; 
        }
        return false; 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        RECEIPTCODE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 680, 450, 110));

        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 140, 120));

        RECEIPTCODE.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        RECEIPTCODE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RECEIPTCODE.setBorder(null);
        RECEIPTCODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RECEIPTCODEActionPerformed(evt);
            }
        });
        RECEIPTCODE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RECEIPTCODEKeyTyped(evt);
            }
        });
        getContentPane().add(RECEIPTCODE, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 690, 180));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/OUT.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);   
        P02_IN_OUT P01 = new P02_IN_OUT();  
        P01.setVisible(true);  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String enteredCodeRaw = RECEIPTCODE.getText().trim();

    if (enteredCodeRaw.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the Ticket Code.");
        return;
    }

    // Normalize to digits only (user might type spaces)
    String enteredCode = enteredCodeRaw.replaceAll("\\D", "");
    if (enteredCode.length() != 6) {
        JOptionPane.showMessageDialog(this, "Please enter the 6-digit Ticket Code (digits only).");
        RECEIPTCODE.setText("");
        return;
    }

    // Try to find the Intheslot database file (handle capitalization variants)
    File slotFile = new File("src/DATABASE/Intheslot.txt");
    if (!slotFile.exists()) slotFile = new File("src/DATABASE/intheslot.txt");
    if (!slotFile.exists()) {
        JOptionPane.showMessageDialog(this, "Ticket Number not found.");
        RECEIPTCODE.setText("");
        return;
    }

    // Read all lines and search for the ticket code
    List<String> allLines = new ArrayList<>();
    boolean found = false;
    String matchedSlot = null;
    Pattern sixDigits = Pattern.compile("\\d{6}");

    try (Scanner sc = new Scanner(slotFile)) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            allLines.add(line);

            Matcher m = sixDigits.matcher(line);
            String lastMatch = null;
            while (m.find()) lastMatch = m.group();

            if (lastMatch != null && lastMatch.equals(enteredCode)) {
                found = true;
                String[] parts = line.split(" - ");
                if (parts.length > 0) {
                    matchedSlot = parts[0].trim();
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error reading Intheslot file: " + e.getMessage());
        RECEIPTCODE.setText("");
        return;
    }

    if (!found) {
        JOptionPane.showMessageDialog(this, "Invalid Ticket Code. Please try again or check the receipt.");
        RECEIPTCODE.setText("");
        return;
    }

    // Remove the matched line
    List<String> keep = new ArrayList<>();
    for (String line : allLines) {
        Matcher m = sixDigits.matcher(line);
        String lastMatch = null;
        while (m.find()) lastMatch = m.group();
        if (lastMatch != null && lastMatch.equals(enteredCode)) {
            // skip
        } else {
            keep.add(line);
        }
    }

    try (PrintWriter pw = new PrintWriter(slotFile)) {
        for (String l : keep) pw.println(l);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating Intheslot file: " + e.getMessage());
        return;
    }

    // Free slot
    if (matchedSlot != null && !matchedSlot.isEmpty()) {
        occupiedSlots.remove(matchedSlot);
        try {
            P03_SELECTPARK selectParkFrame = new P03_SELECTPARK();
            selectParkFrame.setSlotColor(matchedSlot, Color.GREEN);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Decrement counter
    File counterFile = new File("src/DATABASE/Counter_P02.txt");
    int count = 0;
    if (counterFile.exists()) {
        try (Scanner sc = new Scanner(counterFile)) {
            if (sc.hasNextInt()) count = sc.nextInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    if (count > 0) count--;
    try (PrintWriter pw = new PrintWriter(counterFile)) {
        pw.println(count);
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Update QN_panel
    try {
        QN_panel qnPanel = QN_panel.getInstance();
        if (qnPanel.hasTickets()) {
            String nextTicket = qnPanel.popNextTicket();
            nextTicketField.setText(nextTicket);

            textmessage txt = new textmessage();
            txt.setVisible(true);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    // 🔹 NEW PART: queue number + textmessage confirmation
    try {
        File qnFile = new File("src/DATABASE/QN_ticket.txt");
        if (qnFile.exists()) {
            java.util.List<String> tickets = new java.util.ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(qnFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    tickets.add(line.trim());
                }
            }

            if (!tickets.isEmpty()) {
                String firstTicket = tickets.get(0);
                if (firstTicket.length() >= 6) {
                    String sixDigits = firstTicket.substring(0, 6);

                    textmessage tm = new textmessage(sixDigits);
                    tm.setVisible(true);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error in queue system: " + e.getMessage());
    }

    // Thank you panel
    P15_TY_OUT P15 = new P15_TY_OUT();
    P15.setVisible(true);
    this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RECEIPTCODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RECEIPTCODEActionPerformed
       
      
    }//GEN-LAST:event_RECEIPTCODEActionPerformed

    private void RECEIPTCODEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RECEIPTCODEKeyTyped
    char c = evt.getKeyChar();

    if (!Character.isDigit(c)) {
    evt.consume(); 
        }
   
    if (RECEIPTCODE.getText().length() >= 6) {
    evt.consume(); 
    }//GEN-LAST:event_RECEIPTCODEKeyTyped
    
    }
   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P16_OUT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RECEIPTCODE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
