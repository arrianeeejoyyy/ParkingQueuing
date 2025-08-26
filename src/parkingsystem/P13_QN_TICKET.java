
package parkingsystem;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;


public class P13_QN_TICKET extends javax.swing.JFrame {

   
    public P13_QN_TICKET() {
        initComponents();
        
         
        
        Date now = new Date();

        // Date format
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateLabel.setText("Date:  " + df.format(now));

        // Time format
        SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss a");
        TimeLabel.setText("Time:  " + tf.format(now));
        
        
        Random rand = new Random();
        int ticketCode = 100000 + rand.nextInt(900000); 
        

    

        TicketNumber.setText(" " + ticketCode);
        
        subtotal.setText("Total Amount: ₱50.00");
        subtotal1.setText("Subtotal: ₱44.64");    
        VatLabel.setText("VAT (12%): ₱5.36");
        DiscountLabel.setText("Discount: ₱0.00");
        DiscTypeLabel.setText("Discount Type: None");
        
        
       
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        TicketNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        subtotal1 = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        VatLabel = new javax.swing.JLabel();
        DiscountLabel = new javax.swing.JLabel();
        DiscTypeLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 680, 380, 90));

        TicketNumber.setFont(new java.awt.Font("Arial", 1, 70)); // NOI18N
        TicketNumber.setText("Ticket C");
        TicketNumber.setToolTipText("");
        getContentPane().add(TicketNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 310, 60));

        DateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DateLabel.setText("Date:");
        getContentPane().add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 340, 20));

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TimeLabel.setText("Time:");
        getContentPane().add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 290, 20));

        subtotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        subtotal.setText("Total Amount: ");
        getContentPane().add(subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 300, 20));

        subtotal1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        subtotal1.setText("Subtotal:");
        getContentPane().add(subtotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 290, 20));

        transactionNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionNumber.setText("Transaction Number:");
        getContentPane().add(transactionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 290, 20));

        VatLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatLabel.setText("VAT:");
        getContentPane().add(VatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 210, 30));

        DiscountLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscountLabel.setText("DISCOUNT:");
        getContentPane().add(DiscountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 350, -1));

        DiscTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscTypeLabel.setText("Discount Type:");
        getContentPane().add(DiscTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 370, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mitsu\\OneDrive\\Documents\\NetBeansProjects\\ParkingQueuing\\ParkingQueuing\\src\\MAIN_UI\\QUEUING_NUMBER _ FULL .png")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        P14_WaitQueue P14 = new P14_WaitQueue();
        P14.setVisible(true);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(P13_QN_TICKET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P13_QN_TICKET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P13_QN_TICKET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P13_QN_TICKET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P13_QN_TICKET().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DiscTypeLabel;
    private javax.swing.JLabel DiscountLabel;
    private javax.swing.JLabel TicketNumber;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel VatLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel subtotal1;
    private javax.swing.JLabel transactionNumber;
    // End of variables declaration//GEN-END:variables
}
