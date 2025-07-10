package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;

public interface AdresseService {
  Adresse add(Adresse adresse);
  Adresse findById(Long id);
  Adresse findAdresseByClientId(Long clientId);
}
