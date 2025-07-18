package fr.eni.demo.bll;

import fr.eni.demo.bo.Facture;
import fr.eni.demo.bo.Location;
import fr.eni.demo.dal.FactureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {

  private final FactureRepository factureRepo;
  public FactureServiceImpl(FactureRepository factureRepo) {
    this.factureRepo = factureRepo;
  }

  @Override
  public List<Facture> getByClient(Long clientId) {
    if (clientId == null) {
      throw new IllegalArgumentException("Client id can't be null");
    }
    List<Facture> factures = factureRepo.findByClient(clientId);
    if (factures == null) {
      throw new IllegalArgumentException("No factures found");
    };
    return factures;
  }

  @Override
  public List<Facture> getAll() {
    return factureRepo.findAll();
  }

  @Override
  public List<Facture> getUnpayed() {
    return factureRepo.findByDatePayEmpty();
  }

  @Override
  public void add(Facture facture) {
    factureRepo.save(facture);
  }

}
