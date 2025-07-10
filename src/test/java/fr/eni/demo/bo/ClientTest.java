package fr.eni.demo.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ClientTest {

  @Test
  @DisplayName("-- Test add Client builder with Adresse : SUCESS --")
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
    System.out.println(client);
  }

  @Test
  @DisplayName("-- Test add Client builder without Adresse : FAILED --")
  void testAddClientFail() {
    Client client = new Client();
    client.setEmail("julien@test.fr");
    client.setNom("Chateau");
    client.setPrenom("Julien");

    assertNotNull(client);
    assertNull(client.getAdresse());
    System.out.println(client);
    System.out.println(client.getAdresse());
  }


}
