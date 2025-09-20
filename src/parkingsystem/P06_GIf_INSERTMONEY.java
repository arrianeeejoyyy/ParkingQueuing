package parkingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class P06_GIf_INSERTMONEY extends javax.swing.JFrame {

    private String plateNumber;
    private String paymentType;

    private Timer timer;

    public P06_GIf_INSERTMONEY(String plateNumber, String paymentType) {
        this.plateNumber = plateNumber;
        this.paymentType = paymentType;

        initComponents();

        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                P10_RECEIPT receipt = new P10_RECEIPT(P06_GIf_INSERTMONEY.this.plateNumber, P06_GIf_INSERTMONEY.this.paymentType);
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIF/MONEY.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
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
            java.util.logging.Logger.getLogger(P06_GIf_INSERTMONEY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // For testing, pass dummy values
                new P06_GIf_INSERTMONEY("ABC-1234", "Cash").setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
}