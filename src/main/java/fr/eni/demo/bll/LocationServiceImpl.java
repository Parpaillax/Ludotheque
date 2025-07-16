package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Location;
import fr.eni.demo.dal.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LocationServiceImpl implements LocationService {

  private LocationRepository locationRepository;

  public LocationServiceImpl(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  @Override
  public Location findById(int id) {
    return locationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Location non trouvée"));
  }

  @Override
  public void add(Location location) {
    locationRepository.save(location);
  }

  @Override
  public void updateDateEnd(int id, Location location) {
    Location existing = findById(id);
    location.setId(existing.getId());
    location.setEndDate(new Date());
    locationRepository.save(location);
  }

}
