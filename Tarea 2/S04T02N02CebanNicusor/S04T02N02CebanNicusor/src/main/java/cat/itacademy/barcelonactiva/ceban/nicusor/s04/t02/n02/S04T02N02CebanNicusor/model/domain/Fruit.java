package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fruit")
    private String name;

    @Column(name = "quantityKG")
    private Integer quantityKG;

    public Fruit() {
    }

    public Fruit(String name, Integer quantityKG) {
        this.name = name;
        this.quantityKG = quantityKG;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantityKG() {
        return quantityKG;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantityKG(Integer quantityKG) {
        this.quantityKG = quantityKG;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantityKG=" + quantityKG +
                '}';
    }
}
