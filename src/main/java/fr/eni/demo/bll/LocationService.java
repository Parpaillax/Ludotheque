package fr.eni.demo.bll;

import fr.eni.demo.bo.Location;

public interface LocationService {
  void add(Location location);
  Location findByCodeBarre(String codeBarre);
}
