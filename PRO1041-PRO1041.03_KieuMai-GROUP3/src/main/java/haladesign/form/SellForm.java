package haladesign.form;

import haladesign.Utitlity.FormartData;
import haladesign.component.AddToCart;
import haladesign.component.UpdateCart;
import haladesign.mainMenu.Main;
import haladesign.model.JPAHoaDon;
import haladesign.model.JPAHoaDonChiTiet;
import haladesign.model.KhachHang;
import haladesign.model.NhanVien;
import haladesign.model.SanPham;
import haladesign.service.BillService;
import haladesign.service.SanPhamService;
import haladesign.system.GlassPanePopup;
import haladesign.system.Message;
import haladesign.system.Notification;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import javax.swing.AbstractAction;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NONG HOANG VU
 */
public class SellForm extends javax.swing.JPanel {

    private final SanPhamService sanPhamService;
    private final BillService billService;
    private DefaultTableModel tblModel;
    private final NhanVien nhanVien;
    private final Main main;
    private Long totalMoney = 0L;
    private Long tienThua = 0L;
    private GoogleMaterialDesignIcon icon;

    public SellForm(NhanVien nhanVien, Main main) {
        initComponents();
        this.sanPhamService = new SanPhamService();
        this.billService = new BillService();
        this.nhanVien = nhanVien;
        this.main = main;
        init();
    }

    private void init() {
        fillCombo();
        fillTableHoaDon();
        fillTableSanPham();
        change();
        clear();
        setIconButton();
    }

    private void setChange() {
        if (!txtTienKhachDua.getText().trim().isBlank()) {
            try {
                if (Long.parseLong(txtTienKhachDua.getText().trim()) < 0) {
                    lbTrangThaiTien.setText("Tiền thừa:");
                    lbChange.setText("Không nhập số nhỏ hơn 0");
                } else if (Long.valueOf(txtTienKhachDua.getText().trim()) < this.totalMoney) {
                    lbTrangThaiTien.setText("Còn thiếu:");
                    lbChange.setText((new FormartData().moneyFormatLong(SellForm.this.totalMoney - Long.valueOf(txtTienKhachDua.getText().trim()))) + "VND");
                } else {
                    lbTrangThaiTien.setText("Tiền thừa:");
                    this.tienThua = Long.valueOf(txtTienKhachDua.getText().trim()) - SellForm.this.totalMoney;
                    lbChange.setText(new FormartData().moneyFormatLong(Long.valueOf(txtTienKhachDua.getText().trim()) - SellForm.this.totalMoney) + "VND");
                }
            } catch (NumberFormatException e) {
                lbTrangThaiTien.setText("Tiền thừa:");
                lbChange.setText("Vui lòng không sử dụng ký tự biệt");
            }
        } else {
            lbTrangThaiTien.setText("Tiền thừa:");
            lbChange.setText("0VND");
        }
    }

    private void setCustomer() {
        if (txtSoDienThoai.getText().trim().length() > 9 && txtSoDienThoai.getText().trim().length() < 11) {
            KhachHang kh = this.billService.searchKhachHang(txtSoDienThoai.getText());
            if (kh != null) {
                txtTenKhachHang.setText(kh.getHo_ten());
            }
        } else {
            txtTenKhachHang.setText("");
        }
    }

    private void change() {
        txtTienKhachDua.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setChange();
            }
        });
        txtSoDienThoai.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setCustomer();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setCustomer();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setCustomer();
            }
        });
    }

    private void fillCombo() {
        List<String> model = new ArrayList<>();
        model.add("Tiền mặt");
        model.add("Chuyển khoản");
        model.add("Quẹt thẻ");
        model.forEach(item -> {
            cbbTypePay.addItem(item);
        });

    }

    private void setIconButton() {
        btnThanhToan.setColor1(Color.BLACK);
        btnThanhToan.setColor2(Color.BLACK);
        btnThanhToan.setIconButton(this.icon.PAYMENT);
        btnTaoHoaDon.setColor1(Color.BLACK);
        btnTaoHoaDon.setColor2(Color.BLACK);
        btnTaoHoaDon.setIconButton(this.icon.CREATE);
        btnHuy.setColor1(Color.BLACK);
        btnHuy.setColor2(Color.BLACK);
        btnHuy.setIconButton(this.icon.CANCEL);
    }

    public void fillTableHoaDon() {
        this.tblModel = (DefaultTableModel) tblDanhSachHoaDon.getModel();
        tblModel.setRowCount(0);
        Integer[] count = {0};
        this.billService.getBillPending().forEach(bill -> {
            Object[] row = {
                ++count[0],
                bill.getId(),
                bill.getNhanVien().getFullName(),
                bill.getTrangThai()
            };
            tblDanhSachHoaDon.addRow(row);
        });
    }

    public void fillTableSanPham() {
        List<SanPham> sanPhamList = txtSearch.getText().isBlank() ? this.sanPhamService.getList() : this.sanPhamService.getListSearch(txtSearch.getText(), true);
        this.tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        sanPhamList.forEach(data -> {
            data.getBienTheList().forEach(sp -> {
                Object[] row
                        = {
                            sp.getId(),
                            data.getTen_san_pham() + " " + sp.getTenBienThe(),
                            sp.getSize().getLoaiSize(),
                            sp.getColor().getLoaiMau(),
                            sp.getChatLieu().getLoaiChatLieu(),
                            sp.getSoLuong(),
                            new FormartData().moneyFormatLong(sp.getGia()) + "VND",};
                tblModel.addRow(row);
            });
        });
    }

    public void fillTableSlectBill() {
        lbHoaDon.setText(String.valueOf(tblDanhSachHoaDon.getSelectedRow() + 1));
        this.tblModel = (DefaultTableModel) tblGioHang.getModel();
        tblModel.setRowCount(0);
        this.totalMoney = 0L;
        txtSoDienThoai.setEnabled(true);
        txtTenKhachHang.setEnabled(true);
        txtSoDienThoai.setText("");
        txtTenKhachHang.setText("");
        this.billService.getHoaDonChiTiet(String.valueOf(tblDanhSachHoaDon.getValueAt(tblDanhSachHoaDon.getSelectedRow(), 1))).forEach((JPAHoaDonChiTiet hd) -> {
            KhachHang kh = hd.getHoaDon().getKhachHang();
            if (kh != null) {
                txtSoDienThoai.setText(kh.getSo_dien_thoai());
                txtTenKhachHang.setText(kh.getHo_ten());
            }
            this.totalMoney = this.totalMoney + (hd.getSanPhamChiTiet().getGia() * hd.getSoLuong());
            Object[] row = {
                hd.getSanPhamChiTiet().getId(),
                hd.getSanPhamChiTiet().getId_san_pham().getTen_san_pham() + hd.getSanPhamChiTiet().getTenBienThe(),
                hd.getSanPhamChiTiet().getSize().getLoaiSize(),
                hd.getSanPhamChiTiet().getColor().getLoaiMau(),
                hd.getSanPhamChiTiet().getChatLieu().getLoaiChatLieu(),
                hd.getSoLuong(),
                new FormartData().moneyFormatLong(hd.getSanPhamChiTiet().getGia()) + "VND",
                new FormartData().moneyFormatLong(hd.getSanPhamChiTiet().getGia() * hd.getSoLuong()) + "VND",};
            tblGioHang.addRow(row);
        });
        lbTongTienHang.setText(new FormartData().moneyFormatLong(this.totalMoney) + "VND");
        setChange();
    }

    private void createHoaDon() {
        JPAHoaDon hd = new JPAHoaDon();
        hd.setNhanVien(this.nhanVien);
        hd.setTrangThai("Chờ thanh toán");
        hd.setNgayTao(new Date());
        if (this.billService.createBill(hd)) {
            new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã tạo mới một hóa đơn").showNotification();
            fillTableHoaDon();
            tblModel = (DefaultTableModel) tblGioHang.getModel();
            tblModel.setRowCount(0);
        }
    }

    private void cancelBill() {
        if (this.billService.cancellingBill(String.valueOf(tblDanhSachHoaDon.getValueAt(tblDanhSachHoaDon.getSelectedRow(), 1)))) {
            new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã hủy thành công một hóa đơn").showNotification();
            fillTableHoaDon();
            fillTableSanPham();
            lbHoaDon.setText("Chưa có hóa đơn được chọn");
            tblModel = (DefaultTableModel) tblGioHang.getModel();
            tblModel.setRowCount(0);
            txtSoDienThoai.setText("");
            txtTenKhachHang.setText("");
        }
    }

    private void pay() {
        try {
            if (txtTienKhachDua.getText().trim().isBlank()) {
                txtTienKhachDua.requestFocus();
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng nhập tiền khách đưa!").showNotification();
            } else if (Long.valueOf(txtTienKhachDua.getText().trim()) < this.totalMoney) {
                txtTienKhachDua.requestFocus();
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Tiền khách đưa không đủ!").showNotification();
            } else {
                String idHoaDon = String.valueOf(tblDanhSachHoaDon.getValueAt(tblDanhSachHoaDon.getSelectedRow(), 1));
                JPAHoaDon hd = this.billService.getJPAHoaDonById(idHoaDon);
                KhachHang kh = !txtSoDienThoai.getText().trim().isBlank() ? this.billService.searchKhachHang(txtSoDienThoai.getText().trim()) : null;
                if (kh == null && !txtSoDienThoai.getText().isBlank()) {
                    kh = new KhachHang();
                    if (!txtSoDienThoai.getText().matches("^0[0-9]{9,10}$") || txtTenKhachHang.getText().length() > 20) {
                        new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Số điện thoại hoặc tên khách hàng không hợp lệ!").showNotification();
                        return;
                    }
                    kh.setSo_dien_thoai(txtSoDienThoai.getText().trim());
                    kh.setHo_ten(txtTenKhachHang.getText().trim());
                    this.billService.createCustomer(kh);
                }
                hd.setTongGiaTriHoaDon(this.totalMoney);
                hd.setHinhThucThanhToan((String) cbbTypePay.getSelectedItem());
                hd.setTienDua(Long.valueOf(txtTienKhachDua.getText().trim()));
                hd.setTienThua(this.tienThua);
                hd.setKhachHang(kh);
                if (this.billService.payBill(hd)) {
                    fillTableHoaDon();
                    clear();
                    new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Thanh toán thành công").showNotification();
                }
            }
        } catch (NumberFormatException e) {
            txtTienKhachDua.requestFocus();
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng nhập đúng định dạng giá tiền!").showNotification();
        }

    }

    private void clear() {
        lbHoaDon.setText("Chưa có hóa đơn được chọn");
        tblModel = (DefaultTableModel) tblGioHang.getModel();
        tblModel.setRowCount(0);
        this.totalMoney = 0L;
        txtSoDienThoai.setEnabled(false);
        txtTenKhachHang.setEnabled(false);
        txtSoDienThoai.setText("");
        txtTenKhachHang.setText("");
        lbTongTienHang.setText("0VND");
        lbChange.setText("0VND");
        txtTienKhachDua.setText("");
        txtTienKhachDua.setEditable(false);
    }

    private void unlockClear() {
        txtSoDienThoai.setEnabled(true);
        txtTenKhachHang.setEnabled(true);
        txtTienKhachDua.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblDanhSachHoaDon = new haladesign.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblGioHang = new haladesign.swing.table.Table();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSoDienThoai = new haladesign.swingStyle.TextField();
        txtTenKhachHang = new haladesign.swingStyle.TextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        lbTongTienHang = new javax.swing.JLabel();
        cbbTypePay = new haladesign.swingStyle.Combobox();
        txtTienKhachDua = new haladesign.swingStyle.TextField();
        lbTrangThaiTien = new javax.swing.JLabel();
        lbChange = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnThanhToan = new haladesign.swingStyle.Button();
        btnTaoHoaDon = new haladesign.swingStyle.Button();
        btnHuy = new haladesign.swingStyle.Button();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new haladesign.swingStyle.TextField();
        jScrollPane3 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblSanPham = new haladesign.swing.table.Table();
        lbHoaDon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblDanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Tên Nhân Viên", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachHoaDon);
        if (tblDanhSachHoaDon.getColumnModel().getColumnCount() > 0) {
            tblDanhSachHoaDon.getColumnModel().getColumn(0).setMinWidth(50);
            tblDanhSachHoaDon.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bán Hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Danh sách hóa đơn");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Giỏ hàng hóa đơn:");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Size", "Color", "Chất liệu", "Số lượng", "Giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tạo Hóa Đơn");

        txtSoDienThoai.setEnabled(false);
        txtSoDienThoai.setLabelText("Số điện thoại khách hàng");

        txtTenKhachHang.setEnabled(false);
        txtTenKhachHang.setLabelText("Tên khách hàng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tổng tiền hàng:");

        lbTongTienHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTongTienHang.setText("0 VND");

        cbbTypePay.setLabeText("Hình thức thanh toán");

        txtTienKhachDua.setLabelText("Tiền khách đưa");

        lbTrangThaiTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTrangThaiTien.setText("Tiền thừa:");

        lbChange.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbChange.setText("0 VND");

        btnThanhToan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHoaDonMouseClicked(evt);
            }
        });

        btnHuy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnHuy.setText("Hủy");
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbTrangThaiTien)
                                .addGap(10, 10, 10)
                                .addComponent(lbChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(lbTongTienHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbbTypePay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnTaoHoaDon});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbTongTienHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(cbbTypePay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrangThaiTien)
                    .addComponent(lbChange))
                .addGap(40, 40, 40)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Danh sách sản phẩm");

        txtSearch.setLabelText("Tìm kiếm sản phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Size", "Color", "Chất liệu", "Số lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane3.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(70);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(70);
            tblSanPham.getColumnModel().getColumn(1).setMinWidth(250);
            tblSanPham.getColumnModel().getColumn(1).setMaxWidth(500);
        }

        lbHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHoaDon.setText("Chưa có hóa đơn được chọn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(103, 103, 103))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane2)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbHoaDon))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachHoaDonMouseClicked
        this.totalMoney = 0L;
        txtTienKhachDua.setText("");
        lbTrangThaiTien.setText("Tiền thừa:");
        fillTableSlectBill();
        unlockClear();
    }//GEN-LAST:event_tblDanhSachHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (tblDanhSachHoaDon.getSelectedRow() < 0) {
            new Notification(this.main, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Chưa có hóa đơn nào được chọn!").showNotification();
            return;
        }
        if (this.totalMoney < 500) {
            new Notification(this.main, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Hóa đơn phải có ít nhất một sản phẩm!").showNotification();
            return;
        }
        pay();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHoaDonMouseClicked
        if (tblDanhSachHoaDon.getRowCount() >= 5) {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thanh toán các hóa đơn còn lại và thử lại!").showNotification();
        } else {
            Message ms = new Message();
            ms.setTitle("Xác minh");
            ms.setMessage("Bạn có muốn tiếp tục tạo hóa đơn không?");
            ms.eventOK(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createHoaDon();
                    clear();
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(ms);
        }
    }//GEN-LAST:event_btnTaoHoaDonMouseClicked

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        if (tblDanhSachHoaDon.getSelectedRow() < 0) {
            new Notification(this.main, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Chưa có hóa đơn nào được chọn!").showNotification();
        } else {
            Message ms = new Message();
            ms.setTitle("Xác minh");
            ms.setMessage("Bạn có muốn hủy hóa đơn này không?");
            ms.eventOK(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelBill();
                    if (tblDanhSachHoaDon.getSelectedRow() < 0) {
                        txtSoDienThoai.setEnabled(false);
                        txtTenKhachHang.setEnabled(false);
                    }
                    clear();
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(ms);
        }
    }//GEN-LAST:event_btnHuyMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        if (tblDanhSachHoaDon.getSelectedRow() < 0) {
            new Notification(this.main, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Chưa có hóa đơn nào được chọn!").showNotification();
            return;
        }
        String idHoaDon = String.valueOf(tblDanhSachHoaDon.getValueAt(tblDanhSachHoaDon.getSelectedRow(), 1));
        String soHoaDon = String.valueOf(tblDanhSachHoaDon.getSelectedRow() + 1);
        String idSanPham = String.valueOf(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0));
        AddToCart addToCard = new AddToCart(this.main, this, idHoaDon, soHoaDon, idSanPham);
        GlassPanePopup.showPopup(addToCard);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        if (tblDanhSachHoaDon.getSelectedRow() < 0) {
            new Notification(this.main, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Chưa có hóa đơn nào được chọn!").showNotification();
            return;
        }
        String idHoaDon = String.valueOf(tblDanhSachHoaDon.getValueAt(tblDanhSachHoaDon.getSelectedRow(), 1));
        String soHoaDon = String.valueOf(tblDanhSachHoaDon.getSelectedRow() + 1);
        String idSanPham = String.valueOf(tblGioHang.getValueAt(tblGioHang.getSelectedRow(), 0));
        String soLuongHienTai = String.valueOf(tblGioHang.getValueAt(tblGioHang.getSelectedRow(), 5));
        UpdateCart cart = new UpdateCart(this.main, this, idHoaDon, soHoaDon, idSanPham, soLuongHienTai);
        GlassPanePopup.showPopup(cart);
    }//GEN-LAST:event_tblGioHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnHuy;
    private haladesign.swingStyle.Button btnTaoHoaDon;
    private haladesign.swingStyle.Button btnThanhToan;
    private haladesign.swingStyle.Combobox cbbTypePay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbChange;
    private javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbTongTienHang;
    private javax.swing.JLabel lbTrangThaiTien;
    private haladesign.swing.table.Table tblDanhSachHoaDon;
    private haladesign.swing.table.Table tblGioHang;
    private haladesign.swing.table.Table tblSanPham;
    private haladesign.swingStyle.TextField txtSearch;
    private haladesign.swingStyle.TextField txtSoDienThoai;
    private haladesign.swingStyle.TextField txtTenKhachHang;
    private haladesign.swingStyle.TextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
