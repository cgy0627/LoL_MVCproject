package lol.service;

import java.sql.SQLException;
import java.util.ArrayList;

import lol.dto.UserDTO;
import lol.exception.AlreadyExistException;
import lol.exception.NotExistException;
import lol.model.UserDAO;
import lol.view.LolEndView;

public class UserService {
      
   private static UserService instance = new UserService();
   
   private UserService() {};
   
   public static UserService getInstance() {
      return instance;
   }

   // UserDAO
   // notExistUser
   public void notExistUser(String user) throws SQLException, NotExistException {
	   UserDTO User = UserDAO.getUser(user);
	   if (User == null) {
		   throw new NotExistException("존재하지 않는 유저입니다.");
	   }
   }
   // userAlreadyExist
   public void userAlreadyExist(String user) throws SQLException, AlreadyExistException {
	   UserDTO User = UserDAO.getUser(user);
	   if (User != null) {
		   throw new AlreadyExistException("이미 존재하는 유저입니다.");
	   }
   }
   // 1. 유저 전체 조회 	
   public ArrayList<UserDTO> getAllUser() throws SQLException {
	   return UserDAO.getAllUser();
   }
   
   // 2. 유저 추가
   public boolean addUser(String userId, String nickName, String password) throws SQLException, AlreadyExistException {
	   userAlreadyExist(userId);
	   return UserDAO.addUser(userId, nickName, password);
   }
   
	// 3. 오래된 유저 삭제 (현재를 기준으로 마지막 접속일이 3년 전일 경우 유저 휴면처리)
   public ArrayList<UserDTO>changeState() throws SQLException {
	   return UserDAO.changeState();
   }
   
   // 4. 정보수정_닉네임 (변경전 닉네임, 변경후 닉네임)
   public boolean updateNickname(String beforeNinkname, String afterNickname) throws SQLException, NotExistException, AlreadyExistException {
	   notExistUser(beforeNinkname);
	   userAlreadyExist(afterNickname);
	   return UserDAO.updateNickname(beforeNinkname, afterNickname);
   }
   
	// 5. 정보수정_비밀번호 (아이디, 변경후 비밀번호)
   public boolean updatePassword(String userId, String newPassword) throws SQLException, NotExistException {
	   notExistUser(userId);
	   return UserDAO.updatePassword(userId, newPassword);
   }
   // 6. 유저 검색 (id or 닉네임) 
   public UserDTO getUser(String user) throws SQLException, NotExistException{
	  notExistUser(user);
	   return UserDAO.getUser(user);
   }
   
   // 
   public int compareRank(String myUserID, String otherUserID) throws SQLException, NotExistException {
      int myRank = getUser(myUserID).getRank().getRankCode();
      int otherRank = getUser(otherUserID).getRank().getRankCode();
      
      if(myRank > otherRank) {
         return 1;
      }
      else if(myRank == otherRank) {
         return 0;
      }
      else {
         return -1;   
      }
   }

}