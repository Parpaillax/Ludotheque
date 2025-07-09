package fr.eni.demo.bll;

import fr.eni.demo.bo.Stock;
import fr.eni.demo.dal.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

  @Autowired
  private StockRepository stockRepository;

  public void add(Stock stock) {
    stockRepository.save(stock);
  }

  public Optional<Stock> findById(Long gameId) {
    return stockRepository.findById(gameId);
  }
}
