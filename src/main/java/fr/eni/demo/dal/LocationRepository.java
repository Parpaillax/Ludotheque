package fr.eni.demo.dal;

import fr.eni.demo.bo.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends MongoRepository<Location, Integer> {

    Optional<Location> findByCodeBarre(String codeBarre);


}
