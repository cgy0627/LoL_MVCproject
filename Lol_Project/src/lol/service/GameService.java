package lol.service;

import java.sql.SQLException;
import java.util.ArrayList;

import lol.dto.GameDTO;
import lol.model.GameDAO;

public class GameService {
	private static GameService instance = new GameService();

	   
   private GameService() {};
	   
   public static GameService getInstance() {
      return instance;
   }
      public static ArrayList<GameDTO> getAllGame() throws SQLException {
      return GameDAO.getAllGame();
   
   }
   
   public static GameDTO getGame(String time) throws SQLException {
      return GameDAO.getGame(time);
      
   }

	      
}
