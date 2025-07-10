package fr.eni.demo.bll;

import fr.eni.demo.bo.Stock;
import fr.eni.demo.dal.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
