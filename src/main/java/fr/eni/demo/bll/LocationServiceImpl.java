package fr.eni.demo.bll;

import fr.eni.demo.bo.Location;
import fr.eni.demo.dal.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class LocationServiceImpl implements LocationService {

  private final LocationRepository locationRepository;
  private StockService stockService;

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
    stockService.isRent(location.getStock(), true);
  }

  @Override
  public void updateDateEnd(String id, Location location) {
    Location existing = findById(Long.valueOf(id));
    location.setId(existing.getId());
    location.setEndDate(new Date());
    locationRepository.save(location);
  }

  @Override
  public Location findByCodeBarre(String codeBarre) {
    return locationRepository.findByCodeBarre(codeBarre)
            .orElseThrow(() -> new NoSuchElementException("Code-barre inconnu : " + codeBarre));
  }

}
