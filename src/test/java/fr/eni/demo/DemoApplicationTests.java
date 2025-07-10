package fr.eni.demo;

import fr.eni.demo.bll.*;
import fr.eni.demo.bo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private ClientServiceImpl clientServiceImpl;
  @Autowired
  private AdresseServiceImpl adresseServiceImpl;
  @Autowired
  private GameTypeServiceImpl gameTypeService;
  @Autowired
  private StockServiceImpl stockServiceImpl;
  @Autowired
  private LocationServiceImpl locationServiceImpl;

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
  void testAddClientWithAdresse() {
    // Création du client
    Client client = new Client();
    client.setEmail("julien@test.fr");
    client.setNom("Chateau");
    client.setPrenom("Julien");

    //Création de la location
    Adresse adresse = new Adresse();
    adresse.setRue("666 Rue des Enfers");
    adresse.setCodePostal("44000");
    adresse.setVille("Nantes");

    //Ajout de la location au client
    client.setAdresse(adresse);
    clientServiceImpl.add(client);

    System.out.println(client);
    System.out.println(adresse);
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
    stockServiceImpl.add(game);
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
    stockServiceImpl.add(game);
    System.out.println(game);
  }

  @Test
  @DisplayName("-- Test add location game to a client --")
  void testAddLocationGame() {
    // Find a client by his ID
    Client client = clientServiceImpl.findById(1L);
    // Find a Game by his ID
    Optional<Stock> game = stockServiceImpl.findById(1L);

    // Create the Location line for this client and the game
    Location gameLocation =  new Location();
    gameLocation.setStartDate(Date.valueOf(LocalDate.of(2025, 7, 8)));
    gameLocation.setClient(client);
    gameLocation.setStock(game.get());
    locationServiceImpl.add(gameLocation);
    System.out.println(gameLocation);
  }

}
