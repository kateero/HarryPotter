package GUI;

import Entities.Component;
import Entities.Delivery;
import Entities.DeliveryDetails;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addDelivery.setText("Заказать");
        addDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeliveryActionPerformed(evt);
            }
        });

        tableAddedComponents.setModel(detailsModel);
        jScrollPane1.setViewportView(tableAddedComponents);

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
                .addGroup(panelDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDeliveryLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDeliveryLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(panelDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDeliveryLayout.createSequentialGroup()
                                .addComponent(componentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(addComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panelDeliveryLayout.setVerticalGroup(
            panelDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeliveryLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(panelDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(componentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
