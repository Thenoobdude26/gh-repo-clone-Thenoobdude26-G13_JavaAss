package apumedicalcenter;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class MakeReceipt extends javax.swing.JPanel {

    private final String currentUserId;

    public MakeReceipt(String Current_user_ID) {
        initComponents();
        this.currentUserId = Current_user_ID == null ? "" : Current_user_ID.trim();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        
        // Receipt form components
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        patientIdField = new javax.swing.JTextField();
        patientNameField = new javax.swing.JTextField();
        treatmentField = new javax.swing.JTextField();
        amountField = new javax.swing.JTextField();
        servicesArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        submitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        // Left panel (navigation)
        jPanel4.setBackground(new java.awt.Color(165, 29, 45));
        jPanel4.setMaximumSize(new java.awt.Dimension(175, 500));
        jPanel4.setMinimumSize(new java.awt.Dimension(175, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel1.setForeground(java.awt.Color.WHITE);
        jLabel1.setText("DOCTOR PORTAL");

        jButton1.setText("Edit Profile");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jButton2.setText("View Appointments");
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

        jButton4.setText("Make Receipt");
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt));

        jButton3.setText("Make Prescription");
        jButton3.setMaximumSize(new java.awt.Dimension(87, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(87, 23));
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));

        jButton5.setText("View History");
        jButton5.addActionListener(evt -> jButton5ActionPerformed(evt));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4Layout.setHorizontalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jLabel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        				.addComponent(jButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addGap(20)
        			.addComponent(jButton1)
        			.addGap(18)
        			.addComponent(jButton2)
        			.addGap(18)
        			.addComponent(jButton4)
        			.addGap(18)
        			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jButton5)
        			.addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel4.setLayout(jPanel4Layout);

        // Main content panel
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jLabel2.setText("MAKE RECEIPT");

        jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel3.setText("Patient ID:");

        jLabel4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel4.setText("Patient Name:");

        jLabel5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel5.setText("Treatment:");

        jLabel6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel6.setText("Amount (RM):");

        jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel7.setText("Services/Items:");

        jLabel8.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jLabel8.setText("Doctor ID: " + currentUserId);

        jLabel9.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        jLabel9.setText("APU Medical Center - Official Receipt");

        patientIdField.setPreferredSize(new java.awt.Dimension(200, 25));
        patientNameField.setPreferredSize(new java.awt.Dimension(200, 25));
        treatmentField.setPreferredSize(new java.awt.Dimension(200, 25));
        amountField.setPreferredSize(new java.awt.Dimension(200, 25));

        servicesArea.setRows(5);
        servicesArea.setColumns(30);
        servicesArea.setLineWrap(true);
        servicesArea.setWrapStyleWord(true);
        servicesArea.setText("Consultation fee\nPrescription\nTreatment");
        jScrollPane1.setViewportView(servicesArea);

        submitButton.setText("Generate Receipt");
        submitButton.setBackground(new java.awt.Color(165, 29, 45));
        submitButton.setForeground(java.awt.Color.WHITE);
        submitButton.addActionListener(evt -> generateReceipt());

        clearButton.setText("Clear Form");
        clearButton.addActionListener(evt -> clearForm());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(patientIdField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(patientNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(treatmentField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(submitButton)
                        .addGap(20, 20, 20)
                        .addComponent(clearButton)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(patientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(patientNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(treatmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(clearButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    // Navigation methods
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        EditProfile editProfilePanel = new EditProfile(currentUserId);
        parentFrame.setContentPane(editProfilePanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        Appointments appointmentsPanel = new Appointments(currentUserId);
        parentFrame.setContentPane(appointmentsPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        MakePrescription prescriptionPanel = new MakePrescription(currentUserId);
        parentFrame.setContentPane(prescriptionPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // Already in Make Receipt panel
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        DoctorHistory historyPanel = new DoctorHistory(currentUserId);
        parentFrame.setContentPane(historyPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    // Receipt functionality
    private void generateReceipt() {
        String patientId = patientIdField.getText().trim();
        String patientName = patientNameField.getText().trim();
        String treatment = treatmentField.getText().trim();
        String amountStr = amountField.getText().trim();
        String services = servicesArea.getText().trim();
        
        if (patientId.isEmpty() || patientName.isEmpty() || treatment.isEmpty() || amountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Validate amount is numeric
        double amount;
        try {
            amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than 0.", "Invalid Amount", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Invalid Amount", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            saveReceipt(patientId, patientName, treatment, amount, services);
            JOptionPane.showMessageDialog(this, "Receipt generated and saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving receipt: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void saveReceipt(String patientId, String patientName, String treatment, double amount, String services) throws IOException {
        String filename = "src/apumedicalcenter/data/receipt.txt";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        
        // Generate receipt ID
        String receiptId = "rec" + String.format("%03d", (int)(Math.random() * 1000));
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // Format: receiptId,doctorId,patientId,patientName,treatment,amount,services,date,time
            writer.write(String.format("%s,%s,%s,%s,%s,%.2f,\"%s\",%s,%s%n",
                receiptId,
                currentUserId,
                patientId,
                patientName,
                treatment,
                amount,
                services.replace("\"", "\"\""), // Escape quotes in services text
                dateFormat.format(now),
                timeFormat.format(now)
            ));
        }
    }
    
    private void clearForm() {
        patientIdField.setText("");
        patientNameField.setText("");
        treatmentField.setText("");
        amountField.setText("");
        servicesArea.setText("Consultation fee\nPrescription\nTreatment");
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField patientIdField;
    private javax.swing.JTextField patientNameField;
    private javax.swing.JTextField treatmentField;
    private javax.swing.JTextField amountField;
    private javax.swing.JTextArea servicesArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton clearButton;
}