
package parkingsystem;

import java.awt.Color;
import java.util.HashMap;
import static parkingsystem.P03_SELECTPARK.ParkingData.occupiedSlots;


public class P03_SELECTPARK extends javax.swing.JFrame {
    public class ParkingData {
        public static String selectedSlot = null;
        public static HashMap<String, String> occupiedSlots = new HashMap<>();
        static String SelectedSlot;
        public static boolean releaseSlot(String slot, String code) {
            if(occupiedSlots.containsKey(slot) && occupiedSlots.get(slot).equals(code)); {
            occupiedSlots.remove(slot);
            return true;
        }
            
        }

        static boolean releasedSlot(String slot, String enteredCode) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }
    
    private void slotButtonClicked(String slotName) {
    // Check if the slot is already taken
    if (ParkingData.occupiedSlots.containsKey(slotName)) {
        // Show a simple message dialog if the slot is already taken
        javax.swing.JOptionPane.showMessageDialog(this, 
            "This slot is already taken. Please choose another slot.", 
            "Slot Taken", 
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
        // Stay on the current panel, do nothing further
    } else {
        // If the slot is not taken, proceed with the selection
        ParkingData.selectedSlot = slotName; 
        new P04_ENTER_PLATENUMBER().setVisible(true);
        this.dispose(); // Dispose the current panel after moving to the next
    }
}
    
    
    public P03_SELECTPARK() {
        initComponents();
        refreshLabels();
    }
    
  
    private void refreshLabels() {
        setLabelColor(r1l, "R01");
        setLabelColor(r2l, "R02");
        setLabelColor(r3l, "R03");
        setLabelColor(r4l, "R04");
        setLabelColor(r5l, "R05");
        setLabelColor(l1l, "L01");
        setLabelColor(l2l, "L02");
        setLabelColor(l3l, "L03");
        setLabelColor(l4l, "L04");
        setLabelColor(l5l, "L05");
}

    private void setLabelColor(javax.swing.JLabel label, String slot) {
        if (ParkingData.occupiedSlots.containsKey(slot)) {
            label.setOpaque(true);
            label.setBackground(Color.RED);
        } else {
            label.setOpaque(false);
            label.setBackground(null);
        }
    }

    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        R01 = new javax.swing.JButton();
        R02 = new javax.swing.JButton();
        R03 = new javax.swing.JButton();
        R04 = new javax.swing.JButton();
        R05 = new javax.swing.JButton();
        L01 = new javax.swing.JButton();
        L02 = new javax.swing.JButton();
        L03 = new javax.swing.JButton();
        L04 = new javax.swing.JButton();
        L05 = new javax.swing.JButton();
        r1l = new javax.swing.JLabel();
        r2l = new javax.swing.JLabel();
        r3l = new javax.swing.JLabel();
        r4l = new javax.swing.JLabel();
        r5l = new javax.swing.JLabel();
        l1l = new javax.swing.JLabel();
        l2l = new javax.swing.JLabel();
        l3l = new javax.swing.JLabel();
        l4l = new javax.swing.JLabel();
        l5l = new javax.swing.JLabel();
        mainIMG = new javax.swing.JLabel();

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

        R01.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        R01.setContentAreaFilled(false);
        R01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01ActionPerformed(evt);
            }
        });
        getContentPane().add(R01, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 100, 80));

        R02.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        R02.setContentAreaFilled(false);
        R02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02ActionPerformed(evt);
            }
        });
        getContentPane().add(R02, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 100, 80));

        R03.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        R03.setContentAreaFilled(false);
        R03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03ActionPerformed(evt);
            }
        });
        getContentPane().add(R03, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 100, 80));

        R04.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        R04.setContentAreaFilled(false);
        R04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04ActionPerformed(evt);
            }
        });
        getContentPane().add(R04, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 100, 80));

        R05.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        R05.setContentAreaFilled(false);
        R05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05ActionPerformed(evt);
            }
        });
        getContentPane().add(R05, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 340, 100, 80));

        L01.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        L01.setContentAreaFilled(false);
        L01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L01ActionPerformed(evt);
            }
        });
        getContentPane().add(L01, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, 100, 80));

        L02.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        L02.setContentAreaFilled(false);
        L02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L02ActionPerformed(evt);
            }
        });
        getContentPane().add(L02, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 600, 100, 80));

        L03.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        L03.setContentAreaFilled(false);
        L03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L03ActionPerformed(evt);
            }
        });
        getContentPane().add(L03, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 600, 100, 80));

        L04.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        L04.setContentAreaFilled(false);
        L04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L04ActionPerformed(evt);
            }
        });
        getContentPane().add(L04, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 600, 100, 80));

        L05.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        L05.setContentAreaFilled(false);
        L05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L05ActionPerformed(evt);
            }
        });
        getContentPane().add(L05, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 600, 100, 80));
        getContentPane().add(r1l, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 306, 100, 20));
        getContentPane().add(r2l, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 100, 20));
        getContentPane().add(r3l, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 306, 100, 20));
        getContentPane().add(r4l, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 310, 100, 20));
        getContentPane().add(r5l, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 306, 100, 20));
        getContentPane().add(l1l, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 696, 100, 20));
        getContentPane().add(l2l, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 696, 100, 20));
        getContentPane().add(l3l, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 696, 100, 20));
        getContentPane().add(l4l, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 696, 100, 20));
        getContentPane().add(l5l, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 696, 100, 20));

        mainIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/SELECT_PARK_FNL.png"))); // NOI18N
        getContentPane().add(mainIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void L01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L01ActionPerformed
        slotButtonClicked("L01");
       
       this.setVisible(false);
    }//GEN-LAST:event_L01ActionPerformed

    private void R01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01ActionPerformed
        slotButtonClicked("R01");
        
       this.setVisible(false);
    }//GEN-LAST:event_R01ActionPerformed

    private void R02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02ActionPerformed
         slotButtonClicked("R02");
        
       this.setVisible(false);
    }//GEN-LAST:event_R02ActionPerformed

    private void R03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03ActionPerformed
         slotButtonClicked("R03");
       
       this.setVisible(false);
    }//GEN-LAST:event_R03ActionPerformed

    private void R04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04ActionPerformed
        slotButtonClicked("R04");
       
       this.setVisible(false);
    }//GEN-LAST:event_R04ActionPerformed

    private void R05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05ActionPerformed
        slotButtonClicked("R05");
       
       this.setVisible(false);
    }//GEN-LAST:event_R05ActionPerformed

    private void L02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L02ActionPerformed
        slotButtonClicked("L02");
     
       this.setVisible(false);
    }//GEN-LAST:event_L02ActionPerformed

    private void L03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L03ActionPerformed
        slotButtonClicked("L03");
     
       this.setVisible(false);
    }//GEN-LAST:event_L03ActionPerformed

    private void L04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L04ActionPerformed
        slotButtonClicked("L04");
      
       this.setVisible(false);
    }//GEN-LAST:event_L04ActionPerformed

    private void L05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L05ActionPerformed
         slotButtonClicked("L05");
       
       this.setVisible(false);
    }//GEN-LAST:event_L05ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        P02_IN_OUT P02 = new P02_IN_OUT();
        P02.setVisible(true);
        QN_panel.getInstance().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P03_SELECTPARK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton L01;
    private javax.swing.JButton L02;
    private javax.swing.JButton L03;
    private javax.swing.JButton L04;
    private javax.swing.JButton L05;
    private javax.swing.JButton R01;
    private javax.swing.JButton R02;
    private javax.swing.JButton R03;
    private javax.swing.JButton R04;
    private javax.swing.JButton R05;
    private javax.swing.JButton back;
    private javax.swing.JLabel l1l;
    private javax.swing.JLabel l2l;
    private javax.swing.JLabel l3l;
    private javax.swing.JLabel l4l;
    private javax.swing.JLabel l5l;
    private javax.swing.JLabel mainIMG;
    private javax.swing.JLabel r1l;
    private javax.swing.JLabel r2l;
    private javax.swing.JLabel r3l;
    private javax.swing.JLabel r4l;
    private javax.swing.JLabel r5l;
    // End of variables declaration//GEN-END:variables
}
