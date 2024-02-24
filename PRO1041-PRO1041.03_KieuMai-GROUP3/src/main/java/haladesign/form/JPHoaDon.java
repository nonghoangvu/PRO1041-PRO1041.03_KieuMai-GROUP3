package haladesign.form;

import haladesign.Utitlity.FormartData;
import haladesign.mainMenu.Main;
import haladesign.model.HoaDonManh;
import haladesign.model.KeyValuePair_Manh;
import haladesign.service.HoaDonService_manh;
import haladesign.swing.table.TableActionCellEditor3;
import haladesign.swing.table.TableActionCellRender3;
import haladesign.swing.table.TableActionEvent1;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JPHoaDon extends javax.swing.JPanel {

    private final Main main;

    public JPHoaDon(Main main) {
        initComponents();
        init();
        this.main = main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_xuatFile1 = new haladesign.swingStyle.Button();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tbl_dshd = new haladesign.swing.table.Table();
        jPanel6 = new javax.swing.JPanel();
        txt_searchHD = new haladesign.swingStyle.TextField();
        cbb_ngayTao = new com.toedter.calendar.JDateChooser();
        cbotrangthai = new javax.swing.JComboBox<>();
        cbo_nvPhuTrach = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Lịch sử hóa đơn");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        btn_xuatFile1.setBackground(new java.awt.Color(102, 255, 255));
        btn_xuatFile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/haladesign/icon/excel.png"))); // NOI18N
        btn_xuatFile1.setText("Xuất file");
        btn_xuatFile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatFile1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_xuatFile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_xuatFile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbl_dshd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Tên Nhân Viên", "Ngày tạo hóa đơn", "Tên khách hàng", "Trạng thái hóa đơn", "Hình Thức Thanh Toán", "Khách phải trả", "Thao tác"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_dshd);
        if (tbl_dshd.getColumnModel().getColumnCount() > 0) {
            tbl_dshd.getColumnModel().getColumn(6).setResizable(false);
            tbl_dshd.getColumnModel().getColumn(8).setMinWidth(90);
            tbl_dshd.getColumnModel().getColumn(8).setMaxWidth(300);
        }

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Bộ lọc"));

        txt_searchHD.setLabelText("Tìm kiếm theo mã hóa đơn, tên khách hàng, SĐT khách hàng...");
        txt_searchHD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_searchHDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_searchHDFocusLost(evt);
            }
        });
        txt_searchHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchHDKeyReleased(evt);
            }
        });

        cbb_ngayTao.setBackground(new java.awt.Color(255, 255, 255));
        cbb_ngayTao.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày tạo"));
        cbb_ngayTao.setDateFormatString("dd/MM/yyyy");
        cbb_ngayTao.setMaxSelectableDate(new Date());
        cbb_ngayTao.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbb_ngayTaoPropertyChange(evt);
            }
        });

        cbotrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã thanh toán", "Hủy" }));
        cbotrangthai.setBorder(javax.swing.BorderFactory.createTitledBorder("Trạng thái hóa đơn"));
        cbotrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotrangthaiActionPerformed(evt);
            }
        });

        cbo_nvPhuTrach.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân viên phụ trách"));
        cbo_nvPhuTrach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_nvPhuTrachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(txt_searchHD, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbb_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbotrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbo_nvPhuTrach, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbb_ngayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbotrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_nvPhuTrach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_searchHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cbotrangthai.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchHDKeyReleased
        String searchString = txt_searchHD.getText();
        model_DSHD = (DefaultTableModel) this.tbl_dshd.getModel();
        search(searchString, model_DSHD, this.tbl_dshd);
    }//GEN-LAST:event_txt_searchHDKeyReleased

    private void txt_searchHDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchHDFocusGained
        //Sự kiện xảy ra khi thành phần txt_timKiemSP UI nhận đc trạng thái focus.
        if (txt_searchHD.getText().equals("Tìm kiếm theo mã hóa đơn, tên khách hàng, SĐT khách hàng...")) {
            txt_searchHD.setText(null);
            txt_searchHD.requestFocus(); //Yêu cầu tập trung Focus vào 1 component nào đó.
            //remove placeholder style
            removePlaceholderStyle(txt_searchHD);
        }
    }//GEN-LAST:event_txt_searchHDFocusGained

    private void txt_searchHDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchHDFocusLost
    }//GEN-LAST:event_txt_searchHDFocusLost

    private void cbotrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotrangthaiActionPerformed
        String status = (String) cbotrangthai.getSelectedItem();
        List<HoaDonManh> listHD = (status.equals("Tất cả")) ? hds.getInvoiceList() : hds.getInvoiceListByStatus(status);
        fill_listHoaDon_toTable(listHD);
    }//GEN-LAST:event_cbotrangthaiActionPerformed

    private void cbo_nvPhuTrachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_nvPhuTrachActionPerformed
        KeyValuePair_Manh selectedEmployee = (KeyValuePair_Manh) cbo_nvPhuTrach.getSelectedItem();// Lấy đối tượng được chọn từ combobox
        int selectedKey = selectedEmployee.getKey();//Lấy key tương ứng vs value đc chọn
        List<HoaDonManh> listHD = hds.getInvoicesByEmployeeID(selectedKey);
        if (listHD != null && !listHD.isEmpty()) {
            fill_listHoaDon_toTable(listHD);
        }
    }//GEN-LAST:event_cbo_nvPhuTrachActionPerformed

    private void cbb_ngayTaoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbb_ngayTaoPropertyChange
        if (cbb_ngayTao.getDate() != null) {
            String dateStr = cbb_ngayTao.getDate().toString();//Feb 20 02:22:58 ICT 2024
            try {
                List<HoaDonManh> listHD = hds.getInvoiceListByCreationDate(dateStr);
                fill_listHoaDon_toTable(listHD);
            } catch (ParseException ex) {
                Logger.getLogger(JPHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cbb_ngayTaoPropertyChange

    private void btn_xuatFile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatFile1ActionPerformed
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("HoaDon");
            XSSFRow row = null;//Dòng
            Cell cell = null;//
            row = sheet.createRow(2);//Tạo ra 2 dòng trống.
            //Cột 0
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SACH HOA DON");
            //Cột 1
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");//Dòng 3 cột 0
            //Cột 2
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã hóa đơn");//Dòng 3 cột 1

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã nhân viên");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ngày tạo");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tên khách hàng");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Trạng thái");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Hình thức thanh toán");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Tổng giá trị hóa đơn");

            List<HoaDonManh> listExport = hds.getListInvoiceToExport();
            for (int i = 0; i < listExport.size(); i++) {

                row = sheet.createRow(4 + i);//Từ dòng thứ 4 ( 3 + 1 tiêu đề ). Nạp từ đâu

                cell = row.createCell(0, CellType.NUMERIC);//Cột 0
                cell.setCellValue(i + 1);//dòng thứ 1 

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(listExport.get(i).getId_hoa_don());

                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue(listExport.get(i).getId_nhan_vien());

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(dateFormat.format(listExport.get(i).getNgay_tao_hoa_don()));

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(listExport.get(i).getTenKhachHang());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(listExport.get(i).getTrang_thai_hoa_don());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(listExport.get(i).getHinh_thuc_thanh_toan());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(listExport.get(i).getTong_gia_tri_hoa_don());

            }
//            File f = new File("C:\\Users\\ASUS\\Desktop\\duan1//HoaDon2.xlsx");
            File f = new File("D:\\FPT_Leaning\\FPT_Semester_5_Block1\\DA1_lan2\\NHV\\nongHoangVu/HoaDon1.xlsx");
            try {
                try (FileOutputStream fis = new FileOutputStream(f)) {
                    wordkbook.write(fis);
                }
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
            JOptionPane.showMessageDialog(this, "Xuất File thành công");
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Loi mo file");
        }
    }//GEN-LAST:event_btn_xuatFile1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btn_xuatFile1;
    private com.toedter.calendar.JDateChooser cbb_ngayTao;
    private javax.swing.JComboBox<String> cbo_nvPhuTrach;
    private javax.swing.JComboBox<String> cbotrangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private haladesign.swing.table.Table tbl_dshd;
    private haladesign.swingStyle.TextField txt_searchHD;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel model_DSHD;//Lấy model để tương tác vs db bảng.
    private DefaultComboBoxModel dcb_NVPT;//Model của nv phụ trách
    private HoaDonService_manh hds = new HoaDonService_manh();//Để thông qua đó truy vấn bên sql lấy ra dữ liệu.

    final void init() { //Thiết lập Fill DB lên các componenet
        fill_listNV_toCbb();//Đẩy những nv có tạo HD lên cbb
        List<HoaDonManh> listHD = hds.getInvoiceList();
        fill_listHoaDon_toTable(listHD);
        //Thiết lập JDateChooser nhỏ nhất có thể chọn.
        Calendar cal = Calendar.getInstance();// Lấy đối tượng Calendar hiện tại
        cal.add(Calendar.YEAR, -1);// Trừ đi một năm từ Calendar
        Date lastYear = cal.getTime();// Chuyển đổi Calendar thành Date
        cbb_ngayTao.setMinSelectableDate(lastYear);// Thiết lập ngày chọn nhỏ nhất cho JDateChooser
    }

    private void fill_listHoaDon_toTable(List<HoaDonManh> listHD) {//Fill lên bảng dựa vào d/s truyền vào.
        model_DSHD = (DefaultTableModel) this.tbl_dshd.getModel();
        model_DSHD.setRowCount(0);//xóa bảng
        int i = 1;
        for (HoaDonManh hd : listHD) {
            Object[] data = new Object[]{
                i++,
                hd.getId_hoa_don(),
                hd.getTenNhanVien(),
                new SimpleDateFormat("dd/MM/yyyy").format(hd.getNgay_tao_hoa_don()),
                hd.getTenKhachHang(),
                hd.getTrang_thai_hoa_don(),
                hd.getHinh_thuc_thanh_toan(),
                new FormartData().moneyFormat(Integer.valueOf(String.format("%.0f", hd.getTong_gia_tri_hoa_don()))) + "VND"
            };
            model_DSHD.addRow(data);
            TableActionEvent1 event = new TableActionEvent1() {
                @Override
                public void edit(int id) {//id ở đây là dòng chọn (0)
                    //Update hóa đơn chi tiết.
                }

                @Override
                public void detail(int id) {
                    String selectedProductId = String.valueOf(tbl_dshd.getValueAt(id, 1));
                    HoaDonChiTiet hdct = new HoaDonChiTiet(main, selectedProductId);
                    main.showForm(hdct);
                }
            };
            tbl_dshd.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender3());
            tbl_dshd.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor3(event));
        }
    }

    public void fill_listNV_toCbb() {
        dcb_NVPT = (DefaultComboBoxModel) this.cbo_nvPhuTrach.getModel();
        dcb_NVPT.removeAllElements();
        List<HoaDonManh> listEmployee = hds.getListEmployee();
        for (HoaDonManh hd : listEmployee) {//Duyệt qua listEmployee và thêm từng cặp key:value vào Combobox.
            dcb_NVPT.addElement(new KeyValuePair_Manh(hd.getId_nhan_vien(), hd.getTenNhanVien()));
        }
    }

    public void search(String str, DefaultTableModel dtmTable, JTable table) {
        dtmTable = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtmTable); //Tạo 1 TablerowSorter và liên kết với bảng DTM. TableRowSoft : Quản lý việc sắp xếp và lọc các hàng trong JTable.
        table.setRowSorter(trs); //Gán TableRowSorter vừa tạo cho JTable. -> Kích hoạt việc sắp xếp và lọc cho JTable. 
        //Sử dụng biểu thức chính quy để không phân biệt chữ hoa chữ thường
        Pattern pattern = Pattern.compile(Pattern.quote(str), Pattern.CASE_INSENSITIVE);
//        trs.setRowFilter(RowFilter.regexFilter(str));//Đặc bộ lọc cho TableRowSorter để thực hiện tìm kiếm dựa trên biểu thức chính quy ( Regex ). Nó sẽ tạo 1 bộ lọc dựa trên chuỗi str.
        trs.setRowFilter(new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Duyệt qua từng cột trong hàng
                for (int i = entry.getValueCount() - 1; i >= 0; i--) {
                    Object value = entry.getValue(i);
                    if (value != null) {
                        // Kiểm tra nếu giá trị của cột chứa ký tự tìm kiếm
                        Matcher matcher = pattern.matcher(value.toString());
                        if (matcher.find()) {
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

    //Mục đích : Loại bỏ hiệu ứng "Chữ gợi ý" khỏi JTextField.
    public void removePlaceholderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN);
        textField.setFont(font);
        textField.setForeground(Color.BLACK);
    }

    //Mục đích : Thêm hiệu ứng "Chữ gợi ý" cho JTextField = cách thay đổi font = kiểu in nghiêng + màu chữ 
    public void addPlaceholderStyle(JTextField textField) {
        Font font = textField.getFont();//Lấy font hiện tại của JTextField
        font = font.deriveFont(Font.ITALIC);//Tạo 1 bản sao mới của Font với kiểu in nghiêng ( Italic )
        textField.setFont(font); //Đặt font mới cho JTextField
        textField.setForeground(Color.GRAY); //Đặt màu chữ là Gray ( Xám ) 
    }

}
