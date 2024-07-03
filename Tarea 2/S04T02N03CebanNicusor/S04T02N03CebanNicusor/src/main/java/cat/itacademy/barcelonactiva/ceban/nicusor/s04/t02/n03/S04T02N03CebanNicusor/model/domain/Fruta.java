package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "frutas")
public class Fruta {

    @Id
    private String id;
    private String nombre;
    private int cantidadKG;

    public Fruta() {
    }

    public Fruta(String nombre, int cantidadKG) {
        this.nombre = nombre;
        this.cantidadKG = cantidadKG;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadKG() {
        return cantidadKG;
    }

    public void setCantidadKG(int cantidadKG) {
        this.cantidadKG = cantidadKG;
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadKG=" + cantidadKG +
                '}';
    }
}
