
package parkingsystem;

/**
 *
 * @author Airi
 */
public class e_payment extends javax.swing.JFrame {

    
    public e_payment() {
        initComponents();
        this.setVisible(true);
    }
    
  public void setHoldPlate(String plate) {
    holdplate.setText(plate); // holdplate is your JLabel
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gcash = new javax.swing.JButton();
        maya = new javax.swing.JButton();
        gt = new javax.swing.JButton();
        bpi = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        holdplate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        setPreferredSize(new java.awt.Dimension(1400, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gcash.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gcash.setContentAreaFilled(false);
        gcash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gcashActionPerformed(evt);
            }
        });
        getContentPane().add(gcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 220, 290));

        maya.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        maya.setContentAreaFilled(false);
        maya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mayaActionPerformed(evt);
            }
        });
        getContentPane().add(maya, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 210, 290));

        gt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gt.setContentAreaFilled(false);
        gt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtActionPerformed(evt);
            }
        });
        getContentPane().add(gt, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 200, 290));

        bpi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bpi.setContentAreaFilled(false);
        bpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpiActionPerformed(evt);
            }
        });
        getContentPane().add(bpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 320, 220, 300));

        back.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        back.setContentAreaFilled(false);
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 130, 130));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/e payment.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        holdplate.setText("jLabel2");
        getContentPane().add(holdplate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 800, 270, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gcashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gcashActionPerformed
    String plate = PlateNumberHolder.getPlateNumber(); // get plate from holder
    gcash p07 = new gcash();
    p07.setHoldPlate(plate);  // pass value
    p07.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_gcashActionPerformed

    private void mayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayaActionPerformed
     String plate = PlateNumberHolder.getPlateNumber(); // get plate from holder
    maya p07 = new maya();
    p07.setHoldPlate(plate);  // pass value
    p07.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_mayaActionPerformed

    private void gtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gtActionPerformed
      String plate = PlateNumberHolder.getPlateNumber(); // get plate from holder
    gotyme p07 = new gotyme();
    p07.setHoldPlate(plate);  // pass value
    p07.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_gtActionPerformed

    private void bpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpiActionPerformed
    String plate = PlateNumberHolder.getPlateNumber(); // get plate from holder
    bpi p07 = new bpi();
    p07.setHoldPlate(plate);  // pass value
    p07.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_bpiActionPerformed

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
            java.util.logging.Logger.getLogger(e_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(e_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(e_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(e_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new e_payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton bpi;
    private javax.swing.JButton gcash;
    private javax.swing.JButton gt;
    private javax.swing.JLabel holdplate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton maya;
    // End of variables declaration//GEN-END:variables
}
