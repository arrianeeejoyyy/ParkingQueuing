
package parkingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class textmessage extends javax.swing.JFrame {

   private String currentTicket; // holds the first ticket (6 digits)
   
    public textmessage() {
        initComponents();
      
         this.currentTicket = "";
        qn.setText("");
    }

    
        // Constructor that accepts the 6-digit ticket string
    public textmessage(String ticketCode) {
        initComponents();
        this.currentTicket = (ticketCode == null ? "" : ticketCode);
        qn.setText(this.currentTicket);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        confirm = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        qn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(1470, 700, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        confirm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirm.setContentAreaFilled(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 60, 20));

        cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cancel.setContentAreaFilled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 60, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Please click the button to confirm or to cancel.");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 270, -1));

        qn.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        qn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        qn.setText("123456");
        getContentPane().add(qn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 128, 170, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Good Day Client, your parking queue number ");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 280, -1));

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/textmessage.png"))); // NOI18N
        getContentPane().add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
           try {
            File qnFile = new File("src/DATABASE/QN_ticket.txt");
            if (!qnFile.exists()) {
                this.dispose();
                return;
            }

            List<String> tickets = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(qnFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.trim().isEmpty()) tickets.add(line);
                }
            }

            // Remove first row if present
            if (!tickets.isEmpty()) {
                tickets.remove(0);

                // Rewrite QN_ticket.txt with the remaining lines (stack shift)
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(qnFile, false))) {
                    for (String s : tickets) {
                        bw.write(s);
                        bw.newLine();
                    }
                }
            }

            // Update NEXTTOSERVE.txt (first 6-digit of the new top or empty)
            File nextFile = new File("src/DATABASE/NEXTTOSERVE.txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nextFile, false))) {
                if (tickets.isEmpty()) {
                    bw.write("");
                    try { QN_panel.nextTicketField.setText(""); } catch (Exception ex) {}
                } else {
                    // extract first 6-digit group from the new first line
                    Pattern p = Pattern.compile("\\d{6}");
                    Matcher m = p.matcher(tickets.get(0));
                    String nextTicket = "";
                    if (m.find()) nextTicket = m.group();
                    bw.write(nextTicket);
                    try { QN_panel.nextTicketField.setText(nextTicket); } catch (Exception ex) {}
                }
            }

            // Refresh QN_panel labels from file
            try { QN_panel.getInstance().loadTicketsFromFile(); } catch (Exception ex) { ex.printStackTrace(); }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.dispose();
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        this.setVisible(false);
            this.dispose();
    }//GEN-LAST:event_confirmActionPerformed

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
            java.util.logging.Logger.getLogger(textmessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(textmessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(textmessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(textmessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new textmessage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel qn;
    // End of variables declaration//GEN-END:variables
}
