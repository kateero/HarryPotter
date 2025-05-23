package GUI;

import Manager.EntityManagerHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import Entities.*;

public class panelReset extends javax.swing.JPanel {

    public panelReset() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 186, 191));
        setPreferredSize(new java.awt.Dimension(900, 476));

        jButton1.setBackground(new java.awt.Color(145, 44, 160));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(243, 229, 200));
        jButton1.setText("Очистить таблицы");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Вы уверены, что хотите очистить все таблицы? Это действие нельзя отменить.",
                "Подтверждение",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            resetDataBase();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resetDataBase() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            em.createQuery("DELETE FROM DeliveryDetails").executeUpdate();
            em.createQuery("DELETE FROM Delivery").executeUpdate();
            em.createQuery("DELETE FROM Wizard").executeUpdate();
            em.createQuery("DELETE FROM Wand").executeUpdate();
            em.createQuery("UPDATE Component SET quantity = 0").executeUpdate();

            tx.commit();
            JOptionPane.showMessageDialog(null, "Все таблицы очищены!");

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            JOptionPane.showMessageDialog(null,
                    "Не получилось очистить таблицы" + e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
