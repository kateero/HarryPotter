package Entities;

import javax.persistence.*;

@Entity
@Table(name = "wizard")
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "first_name", length = 30)
    private String firstName;

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Wizard() {
    }

    public Wizard(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
