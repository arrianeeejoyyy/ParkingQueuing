package parkingsystem;

import DATABASE.ParkingDataManager;
import parkingsystem.P03_SELECTPARK.ParkingData;

public class PARKINGSYSTEM {

    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(PARKINGSYSTEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PARKINGSYSTEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PARKINGSYSTEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PARKINGSYSTEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Load parking data when the application starts
                ParkingData.occupiedSlots = ParkingDataManager.loadParkingData();

                P01_START lc = new P01_START();
                lc.setVisible(true);

                // Ensure QN_panel is initialized and visible
                QN_panel.getInstance().setVisible(true);
                // After loading, refresh QN_panel with loaded data
                QN_panel.getInstance().refreshTable();
            }
        });
    }
}