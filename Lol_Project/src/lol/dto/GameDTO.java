package lol.dto;

import java.sql.Date;
// import java.util.Date;

public class GameDTO {
	private int gameId;   		// 게임별 id
	private Date startTime;	// 게임 시작 날짜, 시간
	private Date endTime;	// 게임 종료 날짜, 시간
	
	public GameDTO(int gameId, Date startTime, Date endTime) {
		super();
		this.gameId = gameId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getgameId() {
		return gameId;
	}

	public void setgameId(int gameId) {
		this.gameId = gameId;
	}

	public Date getstartTime() {
		return startTime;
	}

	public void setstartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getendTime() {
		return endTime;
	}

	public void setendTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "GameDTO [gameId=" + gameId + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
}
