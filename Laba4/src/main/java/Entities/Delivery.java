package Entities;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @Column(name = "cost")
    private Integer cost;

    public Integer getId() {
        return id;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public Integer getCost() {
        return cost;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Delivery(Integer cost) {
        this.cost = cost;
    }

    public Delivery() {
    }
}
