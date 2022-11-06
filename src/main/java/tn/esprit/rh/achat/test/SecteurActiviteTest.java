package tn.esprit.rh.achat.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class SecteurActiviteTest {

	  @Autowired
	    ISecteurActiviteService secteurService;


	    @Test
	    @Order(1)
	     void testRetrieveAllSecteur() {
	        List<SecteurActivite> allSActivite = secteurService.retrieveAllSecteurActivite();
	        assertEquals(0, allSActivite.size());


	    }
	    
	    @Test
	    @Order(2)
	     void testaddSecteur(){
	    	SecteurActivite sec = secteurService.addSecteurActivite(SecteurActivite.builder()
	                .codeSecteurActivite("1212")
	                .libelleSecteurActivite("couture")        
	                .build());
	        Assertions.assertNotNull(sec);


	    }
	    
	    @Test
	    @Order(3)
	     void testdeleteSecteur(){
	    	SecteurActivite sec = secteurService.addSecteurActivite(SecteurActivite.builder()
	    			 .codeSecteurActivite("2012")
		              .libelleSecteurActivite("couture") 
	               .build());
	    	secteurService.deleteSecteurActivite(sec.getIdSecteurActivite());
	        Assertions.assertNull(secteurService.retrieveSecteurActivite(sec.getIdSecteurActivite()));

	    }
	    
	    @Test
	    @Order(4)
	     void testretrieveSecteur(){
	    	SecteurActivite sec = secteurService.addSecteurActivite(SecteurActivite.builder()
	    			 .codeSecteurActivite("2022")
		              .libelleSecteurActivite("couture") 
	               .build());
	    	    Assertions.assertEquals(sec.getIdSecteurActivite() , secteurService.retrieveSecteurActivite(sec.getIdSecteurActivite()).getIdSecteurActivite()) ;
	    }
	    
	    @Test
	    @Order(5)
	     void tesupdateSecteur(){
	    	SecteurActivite sec = secteurService.addSecteurActivite(SecteurActivite.builder()
	    			 .codeSecteurActivite("2022")
		              .libelleSecteurActivite("couture") 
	               .build());
	        sec.setCodeSecteurActivite("8080");
	        secteurService.updateSecteurActivite(sec);
	        Assertions.assertEquals("8080", secteurService.updateSecteurActivite(sec).getCodeSecteurActivite());

	    }
}
