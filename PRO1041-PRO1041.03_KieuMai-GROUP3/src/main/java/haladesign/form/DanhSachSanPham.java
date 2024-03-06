package haladesign.form;

import haladesign.Utitlity.BcryptHash;
import haladesign.component.NewProduct;
import haladesign.component.NewProductDetails;
import haladesign.mainMenu.Main;
import haladesign.model.Account;
import haladesign.model.SanPham;
import haladesign.model.SanPhamChiTiet;
import haladesign.service.SanPhamService;
import haladesign.swing.table.TableActionCellEditor;
import haladesign.swing.table.TableActionCellRender;
import haladesign.swing.table.TableActionEvent;
import haladesign.system.GlassPanePopup;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javaswingdev.GoogleMaterialDesignIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NONG HOANG VU
 */
public class DanhSachSanPham extends javax.swing.JPanel {

    private final SanPhamService list;
    private DefaultTableModel tblModel;
    private final BcryptHash bcryptHash = new BcryptHash();
    private final Main main;
    private GoogleMaterialDesignIcon icon;
    private final Account account;

    public DanhSachSanPham(Main main, Account account) {
        initComponents();
        this.list = new SanPhamService();
        this.main = main;
        this.account = account;
        fillTable();
        listenSearch();
        btnAdd.setColor1(Color.BLACK);
        btnAdd.setColor2(Color.BLACK);
        btnAdd.setIconButton(this.icon.ADD);
    }

    public void fillTable() {
        List<SanPham> sanPhamList = !(txtSearch.getText().isBlank()) ? this.list.getListSearch(txtSearch.getText(), cbbStatus.getSelectedIndex() == 0 ? true : cbbStatus.getSelectedIndex() == 3) : cbbStatus.getSelectedIndex() == 0 ? this.list.getList() : cbbStatus.getSelectedIndex() == 2 ? this.list.getListStoped() : getOutOfStock();
        this.tblModel = (DefaultTableModel) tblProduct.getModel();
        this.tblModel.setRowCount(0);
        Collections.sort(sanPhamList, Comparator.comparing(SanPham::getNgay_tao).reversed());
        Integer[] count = {0};
        sanPhamList.forEach(sp -> {
            Integer totalQuantity = sp.getBienTheList().stream()
                    .filter(spbt -> sp.getId().startsWith(spbt.getId_san_pham().getId()))
                    .mapToInt(SanPhamChiTiet::getSoLuong)
                    .sum();
            Object[] row = {++count[0], sp.getId(), sp.getTen_san_pham(), sp.getMo_ta(), totalQuantity, sp.getAccount().getFullName(), sp.getNgay_tao(),
                sp.getTrang_thai() ? bcryptHash.decodeBase64("xJBhbmcgYsOhbg==")
                : bcryptHash.decodeBase64("Tmfhu6tuZyBiw6Fu")};
            this.tblModel.addRow(row);
            TableActionEvent event = (int data) -> {
                if (tblProduct.getSelectedRow() < 0) {
                    tblProduct.getCellEditor().stopCellEditing();
                }
                String selectedProductId = String.valueOf(tblProduct.getValueAt(data, 1));
                NewProductDetails newProductDetails = new NewProductDetails(this.main, selectedProductId, this.account);
                this.main.showForm(newProductDetails);
            };
            tblProduct.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
            tblProduct.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));
        });
    }

    private List<SanPham> getOutOfStock() {
        List<SanPham> prdOutOfStock = new ArrayList<>();
        this.list.getAllList().forEach(sp -> {
            Integer totalQuantity = sp.getBienTheList().stream()
                    .filter(spbt -> sp.getId().startsWith(spbt.getId_san_pham().getId()))
                    .mapToInt(SanPhamChiTiet::getSoLuong)
                    .sum();
            if (totalQuantity == 0) {
                prdOutOfStock.add(sp);
            }
        });
        return prdOutOfStock;
    }

    private void listenSearch() {
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fillTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fillTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                fillTable();
            }

        });
    }

    public static int generateRandomNumber(int minValue, int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtSearch = new haladesign.swingStyle.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new haladesign.swingStyle.Button();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblProduct = new haladesign.swing.table.Table();
        cbbStatus = new haladesign.swingStyle.Combobox();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtSearch.setLabelText("Tìm kiếm sản phẩm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách sản phẩm");

        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnAdd.setText("Thêm sản phẩm");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Mã Sản Phẩm", "Tên Sản Phẩm", "Mô tả", "Số Lượng", "Người tạo", "Ngày tạo", "Trạng Thái", "Thao Tác"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setMinWidth(50);
            tblProduct.getColumnModel().getColumn(0).setMaxWidth(50);
            tblProduct.getColumnModel().getColumn(1).setMinWidth(110);
            tblProduct.getColumnModel().getColumn(1).setMaxWidth(210);
            tblProduct.getColumnModel().getColumn(4).setMinWidth(60);
            tblProduct.getColumnModel().getColumn(4).setMaxWidth(110);
            tblProduct.getColumnModel().getColumn(7).setMinWidth(100);
            tblProduct.getColumnModel().getColumn(7).setMaxWidth(120);
            tblProduct.getColumnModel().getColumn(8).setMinWidth(110);
            tblProduct.getColumnModel().getColumn(8).setMaxWidth(110);
        }

        cbbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đang bán", "Hết hàng", "Ngừng bán" }));
        cbbStatus.setLabeText("");
        cbbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbStatusItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Coder: Nong Hoang Vu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbStatusItemStateChanged
        txtSearch.setText("");
        fillTable();
    }//GEN-LAST:event_cbbStatusItemStateChanged
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        NewProduct newProduct = new NewProduct("HLD-" + generateRandomNumber(10000, 10000000), this.account, this.main, this);
        GlassPanePopup.showPopup(newProduct);
    }// GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnAdd;
    private javax.swing.ButtonGroup buttonGroup1;
    private haladesign.swingStyle.Combobox cbbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private haladesign.swing.table.Table tblProduct;
    private haladesign.swingStyle.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
