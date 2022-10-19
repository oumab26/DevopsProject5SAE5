package tn.esprit.achat.test;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.repositories.FactureRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AchatApplication.class)
public class SpringBootWithUnitTestApplication {

	@Autowired
	FactureRepository factureRepository;
	@Test
	public void contextLoads() throws Exception{
	
	assertThat(factureRepository.findAll()).isNotNull();
	
	}
}
