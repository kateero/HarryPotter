package Entities;

import javax.persistence.*;

@Entity
@Table(name = "component")
public class Component {

    @Id
    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "quantity")
    private Integer quantity;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Component(String name, String type, Integer quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public Component() {
    }   

    @Override
    public String toString() {
        return name;
    }
    
    
}
