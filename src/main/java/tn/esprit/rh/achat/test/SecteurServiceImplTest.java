package tn.esprit.rh.achat.test;


import org.junit.jupiter.api.Test;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurServiceImplTest {
	
	   @Autowired
	    private SecteurActiviteServiceImpl secteurService;


	    @MockBean
	    private SecteurActiviteRepository secteurRepository;
	 
	    
	    @Test
	    public void retrieveAllSecteursTest(){
	        when(secteurRepository.findAll()).thenReturn(Stream.of(new SecteurActivite(),new SecteurActivite(),new SecteurActivite()).collect(Collectors.toList()))
	        ;        assertEquals(3,secteurService.retrieveAllSecteurActivite().size());
	    }
	    
	    
	    @Test
	    public void addSecteurActiviteTest(){
	    	SecteurActivite SecteurActivite = new SecteurActivite();
	        when(secteurRepository.save(SecteurActivite)).thenReturn(SecteurActivite);
	        assertEquals(SecteurActivite,secteurService.addSecteurActivite(SecteurActivite));
	    }
	
	    @Test
	    public void retrieveSecteurActiviteTest(){
	    	SecteurActivite SecteurActivite = new SecteurActivite();
	        when(secteurRepository.findById(SecteurActivite .getIdSecteurActivite())).thenReturn(java.util.Optional.of(SecteurActivite));
	        assertEquals(SecteurActivite .getIdSecteurActivite(),secteurService.retrieveSecteurActivite(SecteurActivite.getIdSecteurActivite()).getIdSecteurActivite());
	    }
	    

	    @Test
	    public void updateSecteurActivite(){
	    	SecteurActivite SecteurActivite = new SecteurActivite();
	        when(secteurRepository.save(SecteurActivite)).thenReturn(SecteurActivite);
	        assertEquals(SecteurActivite,secteurService.updateSecteurActivite(SecteurActivite));
	    }
	    
	    @Test
	    public void deleteSecteurActiviteTest(){
	        SecteurActivite SecteurActivite = new SecteurActivite();
	        secteurService.deleteSecteurActivite(SecteurActivite.getIdSecteurActivite());
	        verify(secteurRepository, times(1)).deleteById(SecteurActivite.getIdSecteurActivite());
	    
	    }

   
}
