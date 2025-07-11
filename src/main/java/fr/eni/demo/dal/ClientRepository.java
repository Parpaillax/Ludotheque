package fr.eni.demo.dal;

import fr.eni.demo.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  List<Client> findByPrenomIgnoreCaseContainingOrNomIgnoreCaseContaining(String prenom, String nom);
}
