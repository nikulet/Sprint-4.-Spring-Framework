package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.model.services;


import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.model.domain.Fruta;

import java.util.List;
import java.util.Optional;

public interface ServicioFruta {
    Fruta agregar(Fruta fruta);
    Optional<Fruta> obtenerUno(String id);
    List<Fruta> obtenerTodas();
    Fruta actualizar(Fruta fruta);
    void eliminar(String id);
}
