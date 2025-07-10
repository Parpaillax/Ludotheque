package fr.eni.demo.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class StockTest {

  @Test
  @DisplayName("-- Test add Stock builder : SUCCESS --")
  void testAddStockBuilder() {
    GameType gt = new GameType();
    gt.setName("RPG");
    List<GameType> gtList = new ArrayList<>();
    gtList.add(gt);
    assertNotNull(gt);
    assertThat(gtList).hasSize(1);

    Stock stock = new Stock();
    stock.setName("Baldurs Gate 3");
    stock.setDescription("Jeu RPG au possibilité infinie");
    stock.setRef("154ZOIGZ54");
    stock.setDailyPrice(15.20);
    stock.setGameType(gtList);

    assertNotNull(stock);
    System.out.println(stock);
    System.out.println(gtList);
  }

  @Test
  @DisplayName("-- Test add Stock builder : FAILED --")
  void testAddStockBuilderFailed() {
    GameType gt = new GameType();
    gt.setName("Plateforme");
    List<GameType> gtList = new ArrayList<>();
    gtList.add(gt);
    assertNotNull(gt);
    assertThat(gtList).hasSize(1);

    Stock stock = new Stock();
    stock.setName("Super Mario Bros");
    stock.setDescription("Jeu de plateforme pas compliqué");
    stock.setDailyPrice(8.10);
    stock.setGameType(gtList);
    assertNull(stock.getRef());
  }
}
