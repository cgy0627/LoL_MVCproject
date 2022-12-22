package lol.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lol.dto.GameDTO;
import lol.util.DBUtil;

public class GameDAO {
   
   // 1. 정보조회  (전체 조회) 
   // DBUtil과 연결
//   static {
//      try {
//         Class.forName("com.mysql.cj.jdbc.Driver");
//      } catch (ClassNotFoundException e) {
//         e.printStackTrace();
//      }
//      
   public static ArrayList<GameDTO> getAllGame() throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<GameDTO> allGame = null;
      
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("SELECT * FROM game");
         rset = pstmt.executeQuery();
         
         allGame = new ArrayList<GameDTO>();
         
         while (rset.next()) {
            allGame.add(new GameDTO(rset.getInt("game_id"), rset.getDate("start_time"), rset.getDate("end_time")));
            
         } 
      } finally {
         DBUtil.close(con, pstmt, rset);
      }
      return allGame;
   }   
         
      
   

   // 2. 정보조회  (날짜로 조회) -> 해당 날짜에 실행된 게임 내역 조회  
   // SELECT * FROM WHERE start_time = 2022-10-06 12:10:25
   public static GameDTO getGame(String time) throws SQLException {
      Connection con = null;
      Statement stmt = null;
      ResultSet rset = null;
      GameDTO game = null;
      
      try {
         con = DBUtil.getConnection();
         
         stmt = con.createStatement();
         
         rset = stmt.executeQuery("SELECT * FROM game WHERE SUBSTR(start_time, 1,10) = " + "'" +time+"'");
         
         if (rset.next()) {
            game = new GameDTO(rset.getInt("game_id"), rset.getDate("start_time"), rset.getDate("end_time"));
            
         } 
      }finally {
            DBUtil.close(con, stmt, rset);
         }
         return game;
      }   
      
   }















