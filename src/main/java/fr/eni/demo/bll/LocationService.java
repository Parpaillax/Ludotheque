package fr.eni.demo.bll;

import fr.eni.demo.bo.Location;

public interface LocationService {
  Location findById(int id);
  void add(Location location);
  void updateDateEnd(int id, Location location);
}
