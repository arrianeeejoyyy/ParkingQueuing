package parkingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class P08_GIF_SCANQR extends javax.swing.JFrame {

    private String plateNumber;
    private String paymentType;

    private Timer timer;

    public P08_GIF_SCANQR(String plateNumber, String paymentType) {
        this.plateNumber = plateNumber;
        this.paymentType = paymentType;

        initComponents();

        timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                P10_RECEIPT receipt = new P10_RECEIPT(P08_GIF_SCANQR.this.plateNumber, P08_GIF_SCANQR.this.paymentType);
                receipt.setVisible(true);
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIF/SCAN QR.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 890));

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // For testing, pass dummy values
                new P08_GIF_SCANQR("ABC-1234", "Card").setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
}
