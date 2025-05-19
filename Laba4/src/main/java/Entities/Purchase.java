package Entities;

import java.security.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "wizard_id", referencedColumnName = "id")
    private Wizard wizard;

    @ManyToOne
    @JoinColumn(name = "wand_id", referencedColumnName = "id")
    private Wand wand;

    @Column(name = "amount")
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public Wand getWand() {
        return wand;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Purchase(Timestamp date, Wizard wizard, Wand wand, Integer amount) {
        this.date = date;
        this.wizard = wizard;
        this.wand = wand;
        this.amount = amount;
    }

    public Purchase() {
    }
}
