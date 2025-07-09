package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.dal.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresseService {

  @Autowired
  AdresseRepository adresseRepository;

  public void add(Adresse adresse) {
    adresseRepository.save(adresse);
  }
}
