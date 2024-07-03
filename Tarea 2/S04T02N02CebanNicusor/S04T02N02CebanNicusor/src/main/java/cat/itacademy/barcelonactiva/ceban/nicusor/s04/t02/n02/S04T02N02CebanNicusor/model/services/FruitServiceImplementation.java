package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.model.services;

import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.model.domain.Fruit;
import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.model.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FruitServiceImplementation implements FruitService{
    private FruitRepository fruitRepository;

    @Override
    public Fruit add(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit update(Fruit fruit) {
        return fruitRepository.getReferenceById(fruit.getId());
    }

    @Override
    public void deleteById(long id) {
Optional<Fruit> deletingFruit = fruitRepository.findById(id);
    }

    @Override
    public Iterable<Fruit> getAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Optional<Fruit> getOne(Long id) {
        return Optional.empty();
    }
}
