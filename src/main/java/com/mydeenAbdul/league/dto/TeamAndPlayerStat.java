package com.mydeenAbdul.league.dto;

import java.util.List;

public class TeamAndPlayerStat {

	private int id;
	private String TeamName;
	private int winCount;
	private int loseCount;
	private int runsGet;
	private List<PlayerStats> playerStats;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public int getWinCount() {
		return winCount;
	}
	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}
	public int getLoseCount() {
		return loseCount;
	}
	public void setLoseCount(int loseCount) {
		this.loseCount = loseCount;
	}
	public int getRunsGet() {
		return runsGet;
	}
	public void setRunsGet(int runsGet) {
		this.runsGet = runsGet;
	}
	public List<PlayerStats> getPlayerStats() {
		return playerStats;
	}
	public void setPlayerStats(List<PlayerStats> playerStats) {
		this.playerStats = playerStats;
	}
	@Override
	public String toString() {
		return "TeamAndPlayerStat [id=" + id + ", TeamName=" + TeamName + ", winCount=" + winCount + ", loseCount="
				+ loseCount + ", runsGet=" + runsGet + ", playerStats=" + playerStats + "]";
	}
	
}
