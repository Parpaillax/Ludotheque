package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Client;
import fr.eni.demo.dal.AdresseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdresseServiceImpl implements AdresseService {

  private final AdresseRepository adresseRepo;
  private final ClientService clientService;

  @Override
  public Adresse add(Adresse adresse) {
    validateAdresse(adresse);
    return adresseRepo.save(adresse);
  }

  @Override
  public Adresse findById(Long id) {
    return adresseRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Adresse non trouvée"));
  }

  @Override
  public List<Adresse> findAll() {
    return adresseRepo.findAll();
  }

  @Override
  public Adresse update(Long id, Adresse updatedAdresse) {
    Adresse existing = findById(id);
    updatedAdresse.setId(existing.getId()); // conserve l'id existant
    validateAdresse(updatedAdresse);
    return adresseRepo.save(updatedAdresse);
  }

  @Override
  public void delete(Long id) {
    Adresse adresse = findById(id);
    adresseRepo.delete(adresse);
  }

  @Override
  public Adresse findAdresseByClientId(Long clientId) {
    Client client = clientService.findById(clientId);
    return client.getAdresse();
  }

  private void validateAdresse(Adresse adresse) {
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
  }
}
