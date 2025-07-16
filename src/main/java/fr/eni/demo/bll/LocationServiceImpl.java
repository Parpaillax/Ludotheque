package fr.eni.demo.bll;

import fr.eni.demo.bo.Location;
import fr.eni.demo.dal.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LocationServiceImpl implements LocationService {
  private LocationRepository locationRepository;
  private StockService stockService;

  public LocationServiceImpl(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  @Override
  public void add(Location location) {
    locationRepository.save(location);
  }

  @Override
  public Location findByCodeBarre(String codeBarre) {
    return locationRepository.findByCodeBarre(codeBarre)
            .orElseThrow(() -> new NoSuchElementException("Code-barre inconnu : " + codeBarre));
  }
}
