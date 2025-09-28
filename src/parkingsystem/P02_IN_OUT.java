package parkingsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public final class P02_IN_OUT extends javax.swing.JFrame {

  public static int Counter = 0;
  public static int counterServe = 0;
 
    public P02_IN_OUT() {
        initComponents();
        
             checkDailyResetCounterServe();
    updateCounterServeDisplay();
    }

   public int loadCounterFromFile() {
    int counter = 0;  // Default value if file doesn't exist or is empty
    try {
        File file = new File("src/DATABASE/Counter_P02.txt");
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextInt()) {
                counter = scanner.nextInt(); // Read the counter from the file
            }
            scanner.close();
        }
    } catch (IOException e) {
    }
    return counter;
}
   
   
 // Load counterServe from file
    public static void loadCounterServe() {
        try {
            File file = new File("src/DATABASE/CounterServe.txt");
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                if (scanner.hasNextInt()) {
                    counterServe = scanner.nextInt();
                }
                scanner.close();
            }
        } catch (IOException e) {
        }
    }

    // Save counterServe to file
    public static void saveCounterServe() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/DATABASE/CounterServe.txt"))) {
            writer.write(String.valueOf(counterServe));
        } catch (IOException e) {
        }
    }

    // Increment counterServe
    public static void incrementCounterServe() {
        loadCounterServe();   // always load latest value
        counterServe++;
        saveCounterServe();   // save updated value
    }

    // Reset counterServe daily
    private void checkDailyResetCounterServe() {
        try {
            File dateFile = new File("src/DATABASE/LastCounterServeDate.txt");
            String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String lastDate = "";

            if (dateFile.exists()) {
                Scanner scanner = new Scanner(dateFile);
                if (scanner.hasNextLine()) {
                    lastDate = scanner.nextLine();
                }
                scanner.close();
            }

            if (!today.equals(lastDate)) {
                counterServe = 0;
                saveCounterServe();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(dateFile))) {
                    writer.write(today);
                }
            }
        } catch (IOException e) {
        }
    }

    // Update countServe JLabel
    public void updateCounterServeDisplay() {
        loadCounterServe();
        countserve.setText(String.format("%02d", counterServe));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        out = new javax.swing.JButton();
        in = new javax.swing.JButton();
        countserve = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        out.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        out.setContentAreaFilled(false);
        out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outActionPerformed(evt);
            }
        });
        getContentPane().add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, 450, 110));

        in.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        in.setContentAreaFilled(false);
        in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inActionPerformed(evt);
            }
        });
        getContentPane().add(in, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 450, 110));

        countserve.setFont(new java.awt.Font("Arial", 1, 100)); // NOI18N
        countserve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countserve.setText("09");
        getContentPane().add(countserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 670, 290, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAIN_UI/IN&OUT_FNL.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outActionPerformed
    this.setVisible(false);
    P16_OUT outframe = new P16_OUT();
    outframe.setVisible(true);
    }//GEN-LAST:event_outActionPerformed

    private void inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inActionPerformed
     // Load the counter from the file
    int currentCounter = loadCounterFromFile();  

    // Check if the counter is less than or equal to 10
    if (currentCounter <= 9) {
        // If the counter is 10 or less, go to P03 (Select Park)
        P03_SELECTPARK selectParkFrame = new P03_SELECTPARK();
        selectParkFrame.setVisible(true);
    } else {
        // If the counter is greater than 10, go to P11 (Full Slot)
        P11_FULLSLOT p11Frame = new P11_FULLSLOT();
        p11Frame.setVisible(true);
    }

    // Close the current P02 window
    this.setVisible(false);
    }//GEN-LAST:event_inActionPerformed

   
   public void loadCounter() {
    try {
        File file = new File("src/DATABASE/Counter_P02.txt");
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextInt()) {
                Counter = scanner.nextInt(); // Read the counter from the file
            }
            scanner.close();
        }
    } catch (IOException e) {
    }
}

// Method to save the updated counter back to the text file
public void saveCounter() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/DATABASE/Counter_P02.txt"))) {
        writer.write(String.valueOf(Counter)); // Save the counter value to the text file
    } catch (IOException e) {
    }
}
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new P02_IN_OUT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countserve;
    private javax.swing.JButton in;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton out;
    // End of variables declaration//GEN-END:variables
}
