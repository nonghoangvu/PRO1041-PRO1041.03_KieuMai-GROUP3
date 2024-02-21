package haladesign.form;

import haladesign.Utitlity.BcryptHash;
import haladesign.component.ThemSanPham;
import haladesign.component.ThongTinSanPham;
import haladesign.mainMenu.Main;
import haladesign.model.SanPham;
import haladesign.model.SanPhamBienThe;
import haladesign.service.SanPhamService;
import haladesign.swing.table.TableActionCellEditor;
import haladesign.swing.table.TableActionCellRender;
import haladesign.swing.table.TableActionEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NONG HOANG VU
 */
public class ListProductForm extends javax.swing.JPanel {

    private final SanPhamService list;
    private DefaultTableModel tblModel;
    private final BcryptHash bcryptHash = new BcryptHash();
    private final Main main;

    public ListProductForm(Main main) {
        initComponents();
        this.list = new SanPhamService();
        this.main = main;
        fillTable();
    }

    private void fillTable() {
        List<SanPham> sanPhamList = this.list.getList();
        this.tblModel = (DefaultTableModel) tblProduct.getModel();
        this.tblModel.setRowCount(0);
        Collections.sort(sanPhamList, Comparator.comparing(SanPham::getNgay_tao).reversed());
        Integer[] count = { 0 };
        sanPhamList.forEach(sp -> {
            Integer totalQuantity = sp.getBienTheList().stream()
                    .filter(spbt -> sp.getId().startsWith(spbt.getId_san_pham().getId()))
                    .mapToInt(SanPhamBienThe::getSoLuong)
                    .sum();
            Object[] row = { ++count[0], sp.getId(), sp.getTen_san_pham(), totalQuantity,
                    sp.getTrang_thai() ? bcryptHash.decodeBase64("xJBhbmcgYsOhbg==")
                            : bcryptHash.decodeBase64("Tmfhu6tuZyBiw6Fu") };
            this.tblModel.addRow(row);
            TableActionEvent event = (int data) -> {
                if (tblProduct.getSelectedRow() < 0) {
                    tblProduct.getCellEditor().stopCellEditing();
                }
                String selectedProductId = String.valueOf(tblProduct.getValueAt(data, 1));
                String hashedPassword = bcryptHash.decodeBase64("xJBhbmcgYsOhbg==");
                Boolean activity = tblProduct.getValueAt(data, 4).equals(hashedPassword);
                ThongTinSanPham info = new ThongTinSanPham(main, selectedProductId, activity);
                this.main.showForm(info);
            };
            tblProduct.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
            tblProduct.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        });
    }

    public static int generateRandomNumber(int minValue, int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtSearch = new haladesign.swingStyle.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdoAll = new javax.swing.JRadioButton();
        rdoSelling = new javax.swing.JRadioButton();
        rdoStopped = new javax.swing.JRadioButton();
        btnAdd = new haladesign.swingStyle.Button();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblProduct = new haladesign.swing.table.Table();
        lbIcon = new haladesign.card.LabelIcon();

        setBackground(new java.awt.Color(255, 255, 255));

        txtSearch.setLabelText("Tìm kiếm sản phẩm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh sách sản phẩm");

        jLabel2.setText("Trạng thái");

        rdoAll.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoAll);
        rdoAll.setSelected(true);
        rdoAll.setText("Tất cả");

        rdoSelling.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoSelling);
        rdoSelling.setText("Đang bán");

        rdoStopped.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoStopped);
        rdoStopped.setText("Ngừng bán");

        btnAdd.setBackground(new java.awt.Color(255, 204, 51));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm sản phẩm");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "#", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Trạng Thái", "Thao Tác"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setMinWidth(50);
            tblProduct.getColumnModel().getColumn(0).setMaxWidth(50);
            tblProduct.getColumnModel().getColumn(1).setMinWidth(110);
            tblProduct.getColumnModel().getColumn(1).setMaxWidth(210);
            tblProduct.getColumnModel().getColumn(3).setMinWidth(60);
            tblProduct.getColumnModel().getColumn(3).setMaxWidth(110);
            tblProduct.getColumnModel().getColumn(4).setMinWidth(100);
            tblProduct.getColumnModel().getColumn(4).setMaxWidth(120);
            tblProduct.getColumnModel().getColumn(5).setMinWidth(110);
            tblProduct.getColumnModel().getColumn(5).setMaxWidth(110);
        }

        lbIcon.setForeground(new java.awt.Color(255, 255, 255));
        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setLabelFor(btnAdd);
        lbIcon.setText("New Product");
        lbIcon.setColor1(new java.awt.Color(255, 204, 204));
        lbIcon.setColor2(new java.awt.Color(51, 255, 255));
        lbIcon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(rdoAll, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(rdoSelling)
                                                .addGap(20, 20, 20)
                                                .addComponent(rdoStopped, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txtSearch,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGap(18, 18, 18))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel2,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addGap(121, 121, 121))
                                                                        .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                                .addGap(452, 452, 452)))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(20, 20, 20)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel1)
                                                .addGap(5, 5, 5))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdoAll)
                                        .addComponent(rdoSelling)
                                        .addComponent(rdoStopped))
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane1)
                                .addGap(18, 18, 18)));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        ThemSanPham themSanPham = new ThemSanPham(this.main, "HLD-" + generateRandomNumber(10000, 10000000));
        this.main.showForm(themSanPham);
    }// GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnAdd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private haladesign.card.LabelIcon lbIcon;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoSelling;
    private javax.swing.JRadioButton rdoStopped;
    private haladesign.swing.table.Table tblProduct;
    private haladesign.swingStyle.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
