package fr.eni.demo.bll;

import fr.eni.demo.bo.GameType;

public interface GameTypeService {
  void add(GameType gameType);
  void update(GameType gameType);
  void delete(GameType gameType);
}
