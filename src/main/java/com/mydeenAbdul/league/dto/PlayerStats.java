package com.mydeenAbdul.league.dto;

import java.util.Objects;

public class PlayerStats {

	private int id;
	private String name;
	private int sixes;
	private int fours;
	private int total;
	private int balls;
	private double sr;
	private int highScore;
	private int overs;
	private int wickets;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public double getSr() {
		return sr;
	}
	public void setSr(double sr) {
		this.sr = sr;
	}
	
	public int getHighScore() {
		return highScore;
	}
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs = overs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	@Override
	public String toString() {
		return "PlayerStats [id=" + id + ", name=" + name + ", sixes=" + sixes + ", fours=" + fours + ", total=" + total
				+ ", balls=" + balls + ", sr=" + sr + ", highScore=" + highScore + ", overs=" + overs + ", wickets="
				+ wickets + "]";
	}
	@Override
	public boolean equals(Object obj) {
		Player player = (Player)obj;
		return this.name.equals(player.getName());
	}
	
	

}
