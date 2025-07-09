package fr.eni.demo.dal;

import java.util.*;

import fr.eni.demo.bo.Employe;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeRepositoryImpl implements EmployeRepository {
    private List<Employe> employes = new ArrayList<>();

    @Override
    public void create(Employe employe) {
        employes.add(employe);
    }

    @Override
    public Employe read(Integer id) {
        return employes.stream().filter(item -> item.getId() == id).findAny().orElse(null);
    }

    @Override
    public Employe findByImmatriculation(String immatriculation) {
        return employes.stream().filter(item -> item.getImmatriculation() == immatriculation).findAny().orElse(null);
    }

    @Override
    public List<Employe> findAll() {
        return employes;
    }

    @Override
    public void update(Employe employe) {
        Employe emp = read(employe.getId());
        if (emp != null) {
            emp.setEmail(employe.getEmail());
            emp.setPrenom(employe.getPrenom());
        }
    }
    @Override public void delete(Employe employe) {
        employes.remove(employe);
    }
}