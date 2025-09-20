package parkingsystem;

import DATABASE.ParkingDataManager;
import DATABASE.ParkingSlot;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P05_CHOOSE_PAYMENT extends javax.swing.JFrame {

    // Static field to hold the selected payment type
    public static String currentPaymentType = "";

    public P05_CHOOSE_PAYMENT() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/CHOOSE PAYMENT .png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }

    private void CASHActionPerformed(java.awt.event.ActionEvent evt) {                                     
        currentPaymentType = "Cash";
        String plateNumber = P04_ENTER_PLATENUMBER.tempPlateNumber;
        P06_GIf_INSERTMONEY p6 = new P06_GIf_INSERTMONEY(plateNumber, currentPaymentType);
        p6.setVisible(true);
        QN_panel.getInstance().setVisible(true);
        this.setVisible(false);
    }                                    

    private void CARDActionPerformed(java.awt.event.ActionEvent evt) {                                     
        currentPaymentType = "Card";
        String plateNumber = P04_ENTER_PLATENUMBER.tempPlateNumber;
        P09_INSERTCARD p9 = new P09_INSERTCARD(plateNumber, currentPaymentType);
        p9.setVisible(true);
        this.setVisible(false);
    }                                    

    private void CASHLESSActionPerformed(java.awt.event.ActionEvent evt) {                                         
        currentPaymentType = "Cashless";
        String plateNumber = P04_ENTER_PLATENUMBER.tempPlateNumber;
        P07_QR_FOR_CASHLESS p7 = new P07_QR_FOR_CASHLESS(plateNumber, currentPaymentType);
        p7.setVisible(true);
        this.setVisible(false);
    }                                        

    private void CONFIRMActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (currentPaymentType == null || currentPaymentType.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a payment type before confirming.", "Payment Type Required", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String plateNumber = P04_ENTER_PLATENUMBER.tempPlateNumber;

        if (plateNumber == null || plateNumber.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Plate number is missing. Please start over.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        P10_RECEIPT receiptFrame = new P10_RECEIPT(plateNumber, currentPaymentType);

        String slotName = P03_SELECTPARK.ParkingData.selectedSlot;
        if (slotName != null) {
            String entryDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            ParkingSlot newParking = new ParkingSlot(
                slotName,
                plateNumber,
                receiptFrame.TicketCode.getText().trim(),
                receiptFrame.transactionNumber.getText().trim(),
                currentPaymentType,
                entryDateTime
            );

            P03_SELECTPARK.ParkingData.occupiedSlots.put(slotName, newParking);

            QN_panel.getInstance().addParkingRow(
                newParking.getSlotName(),
                newParking.getPlateNumber(),
                newParking.getTicketCode(),
                newParking.getEntryDateTime()
            );

            ParkingDataManager.saveParkingData(P03_SELECTPARK.ParkingData.occupiedSlots);
        }

        this.setVisible(false);
        receiptFrame.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(P05_CHOOSE_PAYMENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P05_CHOOSE_PAYMENT().setVisible(true);
            }
        });
    }

    private javax.swing.JButton CARD;
    private javax.swing.JButton CASH;
    private javax.swing.JButton CASHLESS;
    private javax.swing.JButton CONFIRM;
    private javax.swing.JLabel jLabel1;
}
