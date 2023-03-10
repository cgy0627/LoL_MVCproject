package lol.controller;

import java.sql.SQLException;

import lol.exception.AlreadyExistException;
import lol.exception.NotExistException;
import lol.service.ChampionService;
import lol.service.GameHistoryService;
import lol.service.GameService;
import lol.service.UserService;
import lol.view.LolEndView;

// Controller = Service에 있는 DAO 함수들 실행하고 EndView를 통해 출력까지 함
public class UserController {
	private static UserController instance = new UserController();
	private UserController() {};
	public static UserController getInstance() {
		return instance;
	}
	
	private ChampionService championService = ChampionService.getInstance();
	private GameService gameService = GameService.getInstance();
	private GameHistoryService gameHistoryService = GameHistoryService.getInstance();
	private UserService userService = UserService.getInstance();
	
	
	/*Champion controller*/
	   
	// champion 추가 -> 관리자
   public void getAllChampion() throws SQLException {
      LolEndView.allView(championService.getAllChampion());
      
   }

   
	/*Game controller*/
   
   public void getAllGame() throws SQLException {
	   LolEndView.allView(gameService.getAllGame());
   }
	   
   public void getGame(String time) throws SQLException {
      LolEndView.printView(gameService.getGame(time));
   }
   
   
	/*Game History controller*/
   public void getAllGameHistory() throws SQLException {
	      LolEndView.allView(gameHistoryService.getAllGameHistory());
	   }
	   
   public void getUserGameHistory(String userID) throws SQLException {
      LolEndView.allView(gameHistoryService.getUserGameHistory(userID));
   }
   
   public void getUserVic(String userID) throws SQLException {
      LolEndView.printVicRate(userID, gameHistoryService.getUserVicRate(userID));
   }
   
   public void getMostPlayedChamp(String userID) throws SQLException {
      LolEndView.printChamp(userID, gameHistoryService.getMostPlayedChamp(userID));
   }

	
	/*User controller*/
  
   // 1. 모든 유저 조회
   public void allUsers() {
	   try {
		   LolEndView.allView(userService.getAllUser());
	} catch (SQLException e) {
		e.printStackTrace();
		LolEndView.showError("모든 유저 조회 시 에러 발생");
	}
   }
   
   //2. 유저 추가 ->  관리자
  
   
   // 3. 유저 상태 변경 -> 관리자
  
   // 4. 닉네임 변경
   public boolean updateNickname(String beforeNinkname, String afterNickname) {
	   try {
		return userService.updateNickname(beforeNinkname, afterNickname); 
	} catch (NotExistException e1) {
		e1.printStackTrace();
	} catch (AlreadyExistException e2) {
		System.out.println("이미 사용 중인 닉네임 입니다.");
	} catch (SQLException e3) {
		e3.printStackTrace();
		LolEndView.showError("닉네임 변경 시 에러 발생");
	}
	   
	return false;
   }
   
   // 5. 비밀번호 변경
   public boolean updatePassword(String userId, String newPassword) {
	   try {
		return userService.updatePassword(userId, newPassword);
	} catch (SQLException | NotExistException e) {
		e.printStackTrace();
	}
	return false;
   }
   
   // 6. 유저 검색 (아이디 or 닉네임)
   public void getUser(String user) {
	   try {
		LolEndView.userView(userService.getUser(user));
	} catch (SQLException | NotExistException e) {
		e.printStackTrace();
	}
   }
   
   // 
 
   // 7. 유저 랭크 비교하기
   public void compareRank(String myUserID, String otherUserID) {
      try {
         LolEndView.rankCompare(myUserID, otherUserID, userService.compareRank(myUserID, otherUserID));
      } catch (SQLException | NotExistException e) {
         e.printStackTrace();
      }
   }
   
}