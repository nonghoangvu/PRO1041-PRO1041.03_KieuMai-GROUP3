package haladesign.form;

import haladesign.Utitlity.FormartData;
import haladesign.mainMenu.Main;
import haladesign.model.HoaDonManh;
import haladesign.service.HoaDonService_manh;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import utility.MsgBox;

public class HoaDonChiTiet extends javax.swing.JPanel {

    private final Main main;
    private final String idInvoice;
    private HoaDonService_manh hds = new HoaDonService_manh();//Để thông qua đó truy vấn bên sql lấy ra dữ liệu.
    private DefaultTableModel model_dssp;//Lấy model để tương tác vs db bảng dssp.

    public HoaDonChiTiet(Main main, String idHDCT) {
        initComponents();
        setOpaque(false);
        this.main = main;
        this.idInvoice = idHDCT;//Lấy IDProduct 
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        lbl_ThongTinHoaDon = new javax.swing.JLabel();
        panel_tthd = new javax.swing.JPanel();
        in4_hd = new javax.swing.JPanel();
        maHD = new javax.swing.JPanel();
        txt_maKH1 = new javax.swing.JTextField();
        btn_maHD = new haladesign.swingStyle.Button();
        loaiHD = new javax.swing.JPanel();
        txt_maKH = new javax.swing.JTextField();
        btn_loaiHoaDon = new haladesign.swingStyle.Button();
        HTTT = new javax.swing.JPanel();
        txt_maKH2 = new javax.swing.JTextField();
        btn_httt = new haladesign.swingStyle.Button();
        TTHD = new javax.swing.JPanel();
        txt_maKH3 = new javax.swing.JTextField();
        btn_trangThai = new haladesign.swingStyle.Button();
        in4_user = new javax.swing.JPanel();
        maHD1 = new javax.swing.JPanel();
        txt_maKH4 = new javax.swing.JTextField();
        btn_tenNguoiMua = new haladesign.swingStyle.Button();
        loaiHD1 = new javax.swing.JPanel();
        txt_maKH5 = new javax.swing.JTextField();
        btn_soDienThoai = new haladesign.swingStyle.Button();
        HTTT1 = new javax.swing.JPanel();
        txt_maKH6 = new javax.swing.JTextField();
        btn_nvTaoDon = new haladesign.swingStyle.Button();
        TTHD1 = new javax.swing.JPanel();
        txt_maKH7 = new javax.swing.JTextField();
        btn_ngayTao = new haladesign.swingStyle.Button();
        btn_arrow = new haladesign.swingStyle.Button();
        footer = new javax.swing.JPanel();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tbl_dssp = new haladesign.swing.table.Table();
        aside = new javax.swing.JPanel();
        pn_thongTinHoaDon1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_tongSoLuong = new javax.swing.JTextField();
        txt_giamGia = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_tienKhachCK = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_maGiaoDich = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_tongTienHang = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_khachCanTra = new javax.swing.JTextField();
        txt_tienThua = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(255, 255, 255));

        lbl_ThongTinHoaDon.setText("THÔNG TIN HÓA ĐƠN");

        panel_tthd.setBackground(new java.awt.Color(255, 255, 255));

        in4_hd.setBackground(new java.awt.Color(255, 255, 255));
        in4_hd.setLayout(new java.awt.GridLayout(4, 1, 0, 20));

        maHD.setBackground(new java.awt.Color(255, 255, 255));

        txt_maKH1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_maKH1.setText("Mã Hóa Đơn");
        txt_maKH1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maKH1.setDoubleBuffered(true);
        txt_maKH1.setEnabled(false);
        txt_maKH1.setMaximumSize(new java.awt.Dimension(75, 25));
        txt_maKH1.setOpaque(true);
        txt_maKH1.setPreferredSize(new java.awt.Dimension(75, 25));

        btn_maHD.setBackground(new java.awt.Color(204, 204, 204));
        btn_maHD.setEnabled(false);
        btn_maHD.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_maHD.setPreferredSize(new java.awt.Dimension(233, 26));

        javax.swing.GroupLayout maHDLayout = new javax.swing.GroupLayout(maHD);
        maHD.setLayout(maHDLayout);
        maHDLayout.setHorizontalGroup(
            maHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maHDLayout.createSequentialGroup()
                .addComponent(txt_maKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_maHD, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );
        maHDLayout.setVerticalGroup(
            maHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_maKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        in4_hd.add(maHD);

        loaiHD.setBackground(new java.awt.Color(255, 255, 255));

        txt_maKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_maKH.setText("Loại Hóa Đơn");
        txt_maKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maKH.setDoubleBuffered(true);
        txt_maKH.setEnabled(false);
        txt_maKH.setMaximumSize(new java.awt.Dimension(75, 25));
        txt_maKH.setOpaque(true);
        txt_maKH.setPreferredSize(new java.awt.Dimension(75, 25));

        btn_loaiHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        btn_loaiHoaDon.setEffectColor(new java.awt.Color(0, 0, 0));
        btn_loaiHoaDon.setEnabled(false);
        btn_loaiHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_loaiHoaDon.setPreferredSize(new java.awt.Dimension(233, 26));

        javax.swing.GroupLayout loaiHDLayout = new javax.swing.GroupLayout(loaiHD);
        loaiHD.setLayout(loaiHDLayout);
        loaiHDLayout.setHorizontalGroup(
            loaiHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loaiHDLayout.createSequentialGroup()
                .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_loaiHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );
        loaiHDLayout.setVerticalGroup(
            loaiHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loaiHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_loaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        in4_hd.add(loaiHD);

        HTTT.setBackground(new java.awt.Color(255, 255, 255));

        txt_maKH2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_maKH2.setText("HTTT");
        txt_maKH2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maKH2.setDoubleBuffered(true);
        txt_maKH2.setEnabled(false);
        txt_maKH2.setMaximumSize(new java.awt.Dimension(75, 25));
        txt_maKH2.setOpaque(true);
        txt_maKH2.setPreferredSize(new java.awt.Dimension(75, 25));

        btn_httt.setBackground(new java.awt.Color(204, 204, 204));
        btn_httt.setEffectColor(new java.awt.Color(0, 0, 0));
        btn_httt.setEnabled(false);
        btn_httt.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_httt.setPreferredSize(new java.awt.Dimension(233, 26));

        javax.swing.GroupLayout HTTTLayout = new javax.swing.GroupLayout(HTTT);
        HTTT.setLayout(HTTTLayout);
        HTTTLayout.setHorizontalGroup(
            HTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HTTTLayout.createSequentialGroup()
                .addComponent(txt_maKH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_httt, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );
        HTTTLayout.setVerticalGroup(
            HTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_maKH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_httt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        in4_hd.add(HTTT);

        TTHD.setBackground(new java.awt.Color(255, 255, 255));

        txt_maKH3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_maKH3.setText("Trạng Thái");
        txt_maKH3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maKH3.setDoubleBuffered(true);
        txt_maKH3.setEnabled(false);
        txt_maKH3.setMaximumSize(new java.awt.Dimension(75, 25));
        txt_maKH3.setOpaque(true);
        txt_maKH3.setPreferredSize(new java.awt.Dimension(75, 25));

        btn_trangThai.setBackground(new java.awt.Color(204, 204, 204));
        btn_trangThai.setEffectColor(new java.awt.Color(0, 0, 0));
        btn_trangThai.setEnabled(false);
        btn_trangThai.setHideActionText(true);
        btn_trangThai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_trangThai.setPreferredSize(new java.awt.Dimension(233, 26));

        javax.swing.GroupLayout TTHDLayout = new javax.swing.GroupLayout(TTHD);
        TTHD.setLayout(TTHDLayout);
        TTHDLayout.setHorizontalGroup(
            TTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TTHDLayout.createSequentialGroup()
                .addComponent(txt_maKH3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_trangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );
        TTHDLayout.setVerticalGroup(
            TTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_maKH3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        in4_hd.add(TTHD);

        in4_user.setBackground(new java.awt.Color(255, 255, 255));
        in4_user.setLayout(new java.awt.GridLayout(4, 1, 0, 20));

        maHD1.setBackground(new java.awt.Color(255, 255, 255));

        txt_maKH4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_maKH4.setText("Tên Người Mua");
        txt_maKH4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maKH4.setDoubleBuffered(true);
        txt_maKH4.setEnabled(false);
        txt_maKH4.setMaximumSize(new java.awt.Dimension(75, 25));
        txt_maKH4.setOpaque(true);
        txt_maKH4.setPreferredSize(new java.awt.Dimension(75, 25));

        btn_tenNguoiMua.setBackground(new java.awt.Color(204, 204, 204));
        btn_tenNguoiMua.setEffectColor(new java.awt.Color(0, 0, 0));
        btn_tenNguoiMua.setEnabled(false);
        btn_tenNguoiMua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_tenNguoiMua.setPreferredSize(new java.awt.Dimension(233, 26));

        javax.swing.GroupLayout maHD1Layout = new javax.swing.GroupLayout(maHD1);
        maHD1.setLayout(maHD1Layout);
        maHD1Layout.setHorizontalGroup(
            maHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maHD1Layout.createSequentialGroup()
                .addComponent(txt_maKH4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tenNguoiMua, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        maHD1Layout.setVerticalGroup(
            maHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_maKH4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_tenNguoiMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        in4_user.add(maHD1);

        loaiHD1.setBackground(new java.awt.Color(255, 255, 255));

        txt_maKH5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_maKH5.setText("Số Điện Thoại");
        txt_maKH5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maKH5.setDoubleBuffered(true);
        txt_maKH5.setEnabled(false);
        txt_maKH5.setMaximumSize(new java.awt.Dimension(75, 25));
        txt_maKH5.setOpaque(true);
        txt_maKH5.setPreferredSize(new java.awt.Dimension(75, 25));

        btn_soDienThoai.setBackground(new java.awt.Color(204, 204, 204));
        btn_soDienThoai.setEffectColor(new java.awt.Color(0, 0, 0));
        btn_soDienThoai.setEnabled(false);
        btn_soDienThoai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_soDienThoai.setPreferredSize(new java.awt.Dimension(233, 26));

        javax.swing.GroupLayout loaiHD1Layout = new javax.swing.GroupLayout(loaiHD1);
        loaiHD1.setLayout(loaiHD1Layout);
        loaiHD1Layout.setHorizontalGroup(
            loaiHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loaiHD1Layout.createSequentialGroup()
                .addComponent(txt_maKH5, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        loaiHD1Layout.setVerticalGroup(
            loaiHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loaiHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_maKH5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        in4_user.add(loaiHD1);

        HTTT1.setBackground(new java.awt.Color(255, 255, 255));

        txt_maKH6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_maKH6.setText("NV tạo hóa đơn");
        txt_maKH6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maKH6.setDoubleBuffered(true);
        txt_maKH6.setEnabled(false);
        txt_maKH6.setMaximumSize(new java.awt.Dimension(75, 25));
        txt_maKH6.setOpaque(true);
        txt_maKH6.setPreferredSize(new java.awt.Dimension(75, 25));

        btn_nvTaoDon.setBackground(new java.awt.Color(204, 204, 204));
        btn_nvTaoDon.setEffectColor(new java.awt.Color(0, 0, 0));
        btn_nvTaoDon.setEnabled(false);
        btn_nvTaoDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_nvTaoDon.setPreferredSize(new java.awt.Dimension(233, 26));

        javax.swing.GroupLayout HTTT1Layout = new javax.swing.GroupLayout(HTTT1);
        HTTT1.setLayout(HTTT1Layout);
        HTTT1Layout.setHorizontalGroup(
            HTTT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HTTT1Layout.createSequentialGroup()
                .addComponent(txt_maKH6, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nvTaoDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HTTT1Layout.setVerticalGroup(
            HTTT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HTTT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_maKH6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_nvTaoDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        in4_user.add(HTTT1);

        TTHD1.setBackground(new java.awt.Color(255, 255, 255));

        txt_maKH7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_maKH7.setText("Ngày Tạo");
        txt_maKH7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maKH7.setDoubleBuffered(true);
        txt_maKH7.setEnabled(false);
        txt_maKH7.setMaximumSize(new java.awt.Dimension(75, 25));
        txt_maKH7.setOpaque(true);
        txt_maKH7.setPreferredSize(new java.awt.Dimension(75, 25));

        btn_ngayTao.setBackground(new java.awt.Color(204, 204, 204));
        btn_ngayTao.setEffectColor(new java.awt.Color(0, 0, 0));
        btn_ngayTao.setEnabled(false);
        btn_ngayTao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_ngayTao.setPreferredSize(new java.awt.Dimension(233, 26));

        javax.swing.GroupLayout TTHD1Layout = new javax.swing.GroupLayout(TTHD1);
        TTHD1.setLayout(TTHD1Layout);
        TTHD1Layout.setHorizontalGroup(
            TTHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TTHD1Layout.createSequentialGroup()
                .addComponent(txt_maKH7, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TTHD1Layout.setVerticalGroup(
            TTHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TTHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_maKH7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        in4_user.add(TTHD1);

        javax.swing.GroupLayout panel_tthdLayout = new javax.swing.GroupLayout(panel_tthd);
        panel_tthd.setLayout(panel_tthdLayout);
        panel_tthdLayout.setHorizontalGroup(
            panel_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tthdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(in4_hd, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(in4_user, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_tthdLayout.setVerticalGroup(
            panel_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tthdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(in4_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(in4_hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btn_arrow.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+("\\src\\main\\java\\haladesign\\icon\\"
            + "arrow.png")));
btn_arrow.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_arrowActionPerformed(evt);
    }
    });

    javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
    header.setLayout(headerLayout);
    headerLayout.setHorizontalGroup(
        headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(headerLayout.createSequentialGroup()
            .addComponent(panel_tthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
        .addGroup(headerLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btn_arrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_ThongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(487, 487, 487))
    );
    headerLayout.setVerticalGroup(
        headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(headerLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(btn_arrow, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_ThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panel_tthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    footer.setBackground(new java.awt.Color(255, 255, 255));
    footer.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm mua"));
    footer.setPreferredSize(new java.awt.Dimension(727, 199));

    tbl_dssp.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "STT", "Ảnh sản phẩm", "ID Sản Phẩm", "Tên Sản Phẩm", "Giá Bán", "Số Lượng", "Thành Tiền"
        }
    ));
    jScrollPane1.setViewportView(tbl_dssp);
    if (tbl_dssp.getColumnModel().getColumnCount() > 0) {
        tbl_dssp.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_dssp.getColumnModel().getColumn(3).setMinWidth(100);
    }

    javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
    footer.setLayout(footerLayout);
    footerLayout.setHorizontalGroup(
        footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 717, Short.MAX_VALUE)
        .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addContainerGap()))
    );
    footerLayout.setVerticalGroup(
        footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
        .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap()))
    );

    aside.setBackground(new java.awt.Color(255, 255, 255));

    pn_thongTinHoaDon1.setBackground(new java.awt.Color(255, 255, 255));
    pn_thongTinHoaDon1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin hóa đơn"));

    jLabel14.setText("Tổng số lượng");
    jLabel14.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_tongSoLuong.setBackground(new java.awt.Color(242, 242, 242));
    txt_tongSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_tongSoLuong.setForeground(new java.awt.Color(51, 51, 255));
    txt_tongSoLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_tongSoLuong.setDisabledTextColor(java.awt.Color.black);
    txt_tongSoLuong.setEnabled(false);
    txt_tongSoLuong.setPreferredSize(new java.awt.Dimension(160, 25));

    txt_giamGia.setBackground(new java.awt.Color(242, 242, 242));
    txt_giamGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_giamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_giamGia.setDisabledTextColor(java.awt.Color.black);
    txt_giamGia.setEnabled(false);
    txt_giamGia.setPreferredSize(new java.awt.Dimension(160, 25));

    jLabel21.setText("Giảm giá");
    jLabel21.setPreferredSize(new java.awt.Dimension(100, 20));

    jLabel23.setText("Tiền khách đưa");
    jLabel23.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_tienKhachDua.setBackground(new java.awt.Color(242, 242, 242));
    txt_tienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_tienKhachDua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_tienKhachDua.setDisabledTextColor(java.awt.Color.black);
    txt_tienKhachDua.setEnabled(false);
    txt_tienKhachDua.setPreferredSize(new java.awt.Dimension(160, 25));

    jLabel24.setText("Tiền khách CK");
    jLabel24.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_tienKhachCK.setBackground(new java.awt.Color(242, 242, 242));
    txt_tienKhachCK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_tienKhachCK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_tienKhachCK.setDisabledTextColor(java.awt.Color.black);
    txt_tienKhachCK.setEnabled(false);
    txt_tienKhachCK.setPreferredSize(new java.awt.Dimension(160, 25));

    jLabel25.setText("Mã giao dịch");
    jLabel25.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_maGiaoDich.setBackground(new java.awt.Color(242, 242, 242));
    txt_maGiaoDich.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_maGiaoDich.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_maGiaoDich.setDisabledTextColor(java.awt.Color.black);
    txt_maGiaoDich.setEnabled(false);
    txt_maGiaoDich.setPreferredSize(new java.awt.Dimension(160, 25));

    jLabel15.setText("Tổng tiền hàng");
    jLabel15.setPreferredSize(new java.awt.Dimension(100, 20));

    jLabel26.setText("Tiền thừa");
    jLabel26.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_tongTienHang.setBackground(new java.awt.Color(242, 242, 242));
    txt_tongTienHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_tongTienHang.setForeground(new java.awt.Color(51, 51, 255));
    txt_tongTienHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_tongTienHang.setDisabledTextColor(java.awt.Color.black);
    txt_tongTienHang.setEnabled(false);
    txt_tongTienHang.setPreferredSize(new java.awt.Dimension(160, 25));

    jLabel22.setText("Khách cần trả");
    jLabel22.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_khachCanTra.setBackground(new java.awt.Color(242, 242, 242));
    txt_khachCanTra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_khachCanTra.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_khachCanTra.setDisabledTextColor(java.awt.Color.black);
    txt_khachCanTra.setEnabled(false);
    txt_khachCanTra.setPreferredSize(new java.awt.Dimension(160, 25));

    txt_tienThua.setBackground(new java.awt.Color(242, 242, 242));
    txt_tienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_tienThua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_tienThua.setDisabledTextColor(java.awt.Color.black);
    txt_tienThua.setEnabled(false);
    txt_tienThua.setPreferredSize(new java.awt.Dimension(160, 25));

    jButton1.setBackground(new java.awt.Color(255, 102, 102));
    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/haladesign/icon/trash-can.png"))); // NOI18N
    jButton1.setText("Xóa hóa đơn");
    jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pn_thongTinHoaDon1Layout = new javax.swing.GroupLayout(pn_thongTinHoaDon1);
    pn_thongTinHoaDon1.setLayout(pn_thongTinHoaDon1Layout);
    pn_thongTinHoaDon1Layout.setHorizontalGroup(
        pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                    .addGap(322, 322, 322)
                    .addComponent(jLabel34))
                .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addComponent(jLabel35))
                .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                                    .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_giamGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_tongTienHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_tongSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_khachCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                                    .addGap(106, 106, 106)
                                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(6, 6, 6)))
                            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(jLabel37)))
                        .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tienKhachCK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_maGiaoDich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(6, 6, 6)))
                    .addGap(44, 44, 44)))
            .addContainerGap())
    );
    pn_thongTinHoaDon1Layout.setVerticalGroup(
        pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_tongSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_tongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_khachCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel37)
                .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                    .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_tienKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_maGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pn_thongTinHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pn_thongTinHoaDon1Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jLabel36)
                            .addGap(129, 129, 129)
                            .addComponent(jLabel34)))
                    .addGap(18, 18, 18)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(jLabel35)))
            .addContainerGap(26, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout asideLayout = new javax.swing.GroupLayout(aside);
    aside.setLayout(asideLayout);
    asideLayout.setHorizontalGroup(
        asideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(asideLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(pn_thongTinHoaDon1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addContainerGap())
    );
    asideLayout.setVerticalGroup(
        asideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(asideLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(pn_thongTinHoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(152, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(aside, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
        .addComponent(aside, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_arrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_arrowActionPerformed
        //Quay về trang trước.
        JPHoaDon uiHD = new JPHoaDon(main);//Gọi tới hàm tạo của SPCT vs truyền vào là main
        this.main.showForm(uiHD);
    }//GEN-LAST:event_btn_arrowActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        deleteInvoice(idInvoice);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HTTT;
    private javax.swing.JPanel HTTT1;
    private javax.swing.JPanel TTHD;
    private javax.swing.JPanel TTHD1;
    private javax.swing.JPanel aside;
    private haladesign.swingStyle.Button btn_arrow;
    private haladesign.swingStyle.Button btn_httt;
    private haladesign.swingStyle.Button btn_loaiHoaDon;
    private haladesign.swingStyle.Button btn_maHD;
    private haladesign.swingStyle.Button btn_ngayTao;
    private haladesign.swingStyle.Button btn_nvTaoDon;
    private haladesign.swingStyle.Button btn_soDienThoai;
    private haladesign.swingStyle.Button btn_tenNguoiMua;
    private haladesign.swingStyle.Button btn_trangThai;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JPanel in4_hd;
    private javax.swing.JPanel in4_user;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_ThongTinHoaDon;
    private javax.swing.JPanel loaiHD;
    private javax.swing.JPanel loaiHD1;
    private javax.swing.JPanel maHD;
    private javax.swing.JPanel maHD1;
    private javax.swing.JPanel panel_tthd;
    private javax.swing.JPanel pn_thongTinHoaDon1;
    private haladesign.swing.table.Table tbl_dssp;
    private javax.swing.JTextField txt_giamGia;
    private javax.swing.JTextField txt_khachCanTra;
    private javax.swing.JTextField txt_maGiaoDich;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_maKH1;
    private javax.swing.JTextField txt_maKH2;
    private javax.swing.JTextField txt_maKH3;
    private javax.swing.JTextField txt_maKH4;
    private javax.swing.JTextField txt_maKH5;
    private javax.swing.JTextField txt_maKH6;
    private javax.swing.JTextField txt_maKH7;
    private javax.swing.JTextField txt_tienKhachCK;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_tongSoLuong;
    private javax.swing.JTextField txt_tongTienHang;
    // End of variables declaration//GEN-END:variables

    private void init() {
        HoaDonManh FormHD = hds.getFormInvoice(idInvoice); // Lấy dữ liệu cho form
        setButtonValue(btn_maHD, String.valueOf(FormHD.getId_hoa_don()));
        setButtonValue(btn_loaiHoaDon, "Tại Quầy");
        setButtonValue(btn_httt, FormHD.getHinh_thuc_thanh_toan());
        setButtonValue(btn_trangThai, FormHD.getTrang_thai_hoa_don());
        setButtonValue(btn_tenNguoiMua, FormHD.getTenKhachHang());
        setButtonValue(btn_soDienThoai, FormHD.getSoDienThoaiKH());
        setButtonValue(btn_nvTaoDon, FormHD.getTenNhanVien());
        setButtonValue(btn_ngayTao, FormHD.getNgay_tao_hoa_don().toString());

        HoaDonManh hdIn4 = hds.getHoaDonIn4(idInvoice);
        fillIn4Invoice(txt_tongSoLuong, hdIn4.getTong_so_luong());

        fillIn4Invoice(txt_tongTienHang, hdIn4.getTongTienHang(), hdIn4.getHinh_thuc_thanh_toan());

        fillIn4Invoice(txt_giamGia, "0đ");

        fillIn4Invoice(txt_khachCanTra, txt_tongTienHang.getText());

        fillIn4Invoice(txt_tienKhachDua, hdIn4.getTien_dua(), hdIn4.getHinh_thuc_thanh_toan());

        fillIn4Invoice(txt_tienKhachCK, hdIn4.getTien_dua(), hdIn4.getHinh_thuc_thanh_toan());

        fillIn4Invoice(txt_maGiaoDich, hdIn4.getMa_giao_dich());

        fillIn4Invoice(txt_tienThua, hdIn4.getTien_thua());

        fill_Invoice_ProductList_ByIDInvoice(idInvoice);//Fill dữ liệu dssp lên bảng.
    }

    public void fillIn4Invoice(JTextField txt, Object value, String... hinhThucThanhToan) {
        if (value instanceof Float) {
//            txt.setText(String.format("%.0f", value));
//              new FormartData().moneyFormat(s.getGia()) + "VND"
            Float floatValue = (Float) value;// Ép kiểu value thành Float
            Integer integerValue = floatValue.intValue();// Chuyển đổi giá trị Float thành Integer
            txt.setText(String.valueOf(new FormartData().moneyFormat(integerValue) + "VND"));
            if (hinhThucThanhToan != null && hinhThucThanhToan.length > 0) {
                if ("Tiền mặt".equals(hinhThucThanhToan[0])) {
                    this.txt_tienKhachDua.setText(String.valueOf(new FormartData().moneyFormat(integerValue) + "VND"));
                    this.txt_tienKhachCK.setText("0đ");
                } else if ("Chuyển khoản".equals(hinhThucThanhToan[0]) || "Quẹt thẻ".equals(hinhThucThanhToan[0])) {
                    this.txt_tienKhachCK.setText(String.valueOf(new FormartData().moneyFormat(integerValue) + "VND"));
                    this.txt_tienKhachCK.setText("0đ");
                }
            }
        } else if (value != null) {
            txt.setText(String.valueOf(value));
        }
    }

    public void fill_Invoice_ProductList_ByIDInvoice(String idInvoice) {//Fill dssp trong hóa đơn dựa vào ID hóa đơn.
        List<HoaDonManh> listHD = hds.getTTSPInInvoice(idInvoice);
        model_dssp = (DefaultTableModel) this.tbl_dssp.getModel();
        model_dssp.setRowCount(0);//xóa bảng
        int i = 1;
        for (HoaDonManh hd : listHD) {
            Object[] data = new Object[]{
                i++,
                hd.getHinhAnh(),
                hd.getId_san_pham_chi_tiet(),//ID spct trog giỏ hàng
                hd.getTen_bien_the(),//Tên SP biến thể có trog giỏ hàng
                new FormartData().moneyFormat(Integer.valueOf(String.format("%.0f", hd.getGia()))) + "VND",//Giá gốc spbt
                hd.getSo_luong(),//SL spct trog hđct
                new FormartData().moneyFormat(Integer.valueOf(String.format("%.0f", hd.getTong_tien()))) + "VND",//= SL * giá gốc
            };
            model_dssp.addRow(data);
        }
    }

    public void deleteInvoice(String idInvoice) {
        //check quyền (Để sau)
        boolean StatusInvoiceHuy = btn_trangThai.getText().equals("Hủy");//TTHĐ Hủy --> True
        System.out.println("checkStatusInvoice " + StatusInvoiceHuy);
        boolean conf = MsgBox.confirm(this, "Bạn muốn xóa hóa đơn " + idInvoice);
        if (!StatusInvoiceHuy && conf) {
            System.out.println("Hóa đơn có thể xóa + đã conf");
        } else {
            String message = (!conf) ? "Hủy xóa hóa đơn" : "Hóa đơn đã được hủy";
            MsgBox.alter(this, message);
        }
    }

    // Phương thức để thiết lập giá trị cho một button (UI HĐCT)
    private void setButtonValue(JButton button, String value) {
        if (value != null) {
            button.setText(value);
        }
    }

}
