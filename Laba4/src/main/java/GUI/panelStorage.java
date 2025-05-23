package GUI;

import Entities.Component;
import Manager.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.table.JTableHeader;


public class panelStorage extends javax.swing.JPanel {

    public panelStorage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableStorage = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 186, 191));

        tableStorage.setBackground(new java.awt.Color(243, 229, 200));
        tableStorage.setFillsViewportHeight(true);
        JTableHeader header = tableStorage.getTableHeader();
        header.setFont(new Font("Georgia", 0, 16));
        header.setBackground(new java.awt.Color(255, 250, 241));
        tableStorage.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        tableStorage.setForeground(new java.awt.Color(74, 48, 50));
        tableStorage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableStorage.setEnabled(false);
        jScrollPane1.setViewportView(tableStorage);

        jButton3.setBackground(new java.awt.Color(145, 44, 160));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(243, 229, 200));
        jButton3.setText("Заказать компоненты");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jButton3)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DeliveryWindow dw = new DeliveryWindow((JFrame) SwingUtilities.getWindowAncestor(this));
        dw.setVisible(true);
        dw.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void refreshData() {
    new SwingWorker<List<Component>, Void>() {

        @Override
        protected List<Component> doInBackground() {
            EntityManager em = EntityManagerHelper.getEntityManager();
            try {
                return em.createQuery("SELECT c FROM Component c ORDER BY c.name", Component.class)
                        .getResultList();
            } finally {
                em.close();
            }
        }

        @Override
        protected void done() {
            try {
                List<Component> components = get();
                DefaultTableModel model = new DefaultTableModel(
                        new Object[]{"Название", "Тип", "Количество"}, 0);

                for (Component c : components) {
                    model.addRow(new Object[]{
                        c.getName(),
                        c.getType(),
                        c.getQuantity()
                    });
                }

                tableStorage.setModel(model);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(panelStorage.this,
                        "Ошибка загрузки: " + e.getMessage(),
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }.execute();
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStorage;
    // End of variables declaration//GEN-END:variables
}
