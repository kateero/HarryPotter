package GUI;

import Entities.Wand;
import Manager.EntityManagerHelper;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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

        setBackground(new java.awt.Color(222, 186, 191));

        tabelWands.setBackground(new java.awt.Color(243, 229, 200));
        tabelWands.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelWands.setFillsViewportHeight(true);
        JTableHeader header = tabelWands.getTableHeader();
        header.setFont(new Font("Georgia", 0, 16));
        header.setBackground(new java.awt.Color(255, 250, 241));
        tabelWands.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        tabelWands.setModel(new javax.swing.table.DefaultTableModel(

        ));
        tabelWands.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        availableButton.setBackground(new java.awt.Color(145, 44, 160));
        availableButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        availableButton.setForeground(new java.awt.Color(243, 229, 200));
        availableButton.setText("В наличии");
        availableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableButtonActionPerformed(evt);
            }
        });

        soldButton.setBackground(new java.awt.Color(145, 44, 160));
        soldButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        soldButton.setForeground(new java.awt.Color(243, 229, 200));
        soldButton.setText("Продано");
        soldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(74, 48, 50));
        statusLabel.setText("Палочки в наличии");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(availableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167)
                .addComponent(soldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
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
