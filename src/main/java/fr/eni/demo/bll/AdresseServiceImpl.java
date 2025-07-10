package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.dal.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresseServiceImpl implements AdresseService{

  private AdresseRepository adresseRepository;

  public AdresseServiceImpl(AdresseRepository adresseRepository) {
    this.adresseRepository = adresseRepository;
  }

  @Override
  public void add(Adresse adresse) {
    adresseRepository.save(adresse);
  }
}
