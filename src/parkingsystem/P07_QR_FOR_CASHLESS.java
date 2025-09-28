
package parkingsystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class P07_QR_FOR_CASHLESS extends javax.swing.JFrame {

    public P07_QR_FOR_CASHLESS() {
        initComponents();
        
        timer.setRepeats(false);
        timer.start();
    }
    
    //timer of the panel 
     Timer timer = new Timer(5000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        P08_GIF_SCANQR p08 = new P08_GIF_SCANQR();
        p08.setHoldPlate(holdplate.getText()); // pass plate to P08
        p08.setVisible(true);
    }
});
     
   public void setHoldPlate(String plate) {
    holdplate.setText(plate); 
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        holdplate = new javax.swing.JLabel();

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

        holdplate.setText("jLabel2");
        getContentPane().add(holdplate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 800, 270, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        P05_CHOOSE_PAYMENT P02 = new P05_CHOOSE_PAYMENT();
        P02.setVisible(true);
        QN_panel.getInstance().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new P07_QR_FOR_CASHLESS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel holdplate;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
