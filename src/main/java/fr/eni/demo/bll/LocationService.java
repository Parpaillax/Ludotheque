package fr.eni.demo.bll;

import fr.eni.demo.bo.Location;

public interface LocationService {
  Location findById(Long id);
  void add(Location location);
  void update(Location location);
  void updateDateEnd(String id, Location location);
  Location findByCodeBarre(String codeBarre);
}
