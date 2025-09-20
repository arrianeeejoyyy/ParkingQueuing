package parkingsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class P10_RECEIPT extends javax.swing.JFrame {
    private static int counter = 0;

    private String generateTransactionNumber() {
        counter++;
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return String.format("PARK-%s-%04d", date, counter);
    }

    // Constructor now accepts plate number and payment type
    public P10_RECEIPT(String plateNumber, String paymentType) {
        initComponents();

        Date now = new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateLabel.setText(df.format(now));

        SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss a");
        TimeLabel.setText(tf.format(now));

        Random rand = new Random();
        int ticketCode = 100000 + rand.nextInt(900000);

        String trxNumber = generateTransactionNumber();
        transactionNumber.setText(trxNumber);

        TicketCode.setText(" " + ticketCode);

        Platenumber_receipt.setText(plateNumber); // Set the plate number here
        PaymentTypeLabel.setText(paymentType);   // Set the payment type here
    }
    
    // Default constructor for cases where plateNumber and paymentType are not immediately available
    // (though it's better to always pass them if possible)
    public P10_RECEIPT() {
        this("", ""); // Call the parameterized constructor with empty strings
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TicketCode = new javax.swing.JLabel();
        tn = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        Platenumber_receipt = new javax.swing.JLabel();
        pl = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        PaymentTypeLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TicketCode.setFont(new java.awt.Font("Arial", 1, 70)); // NOI18N
        TicketCode.setText("R NO.");
        TicketCode.setToolTipText("");
        getContentPane().add(TicketCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 310, 60));

        tn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tn.setText("Transaction Number:");
        getContentPane().add(tn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 196, 20));

        Date.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Date.setText("Date:");
        getContentPane().add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, 20));

        Time.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time.setText("Time:");
        getContentPane().add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 53, 20));

        Platenumber_receipt.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Platenumber_receipt.setText("Plate Number"); // Default text, will be overwritten by constructor
        getContentPane().add(Platenumber_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 150, 20));

        pl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pl.setText("Payment Type:");
        getContentPane().add(pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 142, 20));

        transactionNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionNumber.setText("number");
        getContentPane().add(transactionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 196, 20));

        DateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DateLabel.setText("Date");
        getContentPane().add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 226, 20));

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TimeLabel.setText("Time");
        getContentPane().add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 170, 20));

        PaymentTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PaymentTypeLabel.setText("Payment Type"); // Default text, will be overwritten by constructor
        getContentPane().add(PaymentTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 142, 20));

        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 680, 420, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/RECEIPT.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 910));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // This part is now handled in P04_ENTER_PLATENUMBER before P10_RECEIPT is shown.
        // So, we just proceed to PDF generation and the next screen.

        new P15_TY_IN().setVisible(true);
        this.dispose();

        PDFreceipt pdf = new PDFreceipt();

        pdf.TicketNumber.setText(this.TicketCode.getText());
        pdf.transactionNumber.setText(this.transactionNumber.getText());
        pdf.DateLabel.setText(this.DateLabel.getText());
        pdf.TimeLabel.setText(this.TimeLabel.getText());
        pdf.PaymentTypeLabel.setText(this.PaymentTypeLabel.getText());
        pdf.Platenumber_receipt.setText(this.Platenumber_receipt.getText()); // Ensure plate number is passed

        pdf.savePanelImageAsPDF();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P10_RECEIPT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    public javax.swing.JLabel DateLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pl;
    public javax.swing.JLabel PaymentTypeLabel;
    public javax.swing.JLabel Platenumber_receipt;
    public javax.swing.JLabel TicketCode;
    private javax.swing.JLabel Time;
    public javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel tn;
    public javax.swing.JLabel transactionNumber;
    // End of variables declaration//GEN-END:variables
}