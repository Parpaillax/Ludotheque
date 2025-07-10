package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Client;
import fr.eni.demo.dal.AdresseRepository;
import fr.eni.demo.dal.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdresseServiceTest {
  @Autowired
  AdresseService adresseService;
  @MockitoBean
  AdresseRepository adresseRepo;
  @MockitoBean
  ClientRepository clientRepo;

  @Test
  @DisplayName("-- Test add Adresse with service : SUCCESS --")
  public void addAdresseSuccess() {
    Adresse adresse = new Adresse();
    adresse.setCodePostal("75000");
    adresse.setRue("Rue de la paix");
    adresse.setVille("Paris");

    assertNotNull(adresse);
    adresseService.add(adresse);
    System.out.println(adresse);
  }

  @Test
  @DisplayName("-- Test add Adresse with service : FAILED --")
  void testAddAdresseRepoFail() {
    Adresse adresse = new Adresse();
    adresse.setCodePostal("44000");
    adresse.setRue("Rue d'Orvault");
    adresse.setVille(null); // ville manquante volontairement

    assertThrows((IllegalArgumentException.class), () -> {
      adresseService.add(adresse);
    });
    System.out.println(adresse);
  }

  @Test
  @DisplayName("-- Test findById with service : SUCCESS --")
  void testFindByIdSuccess() {
    Adresse adresse = new Adresse();
    adresse.setId(1);
    adresse.setCodePostal("75000");
    adresse.setRue("Rue de la paix");
    adresse.setVille("Paris");
    when(adresseRepo.findById(1L)).thenReturn(Optional.of(adresse));

    Adresse found = adresseService.findById(Long.valueOf(adresse.getId()));

    assertNotNull(found);
    assertEquals(adresse.getVille(), found.getVille());
    System.out.println(found);
  }

  @Test
  @DisplayName("-- Test findById with service : FAILED --")
  void  testFindByIdFail() {
    Long fakeId = 999L;
    assertThrows(EntityNotFoundException.class, () -> {
      adresseService.findById(fakeId);
    });
  }

  @Test
  @DisplayName("-- Test findAdresseByClientId with service : SUCCESS --")
  void testFindAdresseByClientIdSuccess() {
    Adresse adresse = new Adresse();
    adresse.setId(1);
    adresse.setRue("10 rue Victor Hugo");
    adresse.setCodePostal("75000");
    adresse.setVille("Paris");

    Client client = new Client();
    client.setId(1);
    client.setNom("Dupont");
    client.setPrenom("Jean");
    client.setEmail("jean.dupont@test.fr");
    client.setAdresse(adresse);

    when(clientRepo.findById(1L)).thenReturn(Optional.of(client));

    Adresse result = adresseService.findAdresseByClientId(Long.valueOf(client.getId()));
    System.out.println(result);
    assertNotNull(result);
    assertEquals("Paris", result.getVille());
  }

  @Test
  @DisplayName("-- Test findAdresseByClientId with service : FAILED --")
  void testFindAdresseByClientIdFail() {
    Long fakeId = 999L;
    assertThrows(EntityNotFoundException.class, () -> {
      adresseService.findAdresseByClientId(fakeId);
    });
  }
}
