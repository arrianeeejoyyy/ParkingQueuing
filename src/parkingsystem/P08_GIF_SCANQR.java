
package parkingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import parkingsystem.PlateNumberHolder;

public class P08_GIF_SCANQR extends javax.swing.JFrame {

   
    public P08_GIF_SCANQR() {
        initComponents();
        
         timer.setRepeats(false); // run only once
        timer.start();
    }
Timer timer = new Timer(5000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        P10_RECEIPT receipt = new P10_RECEIPT();
        receipt.setPlateNumber(holdplate.getText()); // pass plate to P10
        receipt.setVisible(true);
    }
});

public void setHoldPlate(String plate) {
    holdplate.setText(plate);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        holdplate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIF/SCAN QR.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 890));

        holdplate.setText("jLabel2");
        getContentPane().add(holdplate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 800, 270, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P08_GIF_SCANQR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel holdplate;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

   
}
