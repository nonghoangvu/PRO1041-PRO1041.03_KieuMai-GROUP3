package haladesign.component;

import haladesign.Utitlity.FormartData;
import haladesign.Utitlity.ValidateNumber;
import haladesign.mainMenu.Main;
import haladesign.model.NhanVien;
import haladesign.model.SanPham;
import haladesign.model.SanPhamChiTiet;
import haladesign.model.Size;
import haladesign.service.SanPhamService;
import haladesign.system.GlassPanePopup;
import haladesign.system.Message;
import haladesign.system.Notification;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NONG HOANG VU
 */
public class NewProductDetails extends javax.swing.JPanel {

    private final Main main;
    private final SanPhamService list;
    private GoogleMaterialDesignIcon icon;
    private List<SanPhamChiTiet> bienTheList;
    private DefaultTableModel tblModel;
    private final String idProduct;
    private final NhanVien nhanVien;

    public NewProductDetails(Main main, String id, NhanVien nhanVien) {
        initComponents();
        this.main = main;
        this.nhanVien = nhanVien;
        this.list = new SanPhamService();
        this.bienTheList = this.list.getByIdSanPhamBienThe(id);
        this.idProduct = id;
        init(id);
    }

    private void init(String id) {
        setProduct(id);
        btnAdd.setColor1(Color.BLACK);
        btnAdd.setColor2(Color.BLACK);
        btnAdd.setIconButton(this.icon.ADD);
        
        btnRefresh.setColor1(Color.BLACK);
        btnRefresh.setColor2(Color.BLACK);
        btnRefresh.setIconButton(this.icon.REFRESH);
        fillSize();
        fillColor();
        fillChatLieu();
        fillTable();
    }

    public void setProduct(String id) {
        SanPham sp = this.list.getSanPhamInfo(id);
        lbID.setText("ID: " + sp.getId());
        lbTen.setText("Tên sản phẩm: " + sp.getTen_san_pham());
        lbTrangThai.setText("Trang thái: " + (sp.getTrang_thai() ? "Đang hoạt động" : "Ngừng hoạt động"));
    }

    private void fillSize() {
        DefaultComboBoxModel<Size> cbbModel = new DefaultComboBoxModel<>();
        Size sizeNull = new Size();
        sizeNull.setLoaiSize("Chọn");
        cbbSize.removeAll();
        cbbSize.setModel(cbbModel);
        cbbModel.addElement(sizeNull);
        this.list.getSize().forEach(size -> {
            if (size.getTrangThai()) {
                cbbModel.addElement(size);
            }
        });
    }

    private void fillColor() {
        DefaultComboBoxModel<haladesign.model.Color> cbbModel = new DefaultComboBoxModel<>();
        haladesign.model.Color colorNull = new haladesign.model.Color();
        colorNull.setLoaiMau("Chọn");
        cbbColor.removeAll();
        cbbColor.setModel(cbbModel);
        cbbModel.addElement(colorNull);
        this.list.getCOlor().forEach(color -> {
            if (color.getTrangThai()) {
                cbbModel.addElement(color);
            }
        });
    }

    private void fillChatLieu() {
        DefaultComboBoxModel<haladesign.model.ChatLieu> cbbModel = new DefaultComboBoxModel<>();
        haladesign.model.ChatLieu chatLieuNull = new haladesign.model.ChatLieu();
        chatLieuNull.setLoaiChatLieu("Chọn");
        cbbChatLieu.removeAll();
        cbbChatLieu.setModel(cbbModel);
        cbbModel.addElement(chatLieuNull);
        this.list.getChatLieu().forEach(chatLieu -> {
            if (chatLieu.getTrangThai()) {
                cbbModel.addElement(chatLieu);
            }
        });
    }

    private void fillTable() {
        tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        Integer[] count = {0};
        this.bienTheList.forEach((SanPhamChiTiet s) -> {
            Object[] row = {
                ++count[0],
                s.getSize().getLoaiSize(),
                s.getColor().getLoaiMau(),
                s.getChatLieu().getLoaiChatLieu(),
                s.getSoLuong(),
                new FormartData().moneyFormat(s.getGia()) + "VND",
                s.getNgay_tao()
            };
            tblModel.addRow(row);
        });
    }

    private void clear() {
        txtSoLuong.setText("");
        cbbSize.setSelectedIndex(0);
        cbbColor.setSelectedIndex(0);
        cbbChatLieu.setSelectedIndex(0);
        txtGia.setText("");
        btnAdd.setText("Thêm");
        btnAdd.setIconButton(this.icon.ADD);
        cbbSize.setEnabled(true);
        cbbColor.setEnabled(true);
        cbbChatLieu.setEnabled(true);
    }

    private void lockWhenClick(){
        cbbSize.setEnabled(false);
        cbbColor.setEnabled(false);
        cbbChatLieu.setEnabled(false);
    }
    private void tableClickRow() {
        if (tblSanPham.getSelectedRow() < 0) {
            return;
        }
        SanPhamChiTiet s = this.bienTheList.get(tblSanPham.getSelectedRow());
        txtSoLuong.setText(String.valueOf(s.getSoLuong()));
        txtGia.setText(String.valueOf(s.getGia()));
        cbbSize.setSelectedIndex(s.getSize().getId());
        cbbColor.setSelectedIndex(s.getColor().getId());
        cbbChatLieu.setSelectedIndex(s.getChatLieu().getId());
        btnAdd.setText("Update");
        btnAdd.setIconButton(this.icon.UPDATE);
        lockWhenClick();
    }

    private Size getSizeForm() {
        Size size = (Size) cbbSize.getSelectedItem();
        return size;
    }

    private haladesign.model.Color getColorForm() {
        haladesign.model.Color color = (haladesign.model.Color) cbbColor.getSelectedItem();
        return color;
    }

    private haladesign.model.ChatLieu getChatLieuForm() {
        haladesign.model.ChatLieu chatLieu = (haladesign.model.ChatLieu) cbbChatLieu.getSelectedItem();
        return chatLieu;
    }

    private SanPhamChiTiet getSanPhamBienThe() {
        SanPhamChiTiet sp = new SanPhamChiTiet();
        sp.setId_san_pham(this.list.getSanPhamInfo(this.idProduct));
        sp.setTenBienThe(String.format("[%s-%s-%s]", getSizeForm().getLoaiSize(), getColorForm().getLoaiMau(), getChatLieuForm().getLoaiChatLieu()));
        sp.setSize(getSizeForm());
        sp.setColor(getColorForm());
        sp.setChatLieu(getChatLieuForm());
        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sp.setGia(Integer.valueOf(txtGia.getText()));
        return sp;
    }

    private Boolean isValidate() {
        Notification notification;
        if (txtSoLuong.getText().trim().isBlank()) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                    "Vui lòng thêm đủ thông tin!");
            notification.showNotification();
            txtSoLuong.requestFocus();
            return false;
        } else if (cbbSize.getSelectedIndex() == 0) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                    "Vui lòng chọn Size!");
            notification.showNotification();
            cbbSize.requestFocus();
            return false;
        } else if (cbbColor.getSelectedIndex() == 0) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                    "Vui lòng chọn màu sắc!");
            notification.showNotification();
            cbbColor.requestFocus();
            return false;
        } else if (cbbChatLieu.getSelectedIndex() == 0) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                    "Vui lòng chọn chất liệu!");
            notification.showNotification();
            cbbChatLieu.requestFocus();
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

    private Boolean existsBienTheWithColorAndSize(List<SanPhamChiTiet> bienThe, String targetColor, String targetSize, String targetChatLieu) {
        return bienThe.stream().anyMatch(
                sp -> targetColor.equals(sp.getColor().getLoaiMau()) && targetSize.equals(sp.getSize().getLoaiSize()) && targetChatLieu.equals(sp.getChatLieu().getLoaiChatLieu()));
    }

    private void add() {
        if (existsBienTheWithColorAndSize(this.bienTheList, getColorForm().getLoaiMau(), getSizeForm().getLoaiSize(), getChatLieuForm().getLoaiChatLieu())) {
            Message message = new Message();
            message.setTitle("Cảnh báo");
            message.setMessage(
                    "Thuộc tính này đã tồn tại bạn có muốn bổ sung thêm số lượng và thay đổi thông tin không?");
            message.eventOK(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SanPhamChiTiet sp = NewProductDetails.this.list
                            .getByColorAndSizeAndChatLieu(NewProductDetails.this.idProduct, getColorForm(), getSizeForm(), getChatLieuForm()).get(0);
                    sp.setSoLuong(sp.getSoLuong() + Integer.valueOf(txtSoLuong.getText()));
                    sp.setGia(Integer.valueOf(txtGia.getText()));
                    if (NewProductDetails.this.list.insertBienThe(sp)) {
                        NewProductDetails.this.bienTheList = NewProductDetails.this.list
                                .getByIdSanPhamBienThe(NewProductDetails.this.idProduct);
                        new Notification(NewProductDetails.this.main, Notification.Type.SUCCESS,
                                Notification.Location.TOP_RIGHT, "Đã bổ sung số lượng và thông tin sản phẩm!")
                                .showNotification();
                        clear();
                        fillTable();
                    } else {
                        new Notification(NewProductDetails.this.main, Notification.Type.WARNING,
                                Notification.Location.TOP_RIGHT, "Vui lòng thử lại!").showNotification();
                    }
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(message);
        } else {
            if (this.list.insertBienThe(getSanPhamBienThe())) {
                this.bienTheList = this.list.getByIdSanPhamBienThe(this.idProduct);
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT,
                        "Thêm thành công!").showNotification();
                fillTable();
            } else {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                        "Vui lòng thử lại!").showNotification();
            }
        }
    }

    private void update() {
        SanPhamChiTiet sp = NewProductDetails.this.list
                .getByColorAndSizeAndChatLieu(NewProductDetails.this.idProduct, getColorForm(), getSizeForm(), getChatLieuForm()).get(0);
        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sp.setGia(Integer.valueOf(txtGia.getText()));
        if (NewProductDetails.this.list.insertBienThe(sp)) {
            NewProductDetails.this.bienTheList = NewProductDetails.this.list
                    .getByIdSanPhamBienThe(NewProductDetails.this.idProduct);
            new Notification(NewProductDetails.this.main, Notification.Type.SUCCESS,
                    Notification.Location.TOP_RIGHT, "Cập nhật thành công")
                    .showNotification();
            clear();
            fillTable();
        } else {
            new Notification(NewProductDetails.this.main, Notification.Type.WARNING,
                    Notification.Location.TOP_RIGHT, "Vui lòng thử lại!").showNotification();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new haladesign.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbID = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        lbTrangThai = new javax.swing.JLabel();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblSanPham = new haladesign.swing.table.Table();
        cbbSize = new haladesign.swingStyle.Combobox();
        cbbColor = new haladesign.swingStyle.Combobox();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new haladesign.swingStyle.TextField();
        txtGia = new haladesign.swingStyle.TextField();
        btnAdd = new haladesign.swingStyle.Button();
        btnRefresh = new haladesign.swingStyle.Button();
        cbbChatLieu = new haladesign.swingStyle.Combobox();

        setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chi Tiết Sản Phẩm");

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        lbID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbID.setForeground(new java.awt.Color(51, 51, 51));
        lbID.setText("ID:");

        lbTen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTen.setForeground(new java.awt.Color(51, 51, 51));
        lbTen.setText("Tên sản phẩm: ");

        lbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTrangThai.setForeground(new java.awt.Color(51, 51, 51));
        lbTrangThai.setText("Trang thái: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(lbTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(lbID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbID)
                .addGap(10, 10, 10)
                .addComponent(lbTen)
                .addGap(10, 10, 10)
                .addComponent(lbTrangThai)
                .addGap(10, 10, 10))
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Size", "Color", "Chất liệu", "Số lượng", "Giá", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        cbbSize.setLabeText("Size");

        cbbColor.setLabeText("Color");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Danh sách thuộc tính sản phẩm");

        txtSoLuong.setLabelText("Số lượng");

        txtGia.setLabelText("Giá");

        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnAdd.setText("Thêm");
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

        cbbChatLieu.setLabeText("Chất liệu");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(cbbSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        roundPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, cbbColor, cbbSize});

        roundPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnRefresh, txtGia, txtSoLuong});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        UpdateProduct updateProduct = new UpdateProduct(this.list.getSanPhamInfo(this.idProduct), this.main, this);
        GlassPanePopup.showPopup(updateProduct);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        tableClickRow();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (isValidate()) {
            if (!btnAdd.getText().equalsIgnoreCase("Update")) {
                add();
            } else {
                update();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        clear();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnAdd;
    private haladesign.swingStyle.Button btnRefresh;
    private haladesign.swingStyle.Combobox cbbChatLieu;
    private haladesign.swingStyle.Combobox cbbColor;
    private haladesign.swingStyle.Combobox cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbTen;
    private javax.swing.JLabel lbTrangThai;
    private haladesign.swing.RoundPanel roundPanel1;
    private haladesign.swing.table.Table tblSanPham;
    private haladesign.swingStyle.TextField txtGia;
    private haladesign.swingStyle.TextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
