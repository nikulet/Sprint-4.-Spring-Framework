package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n01.S04T02N01CebanNicusor;

import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n01.S04T02N01CebanNicusor.model.domain.Fruta;
import cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n01.S04T02N01CebanNicusor.model.repository.RepositorioFruta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class S04T02N01CebanNicusorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contextoAplicacion =
				SpringApplication.run(S04T02N01CebanNicusorApplication.class, args);
		RepositorioFruta repositorioFruta = contextoAplicacion.getBean(RepositorioFruta.class);
		Fruta fruta = new Fruta("Banana", 15);
		repositorioFruta.save(fruta);
	}
}