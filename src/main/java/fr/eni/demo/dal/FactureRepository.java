package fr.eni.demo.dal;

import fr.eni.demo.bo.Facture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends MongoRepository<Facture,Long> {

  List<Facture> findByClient(Long clientId);
  List<Facture> findByDatePayEmpty();
}
