package lol.view;

import java.sql.SQLException;
import java.util.Scanner;

import lol.controller.ManagerController;
import lol.controller.UserController;
import lol.exception.NotExistException;

// StarView = Controller에 있는 함수 실행하기
public class LolStartView {
   public static void main(String[] args) throws SQLException, NullPointerException, NotExistException {
      UserController userController = UserController.getInstance();
      ManagerController managerController = ManagerController.getInstance();

//    ------------------- 기본적인 CRUD -------------------
      // 조회
    managerController.getAllChampion(); 							// 전체 챔피언
      
    managerController.getAllGame();     							// 전체 게임 조회
    managerController.getAllGameHistory();  						// 전체 게임 히스토리 조회
      
    managerController.allUsers();         						// 전체 유저 조회
    managerController.getUser("아마존물타기");						// 유저 조회
    managerController.getUserGameHistory("Ddukbul04");			// 해당 유저의 게임 히스토리
      
      // 추가 및 수정
      
    managerController.insertChampion("챔피온 추가", "역할 추가");       	// 챔피언 추가 (캐릭터) 
      
    managerController.addUser("신규id", "닉네임", "비밀번호");          // 유저 추가
    managerController.changeState();     						    // 유저 상태 변경 (마지막 접속일 3년 초과시)
    managerController.updateNickname("미간폭격기", "미간폭격기_1234");   // 닉네임 변경
    managerController.updatePassword("꽉잡아주네", "newpassword");    // 비밀번호 변경 
      
      
//    ------------------- 몽글 자체 서비스 -------------------
//    1. 게임 날짜별 조회
//    System.out.println("[특정일 게임조회]");
    managerController.getGame("2022-10-06"); 
     
//    2. GameHistory
//    System.out.println("[특정 유저의 승률]");
    managerController.getUserVic("Ddukbul0");
//    System.out.println();
      
//    System.out.println("[특정 유저가 가장 많이 플레이 한 챔피온]");
    managerController.getMostPlayedChamp("Ddukbul04");
//    System.out.println();
//
//	  3. 랭크 비교 (본인 아이디, 상대방 아이디)
//    System.out.println("[랭크 비교]");
    managerController.compareRank("Ddukbul04", "레전드의 극");
      
//    4. 존재하는 유저 예외 처리
//    System.out.println("[이미 존재하는 유저 예외처리]");
    managerController.addUser("신규id", "닉네임", "비밀번호");      
    managerController.updateNickname("꽉잡아주네", "미간폭격기_1234");

      
	

      
      
   }
}