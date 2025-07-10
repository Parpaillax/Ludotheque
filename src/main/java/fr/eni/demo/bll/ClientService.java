package fr.eni.demo.bll;

import fr.eni.demo.bo.Adresse;
import fr.eni.demo.bo.Client;

import java.util.List;

public interface ClientService {
  void add(Client client);
  Client findById(Long clientId);
  List<Client> findByName(String name);
  void fullUpdate(Long id, Client client, Adresse adresseDetails);
  void updateLocation(Long idClient, Adresse adresseDetails);
}
