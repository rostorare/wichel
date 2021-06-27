package htw.berlin.wichteln;


import htw.berlin.wichteln.model.Person;
import htw.berlin.wichteln.jpa.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class WichtelnApplication {

	private static final Logger log = LoggerFactory.getLogger(WichtelnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WichtelnApplication.class, args);
	}
	@Bean
	public CommandLineRunner exampleData(PersonRepository repository){
		return (args) -> {
			//example persons

		//	repository.save(new Person("max", "maxmail"));
		//	repository.save(new Person("mwangi", "mwangismail"));
		//	repository.save(new Person("dio", "ZEWAURDOMAIL"));
		//	repository.save(new Person("frank", "frankysmail"));




		//	log.info("get all persons");
		//	for(Person person : repository.findAll()){
		//		log.info(person.toString());

				//rest des tutorials geskipped
				//do i need @ComponentScan,@EnableAutoConfiguration,@Configuration???
		//	}
		};
	}

}
