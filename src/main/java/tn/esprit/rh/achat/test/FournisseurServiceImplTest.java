package tn.esprit.rh.achat.test;



import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import org.junit.jupiter.api.Test;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class FournisseurServiceImplTest {

    @InjectMocks
    FournisseurServiceImpl  fournisseurService ;

    @Mock
    DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    FournisseurRepository fournisseurRepository;

    @Test
    public void testGetallFournisseurs(){
        when(fournisseurRepository.findAll()).thenReturn(Stream
                .of(new Fournisseur(), new Fournisseur()).collect(Collectors.toList()));
        assertEquals(2, fournisseurService.retrieveAllFournisseurs().size());
    }

    @Test
    public void AddFournisseurTest(){
        Fournisseur four = new Fournisseur();
        when(fournisseurRepository.save(four)).thenReturn(four);
        assertEquals(four, fournisseurService.addFournisseur(four));
    }

    @Test
    public void deleteFournisseurTest(){
        Fournisseur four = new Fournisseur();
        fournisseurService.deleteFournisseur(four.getIdFournisseur());
        verify(fournisseurRepository, times(1)).deleteById(four.getIdFournisseur());
    }

    @Test
    public void testUpdateFournisseur(){
        Fournisseur four = new Fournisseur();
        DetailFournisseur df = new DetailFournisseur();
        four.setDetailFournisseur(df);
        when(fournisseurRepository.save(four)).thenReturn(four);
        assertEquals(four, fournisseurService.updateFournisseur(four));
    }

    @Test
    public void testGetFournisseur(){
        Fournisseur four = new Fournisseur();
        when(fournisseurRepository.findById(four.getIdFournisseur())).thenReturn(Optional.of(four));
        assertEquals(four, fournisseurService.retrieveFournisseur(four.getIdFournisseur()));
    }

}
