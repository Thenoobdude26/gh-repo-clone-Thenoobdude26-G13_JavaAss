package apumedicalcenter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;

/**
 * Appointments panel for doctors to view their appointments
 */
public class Appointments extends javax.swing.JPanel {

    private final String currentUserId;

    public Appointments(String Current_user_ID) {
        initComponents();
        this.currentUserId = Current_user_ID == null ? "" : Current_user_ID.trim();
        loadAppointmentsFromFile();
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

        jPanel4.setBackground(new java.awt.Color(165, 29, 45));
        jPanel4.setMaximumSize(new java.awt.Dimension(175, 500));
        jPanel4.setMinimumSize(new java.awt.Dimension(175, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel1.setForeground(java.awt.Color.WHITE);
        jLabel1.setText("DOCTOR PORTAL");

        jButton1.setText("Edit Profile");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View Appointments");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Make Receipt");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Make Prescription");
        jButton3.setMaximumSize(new java.awt.Dimension(87, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(87, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("View History");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new Font("MathJax_Main", Font.BOLD, 18));
        jLabel2.setText(" APPOINTMENTS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGap(75)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGap(218)
        					.addComponent(jLabel2)))
        			.addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGap(38)
        			.addComponent(jLabel2)
        			.addGap(71)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

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

    // Navigation methods for doctor portal
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        EditProfile editProfilePanel = new EditProfile(currentUserId);
        parentFrame.setContentPane(editProfilePanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Already in Appointments panel
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
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        DoctorHistory historyPanel = new DoctorHistory(currentUserId);
        parentFrame.setContentPane(historyPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void loadAppointmentsFromFile() {
        String filename = "src/apumedicalcenter/data/appointment.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            DefaultTableModel model = new DefaultTableModel();
            
            // Set up column headers manually since your file doesn't have them
            model.addColumn("Appointment ID");
            model.addColumn("Customer ID");
            model.addColumn("Doctor ID");
            model.addColumn("Date");
            model.addColumn("Time");
            model.addColumn("Status");
            model.addColumn("Amount");
            
            SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date currentDate = new Date();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                if (values.length >= 7) {
                    String appointmentDoctorId = values[2].trim();
                    
                    // Check if this appointment belongs to the current doctor
                    if (appointmentDoctorId.equalsIgnoreCase(currentUserId)) {
                        try {
                            // Parse date and time to check if it's a future appointment
                            String dateTimeString = values[3].trim() + " " + values[4].trim();
                            Date appointmentDate = inputFormatter.parse(dateTimeString);
                            
                            // Only show future appointments
                            if (appointmentDate.after(currentDate)) {
                                // Clean up the data for display
                                String[] displayValues = new String[7];
                                displayValues[0] = values[0].trim(); // Appointment ID
                                displayValues[1] = values[1].trim(); // Customer ID
                                displayValues[2] = values[2].trim(); // Doctor ID
                                displayValues[3] = values[3].trim(); // Date
                                displayValues[4] = values[4].trim(); // Time
                                displayValues[5] = values[5].trim(); // Status
                                displayValues[6] = values[6].trim(); // Amount
                                
                                model.addRow(displayValues);
                            }
                        } catch (ParseException e) {
                            // If date parsing fails, still show the appointment
                            model.addRow(values);
                        }
                    }
                }
            }
            
            jTable1.setModel(model);
            
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No upcoming appointments found for doctor ID: " + currentUserId);
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading appointments file: " + e.getMessage());
        }
    }

    private String getDoctorNameById(String doctorId) {
        String doctorFilename = "src/apumedicalcenter/data/doctors.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(doctorFilename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3 && values[0].trim().equalsIgnoreCase(doctorId)) {
                    return values[2].trim();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading doctor file: " + e.getMessage());
        }
        return null;
    }

    // Variables declaration - do not modify
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


//package apumedicalcenter;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//
///**
// * Appointments panel for doctors to view their appointments
// */
//public class Appointments extends javax.swing.JPanel {
//
//    private final String currentUserId;
//    
//    public Appointments(String Current_user_ID) {
//        initComponents();
//        this.currentUserId = Current_user_ID == null ? "" : Current_user_ID.trim();
//        loadAppointmentsFromFile();
//    }
//
//    @SuppressWarnings("unchecked")
//      initComponents() {
//
//        jPanel4 = new javax.swing.JPanel();
//        jLabel1 = new javax.swing.JLabel();
//        jButton1 = new javax.swing.JButton();
//        jButton2 = new javax.swing.JButton();
//        jButton4 = new javax.swing.JButton();
//        jButton3 = new javax.swing.JButton();
//        jButton5 = new javax.swing.JButton();
//        jButton6 = new javax.swing.JButton();
//        jPanel3 = new javax.swing.JPanel();
//        jScrollPane1 = new javax.swing.JScrollPane();
//        jTable1 = new javax.swing.JTable();
//        jLabel2 = new javax.swing.JLabel();
//
//        setPreferredSize(new java.awt.Dimension(800, 500));
//
//        jPanel4.setBackground(new java.awt.Color(165, 29, 45));
//        jPanel4.setMaximumSize(new java.awt.Dimension(175, 500));
//        jPanel4.setMinimumSize(new java.awt.Dimension(175, 500));
//
//        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
//        jLabel1.setForeground(java.awt.Color.WHITE);
//        jLabel1.setText("DOCTOR PORTAL");
//
//        jButton1.setText("Edit Profile");
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });
//
//        jButton2.setText("View Appointments");
//        jButton2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ActionPerformed(evt);
//            }
//        });
//
//        jButton4.setText("Make Receipt");
//        jButton4.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton4ActionPerformed(evt);
//            }
//        });
//
//        jButton3.setText("Make Prescription");
//        jButton3.setMaximumSize(new java.awt.Dimension(87, 23));
//        jButton3.setMinimumSize(new java.awt.Dimension(87, 23));
//        jButton3.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton3ActionPerformed(evt);
//            }
//        });
//
//        jButton5.setText("View History");
//        jButton5.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton5ActionPerformed(evt);
//            }
//        });
//
//        jButton6.setText("Customer Feedback");
//        jButton6.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton6ActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
//        jPanel4.setLayout(jPanel4Layout);
//        jPanel4Layout.setHorizontalGroup(
//            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel4Layout.createSequentialGroup()
//                .addGap(20, 20, 20)
//                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
//                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addContainerGap(20, Short.MAX_VALUE))
//        );
//        jPanel4Layout.setVerticalGroup(
//            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel4Layout.createSequentialGroup()
//                .addGap(20, 20, 20)
//                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(20, 20, 20)
//                .addComponent(jButton1)
//                .addGap(18, 18, 18)
//                .addComponent(jButton2)
//                .addGap(18, 18, 18)
//                .addComponent(jButton4)
//                .addGap(18, 18, 18)
//                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(18, 18, 18)
//                .addComponent(jButton5)
//                .addGap(18, 18, 18)
//                .addComponent(jButton6)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null}
//            },
//            new String [] {
//                "Title 1", "Title 2", "Title 3", "Title 4"
//            }
//        ));
//        jScrollPane1.setViewportView(jTable1);
//
//        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
//        jLabel2.setText("MY APPOINTMENTS");
//
//        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
//        jPanel3.setLayout(jPanel3Layout);
//        jPanel3Layout.setHorizontalGroup(
//            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel3Layout.createSequentialGroup()
//                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(jPanel3Layout.createSequentialGroup()
//                        .addGap(85, 85, 85)
//                        .addComponent(jLabel2))
//                    .addGroup(jPanel3Layout.createSequentialGroup()
//                        .addGap(75, 75, 75)
//                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                .addGap(75, 75, 75))
//        );
//        jPanel3Layout.setVerticalGroup(
//            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
//                .addGap(33, 33, 33)
//                .addComponent(jLabel2)
//                .addGap(76, 76, 76)
//                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//    }
//
//    // Navigation methods for doctor portal
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
//        // Edit Profile
//        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
//        EditProfile editProfilePanel = new EditProfile(currentUserId);
//        parentFrame.setContentPane(editProfilePanel);
//        parentFrame.revalidate();
//        parentFrame.repaint();
//    }
//
//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
//        // View Appointments - already here
//    }
//
//    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
//        // Make Prescription
//        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
//        MakePrescription prescriptionPanel = new MakePrescription(currentUserId);
//        parentFrame.setContentPane(prescriptionPanel);
//        parentFrame.revalidate();
//        parentFrame.repaint();
//    }
//
//    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
//        // Make Receipt
//        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
//        MakeReceipt receiptPanel = new MakeReceipt(currentUserId);
//        parentFrame.setContentPane(receiptPanel);
//        parentFrame.revalidate();
//        parentFrame.repaint();
//    }
//
//    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
//        // View History
//        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
//        DoctorHistory historyPanel = new DoctorHistory(currentUserId);
//        parentFrame.setContentPane(historyPanel);
//        parentFrame.revalidate();
//        parentFrame.repaint();
//    }
//
//    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
//        // Customer Feedback
//        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
//        CustomerFeedback feedbackPanel = new CustomerFeedback(currentUserId);
//        parentFrame.setContentPane(feedbackPanel);
//        parentFrame.revalidate();
//        parentFrame.repaint();
//    }
//
//    private void loadAppointmentsFromFile() {
//        String filename = "src/apumedicalcenter/data/appointment.txt";
//        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            String line;
//            DefaultTableModel model = new DefaultTableModel();
//            
//            // First, get the doctor's name from the doctor ID
//            String doctorName = getDoctorNameById(currentUserId);
//            if (doctorName == null) {
//                JOptionPane.showMessageDialog(this, "Could not find doctor information for ID: " + currentUserId);
//                return;
//            }
//            
//            boolean isFirstLine = true;
//            int doctorColumnIndex = -1;
//            int dateColumnIndex = -1;
//            int timeColumnIndex = -1;
//
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                
//                if (isFirstLine) {
//                    // First line = column headers, find relevant columns dynamically
//                    for (int i = 0; i < values.length; i++) {
//                        String columnName = values[i].trim().toLowerCase();
//                        if (columnName.equals("doctor name")) {
//                            doctorColumnIndex = i;
//                        } else if (columnName.equals("date")) {
//                            dateColumnIndex = i;
//                        } else if (columnName.equals("time")) {
//                            timeColumnIndex = i;
//                        }
//                        model.addColumn(values[i].trim());
//                    }
//                    isFirstLine = false;
//                } else {
//                    // Check if the appointment belongs to this doctor
//                    if (doctorColumnIndex != -1 && values.length > doctorColumnIndex) {
//                        String appointmentDoctorName = values[doctorColumnIndex].trim();
//                        
//                        // Match by doctor name (case insensitive)
//                        if (appointmentDoctorName.equalsIgnoreCase(doctorName)) {
//                            // Optionally filter by date/time if needed
//                            if (dateColumnIndex != -1 && timeColumnIndex != -1 && 
//                                values.length > Math.max(dateColumnIndex, timeColumnIndex)) {
//                                
//                                String dateTimeString = values[dateColumnIndex].trim() + " " + values[timeColumnIndex].trim();
//                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//                                Date currentDate = new Date();
//                                Date appointmentDate = null;
//                                
//                                try {
//                                    appointmentDate = formatter.parse(dateTimeString);
//                                    
//                                    // Show upcoming appointments (future dates)
//                                    if (appointmentDate.after(currentDate)) {
//                                        model.addRow(values);
//                                    }
//                                } catch (ParseException e) {
//                                    // If date parsing fails, still show the appointment
//                                    model.addRow(values);
//                                }
//                            } else {
//                                // If no date/time columns found, show all appointments for this doctor
//                                model.addRow(values);
//                            }
//                        }
//                    }
//                }
//            }
//            jTable1.setModel(model);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(this, "Error loading appointments file: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Get doctor name by doctor ID from the doctor.txt file
//     */
//    private String getDoctorNameById(String doctorId) {
//        String doctorFilename = "src/apumedicalcenter/data/doctor.txt";
//        try (BufferedReader br = new BufferedReader(new FileReader(doctorFilename))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                if (values.length >= 3 && values[0].trim().equalsIgnoreCase(doctorId)) {
//                    return values[2].trim(); // Doctor name is in the 3rd column
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading doctor file: " + e.getMessage());
//        }
//        return null;
//    }
//
//    // Variables declaration - do not modify
//    private javax.swing.JButton jButton1;
//    private javax.swing.JButton jButton2;
//    private javax.swing.JButton jButton3;
//    private javax.swing.JButton jButton4;
//    private javax.swing.JButton jButton5;
//    private javax.swing.JButton jButton6;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JPanel jPanel3;
//    private javax.swing.JPanel jPanel4;
//    private javax.swing.JScrollPane jScrollPane1;
//    private javax.swing.JTable jTable1;
//}

