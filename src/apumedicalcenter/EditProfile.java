package apumedicalcenter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

/**
 * Edit Profile panel for doctors
 */
public class EditProfile extends javax.swing.JPanel {
    
    private final String currentUserId;
    
    public EditProfile(String currentUserId) {
        initComponents();
        this.currentUserId = currentUserId == null ? "" : currentUserId.trim();
        set_doctor_ID(currentUserId);
        loadAndPopulate();  // prefill text fields
    }
    
    private DoctorRow originalRow;   // snapshot for comparison + discard
    private static final Path DOCTOR_FILE = Paths.get("src/apumedicalcenter/data/doctors.txt");
    
    // --- CSV model for doctor data ---
    private static class DoctorRow {
        String id, password, name, email, specialty;

        static DoctorRow parse(String csvLine) {
            String[] a = csvLine.split(",", -1);
            DoctorRow r = new DoctorRow();
            r.id = a.length > 0 ? a[0].trim() : "";
            r.password = a.length > 1 ? a[1].trim() : "";
            r.name = a.length > 2 ? a[2].trim() : "";
            r.email = a.length > 3 ? a[3].trim() : "";
            r.specialty = a.length > 4 ? a[4].trim() : "";
            return r;
        }

        String toCsv() {
            return String.join(",", nullToEmpty(id), nullToEmpty(password), nullToEmpty(name),
                                     nullToEmpty(email), nullToEmpty(specialty));
        }

        private static String nullToEmpty(String s) { return s == null ? "" : s; }
    }

    // --- I/O + UI binding ---
    private void loadAndPopulate() {
        if (currentUserId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing current user ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Files.exists(DOCTOR_FILE)) {
            JOptionPane.showMessageDialog(this, "doctor.txt not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            List<String> lines = Files.readAllLines(DOCTOR_FILE, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue;
                DoctorRow row = DoctorRow.parse(line);
                if (currentUserId.equalsIgnoreCase(row.id)) {
                    originalRow = row;          // keep snapshot
                    populateFields(row);        // prefill UI
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Doctor ID not found in doctor.txt", "Not Found", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to read doctor.txt:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateFields(DoctorRow r) {
        // Map to your text fields
        Name_txtf.setText(r.name);
        email_txtf.setText(r.email);
        jTextField4.setText(r.specialty); // Using phone field for specialty
        jTextField5.setText(r.password);
        dob_txtf.setText(""); // Not applicable for doctors
    }

    private DoctorRow readFieldsIntoRow(DoctorRow base) {
        // Copy base and only replace with the typed values
        DoctorRow r = new DoctorRow();
        r.id = base.id;              // ID never edited here
        r.password = jTextField5.getText().trim();
        r.name = Name_txtf.getText().trim();
        r.email = email_txtf.getText().trim();
        r.specialty = jTextField4.getText().trim();
        return r;
    }

    private boolean rowsEqual(DoctorRow a, DoctorRow b) {
        return Objects.equals(a.password, b.password)
            && Objects.equals(a.name, b.name)
            && Objects.equals(a.email, b.email)
            && Objects.equals(a.specialty, b.specialty);
    }

    private void saveIfChanged() {
        if (originalRow == null) {
            JOptionPane.showMessageDialog(this, "Nothing to save (doctor not loaded).", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        DoctorRow edited = readFieldsIntoRow(originalRow);

        if (rowsEqual(originalRow, edited)) {
            JOptionPane.showMessageDialog(this, "No changes detected.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            List<String> lines = Files.readAllLines(DOCTOR_FILE, StandardCharsets.UTF_8);
            boolean updated = false;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                DoctorRow row = DoctorRow.parse(line);
                if (currentUserId.equalsIgnoreCase(row.id)) {
                    // Merge: only overwrite fields that changed, keep others as-is
                    DoctorRow merged = row;
                    if (!Objects.equals(row.password, edited.password)) merged.password = edited.password;
                    if (!Objects.equals(row.name, edited.name)) merged.name = edited.name;
                    if (!Objects.equals(row.email, edited.email)) merged.email = edited.email;
                    if (!Objects.equals(row.specialty, edited.specialty)) merged.specialty = edited.specialty;

                    lines.set(i, merged.toCsv());
                    originalRow = merged; // refresh snapshot for future edits/discard
                    updated = true;
                    break;
                }
            }

            if (!updated) {
                JOptionPane.showMessageDialog(this, "Doctor ID not found; nothing updated.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Files.write(DOCTOR_FILE, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
            JOptionPane.showMessageDialog(this, "Profile updated successfully.", "Saved", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save doctor.txt:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Name_txtf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dob_txtf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        email_txtf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        Save_Button = new javax.swing.JToggleButton();
        Discard_Button = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        Customer_ID_Text = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(750, 400));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("EDIT YOUR PROFILE");

        jLabel3.setText("Full Name");

        Name_txtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Name_txtfActionPerformed(evt);
            }
        });

        jLabel4.setText("Not Used");
        dob_txtf.setVisible(false); // Hide this field for doctors
        jLabel4.setVisible(false);  // Hide this label for doctors

        jLabel5.setText("Email");

        email_txtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_txtfActionPerformed(evt);
            }
        });

        jLabel6.setText("Specialty");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Change Password");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        Save_Button.setText("Save Changes");
        Save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_ButtonActionPerformed(evt);
            }
        });

        Discard_Button.setText("Discard Changes");
        Discard_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Discard_ButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Doctor ID");

        Customer_ID_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer_ID_TextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(email_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                            .addComponent(Discard_Button))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Name_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Customer_ID_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(Save_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 201, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Customer_ID_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Save_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Discard_Button))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60))
        );

        // Updated sidebar for doctor portal
        jPanel2.setBackground(new java.awt.Color(165, 29, 45));
        jPanel2.setPreferredSize(new java.awt.Dimension(175, 295));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel13.setForeground(java.awt.Color.WHITE);
        jLabel13.setText("DOCTOR PORTAL");

        jButton21.setText("Edit Profile");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("View Appointments");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("Make Receipt");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("Make Prescription");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("View History");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        				.addComponent(jButton22, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton23, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton24, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton25, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(20))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addGap(20)
        			.addComponent(jButton21)
        			.addGap(18)
        			.addComponent(jButton22)
        			.addGap(18)
        			.addComponent(jButton23)
        			.addGap(18)
        			.addComponent(jButton24)
        			.addGap(18)
        			.addComponent(jButton25)
        			.addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }

    private void Discard_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (originalRow != null) {
            populateFields(originalRow);  // restore snapshot
        }
    }

    private void Name_txtfActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void email_txtfActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Customer_ID_TextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        saveIfChanged();
    }

    // Navigation methods for doctor portal buttons
    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {
        // Edit Profile - already here
    }

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {
        // View Appointments
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        Appointments appointmentsPanel = new Appointments(currentUserId);
        parentFrame.setContentPane(appointmentsPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {
        // Make Receipt
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        MakeReceipt receiptPanel = new MakeReceipt(currentUserId);
        parentFrame.setContentPane(receiptPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {
        // Make Prescription
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        MakePrescription prescriptionPanel = new MakePrescription(currentUserId);
        parentFrame.setContentPane(prescriptionPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {
        // View History
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        DoctorHistory historyPanel = new DoctorHistory(currentUserId);
        parentFrame.setContentPane(historyPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    private void set_doctor_ID(String currentUserId) {
        Customer_ID_Text.setText(currentUserId);
        Customer_ID_Text.setEnabled(false);
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField Customer_ID_Text;
    private javax.swing.JToggleButton Discard_Button;
    private javax.swing.JTextField Name_txtf;
    private javax.swing.JToggleButton Save_Button;
    private javax.swing.JTextField dob_txtf;
    private javax.swing.JTextField email_txtf;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
}