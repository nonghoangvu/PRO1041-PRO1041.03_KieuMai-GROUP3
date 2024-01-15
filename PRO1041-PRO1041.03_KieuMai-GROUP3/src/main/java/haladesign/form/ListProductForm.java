package haladesign.form;

import haladesign.model.SanPham;
import haladesign.service.SanPhamService;
import haladesign.swing.table.TableActionCellEditor;
import haladesign.swing.table.TableActionCellRender;
import haladesign.swing.table.TableActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NONG HOANG VU
 */
public class ListProductForm extends javax.swing.JPanel {

    private final SanPhamService list;
    private DefaultTableModel tblModel;

    public ListProductForm() {
        initComponents();
        this.list = new SanPhamService();
        fillTable();
    }

    private void fillTable() {
        this.tblModel = (DefaultTableModel) tblProduct.getModel();
        this.tblModel.setRowCount(0);
        Integer count = 0;
        for (SanPham sv : this.list.getList()) {
            Object[] row = {
                ++count,
                sv.getId(),
                sv.getTen_san_pham(),
                0,
                sv.getTrang_thai() ? "Đang bán" : "Ngừng bán",};
            this.tblModel.addRow(row);
            TableActionEvent event = (int row1) -> {
                if (tblProduct.getSelectedRow() < 0) {
                    tblProduct.getCellEditor().stopCellEditing();
                }
                System.out.println("Hi");
            };
            tblProduct.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
            tblProduct.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        }
    }

    @SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtSearch = new haladesign.swingStyle.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdoAll = new javax.swing.JRadioButton();
        rdoSelling = new javax.swing.JRadioButton();
        rdoStopped = new javax.swing.JRadioButton();
        btnImport = new haladesign.swingStyle.Button();
        btnAdd = new haladesign.swingStyle.Button();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblProduct = new haladesign.swing.table.Table();

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

        btnImport.setBackground(new java.awt.Color(0, 204, 51));
        btnImport.setForeground(new java.awt.Color(255, 255, 255));
        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/haladesign/icon/excel.png"))); // NOI18N
        btnImport.setText("Import");
        btnImport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnAdd.setBackground(new java.awt.Color(255, 204, 51));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/haladesign/icon/plus.png"))); // NOI18N
        btnAdd.setText("Thêm sản phẩm");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoAll, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(rdoSelling)
                                .addGap(20, 20, 20)
                                .addComponent(rdoStopped, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(121, 121, 121))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(620, 620, 620))))
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
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAll)
                    .addComponent(rdoSelling)
                    .addComponent(rdoStopped)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnAdd;
    private haladesign.swingStyle.Button btnImport;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoSelling;
    private javax.swing.JRadioButton rdoStopped;
    private haladesign.swing.table.Table tblProduct;
    private haladesign.swingStyle.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
