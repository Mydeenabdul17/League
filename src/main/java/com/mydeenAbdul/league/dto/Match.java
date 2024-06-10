package com.mydeenAbdul.league.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`Match`")
public class Match {

	@Id
	private int matchId;
//	private Team team1;
//	private Team team2;
//	private Inning inning1;
//	private Inning inning2;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team1ScoreId")
	private TeamScore team1Score;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team2ScoreId")
	private TeamScore team2Score;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "winneId")
	private Team winner;
	private String status;
	public Match() {
		
	}
	public Match(int match_id) {
		this.matchId = match_id;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
//	public Team getTeam1() {
//		return team1;
//	}
//	public void setTeam1(Team team1) {
//		this.team1 = team1;
//	}
//	public Team getTeam2() {
//		return team2;
//	}
//	public void setTeam2(Team team2) {
//		this.team2 = team2;
//	}
//	public Inning getInning1() {
//		return inning1;
//	}
//	public void setInning1(Inning inning1) {
//		this.inning1 = inning1;
//	}
//	public Inning getInning2() {
//		return inning2;
//	}
//	public void setInning2(Inning inning2) {
//		this.inning2 = inning2;
//	}
	public Team getWinner() {
		return winner;
	}
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
	public TeamScore getTeam1Score() {
		return team1Score;
	}
	public void setTeam1Score(TeamScore team1Score) {
		this.team1Score = team1Score;
	}
	public TeamScore getTeam2Score() {
		return team2Score;
	}
	public void setTeam2Score(TeamScore team2Score) {
		this.team2Score = team2Score;
	}
	
public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//	@Override
//	public String toString() {
//		return "Match [matchId=" + matchId + ", team1=" + team1 + ", team2=" + team2 + ", inning1=" + inning1
//				+ ", inning2=" + inning2 + ", team1Score=" + team1Score + ", team2Score=" + team2Score + ", winner="
//				+ winner + "]";
//	}
	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", team1Score=" + team1Score + ", team2Score=" + team2Score + ", winner="
				+ winner + ", status=" + status + "]";
	}
	
	
	
}
