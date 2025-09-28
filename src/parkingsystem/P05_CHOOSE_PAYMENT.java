
package parkingsystem;

public class P05_CHOOSE_PAYMENT extends javax.swing.JFrame {

    
    public P05_CHOOSE_PAYMENT() {
        initComponents();
    }

    public void setHoldPlateLabel(String plate) {
    holdplate.setText(plate);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CARD = new javax.swing.JButton();
        CASH = new javax.swing.JButton();
        CASHLESS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        holdplate = new javax.swing.JLabel();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/CHOOSE PAYMENT .png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        holdplate.setText("jLabel2");
        getContentPane().add(holdplate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 800, 270, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CASHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CASHActionPerformed
    PlateNumberHolder.setPlateNumber(holdplate.getText());
    P06_GIf_INSERTMONEY p6 = new P06_GIf_INSERTMONEY();
    p6.setHoldPlate(holdplate.getText());
    p6.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_CASHActionPerformed

    private void CARDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARDActionPerformed
    PlateNumberHolder.setPlateNumber(holdplate.getText());
    P09_INSERTCARD p6 = new P09_INSERTCARD();
    p6.setHoldPlate(holdplate.getText());
    p6.setVisible(true);
    this.setVisible(false); 
    }//GEN-LAST:event_CARDActionPerformed

    private void CASHLESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CASHLESSActionPerformed
    String plate = PlateNumberHolder.getPlateNumber(); // get plate from holder
    P07_QR_FOR_CASHLESS p07 = new P07_QR_FOR_CASHLESS();
    p07.setHoldPlate(plate);  // pass value
    p07.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_CASHLESSActionPerformed
  
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new P05_CHOOSE_PAYMENT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CARD;
    private javax.swing.JButton CASH;
    private javax.swing.JButton CASHLESS;
    private javax.swing.JLabel holdplate;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
