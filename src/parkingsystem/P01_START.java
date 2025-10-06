package parkingsystem;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public final class P01_START extends javax.swing.JFrame {

    public P01_START() {
        initComponents();
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        start = new javax.swing.JButton();
        imgstart = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        start.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        start.setContentAreaFilled(false);
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        getContentPane().add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 300, 100));

        imgstart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/START_FNL.png"))); // NOI18N
        getContentPane().add(imgstart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
    //playsound
    playNotificationSound();
        
    this.setVisible(false);
    P02_IN_OUT inOutFrame = new P02_IN_OUT();
    inOutFrame.setVisible(true);
    }//GEN-LAST:event_startActionPerformed

       public void playNotificationSound() {
    try {
        File soundFile = new File("src/SOUNDS/welcome.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
    }
}
    
   
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new P01_START().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgstart;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
