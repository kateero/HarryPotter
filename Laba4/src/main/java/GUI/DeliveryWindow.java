package GUI;

import Entities.*;
import Manager.EntityManagerHelper;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.table.JTableHeader;


public class DeliveryWindow extends javax.swing.JFrame {

    private DefaultTableModel detailsModel;
    private JFrame gf;

    public DeliveryWindow(JFrame gf) {
        this.gf = gf;
        gf.setVisible(false);
        initComponents();
        initCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDelivery = new javax.swing.JPanel();
        componentsComboBox = new javax.swing.JComboBox<>();
        addDelivery = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailsModel = new DefaultTableModel(
            new Object[]{"Компонент", "Количество", "Цена за единицу", "Итого"}, 0);
        tableAddedComponents = new javax.swing.JTable();
        quantitySpinner = new javax.swing.JSpinner(new SpinnerNumberModel(5, 1, 100, 1));
        addComponent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelDelivery.setBackground(new java.awt.Color(222, 186, 191));

        componentsComboBox.setBackground(new java.awt.Color(255, 250, 241));
        componentsComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        componentsComboBox.setForeground(new java.awt.Color(74, 48, 50));

        addDelivery.setBackground(new java.awt.Color(145, 44, 160));
        addDelivery.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        addDelivery.setForeground(new java.awt.Color(243, 229, 200));
        addDelivery.setText("Заказать");
        addDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeliveryActionPerformed(evt);
            }
        });

        tableAddedComponents.setBackground(new java.awt.Color(243, 229, 200));
        tableAddedComponents.setFillsViewportHeight(true);
        JTableHeader header = tableAddedComponents.getTableHeader();
        header.setFont(new Font("Georgia", 0, 16));
        header.setBackground(new java.awt.Color(255, 250, 241));
        tableAddedComponents.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        tableAddedComponents.setForeground(new java.awt.Color(74, 48, 50));
        tableAddedComponents.setModel(detailsModel);
        jScrollPane1.setViewportView(tableAddedComponents);

        quantitySpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        addComponent.setBackground(new java.awt.Color(145, 44, 160));
        addComponent.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        addComponent.setForeground(new java.awt.Color(243, 229, 200));
        addComponent.setText("Добавить в поставку");
        addComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComponentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDeliveryLayout = new javax.swing.GroupLayout(panelDelivery);
        panelDelivery.setLayout(panelDeliveryLayout);
        panelDeliveryLayout.setHorizontalGroup(
            panelDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeliveryLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(componentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(addComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeliveryLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(panelDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeliveryLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeliveryLayout.createSequentialGroup()
                        .addComponent(addDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243))))
        );
        panelDeliveryLayout.setVerticalGroup(
            panelDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeliveryLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(componentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(addDelivery)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComponentActionPerformed
        addComponent();
    }//GEN-LAST:event_addComponentActionPerformed

    private void addDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeliveryActionPerformed
        addDelivery();
        gf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addDeliveryActionPerformed

    private void initCombo() {
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
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                    for (Component component : components) {
                        model.addElement(component.getName());
                    }
                    componentsComboBox.setModel(model);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Ошибка загрузки компонентов",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    private void addComponent() {
        String selected = (String) componentsComboBox.getSelectedItem();
        int quantity = (Integer) quantitySpinner.getValue();
        int price = 10 + (int) (Math.random() * 90);
        int total = quantity * price;

        detailsModel.addRow(new Object[]{
            selected,
            quantity,
            price,
            total
        });
        tableAddedComponents.setModel(detailsModel);
    }

    private void addDelivery() {
        if (tableAddedComponents.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Таблица поставки пуста!",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                EntityManager em = EntityManagerHelper.getEntityManager();
                EntityTransaction tx = null;

                try {
                    tx = em.getTransaction();
                    tx.begin();

                    Delivery delivery = new Delivery();
                    int totalCost = calculateTotalCost(tableAddedComponents);
                    delivery.setDeliveryDate(LocalDate.now());
                    delivery.setCost(totalCost);

                    em.persist(delivery);

                    for (int row = 0; row < tableAddedComponents.getRowCount(); row++) {
                    String componentName = (String) tableAddedComponents.getValueAt(row, 0);
                    Integer quantity = (Integer) tableAddedComponents.getValueAt(row, 1);
                    Integer pricePerUnit = (Integer) tableAddedComponents.getValueAt(row, 2);

                    Component component = em.createQuery(
                            "SELECT c FROM Component c WHERE c.name = :name", Component.class)
                            .setParameter("name", componentName)
                            .getSingleResult();

                    DeliveryDetails details = new DeliveryDetails();
                    details.setDelivery(delivery);
                    details.setComponent(component);
                    details.setQuantity(quantity);
                    details.setPricePerUnit(pricePerUnit);
                    em.persist(details);
                    
                    component.setQuantity(component.getQuantity() + quantity);
                    em.merge(component);
                    }
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
                    JOptionPane.showMessageDialog(null,
                            "Поставка успешно оформлена!",
                            "Успех", JOptionPane.INFORMATION_MESSAGE);
                    detailsModel.setRowCount(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Ошибка при оформлении поставки",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }.execute();
    }
                
             

    private int calculateTotalCost(JTable table) {
        int total = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            total += (Integer) table.getValueAt(row, 3);
        }
        return total;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addComponent;
    private javax.swing.JButton addDelivery;
    private javax.swing.JComboBox<String> componentsComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDelivery;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTable tableAddedComponents;
    // End of variables declaration//GEN-END:variables
}
