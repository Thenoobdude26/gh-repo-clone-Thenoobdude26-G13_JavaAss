package apumedicalcenter;

import java.awt.Dimension;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.Stream;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Doctor extends javax.swing.JPanel {
    
    private final String currentUserId;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JLabel jLabel1;
    
    public Doctor(String Current_user_ID) {
        initComponents();
        // Set the panel's preferred size
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));
        
        this.currentUserId = Current_user_ID == null ? "" : Current_user_ID.trim();

        // Look up the doctor's name and update the welcome label
        String name = lookupDoctorNameById(this.currentUserId);
        if (name != null && !name.isEmpty()) {
            Welcome_Label.setText("Welcome Dr. " + name.toUpperCase());
        } else {
            Welcome_Label.setText("Welcome Dr. " + this.currentUserId.toUpperCase());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Main panels
        jPanel3 = new javax.swing.JPanel(); 
        jPanel3.setBorder(new CompoundBorder());
        Welcome_Label = new javax.swing.JLabel();
        
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        jLabel1 = new javax.swing.JLabel();
        
        // Buttons for doctor functions
        btnEditProfile = new javax.swing.JButton();
        btnViewAppointments = new javax.swing.JButton();
        btnMakeReceipt = new javax.swing.JButton();
        btnMakePrescription = new javax.swing.JButton();
        btnViewHistory = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        // Welcome label styling
        Welcome_Label.setFont(new Font("Liberation Serif", Font.BOLD, 26));
        Welcome_Label.setText("Welcome Dr.");
        Welcome_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Main content panel layout
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addComponent(Welcome_Label, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                    .addGap(49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(200)
                    .addComponent(Welcome_Label, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

        // Side panel styling
        jPanel2.setBackground(new Color(165, 29, 45)); // Forest Green for medical theme
        jPanel2.setMaximumSize(new Dimension(200, 600));
        jPanel2.setMinimumSize(new Dimension(200, 600));

        // Panel title
        jLabel1.setFont(new Font("DejaVu Serif", Font.BOLD, 18));
        jLabel1.setText("DOCTOR PORTAL");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Button configurations
        btnEditProfile.setText("Edit Profile");
        btnEditProfile.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProfileActionPerformed(evt);
            }
        });

        btnViewAppointments.setText("View Appointments");
        btnViewAppointments.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnViewAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAppointmentsActionPerformed(evt);
            }
        });

        btnMakeReceipt.setText("Make Receipt");
        btnMakeReceipt.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnMakeReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeReceiptActionPerformed(evt);
            }
        });

        btnMakePrescription.setText("Make Prescription");
        btnMakePrescription.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnMakePrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakePrescriptionActionPerformed(evt);
            }
        });

        btnViewHistory.setText("View History");
        btnViewHistory.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnViewHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewHistoryActionPerformed(evt);
            }
        });

        // Side panel layout
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnEditProfile, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        				.addComponent(btnViewAppointments, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        				.addComponent(btnMakeReceipt, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        				.addComponent(btnMakePrescription, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        				.addComponent(btnViewHistory, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
        			.addGap(10))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(30)
        			.addComponent(btnEditProfile, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addGap(20)
        			.addComponent(btnViewAppointments, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addGap(20)
        			.addComponent(btnMakeReceipt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addGap(20)
        			.addComponent(btnMakePrescription, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addGap(20)
        			.addComponent(btnViewHistory, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(251, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        // Main layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        this.setLayout(layout);
    }

    /**
     * Lookup doctor's name from the doctor data file
     */
    private String lookupDoctorNameById(String id) {
        if (id == null || id.isEmpty()) return null;

        Path doctorFile = Paths.get("src/apumedicalcenter/data/doctors.txt");
        if (!Files.exists(doctorFile)) return null;

        try (Stream<String> lines = Files.lines(doctorFile, StandardCharsets.UTF_8)) {
            return lines
                .map(String::trim)
                .filter(line -> !line.isEmpty() && !line.startsWith("#"))
                .map(line -> line.split(","))
                .filter(arr -> arr.length >= 3 && arr[0].equalsIgnoreCase(id))
                .map(arr -> arr[2].trim()) // Assuming format: doctorID,password,name,...
                .findFirst()
                .orElse(null);
        } catch (IOException e) {
            System.err.println("Error reading doctor file: " + e.getMessage());
            return null;
        }
    }

    /**
     * Navigate to edit profile panel
     */
    private void btnEditProfileActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        EditProfile editProfilePanel = new EditProfile(currentUserId);
        parentFrame.setContentPane(editProfilePanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    /**
     * Navigate to view appointments panel - shows individual appointments
     */
    private void btnViewAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        Appointments appointmentsPanel = new Appointments(currentUserId);
        parentFrame.setContentPane(appointmentsPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    /**
     * Navigate to make receipt panel - for entering charges
     */
    private void btnMakeReceiptActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        MakeReceipt receiptPanel = new MakeReceipt(currentUserId);
        parentFrame.setContentPane(receiptPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    /**
     * Navigate to make prescription panel - for creating prescriptions
     */
    private void btnMakePrescriptionActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        MakePrescription prescriptionPanel = new MakePrescription(currentUserId);
        parentFrame.setContentPane(prescriptionPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    /**
     * Navigate to view history panel - shows past appointments, charges, prescriptions
     */
    private void btnViewHistoryActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        DoctorHistory historyPanel = new DoctorHistory(currentUserId);
        parentFrame.setContentPane(historyPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    // Component declarations - Modern UI elements
    private javax.swing.JLabel Welcome_Label;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnViewAppointments;
    private javax.swing.JButton btnMakeReceipt;
    private javax.swing.JButton btnMakePrescription;
    private javax.swing.JButton btnViewHistory;
    private javax.swing.JLabel portalTitleLabel;
    private javax.swing.JPanel sideNavigationPanel;
    private javax.swing.JPanel mainContentPanel;
}