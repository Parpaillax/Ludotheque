package fr.eni.demo;

import fr.eni.demo.bll.ClientService;
import fr.eni.demo.bll.GameTypeService;
import fr.eni.demo.bll.LocationService;
import fr.eni.demo.bll.StockService;
import fr.eni.demo.bo.Client;
import fr.eni.demo.bo.GameType;
import fr.eni.demo.bo.Location;
import fr.eni.demo.bo.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private ClientService clientService;
  @Autowired
  private LocationService locationService;
  @Autowired
  private GameTypeService gameTypeService;
  @Autowired
  private StockService stockService;

//  DEPREACTED CAUSE : Cant add Client without Location
//  @Test
//  @DisplayName("-- Test add Client --")
//  void testAddClient() {
//    Client client = new Client();
//    client.setEmail("olivier@test.fr");
//    client.setNom("Parpaillon");
//    client.setPrenom("Olivier");
//
//    clientService.add(client);
//    System.out.println(client);
//  }
//
//  DEPRECATED CAUSE : Orphan removal on Client.Location,
//  so if you add Location without Client, it will be deleted by the ORM
//  @Test
//  @DisplayName("-- Test add Location --")
//  void testAddLocation() {
//    Location location = new Location();
//    location.setRue("18 Rue de la Paix");
//    location.setCodePostal("75000");
//    location.setVille("Paris");
//
//    locationService.add(location);
//    System.out.println(location);
//  }

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

  @Test
  @DisplayName("-- Test add Game --")
  void testAddGame() {
    Stock game = new Stock();
    game.setName("Baldurs Gate 3");
    game.setDailyPrice(25.10);
    game.setDescription("Jeu RPG avec de multiple fin c'est incroyable");
    game.setRef("10GBRESF148KQF");
    stockService.add(game);
    System.out.println(game);
  }

  @Test
  @DisplayName("-- Test add Game with GameType --")
  void testAddGameWithGameType() {
    // Création du jeu
    Stock game = new Stock();
    game.setName("Counter Strike 2");
    game.setDailyPrice(8.50);
    game.setRef("454ZGOIHOZ1215EFZD");

    // Création des genres de jeu
    GameType gameTypeFPS = new GameType();
    gameTypeFPS.setName("FPS");
    System.out.println(gameTypeFPS);

    GameType gameTypeOnline = new GameType();
    gameTypeOnline.setName("Multijoueur");
    System.out.println(gameTypeOnline);

    List<GameType> gameTypes = new ArrayList<>();
    gameTypes.add(gameTypeFPS);
    gameTypes.add(gameTypeOnline);

    // Ajout des genres de jeu au jeu
    game.setGameType(gameTypes);
    stockService.add(game);
    System.out.println(game);
  }

}
