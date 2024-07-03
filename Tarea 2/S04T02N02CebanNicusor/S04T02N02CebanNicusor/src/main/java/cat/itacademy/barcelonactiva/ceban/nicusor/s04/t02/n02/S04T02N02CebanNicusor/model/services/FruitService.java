package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.model.services;


import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.model.domain.Fruit;

import java.util.Optional;

public interface FruitService {
    public Fruit add(Fruit fruit);
    public Fruit update(Fruit fruit);
    public void deleteById(long id);
    public Iterable<Fruit> getAll();
    public Optional<Fruit>getOne(Long id);




}
