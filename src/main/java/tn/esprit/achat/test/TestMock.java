package tn.esprit.achat.test;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.IFactureService;

 @ExtendWith(MockitoExtension.class)
 public class TestMock {

     @Mock
     FactureRepository factureRepository;
     
     @InjectMocks
     IFactureService factureService;
   
     @Test
          public void shouldDoSomething() {
    	 factureService.retrieveAllFactures();
          }
    		 
    		 
    		 
    		 
 }
 
