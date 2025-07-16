package fr.eni.demo.bll;

import fr.eni.demo.bo.Location;
import fr.eni.demo.dal.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LocationServiceImpl implements LocationService {

  private final LocationRepository locationRepository;

  public LocationServiceImpl(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  @Override
  public Location findById(Long id) {
    return locationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Location non trouvée"));
  }

  @Override
  public void add(Location location) {
    locationRepository.save(location);
  }

  @Override
  public void updateDateEnd(String id, Location location) {
    Location existing = findById(Long.valueOf(id));
    location.setId(existing.getId());
    location.setEndDate(new Date());
    locationRepository.save(location);
  }

}
