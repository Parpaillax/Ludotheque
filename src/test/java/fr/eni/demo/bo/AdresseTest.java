package fr.eni.demo.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class AdresseTest {

  @Test
  @DisplayName("-- Test add Adresse with builder : SUCCESS --")
  void testAddAdresseSuccess() {
    Adresse adresse = new Adresse();
    adresse.setCodePostal("75000");
    adresse.setRue("Rue de la paix");
    adresse.setVille("Paris");

    assertNotNull(adresse);
    System.out.println(adresse);
  }

  @Test
  @DisplayName("-- Test add Addresse with builder : FAILED --")
  void testAddAdresseFailed() {
    Adresse adresse = new Adresse();
    adresse.setCodePostal("44000");
    adresse.setRue("Rue d'Orvault");

    assertNull(adresse.getVille());
    System.out.println(adresse);
  }
}
