/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package haladesign.form;

import haladesign.component.ThemNhanVien;
import haladesign.component.ThemQuyenHan;
import haladesign.mainMenu.Main;
import haladesign.model.QuyenHan;
import haladesign.service.PhanQuyenService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class FormQlyVaiTro extends javax.swing.JPanel {

    DefaultTableModel tblModel = new DefaultTableModel();
    private PhanQuyenService quyenHanService = new PhanQuyenService();
    private List<QuyenHan> tempList;
    private final Main main;

    public FormQlyVaiTro(Main main) {
        this.main = main;
        initComponents();
        this.tempList = new ArrayList<>();
        initTable();
        loadDataToTable();
    }

    public void initTable() {
        tblRole.setModel(tblModel);
        String[] title = new String[]{"Tên quyền hạn", "Nhìn giá vốn", "Sửa kho", "Được thao sửa hóa đơn", "Sửa thông tin khách", "Xem báo cáo", "Được sửa quyền hạn"};
        tblModel.setColumnIdentifiers(title);
    }

    public void loadDataToTable() {
        tblModel.setRowCount(0);
        this.tempList.clear();
        for (QuyenHan per : quyenHanService.getList()) {
            this.tempList.add(per);
            tblModel.addRow(new Object[]{
                per.getRoleName(),
                per.isCanViewOrginalPrice() ? "T" : "F",
                per.isCanAddProduct() ? "T" : "F",
                per.isCanChangeBillState() ? "T" : "F",
                per.isCanChangeCustomerInfo() ? "T" : "F",
                per.isCanViewDashboard() ? "T" : "F",
                per.isCanChangeRole() ? "T" : "F"
            });
        }
    }

    public String validating() {
        if (quyenHanService.findByName(txtTenQuyenHan.getText().trim()) != null || txtTenQuyenHan.getText().trim().isBlank()) {
            return "DuplicatedName";
        } else if (canHandleQuyenHan.isSelected()) {
            return "ConfirmQuyenHan";
        }
        return "Valid";
    }

    public void loadDataToChk(QuyenHan role) {
        txtTenQuyenHan.setText(role.getRoleName());
        chkCanViewOriginalPrice.setSelected(role.isCanViewOrginalPrice());
        chkCanHandleStorge.setSelected(role.isCanAddProduct());
        chkCanHandleBills.setSelected(role.isCanChangeBillState());
        canHandleCustomer.setSelected(role.isCanChangeCustomerInfo());
        canHandleDoanhSo.setSelected(role.isCanViewDashboard());
        canHandleQuyenHan.setSelected(role.isCanChangeRole());
    }

    public QuyenHan getRoleFromFields() {
        QuyenHan role = new QuyenHan();
        role.setRoleName(txtTenQuyenHan.getText());
        role.setCanViewOrginalPrice(chkCanViewOriginalPrice.isSelected());
        role.setCanAddProduct(chkCanHandleStorge.isSelected());
        role.setCanChangeBillState(chkCanHandleBills.isSelected());
        role.setCanChangeCustomerInfo(canHandleCustomer.isSelected());
        role.setCanViewDashboard(canHandleDoanhSo.isSelected());
        role.setCanChangeRole(canHandleQuyenHan.isSelected());
        return role;
    }

    public void handleAdding() {
        switch (validating()) {
            case "DuplicatedName" -> {
                JOptionPane.showMessageDialog(this, "Tên vai trò/quyền hạn không được để trống và không được dùng tên quyền hạn đã tồn tại trong hệ thống");
                return;
            }
            case "ConfirmQuyenHan" -> {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn cho nhân viên này quản lý vai trò?", "Warning", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    QuyenHan newQuyenHan = getRoleFromFields();
                    if (newQuyenHan != null) {
                        if (this.quyenHanService.addNewQuyenHan(newQuyenHan)) {
                            JOptionPane.showMessageDialog(this, "Thêm thành công");
                            loadDataToTable();
                        }
                    }
                }
            }
            default -> {
                QuyenHan newQuyenHan = getRoleFromFields();
                if (newQuyenHan != null) {
                    if (this.quyenHanService.addNewQuyenHan(newQuyenHan)) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        loadDataToTable();
                    }
                }
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRole = new haladesign.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTenQuyenHan = new haladesign.swingStyle.TextField();
        chkCanViewOriginalPrice = new javax.swing.JCheckBox();
        chkCanHandleStorge = new javax.swing.JCheckBox();
        chkCanHandleBills = new javax.swing.JCheckBox();
        canHandleCustomer = new javax.swing.JCheckBox();
        canHandleDoanhSo = new javax.swing.JCheckBox();
        canHandleQuyenHan = new javax.swing.JCheckBox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setText("Quản lý quyền hạn nhân viên");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tblRole.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRole);

        jLabel1.setText("T: Được phép truy cập và thao tác tính năng đó");

        jLabel2.setText("F: Không được phép truy cập và thao tác tính năng đó");

        chkCanViewOriginalPrice.setText("Được phép nhìn giá vốn");

        chkCanHandleStorge.setText("Được phép thao tác với kho hàng");

        chkCanHandleBills.setText("Được phép quản lý danh sách hóa đơn");
        chkCanHandleBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCanHandleBillsActionPerformed(evt);
            }
        });

        canHandleCustomer.setText("Được phép sửa thông tin khách hàng");
        canHandleCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canHandleCustomerActionPerformed(evt);
            }
        });

        canHandleDoanhSo.setText("Được phép xem báo cáo doanh số");
        canHandleDoanhSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canHandleDoanhSoActionPerformed(evt);
            }
        });

        canHandleQuyenHan.setText("Được sửa quyền hạn");
        canHandleQuyenHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canHandleQuyenHanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenQuyenHan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkCanViewOriginalPrice)
                                    .addComponent(chkCanHandleStorge))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(canHandleCustomer)
                                    .addComponent(canHandleDoanhSo))))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chkCanHandleBills)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(canHandleQuyenHan)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtTenQuyenHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkCanViewOriginalPrice)
                    .addComponent(canHandleCustomer))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkCanHandleStorge)
                    .addComponent(canHandleDoanhSo))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkCanHandleBills)
                    .addComponent(canHandleQuyenHan))
                .addContainerGap(262, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void chkCanHandleBillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCanHandleBillsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkCanHandleBillsActionPerformed

    private void canHandleCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canHandleCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_canHandleCustomerActionPerformed

    private void canHandleDoanhSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canHandleDoanhSoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_canHandleDoanhSoActionPerformed

    private void canHandleQuyenHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canHandleQuyenHanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_canHandleQuyenHanActionPerformed

    private void tblRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoleMouseClicked
        // TODO add your handling code here:
        int index = tblRole.getSelectedRow();
        if (index >= 0) {
            loadDataToChk(this.tempList.get(index));
        }
    }//GEN-LAST:event_tblRoleMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox canHandleCustomer;
    private javax.swing.JCheckBox canHandleDoanhSo;
    private javax.swing.JCheckBox canHandleQuyenHan;
    private javax.swing.JCheckBox chkCanHandleBills;
    private javax.swing.JCheckBox chkCanHandleStorge;
    private javax.swing.JCheckBox chkCanViewOriginalPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private haladesign.swing.table.Table tblRole;
    private haladesign.swingStyle.TextField txtTenQuyenHan;
    // End of variables declaration//GEN-END:variables
}
