package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Client;
import fr.eni.demo.dal.AdresseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresseServiceImpl implements AdresseService{

  private AdresseRepository adresseRepo;
  @Autowired
  private ClientService clientService;

  public AdresseServiceImpl(AdresseRepository adresseRepo) {
    this.adresseRepo = adresseRepo;
  }

  @Override
  public Adresse add(Adresse adresse) {
    if (adresse == null) {
      throw new IllegalArgumentException("Adresse is null");
    }
    if (adresse.getCodePostal() == null || adresse.getCodePostal().isBlank()) {
      throw new IllegalArgumentException("Code postal is null or empty");
    }
    if (adresse.getRue() == null || adresse.getRue().isBlank()) {
      throw new IllegalArgumentException("Rue is null or empty");
    }
    if (adresse.getVille() == null || adresse.getVille().isBlank()) {
      throw new IllegalArgumentException("Ville is null or empty");
    }
    adresseRepo.save(adresse);
    return adresse;
  }

  @Override
  public Adresse findAdresseByClientId(Long clientId) {
    if (clientId == null) {
      throw new IllegalArgumentException("clientId is null");
    }
    System.out.println(clientId);
    Client client = clientService.findById(clientId);
    System.out.println(client);
    return client.getAdresse();
  }

  @Override
  public Adresse findById(Long id) {
    return adresseRepo.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Adresse non trouvée"));
  }
}
