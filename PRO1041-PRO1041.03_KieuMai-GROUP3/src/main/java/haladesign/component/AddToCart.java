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
public class AddToCart extends javax.swing.JPanel {

    private final SellForm sellForm;
    private SanPhamChiTiet sanPhamChiTiet;
    private final BillService billService;
    private final Main main;
    private final String idHoaDon;
    private GoogleMaterialDesignIcon icon;

    public AddToCart(Main main, SellForm sellForm, String idHoaDon, String soHoaDon, String idSanPham) {
        initComponents();
        this.sellForm = sellForm;
        lbHoaDon.setText(soHoaDon);
        this.billService = new BillService();
        this.main = main;
        this.idHoaDon = idHoaDon;
        setLable(idSanPham);
        setIconButton();
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

    private void setIconButton(){
        btnAdd.setColor1(Color.BLACK);
        btnAdd.setColor2(Color.BLACK);
        btnAdd.setIconButton(this.icon.ADD_SHOPPING_CART);
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

        setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm Vào Giỏ Hàng");

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

        txtSoLuong.setLabelText("Số lượng cần thêm");

        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnAdd.setText("Thêm vào giỏ hàng");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
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
                .addGap(20, 20, 20)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel lbTen;
    private haladesign.swing.RoundPanel roundPanel1;
    private haladesign.swingStyle.TextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
