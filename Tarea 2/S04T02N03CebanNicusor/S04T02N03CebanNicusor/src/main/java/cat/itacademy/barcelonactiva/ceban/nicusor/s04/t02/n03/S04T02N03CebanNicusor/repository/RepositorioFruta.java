package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.repository;


import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.model.domain.Fruta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioFruta extends MongoRepository<Fruta, String> {
}
