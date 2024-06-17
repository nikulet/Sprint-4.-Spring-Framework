package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t01.n02.S04T01N02CebanNicusor.controler;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldControler {
    @GetMapping("/HelloWorld")
    public String saluda(@RequestParam(name = "nombre", defaultValue = "UNKNOWN") String nombre) {
        return "Hola, " + nombre + " estás ejecutando un proyecto Gradle.";
    }

    @GetMapping({"/HelloWorld2", "/HelloWorld2/{nombre}"})
    public String saluda2(@PathVariable(required = false) String nombre) {
        if (nombre == null) nombre = "UNKNOWN";
        return "Hola, " + nombre + ". estás ejecutando un proyecto Gradle.";
    }
}
