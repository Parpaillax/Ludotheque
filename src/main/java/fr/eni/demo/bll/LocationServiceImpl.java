package fr.eni.demo.bll;

import fr.eni.demo.bo.Location;
import fr.eni.demo.dal.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
  private LocationRepository locationRepository;

  public LocationServiceImpl(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  @Override
  public void add(Location location) {
    locationRepository.save(location);
  }
}
