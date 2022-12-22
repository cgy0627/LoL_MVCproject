package lol.dto;

public class GameHistoryDTO {
	private int historyId;     // 게임 내역 일렬번호
	private int gameId;		// 게임 아이디
	private String userId;  	// 유저 아이디 (플레이어 아이디)
	private String champName;  // 챔피언 이름
	private String team;          // 팀 구분 (A or B)
	private boolean victory;	// 승패 여부 (true or false)
	
	public GameHistoryDTO(int historyId, int gameId, String userId, String champName, String team, boolean victory) {
		super();
		this.historyId = historyId;
		this.gameId = gameId;
		this.userId = userId;
		this.champName = champName;
		this.team = team;
		this.victory = victory;
	}

	public int gethistoryId() {
		return historyId;
	}

	public void sethistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getgameId() {
		return gameId;
	}

	public void setgameId(int gameId) {
		this.gameId = gameId;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getchampName() {
		return champName;
	}

	public void setchampName(String champName) {
		this.champName = champName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public boolean getVictory() {
		return victory;
	}

	public void setVictory(boolean victory) {
		this.victory = victory;
	}

	@Override
	public String toString() {
		return "GameHistoryDTO [historyId=" + historyId + ", gameId=" + gameId + ", userId=" + userId
				+ ", champName=" + champName + ", team=" + team + ", victory=" + victory + "]";
	}
	
	
}
