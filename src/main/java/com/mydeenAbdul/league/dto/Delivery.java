package com.mydeenAbdul.league.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.opencsv.bean.CsvBindByName;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CsvBindByName
	private int match_id;
	@CsvBindByName
	private int inning;
	@CsvBindByName
	private String batting_team;
	@CsvBindByName
	private String bowling_team;
	@CsvBindByName
	@Column(name = "`over`")
	private int over;
	@CsvBindByName
	private int ball;
	@CsvBindByName
	private String batsman;
	@CsvBindByName
	private String non_striker;
	@CsvBindByName
	private String bowler;
	@CsvBindByName
	private int is_super_over;
	@CsvBindByName
	private int wide_runs;
	@CsvBindByName
	private int bye_runs;
	@CsvBindByName
	private int legbye_runs;
	@CsvBindByName
	private int noball_runs;
	@CsvBindByName
	private int penalty_runs;
	@CsvBindByName
	private int batsman_runs;
	@CsvBindByName
	private int extra_runs;
	@CsvBindByName
	private int total_runs;
	@CsvBindByName
	private String player_dismissed;
	@CsvBindByName
	private String dismissal_kind;
	@CsvBindByName
	private String fielder;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public int getInning() {
		return inning;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	public String getBatting_team() {
		return batting_team;
	}
	public void setBatting_team(String batting_team) {
		this.batting_team = batting_team;
	}
	public String getBowling_team() {
		return bowling_team;
	}
	public void setBowling_team(String bowling_team) {
		this.bowling_team = bowling_team;
	}
	public int getOver() {
		return over;
	}
	public void setOver(int over) {
		this.over = over;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public String getBatsman() {
		return batsman;
	}
	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}
	public String getNon_striker() {
		return non_striker;
	}
	public void setNon_striker(String non_striker) {
		this.non_striker = non_striker;
	}
	public String getBowler() {
		return bowler;
	}
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	public int getIs_super_over() {
		return is_super_over;
	}
	public void setIs_super_over(int is_super_over) {
		this.is_super_over = is_super_over;
	}
	public int getWide_runs() {
		return wide_runs;
	}
	public void setWide_runs(int wide_runs) {
		this.wide_runs = wide_runs;
	}
	public int getBye_runs() {
		return bye_runs;
	}
	public void setBye_runs(int bye_runs) {
		this.bye_runs = bye_runs;
	}
	public int getLegbye_runs() {
		return legbye_runs;
	}
	public void setLegbye_runs(int legbye_runs) {
		this.legbye_runs = legbye_runs;
	}
	public int getNoball_runs() {
		return noball_runs;
	}
	public void setNoball_runs(int noball_runs) {
		this.noball_runs = noball_runs;
	}
	public int getPenalty_runs() {
		return penalty_runs;
	}
	public void setPenalty_runs(int penalty_runs) {
		this.penalty_runs = penalty_runs;
	}
	public int getBatsman_runs() {
		return batsman_runs;
	}
	public void setBatsman_runs(int batsman_runs) {
		this.batsman_runs = batsman_runs;
	}
	public int getExtra_runs() {
		return extra_runs;
	}
	public void setExtra_runs(int extra_runs) {
		this.extra_runs = extra_runs;
	}
	public int getTotal_runs() {
		return total_runs;
	}
	public void setTotal_runs(int total_runs) {
		this.total_runs = total_runs;
	}
	public String getPlayer_dismissed() {
		return player_dismissed;
	}
	public void setPlayer_dismissed(String player_dismissed) {
		this.player_dismissed = player_dismissed;
	}
	public String getDismissal_kind() {
		return dismissal_kind;
	}
	public void setDismissal_kind(String dismissal_kind) {
		this.dismissal_kind = dismissal_kind;
	}
	public String getFielder() {
		return fielder;
	}
	public void setFielder(String fielder) {
		this.fielder = fielder;
	}
	@Override
	public String toString() {
		return "Delivery [id=" + id + ", match_id=" + match_id + ", inning=" + inning + ", batting_team=" + batting_team
				+ ", bowling_team=" + bowling_team + ", over=" + over + ", ball=" + ball + ", batsman=" + batsman
				+ ", non_striker=" + non_striker + ", bowler=" + bowler + ", is_super_over=" + is_super_over
				+ ", wide_runs=" + wide_runs + ", bye_runs=" + bye_runs + ", legbye_runs=" + legbye_runs
				+ ", noball_runs=" + noball_runs + ", penalty_runs=" + penalty_runs + ", batsman_runs=" + batsman_runs
				+ ", extra_runs=" + extra_runs + ", total_runs=" + total_runs + ", player_dismissed=" + player_dismissed
				+ ", dismissal_kind=" + dismissal_kind + ", fielder=" + fielder + "]";
	}
	
}
