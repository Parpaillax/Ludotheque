package fr.eni.demo.bll;

import fr.eni.demo.bo.Location;
import fr.eni.demo.dal.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

  @Autowired
  LocationRepository locationRepository;

  public void add(Location location) {
    if (location.getRue() == null || location.getCodePostal() == null || location.getVille() == null) {
      Location locationTest = new Location();
      locationTest.setRue("18 Rue de la Paix");
      locationTest.setCodePostal("75000");
      locationTest.setVille("Paris");
      locationRepository.save(locationTest);
    } else {
      locationRepository.save(location);
    }
  }
}
