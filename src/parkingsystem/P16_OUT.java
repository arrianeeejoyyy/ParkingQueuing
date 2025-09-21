
package parkingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import parkingsystem.P03_SELECTPARK.ParkingData;
import static parkingsystem.P03_SELECTPARK.ParkingData.occupiedSlots;

public class P16_OUT extends javax.swing.JFrame {

     private P03_SELECTPARK selectParkPanel; // reference to the existing P03 panel
    private P03_SELECTPARK panel;
     
    public P16_OUT() {
        initComponents();
        this.selectParkPanel = panel;
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
     String slot = ParkingData.selectedSlot; 
    String enteredCode = jTextField1.getText().trim(); 

    if (enteredCode.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the Ticket Code.");
        return;
    }

    if (ParkingData.releaseSlot(slot, enteredCode)) {
    try {
        // ===== Delete the same info from intheslot.txt =====
        File slotFile = new File("src/DATABASE/intheslot.txt");
        List<String> slotLines = new ArrayList<>();
        try (Scanner sc = new Scanner(slotFile)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.contains(enteredCode)) { // delete lines with the same ticket code
                    slotLines.add(line);
                }
            }
        }
        try (PrintWriter pw = new PrintWriter(slotFile)) {
            for (String l : slotLines) pw.println(l);
        }

        // ===== Remove from occupiedSlots map =====
        occupiedSlots.remove(slot);

        // ===== Refresh the existing P03_SELECTPARK panel =====
        if (selectParkPanel != null) {
            selectParkPanel.refreshLabels(); // repaint slots to remove RED
        }

        // ===== Decrement counter in Counter_P02.txt =====
        File counterFile = new File("src/DATABASE/Counter_P02.txt");
        int count = 0;
        if (counterFile.exists()) {
            try (Scanner sc = new Scanner(counterFile)) {
                if (sc.hasNextInt()) count = sc.nextInt();
            }
        }
        if (count > 0) count--; // decrement but not negative
        try (PrintWriter pw = new PrintWriter(counterFile)) {
            pw.println(count);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    // ===== Show thank-you panel =====
    P15_TY_OUT P15 = new P15_TY_OUT();
    P15.setVisible(true);
    this.dispose();

} else {
    JOptionPane.showMessageDialog(this, "Invalid Ticket Code.");
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
