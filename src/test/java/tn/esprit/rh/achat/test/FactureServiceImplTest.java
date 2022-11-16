package tn.esprit.rh.achat.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import java.util.Date;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {
    @InjectMocks
    FactureServiceImpl factureService ;

    @Mock
    FactureRepository factureRepository ;

    @Test
    public void testGetallFactures(){
        when(factureRepository. findAll()).thenReturn(Stream
                .of(new Facture(), new Facture()).collect(Collectors.toList()));
        assertEquals(2, factureService.retrieveAllFactures().size());
    }

    @Test
    public void saveFactureTest() {
        Facture f = new Facture(29.75f,153.31f,new Date("19/10/2022"),new Date("21/10/2022"),true,null,null,null);
        when(factureRepository.save(f)).thenReturn(f);
        assertEquals(f, factureService.addFacture(f));
    }

    @Test
    public void retrieveFactureTest() {
        Long id = (long) 3;
        when(factureRepository.findById(id)).thenReturn(Optional.of(new Facture(32.65f,164.84f,new Date("15/10/2022"),new Date("23/10/2022"),true,null,null,null)));
        Facture f = factureService.retrieveFacture(id);
        assertNotNull(f);
        verify(factureRepository).findById(Mockito.anyLong());
    }
}