package fr.eni.demo.bll;

import fr.eni.demo.bo.Client;
import fr.eni.demo.dal.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public void add(Client client) {
    clientRepository.save(client);
  }
}
