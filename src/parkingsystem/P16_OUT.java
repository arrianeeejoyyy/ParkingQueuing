package parkingsystem;

import DATABASE.ParkingDataManager;
import DATABASE.ParkingSlot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import parkingsystem.P03_SELECTPARK.ParkingData;


public class P16_OUT extends javax.swing.JFrame {


    public P16_OUT() {
        initComponents();

    }

    // This method is no longer directly used for releasing, as the logic is in jButton1ActionPerformed
    // but keeping it for consistency if needed elsewhere.
    public static boolean releaseSlot(String slot, String code) {
        if (ParkingData.occupiedSlots.containsKey(slot)) {
            ParkingSlot parkedCar = ParkingData.occupiedSlots.get(slot);
            if (parkedCar.getTicketCode().equals(code)) {
                // occupiedSlots.remove(slot); // This line was commented out in original, now handled in action listener
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
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

        jTextField1.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 690, 180));

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
        String enteredCode = jTextField1.getText().trim();

        if (enteredCode.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter the Ticket Code.");
            return;
        }

        // Find the slot associated with the entered ticket code
        String slotToVacate = null;
        for (Map.Entry<String, ParkingSlot> entry : ParkingData.occupiedSlots.entrySet()) {
            if (entry.getValue().getTicketCode().trim().equals(enteredCode)) {
                slotToVacate = entry.getKey();
                break;
            }
        }

        if (slotToVacate != null) {
            // Remove the slot from occupiedSlots
            ParkingData.occupiedSlots.remove(slotToVacate);

            // Update QN_panel (you'll need a method to remove a row)
            QN_panel.getInstance().removeParkingRow(slotToVacate);

            // Save the updated parking data to file
            ParkingDataManager.saveParkingData(ParkingData.occupiedSlots);

            P15_TY_OUT P15 = new P15_TY_OUT();
            P15.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Ticket Code or car not found.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

        char c = evt.getKeyChar();


    if (!Character.isDigit(c)) {
    evt.consume();
}


    if (jTextField1.getText().length() >= 6) {
    evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P16_OUT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}