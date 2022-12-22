package lol.view;

import java.util.ArrayList;

import lol.dto.GameDTO;
import lol.dto.UserDTO;

public class LolEndView {
   // 게임 히스토리
   // 모든 게임 히스토리 출력
   public static void allView(ArrayList<?> allList) {
      for(int i = 0; i < allList.size(); i++) {
         System.out.println(allList.get(i));
      }
   }
   
   
   // 특정 유저 조회
   public static void userView(UserDTO user) {
	   System.out.println(user);
   }
   
   // 상태가 변경된 유저 출력
   public static void printState(ArrayList<UserDTO> allList) {
	   if(allList.isEmpty()) {
		   System.out.println("상태를 변경할 유저가 없습니다.");
	   }
      for(int i = 0; i < allList.size(); i++) {
         System.out.println(allList.get(i).getuserId() +"님의 상태가 Active -> Inactive로 변경 되었습니다.");
      }
   }
   
   public static void printVicRate(String userID, double number) {
      System.out.println(userID + " 님의 승률은 " + number + " % 입니다.");
   }
   
   public static void printChamp(String userID, String champ) {
      System.out.println(userID + " 님이 가장 많이 플레이 한 챔피온은 \"" + champ + "\" 입니다.");
   }
   
   public static void printView(GameDTO gd) {
	      System.out.println(gd.toString());
	   }
	   
   public static void successView(boolean bo) {
      if (bo) {
         System.out.println("추가 되었습니다");
      }
   }
   
   public static void rankCompare(String myUserID, String otherUserID, int result) {
      if(result == 1) {
         System.out.println("나의 랭크가 " + otherUserID + " 님의 랭크보다 높습니다.");
      }
      else if(result == 0) {
         System.out.println("나의 랭크와 " + otherUserID + " 님의 랭크가 같습니다.");
      }
      else {
         System.out.println("나의 랭크가 \"" + otherUserID + "\"님의 랭크보다 낮습니다.");
      }
   }

   
 //예외 상황 출력
   public static void showError(String message){
 		System.out.println(message);
   }
   
   
}