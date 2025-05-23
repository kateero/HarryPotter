package GUI;

import Entities.Wand;
import Entities.Wizard;
import Manager.EntityManagerHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class buyerWindow extends javax.swing.JFrame {

    Integer wandId = 0;

    public Integer getWandId() {
        return wandId;
    }

    public buyerWindow(Integer wandID) {
        this.wandId = wandID;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        firstNameValue = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        lastNameValue = new javax.swing.JTextField();
        buttonSell = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(222, 186, 191));

        firstNameValue.setBackground(new java.awt.Color(255, 250, 241));
        firstNameValue.setForeground(new java.awt.Color(74, 48, 50));
        firstNameValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameValueActionPerformed(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(74, 48, 50));
        firstNameLabel.setText("Имя");

        lastNameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lastNameLabel.setForeground(new java.awt.Color(74, 48, 50));
        lastNameLabel.setText("Фамилия");

        lastNameValue.setBackground(new java.awt.Color(255, 250, 241));
        lastNameValue.setForeground(new java.awt.Color(74, 48, 50));

        buttonSell.setBackground(new java.awt.Color(145, 44, 160));
        buttonSell.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        buttonSell.setForeground(new java.awt.Color(243, 229, 200));
        buttonSell.setText("Продать");
        buttonSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSellActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(74, 48, 50));
        jLabel3.setText("Кто покупает палочку?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstNameValue, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(lastNameValue))
                .addGap(80, 80, 80))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(buttonSell, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel3)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(buttonSell, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSellActionPerformed
        if (firstNameValue.getText().trim().isEmpty() && lastNameValue.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Заполните поля покупателя",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {
            this.createWizard();
            this.dispose();
        }
    }//GEN-LAST:event_buttonSellActionPerformed

    private void firstNameValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameValueActionPerformed

    private void createWizard() {

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                EntityManager em = EntityManagerHelper.getEntityManager();
                EntityTransaction tx = null;

                try {
                    tx = em.getTransaction();
                    tx.begin();

                    Wand wand = em.find(Wand.class, getWandId());
                    if (wand == null) {
                        throw new IllegalArgumentException("Палочка не найдена");
                    }

                    Wizard wizard = new Wizard();
                    wizard.setFirstName(firstNameValue.getText());
                    wizard.setLastName(lastNameValue.getText());
                    wizard.setWand(wand);

                    wand.setIsSold(true);

                    em.persist(wizard);
                    em.merge(wand);

                    tx.commit();

                    return null;

                } catch (Exception e) {
                    if (tx != null && tx.isActive()) {
                        tx.rollback();
                    }
                    throw e;
                } finally {
                    em.close();
                }
            }

            @Override
            protected void done() {
                try {
                    get();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Волшебник не добавлен",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSell;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameValue;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameValue;
    // End of variables declaration//GEN-END:variables
}
