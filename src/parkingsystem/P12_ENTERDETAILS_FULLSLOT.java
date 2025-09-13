
package parkingsystem;


public class P12_ENTERDETAILS_FULLSLOT extends javax.swing.JFrame {

   
    public P12_ENTERDETAILS_FULLSLOT() {
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
            } else if (pos == 3) {
                PlateNumber.setText(text + "-");
                if (Character.isDigit(c)) {
                    PlateNumber.setText(PlateNumber.getText() + c);
                }
                evt.consume();
            } else {
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        }
    });

    phoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            String text = phoneNumber.getText();

            if (!Character.isDigit(c)) {
                evt.consume();
                return;
            }

            if (text.length() >= 11) {
                evt.consume();
            }
        }
    });

    fullName.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            String text = fullName.getText();

            if (text.length() >= 50) {
                evt.consume();
                return;
            }

            if (!Character.isLetter(c) && c != ' ' && c != '-' && c != '\'') {
                evt.consume();
            }
        }
    });
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fullName = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JTextField();
        PlateNumber = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fullName.setFont(new java.awt.Font("Arial", 1, 35)); // NOI18N
        fullName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(fullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 490, 100));

        phoneNumber.setFont(new java.awt.Font("Arial", 1, 35)); // NOI18N
        phoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        phoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberActionPerformed(evt);
            }
        });
        getContentPane().add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 490, 100));

        PlateNumber.setFont(new java.awt.Font("Arial", 1, 35)); // NOI18N
        PlateNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlateNumber.setOpaque(true);
        PlateNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlateNumberActionPerformed(evt);
            }
        });
        getContentPane().add(PlateNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 560, 490, 100));

        confirm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirm.setBorderPainted(false);
        confirm.setContentAreaFilled(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 720, 430, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/ENTERDETAILS_FULLSLOT.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        
    }//GEN-LAST:event_confirmActionPerformed

    private void PlateNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlateNumberActionPerformed
      String input = PlateNumber.getText().toUpperCase(); 
    
    if (input.length() > 7) {
        input = input.substring(0, 7);
        PlateNumber.setText(input);
        
        
    }
    }//GEN-LAST:event_PlateNumberActionPerformed

    private void phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberActionPerformed
       
    }//GEN-LAST:event_phoneNumberActionPerformed

   
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
            java.util.logging.Logger.getLogger(P12_ENTERDETAILS_FULLSLOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P12_ENTERDETAILS_FULLSLOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P12_ENTERDETAILS_FULLSLOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P12_ENTERDETAILS_FULLSLOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P12_ENTERDETAILS_FULLSLOT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PlateNumber;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField fullName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField phoneNumber;
    // End of variables declaration//GEN-END:variables
}
