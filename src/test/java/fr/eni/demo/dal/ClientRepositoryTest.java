package fr.eni.demo.dal;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientRepositoryTest {

  @Autowired
  ClientRepository clientRepo;

  @Test
  @DisplayName("-- Test add Client and Adresse with Repo : SUCCESS --")
  void testAddClientSuccess() {
    Client client = new Client();
    client.setEmail("olivier@test.fr");
    client.setNom("Parpaillon");
    client.setPrenom("Olivier");

    Adresse adresse = new Adresse();
    adresse.setRue("666 Rue des Enfers");
    adresse.setCodePostal("44000");
    adresse.setVille("Nantes");
    client.setAdresse(adresse);

    assertNotNull(adresse);
    assertNotNull(client);
    clientRepo.save(client);
    System.out.println(client);
  }

  @Test
  @DisplayName("-- Test add Client without Adresse with repo : FAILED --")
  void testAddClientFailed() {
    Client client = new Client();
    client.setEmail("julien@test.fr");
    client.setNom("Chateau");
    client.setPrenom("Julien");

    assertNull(client.getAdresse());
    assertThrows(Exception.class, () -> {
      clientRepo.saveAndFlush(client);
    });
    System.out.println(client);
    System.out.println(client.getAdresse());
  }
}
