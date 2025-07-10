package fr.eni.demo.bll;

import fr.eni.demo.bo.Client;
import fr.eni.demo.dal.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements  ClientService {

  private ClientRepository clientRepository;

  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public void add(Client client) {
    clientRepository.save(client);
  }

  @Override
  public Optional<Client> findById(Long clientId) {
    return clientRepository.findById(clientId);
  }
}
