
package parkingsystem;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import java.io.File;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


public class PDFticket extends javax.swing.JFrame {

    public PDFticket() {
        initComponents(); 
    }

    // Helper method to capture the panel as an image (if you want to save the receipt as an image and then convert to PDF)
    public BufferedImage getPanelImage() {
        BufferedImage image = new BufferedImage(jPanel1.getWidth(), jPanel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        jPanel1.paint(g2d);  // You may need to use your own panel for the receipt
        g2d.dispose();
        return image;
    }

    // Convert the panel image to a byte array (for PDF purposes)
    private byte[] bufferedImageToByteArray(BufferedImage image) throws IOException {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    public void savePanelImageAsPDF() {
    try {
        // Generate a unique filename based on the current date and time
        String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
        String fileName = "receipt_" + timestamp + ".pdf";

        // Get the user's Documents folder
        String userHome = System.getProperty("user.home");
        String documentsPath = userHome + File.separator + "Documents";
        File pdfFile = new File(documentsPath, fileName);

        // Capture the panel as an image
        BufferedImage receiptImage = getPanelImage();

        // Create a new PDF document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(receiptImage.getWidth(), receiptImage.getHeight()));
        document.addPage(page);

        // Convert BufferedImage to PDImageXObject
        PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, bufferedImageToByteArray(receiptImage), "receipt_image");

        // Write image to PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.drawImage(pdImage, 0, 0, receiptImage.getWidth(), receiptImage.getHeight());
        contentStream.close();

        // Save the PDF
        document.save(pdfFile);
        document.close();

        // Show confirmation dialog
        javax.swing.JOptionPane.showMessageDialog(this, "Receipt saved as PDF at:\n" + pdfFile.getAbsolutePath());

        // Attempt to open the PDF
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(pdfFile);

            // Set up a Timer to close PDF and show the next panel after 6 seconds
            Timer timer = new Timer(6000, (ActionEvent e) -> {
                // After 6 seconds, close the PDF and show another panel
                closePDFAndShowPanel();
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start(); // Start the timer

        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Automatic open not supported on this platform.");
        }

    } catch (IOException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error saving PDF: " + e.getMessage());
    }
}

    private void closePDFAndShowPanel() {

        this.setVisible(false);  
        this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TicketNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        platenumber = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        tn1 = new javax.swing.JLabel();
        tn2 = new javax.swing.JLabel();
        Time1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(450, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TicketNumber.setFont(new java.awt.Font("Arial", 1, 80)); // NOI18N
        TicketNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TicketNumber.setText("Ticket C");
        TicketNumber.setToolTipText("");
        jPanel1.add(TicketNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 430, 90));

        DateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DateLabel.setText("Date:");
        jPanel1.add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 226, 20));

        platenumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        platenumber.setText("Plate Number:");
        jPanel1.add(platenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 196, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("PARKPOINT PARKING SERVICES");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 145, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Location: Olaes Subd Noveleta, Cavite");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 185, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Email: PPPservices@gmail.com");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 214, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("---------------------------------------------------------------------------");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("****************************************");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 111, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel7.setText("....................................");
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, 31));

        Date.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Date.setText("Date:");
        jPanel1.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("PARKPOINT PARKING SERVICES");
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, -1));

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TimeLabel.setText("Time:");
        jPanel1.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 194, 20));

        transactionNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionNumber.setText("Transaction Number:");
        jPanel1.add(transactionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 196, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("THANKYOU FOR CHOOSING");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SECOND_UI/barccode.png"))); // NOI18N
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, -1));

        Time.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time.setText("PLEASE TAKE CARE OF THIS TICKET");
        jPanel1.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 330, 20));

        tn1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tn1.setText("Transaction Number:");
        jPanel1.add(tn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 196, 20));

        tn2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tn2.setText("Plate Number:");
        jPanel1.add(tn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 196, 20));

        Time1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time1.setText("Time:");
        jPanel1.add(Time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 53, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Create a JFrame for demonstration
       
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    public javax.swing.JLabel DateLabel;
    public javax.swing.JLabel TicketNumber;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel Time1;
    public javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel platenumber;
    private javax.swing.JLabel tn1;
    private javax.swing.JLabel tn2;
    public javax.swing.JLabel transactionNumber;
    // End of variables declaration//GEN-END:variables
}
