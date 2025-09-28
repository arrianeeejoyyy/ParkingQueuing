
package parkingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


public class P3_ENTER_TC_CODE extends javax.swing.JFrame {

    
    public P3_ENTER_TC_CODE() {
        initComponents();
        
        ticketCodeField.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();

            // Allow only digits
            if (!Character.isDigit(c)) {
                evt.consume(); // block non-digits
            }

            // Limit to 6 digits only
            if (ticketCodeField.getText().length() >= 6) {
                evt.consume(); // block extra input
            }
        }
    });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ticketCodeField = new javax.swing.JTextField();
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 670, 490, 130));

        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 130, 130));

        ticketCodeField.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        ticketCodeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ticketCodeField.setToolTipText("");
        ticketCodeField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ticketCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketCodeFieldActionPerformed(evt);
            }
        });
        getContentPane().add(ticketCodeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 690, 180));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/ENTER_TC_CODE .png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ticketCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketCodeFieldActionPerformed
       
    }//GEN-LAST:event_ticketCodeFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);   
        P02_IN_OUT P01 = new P02_IN_OUT();  
        P01.setVisible(true);         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String enteredCode = ticketCodeField.getText().trim();

        if (enteredCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a ticket code!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("src/DATABASE/QN_ticket.txt"))) {
            String firstLine = reader.readLine(); // ✅ only check the very first line

            if (firstLine != null && firstLine.length() >= 6) {
                String fileCode = firstLine.substring(0, 6).trim(); // ✅ first 6 characters only

                if (enteredCode.equals(fileCode)) {
                    // ✅ Correct code → proceed to plate number entry

                    // Clear NEXTTOSERVE.txt
                    try (BufferedWriter bw = new BufferedWriter(
                            new FileWriter("src/DATABASE/NEXTTOSERVE.txt", false))) {
                        bw.write(""); // overwrite with empty content
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, 
                            "Error clearing NEXTTOSERVE.txt: " + ex.getMessage());
                    }

                    this.dispose();
                    new P04_ENTER_PLATENUMBER().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Invalid ticket code. Please enter the correct one.");
                    ticketCodeField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No valid ticket found in QN_ticket.");
                ticketCodeField.setText("");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading QN_ticket: " + e.getMessage());
            ticketCodeField.setText("");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(P3_ENTER_TC_CODE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P3_ENTER_TC_CODE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P3_ENTER_TC_CODE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P3_ENTER_TC_CODE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P3_ENTER_TC_CODE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField ticketCodeField;
    // End of variables declaration//GEN-END:variables
}
