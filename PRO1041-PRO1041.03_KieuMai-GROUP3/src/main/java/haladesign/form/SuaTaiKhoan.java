/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package haladesign.form;

import haladesign.component.ThemMoiNhanVienThanhCong;
import haladesign.model.NhanVien;
import haladesign.model.QuyenHan;
import haladesign.service.NhanVienService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class SuaTaiKhoan extends javax.swing.JPanel {

    /**
     * Creates new form SuaTaiKhoan
     */
    private NhanVien nhanVien;
    private NhanVienService nhanVienService = new NhanVienService();

    public SuaTaiKhoan(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
        initComponents();
        fillDataToForm(nhanVien);

    }

    public boolean isValidDate(String text) {
        if (text == null || !text.matches("\\d{4}-[01]\\d-[0-3]\\d")) {
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        try {
            df.parse(text);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public Date covertValidStringToDate(String fmtDate) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(fmtDate);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng để đúng định dạng yyyy-MM-dd");
            return null;
        }
    }

    public boolean validateEmplData() {
        if (txtFullname.getText().trim().isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống");
            return false;
        } else if (!txtEmail.getText().trim().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ");
            return false;
        } else if (!isValidDate(txtBirthdate.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ, vui lòng để đúng định dạng yyyy-MM-dd");
            return false;
        }

        return true;
    }

    public NhanVien getDataFromFields() {
        if (validateEmplData()) {
            NhanVien empl = new NhanVien();

            empl.setId(this.nhanVien.getId());
            empl.setPhoneNum(txtPhonenum.getText());
            empl.setFullName(txtFullname.getText());
            empl.setEmail(txtEmail.getText());
            switch (cboGender.getSelectedIndex()) {
                case 2:
                    empl.setGender(null);
                    break;
                case 0:
                    empl.setGender(true);
                    break;
                case 1:
                    empl.setGender(false);
                    break;
                default:
                    break;
            }
            empl.setBirthdate(txtBirthdate.getText());
            empl.setAddress(txtAddress.getText());
            empl.setCreatedDate(this.nhanVien.getCreatedDate());
            empl.setPassword(this.nhanVien.getPassword());
            empl.setUserState(this.nhanVien.getUserState());
            empl.setRole(this.nhanVien.getRole());
            empl.setNote(this.nhanVien.getNote());
            return empl;
        } else {
            return null;
        }
    }

    public void handleSubmit() {
        NhanVien newNhanVien = getDataFromFields();
        if (newNhanVien != null) {
            if (this.nhanVienService.addNewNhanVien(newNhanVien)) {
                this.nhanVien = new NhanVien(
                        newNhanVien.getId(),
                        newNhanVien.getFullName(),
                        newNhanVien.getPhoneNum(),
                        newNhanVien.getEmail(),
                        newNhanVien.getGender(), 
                        newNhanVien.getBirthdate(),
                        newNhanVien.getAddress(), 
                        newNhanVien.getPassword(), 
                        newNhanVien.getCreatedDate(), 
                        newNhanVien.getUserState(), 
                        newNhanVien.getNote(), 
                        newNhanVien.getRole()
                );
                JOptionPane.showMessageDialog(this, "Sửa thành công, vui lòng đăng nhập lại để kiểm tra thông tin");
                fillDataToForm(this.nhanVien);
            }
        }
    }

    public void fillDataToForm(NhanVien nvien) {
        txtFullname.setText(nvien.getFullName().trim());
        txtPhonenum.setText(nvien.getPhoneNum().trim());
        txtEmail.setText(nvien.getEmail().trim());
        if (nvien.getGender() == null) {
            cboGender.setSelectedIndex(2);
        } else if (nvien.getGender()) {
            cboGender.setSelectedIndex(0);
        } else if (!nvien.getGender()) {
            cboGender.setSelectedIndex(1);
        }
        txtAddress.setText(nvien.getAddress());
        if (nvien.getBirthdate() != null) {
            txtBirthdate.setText(nvien.getBirthdate().trim().substring(0, 10));
        } else {
            txtBirthdate.setText("");

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtFullname = new haladesign.swingStyle.TextField();
        txtPhonenum = new haladesign.swingStyle.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new haladesign.swingStyle.TextField();
        txtBirthdate = new haladesign.swingStyle.TextField();
        cboGender = new haladesign.swingStyle.Combobox();
        txtAddress = new haladesign.swingStyle.TextField();
        jLabel2 = new javax.swing.JLabel();
        button1 = new haladesign.swingStyle.Button();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setText("Thông tin tài khoản");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1048, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtFullname.setLabelText("Họ tên");

        txtPhonenum.setEnabled(false);
        txtPhonenum.setLabelText("Số điện thoại");

        jLabel1.setText("Các thông tin cơ bản của tài khoản đang đăng nhập hệ thống");

        txtEmail.setLabelText("Email");

        txtBirthdate.setLabelText("Ngày sinh");

        cboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ", "Khác" }));
        cboGender.setLabeText("Giới tính");

        txtAddress.setToolTipText("");
        txtAddress.setLabelText("Địa chỉ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Đổi mật khẩu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(txtBirthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(txtPhonenum, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhonenum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        button1.setText("Sửa thông tin");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        handleSubmit();
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button button1;
    private haladesign.swingStyle.Combobox cboGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private haladesign.swingStyle.TextField txtAddress;
    private haladesign.swingStyle.TextField txtBirthdate;
    private haladesign.swingStyle.TextField txtEmail;
    private haladesign.swingStyle.TextField txtFullname;
    private haladesign.swingStyle.TextField txtPhonenum;
    // End of variables declaration//GEN-END:variables
}
