package GUI;

import Entities.Component;
import Entities.Wand;
import Manager.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;

public class panelCreate extends javax.swing.JPanel {
    
    public panelCreate() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxCore = new javax.swing.JComboBox<>();
        comboBoxWood = new javax.swing.JComboBox<>();
        spinnerLength = new javax.swing.JSpinner(new SpinnerNumberModel(26, 20, 35, 1));
        spinnerPrice = new javax.swing.JSpinner(new SpinnerNumberModel(100, 50, 300, 10));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonCreate = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 186, 191));

        comboBoxCore.setBackground(new java.awt.Color(255, 250, 241));
        comboBoxCore.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        comboBoxCore.setName(""); // NOI18N

        comboBoxWood.setBackground(new java.awt.Color(255, 250, 241));
        comboBoxWood.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N

        spinnerLength.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        JComponent editor = spinnerLength.getEditor();
        JFormattedTextField tfLength = ((JSpinner.DefaultEditor)editor).getTextField();
        tfLength.setEditable(false);

        spinnerPrice.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        JComponent editorPrice = spinnerPrice.getEditor();
        JFormattedTextField tfPrice = ((JSpinner.DefaultEditor)editorPrice).getTextField();
        tfPrice.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(74, 48, 50));
        jLabel1.setText("Сердцевина");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 48, 50));
        jLabel2.setText("Древесина");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(74, 48, 50));
        jLabel3.setText("Длина");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(74, 48, 50));
        jLabel4.setText("Цена");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(74, 48, 50));
        jLabel5.setText("Изготовить палочку");

        buttonCreate.setBackground(new java.awt.Color(145, 44, 160));
        buttonCreate.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        buttonCreate.setForeground(new java.awt.Color(243, 229, 200));
        buttonCreate.setText("Создать");
        buttonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(189, 189, 189))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(comboBoxCore, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(comboBoxWood, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(spinnerLength, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(spinnerPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(buttonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCore, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxWood, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spinnerPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(buttonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateActionPerformed
        if(comboBoxCore.getSelectedItem() != null && comboBoxWood.getSelectedItem() != null){
            createWand();
            this.updateComboBox(true);
            this.updateComboBox(false);
        } else {
             JOptionPane.showMessageDialog(null,
                            "Выберите компоненты",
                            "Предупреждение", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_buttonCreateActionPerformed

    public void updateComboBox(boolean flag) {
        new SwingWorker<List<Component>, Void>() {
            @Override
            protected List<Component> doInBackground() throws Exception {
                EntityManager em = EntityManagerHelper.getEntityManager();
                try {
                    if (flag) {
                        return em.createQuery("SELECT c FROM Component c WHERE c.quantity > 0 AND c.type = 'сердцевина'", Component.class)
                                .getResultList();
                    } else {
                        return em.createQuery("SELECT c FROM Component c WHERE c.quantity > 0 AND c.type = 'древесина'", Component.class)
                                .getResultList();
                    }
                } finally {
                    em.close();
                }
            }

            @Override
            protected void done() {
                try {
                    List<Component> components = get();
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                    for (Component component : components) {
                        model.addElement(component.getName());
                    }
                    if (flag) {
                        comboBoxCore.setModel(model);
                    } else {
                        comboBoxWood.setModel(model);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Пополните склад",
                            "Предупреждение", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }.execute();
    }

    private void createWand() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Component core = em.find(Component.class, comboBoxCore.getSelectedItem());
            core.setQuantity(core.getQuantity() - 1);

            Component wood = em.find(Component.class, comboBoxWood.getSelectedItem());
            wood.setQuantity(wood.getQuantity() - 1);

            Wand newWand = new Wand();
            newWand.setCore(core);
            newWand.setWood(wood);
            newWand.setIsSold(false);
            newWand.setLength((Integer)spinnerLength.getValue());
            newWand.setPrice((Integer)spinnerPrice.getValue());

            em.persist(newWand);
            tx.commit();
            
            JOptionPane.showMessageDialog(null,
                            "Палочка создана",
                            "Успешно", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCreate;
    private javax.swing.JComboBox<String> comboBoxCore;
    private javax.swing.JComboBox<String> comboBoxWood;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner spinnerLength;
    private javax.swing.JSpinner spinnerPrice;
    // End of variables declaration//GEN-END:variables
}
