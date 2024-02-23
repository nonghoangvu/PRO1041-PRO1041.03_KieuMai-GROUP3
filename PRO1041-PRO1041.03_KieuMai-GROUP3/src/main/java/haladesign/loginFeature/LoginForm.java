package haladesign.loginFeature;

import haladesign.Utitlity.BcryptHash;
import haladesign.Utitlity.LoginInfo;
import haladesign.Utitlity.LoginInfoSerializationUtil;
import haladesign.mainMenu.Main;
import haladesign.model.NhanVien;
import haladesign.service.NhanVienService;
import haladesign.system.Notification;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author NONG HOANG VU
 */
public class LoginForm extends javax.swing.JFrame {

    private final NhanVienService nhanVienService = new NhanVienService();
    private final BcryptHash bcryptHash = new BcryptHash();

    public LoginForm() {
        initComponents();
        titleBar.initJFram(this);
        isRemember();
    }

    public void handleSubmit() {
        lblErrPhone.setText("");
        lblErrPassw.setText("");

        String phonenum = txtPhonenum.getText();
        String password = String.valueOf(txtPassw.getPassword());

        NhanVien nhanVien = nhanVienService.getEmplLogin(phonenum);
        if (phonenum.isBlank()) {
            lblErrPhone.setText("Vui lòng nhập SDT");
        } else if (nhanVien == null) {
            lblErrPhone.setText("SĐT không tồn tại trong hệ thống");
        } else if (nhanVien != null && nhanVien.getPassword() == null) {
            lblErrPassw.setText("SĐT này chưa được đăng ký, vui lòng chọn đăng ký");
        } else if (nhanVien != null && password.isBlank()) {
            lblErrPassw.setText("Vui lòng nhập mật khẩu");
        } else if (nhanVien != null && !nhanVien.getPassword().trim().equals(password)) {
            lblErrPassw.setText("Sai mật khẩu");
        } else if (nhanVien.getPhoneNum().trim().equals(phonenum) && nhanVien.getPassword().trim().equals(password)) {
            System.out.println(nhanVien);
            rememberPassword(ckbRemember.isSelected());
            new Main(nhanVien).setVisible(true);
            this.dispose();
        }
    }

    public String getIPAddress() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            return localhost.getHostAddress().trim();
        } catch (UnknownHostException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    private void rememberPassword(Boolean selected) {
        LoginInfo loginInfo = new LoginInfo();
        if (selected) {
            loginInfo.setUsername(txtPhonenum.getText());
            loginInfo.setPassword(bcryptHash.encodeBase64(String.valueOf(txtPassw.getPassword())));
            loginInfo.setIpAddress(bcryptHash.encodeBase64(getIPAddress()));
        } else {
            loginInfo = null;
        }
        new LoginInfoSerializationUtil().saveLoginInfoToFile(loginInfo);
    }

    private void isRemember() {
        LoginInfo cookie = new LoginInfoSerializationUtil().readLoginInfoFromFile();
        if (cookie != null) {
            if (bcryptHash.decodeBase64(cookie.getIpAddress()).equals(getIPAddress())) {
                txtPhonenum.setText(cookie.getUsername());
                txtPassw.setText(bcryptHash.decodeBase64(cookie.getPassword()));
                ckbRemember.setSelected(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new haladesign.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPhonenum = new haladesign.swingStyle.TextField();
        txtPassw = new haladesign.swingStyle.PasswordField();
        ckbRemember = new haladesign.swingStyle.JCheckBoxCustom();
        btnLogin = new haladesign.swingStyle.Button();
        lbQuenMatKhau = new javax.swing.JLabel();
        titleBar = new haladesign.swing.titlebar.TitleBar();
        lblErrPhone = new javax.swing.JLabel();
        lblErrPassw = new javax.swing.JLabel();
        lbSignup = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        txtPhonenum.setLabelText("Số điện thoại");
        txtPhonenum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhonenumKeyPressed(evt);
            }
        });

        txtPassw.setLabelText("Mật khẩu");
        txtPassw.setShowAndHide(true);
        txtPassw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswKeyPressed(evt);
            }
        });

        ckbRemember.setText("Remember me");

        btnLogin.setBackground(new java.awt.Color(102, 204, 255));
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lbQuenMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbQuenMatKhau.setForeground(new java.awt.Color(51, 51, 255));
        lbQuenMatKhau.setText("Quên mật khẩu");
        lbQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQuenMatKhauMouseClicked(evt);
            }
        });

        lblErrPhone.setForeground(new java.awt.Color(255, 0, 0));
        lblErrPhone.setText("   ");

        lblErrPassw.setForeground(new java.awt.Color(255, 0, 0));
        lblErrPassw.setText("   ");

        lbSignup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSignup.setForeground(new java.awt.Color(51, 51, 255));
        lbSignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSignup.setText("Tạo tài khoản");
        lbSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSignupMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPhonenum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addComponent(ckbRemember, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(lbQuenMatKhau))
                            .addComponent(txtPassw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblErrPassw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblErrPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbSignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txtPhonenum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblErrPhone)
                .addGap(10, 10, 10)
                .addComponent(txtPassw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblErrPassw)
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbRemember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuenMatKhau))
                .addGap(30, 30, 30)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbSignup)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        handleSubmit();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lbQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuenMatKhauMouseClicked
        new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Đang bảo trì!").showNotification();
    }//GEN-LAST:event_lbQuenMatKhauMouseClicked

    private void lbSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSignupMouseClicked
        new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Đang bảo trì!").showNotification();
    }//GEN-LAST:event_lbSignupMouseClicked

    private void txtPhonenumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhonenumKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPassw.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtPassw.requestFocus();
        }
    }//GEN-LAST:event_txtPhonenumKeyPressed

    private void txtPasswKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSubmit();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtPhonenum.requestFocus();
        }
    }//GEN-LAST:event_txtPasswKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnLogin;
    private haladesign.swingStyle.JCheckBoxCustom ckbRemember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbQuenMatKhau;
    private javax.swing.JLabel lbSignup;
    private javax.swing.JLabel lblErrPassw;
    private javax.swing.JLabel lblErrPhone;
    private haladesign.swing.RoundPanel roundPanel1;
    private haladesign.swing.titlebar.TitleBar titleBar;
    private haladesign.swingStyle.PasswordField txtPassw;
    private haladesign.swingStyle.TextField txtPhonenum;
    // End of variables declaration//GEN-END:variables
}
