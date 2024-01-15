package haladesign.system;

import haladesign.Utitlity.BcryptHash;

/**
 *
 * @author NONG HOANG VU
 */
public class Setting extends javax.swing.JPanel {

    public Setting() {
        initComponents();
        setConfig();
    }

    private void setConfig() {
        DatabaseConfig config = new DataConfigSerializationUtil().readConfigInfoFromFile();
        if (config != null) {
            BcryptHash bcryptHash = new BcryptHash();
            txtUsername.setText(bcryptHash.decodeBase64(config.getUsername()));
            txtPassword.setText(bcryptHash.decodeBase64(config.getPassword()));
            txtDBName.setText(bcryptHash.decodeBase64(config.getDatabase_name()));
            txtPort.setText(bcryptHash.decodeBase64(config.getPort()));
            txtServer.setText(bcryptHash.decodeBase64(config.getServer()));
            btnSSL.setSelected(config.getUsing_ssl());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new haladesign.swingStyle.TextField();
        jLabel2 = new javax.swing.JLabel();
        txtServer = new haladesign.swingStyle.TextField();
        txtPort = new haladesign.swingStyle.TextField();
        txtDBName = new haladesign.swingStyle.TextField();
        jLabel3 = new javax.swing.JLabel();
        btnSSL = new haladesign.swingStyle.SwitchButton();
        btnSave = new haladesign.swingStyle.Button();
        txtPassword = new haladesign.swingStyle.PasswordField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("V1.1");

        txtUsername.setText("sa");
        txtUsername.setLabelText("USERNAME");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Config Database");

        txtServer.setText("localhost");
        txtServer.setLabelText("SERVER");

        txtPort.setText("1433");
        txtPort.setLabelText("PORT");

        txtDBName.setText("HalaDesign");
        txtDBName.setLabelText("DATABASE NAME");

        jLabel3.setText("USING_SSL:");

        btnSSL.setBackground(new java.awt.Color(51, 51, 255));

        btnSave.setBackground(new java.awt.Color(204, 204, 204));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save & Restart");
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtPassword.setText("123");
        txtPassword.setLabelText("PASSWORD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(633, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDBName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(txtDBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        DatabaseConfig config = new DatabaseConfig();
        BcryptHash bcryptHash = new BcryptHash();
        config.setUsername(bcryptHash.encodeBase64(txtUsername.getText()));
        config.setPassword(bcryptHash.encodeBase64(String.valueOf(txtPassword.getPassword())));
        config.setDatabase_name(bcryptHash.encodeBase64(txtDBName.getText()));
        config.setPort(bcryptHash.encodeBase64(txtPort.getText()));
        config.setServer(bcryptHash.encodeBase64(txtServer.getText()));
        config.setUsing_ssl(btnSSL.isSelected());
        new DataConfigSerializationUtil().saveConfigInfoToFile(config);
        System.exit(0);
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.swingStyle.SwitchButton btnSSL;
    private haladesign.swingStyle.Button btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private haladesign.swingStyle.TextField txtDBName;
    private haladesign.swingStyle.PasswordField txtPassword;
    private haladesign.swingStyle.TextField txtPort;
    private haladesign.swingStyle.TextField txtServer;
    private haladesign.swingStyle.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
