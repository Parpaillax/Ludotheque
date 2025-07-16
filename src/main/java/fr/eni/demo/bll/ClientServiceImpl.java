package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Client;
import fr.eni.demo.bo.Location;
import fr.eni.demo.dal.AdresseRepository;
import fr.eni.demo.dal.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

  private ClientRepository clientRepository;
  private AdresseRepository adresseRepository;

  public ClientServiceImpl(ClientRepository clientRepository, AdresseRepository adresseRepository) {
    this.clientRepository = clientRepository;
    this.adresseRepository = adresseRepository;
  }


  @Override
  public void add(Client client) {
    if (client == null) {
      throw new IllegalArgumentException("Client is null");
    }
    if (client.getAdresse() == null) {
      throw new IllegalArgumentException("Adresse mandatory");
    }

    Adresse adresse = client.getAdresse();

    ExampleMatcher matcher = ExampleMatcher.matchingAll()
            .withIgnoreNullValues()
            .withIgnoreCase();

    Example<Adresse> example = Example.of(adresse, matcher);

    Optional<Adresse> existingAdresse = adresseRepository.findOne(example);

    client.setAdresse(existingAdresse.orElseGet(() -> adresseRepository.save(adresse)));

    clientRepository.save(client);
  }


  @Override
  public Client findById(Long clientId) {
    return clientRepository.findById(clientId)
      .orElseThrow(()  -> new EntityNotFoundException("Client not found"));
  }

  @Override
  public List<Client> findByName(String name) {
    if (name.isBlank()) {
      throw new IllegalArgumentException("name is null");
    }
    List<Client> clients = clientRepository.findByPrenomIgnoreCaseContainingOrNomIgnoreCaseContaining(name, name);
    if (clients.isEmpty()) {
      throw new EntityNotFoundException("Aucun client trouvé pour : " + name);
    }
    return clients;
  }

  public void fullUpdate(Long id, Client clientDetails, Adresse adresseDetails) {
    Client client = clientRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Client non trouvé avec l'id " + id));

    client.setPrenom(clientDetails.getPrenom());
    client.setNom(clientDetails.getNom());
    client.setEmail(clientDetails.getEmail());
    if (adresseDetails != null) {
      client.setAdresse(adresseDetails);
    }
    clientRepository.save(client);
  }

  public void updateLocation(Long idClient, Adresse adresseDetails) {
    Client client = clientRepository.findById(idClient)
      .orElseThrow(() -> new EntityNotFoundException("Client non trouvé avec l'id " + idClient));

    client.setAdresse(adresseDetails);
    clientRepository.save(client);
  }
}
