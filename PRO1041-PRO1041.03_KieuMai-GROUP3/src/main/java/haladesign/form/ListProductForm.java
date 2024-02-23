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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
        listenSearch();
    }

    private void fillTable() {
        List<SanPham> sanPhamList = !(txtSearch.getText().isBlank()) ? this.list.getListSearch(txtSearch.getText(), rdoSelling.isSelected() ? true : rdoOutOfStock.isSelected()) : rdoSelling.isSelected() ? this.list.getList() : rdoStopped.isSelected() ? this.list.getListStoped() : getOutOfStock();
        this.tblModel = (DefaultTableModel) tblProduct.getModel();
        this.tblModel.setRowCount(0);
        Collections.sort(sanPhamList, Comparator.comparing(SanPham::getNgay_tao).reversed());
        Integer[] count = {0};
        sanPhamList.forEach(sp -> {
            Integer totalQuantity = sp.getBienTheList().stream()
                    .filter(spbt -> sp.getId().startsWith(spbt.getId_san_pham().getId()))
                    .mapToInt(SanPhamBienThe::getSoLuong)
                    .sum();
            Object[] row = {++count[0], sp.getId(), sp.getTen_san_pham(), totalQuantity,
                sp.getTrang_thai() ? bcryptHash.decodeBase64("xJBhbmcgYsOhbg==")
                : bcryptHash.decodeBase64("Tmfhu6tuZyBiw6Fu")};
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

    private List<SanPham> getOutOfStock() {
        List<SanPham> prdOutOfStock = new ArrayList<>();
        this.list.getAllList().forEach(sp -> {
            Integer totalQuantity = sp.getBienTheList().stream()
                    .filter(spbt -> sp.getId().startsWith(spbt.getId_san_pham().getId()))
                    .mapToInt(SanPhamBienThe::getSoLuong)
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtSearch = new haladesign.swingStyle.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdoSelling = new javax.swing.JRadioButton();
        rdoStopped = new javax.swing.JRadioButton();
        btnAdd = new haladesign.swingStyle.Button();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblProduct = new haladesign.swing.table.Table();
        rdoOutOfStock = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtSearch.setLabelText("Tìm kiếm sản phẩm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh sách sản phẩm");

        jLabel2.setText("Trạng thái");

        rdoSelling.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoSelling);
        rdoSelling.setSelected(true);
        rdoSelling.setText("Đang bán");
        rdoSelling.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoSellingItemStateChanged(evt);
            }
        });

        rdoStopped.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoStopped);
        rdoStopped.setText("Ngừng bán");
        rdoStopped.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoStoppedItemStateChanged(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(127, 127, 127));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm sản phẩm");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Trạng Thái", "Thao Tác"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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
            tblProduct.getColumnModel().getColumn(3).setMinWidth(60);
            tblProduct.getColumnModel().getColumn(3).setMaxWidth(110);
            tblProduct.getColumnModel().getColumn(4).setMinWidth(100);
            tblProduct.getColumnModel().getColumn(4).setMaxWidth(120);
            tblProduct.getColumnModel().getColumn(5).setMinWidth(110);
            tblProduct.getColumnModel().getColumn(5).setMaxWidth(110);
        }

        rdoOutOfStock.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoOutOfStock);
        rdoOutOfStock.setText("Hết hàng");
        rdoOutOfStock.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoOutOfStockItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoSelling)
                        .addGap(20, 20, 20)
                        .addComponent(rdoStopped, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoOutOfStock)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(121, 121, 121))
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(452, 452, 452)))
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoSelling)
                    .addComponent(rdoStopped)
                    .addComponent(rdoOutOfStock))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoOutOfStockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoOutOfStockItemStateChanged
        txtSearch.setText("");
        fillTable();
    }//GEN-LAST:event_rdoOutOfStockItemStateChanged

    private void rdoSellingItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rdoSellingItemStateChanged
        txtSearch.setText("");
        fillTable();
    }// GEN-LAST:event_rdoSellingItemStateChanged

    private void rdoStoppedItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rdoStoppedItemStateChanged
        txtSearch.setText("");
        fillTable();
    }// GEN-LAST:event_rdoStoppedItemStateChanged

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
    private javax.swing.JRadioButton rdoOutOfStock;
    private javax.swing.JRadioButton rdoSelling;
    private javax.swing.JRadioButton rdoStopped;
    private haladesign.swing.table.Table tblProduct;
    private haladesign.swingStyle.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
