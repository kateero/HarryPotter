package GUI;

import Entities.Component;
import Entities.Wizard;
import Manager.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
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
        jScrollPane1.setViewportView(tableStorage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

        public void refreshData() {
        new SwingWorker<List<Component>, Void>() {

            @Override
            protected List<Component> doInBackground() {
                EntityManager em = EntityManagerHelper.getEntityManager();
                try {
                    return em.createQuery("SELECT c FROM Component c", Component.class)
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStorage;
    // End of variables declaration//GEN-END:variables
}
