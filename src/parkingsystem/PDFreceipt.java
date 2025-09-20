package parkingsystem;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.File;
import java.awt.Desktop;
import java.io.IOException;
import javax.swing.JOptionPane;

public class PDFreceipt extends javax.swing.JFrame {

    public PDFreceipt() {
        initComponents();
    }

    public void saveTicketAsPDF() {
        try {
            // Get user's Documents folder
            String userHome = System.getProperty("user.home");
            String documentsPath = userHome + File.separator + "Documents";
            String fileName = "ticket_" + System.currentTimeMillis() + ".pdf";
            File pdfFile = new File(documentsPath, fileName);

            // Create new PDF document and page
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Start content stream to write text
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
            contentStream.newLineAtOffset(50, 750);
            contentStream.showText("DISPLAY HUB Receipt");
            contentStream.setFont(PDType1Font.HELVETICA, 12);

            // Move down and write details
            int leading = 18;
            int startX = 50;
            int startY = 730;

            contentStream.newLineAtOffset(0, -leading);
            contentStream.showText("Ticket Number: " + TicketNumber.getText());

            contentStream.newLineAtOffset(0, -leading);
            contentStream.showText("Transaction Number: " + transactionNumber.getText());

            contentStream.newLineAtOffset(0, -leading);
            contentStream.showText("Date: " + DateLabel.getText());

            contentStream.newLineAtOffset(0, -leading);
            contentStream.showText("Time: " + TimeLabel.getText());

            contentStream.newLineAtOffset(0, -leading);
            contentStream.showText("Plate Number: " + PlateNumberValueLabel.getText());

            contentStream.newLineAtOffset(0, -leading);
            contentStream.showText("Payment Type: " + PaymentTypeLabel.getText());

            contentStream.endText();
            contentStream.close();

            // Save and close document
            document.save(pdfFile);
            document.close();

            // Inform user and open PDF
            JOptionPane.showMessageDialog(this, "Receipt saved to:\n" + pdfFile.getAbsolutePath());

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                JOptionPane.showMessageDialog(this, "Automatic open not supported on this platform.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving PDF: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        TicketNumber = new javax.swing.JLabel();
        transactionNumber = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        PaymentTypeLabel = new javax.swing.JLabel();
        PlateNumberValueLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDF Receipt");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        // These labels are invisible placeholders to hold data
        TicketNumber.setBounds(10, 10, 200, 20);
        TicketNumber.setVisible(false);
        add(TicketNumber);

        transactionNumber.setBounds(10, 40, 200, 20);
        transactionNumber.setVisible(false);
        add(transactionNumber);

        DateLabel.setBounds(10, 70, 200, 20);
        DateLabel.setVisible(false);
        add(DateLabel);

        TimeLabel.setBounds(10, 100, 200, 20);
        TimeLabel.setVisible(false);
        add(TimeLabel);

        PaymentTypeLabel.setBounds(10, 130, 200, 20);
        PaymentTypeLabel.setVisible(false);
        add(PaymentTypeLabel);

        PlateNumberValueLabel.setBounds(10, 160, 200, 20);
        PlateNumberValueLabel.setVisible(false);
        add(PlateNumberValueLabel);
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    public javax.swing.JLabel DateLabel;
    public javax.swing.JLabel PaymentTypeLabel;
    public javax.swing.JLabel PlateNumberValueLabel;
    public javax.swing.JLabel TicketNumber;
    public javax.swing.JLabel TimeLabel;
    public javax.swing.JLabel transactionNumber;
    // End of variables declaration                   
}
