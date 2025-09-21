
package parkingsystem;
import java.awt.Desktop;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;


public class P13_QN_TICKET extends javax.swing.JFrame {
    
     private String paymentType;
    
    private static int counter = 0;
    
    private String plate;   // store plate number
    private String ticketCode; // store ticket code

   
    private String generateTransactionNumber() {
        counter++; // Increment for each transaction

        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return String.format("PARK-%s-%04d", date, counter);
    }

   
     public P13_QN_TICKET(String plate) {
         initComponents(); // initialize UI first

    // Set class field
    this.plate = plate;

    // Set plate number label
    TNL.setText("Plate Number: " + this.plate);

    // Generate ticket code and set label
    this.ticketCode = String.valueOf(100000 + new Random().nextInt(900000));
    TicketNumber.setText(this.ticketCode);

    // Generate transaction number
    String trxNumber = generateTransactionNumber();
    TNL1.setText(trxNumber);

    // Set date and time
    Date now = new Date();
    DateLabel.setText(new SimpleDateFormat("yyyy-MM-dd").format(now));
    TimeLabel.setText(new SimpleDateFormat("hh:mm:ss a").format(now));

    // Add to QN panel table
    QN_panel.getInstance().addToQueue(ticketCode);
    }
        
     
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PRINTTICKET = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TicketNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        subtotallabel = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        VatsalesLabel = new javax.swing.JLabel();
        VatLabel = new javax.swing.JLabel();
        DiscountLabel = new javax.swing.JLabel();
        DiscTypeLabel = new javax.swing.JLabel();
        unitcostlabel = new javax.swing.JLabel();
        PaymentTypeLabel = new javax.swing.JLabel();
        DL = new javax.swing.JLabel();
        TL = new javax.swing.JLabel();
        TNL = new javax.swing.JLabel();
        PTL = new javax.swing.JLabel();
        UL = new javax.swing.JLabel();
        DTL = new javax.swing.JLabel();
        DSL = new javax.swing.JLabel();
        SL = new javax.swing.JLabel();
        VSL = new javax.swing.JLabel();
        VAL = new javax.swing.JLabel();
        TAL = new javax.swing.JLabel();
        TNL1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PRINTTICKET.setBorderPainted(false);
        PRINTTICKET.setContentAreaFilled(false);
        PRINTTICKET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINTTICKETActionPerformed(evt);
            }
        });
        getContentPane().add(PRINTTICKET, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 680, 410, 90));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("-------------------------------------------------------------------------");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        TicketNumber.setFont(new java.awt.Font("Arial", 1, 70)); // NOI18N
        TicketNumber.setText("Ticket C");
        TicketNumber.setToolTipText("");
        getContentPane().add(TicketNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 310, 60));

        DateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DateLabel.setText("Date");
        getContentPane().add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 140, 20));

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TimeLabel.setText("Time");
        getContentPane().add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 290, 20));

        totalAmount.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        totalAmount.setText("₱50.00");
        getContentPane().add(totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 690, 80, -1));

        subtotallabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        subtotallabel.setText("₱50.00");
        getContentPane().add(subtotallabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 600, 60, 20));

        transactionNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionNumber.setText("Transaction Number");
        getContentPane().add(transactionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 200, 20));

        VatsalesLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatsalesLabel.setText("₱44.64");
        getContentPane().add(VatsalesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 630, 60, 20));

        VatLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatLabel.setText("₱5.36");
        getContentPane().add(VatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 660, -1, 20));

        DiscountLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscountLabel.setText("₱0.00");
        getContentPane().add(DiscountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 570, 50, -1));

        DiscTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscTypeLabel.setText("None");
        getContentPane().add(DiscTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 540, -1, -1));

        unitcostlabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        unitcostlabel.setText("₱50.00");
        getContentPane().add(unitcostlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, 60, 20));

        PaymentTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PaymentTypeLabel.setText("Payment Type");
        getContentPane().add(PaymentTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, -1, 20));

        DL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DL.setText("Date:");
        getContentPane().add(DL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 60, 20));

        TL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TL.setText("Time:");
        getContentPane().add(TL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 290, 20));

        TNL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TNL.setText("Plate Number:");
        getContentPane().add(TNL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 350, 20));

        PTL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PTL.setText("Payment Type");
        getContentPane().add(PTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 260, 20));

        UL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        UL.setText("Unit Cost/Price ");
        getContentPane().add(UL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 300, 20));

        DTL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DTL.setText("Discount Type:");
        getContentPane().add(DTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 370, -1));

        DSL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DSL.setText("Discount");
        getContentPane().add(DSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 350, 20));

        SL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SL.setText("Subtotal");
        getContentPane().add(SL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 290, 20));

        VSL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VSL.setText("VAT Sales");
        getContentPane().add(VSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, 310, 20));

        VAL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VAL.setText("VAT (12%)");
        getContentPane().add(VAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 660, 330, 20));

        TAL.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        TAL.setText("Total Amount:");
        getContentPane().add(TAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 690, 300, -1));

        TNL1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TNL1.setText("Transaction Number:");
        getContentPane().add(TNL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 200, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/QUEUING_NUMBER _ FULL.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PRINTTICKETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINTTICKETActionPerformed
     
        PDFticket pdf = new PDFticket();

    // Pass the values from P13_QN_TICKET to PDFticket
    pdf.TicketNumber.setText(this.TicketNumber.getText());
    pdf.transactionNumber.setText(this.transactionNumber.getText());
    pdf.DateLabel.setText(this.DateLabel.getText());
    pdf.TimeLabel.setText(this.TimeLabel.getText());
    pdf.PaymentTypeLabel.setText(this.PaymentTypeLabel.getText());

    // Make the PDFticket window visible
    pdf.setVisible(true);  
    pdf.savePanelImageAsPDF();
        
    }//GEN-LAST:event_PRINTTICKETActionPerformed

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
            public void run(){ 
               
            new P13_QN_TICKET("test123").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DL;
    private javax.swing.JLabel DSL;
    private javax.swing.JLabel DTL;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DiscTypeLabel;
    private javax.swing.JLabel DiscountLabel;
    private javax.swing.JButton PRINTTICKET;
    private javax.swing.JLabel PTL;
    private javax.swing.JLabel PaymentTypeLabel;
    private javax.swing.JLabel SL;
    private javax.swing.JLabel TAL;
    private javax.swing.JLabel TL;
    private javax.swing.JLabel TNL;
    private javax.swing.JLabel TNL1;
    private javax.swing.JLabel TicketNumber;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel UL;
    private javax.swing.JLabel VAL;
    private javax.swing.JLabel VSL;
    private javax.swing.JLabel VatLabel;
    private javax.swing.JLabel VatsalesLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel subtotallabel;
    private javax.swing.JLabel totalAmount;
    private javax.swing.JLabel transactionNumber;
    private javax.swing.JLabel unitcostlabel;
    // End of variables declaration//GEN-END:variables
}
