package haladesign.form;

import haladesign.mainMenu.Main;
import haladesign.model.ChatLieu;
import haladesign.model.Color;
import haladesign.model.Size;
import haladesign.service.SanPhamService;
import haladesign.system.Notification;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javaswingdev.GoogleMaterialDesignIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NONG HOANG VU
 */
public class ThuocTinhSanPham extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private final SanPhamService list;
    private List<Size> listSize;
    private List<Color> listColor;
    private List<ChatLieu> listChatLieu;
    private final Main main;
    private GoogleMaterialDesignIcon icon;

    public ThuocTinhSanPham(Main main) {
        initComponents();
        this.main = main;
        this.list = new SanPhamService();
        this.listSize = new ArrayList<>();
        this.listColor = new ArrayList<>();
        this.listChatLieu = new ArrayList<>();
        init();
    }

    private void init() {
        setTempColor();
        setTempSize();
        btnAdd.setColor1(java.awt.Color.BLACK);
        btnAdd.setColor2(java.awt.Color.BLACK);
        btnRefresh.setColor1(java.awt.Color.BLACK);
        btnRefresh.setColor2(java.awt.Color.BLACK);
        btnAdd.setIconButton(this.icon.ADD);
        btnRefresh.setIconButton(this.icon.REFRESH);
        setTable("Size");
        fillSize();
    }

    private void setTempSize() {
        this.listSize = this.list.getSize();
    }

    private void setTempColor() {
        this.listColor = this.list.getCOlor();
    }

    private void setTempChatLieu() {
        this.listChatLieu = this.list.getChatLieu();
    }

    private void setTable(String value) {
        tblModel = (DefaultTableModel) tblProperties.getModel();
        tblModel.setColumnCount(0);
        tblModel.addColumn("#");
        tblModel.addColumn(value);
        tblModel.addColumn("Trạng thái");
        tblModel.addColumn("Ngày tạo");
        tblProperties.getColumnModel().getColumn(0).setMinWidth(50);
        tblProperties.getColumnModel().getColumn(0).setMaxWidth(50);
        tblModel.setRowCount(0);
    }

    private void fillSize() {
        tblModel = (DefaultTableModel) tblProperties.getModel();
        tblModel.setRowCount(0);
        this.listSize.forEach(sz -> {
            Object[] row = {
                sz.getId(),
                sz.getLoaiSize(),
                sz.getTrangThai() ? "Đang hoạt động" : "Ngừng hoạt động",
                sz.getNgayTao()
            };
            tblModel.addRow(row);
        });
    }

    private void fillColor() {
        tblModel = (DefaultTableModel) tblProperties.getModel();
        tblModel.setRowCount(0);
        this.listColor.forEach(color -> {
            Object[] row = {
                color.getId(),
                color.getLoaiMau(),
                color.getTrangThai() ? "Đang hoạt động" : "Ngừng hoạt động",
                color.getNgayTao()
            };
            tblModel.addRow(row);
        });
    }

    private void fillChatLieu() {
        tblModel = (DefaultTableModel) tblProperties.getModel();
        tblModel.setRowCount(0);
        this.listChatLieu.forEach(color -> {
            Object[] row = {
                color.getId(),
                color.getLoaiChatLieu(),
                color.getTrangThai() ? "Đang hoạt động" : "Ngừng hoạt động",
                color.getNgayTao()
            };
            tblModel.addRow(row);
        });
    }

    private Boolean existsSize() {
        AtomicBoolean found = new AtomicBoolean(false);
        this.listSize.forEach(s -> {
            if (s.getLoaiSize().trim().equalsIgnoreCase(txtTenThuocTinh.getText().trim())) {
                found.set(true);
            }
        });
        return found.get();
    }

    private Boolean existsColor() {
        AtomicBoolean found = new AtomicBoolean(false);
        this.listColor.forEach(c -> {
            if (c.getLoaiMau().trim().equalsIgnoreCase(txtTenThuocTinh.getText().trim())) {
                found.set(true);
            }
        });
        return found.get();
    }

    private Boolean existsChatLieu() {
        AtomicBoolean found = new AtomicBoolean(false);
        this.listChatLieu.forEach(c -> {
            if (c.getLoaiChatLieu().trim().equalsIgnoreCase(txtTenThuocTinh.getText().trim())) {
                found.set(true);
            }
        });
        return found.get();
    }

    private void saveSize() {
        if (!existsSize()) {
            Size size = new Size();
            size.setLoaiSize(txtTenThuocTinh.getText().trim());
            size.setTrangThai(true);
            size.setNgayTao(new Date());
            if (this.list.insertSize(size)) {
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã thêm một size mới").showNotification();
                fillSize();
                txtTenThuocTinh.setText("");
            }
        } else {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Thuộc tính đã tồn tại").showNotification();
        }
    }

    private void saveColor() {
        if (!existsColor()) {
            Color color = new Color();
            color.setLoaiMau(txtTenThuocTinh.getText().trim());
            color.setTrangThai(true);
            color.setNgayTao(new Date());
            if (this.list.insertColor(color)) {
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã thêm một color mới").showNotification();
                fillColor();
                txtTenThuocTinh.setText("");
            }
        } else {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Thuộc tính đã tồn tại").showNotification();
        }
    }

    private void saveChatLieu() {
        if (!existsChatLieu()) {
            ChatLieu chatLieu = new ChatLieu();
            chatLieu.setLoaiChatLieu(txtTenThuocTinh.getText().trim());
            chatLieu.setTrangThai(true);
            chatLieu.setNgayTao(new Date());
            if (this.list.insertChatLieu(chatLieu)) {
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã thêm một chất liệu mới").showNotification();
                fillColor();
                txtTenThuocTinh.setText("");
            }
        } else {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Thuộc tính đã tồn tại").showNotification();
        }
    }

    private void save() {
        switch (cbbThuocTinh.getSelectedIndex()) {
            case 0 ->
                saveSize();
            case 1 ->
                saveColor();
            default ->
                saveChatLieu();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblProperties = new haladesign.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new haladesign.swingStyle.Button();
        btnRefresh = new haladesign.swingStyle.Button();
        txtTenThuocTinh = new haladesign.swingStyle.TextField();
        cbbThuocTinh = new haladesign.swingStyle.Combobox();

        setBackground(new java.awt.Color(255, 255, 255));

        tblProperties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProperties);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách thuộc tính");

        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnAdd.setText("Thêm size");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRefresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnRefresh.setText("Làm mới");
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        txtTenThuocTinh.setLabelText("Tên thuộc tính mới");

        cbbThuocTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Size", "Color", "Chất liệu" }));
        cbbThuocTinh.setLabeText("");
        cbbThuocTinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThuocTinhItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnRefresh, cbbThuocTinh, txtTenThuocTinh});

    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtTenThuocTinh.getText().trim().isBlank()) {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng không bỏ trống tên thuộc tính!").showNotification();
            txtTenThuocTinh.requestFocus();
        } else if (txtTenThuocTinh.getText().trim().length() > 20) {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Tên thuộc tính không hợp lệ!").showNotification();
            txtTenThuocTinh.requestFocus();
        } else {
            save();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        setTempSize();
        setTempColor();
        setTempChatLieu();
        txtTenThuocTinh.setText("");
        switch (cbbThuocTinh.getSelectedIndex()) {
            case 0 -> {
                btnAdd.setText("Thêm size");
                fillSize();
            }
            case 1 -> {
                btnAdd.setText("Thêm color");
                fillColor();
            }
            default -> {
                btnAdd.setText("Thêm chất liệu");
                fillChatLieu();

            }
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cbbThuocTinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThuocTinhItemStateChanged
        setTempSize();
        setTempColor();
        setTempChatLieu();
        txtTenThuocTinh.setText("");
        switch (cbbThuocTinh.getSelectedIndex()) {
            case 0 -> {
                btnAdd.setText("Thêm size");
                fillSize();
            }
            case 1 -> {
                btnAdd.setText("Thêm color");
                fillColor();
            }
            default -> {
                btnAdd.setText("Thêm chất liệu");
                fillChatLieu();

            }
        }
    }//GEN-LAST:event_cbbThuocTinhItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnAdd;
    private haladesign.swingStyle.Button btnRefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private haladesign.swingStyle.Combobox cbbThuocTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private haladesign.swing.table.Table tblProperties;
    private haladesign.swingStyle.TextField txtTenThuocTinh;
    // End of variables declaration//GEN-END:variables
}
