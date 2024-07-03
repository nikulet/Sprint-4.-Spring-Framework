package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n01.S04T02N01CebanNicusor.controllers;

import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n01.S04T02N01CebanNicusor.model.domain.Fruta;
import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n01.S04T02N01CebanNicusor.model.repository.RepositorioFruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/frutas")
public class ControladorFruta {

    @Autowired
    RepositorioFruta repositorio;

    @GetMapping
    public ResponseEntity<List<Fruta>> getAll() {
        try {
            List<Fruta> frutas = new ArrayList<>();
            repositorio.findAll().forEach(frutas::add);
            if (frutas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(frutas, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fruta/{id}")
    public ResponseEntity<Fruta> getFrutaPorId(@PathVariable("id") Long id) {
        Optional<Fruta> datosFruta = repositorio.findById(id);

        if (datosFruta.isPresent()) {
            return new ResponseEntity<>(datosFruta.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/frutas")
    public ResponseEntity<Fruta> crearFruta(@RequestBody Fruta fruta) {
        try {
            Fruta _fruta = repositorio.save(new Fruta(fruta.getNombre(), fruta.getCantidad()));
            return new ResponseEntity<>(_fruta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/frutas/{id}")
    public ResponseEntity<Fruta> actualizarFruta(@PathVariable("id") Long id, @RequestBody Fruta fruta) {
        Optional<Fruta> datosFruta = repositorio.findById(id);

        if (datosFruta.isPresent()) {
            fruta = datosFruta.get();
            fruta.setNombre(fruta.getNombre());
            fruta.setCantidad(fruta.getCantidad());
            return new ResponseEntity<>(repositorio.save(fruta), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/fruta/{id}")
    public ResponseEntity<HttpStatus> borrarFruta(@PathVariable("id") long id) {
        try {
            repositorio.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/fruta")
    public ResponseEntity<HttpStatus> borrarTodasLasFrutas() {
        try {
            repositorio.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}