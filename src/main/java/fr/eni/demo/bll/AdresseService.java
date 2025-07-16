package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;

import java.util.List;

public interface AdresseService {

  Adresse add(Adresse adresse);
  Adresse findById(Long id);
  List<Adresse> findAll();
  Adresse update(Long id, Adresse adresse);
  void delete(Long id);
  Adresse findAdresseByClientId(Long clientId);
}
