package fr.eni.demo.dal;

import fr.eni.demo.bo.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock,Long> {
}
