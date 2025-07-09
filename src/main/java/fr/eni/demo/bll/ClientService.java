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
    if (client.getPrenom() == null) {
      Client clientTest = new Client();
      clientTest.setPrenom("Olivier");
      clientTest.setNom("Parpaillon");
      clientTest.setEmail("olivier@test.fr");
      clientRepository.save(clientTest);
    } else {
      clientRepository.save(client);
    }
  }
}
