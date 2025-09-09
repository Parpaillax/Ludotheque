package fr.eni.demo.bll;

import fr.eni.demo.bo.Stock;
import fr.eni.demo.bo.StockCount;

import java.util.List;
import java.util.Optional;

public interface StockService {
  void add(Stock game);
  Optional<Stock> findById(Long gameId);
  List<StockCount> findAllByName(String name);
  Stock findByRef(String ref);
  void isRent(Stock stock, boolean value);
  void update(Stock stock);
  void delete(Stock stock);
}

