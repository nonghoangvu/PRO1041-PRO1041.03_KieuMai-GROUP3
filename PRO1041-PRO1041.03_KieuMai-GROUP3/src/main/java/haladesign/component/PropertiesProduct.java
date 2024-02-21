package haladesign.component;

import haladesign.mainMenu.Main;
import haladesign.model.Color;
import haladesign.model.Size;
import haladesign.service.SanPhamService;
import haladesign.system.Notification;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author NONG HOANG VU
 */
public class PropertiesProduct extends javax.swing.JPanel {

    private final Boolean type;
    private final SanPhamService control;
    private final List<Size> listSize;
    private final List<Color> listColor;
    private final Main main;

    public PropertiesProduct(Boolean type, Main main, String properties, Boolean activity) {
        initComponents();
        this.type = type;
        this.main = main;
        setEditProperties(properties, activity);
        this.control = new SanPhamService();
        lbProrperties.setText(type ? "Size" : "Color");
        txtProperties.setLabelText(type ? "Nhập Size" : "Nhập Color");
        this.listSize = this.control.getSize();
        this.listColor = this.control.getCOlor();
    }

    private void setEditProperties(String properties, Boolean activity) {
        if (!properties.isEmpty()) {
            txtProperties.setText(properties);
            txtProperties.setEditable(false);
            chkActive.setSelected(activity);
        }
    }

    private boolean existsSize() {
        AtomicBoolean found = new AtomicBoolean(false);
        this.listSize.forEach(s -> {
            if (s.getLoaiSize().equalsIgnoreCase(txtProperties.getText())) {
                found.set(true);
            }
        });

        return found.get();
    }

    private boolean existsColor() {
        AtomicBoolean found = new AtomicBoolean(false);
        this.listColor.forEach(c -> {
            if (c.getLoaiMau().equalsIgnoreCase(txtProperties.getText())) {
                found.set(true);
            }
        });
        return found.get();
    }

    private void configSize() {
        if(txtProperties.getText().isBlank()){
            return;
        }
        if (existsSize()) {
            Size size = this.control.findBySize(txtProperties.getText().trim());
            size.setTrangThai(chkActive.isSelected());
            if (this.control.insertSize(size)) {
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã cập nhật trạng thái của thuộc tính " + size.getLoaiSize()).showNotification();
            } else {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thử lại sau").showNotification();
            }
        } else {
            Size size = new Size();
            size.setLoaiSize(txtProperties.getText().trim());
            size.setTrangThai(chkActive.isSelected());
            size.setNgayTao(new Date());
            if (this.control.insertSize(size)) {
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã thêm một size mới").showNotification();
            } else {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thử lại sau").showNotification();
            }
        }
    }

    private void configColor() {
        if(txtProperties.getText().isBlank()){
            return;
        }
        if (existsColor()) {
            Color color = this.control.findByColor(txtProperties.getText().trim());
            color.setTrangThai(chkActive.isSelected());
            if (this.control.insertColor(color)) {
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã cập nhật trạng thái của thuộc tính " + color.getLoaiMau()).showNotification();
            } else {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thử lại sau").showNotification();
            }
        } else {
            Color color = new Color();
            color.setLoaiMau(txtProperties.getText().trim());
            color.setTrangThai(chkActive.isSelected());
            color.setNgayTao(new Date());
            if (this.control.insertColor(color)) {
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã thêm một màu mới").showNotification();
            } else {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thử lại sau").showNotification();
            }
        }
    }

    public void evenSave(ActionListener event) {
        btnSave.addActionListener(event);
    }

    private void isSubmit() {
        if (this.type) {
            configSize();
        } else {
            configColor();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbProrperties = new javax.swing.JLabel();
        txtProperties = new haladesign.swingStyle.TextField();
        btnSave = new haladesign.swingStyle.Button();
        chkActive = new haladesign.swingStyle.JCheckBoxCustom();

        setBackground(new java.awt.Color(255, 255, 255));

        lbProrperties.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProrperties.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProrperties.setText("Properties");

        txtProperties.setLabelText("Properties");

        btnSave.setBackground(new java.awt.Color(102, 204, 255));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Lưu");
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        chkActive.setText("Hoạt động");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lbProrperties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(187, 187, 187))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProperties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(169, 169, 169)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbProrperties)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProperties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(chkActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        isSubmit();
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnSave;
    private haladesign.swingStyle.JCheckBoxCustom chkActive;
    private javax.swing.JLabel lbProrperties;
    private haladesign.swingStyle.TextField txtProperties;
    // End of variables declaration//GEN-END:variables
}
