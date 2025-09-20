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

    // Constructor that accepts plate number and payment type
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

        // Set plate number and payment type values to the value labels
        PlateNumberValueLabel.setText(plateNumber);
        PaymentTypeLabel.setText(paymentType);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        TicketCode = new javax.swing.JLabel();
        tn = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        Platenumber_receipt = new javax.swing.JLabel(); // Title label "Plate Number:"
        PlateNumberValueLabel = new javax.swing.JLabel(); // Value label for plate number
        pl = new javax.swing.JLabel();
        unitcostlabel = new javax.swing.JLabel();
        DiscTypeLabel = new javax.swing.JLabel();
        DiscountLabel = new javax.swing.JLabel();
        subtotallabel = new javax.swing.JLabel();
        VatsalesLabel = new javax.swing.JLabel();
        VatLabel = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        PaymentTypeLabel = new javax.swing.JLabel();
        ryy3 = new javax.swing.JLabel();
        ryy4 = new javax.swing.JLabel();
        ryy5 = new javax.swing.JLabel();
        ryy6 = new javax.swing.JLabel();
        ryy7 = new javax.swing.JLabel();
        ryy8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ryy9 = new javax.swing.JLabel();
        Time2 = new javax.swing.JLabel();
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
        Platenumber_receipt.setText("Plate Number:");
        getContentPane().add(Platenumber_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 150, 20));

        // New label for actual plate number value
        PlateNumberValueLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PlateNumberValueLabel.setText(""); // initially empty
        getContentPane().add(PlateNumberValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 150, 20));

        pl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pl.setText("Payment Type:");
        getContentPane().add(pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 142, 20));

        unitcostlabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        unitcostlabel.setText("Unit Cost/Price :");
        getContentPane().add(unitcostlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 153, 20));

        DiscTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscTypeLabel.setText("Discount Type:");
        getContentPane().add(DiscTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 145, -1));

        DiscountLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscountLabel.setText("Discount:");
        getContentPane().add(DiscountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 94, -1));

        subtotallabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        subtotallabel.setText("Subtotal:");
        getContentPane().add(subtotallabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 94, 20));

        VatsalesLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatsalesLabel.setText("VAT Sales:");
        getContentPane().add(VatsalesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 118, 20));

        VatLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatLabel.setText("VAT:");
        getContentPane().add(VatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 59, -1));

        totalAmount.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        totalAmount.setText("Total Amount: ");
        getContentPane().add(totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 650, -1, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("-------------------------------------------------------------------------");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

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
        PaymentTypeLabel.setText("Payment Type");
        getContentPane().add(PaymentTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 142, 20));

        ryy3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy3.setText("₱5.36");
        getContentPane().add(ryy3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, -1, 20));

        ryy4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy4.setText("None");
        getContentPane().add(ryy4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, -1, 20));

        ryy5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy5.setText("₱0.00");
        getContentPane().add(ryy5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, -1, 20));

        ryy6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy6.setText("₱50.00");
        getContentPane().add(ryy6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, -1, 20));

        ryy7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy7.setText("₱44.64");
        getContentPane().add(ryy7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, -1, 20));

        ryy8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ryy8.setText("₱50.00");
        getContentPane().add(ryy8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 640, 120, 40));

        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 680, 420, 90));

        ryy9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy9.setText("₱50.00");
        getContentPane().add(ryy9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, -1, 20));

        Time2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time2.setText("Plate Number:");
        getContentPane().add(Time2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 150, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/RECEIPT.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 910));

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Open thank you screen and close this receipt window
        new P15_TY_IN().setVisible(true);
        this.dispose();

        // Create PDFreceipt instance and set labels
        PDFreceipt pdf = new PDFreceipt();

        pdf.TicketNumber.setText(this.TicketCode.getText());
        pdf.transactionNumber.setText(this.transactionNumber.getText());
        pdf.DateLabel.setText(this.DateLabel.getText());
        pdf.TimeLabel.setText(this.TimeLabel.getText());
        pdf.PaymentTypeLabel.setText(this.PaymentTypeLabel.getText());

        // Generate and save PDF using text-based method
        pdf.saveTicketAsPDF();
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // For testing, you can pass dummy values here
                new P10_RECEIPT("ABC-1234", "Cash").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel Date;
    public javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DiscTypeLabel;
    private javax.swing.JLabel DiscountLabel;
    public javax.swing.JLabel PaymentTypeLabel;
    public javax.swing.JLabel Platenumber_receipt; // Title label "Plate Number:"
    public javax.swing.JLabel PlateNumberValueLabel; // Value label for plate number
    public javax.swing.JLabel TicketCode;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel Time2;
    public javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel VatLabel;
    private javax.swing.JLabel VatsalesLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel pl;
    private javax.swing.JLabel ryy3;
    private javax.swing.JLabel ryy4;
    private javax.swing.JLabel ryy5;
    private javax.swing.JLabel ryy6;
    private javax.swing.JLabel ryy7;
    private javax.swing.JLabel ryy8;
    private javax.swing.JLabel ryy9;
    private javax.swing.JLabel subtotallabel;
    private javax.swing.JLabel tn;
    private javax.swing.JLabel totalAmount;
    public javax.swing.JLabel transactionNumber;
    private javax.swing.JLabel unitcostlabel;
    // End of variables declaration                   
}
