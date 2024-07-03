package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class S04T02N03CebanNicusorApplication {

	public static void main(String[] args) {
		SpringApplication.run(cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n03.S04T02N03CebanNicusor.S04T02N03CebanNicusorApplication.class, args);
	}

}