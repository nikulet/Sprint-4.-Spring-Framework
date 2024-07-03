package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.controllers;

import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.model.domain.Fruit;
import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/fruats")
public class FruitController {
    @Autowired
   private FruitRepository repository;

    //getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll(@RequestParam(required = false) String name) {
        try {
            List<Fruit> fruits = new ArrayList<Fruit>();
            repository.findAll().forEach(fruits::add);
            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else
                return new ResponseEntity<>(fruits, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //getOne
    @GetMapping("/fruta/{id}")
    public ResponseEntity<Fruit> getFruitByID(@PathVariable("id") long id) {
        Optional<Fruit> fruitData = repository.findById(id);

        if (fruitData.isPresent()) {
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public  ResponseEntity<Fruit> createNewFruit(@RequestBody Fruit fruit) {
        try {
            Fruit _fruit = repository
                    .save(new Fruit(fruit.getName(), fruit.getQuantityKG()));
            return new ResponseEntity<>(_fruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        @PutMapping("/frutas/{id}")
        public ResponseEntity<Fruit> updateFruit(@PathVariable("id") long id, @RequestBody Fruit fruit) {
            Optional<Fruit> fruitData = repository.findById(id);

            if (fruitData.isPresent()) {
                Fruit _fruit = fruitData.get();
                _fruit.setName(fruit.getName());
                _fruit.setQuantityKG(fruit.getQuantityKG());
                return new ResponseEntity<>(repository.save(_fruit), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/fruit/{id}")
        public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") long id) {

            try {
                repository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @DeleteMapping("/fruit")
        public ResponseEntity<HttpStatus> deleteAllFruit() {
            try {
                repository.deleteAll();
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

