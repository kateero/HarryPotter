package GUI;

import Entities.Wand;
import Manager.EntityManagerHelper;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

public class panelWand extends javax.swing.JPanel {
    boolean state = true;

    public panelWand() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelWands = new javax.swing.JTable();
        availableButton = new javax.swing.JButton();
        soldButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        tabelWands.setModel(new javax.swing.table.DefaultTableModel(

        ));
        tabelWands.setEnabled(false);
        jScrollPane1.setViewportView(tabelWands);
        tabelWands.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(state){
                    if(e.getClickCount() == 2){
                        int row = tabelWands.rowAtPoint(e.getPoint());
                        if (row >= 0) {
                            Integer idWand = (Integer) tabelWands.getValueAt(row, 0);
                            buyerWindow bw = new buyerWindow(idWand);
                            bw.setVisible(true);
                            bw.setLocationRelativeTo(null);
                        }
                    }
                }
            }
        });

        availableButton.setText("В наличии");
        availableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableButtonActionPerformed(evt);
            }
        });

        soldButton.setText("Продано");
        soldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        statusLabel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(availableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(soldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void availableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableButtonActionPerformed
        this.refreshAvailable();
    }//GEN-LAST:event_availableButtonActionPerformed

    private void soldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldButtonActionPerformed
        this.refreshSold();
    }//GEN-LAST:event_soldButtonActionPerformed
   
    public void refreshAvailable() {
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
                    statusLabel.setText("Палочки в наличии");
                    state = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(panelWand.this,
                            "Ошибка загрузки: " + e.getMessage(),
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    private void refreshSold() {
        new SwingWorker<List<Wand>, Void>() {

            @Override
            protected List<Wand> doInBackground() {
                EntityManager em = EntityManagerHelper.getEntityManager();
                try {
                    return em.createQuery("SELECT w FROM Wand w WHERE w.isSold = true", Wand.class)
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
                    statusLabel.setText("Проданные палочки");
                    state = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(panelWand.this,
                            "Ошибка загрузки: " + e.getMessage(),
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton availableButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton soldButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTable tabelWands;
    // End of variables declaration//GEN-END:variables
}
