package Entities;

import javax.persistence.*;

@Entity
@Table(name = "deliverydetails")
public class DeliveryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "id", nullable = false)
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "component_name", referencedColumnName = "name", nullable = false)
    private Component component;

    @Column(name = "component_quantity", nullable = false)
    private Integer quantity;

    @Column(name = "component_unit_price")
    private Integer pricePerUnit;

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPricePerUnit() {
        return pricePerUnit;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Component getComponent() {
        return component;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPricePerUnit(Integer pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public DeliveryDetails(Delivery delivery, Component component, Integer quantity, Integer pricePerUnit) {
        this.delivery = delivery;
        this.component = component;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public DeliveryDetails() {
    }

}
