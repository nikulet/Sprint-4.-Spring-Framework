package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.model.services;

import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.model.domain.Fruta;
import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.repository.RepositorioFruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplementacionServicioFruta implements ServicioFruta {


    private final RepositorioFruta repositorioFruta;


    @Autowired
    public ImplementacionServicioFruta(RepositorioFruta repositorioFruta) {
        this.repositorioFruta = repositorioFruta;

    }

    @Override
    public Fruta agregar(Fruta fruta) {

        return  repositorioFruta.save(fruta);
    }

    @Override
    public Optional<Fruta> obtenerUno(String id) {
        return repositorioFruta.findById(id);
    }

    @Override
    public List<Fruta> obtenerTodas() {
        return repositorioFruta.findAll();
    }

    @Override
    public Fruta actualizar(Fruta fruta) {
        if(fruta != null && repositorioFruta.existsById(fruta.getId())) {
            return repositorioFruta.save(fruta);
        }else throw new RuntimeException("Fruta no encontrada con id " + fruta.getId());

    }

    @Override
    public void eliminar(String id) {
        repositorioFruta.deleteById(id);
    }
}
