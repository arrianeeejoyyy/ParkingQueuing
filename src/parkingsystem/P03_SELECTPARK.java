
package parkingsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static parkingsystem.P03_SELECTPARK.ParkingData.occupiedSlots;


public final class P03_SELECTPARK extends javax.swing.JFrame {

    
     public P03_SELECTPARK() {
        initComponents();
        refreshLabels();

    }
    
    public void setSlotColor(String slotName, Color color) {
    switch (slotName) {
        case "R01": r1l.setBackground(color); r1l.setOpaque(true); break;
        case "R02": r2l.setBackground(color); r2l.setOpaque(true); break;
        case "R03": r3l.setBackground(color); r3l.setOpaque(true); break;
        case "R04": r4l.setBackground(color); r4l.setOpaque(true); break;
        case "R05": r5l.setBackground(color); r5l.setOpaque(true); break;
        case "L01": l1l.setBackground(color); l1l.setOpaque(true); break;
        case "L02": l2l.setBackground(color); l2l.setOpaque(true); break;
        case "L03": l3l.setBackground(color); l3l.setOpaque(true); break;
        case "L04": l4l.setBackground(color); l4l.setOpaque(true); break;
        case "L05": l5l.setBackground(color); l5l.setOpaque(true); break;
    }
}
    
   public static boolean releaseSlot(String slot, String code) {
    if (occupiedSlots.containsKey(slot) && occupiedSlots.get(slot).equals(code)) {
        occupiedSlots.remove(slot);

        // update UI (need instance reference for setSlotColor)
        P03_SELECTPARK instance = new P03_SELECTPARK();
        instance.setSlotColor(slot, Color.GREEN);

        return true;
    }
    return false;
}
     
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
        // Check if the slot is already occupied
        if (P03_SELECTPARK.ParkingData.occupiedSlots.containsKey(slotName)) {
            JOptionPane.showMessageDialog(this, 
                "Slot " + slotName + " is already occupied!", 
                "Error", 
                JOptionPane.WARNING_MESSAGE);
            return; // Stop here so it won’t continue
        }

        // Slot is free → check if QN_panel has queue data
        if (!QN_panel.getInstance().nextTicketField.getText().isEmpty()) {
            ParkingData.selectedSlot = slotName;
            new P3_ENTER_TC_CODE().setVisible(true);
            this.dispose();
        } else {
            ParkingData.selectedSlot = slotName;
            new P04_ENTER_PLATENUMBER().setVisible(true);
            this.dispose();
        }
    }

      public void refreshLabels() {
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

    // Read data from file and apply the colors to slots
    loadSlotStatusesFromFile();
}

    private void loadSlotStatusesFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/DATABASE/Intheslot.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Split the line by " - "
            String[] parts = line.split(" - ");
            if (parts.length >= 4) {  // <-- Your code here
                String slot = parts[0];
                String plate = parts[1];
                String status = parts[2];
                String color = parts[3];

                // Add the slot to the occupied slots map if occupied
                if (status.equals("Occupied")) {
                    ParkingData.occupiedSlots.put(slot, plate);
                }

                // Apply color to the slot label
                applySlotColor(slot, color);
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error reading slot statuses: " + e.getMessage());
    }
}

    private void applySlotColor(String slot, String color) {
        switch (slot) {
            case "R01":
                setLabelColor(r1l, color);
                break;
            case "R02":
                setLabelColor(r2l, color);
                break;
            case "R03":
                setLabelColor(r3l, color);
                break;
            case "R04":
                setLabelColor(r4l, color);
                break;
            case "R05":
                setLabelColor(r5l, color);
                break;
            case "L01":
                setLabelColor(l1l, color);
                break;
            case "L02":
                setLabelColor(l2l, color);
                break;
            case "L03":
                setLabelColor(l3l, color);
                break;
            case "L04":
                setLabelColor(l4l, color);
                break;
            case "L05":
                setLabelColor(l5l, color);
                break;
            default:
                break;
        }
    }

    private void setLabelColor(javax.swing.JLabel label, String color) {
        if (color.equals("RED")) {
            label.setOpaque(true);
            label.setBackground(Color.RED);
        } else if (color.equals("GREEN")) {
            label.setOpaque(true);
            label.setBackground(Color.GREEN);
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
        getContentPane().add(r1l, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 308, 100, 20));
        getContentPane().add(r2l, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 308, 100, 20));
        getContentPane().add(r3l, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 308, 100, 20));
        getContentPane().add(r4l, new org.netbeans.lib.awtextra.AbsoluteConstraints(831, 308, 100, 20));
        getContentPane().add(r5l, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 308, 100, 20));
        getContentPane().add(l1l, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 694, 100, 20));
        getContentPane().add(l2l, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 694, 100, 20));
        getContentPane().add(l3l, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 694, 100, 20));
        getContentPane().add(l4l, new org.netbeans.lib.awtextra.AbsoluteConstraints(831, 694, 100, 20));
        getContentPane().add(l5l, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 694, 100, 20));

        mainIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/SELECT_PARK_FNL.png"))); // NOI18N
        getContentPane().add(mainIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void L01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L01ActionPerformed
       slotButtonClicked("L01");
    }//GEN-LAST:event_L01ActionPerformed

    private void R01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01ActionPerformed
           slotButtonClicked("R01");
    }//GEN-LAST:event_R01ActionPerformed

    private void R02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02ActionPerformed
         slotButtonClicked("R02");
    }//GEN-LAST:event_R02ActionPerformed

    private void R03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03ActionPerformed
         slotButtonClicked("R033");
    }//GEN-LAST:event_R03ActionPerformed

    private void R04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04ActionPerformed
        slotButtonClicked("R04");
    }//GEN-LAST:event_R04ActionPerformed

    private void R05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05ActionPerformed
        slotButtonClicked("R05");
    }//GEN-LAST:event_R05ActionPerformed

    private void L02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L02ActionPerformed
        slotButtonClicked("L02");
    }//GEN-LAST:event_L02ActionPerformed

    private void L03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L03ActionPerformed
      slotButtonClicked("L03");
    }//GEN-LAST:event_L03ActionPerformed

    private void L04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L04ActionPerformed
       slotButtonClicked("L04");
    }//GEN-LAST:event_L04ActionPerformed

    private void L05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L05ActionPerformed
      slotButtonClicked("L05");
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
