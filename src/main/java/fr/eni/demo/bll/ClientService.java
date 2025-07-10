package fr.eni.demo.bll;

import fr.eni.demo.bo.Client;

import java.util.Optional;

public interface ClientService {
  void add(Client client);
  Optional<Client> findById(Long clientId);
}
