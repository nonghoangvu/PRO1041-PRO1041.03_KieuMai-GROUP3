package haladesign.component;

import haladesign.Utitlity.BcryptHash;
import haladesign.form.DanhSachSanPham;
import haladesign.mainMenu.Main;
import haladesign.model.NhanVien;
import haladesign.model.SanPham;
import haladesign.service.SanPhamService;
import haladesign.system.GlassPanePopup;
import haladesign.system.Notification;
import java.util.Date;

/**
 *
 * @author NONG HOANG VU
 */
public class NewProduct extends javax.swing.JPanel {

    private final NhanVien nhanVien;
    private final Main main;
    private final SanPhamService list;
    private final BcryptHash bcryptHash = new BcryptHash();
    private final DanhSachSanPham listProductForm;

    public NewProduct(String id, NhanVien nhanVien, Main main, DanhSachSanPham listProductForm) {
        initComponents();
        this.nhanVien = nhanVien;
        this.main = main;
        this.list = new SanPhamService();
        this.listProductForm = listProductForm;
        lbNhanVien.setText(this.nhanVien.getFullName());
        lbID.setText(id);
    }

    private SanPham getProduct() {
        SanPham sp = new SanPham();
        sp.setId(lbID.getText());
        sp.setTen_san_pham(txtSanPham.getText());
        sp.setMo_ta(txtMoTa.getText());
        sp.setTrang_thai(chkTrangThai.isSelected());
        sp.setNgay_tao(new Date());
        sp.setNhanVien(this.nhanVien);
        return sp;
    }

    private Boolean validateData() {
        Notification notification;
        if (txtSanPham.getText().trim().isBlank()) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                    this.bcryptHash.decodeBase64("QuG6oW4gY2jGsGEgbmjhuq1wIHTDqm4gc+G6o24gcGjhuqltIQ=="));
            notification.showNotification();
            txtSanPham.requestFocus();
            return false;
        }
        return true;
    }

    private void save() {
        if (validateData()) {
            if (this.list.insertSanPham(getProduct())) {
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, this.bcryptHash.decodeBase64("VGjDqm0gdGjDoG5oIGPDtG5nIQ==")).showNotification();
                GlassPanePopup.closePopupLast();
                this.listProductForm.fillTable();
            } else {
                new Notification(this.main, Notification.Type.INFO, Notification.Location.TOP_RIGHT, this.bcryptHash.decodeBase64("VnVpIGzDsm5nIHRo4butIGzhuqFpIQ==")).showNotification();

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new haladesign.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbNhanVien = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSanPham = new haladesign.swingStyle.TextField();
        textAreaScroll1 = new haladesign.swingStyle.TextAreaScroll();
        txtMoTa = new haladesign.swingStyle.TextArea();
        chkTrangThai = new haladesign.swingStyle.JCheckBoxCustom();
        btnThem = new haladesign.swingStyle.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nhân viên:");

        lbNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNhanVien.setText("Auto");

        lbID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbID.setText("Auto");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mã sản phẩm:");

        txtSanPham.setLabelText("Tên sản phẩm");

        textAreaScroll1.setBackground(new java.awt.Color(255, 255, 255));
        textAreaScroll1.setLabelText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        textAreaScroll1.setViewportView(txtMoTa);

        chkTrangThai.setSelected(true);
        chkTrangThai.setText("Hoạt động");

        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(chkTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbNhanVien))
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbID))
                .addGap(20, 20, 20)
                .addComponent(txtSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(chkTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        save();
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnThem;
    private haladesign.swingStyle.JCheckBoxCustom chkTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbNhanVien;
    private haladesign.swing.RoundPanel roundPanel1;
    private haladesign.swingStyle.TextAreaScroll textAreaScroll1;
    private haladesign.swingStyle.TextArea txtMoTa;
    private haladesign.swingStyle.TextField txtSanPham;
    // End of variables declaration//GEN-END:variables
}
