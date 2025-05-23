package GUI;

import Entities.Wizard;
import Manager.EntityManagerHelper;
import java.awt.Font;
import javax.swing.table.JTableHeader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;


public class panelWizard extends javax.swing.JPanel {

    public panelWizard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelWizards = new javax.swing.JTable();

        setBackground(new java.awt.Color(222, 186, 191));

        tabelWizards.setBackground(new java.awt.Color(243, 229, 200));
        tabelWizards.setFillsViewportHeight(true);
        JTableHeader header = tabelWizards.getTableHeader();
        header.setFont(new Font("Georgia", 0, 16));
        header.setBackground(new java.awt.Color(255, 250, 241));
        tabelWizards.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        tabelWizards.setForeground(new java.awt.Color(74, 48, 50));
        tabelWizards.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelWizards.setEnabled(false);
        jScrollPane1.setViewportView(tabelWizards);

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
        new SwingWorker<List<Wizard>, Void>() {

            @Override
            protected List<Wizard> doInBackground() {
                EntityManager em = EntityManagerHelper.getEntityManager();
                try {
                    return em.createQuery("SELECT w FROM Wizard w", Wizard.class)
                            .getResultList();
                } finally {
                    em.close();
                }
            }

            @Override
            protected void done() {
                try {
                    List<Wizard> wizards = get();
                    DefaultTableModel model = new DefaultTableModel(
                            new Object[]{"ID", "Фамилия", "Имя", "ID палочки"}, 0);

                    for (Wizard w : wizards) {
                        model.addRow(new Object[]{
                            w.getId(),
                            w.getFirstName(),
                            w.getLastName(),
                            w.getWand()
                        });
                    }

                    tabelWizards.setModel(model);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(panelWizard.this,
                            "Ошибка загрузки: " + e.getMessage(),
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelWizards;
    // End of variables declaration//GEN-END:variables
}
