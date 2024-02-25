package haladesign.component;

import haladesign.Utitlity.BcryptHash;
import haladesign.mainMenu.Main;
import haladesign.model.SanPham;
import haladesign.service.SanPhamService;
import haladesign.system.GlassPanePopup;
import haladesign.system.Notification;
import java.util.Date;

/**
 *
 * @author NONG HOANG VU
 */
public class UpdateProduct extends javax.swing.JPanel {
    
    private final Main main;
    private final SanPhamService list;
    private final BcryptHash bcryptHash = new BcryptHash();
    private final SanPham sp;
    private final NewProductDetails details;
    
    public UpdateProduct(SanPham sp, Main main, NewProductDetails details) {
        initComponents();
        this.main = main;
        this.list = new SanPhamService();
        this.sp = sp;
        this.details = details;
        setData(sp);
    }
    
    private void setData(SanPham sp) {
        lbID.setText(sp.getId());
        txtSanPham.setText(sp.getTen_san_pham());
        txtMoTa.setText(sp.getMo_ta() == null ? "" : sp.getMo_ta());
        chkTrangThai.setSelected(sp.getTrang_thai());
    }
    
    private SanPham getProduct() {
        SanPham sanPhamUpdate = this.sp;
        sanPhamUpdate.setId(lbID.getText());
        sanPhamUpdate.setTen_san_pham(txtSanPham.getText());
        sanPhamUpdate.setMo_ta(txtMoTa.getText());
        sanPhamUpdate.setTrang_thai(chkTrangThai.isSelected());
        return sanPhamUpdate;
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
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, this.bcryptHash.decodeBase64("Q+G6rXAgbmjhuq10IHRow6BuaCBjw7RuZw==")).showNotification();
                GlassPanePopup.closePopupLast();
                this.details.setProduct(this.sp.getId());
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
        jLabel1.setText("Cập Nhật Sản Phẩm");

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
        btnThem.setText("Cập nhật");
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(chkTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbID;
    private haladesign.swing.RoundPanel roundPanel1;
    private haladesign.swingStyle.TextAreaScroll textAreaScroll1;
    private haladesign.swingStyle.TextArea txtMoTa;
    private haladesign.swingStyle.TextField txtSanPham;
    // End of variables declaration//GEN-END:variables
}
