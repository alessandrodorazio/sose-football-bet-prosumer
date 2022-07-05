package it.univaq.aggm;

public class Match {
	private Team localTeam;
	private Team visitorTeam;
	private int localTeamScore;
	private int visitorTeamScore;
	private String coordinates;
	
	public Team getLocalTeam() {
		return localTeam;
	}
	public void setLocalTeam(Team localTeam) {
		this.localTeam = localTeam;
	}
	public Team getVisitorTeam() {
		return visitorTeam;
	}
	public void setVisitorTeam(Team visitorTeam) {
		this.visitorTeam = visitorTeam;
	}
	public int getLocalTeamScore() {
		return localTeamScore;
	}
	public void setLocalTeamScore(int localTeamScore) {
		this.localTeamScore = localTeamScore;
	}
	public int getVisitorTeamScore() {
		return visitorTeamScore;
	}
	public void setVisitorTeamScore(int visitorTeamScore) {
		this.visitorTeamScore = visitorTeamScore;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
	
}
