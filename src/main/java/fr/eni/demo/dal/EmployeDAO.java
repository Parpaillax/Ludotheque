package fr.eni.demo.dal;

import java.util.List;
import fr.eni.demo.bo.Employe;

public interface EmployeDAO {
    void create(Employe employe);

    Employe read(Integer id);

    Employe findByImmatriculation(String immatriculation);

    List<Employe> findAll();

    void update(Employe employe);

    void delete(Employe employe);
}