package com.mydeenAbdul.league.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "`MatchData`")
public class MatchData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@CsvBindByName
	private int season;
	@CsvBindByName
	private String city;
	@CsvBindByName
	private String date;
	@CsvBindByName
	private String team1;
	@CsvBindByName
	private String team2;
	@CsvBindByName
	private String toss_winner;
	@CsvBindByName
	private String toss_dicision;
	@CsvBindByName
	private String result;
	@CsvBindByName
	private int dl_applied;
	@CsvBindByName
	private String winner;
	@CsvBindByName
	private int win_by_runs;
	@CsvBindByName
	private int win_by_wickets;
	@CsvBindByName
	private String player_of_match;
	@CsvBindByName
	private String venue;
	@CsvBindByName
	private String umpire1;
	@CsvBindByName
	private String umpire2;
	@CsvBindByName
	private String umpire3;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getToss_winner() {
		return toss_winner;
	}
	public void setToss_winner(String toss_winner) {
		this.toss_winner = toss_winner;
	}
	public String getToss_dicision() {
		return toss_dicision;
	}
	public void setToss_dicision(String toss_dicision) {
		this.toss_dicision = toss_dicision;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getDl_applied() {
		return dl_applied;
	}
	public void setDl_applied(int dl_applied) {
		this.dl_applied = dl_applied;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public int getWin_by_runs() {
		return win_by_runs;
	}
	public void setWin_by_runs(int win_by_runs) {
		this.win_by_runs = win_by_runs;
	}
	public int getWin_by_wickets() {
		return win_by_wickets;
	}
	public void setWin_by_wickets(int win_by_wickets) {
		this.win_by_wickets = win_by_wickets;
	}
	public String getPlayer_of_match() {
		return player_of_match;
	}
	public void setPlayer_of_match(String player_of_match) {
		this.player_of_match = player_of_match;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getUmpire1() {
		return umpire1;
	}
	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}
	public String getUmpire2() {
		return umpire2;
	}
	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}
	public String getUmpire3() {
		return umpire3;
	}
	public void setUmpire3(String umpire3) {
		this.umpire3 = umpire3;
	}
	@Override
	public String toString() {
		return "Match [id=" + id + ", season=" + season + ", city=" + city + ", date=" + date + ", team1=" + team1
				+ ", team2=" + team2 + ", toss_winner=" + toss_winner + ", toss_dicision=" + toss_dicision + ", result="
				+ result + ", dl_applied=" + dl_applied + ", winner=" + winner + ", win_by_runs=" + win_by_runs
				+ ", win_by_wickets=" + win_by_wickets + ", player_of_match=" + player_of_match + ", venue=" + venue
				+ ", umpire1=" + umpire1 + ", umpire2=" + umpire2 + ", umpire3=" + umpire3 + "]";
	}
	
	
}
