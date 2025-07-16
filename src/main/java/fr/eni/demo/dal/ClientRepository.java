package fr.eni.demo.dal;

import fr.eni.demo.bo.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, Long> {
  List<Client> findByPrenomIgnoreCaseContainingOrNomIgnoreCaseContaining(String prenom, String nom);
}
