package fr.eni.demo.dal;

import fr.eni.demo.bo.GameType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTypeRepository extends JpaRepository<GameType, Long> {
}
