package lol.dto;

import java.sql.Date;

public class UserDTO {
	private String userId;  	// 유저 아이디 (플레이어 아이디)
	private String nickname;	// 유저 닉네임
	private String password;	// 유저 비밀번호
	private int level;			// 유저 레벨
	private Rank rank;		// 유저 랭킹
	private Date lastDate;		// 마지막 접속일자
	private String state;		// 상태
	
	public UserDTO(String userId, String nickname, String password, int level, Rank rank, Date lastDate, String state) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.password = password;
		this.level = level;
		this.rank = rank;
		this.lastDate = lastDate;
		this.state = state;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", nickname=" + nickname + ", password=" + password + ", level=" + level
				+ ", rank=" + rank + ", lastDate=" + lastDate + ", state=" + state + "]";
	}

	
	
	
}
