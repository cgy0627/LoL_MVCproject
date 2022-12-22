package lol.dto;

public class ChampionDTO {
	private String champName; // 챔피언 이름
	private String role;	   // 챔피언 역할
	
	public ChampionDTO(String champName, String role) {
		super();
		this.champName = champName;
		this.role = role;
	}

	public String getchampName() {
		return champName;
	}

	public void setchampName(String champName) {
		this.champName = champName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ChampionDTO [champName=" + champName + ", role=" + role + "]";
	}
	
	
	
}
