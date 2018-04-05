package fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface AutoRepository extends CrudRepository<Auto, Long> {
	
	List<Auto> findById(long id);
}

