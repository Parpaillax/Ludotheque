package fr.eni.demo.bll;

import fr.eni.demo.bo.Facture;
import fr.eni.demo.bo.Location;

import java.util.List;

public interface FactureService {
  List<Facture> getByClient(Long clientId);
  List<Facture> getAll();
  List<Facture> getUnpayed();
  void add(Facture facture);
}
