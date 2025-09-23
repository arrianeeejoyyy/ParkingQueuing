
package parkingsystem;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PDFreceipt extends javax.swing.JFrame {

    public PDFreceipt() {
        initComponents();
        
        
    }

    // Helper method to capture the panel as an image (if you want to save the receipt as an image and then convert to PDF)
    // Capture jPanel1 as an image
    public BufferedImage getPanelImage() {
        BufferedImage image = new BufferedImage(jPanel1.getWidth(), jPanel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        jPanel1.paint(g2d);
        g2d.dispose();
        return image;
    }

    // Convert BufferedImage to byte array for PDF
    private byte[] bufferedImageToByteArray(BufferedImage image) throws IOException {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    // Save receipt as PDF
    public void savePanelImageAsPDF() {
        try {
            String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
            String fileName = "receipt_" + timestamp + ".pdf";
            String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
            File pdfFile = new File(documentsPath, fileName);

            BufferedImage receiptImage = getPanelImage();
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(new PDRectangle(receiptImage.getWidth(), receiptImage.getHeight()));
            document.addPage(page);

            PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, bufferedImageToByteArray(receiptImage), "receipt_image");
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImage, 0, 0, receiptImage.getWidth(), receiptImage.getHeight());
            contentStream.close();

            document.save(pdfFile);
            document.close();

            JOptionPane.showMessageDialog(this, "Receipt saved as PDF at:\n" + pdfFile.getAbsolutePath());

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);

                // Timer to hide the frame after 6 seconds
                Timer timer = new Timer(6000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        closePDFAndShowPanel();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving PDF: " + e.getMessage());
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
        platenumber = new javax.swing.JLabel();
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
        TimeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(450, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TicketNumber.setFont(new java.awt.Font("Arial", 1, 80)); // NOI18N
        TicketNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TicketNumber.setText("R NO.");
        TicketNumber.setToolTipText("");
        jPanel1.add(TicketNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 400, 70));

        DateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DateLabel.setText("Date:");
        jPanel1.add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 295, 226, 20));

        VatLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatLabel.setText("VAT:");
        jPanel1.add(VatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 559, 59, -1));

        tn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tn.setText("Transaction Number:");
        jPanel1.add(tn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 196, 20));

        totalAmount.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        totalAmount.setText("Total Amount: ");
        jPanel1.add(totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 598, -1, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("PARKPOINT PARKING SERVICES");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        subtotallabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        subtotallabel.setText("Subtotal:");
        jPanel1.add(subtotallabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 507, 94, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Location: Olaes Subd Noveleta, Cavite");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("\"THIS IS A OFFICIAL RECEIPT \"");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 280, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("---------------------------------------------------------------------------");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 243, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("****************************************");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel7.setText("....................................");
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 629, -1, 31));

        Date.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Date.setText("Date:");
        jPanel1.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 295, -1, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("PARKPOINT PARKING SERVICES");
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 689, -1, -1));

        VatsalesLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        VatsalesLabel.setText("VAT Sales:");
        jPanel1.add(VatsalesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 533, 118, 20));

        unitcostlabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        unitcostlabel.setText("Unit Cost/Price :");
        jPanel1.add(unitcostlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 425, 153, 20));

        platenumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        platenumber.setText("platenumber");
        jPanel1.add(platenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 194, 20));

        ryy.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy.setText("₱50.00");
        jPanel1.add(ryy, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 507, -1, 20));

        transactionNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionNumber.setText("number");
        jPanel1.add(transactionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 196, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("THANKYOU FOR CHOOSING");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 666, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("---------------------------------------------------------------------------");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SECOND_UI/barccode.png"))); // NOI18N
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 712, -1, 50));

        PaymentTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PaymentTypeLabel.setText("Payment Type");
        jPanel1.add(PaymentTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, 20));

        ryy4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy4.setText("₱44.64");
        jPanel1.add(ryy4, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 533, -1, 20));

        ryy5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy5.setText("₱5.36");
        jPanel1.add(ryy5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, -1, 20));

        ryy6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ryy6.setText("₱50.00");
        jPanel1.add(ryy6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 593, -1, 30));

        Time1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time1.setText("Plate Number:");
        jPanel1.add(Time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 150, 20));

        ryy2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy2.setText("₱0.00");
        jPanel1.add(ryy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, -1, 20));

        ryy1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy1.setText("None");
        jPanel1.add(ryy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, -1, 20));

        ryy3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ryy3.setText("₱50.00");
        jPanel1.add(ryy3, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 425, -1, 20));

        pl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pl.setText("Payment Type:");
        jPanel1.add(pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 398, 142, 20));

        Time.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time.setText("Time:");
        jPanel1.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 53, 20));

        DiscountLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscountLabel.setText("Discount:");
        jPanel1.add(DiscountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 479, 94, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("TIN: 101-165-233-00012");
        jLabel11.setToolTipText("");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 170, -1));

        DiscTypeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DiscTypeLabel.setText("Discount Type:");
        jPanel1.add(DiscTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 451, 145, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Email: PPPservices@gmail.com");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, 20));

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TimeLabel.setText("Time:");
        jPanel1.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 194, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 780));

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
    public javax.swing.JLabel platenumber;
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
