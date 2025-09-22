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

    private javax.swing.JLabel[] ticketLabels; // Array to hold ticket labels
    
    private QN_panel() {
        initComponents();
                                                                
     // Initialize stack labels (example: 5 labels)
        ticketLabels = new javax.swing.JLabel[]{one, two, three, four, five,six,seven, eight, nine,ten, eleven,twelve,thirteen, fourteen};

        // Load saved tickets into stack labels
        loadTicketsFromFile();
    }

    
    private void initializeTicketLabels() {
    ticketLabels = new javax.swing.JLabel[]{
        one, // replace with your actual label names
        two,
        three,
        four,
        five,
        six,
        seven,
        eight,
        nine,
        ten,
        eleven,
        twelve,
        thirteen,
        fourteen// add all labels you have for stacking
    };
}
    
     public static QN_panel getInstance() {
        if (instance == null) {
            instance = new QN_panel();
        }
        return instance;
    }

     
     public void addTicketToStack(String ticketCode) {
    for (javax.swing.JLabel lbl : ticketLabels) {
        if (lbl.getText().isEmpty()) {  // empty slot
            lbl.setText(ticketCode);
            break;
        }
    }
}
     
     
     public String popNextTicket() {
    String nextTicket = ticketLabels[0].getText();
    for (int i = 0; i < ticketLabels.length - 1; i++) {
        ticketLabels[i].setText(ticketLabels[i+1].getText());
    }
    ticketLabels[ticketLabels.length - 1].setText(""); // last one is empty
    return nextTicket;
}
     
     public boolean hasTickets() {
    return !ticketLabels[0].getText().isEmpty();
}

      // Add new ticket (push)
    public void pushTicket(String ticketCode, String plate) {
    try {
        File file = new File("src/DATABASE/QN_ticket.txt");
        List<String> tickets = new ArrayList<>();

        // Read existing tickets
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) tickets.add(line);
            br.close();
        }

        // Add new ticket at the end (bottom of stack)
        tickets.add(ticketCode + " | " + plate);

        // Save back to file
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
        for (String s : tickets) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();

        // Update stacking labels
        List<String> codesOnly = new ArrayList<>();
        for (String s : tickets) codesOnly.add(s.split("\\|")[0].trim());
        updateStackLabels(codesOnly);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
     public String popTicket() {
    File file = new File("src/DATABASE/QN_ticket.txt");
    if (!file.exists()) return null;

    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> tickets = new ArrayList<>();
        String topTicket = br.readLine(); // first ticket in file
        String line;
        while ((line = br.readLine()) != null) tickets.add(line);
        br.close();

        // Save remaining tickets
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
        for (String s : tickets) bw.write(s + "\n");
        bw.close();

        // Update stacking labels
        List<String> codesOnly = new ArrayList<>();
        for (String s : tickets) codesOnly.add(s.split("\\|")[0].trim());
        updateStackLabels(codesOnly);

        return (topTicket != null) ? topTicket.split("\\|")[0].trim() : null;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
      
      
     private void updateStackLabels(List<String> tickets) {
    // Keep nextTicketField empty
    nextTicketField.setText("");

    // Fill the labels with all tickets (from first to last)
    for (int i = 0; i < ticketLabels.length; i++) {
        if (i < tickets.size()) {
            ticketLabels[i].setText(tickets.get(i)); // show ticket code
        } else {
            ticketLabels[i].setText(""); // empty if no ticket
        }
    }
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
   public void loadTicketsFromFile() {
    initializeTicketLabels();

    File file = new File("src/DATABASE/QN_ticket.txt");
    if (!file.exists()) return;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        List<String> tickets = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().length() >= 6) {
                tickets.add(line.split("\\|")[0].trim()); // only ticket code
            }
        }

        // Update stacking labels
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

  public void serveNextTicket(javax.swing.JTextField targetField) {
    if(ticketLabels[0].getText().isEmpty()) {
        targetField.setText("");
        return;
    }

    targetField.setText(ticketLabels[0].getText());

    // Remove first line from file
    try {
        File file = new File("src/DATABASE/NEXTTOSERVE.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        boolean firstSkipped = false;

        while ((line = reader.readLine()) != null) {
            if(!firstSkipped) {
                firstSkipped = true; // skip the first line
                continue;
            }
            sb.append(line).append("\n");
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(sb.toString());
        writer.close();

        // Shift labels up
        for(int i=0; i<ticketLabels.length-1; i++) {
            ticketLabels[i].setText(ticketLabels[i+1].getText());
        }
        ticketLabels[ticketLabels.length-1].setText("");

    } catch(Exception e) {
        e.printStackTrace();
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

  
    public static void main(String args[]) {
       
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
