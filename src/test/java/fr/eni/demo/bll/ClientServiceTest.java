package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Client;
import fr.eni.demo.dal.AdresseRepository;
import fr.eni.demo.dal.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClientServiceTest {
  @Autowired
  ClientService clientService;
  @MockitoBean
  ClientRepository clientRepo;
  @MockitoBean
  AdresseRepository adresseRepo;

  @Test
  @DisplayName("-- Test add Client and Adresse with service : SUCCESS --")
  void testAddClientSuccess() {
    Client client = new Client();
    client.setPrenom("Test");
    client.setNom("Test");
    client.setEmail("test@test.test");

    Adresse adresse = new Adresse();
    adresse.setId(1);
    adresse.setRue("Rue du test");
    adresse.setCodePostal("12345");
    adresse.setVille("Ville du test");
    client.setAdresse(adresse);

    assertNotNull(client);
    assertNotNull(adresse);
    clientService.add(client);
  }

  @Test
  @DisplayName("-- Test add Client without Adresse with service : FAILED --")
  void testAddClientFailed() {
    Client client = new Client();
    client.setPrenom("Test");
    client.setNom("Test");
    client.setEmail("test@test.test");

    assertNotNull(client);
    assertNull(client.getAdresse());
    assertThrows((IllegalArgumentException.class), () -> {
      clientService.add(client);
    });
    System.out.println(client);
  }

  @Test
  @DisplayName("-- Test findById Client with service : SUCCESS --")
  void testFindByIdSuccess() {
    Client client = new Client();
    client.setId(1);
    client.setPrenom("Test");
    client.setNom("Test");
    client.setEmail("test@test.test");

    Adresse adresse = new Adresse();
    adresse.setId(1);
    adresse.setRue("Rue du test");
    adresse.setCodePostal("12345");
    adresse.setVille("Ville du test");
    client.setAdresse(adresse);
    when(clientRepo.findById(1L)).thenReturn(Optional.of(client));

    Client found = clientService.findById(1L);

    assertNotNull(found);
    assertEquals(found.getPrenom(), client.getPrenom());
    System.out.println(found);
  }

  @Test
  @DisplayName("-- Test findById Client with service : FAILED --")
  void testFindByIdFailed() {
    Long fakeId = 55L;
    assertThrows((EntityNotFoundException.class), () -> {
      clientService.findById(fakeId);
    });
  }

  @Test
  @DisplayName("-- Test findByName Client with service : SUCCESS --")
  void testFindByNameSuccess() {
    Client client = new Client();
    client.setId(1);
    client.setPrenom("Jean");
    client.setNom("Paul");
    client.setEmail("jean-paul@test.test");

    Client client2 = new Client();
    client2.setId(2);
    client2.setPrenom("Paul");
    client2.setNom("Jeanne");
    client2.setEmail("lilian-jeanne@test.test");

    Adresse adresse = new Adresse();
    adresse.setId(1);
    adresse.setRue("Rue du test");
    adresse.setCodePostal("12345");
    adresse.setVille("Ville du test");
    client.setAdresse(adresse);
    client2.setAdresse(adresse);

    when(clientRepo.findByPrenomIgnoreCaseContainingOrNomIgnoreCaseContaining("Paul", "Paul"))
      .thenReturn(List.of(client, client2));
    List<Client> founds = clientService.findByName(client.getNom());

    assertNotNull(founds);
    assertThat(founds).hasSize(2);
    assertEquals(founds.get(0).getPrenom(), client.getPrenom());
    assertEquals(founds.get(1).getNom(), client2.getNom());
    System.out.println(founds);
  }

  @Test
  @DisplayName("-- Test findByName Client with service : FAILED --")
  void testFindByNameFailed() {
    String fakeName = "Olivier";
    assertThrows((EntityNotFoundException.class), () -> {
      clientService.findByName(fakeName);
    });
  }

  @Test
  @DisplayName("-- Test update Client and Adresse with service : SUCCESS --")
  void testUpdateSuccess() {
    Client client = new Client();
    client.setId(1);
    client.setPrenom("Test");
    client.setNom("Test");
    client.setEmail("test@test.test");
    Adresse adresse = new Adresse();
    adresse.setId(1);
    adresse.setRue("Rue du test");
    adresse.setCodePostal("12345");
    adresse.setVille("Ville du test");
    client.setAdresse(adresse);

    Client newClient = new Client();
    newClient.setPrenom("Jean");
    newClient.setNom("Paul");
    newClient.setEmail("paul-jean@test.fr");
    Adresse newAdresse = new Adresse();
    newAdresse.setRue("Rue de la paix");
    newAdresse.setVille("Paris");
    newAdresse.setCodePostal("75000");
    newClient.setAdresse(newAdresse);

    when(clientRepo.findById(1L)).thenReturn(Optional.of(client));
    when(clientRepo.save(any(Client.class))).thenAnswer(invocation -> invocation.getArgument(0));

    assertNotNull(client);
    assertNotNull(client.getAdresse());
    assertNotNull(newClient);
    assertNotNull(newClient.getAdresse());
    clientService.fullUpdate(1L, newClient, newAdresse);
    verify(clientRepo).findById(1L);
    verify(clientRepo).save(client);
    System.out.println(newClient);
  }

  @Test
  @DisplayName("-- Test update Client and Adresse with service : FAILED --")
  void  testUpdateFailed() {
    Long id = 99L;
    Client client = new Client();
    client.setPrenom("Jean");
    Adresse adresse = new Adresse();

    when(clientRepo.findById(id)).thenReturn(Optional.empty());
    assertThrows(Exception.class, () -> {
      clientService.fullUpdate(id, client, adresse);
    });

    verify(clientRepo).findById(id);
    verify(clientRepo, never()).save(any());
  }

  @Test
  @DisplayName("-- Test update only Adresse of Client with service : SUCCESS --")
  void testUpdateOnlyAdresseSuccess() {
    Client client = new Client();
    client.setId(1);
    client.setPrenom("Test");
    client.setNom("Test");
    client.setEmail("test@test.test");
    Adresse adresse = new Adresse();
    adresse.setId(1);
    adresse.setRue("Rue du test");
    adresse.setCodePostal("12345");
    adresse.setVille("Ville du test");
    client.setAdresse(adresse);

    Adresse newAdresse = new Adresse();
    newAdresse.setRue("Rue de la paix");
    newAdresse.setVille("Paris");
    newAdresse.setCodePostal("75000");
    client.setAdresse(newAdresse);

    when(clientRepo.findById(1L)).thenReturn(Optional.of(client));
    when(clientRepo.save(any(Client.class))).thenAnswer(invocation -> invocation.getArgument(0));

    assertNotNull(client);
    assertNotNull(client.getAdresse());
    clientService.updateLocation(1L, newAdresse);
    verify(clientRepo).findById(1L);
    verify(clientRepo).save(client);
    System.out.println(client);
  }
}
