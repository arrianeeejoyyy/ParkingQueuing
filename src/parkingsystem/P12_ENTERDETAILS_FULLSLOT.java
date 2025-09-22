
package parkingsystem;


import javax.swing.JOptionPane;


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



    phoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        String text = phoneNumber.getText();

        // Allow only digits
        if (!Character.isDigit(c)) {
            evt.consume();
            return;
        }

        // Limit to 11 digits
        if (text.length() >= 11) {
            evt.consume();
            return;
        }

        // Validate prefix "09" as the first two characters
        if (text.length() == 0 && c != '0') {
            evt.consume();
            JOptionPane.showMessageDialog(
                null,
                "Phone number must start with 09 and only have 11 digits.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
            );
        } else if (text.length() == 1 && c != '9') {
            evt.consume();
            JOptionPane.showMessageDialog(
                null,
                "Phone number must start with 09 and only have 11 digits.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
            );
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
        back = new javax.swing.JButton();
        checkbox1 = new java.awt.Checkbox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fullName.setFont(new java.awt.Font("Arial", 1, 35)); // NOI18N
        fullName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(fullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 490, 90));

        phoneNumber.setFont(new java.awt.Font("Arial", 1, 35)); // NOI18N
        phoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        phoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberActionPerformed(evt);
            }
        });
        getContentPane().add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 490, 90));

        PlateNumber.setFont(new java.awt.Font("Arial", 1, 35)); // NOI18N
        PlateNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlateNumber.setOpaque(true);
        PlateNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlateNumberActionPerformed(evt);
            }
        });
        getContentPane().add(PlateNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 490, 90));

        confirm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirm.setBorderPainted(false);
        confirm.setContentAreaFilled(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 750, 430, 110));

        back.setToolTipText("");
        back.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 120));

        checkbox1.setBackground(new java.awt.Color(255, 255, 255));
        checkbox1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(checkbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 735, 20, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/ENTERDETAILS_FULLSLOT.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
    String name = fullName.getText().trim();
String phone = phoneNumber.getText().trim();
String plate = PlateNumber.getText().trim();

// Check if checkbox is selected
if (!checkbox1.getState()) {                       
    JOptionPane.showMessageDialog(
        this,
        "You must check the box before confirming!",
        "Warning",
        JOptionPane.WARNING_MESSAGE
    );
    return; 
} 
// Validate name (not empty and letters only)
else if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
    JOptionPane.showMessageDialog(
        this,
        "Please enter a valid name (letters only)!",
        "Warning",
        JOptionPane.WARNING_MESSAGE
    );
    return;
} 
// Validate phone number (starts with 09 and exactly 11 digits)
else if (!phone.matches("09\\d{9}")) {
    JOptionPane.showMessageDialog(
        this,
        "Please enter a valid phone number starting with 09 and 11 digits long!",
        "Warning",
        JOptionPane.WARNING_MESSAGE
    );
    return;
} 
// Validate plate number (3 letters + 4 digits)
else if (!plate.matches("[A-Z]{3}-\\d{4}")) {
    JOptionPane.showMessageDialog(
        this,
        "Please enter a valid plate number (format: ABC-1234)!",
        "Warning",
        JOptionPane.WARNING_MESSAGE
    );
    return;
}

// Save to text file (database)
try {
    java.io.FileWriter fw = new java.io.FileWriter("src/DATABASE/fullslot_details.txt", true);
    java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
    bw.write("FullName: " + name + ", PhoneNumber: " + phone + ", PlateNumber: " + plate);
    bw.newLine();
    bw.close();
    fw.close();
} catch (java.io.IOException e) {
    e.printStackTrace();
}

// Show the ticket frame
this.setVisible(false);
new P13_QN_TICKET(plate).setVisible(true);

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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        P02_IN_OUT P02 = new P02_IN_OUT();
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
    private javax.swing.JButton back;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField fullName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField phoneNumber;
    // End of variables declaration//GEN-END:variables

    private String generateTicketCode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
