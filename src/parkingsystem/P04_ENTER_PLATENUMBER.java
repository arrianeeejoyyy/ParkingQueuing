
package parkingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import parkingsystem.P03_SELECTPARK.ParkingData;
import parkingsystem.PlateNumberHolder;


public class P04_ENTER_PLATENUMBER extends javax.swing.JFrame {

   private static final String DATABASE_FILE = "src/DATABASE/Intheslot.txt";
    
    public P04_ENTER_PLATENUMBER() {
        initComponents();
        
        PlateNumber.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            String text = PlateNumber.getText();

            if (text.length() >= 8) {
                evt.consume();
                return;
            }

            int pos = text.length();

            if (pos < 3) {
                if (!Character.isLetter(c)) {
                    evt.consume();
                } else {
                    evt.setKeyChar(Character.toUpperCase(c));
                }
            }
            else if (pos == 3) {
                // Check if dash already exists, don't add it again
                if (!text.contains("-")) {
                    PlateNumber.setText(text + "-");
                }
                if (Character.isDigit(c)) {
                    PlateNumber.setText(PlateNumber.getText() + c);
                }
                evt.consume();
            }
            else {
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        }

        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
                String text = PlateNumber.getText();
                int pos = text.length();

                // Handle the case when user presses backspace and remove the dash properly
                if (pos == 4 && text.charAt(3) == '-') {
                    PlateNumber.setText(text.substring(0, 3));
                }
            } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                // Trigger confirm when enter is pressed
                confirmActionPerformed(null);
            }
        }
    });

}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        confirm = new javax.swing.JButton();
        PlateNumber = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        confirm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirm.setBorderPainted(false);
        confirm.setContentAreaFilled(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 680, 470, 110));

        PlateNumber.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        PlateNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PlateNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlateNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlateNumberActionPerformed(evt);
            }
        });
        getContentPane().add(PlateNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 700, 160));

        back.setToolTipText("");
        back.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/ENTER_PLATENUMBER.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlateNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlateNumberActionPerformed
    String input = PlateNumber.getText().toUpperCase(); 
    
    if (input.length() > 7) {
        input = input.substring(0, 7);
        PlateNumber.setText(input);
        
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Plate number can only have up to 7 characters.");
    }
    }//GEN-LAST:event_PlateNumberActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
 String plate = PlateNumber.getText().trim();

    if (plate.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter a plate number!");
        return;
    }

    // --- NEW: Check QN_ticket.txt file ---
    boolean allowProceed = false; 

    try (BufferedReader br = new BufferedReader(new FileReader("src/DATABASE/QN_ticket.txt"))) {
        String firstRow = br.readLine();  // only read the first row

        if (firstRow == null || firstRow.trim().isEmpty()) {
            // ✅ Case 1: File is empty → allow any plate number
            allowProceed = true;
        } else {
            // ✅ Case 2: File has data, check only the first row
            String[] parts = firstRow.split("\\|");
            if (parts.length == 2) {
                String registeredPlate = parts[1].trim();  // plate from file (e.g. FGH-5654)

                if (plate.equals(registeredPlate)) {
                    allowProceed = true; // ✅ Plate matches
                } else {
                    JOptionPane.showMessageDialog(this,
                            "The plate number entered was wrong!\n" +
                            "Check the ticket for the registered plate number.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    PlateNumber.setText("");
                    return; // ❌ stop execution if not matching
                }
            } else {
                // if row format invalid, just allow (fallback)
                allowProceed = true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error reading QN_ticket.txt",
                "File Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    // --- Continue only if allowed ---
    if (allowProceed) {
        int confirmResult = JOptionPane.showConfirmDialog(this, 
            "Are you sure this is the correct plate number?\n" + plate, 
            "Confirm Plate Number", 
            JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {
            // ✅ Save plate to shared holder
            PlateNumberHolder.setPlateNumber(plate);

            // ✅ Move to payment selection
            P05_CHOOSE_PAYMENT paymentFrame = new P05_CHOOSE_PAYMENT();
            paymentFrame.setHoldPlateLabel(plate); // set in holdplate JLabel
            paymentFrame.setVisible(true); 
            this.setVisible(false);
        }
    }
    }//GEN-LAST:event_confirmActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        P03_SELECTPARK P02 = new P03_SELECTPARK();
        P02.setVisible(true);
        QN_panel.getInstance().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

  
 
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(P04_ENTER_PLATENUMBER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P04_ENTER_PLATENUMBER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P04_ENTER_PLATENUMBER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P04_ENTER_PLATENUMBER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>a
        //</editor-fold>a
        //</editor-fold>a
        //</editor-fold>a
        //</editor-fold>a
        //</editor-fold>a
        //</editor-fold>a
        //</editor-fold>a

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P04_ENTER_PLATENUMBER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PlateNumber;
    private javax.swing.JButton back;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
