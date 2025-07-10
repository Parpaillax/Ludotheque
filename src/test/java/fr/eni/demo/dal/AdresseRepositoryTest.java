package fr.eni.demo.dal;

import fr.eni.demo.bo.Adresse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdresseRepositoryTest {

  @Autowired
  AdresseRepository adresseRepo;

  @Test
  @DisplayName("-- Test add Adresse with repo : SUCCESS --")
  void testAddAdresseRepo() {
    Adresse adresse = new Adresse();
    adresse.setCodePostal("75000");
    adresse.setRue("Rue de la paix");
    adresse.setVille("Paris");

    assertNotNull(adresse);
    adresseRepo.save(adresse);
    System.out.println(adresse);
  }

  @Test
  @DisplayName("-- Test add Adresse with repo : FAILED --")
  void testAddAdresseRepoFail() {
    Adresse adresse = new Adresse();
    adresse.setCodePostal("44000");
    adresse.setRue("Rue d'Orvault");
    adresse.setVille(null); // ville manquante volontairement

    assertThrows(Exception.class, () -> {
      adresseRepo.saveAndFlush(adresse);
    });
    System.out.println(adresse);
  }
}
