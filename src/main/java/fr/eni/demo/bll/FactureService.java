package fr.eni.demo.bll;

import fr.eni.demo.bo.Facture;

import java.util.List;

public interface FactureService {
  List<Facture> getByClient(Long clientId);
  List<Facture> getAll();
  List<Facture> getUnpayed();
}
