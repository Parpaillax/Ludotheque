package fr.eni.demo.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GameTypeTest {

  @Test
  @DisplayName("-- Test add GameType builder : SUCCESS --")
  void testAddGameTypeSuccess() {
    GameType gt = new GameType();
    gt.setName("FPS");

    assertNotNull(gt);
    System.out.println(gt);
  }
}
