package tn.esprit.rh.achat.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Produit;
import org.junit.jupiter.api.Test;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
class ProduitServiceImplTest {

    @InjectMocks
    ProduitServiceImpl  produitService ;

    @Mock
    ProduitRepository produitRepository ;

    @Test
    public void testGetallProducts(){
        when(produitRepository. findAll()).thenReturn(Stream
                .of(new Produit(), new Produit()).collect(Collectors.toList()));
        assertEquals(2, produitService.retrieveAllProduits().size());
    }

    @Test
    public void addProduitTest(){
        Produit prod = new Produit();
        when(produitRepository.save(prod)).thenReturn(prod);
        assertEquals(prod, produitService.addProduit(prod));
    }

    @Test
    public void deleteUserTest(){
        Produit prod = new Produit();
        produitService.deleteProduit(prod.getIdProduit());
        verify(produitRepository, times(1)).deleteById(prod.getIdProduit());
    }

    @Test
    public void testUpdateProduct(){
        Produit prod = new Produit();
        when(produitRepository.save(prod)).thenReturn(prod);
        assertEquals(prod, produitService.updateProduit(prod));
    }

    @Test
    public void testGetProduct(){
        Produit prod = new Produit();
        when(produitRepository.findById(prod.getIdProduit())).thenReturn(Optional.of(prod));
        assertEquals(prod, produitService.retrieveProduit(prod.getIdProduit()));
    }


}
