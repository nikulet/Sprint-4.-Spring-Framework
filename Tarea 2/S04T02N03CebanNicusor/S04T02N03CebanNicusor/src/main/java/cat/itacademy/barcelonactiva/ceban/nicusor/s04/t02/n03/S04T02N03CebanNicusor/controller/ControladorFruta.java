package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.controller;


import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.model.domain.Fruta;
import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.model.services.ServicioFruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/frutas")
public class ControladorFruta {

    @Autowired
    private ServicioFruta servicioFruta;


    @PostMapping("/agregar")
    public ResponseEntity<Fruta> agregarFruta(@RequestBody Fruta fruta) {
        Fruta frutaCreada = servicioFruta.agregar(fruta);
        return new ResponseEntity<>(frutaCreada, HttpStatus.CREATED);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Fruta> obtenerFruta(@PathVariable String id) {
        Optional<Fruta> fruta = servicioFruta.obtenerUno(id);
        return fruta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/obtenerTodas")
    public ResponseEntity<List<Fruta>> obtenerTodasFrutas() {
        List<Fruta> frutas = servicioFruta.obtenerTodas();
        return ResponseEntity.ok().body(frutas);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Fruta> actualizarFruta(@PathVariable String id, @RequestBody Fruta fruta) {
        Fruta frutaActualizada = servicioFruta.actualizar(fruta);
        return ResponseEntity.ok().body(frutaActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarFruta(@PathVariable String id) {
        if (servicioFruta.obtenerUno(id).isPresent()) {
            servicioFruta.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
