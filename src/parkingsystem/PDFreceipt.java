
package parkingsystem;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.File;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


public class PDFreceipt extends javax.swing.JFrame {

    public PDFreceipt() {
        initComponents();
        
        
    }

   public void saveTicketAsPDF() {
        try {
            // Get the user's Documents folder
            String userHome = System.getProperty("user.home");
            String documentsPath = userHome + File.separator + "Documents";
            String fileName = "ticket_" + System.currentTimeMillis() + ".pdf";
            File pdfFile = new File(documentsPath, fileName);

            // Create a new PDF document
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.LETTER); // A4 size, you can change it to LETTER
            document.addPage(page);

            // Create a content stream to write the content to the PDF
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Start writing text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            contentStream.newLineAtOffset(50, 750); // Starting position (x, y)
            contentStream.showText("DISPLAY HUB Receipt");

            // Set font for the ticket details (smaller font)
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.newLineAtOffset(0, -25);
            contentStream.showText("Ticket Number: " + TicketNumber.getText());
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Transaction Number: " + transactionNumber.getText());
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Date: " + DateLabel.getText());
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Time: " + TimeLabel.getText());
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Payment Type: " + PaymentTypeLabel.getText());
            contentStream.newLineAtOffset(0, -30);

            
            contentStream.endText();
            contentStream.close();

            // Save the PDF file
            document.save(pdfFile);
            document.close();

            // Optional: Show confirmation dialog
            javax.swing.JOptionPane.showMessageDialog(this, "Receipt saved to:\n" + pdfFile.getAbsolutePath());

            // Open the saved PDF file using the default PDF viewer
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Automatic open not supported on this platform.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving PDF: " + e.getMessage());
        }
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
            Timer timer = new Timer(6000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // After 6 seconds, close the PDF and show another panel
                    closePDFAndShowPanel();
                    
                    
                }
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start(); // Start the timer

        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Automatic open not supported on this platform.");
        }

    } catch (IOException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error saving PDF: " + e.getMessage());
    }
}

private void closePDFAndShowPanel() {
    // Close the PDF (this cannot be done directly via code, but you can rely on the system closing it after a while)
    // We can switch to another panel in the NetBeans JFrame here:

    // Hide the current PDF view or close the frame
    this.setVisible(false);  // Hide the current frame, or you can close it with dispose() if needed

    // Show another panel or frame
    // Assuming you want to show a different JPanel:
    P14_WaitQueue newPanel = new P14_WaitQueue();
    newPanel.setVisible(true);// Replace NewPanel with your actual panel class
    this.getContentPane().removeAll();
    this.getContentPane().add(newPanel);
    this.revalidate();
    this.repaint();
}
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TicketNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        VatLabel = new javax.swing.JLabel();
        tn = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        subtotallabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        VatsalesLabel = new javax.swing.JLabel();
        unitcostlabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        ryy = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PaymentTypeLabel = new javax.swing.JLabel();
        ryy4 = new javax.swing.JLabel();
        ryy5 = new javax.swing.JLabel();
        ryy6 = new javax.swing.JLabel();
        Time1 = new javax.swing.JLabel();
        ryy2 = new javax.swing.JLabel();
        ryy1 = new javax.swing.JLabel();
        ryy3 = new javax.swing.JLabel();
        pl = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        DiscountLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DiscTypeLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(450, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        TicketNumber.setFont(new java.awt.Font("Arial", 1, 70)); // NOI18N
        TicketNumber.setText("R NO.");
        TicketNumber.setToolTipText("");
        jPanel1.add(TicketNumber);
        TicketNumber.setBounds(70, 170, 310, 60);

        DateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DateLabel.setText("Date:");
        jPanel1.add(DateLabel);
        DateLabel.setBounds(100, 295, 226, 20);

        VatLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatLabel.setText("VAT:");
        jPanel1.add(VatLabel);
        VatLabel.setBounds(44, 559, 59, 22);

        tn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tn.setText("Transaction Number:");
        jPanel1.add(tn);
        tn.setBounds(50, 270, 196, 20);

        totalAmount.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        totalAmount.setText("Total Amount: ");
        jPanel1.add(totalAmount);
        totalAmount.setBounds(44, 598, 170, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("PARKPOINT PARKING SERVICES");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 20, 385, 28);

        subtotallabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        subtotallabel.setText("Subtotal:");
        jPanel1.add(subtotallabel);
        subtotallabel.setBounds(44, 507, 94, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Location: Olaes Subd Noveleta, Cavite");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 50, 268, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("\"THIS IS A OFFICIAL RECEIPT \"");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(90, 110, 280, 22);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("---------------------------------------------------------------------------");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(44, 243, 375, 17);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("****************************************");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 140, 360, 28);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel7.setText("....................................");
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(44, 629, 360, 31);

        Date.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Date.setText("Date:");
        jPanel1.add(Date);
        Date.setBounds(50, 295, 47, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("PARKPOINT PARKING SERVICES");
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(99, 689, 220, 17);

        VatsalesLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatsalesLabel.setText("VAT Sales:");
        jPanel1.add(VatsalesLabel);
        VatsalesLabel.setBounds(44, 533, 118, 20);

        unitcostlabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        unitcostlabel.setText("Unit Cost/Price :");
        jPanel1.add(unitcostlabel);
        unitcostlabel.setBounds(44, 425, 153, 20);

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TimeLabel.setText("Time:");
        jPanel1.add(TimeLabel);
        TimeLabel.setBounds(110, 320, 194, 20);

        ryy.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy.setText("₱50.00");
        jPanel1.add(ryy);
        ryy.setBounds(351, 507, 57, 20);

        transactionNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionNumber.setText("number");
        jPanel1.add(transactionNumber);
        transactionNumber.setBounds(240, 270, 196, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("THANKYOU FOR CHOOSING");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(113, 666, 192, 17);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("---------------------------------------------------------------------------");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 370, 375, 17);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SECOND_UI/barccode.png"))); // NOI18N
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(124, 712, 170, 50);

        PaymentTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PaymentTypeLabel.setText("Payment Type");
        jPanel1.add(PaymentTypeLabel);
        PaymentTypeLabel.setBounds(266, 398, 142, 20);

        ryy4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy4.setText("₱50.00");
        jPanel1.add(ryy4);
        ryy4.setBounds(351, 533, 57, 20);

        ryy5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy5.setText("₱50.00");
        jPanel1.add(ryy5);
        ryy5.setBounds(351, 560, 57, 20);

        ryy6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ryy6.setText("₱50.00");
        jPanel1.add(ryy6);
        ryy6.setBounds(333, 593, 75, 30);

        Time1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time1.setText("Plate Number:");
        jPanel1.add(Time1);
        Time1.setBounds(50, 350, 150, 20);

        ryy2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy2.setText("₱50.00");
        jPanel1.add(ryy2);
        ryy2.setBounds(351, 479, 57, 20);

        ryy1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy1.setText("₱50.00");
        jPanel1.add(ryy1);
        ryy1.setBounds(351, 452, 57, 20);

        ryy3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy3.setText("₱50.00");
        jPanel1.add(ryy3);
        ryy3.setBounds(351, 425, 57, 20);

        pl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pl.setText("Payment Type:");
        jPanel1.add(pl);
        pl.setBounds(44, 398, 142, 20);

        Time.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time.setText("Time:");
        jPanel1.add(Time);
        Time.setBounds(50, 320, 53, 20);

        DiscountLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscountLabel.setText("Discount:");
        jPanel1.add(DiscountLabel);
        DiscountLabel.setBounds(44, 479, 94, 22);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("TIN: 101-165-233-00012");
        jLabel11.setToolTipText("");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(140, 90, 170, 17);

        DiscTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscTypeLabel.setText("Discount Type:");
        jPanel1.add(DiscTypeLabel);
        DiscTypeLabel.setBounds(44, 451, 145, 22);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Email: PPPservices@gmail.com");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(120, 70, 217, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 780);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Create a JFrame for demonstration
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    public javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DiscTypeLabel;
    private javax.swing.JLabel DiscountLabel;
    public javax.swing.JLabel PaymentTypeLabel;
    public javax.swing.JLabel TicketNumber;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel Time1;
    public javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel VatLabel;
    private javax.swing.JLabel VatsalesLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pl;
    private javax.swing.JLabel ryy;
    private javax.swing.JLabel ryy1;
    private javax.swing.JLabel ryy2;
    private javax.swing.JLabel ryy3;
    private javax.swing.JLabel ryy4;
    private javax.swing.JLabel ryy5;
    private javax.swing.JLabel ryy6;
    private javax.swing.JLabel subtotallabel;
    private javax.swing.JLabel tn;
    private javax.swing.JLabel totalAmount;
    public javax.swing.JLabel transactionNumber;
    private javax.swing.JLabel unitcostlabel;
    // End of variables declaration//GEN-END:variables
}
