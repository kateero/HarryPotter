package GUI;

import Entities.Wand;
import Manager.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

public class panelWand extends javax.swing.JPanel {

    public panelWand() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelWands = new javax.swing.JTable();

        tabelWands.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelWands);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void refreshData() {
        new SwingWorker<List<Wand>, Void>() {

            @Override
            protected List<Wand> doInBackground() {
                EntityManager em = EntityManagerHelper.getEntityManager();
                try {
                    return em.createQuery("SELECT w FROM Wand w WHERE w.isSold = false", Wand.class)
                            .getResultList();
                } finally {
                    em.close();
                }
            }

            @Override
            protected void done() {
                try {
                    List<Wand> wands = get();
                    DefaultTableModel model = new DefaultTableModel(
                            new Object[]{"ID", "Сердцевина", "Древесина", "Длина", "Цена"}, 0);

                    for (Wand w : wands) {
                        model.addRow(new Object[]{
                            w.getId(),
                            w.getCore(),
                            w.getWood(),
                            w.getLength(),
                            w.getPrice()
                        });
                    }

                    tabelWands.setModel(model);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(panelWand.this,
                            "Ошибка загрузки: " + e.getMessage(),
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelWands;
    // End of variables declaration//GEN-END:variables
}
