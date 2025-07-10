package fr.eni.demo.dal;

import fr.eni.demo.bo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LocationRepositoryTest {

  @Autowired
  LocationRepository locationRepo;

  @Test
  @DisplayName("-- Test add Location, game and client with repo : SUCCESS --")
  void testAddLocationGameSuccess() {
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

    GameType gt = new GameType();
    gt.setName("FPS");
    List<GameType> gtList = new ArrayList<>();
    assertNotNull(gt);
    gtList.add(gt);

    Stock stock = new Stock();
    stock.setGameType(gtList);
    stock.setRef("ZEG45456ZGJNZG4GSG");
    stock.setName("Counter Strike 2");
    stock.setDailyPrice(15.25);
    stock.setDescription("Jeu de tir a la première personne stratégique");
    assertNotNull(stock);
    System.out.println(stock);

    Location l = new Location();
    l.setClient(client);
    l.setStock(stock);
    l.setStartDate(Date.valueOf(LocalDate.of(2025, 7, 8)));
    assertNotNull(l);
    locationRepo.saveAndFlush(l);
    System.out.println(l);
  }

  @Test
  @DisplayName("-- Test add Location and game but without client with repo : FAILED --")
  void testAddLocationGameFailure() {
    GameType gt = new GameType();
    gt.setName("FPS");
    List<GameType> gtList = new ArrayList<>();
    gtList.add(gt);
    assertNotNull(gt);

    Stock stock = new Stock();
    stock.setGameType(gtList);
    stock.setRef("ZEG45456ZGJNZG4GSG");
    stock.setName("Counter Strike 2");
    stock.setDailyPrice(15.25);
    stock.setDescription("Jeu de tir a la première personne stratégique");
    assertNotNull(stock);
    System.out.println(stock);

    Location l = new Location();
    l.setStock(stock);
    l.setStartDate(Date.valueOf(LocalDate.of(2025, 7, 8)));
    assertNotNull(l);
    assertNull(l.getClient());
    assertThrows(Exception.class, () -> {
      locationRepo.saveAndFlush(l);
    });
    System.out.println(l);
  }
}
