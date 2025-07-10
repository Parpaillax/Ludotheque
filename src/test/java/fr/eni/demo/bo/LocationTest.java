package fr.eni.demo.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class LocationTest {

  @Test
  @DisplayName("-- Test add Location with game and client builder : SUCCESS")
  void testAddLocationGameSuccess() {
    Adresse adresse = new Adresse();
    adresse.setVille("Paris");
    adresse.setRue("Rue de la paix");
    adresse.setCodePostal("75000");

    assertNotNull(adresse);
    System.out.println(adresse);

    Client client = new Client();
    client.setEmail("test@test.fr");
    client.setAdresse(adresse);
    client.setPrenom("test");
    client.setNom("test");

    assertNotNull(client);
    System.out.println(client);

    GameType gt = new GameType();
    gt.setName("Plateforme");
    List<GameType> gtList = new ArrayList<>();
    gtList.add(gt);
    assertNotNull(gt);
    assertThat(gtList).hasSize(1);
    System.out.println(gtList);

    Stock stock = new Stock();
    stock.setName("Super Mario Bros");
    stock.setDescription("Jeu de plateforme pas compliqué");
    stock.setDailyPrice(8.10);
    stock.setGameType(gtList);
    stock.setRef("654POAZJIHGOG646");

    assertNotNull(stock);
    System.out.println(stock);

    Location l = new Location();
    l.setClient(client);
    l.setStock(stock);
    l.setStartDate(Date.valueOf(LocalDate.of(2025, 7, 8)));
    assertNotNull(l);
    System.out.println(l);
  }

  @Test
  @DisplayName("-- Test add location with game but without client builder : FAILED --")
  void testAddLocationGameFailure() {
    GameType gt = new GameType();
    gt.setName("Aventure");
    List<GameType> gtList = new ArrayList<>();
    gtList.add(gt);
    assertNotNull(gt);
    assertThat(gtList).hasSize(1);
    System.out.println(gtList);

    Stock stock = new Stock();
    stock.setName("Tomb Raider");
    stock.setDescription("Jeu d'aventure et d'archéologie coolos");
    stock.setDailyPrice(18.10);
    stock.setGameType(gtList);
    stock.setRef("ZOIGHE45ZPIG452");

    assertNotNull(stock);
    System.out.println(stock);

    Location l = new Location();
    l.setStock(stock);
    l.setStartDate(Date.valueOf(LocalDate.of(2025, 7, 8)));
    assertNull(l.getClient());
    assertNotNull(l);
    System.out.println(l);
  }
}
