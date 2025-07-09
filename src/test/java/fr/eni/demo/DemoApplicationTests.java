package fr.eni.demo;

import fr.eni.demo.bll.ClientService;
import fr.eni.demo.bll.LocationService;
import fr.eni.demo.bo.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private ClientService clientService;

  @Autowired
  private LocationService locationService;

  @Test
  @DisplayName("-- Test add Client --")
  void testAddClient() {
    //Création de l'objet client
    Client client = new Client();
    client.setEmail("olivier@test.fr");
    client.setNom("Parpaillon");
    client.setPrenom("Olivier");

    clientService.add(client);
  }

}
