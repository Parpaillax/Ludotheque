package fr.eni.demo.bll;

import fr.eni.demo.bo.User;
import java.util.Optional;
import java.util.List;

public interface UserService {
    void addUser(User user);
    Optional<User> findByUsername(String username);
    List<User> findAll();
} 