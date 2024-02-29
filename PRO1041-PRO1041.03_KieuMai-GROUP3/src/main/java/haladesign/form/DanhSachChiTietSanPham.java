package haladesign.form;

import haladesign.Utitlity.FormartData;
import haladesign.component.UpdateProductDetail;
import haladesign.mainMenu.Main;
import haladesign.model.SanPham;
import haladesign.model.SanPhamChiTiet;
import haladesign.service.SanPhamService;
import haladesign.swing.table.TableActionCellEditor;
import haladesign.swing.table.TableActionCellRender;
import haladesign.swing.table.TableActionEvent;
import haladesign.system.GlassPanePopup;
import java.awt.Color;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NONG HOANG VU
 */
public class DanhSachChiTietSanPham extends javax.swing.JPanel {

    private final Main main;
    private final SanPhamService list;
    private DefaultTableModel tblModel;
    private GoogleMaterialDesignIcon icon;

    public DanhSachChiTietSanPham(Main main) {
        initComponents();
        this.main = main;
        this.list = new SanPhamService();
        btnSearch.setColor1(Color.BLACK);
        btnSearch.setColor2(Color.BLACK);
        btnSearch.setIconButton(this.icon.SEARCH);
        fillTable();
    }

    public void fillTable() {
        List<SanPham> sanPhamList = txtSearch.getText().isBlank() ? this.list.getList() : this.list.getListSearch(txtSearch.getText(), true);
        this.tblModel = (DefaultTableModel) tblProduct.getModel();
        tblModel.setRowCount(0);
        Integer[] count = {0};
        sanPhamList.forEach(data -> {
            data.getBienTheList().forEach(sp -> {
                Object[] row
                        = {
                            ++count[0],
                            data.getId(),
                            data.getTen_san_pham() + " " + sp.getTenBienThe(),
                            sp.getSize().getLoaiSize(),
                            sp.getColor().getLoaiMau(),
                            sp.getChatLieu().getLoaiChatLieu(),
                            sp.getSoLuong(),
                            new FormartData().moneyFormatLong(sp.getGia()) + "VND",
                            sp.getNgay_tao()
                        };
                tblModel.addRow(row);
                TableActionEvent event = (int selectedRowTable) -> {
                    if (selectedRowTable < 0) {
                        tblProduct.getCellEditor().stopCellEditing();
                    }
                    String selectedProductId = String.valueOf(tblProduct.getValueAt(selectedRowTable, 1));
                    String selectedProductSize = String.valueOf(tblProduct.getValueAt(selectedRowTable, 3));
                    String selectedProductColor = String.valueOf(tblProduct.getValueAt(selectedRowTable, 4));
                    String selectedProductChatLieu = String.valueOf(tblProduct.getValueAt(selectedRowTable, 5));
                    SanPhamChiTiet spct = this.list.getSanPhamChiTiet(selectedProductId, selectedProductSize, selectedProductColor, selectedProductChatLieu);
                    UpdateProductDetail updateDetail = new UpdateProductDetail(spct, this.main, this);
                    GlassPanePopup.showPopup(updateDetail);
                };
                tblProduct.getColumnModel().getColumn(9).setCellRenderer(new TableActionCellRender());
                tblProduct.getColumnModel().getColumn(9).setCellEditor(new TableActionCellEditor(event));
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new haladesign.swingStyle.TextField();
        btnSearch = new haladesign.swingStyle.Button();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblProduct = new haladesign.swing.table.Table();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Sản Phẩm Chi Tiết");

        txtSearch.setLabelText("Tìm kiếm sản phẩm");

        btnSearch.setBorder(null);
        btnSearch.setText(" ");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Mã Sản Phẩm", "Tên Sản Phẩm", "Size", "Color", "Chất Liệu", "Số lượng", "Giá", "Ngày Tạo", "Thao Tác"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
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
            tblProduct.getColumnModel().getColumn(2).setMinWidth(300);
            tblProduct.getColumnModel().getColumn(2).setMaxWidth(500);
            tblProduct.getColumnModel().getColumn(9).setMinWidth(110);
            tblProduct.getColumnModel().getColumn(9).setMaxWidth(110);
        }

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSearch, txtSearch});

    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        fillTable();
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private haladesign.swing.table.Table tblProduct;
    private haladesign.swingStyle.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
