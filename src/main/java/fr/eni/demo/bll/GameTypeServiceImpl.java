package fr.eni.demo.bll;

import fr.eni.demo.bo.GameType;
import fr.eni.demo.dal.GameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameTypeServiceImpl implements GameTypeService {

  private GameTypeRepository gameTypeRepository;

  public GameTypeServiceImpl(GameTypeRepository gameTypeRepository) {
    this.gameTypeRepository = gameTypeRepository;
  }

  @Override
  public void add(GameType gameType) {
    gameTypeRepository.save(gameType);
  }

  @Override
  public void delete(String id, GameType gt) {
    gameTypeRepository.delete(id, gameType);
  }

  @Override
  public void update(GameType gt) {
    gameTypeRepository.save(gameType);
  }

  @Override
  public List<GameType> findAll() {
    return gameTypeRepository.findAll();
  }
}
