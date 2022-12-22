// GameHistoryService
package lol.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lol.dto.GameHistoryDTO;
import lol.model.GameHistoryDAO;

// Service = DAO 함수 이용해서 서비스 구현하기
public class GameHistoryService {
      
   private static GameHistoryService instance = new GameHistoryService();
   
   private GameHistoryService() {};
   
   public static GameHistoryService getInstance() {
      return instance;
   }
   
   // 게임 히스토리 전체 조회하기
   public ArrayList<GameHistoryDTO> getAllGameHistory() throws SQLException {
      return GameHistoryDAO.getAllGameHistory();
   }
   // 유저 한 명의 게임 히스토리 조회하기
   public ArrayList<GameHistoryDTO> getUserGameHistory(String userID) throws SQLException {
      return GameHistoryDAO.getUserHistory(userID);
   }
   
   // 특정 유저의 승률 구하기
   public double getUserVicRate(String userID) throws SQLException {
      ArrayList<GameHistoryDTO> userHistory = GameHistoryDAO.getUserHistory(userID);
      double numVic = 0;
      double totalGames = userHistory.size();
      for(GameHistoryDTO history : userHistory) {
         if(history.getVictory()) {
            numVic += 1;
         }
      }
      
      return Math.round(numVic/totalGames*100.0);
   }
   
   // 특정 유저가 가장 많이 플레이한 챔피언 구하기
   public String getMostPlayedChamp(String userID) throws SQLException {
      ArrayList<GameHistoryDTO> userHistory = GameHistoryDAO.getUserHistory(userID);
      Map<String, Integer> champFreq = new HashMap<String, Integer>();
      String mostPlayedChamp = null;
      
      for(GameHistoryDTO history : userHistory) {
         String champ = history.getchampName();
         int count = champFreq.containsKey(champ) ? champFreq.get(champ) : 0; 
         champFreq.put(champ, count + 1);
      }
      
      int maxFreq = 0;
      for(String champ : champFreq.keySet()) {
         if(champFreq.get(champ) > maxFreq) {
            mostPlayedChamp = champ;
         }
      }
      
      return mostPlayedChamp;
   }
   
}