package parkingsystem;

import DATABASE.ParkingSlot;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class QN_panel extends javax.swing.JFrame {

    private static QN_panel instance;   // singleton instance
    public static DefaultTableModel model;

    private QN_panel() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
    }

    public static QN_panel getInstance() {
        if (instance == null) {
            instance = new QN_panel();
        }
        return instance;
    }

    // Method to add a parking row with more details
    public void addParkingRow(String slot, String plate, String ticketCode, String entryTime) {
        model.addRow(new Object[]{slot, plate, ticketCode, entryTime});
    }

    // Method to remove a parking row by slot name
    public void removeParkingRow(String slotName) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(slotName)) { // Assuming slot name is in the first column
                model.removeRow(i);
                break;
            }
        }
    }

    // Method to refresh the table with current data from ParkingData
    public void refreshTable() {
        model.setRowCount(0); // Clear existing rows
        for (Map.Entry<String, ParkingSlot> entry : P03_SELECTPARK.ParkingData.occupiedSlots.entrySet()) {
            ParkingSlot slot = entry.getValue();
            model.addRow(new Object[]{
                slot.getSlotName(),
                slot.getPlateNumber(),
                slot.getTicketCode(),
                slot.getEntryDateTime()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PIC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(1500, 150, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 270, 90));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Slot", "Plate Number", "Ticket Code", "Entry Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 310, 340));

        PIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SECOND_UI/2ND UI DATASTRUC.png"))); // NOI18N
        getContentPane().add(PIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QN_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QN_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QN_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QN_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QN_panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PIC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}