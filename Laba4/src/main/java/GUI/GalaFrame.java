package GUI;

public class GalaFrame extends javax.swing.JFrame {

    panelWizard panelWizard = new panelWizard();
    panelWand panelWand = new panelWand();
    panelCreate panelCreate = new panelCreate();
    panelStorage panelStorage = new panelStorage();
    panelReset panelDelivery = new panelReset();
    panelDeliveryDetails panelDeliveryDetails = new panelDeliveryDetails();

    public GalaFrame() {
        initComponents();
        panelWizard.refreshData();
        panelWand.refreshAvailable();
        panelStorage.refreshData();
       // panelDelivery.refreshData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        wands = new javax.swing.JMenu("Палочки");
        createWand = new javax.swing.JMenu();
        buyers = new javax.swing.JMenu();
        storageComponents = new javax.swing.JMenu();
        deliveryDetails = new javax.swing.JMenu();
        delivery = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addTab("Палочки", panelWand);
        jTabbedPane1.addTab("Создать палочку", panelCreate);
        jTabbedPane1.addTab("Покупатели", panelWizard);
        jTabbedPane1.addTab("Склад", panelStorage);
        jTabbedPane1.addTab("Заказать компоненты", panelDelivery);
        jTabbedPane1.addTab("Журнал поставок", panelDeliveryDetails);

        wands.setBackground(new java.awt.Color(202, 220, 227));
        wands.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        wands.setForeground(new java.awt.Color(74, 48, 50));
        wands.setText("            Палочки");
        wands.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        wands.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        wands.setHideActionText(true);
        wands.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wands.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        wands.setMinimumSize(new java.awt.Dimension(150, 40));
        wands.setPreferredSize(new java.awt.Dimension(150, 40));
        wands.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wandsMouseClicked(evt);
            }
        });
        menuBar.add(wands);

        createWand.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        createWand.setForeground(new java.awt.Color(74, 48, 50));
        createWand.setText("   Изготовить палочку");
        createWand.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        createWand.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        createWand.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createWand.setPreferredSize(new java.awt.Dimension(150, 22));
        createWand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createWandMouseClicked(evt);
            }
        });
        menuBar.add(createWand);

        buyers.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        buyers.setForeground(new java.awt.Color(74, 48, 50));
        buyers.setText("         Покупатели");
        buyers.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        buyers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buyers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buyers.setPreferredSize(new java.awt.Dimension(150, 22));
        buyers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyersMouseClicked(evt);
            }
        });
        menuBar.add(buyers);

        storageComponents.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        storageComponents.setForeground(new java.awt.Color(74, 48, 50));
        storageComponents.setText("              Склад");
        storageComponents.setAutoscrolls(true);
        storageComponents.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        storageComponents.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        storageComponents.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        storageComponents.setPreferredSize(new java.awt.Dimension(150, 22));
        storageComponents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                storageComponentsMouseClicked(evt);
            }
        });
        menuBar.add(storageComponents);

        deliveryDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        deliveryDetails.setForeground(new java.awt.Color(74, 48, 50));
        deliveryDetails.setText("     Журнал поставок");
        deliveryDetails.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        deliveryDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deliveryDetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deliveryDetails.setPreferredSize(new java.awt.Dimension(150, 22));
        deliveryDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deliveryDetailsMouseClicked(evt);
            }
        });
        menuBar.add(deliveryDetails);

        delivery.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        delivery.setForeground(new java.awt.Color(74, 48, 50));
        delivery.setText("      Сбросить данные");
        delivery.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        delivery.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        delivery.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delivery.setMinimumSize(new java.awt.Dimension(150, 15));
        delivery.setPreferredSize(new java.awt.Dimension(150, 15));
        delivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deliveryMouseClicked(evt);
            }
        });
        menuBar.add(delivery);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
                return 0;
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buyersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyersMouseClicked
        panelWizard.refreshData();
        jTabbedPane1.setSelectedIndex(2);


    }//GEN-LAST:event_buyersMouseClicked

    private void wandsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wandsMouseClicked
        jTabbedPane1.setSelectedIndex(0);
        panelWand.refreshAvailable();
    }//GEN-LAST:event_wandsMouseClicked

    private void createWandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createWandMouseClicked
        jTabbedPane1.setSelectedIndex(1);
        panelCreate.updateComboBox(true);
        panelCreate.updateComboBox(false);
    }//GEN-LAST:event_createWandMouseClicked

    private void storageComponentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storageComponentsMouseClicked
        panelStorage.refreshData();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_storageComponentsMouseClicked

    private void deliveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryMouseClicked
        
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_deliveryMouseClicked

    private void deliveryDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryDetailsMouseClicked
        panelDeliveryDetails.refreshData();
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_deliveryDetailsMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu buyers;
    private javax.swing.JMenu createWand;
    private javax.swing.JMenu delivery;
    private javax.swing.JMenu deliveryDetails;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu storageComponents;
    private javax.swing.JMenu wands;
    // End of variables declaration//GEN-END:variables
}
