package parkingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class P07_QR_FOR_CASHLESS extends javax.swing.JFrame {

    private String plateNumber;
    private String paymentType;

    private Timer timer;

    public P07_QR_FOR_CASHLESS(String plateNumber, String paymentType) {
        this.plateNumber = plateNumber;
        this.paymentType = paymentType;

        initComponents();

        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                P08_GIF_SCANQR p8 = new P08_GIF_SCANQR(P07_QR_FOR_CASHLESS.this.plateNumber, P07_QR_FOR_CASHLESS.this.paymentType);
                p8.setVisible(true);
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setToolTipText("");
        back.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/QR_FOR CASH LESS.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        P05_CHOOSE_PAYMENT p05 = new P05_CHOOSE_PAYMENT();
        p05.setVisible(true);
        QN_panel.getInstance().setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(P07_QR_FOR_CASHLESS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // For testing, pass dummy values
                new P07_QR_FOR_CASHLESS("ABC-1234", "Cashless").setVisible(true);
            }
        });
    }

    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
}