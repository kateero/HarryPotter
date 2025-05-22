package Entities;

import java.security.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cost")
    private Integer cost;

    public Integer getId() {
        return id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setId(Integer id) {
        this.id = id;
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
