package haladesign.component;

import haladesign.Utitlity.FormartData;
import haladesign.form.SellForm;
import haladesign.mainMenu.Main;
import haladesign.model.JPAHoaDonChiTiet;
import haladesign.model.SanPhamChiTiet;
import haladesign.service.BillService;
import haladesign.system.GlassPanePopup;
import haladesign.system.Notification;
import java.awt.Color;
import javaswingdev.GoogleMaterialDesignIcon;

/**
 *
 * @author NONG HOANG VU
 */
public class UpdateCart extends javax.swing.JPanel {
    
    private final SellForm sellForm;
    private SanPhamChiTiet sanPhamChiTiet;
    private final BillService billService;
    private final Main main;
    private final String idHoaDon;
    private GoogleMaterialDesignIcon icon;
    
    public UpdateCart(Main main, SellForm sellForm, String idHoaDon, String soHoaDon, String idSanPham, String soLuongHienTai) {
        initComponents();
        this.sellForm = sellForm;
        lbHoaDon.setText(soHoaDon);
        this.billService = new BillService();
        this.main = main;
        this.idHoaDon = idHoaDon;
        setLable(idSanPham);
        setIconButton();
        lbSoLuongHienTai.setText(soLuongHienTai);
    }
    
    private void setIconButton() {
        btnAdd.setColor1(Color.BLACK);
        btnAdd.setColor2(Color.BLACK);
        btnAdd.setIconButton(this.icon.ADD_SHOPPING_CART);
        
        btnUpdate.setColor1(Color.BLACK);
        btnUpdate.setColor2(Color.BLACK);
        btnUpdate.setIconButton(this.icon.UPDATE);
        
        btnRemove.setColor1(Color.BLACK);
        btnRemove.setColor2(Color.BLACK);
        btnRemove.setIconButton(this.icon.DELETE);
    }
    
    private void setLable(String idSanPham) {
        this.sanPhamChiTiet = this.billService.getSanPhamChiTiet(idSanPham);
        lbTen.setText(this.sanPhamChiTiet.getId_san_pham().getTen_san_pham());
        lbSize.setText(this.sanPhamChiTiet.getSize().getLoaiSize());
        lbColor.setText(this.sanPhamChiTiet.getColor().getLoaiMau());
        lbChatLieu.setText(this.sanPhamChiTiet.getChatLieu().getLoaiChatLieu());
        lbGia.setText(String.valueOf(new FormartData().moneyFormatLong(this.sanPhamChiTiet.getGia())) + "VND");
        lbSoLuong.setText(String.valueOf(this.sanPhamChiTiet.getSoLuong()));
    }
    
    private Boolean isValidate() {
        try {
            if (Integer.parseInt(txtSoLuong.getText().trim()) < 1) {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Số lượng phải lớn hơn 0").showNotification();;
                txtSoLuong.requestFocus();
                return false;
            } else if (Integer.valueOf(txtSoLuong.getText().trim()) > this.sanPhamChiTiet.getSoLuong()) {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Số lượng không đủ!").showNotification();;
                txtSoLuong.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Số lượng phải là số!").showNotification();;
            txtSoLuong.requestFocus();
            return false;
        }
        return true;
    }
    
    private Boolean isValidateUpdate() {
        try {
            if ((Integer.parseInt(txtSoLuong.getText().trim())) <= 0) {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Phải có ít nhất 1 sản phẩm trong giỏ hàng!").showNotification();
                txtSoLuong.requestFocus();
                return false;
            } else if ((Integer.valueOf(lbSoLuongHienTai.getText().trim()) + this.sanPhamChiTiet.getSoLuong()) - Integer.parseInt(txtSoLuong.getText().trim()) < 0) {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Số lượng không đủ!").showNotification();
                txtSoLuong.requestFocus();
                return false;
            }
//            Integer.valueOf(txtSoLuong.getText().trim()) > this.sanPhamChiTiet.getSoLuong()
        } catch (NumberFormatException e) {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Số lượng phải là số!").showNotification();
            txtSoLuong.requestFocus();
            return false;
        }
        return true;
    }
    
    private void addToCard() {
        JPAHoaDonChiTiet hoaDonChiTiet = new JPAHoaDonChiTiet();
        hoaDonChiTiet.setHoaDon(this.billService.getJPAHoaDonById(this.idHoaDon));
        hoaDonChiTiet.setSanPhamChiTiet(this.sanPhamChiTiet);
        hoaDonChiTiet.setSoLuong(Integer.valueOf(txtSoLuong.getText().trim()));
        hoaDonChiTiet.setGia(this.sanPhamChiTiet.getGia());
        hoaDonChiTiet.setTongTien(this.sanPhamChiTiet.getGia() * Integer.valueOf(txtSoLuong.getText().trim()));
        if (this.billService.addToCart(hoaDonChiTiet)) {
            new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã thêm thành công vào giỏ hàng").showNotification();;
            this.sellForm.clear();
            this.sellForm.fillTableSanPham();
            this.sellForm.fillTableSlectBill();
            GlassPanePopup.closePopupLast();
        }
    }
    
    private void updateCart() {
        JPAHoaDonChiTiet hoaDonChiTiet = new JPAHoaDonChiTiet();
        hoaDonChiTiet.setHoaDon(this.billService.getJPAHoaDonById(this.idHoaDon));
        hoaDonChiTiet.setSanPhamChiTiet(this.sanPhamChiTiet);
        hoaDonChiTiet.setSoLuong(Integer.valueOf(txtSoLuong.getText().trim()));
        hoaDonChiTiet.setGia(this.sanPhamChiTiet.getGia());
        hoaDonChiTiet.setTongTien(this.sanPhamChiTiet.getGia() * Integer.valueOf(txtSoLuong.getText().trim()));
        if (this.billService.updateCartItem(hoaDonChiTiet)) {
            new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Sửa thành công").showNotification();;
            this.sellForm.clear();
            this.sellForm.fillTableSanPham();
            this.sellForm.fillTableSlectBill();
            GlassPanePopup.closePopupLast();
        }
    }
    
    private void deleteCart() {
        JPAHoaDonChiTiet hoaDonChiTiet = new JPAHoaDonChiTiet();
        hoaDonChiTiet.setHoaDon(this.billService.getJPAHoaDonById(this.idHoaDon));
        hoaDonChiTiet.setSanPhamChiTiet(this.sanPhamChiTiet);
        if (this.billService.deleteCartItem(hoaDonChiTiet)) {
            new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Xóa thành công").showNotification();;
            this.sellForm.clear();
            this.sellForm.fillTableSanPham();
            this.sellForm.fillTableSlectBill();
            GlassPanePopup.closePopupLast();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new haladesign.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbHoaDon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbColor = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbChatLieu = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        txtSoLuong = new haladesign.swingStyle.TextField();
        btnAdd = new haladesign.swingStyle.Button();
        btnUpdate = new haladesign.swingStyle.Button();
        btnRemove = new haladesign.swingStyle.Button();
        jLabel15 = new javax.swing.JLabel();
        lbSoLuongHienTai = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chỉnh Sửa Giỏ Hàng");

        jLabel2.setText("Hóa đơn:");

        lbHoaDon.setText("Auto");

        jLabel4.setText("Tên Sản Phẩm:");

        lbTen.setText("Auto");

        jLabel6.setText("Size:");

        lbSize.setText("Auto");

        jLabel8.setText("Màu Sắc:");

        lbColor.setText("Auto");

        jLabel10.setText("Chất liệu:");

        lbChatLieu.setText("Auto");

        jLabel12.setText("Giá:");

        lbGia.setText("Auto");

        jLabel14.setText("Số lượng còn lại:");

        lbSoLuong.setText("Auto");

        txtSoLuong.setLabelText("Số lượng");

        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnAdd.setText("Thêm số lượng");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnUpdate.setText("Cập nhật");
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnRemove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnRemove.setText("Xóa");
        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });

        jLabel15.setText("Số lượng hiện tại:");

        lbSoLuongHienTai.setText("Auto");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSoLuongHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );

        roundPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnRemove, btnUpdate});

        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbHoaDon))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbTen))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbSize))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbColor))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbChatLieu))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbGia))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbSoLuong))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbSoLuongHienTai))
                .addGap(20, 20, 20)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        roundPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnRemove, btnUpdate});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (isValidate()) {
            addToCard();
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        if (isValidateUpdate()) {
            updateCart();
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        deleteCart();
    }//GEN-LAST:event_btnRemoveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnAdd;
    private haladesign.swingStyle.Button btnRemove;
    private haladesign.swingStyle.Button btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbChatLieu;
    private javax.swing.JLabel lbColor;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbSoLuongHienTai;
    private javax.swing.JLabel lbTen;
    private haladesign.swing.RoundPanel roundPanel1;
    private haladesign.swingStyle.TextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
