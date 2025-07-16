package fr.eni.demo.dal;

import fr.eni.demo.bo.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends MongoRepository<Stock,Long> {
  List<Stock> findByNameIsContainingIgnoreCase(String name);
}
