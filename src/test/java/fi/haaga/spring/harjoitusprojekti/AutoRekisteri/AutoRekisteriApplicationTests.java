package fi.haaga.spring.harjoitusprojekti.AutoRekisteri;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haaga.spring.harjoitusprojekti.AutoRekisteri.web.AutoController;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoRekisteriApplicationTests {
	
	
	@Autowired
    private AutoController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}



 