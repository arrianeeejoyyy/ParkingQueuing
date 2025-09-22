package parkingsystem;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class QN_panel extends javax.swing.JFrame {
    
     private static QN_panel instance;

    private javax.swing.JLabel[] stackLabels; // Array to hold ticket labels
    
    private QN_panel() {
        initComponents();
                                                                
     // Initialize stack labels (example: 5 labels)
        stackLabels = new javax.swing.JLabel[]{one, two, three, four, five,six,seven, eight, nine,ten, eleven,twelve,thirteen, fourteen};

        // Load saved tickets into stack labels
        loadTicketsFromFile();
    }

     public static QN_panel getInstance() {
        if (instance == null) {
            instance = new QN_panel();
        }
        return instance;
    }


      // Add new ticket (push)
    public void pushTicket(String ticketCode) {
        try {
            File file = new File("src/DATABASE/QN_ticket.txt");
            List<String> lines = new ArrayList<>();

            // Add new ticket at the top
            lines.add(ticketCode);

            // Read existing tickets and append
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
                br.close();
            }

            // Save all tickets back
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            for (String s : lines) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();

            // Update stack labels
            updateStackLabels(lines);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public String popTicket() {
        try {
            File file = new File("src/DATABASE/QN_ticket.txt");
            if (!file.exists()) return null;

            BufferedReader br = new BufferedReader(new FileReader(file));
            List<String> lines = new ArrayList<>();
            String top = br.readLine(); // first ticket (top)
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();

            // Save remaining tickets
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            for (String s : lines) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();

            // Update stack labels
            updateStackLabels(lines);

            return top;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      
      
      private void updateStackLabels(List<String> tickets) {
        // nextTicketField shows top ticket
        if (!tickets.isEmpty()) {
            nextTicketField.setText(tickets.get(0));
        } else {
            nextTicketField.setText("");
        }

        // Shift the rest into labels
        for (int i = 0; i < stackLabels.length; i++) {
            if (i + 1 < tickets.size()) {
                stackLabels[i].setText(tickets.get(i + 1));
            } else {
                stackLabels[i].setText("");
            }
        }

        saveNextTicketField();
    }
      
        // Save top ticket
    private void saveNextTicketField() {
        try {
            File file = new File("src/DATABASE/NEXTTOSERVE.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            bw.write(nextTicketField.getText());
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load tickets on startup
    private void loadTicketsFromFile() {
        try {
            File file = new File("src/DATABASE/QN_ticket.txt");
            if (!file.exists()) return;

            List<String> tickets = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                tickets.add(line);
            }
            br.close();

            updateStackLabels(tickets);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public static class Helper {
    public static void clearNextTicketField() {
        if (nextTicketField != null) {
            nextTicketField.setText("");  // clear it
        }
    }
}

   
   


// Load the next ticket from NEXTTOSERVE.txt
public void loadNextTicketField() {
    try {
        File file = new File("src/DATABASE/NEXTTOSERVE.txt");
        if (!file.exists()) return;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String nextTicket = br.readLine();
        if (nextTicket != null) {
            nextTicketField.setText(nextTicket);
        }
        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nextTicketField = new javax.swing.JLabel();
        nine = new javax.swing.JLabel();
        three = new javax.swing.JLabel();
        one = new javax.swing.JLabel();
        four = new javax.swing.JLabel();
        five = new javax.swing.JLabel();
        seven = new javax.swing.JLabel();
        two = new javax.swing.JLabel();
        six = new javax.swing.JLabel();
        ten = new javax.swing.JLabel();
        eleven = new javax.swing.JLabel();
        twelve = new javax.swing.JLabel();
        thirteen = new javax.swing.JLabel();
        fourteen = new javax.swing.JLabel();
        eight = new javax.swing.JLabel();
        PIC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(1500, 150, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nextTicketField.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        nextTicketField.setForeground(new java.awt.Color(255, 255, 255));
        nextTicketField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nextTicketField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 270, 90));

        nine.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        nine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nine.setText("123456");
        getContentPane().add(nine, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        three.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        three.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        three.setText("123456");
        getContentPane().add(three, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        one.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        one.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        one.setText("123456");
        getContentPane().add(one, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        four.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        four.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        four.setText("123456");
        getContentPane().add(four, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        five.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        five.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        five.setText("123456");
        getContentPane().add(five, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        seven.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        seven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seven.setText("123456");
        getContentPane().add(seven, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, -1, -1));

        two.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        two.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        two.setText("123456");
        getContentPane().add(two, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        six.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        six.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        six.setText("123456");
        getContentPane().add(six, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, -1));

        ten.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ten.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ten.setText("123456");
        getContentPane().add(ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, -1, -1));

        eleven.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        eleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eleven.setText("123456");
        getContentPane().add(eleven, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, -1, -1));

        twelve.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        twelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelve.setText("123456");
        getContentPane().add(twelve, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, -1, -1));

        thirteen.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        thirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteen.setText("123456");
        getContentPane().add(thirteen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 590, -1, -1));

        fourteen.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        fourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteen.setText("123456");
        getContentPane().add(fourteen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 640, -1, -1));

        eight.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        eight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eight.setText("123456");
        getContentPane().add(eight, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        PIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SECOND_UI/2ND UI DATASTRUC.png"))); // NOI18N
        getContentPane().add(PIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JLabel eight;
    private javax.swing.JLabel eleven;
    private javax.swing.JLabel five;
    private javax.swing.JLabel four;
    private javax.swing.JLabel fourteen;
    public static javax.swing.JLabel nextTicketField;
    private javax.swing.JLabel nine;
    private javax.swing.JLabel one;
    private javax.swing.JLabel seven;
    private javax.swing.JLabel six;
    private javax.swing.JLabel ten;
    private javax.swing.JLabel thirteen;
    private javax.swing.JLabel three;
    private javax.swing.JLabel twelve;
    private javax.swing.JLabel two;
    // End of variables declaration//GEN-END:variables

    void addParkingRow(String slot, String plate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
