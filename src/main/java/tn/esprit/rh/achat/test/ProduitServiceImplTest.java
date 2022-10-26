package tn.esprit.rh.achat.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Produit;
import org.junit.jupiter.api.Test;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProduitServiceImplTest {

    @Autowired
    ProduitServiceImpl  produitService ;

    @MockBean
    ProduitRepository produitRepository ;

    @Test
    public void testGetallProducts() {
        when(produitRepository. findAll()).thenReturn(Stream
                .of(new Produit(), new Produit()).collect(Collectors.toList()));
        assertEquals(2, produitService.retrieveAllProduits().size());

    }

    @Test
    public void AddProduitTest() {
        Produit prod = new Produit();
        when(produitRepository.save(prod)).thenReturn(prod);
        assertEquals(prod, produitService.addProduit(prod));
    }

    @Test
    public void deleteUserTest() {
        Produit prod = new Produit();
       // Produit prod1 = new Produit();
        produitService.deleteProduit(prod.getIdProduit());
       // produitService.deleteProduit(prod1.getIdProduit());
        verify(produitRepository, times(1)).deleteById(prod.getIdProduit());

    }

    @Test
    public void testUpdateProduct() {
        Produit prod = new Produit();
        when(produitRepository.save(prod)).thenReturn(prod);
        assertEquals(prod, produitService.updateProduit(prod));
    }

    @Test
    public void testGetProduct() {

        Produit prod = new Produit();
       // Produit prod1 = new Produit();
        when(produitRepository.findById(prod.getIdProduit())).thenReturn(Optional.of(prod));
        assertEquals(prod, produitService.retrieveProduit(prod.getIdProduit()));



    }


    }
