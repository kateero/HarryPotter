
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

        tableStorage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        jButton3.setText("jButton3");
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
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(jButton3)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton3)
                .addContainerGap(38, Short.MAX_VALUE))
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
