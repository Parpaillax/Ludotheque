package fr.eni.demo.bll;

import fr.eni.demo.bo.GameType;
import fr.eni.demo.dal.GameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameTypeService {

  @Autowired
  private GameTypeRepository gameTypeRepository;

  public void add(GameType gameType) {
    gameTypeRepository.save(gameType);
  }
}
