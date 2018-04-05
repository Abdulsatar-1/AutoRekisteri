package fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PolttoaineRepository extends CrudRepository<Polttoaine, Long>  {

	List<Polttoaine> findByName(String name);
	
}
