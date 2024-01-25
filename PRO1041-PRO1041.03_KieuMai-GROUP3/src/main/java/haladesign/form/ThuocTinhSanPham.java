package haladesign.form;

import haladesign.component.NewProperties;
import haladesign.mainMenu.Main;
import haladesign.model.Color;
import haladesign.model.Size;
import haladesign.service.SanPhamService;
import haladesign.swing.table.TableActionCellRender;
import haladesign.system.GlassPanePopup;
import java.util.ArrayList;
import java.util.List;
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

    public ThuocTinhSanPham(Main main) {
        initComponents();
        this.list = new SanPhamService();
        this.listSize = new ArrayList<>();
        this.listColor = new ArrayList<>();
        init();
    }

    private void init() {
        setTempColor();
        setTempSize();
        setTable("Size");
        fillSize();
    }

    private void setTempSize() {
        this.listSize = this.list.getSize();
    }

    private void setTempColor() {
        this.listColor = this.list.getCOlor();
    }

    private void setTable(String value) {
        tblModel = (DefaultTableModel) tblProperties.getModel();
        tblModel.setColumnCount(0);
        tblModel.addColumn("#");
        tblModel.addColumn(value);
        tblModel.addColumn("Trạng thái");
        tblModel.addColumn("Ngày tạo");
        tblModel.addColumn("Thao tác");
        tblModel.setRowCount(0);
        tblProperties.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
    }

    private void fillSize() {
        tblModel = (DefaultTableModel) tblProperties.getModel();
        this.listSize.forEach(sz -> {
            Object[] row = {
                sz.getId(),
                sz.getLoaiSize(),
                sz.getTrangThai()?"Đang hoạt động":"Ngừng hoạt động",
                sz.getNgayTao()
            };
            tblModel.addRow(row);
        });
    }
    private  void fillColor(){
        tblModel = (DefaultTableModel) tblProperties.getModel();
        this.listColor.forEach(color -> {
            Object[] row = {
                color.getId(),
                color.getLoaiMau(),
                color.getTrangThai()?"Đang hoạt động":"Ngừng hoạt động",
                color.getNgayTao()
            };
            tblModel.addRow(row);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProperties = new haladesign.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        rdoSize = new javax.swing.JRadioButton();
        rdoColor = new javax.swing.JRadioButton();
        textField1 = new haladesign.swingStyle.TextField();
        btnAdd = new haladesign.swingStyle.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        tblProperties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProperties);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách thuộc tính");

        rdoSize.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoSize);
        rdoSize.setSelected(true);
        rdoSize.setText("Size");
        rdoSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoSizeItemStateChanged(evt);
            }
        });

        rdoColor.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoColor);
        rdoColor.setText("Color");
        rdoColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoColorItemStateChanged(evt);
            }
        });

        textField1.setLabelText("Tìm kiếm");

        btnAdd.setBackground(new java.awt.Color(255, 204, 51));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/haladesign/icon/plus.png"))); // NOI18N
        btnAdd.setText("Thêm size");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(rdoSize)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoColor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoSize)
                        .addComponent(rdoColor)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoSizeItemStateChanged
        setTable("Size");
        btnAdd.setText("Thêm size");
        fillSize();
    }//GEN-LAST:event_rdoSizeItemStateChanged

    private void rdoColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoColorItemStateChanged
        setTable("Color");
        btnAdd.setText("Thêm color");
        fillColor();
    }//GEN-LAST:event_rdoColorItemStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        NewProperties properties = new NewProperties(rdoSize.isSelected());
        GlassPanePopup.showPopup(properties);
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnAdd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoColor;
    private javax.swing.JRadioButton rdoSize;
    private haladesign.swing.table.Table tblProperties;
    private haladesign.swingStyle.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
