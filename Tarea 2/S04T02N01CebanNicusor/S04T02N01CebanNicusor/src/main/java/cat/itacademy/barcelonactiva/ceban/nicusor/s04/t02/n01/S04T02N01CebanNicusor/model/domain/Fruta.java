package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n01.S04T02N01CebanNicusor.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fruta")
public class Fruta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad")
    private int cantidad;

    public Fruta() {
    }

    public Fruta(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Fruta " +
                "id " + id +
                ", nombre '" + nombre + '\'' +
                ", cantidad " + cantidad +
                " porción";
    }
}