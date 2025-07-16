package fr.eni.demo.bll;

import fr.eni.demo.bo.Location;
import fr.eni.demo.dal.LocationRepository;
import org.springframework.stereotype.Service;

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
    stockService.isRent(location.getStock(), true);
  }

  @Override
  public void update(Location location) {
    locationRepository.save(location);
    stockService.isRent(location.getStock(), false);
  }
}
