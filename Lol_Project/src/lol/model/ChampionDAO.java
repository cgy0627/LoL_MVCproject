package lol.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lol.dto.ChampionDTO;
import lol.util.DBUtil;

public class ChampionDAO {
      //1. 챔피언 추가
   public static boolean insertChampion(String champName, String role) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;      
      
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("INSERT INTO champion (champ_name, role) VALUES (?, ?)");
         
         pstmt.setString(1, champName);
         pstmt.setString(2, role);
         
         int result = pstmt.executeUpdate();
         if (result != 0) {
            return true;
         }
      } finally {
         DBUtil.close(con, pstmt);
      } 
      
      return false;
   
      
   }

   
      //2. 챔피언 전체조회
   public static ArrayList<ChampionDTO> getAllChampion() throws SQLException {
      Connection con = null;
      Statement stmt = null;
      ResultSet rset = null;
      ArrayList<ChampionDTO> allChampion = null;
      
      try {
         con = DBUtil.getConnection();
         
         stmt = con.createStatement();
         
         rset = stmt.executeQuery("SELECT * FROM champion");
         
         allChampion = new ArrayList<ChampionDTO> () ;
         
         while (rset.next()) {
            allChampion.add(new ChampionDTO(rset.getString("champ_name"), rset.getString("role")));
            
         } 
      }finally {
            DBUtil.close(con, stmt, rset);
         }
         return allChampion;
      }   
   
   
   
      //3. 챔피언 조회 (역할) -> 해당 역할의 챔피언 모두 조회
}