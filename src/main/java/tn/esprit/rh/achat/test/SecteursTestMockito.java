package tn.esprit.rh.achat.test;


import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SecteursTestMockito {
	
	    @InjectMocks
	    private SecteurActiviteServiceImpl SecteurService;


	    @Mock
	    private SecteurActiviteRepository SecteurRepository;
	    
	    @Test
	     void RetrieveSecteurActiviteTest() {

	        SecteurActivite s = new SecteurActivite(1L, "1","informatique",null);
	        s.setIdSecteurActivite(1L);

	        Mockito.when(SecteurRepository.findById(1L)).thenReturn(Optional.of(s));
	        SecteurService.retrieveSecteurActivite(1L);
	        Assertions.assertNotNull(s);

	        System.out.println(s);

	    }
	    @Test
	     void AddSecteurActiviteTest()
	    {

	        SecteurActivite sec = new SecteurActivite(null,"2","nature",null);
	        sec.setIdSecteurActivite(2L);
	        SecteurService.addSecteurActivite(sec);
	        verify(SecteurRepository, times(1)).save(sec);
	        System.out.println(sec);

	    }
	    @Test
	     void getAllSecteursTest()
	    {
	        List<SecteurActivite> Secteurs = new ArrayList<SecteurActivite>() {

	            {
	                add(new SecteurActivite(null,"3","info",null));
	                add(new SecteurActivite(null,"4","sante",null));
	                add(new SecteurActivite(null,"5","education",null));
	            }};
	        when(SecteurService.retrieveAllSecteurActivite()).thenReturn(Secteurs);
	        List<SecteurActivite> sList = SecteurService.retrieveAllSecteurActivite();
	        assertEquals(3, sList.size());


	    }

	    
	    @Test
	    public void updateSecteurTest(){
	    	SecteurActivite SecteurActivite = new SecteurActivite(null,"7","info",null);
	       
	    	when(SecteurRepository.save(SecteurActivite)).thenReturn(SecteurActivite);
	      
	    	assertEquals(SecteurActivite,SecteurService.updateSecteurActivite(SecteurActivite));  
	    	 System.out.println(SecteurActivite);
	    }
	    
	    @Test
	     void DeleteSecteurTest(){

	        SecteurActivite se1 = new SecteurActivite(null,"3","info",null);
	        se1.setIdSecteurActivite(10L);

	        Mockito.lenient().when(SecteurRepository.findById(se1.getIdSecteurActivite())).thenReturn(Optional.of(se1));

	        SecteurService.deleteSecteurActivite(10L);
	        verify(SecteurRepository).deleteById(se1.getIdSecteurActivite());

	        System.out.println(se1);

	    }

   
}
