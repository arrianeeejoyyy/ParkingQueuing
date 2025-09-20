package parkingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class P09_INSERTCARD extends javax.swing.JFrame {

    private String plateNumber;
    private String paymentType;

    private Timer timer;

    public P09_INSERTCARD(String plateNumber, String paymentType) {
        this.plateNumber = plateNumber;
        this.paymentType = paymentType;

        initComponents();

        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                P10_RECEIPT receipt = new P10_RECEIPT(P09_INSERTCARD.this.plateNumber, P09_INSERTCARD.this.paymentType);
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIF/TAP CARD.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P09_INSERTCARD("ABC-1234", "Card").setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
}
