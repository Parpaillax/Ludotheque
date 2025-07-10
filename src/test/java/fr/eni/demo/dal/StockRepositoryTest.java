package fr.eni.demo.dal;

import fr.eni.demo.bo.GameType;
import fr.eni.demo.bo.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StockRepositoryTest {

  @Autowired
  StockRepository stockRepo;

  @Test
  @DisplayName("-- Test add Stock with GameType with repo : SUCCESS --")
  void testAddStockSuccess() {
    GameType gt = new GameType();
    gt.setName("FPS");
    List<GameType> gtList = new ArrayList<>();
    gtList.add(gt);

    Stock stock = new Stock();
    stock.setGameType(gtList);
    stock.setRef("ZEG45456ZGJNZG4GSG");
    stock.setName("Counter Strike 2");
    stock.setDailyPrice(15.25);
    stock.setDescription("Jeu de tir a la première personne stratégique");
    assertNotNull(stock);
    stockRepo.save(stock);
    System.out.println(stock);
  }

  @Test
  @DisplayName("-- Test add Stock and GameType with repo : FAILED --")
  void testAddStockFailed() {
    GameType gt = new GameType();
    gt.setName("FPS");
    List<GameType> gtList = new ArrayList<>();
    gtList.add(gt);

    Stock stock = new Stock();
    stock.setGameType(gtList);
    stock.setName("Super Mario Bros");
    stock.setDailyPrice(8.10);
    stock.setDescription("Jeu de plateforme pas compliqué");
    assertNotNull(stock);
    assertNull(stock.getRef());
    assertThrows(Exception.class, () -> {
      stockRepo.saveAndFlush(stock);
    });
    System.out.println(stock);
  }
}
