
package parkingsystem;

public class P05_CHOOSE_PAYMENT extends javax.swing.JFrame {

    
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

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mitsu\\OneDrive\\Documents\\NetBeansProjects\\ParkingQueuing\\ParkingQueuing\\src\\MAIN_UI\\CHOOSE PAYMENT .png")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CASHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CASHActionPerformed
        P06_ p6 = new P06_();
        p6.setVisible(true);
        QN_panel.getInstance().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CASHActionPerformed

    private void CONFIRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONFIRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CONFIRMActionPerformed

    private void CARDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARDActionPerformed
         P09 p9 = new P09();
        p9.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CARDActionPerformed

    private void CASHLESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CASHLESSActionPerformed
        P07_QR_FOR_CASHLESS p7 = new P07_QR_FOR_CASHLESS();
        p7.setVisible(true);
        this.setVisible(false);
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
