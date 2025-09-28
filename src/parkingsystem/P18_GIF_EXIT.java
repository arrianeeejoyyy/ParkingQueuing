package parkingsystem;

import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class P18_GIF_EXIT extends javax.swing.JFrame {

    public P18_GIF_EXIT() {
        initComponents();
        
         timer.setRepeats(false); // run only once
        timer.start();
    }

   Timer timer = new Timer(5000, (ActionEvent e) -> {
       // Close or hide the JFrame after 3 seconds
       setVisible(false);   // just hide
       P01_START P01 = new P01_START();
       P01.setVisible(true);          // fully close the window
    });
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIF/EXIT.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new P18_GIF_EXIT().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
