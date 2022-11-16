package tn.esprit.rh.achat.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class OperateurServiceImplTest {


    @InjectMocks
    private OperateurServiceImpl operateurService;


    @Mock
    private OperateurRepository operateurRepository;

    @Test
    public void retrieveAllOperateursTest(){
        when(operateurRepository.findAll()).thenReturn(Stream.of(new Operateur(),new Operateur(),new Operateur()).collect(Collectors.toList()))
        ;        assertEquals(3,operateurService.retrieveAllOperateurs().size());
    }

    @Test
    public void addOperateurTest(){
        Operateur operateur = new Operateur();
        when(operateurRepository.save(operateur)).thenReturn(operateur);
        assertEquals(operateur,operateurService.addOperateur(operateur));
    }


    @Test
    public void deleteOperateurTest(){
        Operateur operateur = new Operateur();
        Operateur operateur1 = new Operateur();
        operateurService.deleteOperateur(operateur.getIdOperateur());
        operateurService.deleteOperateur(operateur1.getIdOperateur());
        verify(operateurRepository, times(2)).deleteById(operateur.getIdOperateur());
    }


    @Test
    public void updateOperateur(){
        Operateur operateur = new Operateur();
        when(operateurRepository.save(operateur)).thenReturn(operateur);
        assertEquals(operateur,operateurService.updateOperateur(operateur));
    }


    @Test
    public void retrieveOperateurTest(){
        Operateur operateur = new Operateur();
        when(operateurRepository.findById(operateur.getIdOperateur())).thenReturn(java.util.Optional.of(operateur));
        assertEquals(operateur.getIdOperateur(),operateurService.retrieveOperateur(operateur.getIdOperateur()).getIdOperateur());
    }
}