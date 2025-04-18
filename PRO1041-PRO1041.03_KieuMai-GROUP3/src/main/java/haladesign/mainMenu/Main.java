package haladesign.mainMenu;

import haladesign.Utitlity.BcryptHash;
import haladesign.form.DanhSachChiTietSanPham;
import haladesign.form.ThongKe;
import java.awt.Component;
import haladesign.form.Form_Empty;
import haladesign.form.DanhSachSanPham;
import haladesign.form.SellForm;
import haladesign.form.ThuocTinhSanPham;
import haladesign.loginFeature.LoginForm;
import haladesign.model.Account;
import haladesign.system.GlassPanePopup;
import haladesign.system.Message;
import haladesign.system.Setting;
import java.awt.event.ActionEvent;

/**
 *
 * @author NONG HOANG VU
 */
public class Main extends javax.swing.JFrame {

    private static Main main;
    private final Account account;
    private final BcryptHash bcryptHash = new BcryptHash();

    public Main(Account account) {
        this.account = account;
        initComponents();
        init();
        GlassPanePopup.install(this);
    }

    public void showMessage() {
        Message message = new Message();
        message.eventOK((ActionEvent ae) -> {
            GlassPanePopup.closePopupLast();
        });
        GlassPanePopup.showPopup(message);
    }

    private void init() {
        main = this;
        titleBar.initJFram(this);
        menu.addEvent((var index, var indexSubMenu) -> {
            switch (index) {
                case 0 -> {
                    switch (indexSubMenu) {
                        case 0 ->
                            showForm(new ThongKe());
                        default ->
                            showForm(new Form_Empty(index + " " + indexSubMenu));
                    }
                }
                case 1 -> {
                    switch (indexSubMenu) {
                        case 1 ->
                            showForm(new SellForm(this.account, this));
                        default ->
                            showForm(new Form_Empty(index + " " + indexSubMenu));
                    }
                }
                case 2 -> {
                    switch (indexSubMenu) {
                        case 1 ->
                            showForm(new DanhSachSanPham(Main.this, this.account));
                        case 2 ->
                            showForm(new ThuocTinhSanPham(Main.this));
                        case 3 ->
                            showForm(new DanhSachChiTietSanPham(Main.this));
                        default ->
                            showForm(new Form_Empty(index + " " + indexSubMenu));
                    }
                }
                case 4 ->
                    showForm(new Setting());
                default ->
                    showForm(new Form_Empty(index + " " + indexSubMenu));
                case 6 -> {
                    Message message = new Message();
                    message.setTitle(this.bcryptHash.decodeBase64("Q+G6o25oIGLDoW8="));
                    message.setMessage(
                            this.bcryptHash.decodeBase64("QuG6oW4gY8OzIG114buRbiDEkcSDbmcgeHXhuqV0IGtow7RuZz8="));
                    message.eventOK((ActionEvent ae) -> {
                        new LoginForm().setVisible(true);
                        this.dispose();
                        GlassPanePopup.closePopupLast();
                    });
                    GlassPanePopup.showPopup(message);
                }
            }

        });
        menu.setSelectedIndex(
                0, 0);
    }

    public void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    public static Main getMain() {
        return main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        menu = new haladesign.menu.Menu();
        titleBar = new haladesign.swing.titlebar.TitleBar();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(255, 255, 255));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
                panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMenuLayout.createSequentialGroup()
                                .addGroup(panelMenuLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                        .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)));
        panelMenuLayout.setVerticalGroup(
                panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)));

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                                .addContainerGap()));
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel body;
    private haladesign.menu.Menu menu;
    private javax.swing.JPanel panelMenu;
    private haladesign.swing.titlebar.TitleBar titleBar;
    // End of variables declaration//GEN-END:variables
}
