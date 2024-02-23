package haladesign.form;

/**
 *
 * @author NONG HOANG VU
 */
public class ThongKe extends javax.swing.JPanel {
    
    
    public ThongKe() {
        initComponents();
        init();
    }
    
    private void init() {
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new haladesign.swing.RoundPanel();
        card1 = new haladesign.card.Card();
        card2 = new haladesign.card.Card();
        card3 = new haladesign.card.Card();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        card1.setColor1(new java.awt.Color(255, 51, 255));
        card1.setColor2(new java.awt.Color(255, 102, 102));
        card1.setDescription("Tổng doanh thu");
        card1.setIcon(javaswingdev.GoogleMaterialDesignIcon.MONEY_OFF);
        card1.setValues("363.083.043 VNĐ");

        card2.setColor1(new java.awt.Color(255, 51, 255));
        card2.setColor2(new java.awt.Color(255, 102, 102));
        card2.setDescription("Doanh thu tháng");
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.TODAY);
        card2.setValues("4.260.000 VNĐ");

        card3.setColor1(new java.awt.Color(255, 51, 255));
        card3.setColor2(new java.awt.Color(255, 102, 102));
        card3.setDescription("Doanh thu tuần");
        card3.setIcon(javaswingdev.GoogleMaterialDesignIcon.PAYMENT);
        card3.setValues("400.000 VNĐ");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(403, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private haladesign.card.Card card1;
    private haladesign.card.Card card2;
    private haladesign.card.Card card3;
    private haladesign.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
