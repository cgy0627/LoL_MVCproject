// GameHistoryDAO
package lol.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lol.dto.GameHistoryDTO;
import lol.util.DBUtil;

public class GameHistoryDAO {

   // 1. 전체조회 
   public static ArrayList<GameHistoryDTO> getAllGameHistory() throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<GameHistoryDTO> allHistory = null;
      
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("SELECT * FROM game_history");
         rset = pstmt.executeQuery();
         
         allHistory = new ArrayList<GameHistoryDTO>();
         
         while (rset.next()) {
            allHistory.add(new GameHistoryDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getBoolean(6)));
         }
      } finally {
         DBUtil.close(con, pstmt, rset);
      }
      return allHistory;
   }
   
   // 2. 특정 유저의 게임 내역 조회 (유저id)
   public static ArrayList<GameHistoryDTO> getUserHistory(String userID) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<GameHistoryDTO> gameHistory = null;
      
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("SELECT * FROM game_history WHERE user_id = ?");
         pstmt.setString(1, userID);
         rset = pstmt.executeQuery();
         
         gameHistory = new ArrayList<GameHistoryDTO>();
         
         while (rset.next()) {
            gameHistory.add(new GameHistoryDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getBoolean(6)));
         }
         
      } finally {
         DBUtil.close(con, pstmt);
      }
         
      return gameHistory;
   }
   
   
}