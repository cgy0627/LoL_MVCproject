package lol.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lol.dto.Rank;
import lol.dto.UserDTO;
import lol.util.DBUtil;

public class UserDAO {
	
	// 1. 유저 전체 조회 
	public static ArrayList<UserDTO> getAllUser() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UserDTO> userList = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM user");
			rset = pstmt.executeQuery();
			
			userList = new ArrayList<UserDTO>();
			while (rset.next()) {
				userList.add(new UserDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4), Rank.valueOf(rset.getString(5)), rset.getDate(6), rset.getString(7) ));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return userList;
		
	}
	
	// 2. 유저 추가 (String user_id, String nickname, String password, int level, String rank,  Date lastDate)
	public static boolean addUser(String userId, String nickName, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			// INSERT INTO user VALUES('Ddukbul05', 'Ddukbul05', 'loislois567', 30, 'Silver 3', default);
			
			pstmt = con.prepareStatement("INSERT INTO user VALUES(?, ?, ?, 1, 'BronzeV', default, 'Active')");
			
			pstmt.setString(1, userId);
			pstmt.setString(2, nickName);
			pstmt.setString(3, password);
			
			int result = pstmt.executeUpdate();
			if (result ==1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
		
	}
	
	
	// 3. 오래된 유저 상태 변경 (현재를 기준으로 마지막 접속일이 3년 전일 경우 휴면 처리)
	public static ArrayList<UserDTO> changeState() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		Statement stmt = null;
		ResultSet rset1 = null;
		ArrayList<UserDTO> userList = null;

		try {
			con = DBUtil.getConnection();
			pstmt1 = con.prepareStatement("SELECT * FROM user WHERE TIMESTAMPDIFF(YEAR, last_played, CURRENT_TIMESTAMP)  >= 3 AND state = 'Active'");
			rset1 = pstmt1.executeQuery();
	
			userList = new ArrayList<UserDTO>();
			while (rset1.next()) {
				userList.add(new UserDTO(rset1.getString(1), rset1.getString(2), rset1.getString(3), rset1.getInt(4), Rank.valueOf(rset1.getString(5)), rset1.getDate(6), rset1.getString(7) ));
			}
			
			stmt = con.createStatement();
			stmt.execute("UPDATE user SET state = 'Inactive' WHERE user_id in (SELECT find_id FROM (SELECT user_id as find_id FROM user where TIMESTAMPDIFF(YEAR, last_played, CURRENT_TIMESTAMP)  >= 3) a )");
//			pstmt1 = con.prepareStatement("UPDATE user SET state = 'Inactive' WHERE user_id in (SELECT find_id FROM (SELECT user_id as find_id FROM user where TIMESTAMPDIFF(YEAR, last_played, CURRENT_TIMESTAMP)  >= 3) a )");
//			rset1 = pstmt1.executeQuery();
			
			
		} finally {
			DBUtil.close(con, pstmt1, rset1);
			DBUtil.close(con, stmt);
		}
		
		return userList;
	}
	
	
	// 4. 정보수정_닉네임 (변경전 닉네임, 변경후 닉네임)
	public static boolean updateNickname(String beforeNinkname, String afterNickname ) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			// UPDATE user SET nickname = 'Ddukbul06' WHERE nickname = 'Ddukbul05'
			
			pstmt = con.prepareStatement("UPDATE user SET nickname = ? WHERE nickname = ?");
			
			pstmt.setString(1, afterNickname);
			pstmt.setString(2, beforeNinkname);
			
			int result = pstmt.executeUpdate();
			if (result ==1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
		
	}
	
	// 5. 정보수정_비밀번호 (아이디, 변경후 비밀번호)
	public static boolean updatePassword(String userId, String newPassword ) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			// UPDATE user SET password = '123456' WHERE user_id = 'Ddukbul05';
			pstmt = con.prepareStatement("UPDATE user SET password = ? WHERE user_id = ?");
			
			pstmt.setString(1, newPassword);
			pstmt.setString(2, userId);
			
			int result = pstmt.executeUpdate();
			if (result ==1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	
	}
	
	// 6. 유저검색 (아이디 or 닉네임)
	public static UserDTO getUser(String user) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		UserDTO User = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
//			System.out.println("<" +user+"> 검색 결과");
			rset = stmt.executeQuery("SELECT * FROM user WHERE user_id = '" + user+"' or nickname ='"+user+"'");
						
			if(rset.next()) {
				User = new UserDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4), Rank.valueOf(rset.getString(5)), rset.getDate(6), rset.getString(7));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		
		return User;
		
	}
	


}
	
