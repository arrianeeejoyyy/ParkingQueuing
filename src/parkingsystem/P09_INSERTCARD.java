
package parkingsystem;

import java.awt.event.ActionEvent;
import javax.swing.Timer;


public class P09_INSERTCARD extends javax.swing.JFrame {

 
    public P09_INSERTCARD() {
        initComponents();
        
         timer.setRepeats(false); // run only once
        timer.start();
    }
    
    //timer of the panel
    Timer timer = new Timer(5000, (ActionEvent e) -> {
        setVisible(false);
        P10_RECEIPT receipt = new P10_RECEIPT();
        receipt.setPlateNumber(PlateNumberHolder.getPlateNumber());
        receipt.setVisible(true);
    });

public void setHoldPlate(String plate) {
    holdplate.setText(plate); // holdplate is your JLabel
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        holdplate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIF/TAP CARD.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        holdplate.setText("jLabel2");
        getContentPane().add(holdplate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 800, 270, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new P09_INSERTCARD().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel holdplate;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
