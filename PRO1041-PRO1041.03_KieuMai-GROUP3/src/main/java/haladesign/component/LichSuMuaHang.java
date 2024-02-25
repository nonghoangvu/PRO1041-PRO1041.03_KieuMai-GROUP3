package haladesign.component;

import haladesign.model.KhachHang;
import haladesign.service.KhachHangService;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phương Thảo
 */
public class LichSuMuaHang extends javax.swing.JPanel {

    private final KhachHangService service;
    private DefaultTableModel tblModel;

    public LichSuMuaHang(Integer id) {
        initComponents();
        this.service = new KhachHangService();
        loadUser(id);
        fillTable(id);
    }

    private void loadUser(Integer id) {
        KhachHang kh = this.service.getKhachHangById(id);
        lbTen.setText(kh.getHo_ten());
        lbSdt.setText(kh.getSo_dien_thoai());
    }

    private void fillTable(Integer id) {
        this.tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        Integer[] count = {0};
        this.service.getListProduct(id).forEach(s -> {
            s.getHoaDonChiTiets().forEach(sp -> {
                Object[] row = {
                    ++count[0],
                    sp.getSanPhamChiTiet().getId_san_pham().getTen_san_pham() + " " + sp.getSanPhamChiTiet().getTenBienThe(),
                    sp.getSoLuong(),
                    sp.getSanPhamChiTiet().getColor().getLoaiMau(),
                    sp.getSanPhamChiTiet().getSize().getLoaiSize(),
                    sp.getSanPhamChiTiet().getChatLieu().getLoaiChatLieu(),
                    s.getNgayTao(),
                    s.getHinhThucThanhToan()

                };
                tblModel.addRow(row);
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new haladesign.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        lbSdt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượng", "Màu", "Size", "Chất liệu", "Ngày mua", "Hình thức thanh toán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(50);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(50);
            tblSanPham.getColumnModel().getColumn(2).setMinWidth(70);
            tblSanPham.getColumnModel().getColumn(2).setMaxWidth(70);
            tblSanPham.getColumnModel().getColumn(3).setMinWidth(70);
            tblSanPham.getColumnModel().getColumn(3).setMaxWidth(70);
            tblSanPham.getColumnModel().getColumn(4).setMinWidth(70);
            tblSanPham.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jLabel1.setText("Tên khách hàng: ");

        jLabel2.setText("Số điện thoại:");

        lbTen.setText("ABC");

        lbSdt.setText("+84...");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Lịch Sử Mua Hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel5)
                .addContainerGap(347, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbTen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbSdt))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSdt;
    private javax.swing.JLabel lbTen;
    private haladesign.swing.table.Table tblSanPham;
    // End of variables declaration//GEN-END:variables
}
