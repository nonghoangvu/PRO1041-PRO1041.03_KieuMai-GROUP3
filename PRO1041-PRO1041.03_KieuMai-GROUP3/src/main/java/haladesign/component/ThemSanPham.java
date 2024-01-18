package haladesign.component;

import haladesign.form.ListProductForm;
import haladesign.mainMenu.Main;
import haladesign.model.Color;
import haladesign.model.SanPham;
import haladesign.model.SanPhamBienThe;
import haladesign.model.Size;
import haladesign.service.SanPhamService;
import haladesign.swing.table.TableActionCellRender2;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author NONG HOANG VU
 */
public class ThemSanPham extends javax.swing.JPanel {

    private final SanPhamService list;
    private final Main main;

    public ThemSanPham(Main main, String id) {
        initComponents();
        setOpaque(false);
        this.list = new SanPhamService();
        this.main = main;
        init(id);
    }

    private void init(String id) {
        lbID.setText(id);
        fillSize();
        fillColor();
        updateNameProduct();

    }

    /*__________________________Fill Data__________________________*/
    private void fillTable() {
        tblSanPham.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender2());
    }

    private void fillSize() {
        DefaultComboBoxModel<Size> cbbModel = new DefaultComboBoxModel<>();
        cbbSize.removeAll();
        cbbSize.setModel(cbbModel);
        this.list.getSize().forEach(size -> {
            cbbModel.addElement(size);
        });
    }

    private void fillColor() {
        DefaultComboBoxModel<Color> cbbModel = new DefaultComboBoxModel<>();
        cbbColor.removeAll();
        cbbColor.setModel(cbbModel);
        this.list.getCOlor().forEach(color -> {
            cbbModel.addElement(color);
        });
    }

    /*__________________________Set Data__________________________*/
    private void clear() {
        lbID.setText("HLD-" + generateRandomNumber(10000, 10000000));
        txtSanPham.setEditable(true);
        txtMoTa.setEditable(true);
        txtSanPham.setText("");
        txtMoTa.setText("");
        txtSoLuong.setText("");
        cbbSize.setSelectedIndex(0);
        cbbColor.setSelectedIndex(0);
        txtTenBienThe.setText("");
        txtGia.setText("");
        btnTrangThai.setSelected(false);
    }

    /*__________________________Get Data__________________________*/
    private SanPham getSanPham() {
        SanPham sp = new SanPham();
        sp.setId(lbID.getText());
        sp.setTen_san_pham(txtSanPham.getText());
        sp.setMo_ta(txtMoTa.getText());
        sp.setTrang_thai(btnTrangThai.isSelected());
        return sp;
    }

    private SanPhamBienThe getSanPhamBienThe() {
        SanPhamBienThe sp = new SanPhamBienThe();
        sp.setId_san_pham(getSanPham());
        sp.setTenBienThe(txtTenBienThe.getText());
        sp.setSize(getSizeForm());
        sp.setColor(getColorForm());
        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sp.setGia(Integer.valueOf(txtGia.getText()));
        return sp;
    }

    private Size getSizeForm() {
        Size size = (Size) cbbSize.getSelectedItem();
        return size;
    }

    private Color getColorForm() {
        Color color = (Color) cbbColor.getSelectedItem();
        return color;
    }

    /*__________________________Controller__________________________*/
    private void save() {
        txtSanPham.setEditable(false);
        txtMoTa.setEditable(false);
        System.out.println(this.list.insert(getSanPham(), getSanPhamBienThe()));
        fillTable();
    }

    /*__________________________System__________________________*/
    private void updateNameProduct() {
        txtSanPham.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                txtTenBienThe.setText(txtSanPham.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                txtTenBienThe.setText(txtSanPham.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                txtTenBienThe.setText(txtSanPham.getText());
            }

        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    public Integer generateRandomNumber(int minValue, int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        txtSanPham = new haladesign.swingStyle.TextField();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblSanPham = new haladesign.swing.table.Table();
        cbbSize = new haladesign.swingStyle.Combobox();
        cbbColor = new haladesign.swingStyle.Combobox();
        txtGia = new haladesign.swingStyle.TextField();
        txtSoLuong = new haladesign.swingStyle.TextField();
        txtTenBienThe = new haladesign.swingStyle.TextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTrangThai = new haladesign.swingStyle.SwitchButton();
        textAreaScroll1 = new haladesign.swingStyle.TextAreaScroll();
        txtMoTa = new haladesign.swingStyle.TextArea();
        jPanel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        btnLuu = new haladesign.swingStyle.Button();
        btnLamMoi = new haladesign.swingStyle.Button();
        btnHoanThanh = new haladesign.swingStyle.Button();

        jLabel4.setText("jLabel4");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Mã sản phẩm:");

        lbID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbID.setForeground(new java.awt.Color(153, 153, 153));
        lbID.setText("Auto");

        txtSanPham.setLabelText("Tên sản phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Sản Phẩm", "Số Lượng", "Màu Sắc", "Size", "Giá", "Thao Tác"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(50);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(50);
            tblSanPham.getColumnModel().getColumn(2).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(2).setMaxWidth(120);
            tblSanPham.getColumnModel().getColumn(3).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(3).setMaxWidth(120);
            tblSanPham.getColumnModel().getColumn(4).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(4).setMaxWidth(120);
            tblSanPham.getColumnModel().getColumn(5).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(5).setMaxWidth(120);
            tblSanPham.getColumnModel().getColumn(6).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        cbbSize.setLabeText("Size");

        cbbColor.setLabeText("Color");

        txtGia.setLabelText("Giá");

        txtSoLuong.setLabelText("Số lượng");

        txtTenBienThe.setLabelText("Tên biến thể");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Danh sách biến thể sản phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Hoạt động:");

        textAreaScroll1.setBackground(new java.awt.Color(255, 255, 255));
        textAreaScroll1.setLabelText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        textAreaScroll1.setViewportView(txtMoTa);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbImage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.setText("IMG");
        lbImage.setToolTipText("");
        jPanel1.add(lbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 230));

        btnLuu.setBackground(java.awt.SystemColor.activeCaption);
        btnLuu.setForeground(java.awt.SystemColor.control);
        btnLuu.setText("Lưu");
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(java.awt.SystemColor.activeCaption);
        btnLamMoi.setForeground(java.awt.SystemColor.control);
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnHoanThanh.setBackground(java.awt.SystemColor.activeCaption);
        btnHoanThanh.setForeground(java.awt.SystemColor.control);
        btnHoanThanh.setText("Hoàn thành");
        btnHoanThanh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                            .addComponent(txtSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(cbbSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(cbbColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(txtTenBienThe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(169, 169, 169))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnHoanThanh, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                .addGap(43, 43, 43)))))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbID))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenBienThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clear();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        save();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
        this.main.showForm(new ListProductForm(this.main));
    }//GEN-LAST:event_btnHoanThanhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnHoanThanh;
    private haladesign.swingStyle.Button btnLamMoi;
    private haladesign.swingStyle.Button btnLuu;
    private haladesign.swingStyle.SwitchButton btnTrangThai;
    private haladesign.swingStyle.Combobox cbbColor;
    private haladesign.swingStyle.Combobox cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbImage;
    private haladesign.swing.table.Table tblSanPham;
    private haladesign.swingStyle.TextAreaScroll textAreaScroll1;
    private haladesign.swingStyle.TextField txtGia;
    private haladesign.swingStyle.TextArea txtMoTa;
    private haladesign.swingStyle.TextField txtSanPham;
    private haladesign.swingStyle.TextField txtSoLuong;
    private haladesign.swingStyle.TextField txtTenBienThe;
    // End of variables declaration//GEN-END:variables
}
