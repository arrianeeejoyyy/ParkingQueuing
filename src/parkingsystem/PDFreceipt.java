package parkingsystem;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PDFreceipt extends JFrame {

    public PDFreceipt() {
        initComponents();
    }

    public void savePanelImageAsPDF() {
        try {
            String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
            String fileName = "receipt_" + timestamp + ".pdf";

            String userHome = System.getProperty("user.home");
            String documentsPath = userHome + File.separator + "Documents";
            File pdfFile = new File(documentsPath, fileName);

            BufferedImage receiptImage = getPanelImage();

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(new PDRectangle(receiptImage.getWidth(), receiptImage.getHeight()));
            document.addPage(page);

            PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, bufferedImageToByteArray(receiptImage), "receipt_image");

            var contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
            contentStream.drawImage(pdImage, 0, 0, receiptImage.getWidth(), receiptImage.getHeight());
            contentStream.close();

            document.save(pdfFile);
            document.close();

            javax.swing.JOptionPane.showMessageDialog(this, "Receipt saved as PDF at:\n" + pdfFile.getAbsolutePath());

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);

                Timer timer = new Timer(6000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        closePDFAndShowPanel();
                    }
                });
                timer.setRepeats(false);
                timer.start();

            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Automatic open not supported on this platform.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving PDF: " + e.getMessage());
        }
    }

    private void closePDFAndShowPanel() {
        this.setVisible(false);
        this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
    }

    public BufferedImage getPanelImage() {
        BufferedImage image = new BufferedImage(jPanel1.getWidth(), jPanel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        jPanel1.paint(g2d);
        g2d.dispose();
        return image;
    }

    private byte[] bufferedImageToByteArray(BufferedImage image) throws IOException {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        TicketNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        tn = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        pl = new javax.swing.JLabel();
        PaymentTypeLabel = new javax.swing.JLabel();
        Platenumber_receipt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(450, 420);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.JLabel titleLabel = new javax.swing.JLabel("PARKPOINT PARKING SERVICES");
        titleLabel.setFont(new java.awt.Font("Arial", 1, 24));
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 370, 30));

        javax.swing.JLabel subtitleLabel = new javax.swing.JLabel("Official Receipt");
        subtitleLabel.setFont(new java.awt.Font("Arial", 1, 18));
        jPanel1.add(subtitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 25));

        TicketNumber.setFont(new java.awt.Font("Arial", 1, 48));
        TicketNumber.setText("R NO.");
        jPanel1.add(TicketNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 270, 60));

        tn = new javax.swing.JLabel();
        tn.setFont(new java.awt.Font("Arial", 1, 18));
        tn.setText("Transaction Number:");
        jPanel1.add(tn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 180, 20));

        transactionNumber.setFont(new java.awt.Font("Arial", 1, 18));
        transactionNumber.setText("number");
        jPanel1.add(transactionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 200, 20));

        javax.swing.JLabel dateTextLabel = new javax.swing.JLabel("Date:");
        dateTextLabel.setFont(new java.awt.Font("Arial", 1, 18));
        jPanel1.add(dateTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 50, 20));

        DateLabel.setFont(new java.awt.Font("Arial", 1, 18));
        DateLabel.setText("Date");
        jPanel1.add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 200, 20));

        javax.swing.JLabel timeTextLabel = new javax.swing.JLabel("Time:");
        timeTextLabel.setFont(new java.awt.Font("Arial", 1, 18));
        jPanel1.add(timeTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 50, 20));

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 18));
        TimeLabel.setText("Time");
        jPanel1.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 200, 20));

        pl = new javax.swing.JLabel();
        pl.setFont(new java.awt.Font("Arial", 1, 18));
        pl.setText("Plate Number:");
        jPanel1.add(pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 130, 20));

        Platenumber_receipt.setFont(new java.awt.Font("Arial", 1, 18));
        Platenumber_receipt.setText("Plate Number");
        jPanel1.add(Platenumber_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 200, 20));

        javax.swing.JLabel paymentTypeTextLabel = new javax.swing.JLabel("Payment Type:");
        paymentTypeTextLabel.setFont(new java.awt.Font("Arial", 1, 18));
        jPanel1.add(paymentTypeTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 130, 20));

        PaymentTypeLabel.setFont(new java.awt.Font("Arial", 1, 18));
        PaymentTypeLabel.setText("Payment Type");
        jPanel1.add(PaymentTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 200, 20));

        javax.swing.JSeparator separator = new javax.swing.JSeparator();
        separator.setBounds(40, 350, 370, 10);
        jPanel1.add(separator);

        javax.swing.JLabel footerLabel = new javax.swing.JLabel("Thank you for choosing ParkPoint!");
        footerLabel.setFont(new java.awt.Font("Arial", 1, 16));
        jPanel1.add(footerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 370, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 420));

        pack();
    }

    public javax.swing.JLabel TicketNumber;
    public javax.swing.JLabel transactionNumber;
    public javax.swing.JLabel DateLabel;
    public javax.swing.JLabel TimeLabel;
    public javax.swing.JLabel PaymentTypeLabel;
    public javax.swing.JLabel Platenumber_receipt;

    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pl;
    private javax.swing.JLabel tn;
}