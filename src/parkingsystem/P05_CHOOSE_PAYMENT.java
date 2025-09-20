package parkingsystem;

public class P05_CHOOSE_PAYMENT extends javax.swing.JFrame {

    // Static field to hold the selected payment type
    public static String currentPaymentType = "";

    public P05_CHOOSE_PAYMENT() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CARD = new javax.swing.JButton();
        CASH = new javax.swing.JButton();
        CASHLESS = new javax.swing.JButton();
        CONFIRM = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CARD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CARD.setContentAreaFilled(false);
        CARD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CARDActionPerformed(evt);
            }
        });
        getContentPane().add(CARD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 400, 340, 350));

        CASH.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CASH.setContentAreaFilled(false);
        CASH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CASHActionPerformed(evt);
            }
        });
        getContentPane().add(CASH, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 340, 350));

        CASHLESS.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CASHLESS.setContentAreaFilled(false);
        CASHLESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CASHLESSActionPerformed(evt);
            }
        });
        getContentPane().add(CASHLESS, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 340, 350));

        CONFIRM.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CONFIRM.setContentAreaFilled(false);
        CONFIRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONFIRMActionPerformed(evt);
            }
        });
        getContentPane().add(CONFIRM, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 730, 470, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/CHOOSE PAYMENT .png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CASHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CASHActionPerformed
        currentPaymentType = "Cash"; // Set payment type
        // P06_GIf_INSERTMONEY p6 = new P06_GIf_INSERTMONEY(); // Removed direct navigation
        // p6.setVisible(true);
        this.dispose(); // Close this frame
    }//GEN-LAST:event_CASHActionPerformed

    private void CONFIRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONFIRMActionPerformed
        // This button's action might need to be re-evaluated based on your desired flow.
        // Currently, selecting Cash, Card, or Cashless directly disposes this frame.
        // If CONFIRM is meant to be a general "proceed" button after selection,
        // its logic would need to check if a payment type has been selected.
    }//GEN-LAST:event_CONFIRMActionPerformed

    private void CARDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARDActionPerformed
        currentPaymentType = "Card"; // Set payment type
        // P09_INSERTCARD p9 = new P09_INSERTCARD(); // Removed direct navigation
        // p9.setVisible(true);
        this.dispose(); // Close this frame
    }//GEN-LAST:event_CARDActionPerformed

    private void CASHLESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CASHLESSActionPerformed
        currentPaymentType = "Cashless"; // Set payment type
        // P07_QR_FOR_CASHLESS p7 = new P07_QR_FOR_CASHLESS(); // Removed direct navigation
        // p7.setVisible(true);
        this.dispose(); // Close this frame
    }//GEN-LAST:event_CASHLESSActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(P05_CHOOSE_PAYMENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P05_CHOOSE_PAYMENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P05_CHOOSE_PAYMENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P05_CHOOSE_PAYMENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P05_CHOOSE_PAYMENT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CARD;
    private javax.swing.JButton CASH;
    private javax.swing.JButton CASHLESS;
    private javax.swing.JButton CONFIRM;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}