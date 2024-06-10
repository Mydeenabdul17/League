package com.mydeenAbdul.league.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TeamScore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id")
	private Team team;
	private int total;
	private int wikets;
	private int balls;
	private int extras;
	private int byes;
	private int legByes;
	private int wide;
	private int noBall;
	private int penalty;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getWikets() {
		return wikets;
	}
	public void setWikets(int wikets) {
		this.wikets = wikets;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public int getExtras() {
		return extras;
	}
	public void setExtras(int extras) {
		this.extras = extras;
	}
	public int getByes() {
		return byes;
	}
	public void setByes(int byes) {
		this.byes = byes;
	}
	public int getLegByes() {
		return legByes;
	}
	public void setLegByes(int legByes) {
		this.legByes = legByes;
	}
	public int getWide() {
		return wide;
	}
	public void setWide(int wide) {
		this.wide = wide;
	}
	public int getNoBall() {
		return noBall;
	}
	public void setNoBall(int noBall) {
		this.noBall = noBall;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	@Override
	public String toString() {
		return "TeamScore [id=" + id + ", team=" + team + ", total=" + total + ", wikets=" + wikets + ", balls=" + balls
				+ ", extras=" + extras + ", byes=" + byes + ", legByes=" + legByes + ", wide=" + wide + ", noBall="
				+ noBall + ", penalty=" + penalty + "]";
	}
	
	
}
