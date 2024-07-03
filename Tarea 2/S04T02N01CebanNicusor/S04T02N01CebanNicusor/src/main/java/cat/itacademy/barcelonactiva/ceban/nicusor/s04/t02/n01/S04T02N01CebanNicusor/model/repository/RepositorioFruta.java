package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n01.S04T02N01CebanNicusor.model.repository;

import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n01.S04T02N01CebanNicusor.model.domain.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioFruta extends JpaRepository<Fruta, Long> {
   List<Fruta> findById(int id);
   List<Fruta> findByNombre(String nombre);
}
