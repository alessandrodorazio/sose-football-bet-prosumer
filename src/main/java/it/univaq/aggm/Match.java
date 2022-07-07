package it.univaq.aggm;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Match")
public class Match {
	private Team localTeam;
	private Team visitorTeam;
	private int localTeamScore;
	private int visitorTeamScore;
	private String coordinates;
	
	public Match() {
		
	}
	
	public Match(Team localTeam, Team visitorTeam) {
		this.localTeam = localTeam;
		this.visitorTeam = visitorTeam;
	}
	
	public Match(Team localTeam, int localTeamScore, Team visitorTeam, int visitorTeamScore, String coordinates) {
		this.localTeam = localTeam;
		this.localTeamScore = localTeamScore;
		this.visitorTeam = visitorTeam;
		this.visitorTeamScore = visitorTeamScore;
		this.coordinates = coordinates;
	}
	
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
