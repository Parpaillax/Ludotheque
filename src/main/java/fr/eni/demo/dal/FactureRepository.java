package fr.eni.demo.dal;

import fr.eni.demo.bo.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
