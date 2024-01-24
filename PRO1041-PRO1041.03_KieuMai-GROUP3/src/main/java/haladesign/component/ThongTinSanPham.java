package haladesign.component;

import haladesign.Utitlity.ValidateNumber;
import haladesign.api.JnaFileChooser;
import haladesign.form.ListProductForm;
import haladesign.mainMenu.Main;
import haladesign.model.Color;
import haladesign.model.SanPham;
import haladesign.model.SanPhamBienThe;
import haladesign.model.Size;
import haladesign.service.SanPhamService;
import haladesign.system.GlassPanePopup;
import haladesign.system.Message;
import haladesign.system.Notification;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NONG HOANG VU
 */
public class ThongTinSanPham extends javax.swing.JPanel {

    private final SanPhamService list;
    private final Main main;
    private DefaultTableModel tblModel;
    private List<SanPhamBienThe> bienTheList;
    private String url = null;
    private final String idProduct;

    public ThongTinSanPham(Main main, String id, Boolean activity) {
        initComponents();
        setOpaque(false);
        this.list = new SanPhamService();
        this.main = main;
        this.idProduct = id;
        this.bienTheList = this.list.getByIdSanPhamBienThe(id);
        init(id, activity);
    }

    private void init(String id, Boolean activity) {
        lbID.setText(id);
        txtTenBienThe.setText("");
        fillSize();
        fillColor();
        setForm(id);
        setTrangThai(activity);
        fillTable();
        updateNameProduct();

    }

    /*__________________________Fill Data__________________________*/
    private void fillTable() {
        tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        Integer[] count = {0};
        this.bienTheList.forEach((SanPhamBienThe s) -> {
            Object[] row = {
                ++count[0],
                s.getTenBienThe(),
                s.getSoLuong(),
                s.getColor().getLoaiMau(),
                s.getSize().getLoaiSize(),
                s.getGia()
            };
            tblModel.addRow(row);
        });
    }

    private void fillSize() {
        DefaultComboBoxModel<Size> cbbModel = new DefaultComboBoxModel<>();
        Size sizeNull = new Size();
        sizeNull.setLoaiSize("Chọn");
        cbbSize.removeAll();
        cbbSize.setModel(cbbModel);
        cbbModel.addElement(sizeNull);
        this.list.getSize().forEach(size -> {
            cbbModel.addElement(size);
        });
    }

    private void fillColor() {
        DefaultComboBoxModel<Color> cbbModel = new DefaultComboBoxModel<>();
        Color colorNull = new Color();
        colorNull.setLoaiMau("Chọn");
        cbbColor.removeAll();
        cbbColor.setModel(cbbModel);
        cbbModel.addElement(colorNull);
        this.list.getCOlor().forEach(color -> {
            cbbModel.addElement(color);
        });
    }

    /*__________________________Set Data__________________________*/
    private void setTrangThai(Boolean activity) {
        btnTrangThai.setSelected(activity);
    }

    private void setForm(String id) {
        SanPham sp = this.list.getByIdSanPham(id).get(0);
        txtSanPham.setText(sp.getTen_san_pham());
        txtMoTa.setText(sp.getMo_ta() != null ? sp.getMo_ta() : "");
    }

    private void clear() {
        txtSoLuong.setText("");
        cbbSize.setSelectedIndex(0);
        cbbColor.setSelectedIndex(0);
        txtTenBienThe.setText("");
        txtGia.setText("");
        setImange(null);
    }

    private void setImange(String url) {
        lbImage.setText(null);
        try {
            int labelWidth = lbImage.getWidth();
            int labelHeight = lbImage.getHeight();
            ImageIcon originalIcon = new javax.swing.ImageIcon(
                    Objects.requireNonNull(getClass().getResource("/haladesign/photo/" + url)));
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight,
                    Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            lbImage.setIcon(scaledIcon);
        } catch (Exception e) {
            lbImage.setIcon(null);
            lbImage.setText("Image not found");
        }
    }

    private void tableClickRow() {
        if (tblSanPham.getSelectedRow() < 0) {
            return;
        }
        SanPhamBienThe s = this.bienTheList.get(tblSanPham.getSelectedRow());
        txtTenBienThe.setText(s.getTenBienThe());
        txtSoLuong.setText(String.valueOf(s.getSoLuong()));
        txtGia.setText(String.valueOf(s.getGia()));
        cbbSize.setSelectedIndex(s.getSize().getId());
        cbbColor.setSelectedIndex(s.getColor().getId());
        setImange(s.getHinhAnh());
    }

    /*__________________________Get Data__________________________*/
    private SanPham getSanPham() {
        SanPham sp = new SanPham();
        sp.setId(lbID.getText());
        sp.setTen_san_pham(txtSanPham.getText());
        sp.setMo_ta(txtMoTa.getText());
        sp.setTrang_thai(btnTrangThai.isSelected());
        sp.setNgay_tao(new Date());
        return sp;
    }

    private SanPhamBienThe getSanPhamBienThe() {
        SanPhamBienThe sp = new SanPhamBienThe();
        sp.setId_san_pham(getSanPham());
        sp.setTenBienThe(txtTenBienThe.getText());
        sp.setSize(getSizeForm());
        sp.setColor(getColorForm());
        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sp.setGia(Integer.valueOf(txtGia.getText()));
        sp.setHinhAnh(this.url);
        return sp;
    }

    private Size getSizeForm() {
        Size size = (Size) cbbSize.getSelectedItem();
        return size;
    }

    private Color getColorForm() {
        Color color = (Color) cbbColor.getSelectedItem();
        return color;
    }

    /*__________________________Controller__________________________*/
    private void complete() {
        SanPham sp = this.bienTheList.get(0).getId_san_pham();
        sp.setTen_san_pham(txtSanPham.getText());
        sp.setTrang_thai(btnTrangThai.isSelected());
        sp.setMo_ta(txtMoTa.getText());
        if (this.list.insertSanPham(sp)) {
            new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Hoàn thành chỉnh sửa!").showNotification();
            this.main.showForm(new ListProductForm(this.main));
        } else {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thử lại!").showNotification();
        }
    }

    private void update() {
        SanPhamBienThe sp = this.bienTheList.get(tblSanPham.getSelectedRow());
        sp.setId(sp.getId());
        sp.setId_san_pham(getSanPham());
        sp.setTenBienThe(txtTenBienThe.getText());
        sp.setSize(getSizeForm());
        sp.setColor(getColorForm());
        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sp.setGia(Integer.valueOf(txtGia.getText()));
        sp.setHinhAnh(this.url);
        if (this.list.insertBienThe(sp)) {
            clear();
            new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Hoàn thành chỉnh sửa!").showNotification();
            this.bienTheList = this.list.getByIdSanPhamBienThe(this.idProduct);
            fillTable();
        } else {
            new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thử lại!").showNotification();
        }

    }

    private void add() {
        if (existsBienTheWithColorAndSize(this.bienTheList, getColorForm().getLoaiMau(), getSizeForm().getLoaiSize())) {
            Message message = new Message();
            message.setTitle("Cảnh báo");
            message.setMessage("Thuộc tính này đã tồn tại bạn có muốn bổ sung thêm số lượng và thay đổi thông tin không?");
            message.eventOK(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SanPhamBienThe sp = ThongTinSanPham.this.list.getByColorAndSize(ThongTinSanPham.this.idProduct, getColorForm(), getSizeForm()).get(0);
                    sp.setSoLuong(sp.getSoLuong() + Integer.valueOf(txtSoLuong.getText()));
                    sp.setTenBienThe(txtTenBienThe.getText());
                    sp.setGia(Integer.valueOf(txtGia.getText()));
                    if (ThongTinSanPham.this.list.insertBienThe(sp)) {
                        ThongTinSanPham.this.bienTheList = ThongTinSanPham.this.list.getByIdSanPhamBienThe(ThongTinSanPham.this.idProduct);
                        new Notification(ThongTinSanPham.this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Đã bổ sung số lượng và thông tin sản phẩm!").showNotification();
                        clear();
                        fillTable();
                    } else {
                        new Notification(ThongTinSanPham.this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thử lại!").showNotification();
                    }
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(message);
        } else {
            System.out.println("Chua co thuoc tinh");
            if (this.list.insertBienThe(getSanPhamBienThe())) {
                this.bienTheList = this.list.getByIdSanPhamBienThe(this.idProduct);
                new Notification(this.main, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Thêm thành công!").showNotification();
                fillTable();
            } else {
                new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thử lại!").showNotification();
            }
        }
    }

    /*__________________________System__________________________*/
    private void updateNameProduct() {
        txtSanPham.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String size = cbbSize.getSelectedItem().toString();
                String color = cbbColor.getSelectedItem().toString();
                txtTenBienThe.setText(String.format("%s [%s - %s]", txtSanPham.getText(), size != null ? size : "", color != null ? color : ""));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String size = cbbSize.getSelectedItem().toString();
                String color = cbbColor.getSelectedItem().toString();
                txtTenBienThe.setText(String.format("%s [%s - %s]", txtSanPham.getText(), size != null ? size : "", color != null ? color : ""));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String size = cbbSize.getSelectedItem().toString();
                String color = cbbColor.getSelectedItem().toString();
                txtTenBienThe.setText(String.format("%s [%s - %s]", txtSanPham.getText(), size != null ? size : "", color != null ? color : ""));
            }

        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    public Integer generateRandomNumber(int minValue, int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    private Boolean isValidate() {
        Notification notification;
        if (txtSanPham.getText().trim().isBlank()) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thêm đủ thông tin!");
            notification.showNotification();
            txtSanPham.requestFocus();
            return false;
        } else if (txtSoLuong.getText().trim().isBlank()) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thêm đủ thông tin!");
            notification.showNotification();
            txtSoLuong.requestFocus();
            return false;
        } else if (cbbSize.getSelectedIndex() == 0) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng chọn Size!");
            notification.showNotification();
            cbbSize.requestFocus();
            return false;
        } else if (cbbColor.getSelectedIndex() == 0) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng chọn màu sắc!");
            notification.showNotification();
            cbbColor.requestFocus();
            return false;
        } else if (txtGia.getText().trim().isBlank()) {
            notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng thêm đủ thông tin!");
            notification.showNotification();
            txtGia.requestFocus();
            return false;
        } else {
            if (!(new ValidateNumber().isNumber(txtSoLuong.getText().trim()))) {
                notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Dữ liệu không hợp lệ!");
                notification.showNotification();
                txtSoLuong.requestFocus();
                return false;
            } else if (!(new ValidateNumber().isNumber(txtGia.getText().trim()))) {
                notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Dữ liệu không hợp lệ!");
                notification.showNotification();
                txtGia.requestFocus();
                return false;
            } else {
                Integer soLuong = Integer.valueOf(txtSoLuong.getText().trim());
                Integer gia = Integer.valueOf(txtGia.getText().trim());
                if (soLuong < 0) {
                    notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Số lượng không hợp lệ!");
                    notification.showNotification();
                    txtSoLuong.requestFocus();
                    return false;
                } else if (gia < 1000) {
                    notification = new Notification(this.main, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Giá không hợp lệ!");
                    notification.showNotification();
                    txtGia.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    public String urlImage(Boolean get_set) {
        try {
            String currentDirectory = System.getProperty("user.dir")
                    + "/src/main/java/haladesign/photo/";
            JnaFileChooser fileChooser = new  JnaFileChooser(currentDirectory);
            fileChooser.showOpenDialog(null);
            File selectedFile = fileChooser.getSelectedFile();

            if (selectedFile != null) {
                if (get_set) {
                    return selectedFile.getName();
                }
                Image img = ImageIO.read(selectedFile);
                lbImage.setText(null);
                lbImage.setIcon(new ImageIcon(
                        img.getScaledInstance(lbImage.getWidth(),
                                lbImage.getHeight(),
                                lbImage.getWidth())));
                return selectedFile.getName();
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    private Boolean existsBienTheWithColorAndSize(List<SanPhamBienThe> bienThe, String targetColor, String targetSize) {
        return bienThe.stream().anyMatch(sp -> targetColor.equals(sp.getColor().getLoaiMau()) && targetSize.equals(sp.getSize().getLoaiSize()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        txtSanPham = new haladesign.swingStyle.TextField();
        jScrollPane1 = new haladesign.swing.scroll.ScrollPaneWin11();
        tblSanPham = new haladesign.swing.table.Table();
        cbbSize = new haladesign.swingStyle.Combobox();
        cbbColor = new haladesign.swingStyle.Combobox();
        txtGia = new haladesign.swingStyle.TextField();
        txtSoLuong = new haladesign.swingStyle.TextField();
        txtTenBienThe = new haladesign.swingStyle.TextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTrangThai = new haladesign.swingStyle.SwitchButton();
        textAreaScroll1 = new haladesign.swingStyle.TextAreaScroll();
        txtMoTa = new haladesign.swingStyle.TextArea();
        jPanel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        btnThem = new haladesign.swingStyle.Button();
        btnUpdate = new haladesign.swingStyle.Button();
        btnHoanThanh = new haladesign.swingStyle.Button();

        jLabel4.setText("jLabel4");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Mã sản phẩm:");

        lbID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbID.setForeground(new java.awt.Color(153, 153, 153));
        lbID.setText("Auto");

        txtSanPham.setLabelText("Tên sản phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Sản Phẩm", "Số Lượng", "Màu Sắc", "Size", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane1.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(50);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(50);
            tblSanPham.getColumnModel().getColumn(2).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(2).setMaxWidth(120);
            tblSanPham.getColumnModel().getColumn(3).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(3).setMaxWidth(120);
            tblSanPham.getColumnModel().getColumn(4).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(4).setMaxWidth(120);
            tblSanPham.getColumnModel().getColumn(5).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        cbbSize.setLabeText("Size");
        cbbSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSizeItemStateChanged(evt);
            }
        });

        cbbColor.setLabeText("Color");
        cbbColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbColorItemStateChanged(evt);
            }
        });

        txtGia.setLabelText("Giá");

        txtSoLuong.setLabelText("Số lượng");

        txtTenBienThe.setLabelText("Tên biến thể");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Danh sách biến thể sản phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Hoạt động:");

        textAreaScroll1.setBackground(new java.awt.Color(255, 255, 255));
        textAreaScroll1.setLabelText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        textAreaScroll1.setViewportView(txtMoTa);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbImage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.setText("Image not found");
        lbImage.setToolTipText("");
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImageMouseClicked(evt);
            }
        });
        jPanel1.add(lbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 210));

        btnThem.setBackground(new java.awt.Color(102, 204, 255));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(102, 204, 255));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Cập nhật");
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHoanThanh.setBackground(new java.awt.Color(102, 204, 255));
        btnHoanThanh.setForeground(new java.awt.Color(255, 255, 255));
        btnHoanThanh.setText("Hoàn thành");
        btnHoanThanh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                            .addComponent(txtSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(cbbSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(cbbColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(txtTenBienThe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(169, 169, 169))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnHoanThanh, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                .addGap(43, 43, 43)))))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbID))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenBienThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (isValidate()) {
            update();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (isValidate()) {
            add();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
        complete();
    }//GEN-LAST:event_btnHoanThanhActionPerformed
    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        tableClickRow();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void cbbSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSizeItemStateChanged
        String size = (cbbSize.getSelectedIndex() > 0) ? cbbSize.getSelectedItem().toString() : "";
        String color = (cbbColor.getSelectedIndex() > 0) ? cbbColor.getSelectedItem().toString() : "";
        txtTenBienThe.setText(String.format("%s [%s - %s]", txtSanPham.getText(), size != null ? size : "", color != null ? color : ""));
    }//GEN-LAST:event_cbbSizeItemStateChanged

    private void cbbColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbColorItemStateChanged
        String size = (cbbSize.getSelectedIndex() > 0) ? cbbSize.getSelectedItem().toString() : "";
        String color = (cbbColor.getSelectedIndex() > 0) ? cbbColor.getSelectedItem().toString() : "";
        txtTenBienThe.setText(String.format("%s [%s - %s]", txtSanPham.getText(), size != null ? size : "", color != null ? color : ""));
    }//GEN-LAST:event_cbbColorItemStateChanged

    private void lbImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImageMouseClicked
        this.url = urlImage(false);
    }//GEN-LAST:event_lbImageMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnHoanThanh;
    private haladesign.swingStyle.Button btnThem;
    private haladesign.swingStyle.SwitchButton btnTrangThai;
    private haladesign.swingStyle.Button btnUpdate;
    private haladesign.swingStyle.Combobox cbbColor;
    private haladesign.swingStyle.Combobox cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbImage;
    private haladesign.swing.table.Table tblSanPham;
    private haladesign.swingStyle.TextAreaScroll textAreaScroll1;
    private haladesign.swingStyle.TextField txtGia;
    private haladesign.swingStyle.TextArea txtMoTa;
    private haladesign.swingStyle.TextField txtSanPham;
    private haladesign.swingStyle.TextField txtSoLuong;
    private haladesign.swingStyle.TextField txtTenBienThe;
    // End of variables declaration//GEN-END:variables
}
