package fr.eni.demo.bll;

import fr.eni.demo.bo.Stock;

import java.util.Optional;

public interface StockService {
  void add(Stock game);
  Optional<Stock> findById(Long gameId);
}

