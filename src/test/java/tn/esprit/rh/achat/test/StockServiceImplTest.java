package tn.esprit.rh.achat.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

@RunWith(SpringRunner.class)
public class StockServiceImplTest {

	@InjectMocks
	private StockServiceImpl stockService;

	@Mock
	private StockRepository stockRepository;

	@Test
	public void testRetrieveAllStocks() {
		when(stockRepository.findAll())
				.thenReturn(Stream.of(new Stock(), new Stock(), new Stock()).collect(Collectors.toList()));
		assertEquals(3, stockService.retrieveAllStocks().size());
	}

	@Test
	public void testAddStock() {
		Stock stock = new Stock();
		when(stockRepository.save(stock)).thenReturn(stock);
		assertEquals(stock, stockService.addStock(stock));
	}

	@Test
	public void testDeleteStock() {
		Stock stock = new Stock();
		stockService.deleteStock(stock.getIdStock());
		verify(stockRepository, times(1)).deleteById(stock.getIdStock());
	}

	@Test
	public void testUpdateStock() {
		Stock stock = new Stock();
		when(stockRepository.save(stock)).thenReturn(stock);
		assertEquals(stock, stockService.updateStock(stock));
	}

	@Test
	public void testRetrieveStock() {
		Stock stock = new Stock();
		when(stockRepository.findById(stock.getIdStock())).thenReturn(java.util.Optional.of(stock));
		assertEquals(stock.getIdStock(), stockService.retrieveStock(stock.getIdStock()).getIdStock());
	}



}
