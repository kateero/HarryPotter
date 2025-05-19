package Entities;

import javax.persistence.*;

@Entity
@Table(name = "wand")
public class Wand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "core_name", referencedColumnName = "name")
    private Component core;

    @ManyToOne
    @JoinColumn(name = "wood_name", referencedColumnName = "name")
    private Component wood;

    @Column(name = "length")
    private Integer length;

    @Column(name = "price")
    private Integer price;

    @Column(name = "sale_status")
    private Boolean isSold;

    public Integer getId() {
        return id;
    }

    public Component getCore() {
        return core;
    }

    public Component getWood() {
        return wood;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getPrice() {
        return price;
    }

    public Boolean getIsSold() {
        return isSold;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCore(Component core) {
        this.core = core;
    }

    public void setWood(Component wood) {
        this.wood = wood;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setIsSold(Boolean isSold) {
        this.isSold = isSold;
    }

    public Wand(Component core, Component wood, Integer length, Integer price, Boolean isSold) {
        this.core = core;
        this.wood = wood;
        this.length = length;
        this.price = price;
        this.isSold = isSold;
    }

    public Wand() {
    }
}
