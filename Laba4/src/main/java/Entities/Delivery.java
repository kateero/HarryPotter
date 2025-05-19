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

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "cost")
    private Integer cost;

    public Integer getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public Integer getCost() {
        return cost;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Delivery(Timestamp date, Integer cost) {
        this.date = date;
        this.cost = cost;
    }

    public Delivery() {
    }
}
