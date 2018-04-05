package fi.haaga.spring.harjoitusprojekti.AutoRekisteri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain.Auto;
import fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain.AutoRepository;
import fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain.Polttoaine;
import fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain.PolttoaineRepository;




@SpringBootApplication
public class  AutoRekisteriApplication   {
	private static final Logger log = LoggerFactory.getLogger(AutoRekisteriApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(AutoRekisteriApplication.class, args);}
	
	@Bean
	public CommandLineRunner autoDemo(AutoRepository repository, PolttoaineRepository prepository){
		return args -> {
			log.info("save a couple of autos");
			prepository.save(new Polttoaine("Bensiini"));
			prepository.save(new Polttoaine("Diesel"));
			prepository.save(new Polttoaine("Hybridi"));
			
			
			repository.save(new Auto(0, "Alfa Romeo", "Juliette", 2013, "25 656€", prepository.findByName("Diesel").get(0)));
			repository.save(new Auto(0, "Audi", "RS5 ", 2017, "125 656 €", prepository.findByName("Bensiini").get(0)));
			
			log.info("fetch all autos");
			for (Auto auto : repository.findAll()) {
				log.info(auto.toString());
			}
		};
	}
	
	}



