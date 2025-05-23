package GUI;

import Entities.Delivery;
import Manager.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.table.JTableHeader;

public class panelDeliveryDetails extends javax.swing.JPanel {

    public panelDeliveryDetails() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DeliveryDetailsTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(222, 186, 191));

        DeliveryDetailsTable.setBackground(new java.awt.Color(243, 229, 200));
        DeliveryDetailsTable.setFillsViewportHeight(true);
        JTableHeader header = DeliveryDetailsTable.getTableHeader();
        header.setFont(new Font("Georgia", 0, 16));
        header.setBackground(new java.awt.Color(255, 250, 241));
        DeliveryDetailsTable.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        DeliveryDetailsTable.setForeground(new java.awt.Color(74, 48, 50));
        DeliveryDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(DeliveryDetailsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void refreshData() {
        new SwingWorker<List<Delivery>, Void>() {

            @Override
            protected List<Delivery> doInBackground() {
                EntityManager em = EntityManagerHelper.getEntityManager();
                try {
                    return em.createQuery("SELECT d FROM Delivery d ORDER BY d.id", Delivery.class)
                            .getResultList();
                } finally {
                    em.close();
                }
            }

            @Override
            protected void done() {
                try {
                    List<Delivery> deliveries = get();
                    DefaultTableModel model = new DefaultTableModel(
                            new Object[]{"ID поставки", "Дата поставки", "Сумма поставки"}, 0);

                    for (Delivery delivery : deliveries) {
                        model.addRow(new Object[]{
                            delivery.getId(),
                            delivery.getDeliveryDate(),
                            delivery.getCost()
                        });
                    }

                    DeliveryDetailsTable.setModel(model);
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(panelDeliveryDetails.this,
                            "Ошибка загрузки: " + e.getMessage(),
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DeliveryDetailsTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
