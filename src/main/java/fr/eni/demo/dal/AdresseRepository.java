package fr.eni.demo.dal;

import fr.eni.demo.bo.Adresse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends MongoRepository<Adresse, Long> {
}
