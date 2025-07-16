package fr.eni.demo.dal;

import fr.eni.demo.bo.GameType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTypeRepository extends MongoRepository<GameType, Long> {
}
