package fr.eni.demo.dal;

import fr.eni.demo.bo.GameType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GameTypeRepositoryTest {

  @Autowired
  GameTypeRepository gameTypeRepo;

  @Test
  @DisplayName("-- Test add GameType with repo : SUCCESS --")
  void testAddGameTypeSuccess() {
    GameType gt = new GameType();
    gt.setName("FPS");

    assertNotNull(gt);
    gameTypeRepo.save(gt);
    System.out.println(gt);
  }
  // You cant failed to create a GameType...
}
