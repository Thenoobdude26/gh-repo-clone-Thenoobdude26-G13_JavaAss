package apumedicalcenter;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;

public class DoctorHistory extends javax.swing.JPanel {

    private final String currentUserId;

    public DoctorHistory(String Current_user_ID) {
        initComponents();
        this.currentUserId = Current_user_ID == null ? "" : Current_user_ID.trim();
        loadPrescriptionHistory();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

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
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Prescription ID", "Patient ID", "Patient Name", "Medicine", "Date", "Time", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jLabel2.setText("PRESCRIPTION HISTORY");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        MakeReceipt receiptPanel = new MakeReceipt(currentUserId);
        parentFrame.setContentPane(receiptPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // Already in View History panel
    }

    // Load prescription history from file
    private void loadPrescriptionHistory() {
        String filename = "src/apumedicalcenter/data/prescription.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            DefaultTableModel model = new DefaultTableModel();
            
            // Set up column headers
            model.addColumn("Prescription ID");
            model.addColumn("Patient ID");
            model.addColumn("Patient Name");
            model.addColumn("Medicine & Instructions");
            model.addColumn("Date");
            model.addColumn("Time");

            while ((line = br.readLine()) != null) {
                String[] values = parseCSVLine(line);
                
                if (values.length >= 7) {
                    String prescriptionDoctorId = values[1].trim();
                    
                    // Check if this prescription belongs to the current doctor
                    if (prescriptionDoctorId.equalsIgnoreCase(currentUserId)) {
                        // Clean up the data for display
                        String[] displayValues = new String[6];
                        displayValues[0] = values[0].trim(); // Prescription ID
                        displayValues[1] = values[2].trim(); // Patient ID
                        displayValues[2] = values[3].trim(); // Patient Name
                        displayValues[3] = values[4].trim(); // Medicine & Instructions
                        displayValues[4] = values[5].trim(); // Date
                        displayValues[5] = values[6].trim(); // Time
                        
                        model.addRow(displayValues);
                    }
                }
            }
            
            jTable1.setModel(model);
            
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No prescription history found for doctor ID: " + currentUserId);
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading prescription history: " + e.getMessage());
        }
    }
    
    // Helper method to parse CSV line with quoted fields
    private String[] parseCSVLine(String line) {
        java.util.List<String> result = new java.util.ArrayList<>();
        boolean inQuotes = false;
        StringBuilder currentField = new StringBuilder();
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    // Escaped quote
                    currentField.append('"');
                    i++; // Skip next quote
                } else {
                    // Toggle quote state
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                // End of field
                result.add(currentField.toString());
                currentField.setLength(0);
            } else {
                currentField.append(c);
            }
        }
        
        // Add the last field
        result.add(currentField.toString());
        
        return result.toArray(new String[0]);
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}