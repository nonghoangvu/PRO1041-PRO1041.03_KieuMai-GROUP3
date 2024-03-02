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
import javax.swing.JOptionPane;

/**
 *
 * @author NONG HOANG VU
 */
public class SignUp extends javax.swing.JFrame {

    private final NhanVienService nhanVienService = new NhanVienService();

    public SignUp() {
        initComponents();
        titleBar.initJFram(this);

    }

    public void handleSubmit() {
        String phonenum = txtPhonenum.getText().trim();

        NhanVien nvien = nhanVienService.getEmplLogin(phonenum.trim());
        if (nvien == null) {
           new Notification(this, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Số điện thoại chưa được đăng ký trong hệ thống, vui lòng liên hệ với chủ cửa hàng").showNotification();
        } else if (nvien.getUserState().trim().equalsIgnoreCase("Đã gửi lời mời")) {
            new ConfirmPassw(nvien).setVisible(true);
            this.dispose();
        } else {
            new Notification(this, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Số điện thoại đã được sử dụng cho tài khoản khác").showNotification();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new haladesign.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPhonenum = new haladesign.swingStyle.TextField();
        btnLogin = new haladesign.swingStyle.Button();
        titleBar = new haladesign.swing.titlebar.TitleBar();
        lblErrPhone = new javax.swing.JLabel();
        lblErrPassw = new javax.swing.JLabel();
        lbSignup = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng ký");

        txtPhonenum.setLabelText("Số điện thoại");
        txtPhonenum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhonenumActionPerformed(evt);
            }
        });
        txtPhonenum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhonenumKeyPressed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(102, 204, 255));
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Tiếp tục");
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblErrPhone.setForeground(new java.awt.Color(255, 0, 0));
        lblErrPhone.setText("   ");

        lblErrPassw.setForeground(new java.awt.Color(255, 0, 0));
        lblErrPassw.setText("   ");

        lbSignup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSignup.setForeground(new java.awt.Color(51, 51, 255));
        lbSignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSignup.setText("Quay lại");
        lbSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSignupMouseClicked(evt);
            }
        });

        jLabel2.setText("Nhập vào SĐT đã được thêm bởi chủ cửa hàng");

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
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPhonenum, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErrPassw, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lbSignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(22, 22, 22))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrPhone)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblErrPassw))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtPhonenum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lbSignup)
                .addContainerGap(73, Short.MAX_VALUE))
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

    private void lbSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSignupMouseClicked
//        new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Đang bảo trì!").showNotification();
        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbSignupMouseClicked

    private void txtPhonenumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhonenumKeyPressed

    }//GEN-LAST:event_txtPhonenumKeyPressed

    private void txtPhonenumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhonenumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhonenumActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.Button btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbSignup;
    private javax.swing.JLabel lblErrPassw;
    private javax.swing.JLabel lblErrPhone;
    private haladesign.swing.RoundPanel roundPanel1;
    private haladesign.swing.titlebar.TitleBar titleBar;
    private haladesign.swingStyle.TextField txtPhonenum;
    // End of variables declaration//GEN-END:variables
}
