package fr.eni.demo.dal;

import fr.eni.demo.bo.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {

  List<Facture> findByClient(Long clientId);
  List<Facture> findByDatePayEmpty();
}
