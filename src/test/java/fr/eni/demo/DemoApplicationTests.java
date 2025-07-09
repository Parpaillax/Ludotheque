package fr.eni.demo;

import fr.eni.demo.bll.ClientService;
import fr.eni.demo.bll.GameTypeService;
import fr.eni.demo.bll.LocationService;
import fr.eni.demo.bo.Client;
import fr.eni.demo.bo.GameType;
import fr.eni.demo.bo.Location;
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
  @Autowired
  private GameTypeService gameTypeService;

  @Test
  @DisplayName("-- Test add Client --")
  void testAddClient() {
    //Création de l'objet client
    Client client = new Client();
    client.setEmail("olivier@test.fr");
    client.setNom("Parpaillon");
    client.setPrenom("Olivier");

    clientService.add(client);
    System.out.println(client);
  }

  @Test
  @DisplayName("-- Test add Location --")
  void testAddLocation() {
    Location location = new Location();
    location.setRue("18 Rue de la Paix");
    location.setCodePostal("75000");
    location.setVille("Paris");

    locationService.add(location);
    System.out.println(location);
  }

  @Test
  @DisplayName("-- Test add Client with Location --")
  void testAddClientWithLocation() {
    // Création du client
    Client client = new Client();
    client.setEmail("julien@test.fr");
    client.setNom("Chateau");
    client.setPrenom("Julien");

    //Création de la location
    Location location = new Location();
    location.setRue("666 Rue des Enfers");
    location.setCodePostal("44000");
    location.setVille("Nantes");
    locationService.add(location);

    //Ajout de la location au client
    client.setLocation(location);
    clientService.add(client);

    System.out.println(client);
    System.out.println(location);
  }

  @Test
  @DisplayName("-- Test add Game Type --")
  void testAddGameType() {
    GameType gameType = new GameType();
    gameType.setName("RPG");
    gameTypeService.add(gameType);
    System.out.println(gameType);
  }

}
