package parkingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class P08_GIF_SCANQR extends javax.swing.JFrame {

    private String plateNumber;
    private String paymentType;

    // Constructor accepts plate number and payment type
    public P08_GIF_SCANQR(String plateNumber, String paymentType) {
        this.plateNumber = plateNumber;
        this.paymentType = paymentType;
        initComponents();

        timer.setRepeats(false); // run only once
        timer.start();
    }

    Timer timer = new Timer(4000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);   // hide this frame
            // Pass plateNumber and paymentType to P10_RECEIPT
            P10_RECEIPT P10 = new P10_RECEIPT(plateNumber, paymentType);
            P10.setVisible(true);
        }
    });

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIF/SCAN QR.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 890));

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // For testing, pass dummy plate and payment type
                new P08_GIF_SCANQR("ABC-1234", "Cash").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
