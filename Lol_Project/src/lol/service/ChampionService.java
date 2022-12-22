package lol.service;

import java.sql.SQLException;
import java.util.ArrayList;

import lol.dto.ChampionDTO;
import lol.model.ChampionDAO;

public class ChampionService {

   private static ChampionService instance = new ChampionService();
 	   
   private ChampionService() {};
   
   public static ChampionService getInstance() {
      return instance;
   }
   
   // ChampionDAO
   public boolean insertChampion(String champName, String role) throws SQLException {
      return ChampionDAO.insertChampion(champName, role);
   }
   
   public ArrayList<ChampionDTO> getAllChampion() throws SQLException {
      return ChampionDAO.getAllChampion();
   }

	
}
