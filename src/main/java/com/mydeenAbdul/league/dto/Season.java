package com.mydeenAbdul.league.dto;

import java.util.List;

public class Season {

	private int id ;
	private int year;
	private List<TeamAndPlayerStat> teamAndPlayerStats;
	private PlayerStats highScored;
	private PlayerStats highSixes;
	private PlayerStats highSR;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<TeamAndPlayerStat> getTeamAndPlayerStats() {
		return teamAndPlayerStats;
	}
	public void setTeamAndPlayerStats(List<TeamAndPlayerStat> teamAndPlayerStats) {
		this.teamAndPlayerStats = teamAndPlayerStats;
	}
	public PlayerStats getHighScored() {
		return highScored;
	}
	public void setHighScored(PlayerStats highScored) {
		this.highScored = highScored;
	}
	public PlayerStats getHighSixes() {
		return highSixes;
	}
	public void setHighSixes(PlayerStats highSixes) {
		this.highSixes = highSixes;
	}
	public PlayerStats getHighSR() {
		return highSR;
	}
	public void setHighSR(PlayerStats highSR) {
		this.highSR = highSR;
	}
	@Override
	public String toString() {
		return "Season [id=" + id + ", year=" + year + ", teamAndPlayerStats=" + teamAndPlayerStats + ", highScored="
				+ highScored + ", highSixes=" + highSixes + ", highSR=" + highSR + "]";
	}
	
	
}
