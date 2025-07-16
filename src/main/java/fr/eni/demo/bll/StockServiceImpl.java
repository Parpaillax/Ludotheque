package fr.eni.demo.bll;

import fr.eni.demo.bo.Stock;
import fr.eni.demo.bo.StockCount;
import fr.eni.demo.dal.StockRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService{

  private StockRepository stockRepository;

  public StockServiceImpl(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  @Override
  public void add(Stock game) {
    stockRepository.save(game);
  }

  @Override
  public Optional<Stock> findById(Long gameId) {
    return stockRepository.findById(gameId);
  }

  @Override
  public List<StockCount> findAllByName(String name){
    List<Stock> stocks = stockRepository.findByNameIsContainingIgnoreCaseAndIsRentFalse(name);
    List<StockCount> result = stocks.stream()
      .collect(Collectors.groupingBy(Stock::getName, Collectors.counting()))
      .entrySet().stream()
      .map(entry -> new StockCount(entry.getKey(), entry.getValue()))
      .toList();
    return result;
  }

  @Override
  public Stock findByRef(String ref) {
    Stock stock = stockRepository.findByRefEQ(ref);
    if (stock == null) {
      throw new EntityNotFoundException("Ref non valide");
    }
    return stock;
  }

  @Override
  public void isRent(Stock stock, boolean value) {
    if (stock == null) {
      throw new EntityNotFoundException("Stock non valide");
    }
    stock.setIsRent(value);
    stockRepository.save(stock);
  }
}
