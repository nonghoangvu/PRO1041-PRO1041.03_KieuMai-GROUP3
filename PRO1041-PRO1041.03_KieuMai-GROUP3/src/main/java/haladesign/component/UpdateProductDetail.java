package haladesign.component;

import haladesign.Utitlity.ValidateNumber;
import haladesign.form.DanhSachChiTietSanPham;
import haladesign.mainMenu.Main;
import haladesign.model.SanPhamChiTiet;
import haladesign.service.SanPhamService;
import haladesign.system.GlassPanePopup;
import haladesign.system.Notification;

/**
 *
 * @author NONG HOANG VU
 */
public class UpdateProductDetail extends javax.swing.JPanel {

    private final SanPhamChiTiet spct;
    private final Main main;
    private final SanPhamService list;
    private final DanhSachChiTietSanPham danhSachChiTietSanPham;

    public UpdateProductDetail(SanPhamChiTiet spct, Main main, DanhSachChiTietSanPham danhSachChiTietSanPham) {
        initComponents();
        this.spct = spct;
        this.main = main;
        this.list = new SanPhamService();
        this.danhSachChiTietSanPham = danhSachChiTietSanPham;
        setForm();
    }

    private void setForm() {
        lbSanPham.setText("Sản phẩm: " + this.spct.getId_san_pham().getId());
        lbSize.setText("Size: " + this.spct.getSize().getLoaiSize());
        lbColor.setText("Color: " + this.spct.getColor().getLoaiMau());
        lbChatLieu.setText("Chất liệu: " + this.spct.getChatLieu().getLoaiChatLieu());
        txtGia.setText(String.valueOf(this.spct.getGia()));
        txtSoLuong.setText(String.valueOf(this.spct.getSoLuong()));
    }

    private Boolean isValidate() {
        Notification notification;
        if (txtSoLuong.getText().trim().isBlank()) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                    "Vui lòng thêm đủ thông tin!");
            notification.showNotification();
            txtSoLuong.requestFocus();
            return false;
        } else if (txtGia.getText().trim().isBlank()) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                    "Vui lòng thêm đủ thông tin!");
            notification.showNotification();
            txtGia.requestFocus();
            return false;
        } else {
            if (!(new ValidateNumber().isNumber(txtSoLuong.getText().trim()))) {
                notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                        "Dữ liệu không hợp lệ!");
                notification.showNotification();
                txtSoLuong.requestFocus();
                return false;
            } else if (!(new ValidateNumber().isNumber(txtGia.getText().trim()))) {
                notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                        "Dữ liệu không hợp lệ!");
                notification.showNotification();
                txtGia.requestFocus();
                return false;
            } else {
                Integer soLuong = Integer.valueOf(txtSoLuong.getText().trim());
                Integer gia = Integer.valueOf(txtGia.getText().trim());
                if (soLuong < 0) {
                    notification = new Notification(this.main, Notification.Type.WARNING,
                            Notification.Location.TOP_RIGHT, "Số lượng không hợp lệ!");
                    notification.showNotification();
                    txtSoLuong.requestFocus();
                    return false;
                } else if (gia < 1000) {
                    notification = new Notification(this.main, Notification.Type.WARNING,
                            Notification.Location.TOP_RIGHT, "Giá không hợp lệ!");
                    notification.showNotification();
                    txtGia.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    private void update() {
        SanPhamChiTiet sp = this.spct;
        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText().trim()));
        sp.setGia(Integer.valueOf(txtGia.getText().trim()));
        if (this.list.insertBienThe(sp)) {
            this.danhSachChiTietSanPham.fillTable();
            GlassPanePopup.closePopupLast();
            new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Cập nhật thành công!").showNotification();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new haladesign.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        lbSanPham = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();
        lbColor = new javax.swing.JLabel();
        lbChatLieu = new javax.swing.JLabel();
        txtGia = new haladesign.swingStyle.TextField();
        txtSoLuong = new haladesign.swingStyle.TextField();
        button1 = new haladesign.swingStyle.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chỉnh Sửa Thông Tin");

        lbSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSanPham.setText("Sản phẩm: Auto");

        lbSize.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSize.setText("Size: Auto");

        lbColor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbColor.setText("Color: Auto");

        lbChatLieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbChatLieu.setText("Chất liệu: Auto");

        txtGia.setLabelText("Giá");

        txtSoLuong.setLabelText("Số lượng");

        button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        button1.setText("Cập Nhật");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(lbSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbColor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbChatLieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(lbSanPham)
                .addGap(15, 15, 15)
                .addComponent(lbSize)
                .addGap(10, 10, 10)
                .addComponent(lbColor)
                .addGap(10, 10, 10)
                .addComponent(lbChatLieu)
                .addGap(20, 20, 20)
                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (isValidate()) {
            update();
        }
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbChatLieu;
    private javax.swing.JLabel lbColor;
    private javax.swing.JLabel lbSanPham;
    private javax.swing.JLabel lbSize;
    private haladesign.swing.RoundPanel roundPanel1;
    private haladesign.swingStyle.TextField txtGia;
    private haladesign.swingStyle.TextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
