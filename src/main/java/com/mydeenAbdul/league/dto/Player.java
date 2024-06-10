package com.mydeenAbdul.league.dto;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean Batted;
	private boolean bowled;
	private String name;
	private int runsGet;
	private int balls;
	private int fours;
	private int sixs;
	@ElementCollection
    @CollectionTable(name = "player_overs", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "`over`")
	private List<Integer> overs;
	private int maiden;
	private int runsGiven;
	private int wickets;
	private int noBall;
	private int wide;
	private boolean isOut;
	private String bowlerName;
	private String catcher;
	private String outType;
	private String outAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isBatted() {
		return Batted;
	}
	public void setBatted(boolean batted) {
		Batted = batted;
	}
	public boolean isBowled() {
		return bowled;
	}
	public void setBowled(boolean bowled) {
		this.bowled = bowled;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRunsGet() {
		return runsGet;
	}
	public void setRunsGet(int runsGet) {
		this.runsGet = runsGet;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getSixs() {
		return sixs;
	}
	public void setSixs(int sixs) {
		this.sixs = sixs;
	}
	public List<Integer> getOvers() {
		return overs;
	}
	public void setOvers(List<Integer> overs) {
		this.overs = overs;
	}
	public int getMaiden() {
		return maiden;
	}
	public void setMaiden(int maiden) {
		this.maiden = maiden;
	}
	public int getRunsGiven() {
		return runsGiven;
	}
	public void setRunsGiven(int runsGiven) {
		this.runsGiven = runsGiven;
	}
	
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getNoBall() {
		return noBall;
	}
	public void setNoBall(int noBall) {
		this.noBall = noBall;
	}
	public int getWide() {
		return wide;
	}
	public void setWide(int wide) {
		this.wide = wide;
	}
	
	public boolean isOut() {
		return isOut;
	}
	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}
	public String getBowlerName() {
		return bowlerName;
	}
	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}
	public String getCatcher() {
		return catcher;
	}
	public void setCatcher(String catcher) {
		this.catcher = catcher;
	}
	public String getOutType() {
		return outType;
	}
	public void setOutType(String outType) {
		this.outType = outType;
	}
	public String getOutAt() {
		return outAt;
	}
	public void setOutAt(String outAt) {
		this.outAt = outAt;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", runsGet=" + runsGet + ", balls=" + balls + ", fours=" + fours
				+ ", sixs=" + sixs + ", overs=" + overs + ", maiden=" + maiden + ", runsGiven=" + runsGiven
				+ ", wickets=" + wickets + ", noBall=" + noBall + ", wide=" + wide + ", isOut=" + isOut
				+ ", bowlerName=" + bowlerName + ", catcher=" + catcher + ", outType=" + outType + ", outAt=" + outAt
				+ "]";
	}
	
	
	
}
