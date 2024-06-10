package com.mydeenAbdul.league.dto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydeenAbdul.league.dao.Repository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Driver {

	static Repository repository = Repository.getInstance();
	public static void main(String[] args) {
//		List<Delivery> deliveries = new ArrayList<>();
//		for(MatchData data : repository.getByYear(2008)) {
//			System.out.println(data);
//			deliveries.addAll(repository.getDelivery((int)data.getId()));
//		}
//		for (Delivery delivery : deliveries) {
//			System.out.println(delivery);
//		}
//		repository.storeDeliveries(getDeliveries());
//		List<Delivery> deliveries = repository.getDelivery(1);
//		for (Delivery delivery : deliveries) {
//			System.out.println(delivery);
//		}
	}
	public Season getSeason(List<Delivery> deliveries) {
		List<Match> matches = getMatches(deliveries);
		Map<String, List<Match>> teams = getTeams(matches);
		Map<String, TeamAndPlayerStat> map = getTeamAndPlayrStat(teams);
		return getSeason(map);
	}
	private Map<String, List<Match>> getTeams(List<Match> mat) {
		Map<String, List<Match>> teams = new HashMap<>();
		for (Match m : mat) {
			List<Match> match = teams.getOrDefault(m.getTeam1Score().getTeam().getName(), new ArrayList<Match>());
			match.add(m);
			teams.put(m.getTeam1Score().getTeam().getName(), match);
			match = teams.getOrDefault(m.getTeam2Score().getTeam().getName(), new ArrayList<Match>());
			match.add(m);
			teams.put(m.getTeam2Score().getTeam().getName(), match);

		}
		return teams;
	}
	private Map<String, TeamAndPlayerStat> getTeamAndPlayrStat(Map<String, List<Match>> teams) {
		Map<String, TeamAndPlayerStat> map = new HashMap<>();
		for (Map.Entry<String, List<Match>> entry : teams.entrySet()) {
			String key = entry.getKey();
			List<Match> val = entry.getValue();
			TeamAndPlayerStat stat = new TeamAndPlayerStat();
			stat.setTeamName(key);
			stat.setPlayerStats(new ArrayList<PlayerStats>());
			for (Match match : val) {
				TeamScore team = match.getTeam1Score().getTeam().getName().equals(key) ? match.getTeam1Score()
						: match.getTeam2Score();
				if (match.getWinner() != null && match.getWinner().getName().equals(key))
					stat.setWinCount(stat.getWinCount() + 1);
				else if (match.getWinner() != null)
					stat.setLoseCount(stat.getLoseCount() + 1);
				stat.setRunsGet(stat.getRunsGet() + team.getTotal());
				List<Player> players = match.getTeam1Score().getTeam().getName().equals(key)
						? match.getTeam1Score().getTeam().getPlayers()
						: match.getTeam2Score().getTeam().getPlayers();
				for (Player player : players) {
					PlayerStats playerStats = null;
					for (PlayerStats pStats : stat.getPlayerStats()) {
						if (pStats.getName().equals(player.getName()))
							playerStats = pStats;
					}
					if (playerStats == null) {
						playerStats = new PlayerStats();
						playerStats.setName(player.getName());
						stat.getPlayerStats().add(playerStats);
					}
					playerStats.setFours(playerStats.getFours() + player.getFours());
					playerStats.setSixes(playerStats.getSixes() + player.getSixs());
					playerStats.setBalls(playerStats.getBalls() + player.getBalls());
					playerStats.setOvers(playerStats.getOvers() + player.getOvers().size());
					playerStats.setTotal(playerStats.getTotal() + player.getRunsGet());
					if (playerStats.getHighScore() < player.getRunsGet())
						playerStats.setHighScore(player.getRunsGet());
					playerStats.setWickets(playerStats.getWickets() + player.getWickets());
					if (playerStats.getBalls() > 0)
						playerStats.setSr(
								((double) playerStats.getTotal() * (double) 100) / (double) playerStats.getBalls());

				}
			}
			map.put(key, stat);
		}
		return map;
	}

	private Season getSeason(Map<String, TeamAndPlayerStat> map) {
		Season season = new Season();
		for (Map.Entry<String, TeamAndPlayerStat> entry : map.entrySet()) {
			String key = entry.getKey();
			TeamAndPlayerStat val = entry.getValue();
			if (season.getTeamAndPlayerStats() == null)
				season.setTeamAndPlayerStats(new ArrayList<TeamAndPlayerStat>());
			season.getTeamAndPlayerStats().add(val);
			for (PlayerStats playerStats : val.getPlayerStats()) {
				if (season.getHighScored() == null)
					season.setHighScored(playerStats);
				else if (season.getHighScored().getTotal() < playerStats.getTotal())
					season.setHighScored(playerStats);
				if (season.getHighSixes() == null)
					season.setHighSixes(playerStats);
				else if (season.getHighSixes().getSixes() < playerStats.getSixes())
					season.setHighSixes(playerStats);
				if (season.getHighSR() == null)
					season.setHighSR(playerStats);
				else if (season.getHighSR().getSr() < playerStats.getSr())
					season.setHighSR(playerStats);
			}
		}
		return season;
	}
	public List<Match> getMatches(List<Delivery> records) {

		// Now you have a list of CricketRecord objects
		for (Delivery record : records) {
			System.out.println(record);
		}
		List<Integer> keys = new ArrayList<>();
		Map<Integer, Match> matches = new HashMap<>();
//			int key = 0;
		for (Delivery deliveries : records) {
//				if(!keys.contains(deliveries.getMatch_id())) keys.add(deliveries.getMatch_id());
//				if(keys.size()>5) break;
//				if(matches.size()>1) break;
//				if(key ==0) key = deliveries.getMatch_id();
			Match m;
//				Inning currentInng;
			TeamScore battingTeamScore;
			TeamScore bowlingTeamScore;
			Player batter = null;
			Player bowler = null;
			if (matches.containsKey(deliveries.getMatch_id())) {
				m = matches.get(deliveries.getMatch_id());
//					if (deliveries.getInning() == 2 && m.getInning2() == null) {
//						Inning inning = new Inning();
//						inning.setInningNum(deliveries.getInning());
//						if (m.getTeam1().getName().equals(deliveries.getBatting_team())) {
//							inning.setBattingTeam(m.getTeam1());
//							inning.setBowlingTeam(m.getTeam2());
//						} else {
//							inning.setBattingTeam(m.getTeam2());
//							inning.setBowlingTeam(m.getTeam1());
//						}
//						m.setInning2(inning);
//					} else if (deliveries.getInning() == 1 && m.getInning1() == null) {
//						Inning inning = new Inning();
//						inning.setInningNum(deliveries.getInning());
//						if (m.getTeam1().getName().equals(deliveries.getBatting_team())) {
//							inning.setBattingTeam(m.getTeam1());
//							inning.setBowlingTeam(m.getTeam2());
//						} else {
//							inning.setBattingTeam(m.getTeam2());
//							inning.setBowlingTeam(m.getTeam1());
//						}
//						m.setInning1(inning);
//					}
				if (m.getTeam1Score().getTeam().getName().equals(deliveries.getBatting_team())) {
					battingTeamScore = m.getTeam1Score();
					bowlingTeamScore = m.getTeam2Score();
				} else {
					battingTeamScore = m.getTeam2Score();
					bowlingTeamScore = m.getTeam1Score();
				}
//					if (deliveries.getInning() == 1)
//						currentInng = m.getInning1();
//					else
//						currentInng = m.getInning2();
			} else {
				m = new Match();
				m.setMatchId(deliveries.getMatch_id());
//            		m.setTeam1();
				Team battingTeam = new Team();
				battingTeam.setName(deliveries.getBatting_team());
				battingTeam.setPlayers(new ArrayList<Player>());
				Team bowlingTeam = new Team();
				bowlingTeam.setName(deliveries.getBowling_team());
				bowlingTeam.setPlayers(new ArrayList<Player>());
				TeamScore team1Score = new TeamScore();
				TeamScore team2Score = new TeamScore();
				if (deliveries.getInning() == 1) {
					team1Score.setTeam(battingTeam);
					team2Score.setTeam(bowlingTeam);
					battingTeamScore = team1Score;
					bowlingTeamScore = team2Score;
				} else {
					team1Score.setTeam(bowlingTeam);
					team2Score.setTeam(battingTeam);
					battingTeamScore = team2Score;
					bowlingTeamScore = team1Score;
				}
//					m.setTeam1(battingTeam);
//					m.setTeam2(bowlingTeam);
//					Inning inning = new Inning();
//					inning.setInningNum(deliveries.getInning());
//					inning.setBattingTeam(battingTeam);
//					inning.setBowlingTeam(bowlingTeam);
//					if (deliveries.getInning() == 1) {
//						m.setInning1(inning);
//					} else {
//						m.setInning2(inning);
//					}
//					currentInng = inning;
				m.setTeam1Score(team1Score);
				m.setTeam2Score(team2Score);
			}
			System.out.println(battingTeamScore.getTeam().getPlayers());
			for (Player p : battingTeamScore.getTeam().getPlayers()) {
				System.out.println(p.getName() + "-->" + deliveries.getBatsman());
				if (p.getName().equals(deliveries.getBatsman())) {
					System.out.println("found");
					batter = p;
					break;
				}
			}
			if (batter == null) {
				Player p = new Player();
				p.setName(deliveries.getBatsman());
				p.setOvers(new ArrayList<Integer>());
				batter = p;
				battingTeamScore.getTeam().getPlayers().add(batter);
			}
			for (Player p : bowlingTeamScore.getTeam().getPlayers()) {
				System.out.println(p.getName() + "-->" + deliveries.getBowler());
				if (p.getName().equals(deliveries.getBowler())) {
					System.out.println("found");
					bowler = p;
					break;
				}
			}
			if (bowler == null) {
				Player p = new Player();
				p.setName(deliveries.getBowler());
				p.setOvers(new ArrayList<Integer>());
				bowler = p;
				bowlingTeamScore.getTeam().getPlayers().add(bowler);
			}
			batter.setBatted(true);
			bowler.setBowled(true);
			batter.setRunsGet(batter.getRunsGet() + deliveries.getBatsman_runs());
			if (deliveries.getBatsman_runs() == 4)
				batter.setFours(batter.getFours() + 1);
			if (deliveries.getBatsman_runs() == 6)
				batter.setSixs(batter.getSixs() + 1);
			bowler.setRunsGiven(bowler.getRunsGiven() + deliveries.getBatsman_runs() + deliveries.getExtra_runs());
			battingTeamScore
					.setTotal(battingTeamScore.getTotal() + deliveries.getBatsman_runs() + deliveries.getExtra_runs());
			if (!bowler.getOvers().contains(deliveries.getOver()))
				bowler.getOvers().add(deliveries.getOver());
			batter.setBalls(batter.getBalls() + 1);
			battingTeamScore.setExtras(battingTeamScore.getExtras() + deliveries.getExtra_runs());
			battingTeamScore.setBalls(battingTeamScore.getBalls() + 1);
			if(deliveries.getWide_runs()>0) {
				bowler.setWide(bowler.getWide() + 1);
				battingTeamScore.setWide(battingTeamScore.getWide() + 1);
			}
			if(deliveries.getBye_runs()>0) {
				battingTeamScore.setByes(battingTeamScore.getByes() + 1);
			}
			if(deliveries.getLegbye_runs()>0) {
				battingTeamScore.setLegByes(battingTeamScore.getLegByes() + 1);
			}
			if(deliveries.getPenalty_runs()>0) {
				battingTeamScore.setPenalty(battingTeamScore.getPenalty() + 1);
			}
			if(deliveries.getNoball_runs()>0) {
				bowler.setNoBall(bowler.getNoBall() + 1);
				battingTeamScore.setNoBall(battingTeamScore.getNoBall() + 1);
			}
			if (deliveries.getPlayer_dismissed()!=null&&!deliveries.getPlayer_dismissed().equals("")) {
				batter.setOut(true);
				battingTeamScore.setWikets(battingTeamScore.getWikets() + 1);
				bowler.setWickets(bowler.getWickets() + 1);
				batter.setOutAt(deliveries.getOver() + "." + deliveries.getBall());
				batter.setOutType(deliveries.getDismissal_kind());
				batter.setBowlerName(bowler.getName());
				batter.setCatcher(deliveries.getFielder());
			}
			matches.put(deliveries.getMatch_id(), m);
//			List<Player> player = players.getOrDefault(deliveries.getBatter(), new ArrayList<Player>());
//			player.add(batter);
//			players.put(deliveries.getBatter(), player);
//			player = players.getOrDefault(deliveries.getBowler(), new ArrayList<Player>());
//			player.add(bowler);
//			players.put(deliveries.getBowler(), player);
		}
		List<Match> mat = new ArrayList<>();
		for (Map.Entry<Integer, Match> entry : matches.entrySet()) {
			Integer matchId = entry.getKey();
			Match val = entry.getValue();
			int team1Balls = val.getTeam1Score().getBalls() - val.getTeam1Score().getWide()
					- val.getTeam1Score().getNoBall();
			int team2Balls = val.getTeam2Score().getBalls() - val.getTeam2Score().getWide()
					- val.getTeam2Score().getNoBall();
			if ((val.getTeam1Score().getWikets() == 10
					&& (val.getTeam2Score().getTotal() > val.getTeam1Score().getTotal()
							|| val.getTeam2Score().getWikets() == 10))
					|| val.getTeam2Score().getWikets() == 10 || team2Balls >= 120
					|| val.getTeam2Score().getTotal() > val.getTeam1Score().getTotal()) {
				TeamScore winnierScore, LoserScore;
				Team winner;
				if (val.getTeam1Score().getTotal() > val.getTeam2Score().getTotal()) {
					winner = val.getTeam1Score().getTeam();
					winnierScore = val.getTeam1Score();
					LoserScore = val.getTeam2Score();
				} else {
					winner = val.getTeam2Score().getTeam();
					winnierScore = val.getTeam2Score();
					LoserScore = val.getTeam1Score();
				}
				val.setWinner(winner);
				val.setStatus(
						winner.getName() + " won by " + (winnierScore.getTotal() - LoserScore.getTotal()) + " runs");
			} else {
				if (val.getTeam2Score().getBalls() > 0) {
					val.setStatus(val.getTeam2Score().getTeam().getName() + " needs "
							+ (val.getTeam1Score().getTotal() - val.getTeam2Score().getTotal()) + " to win");
				} else {
					val.setStatus(val.getTeam1Score().getTeam().getName() + " batting");
				}
			}
			mat.add(val);
		}
//			System.out.println(matches.get(key));
//			System.out.println(matches.get(key).getTeam1Score());
//			System.out.println(matches.get(key).getTeam2Score());
		return mat;
	}
	private static List<Delivery> getDeliveries() {
//		String fileName = "C:/Users/mydeen abdul kadar/Downloads/delivery.csv";
//
//		try (Reader reader = new FileReader(fileName)) {
//			CsvToBean<Delivery> csvToBean = new CsvToBeanBuilder<Delivery>(reader).withType(Delivery.class)
//					.withIgnoreLeadingWhiteSpace(true).build();
//
//			return csvToBean.parse();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
		 ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            // Path to your JSON file
	            File jsonFile = new File("C:/Users/mydeen abdul kadar/Downloads/csvjson.json");

	            // Read JSON file and convert to list of POJOs
	            List<Delivery> pojoList = objectMapper.readValue(jsonFile, new TypeReference<List<Delivery>>() {});

	            // Print the list of POJOs
	           return pojoList;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return new ArrayList<>();
	}
	private static List<MatchData> getMatches() {
		String fileName = "C:/Users/mydeen abdul kadar/Downloads/data.csv";

		try (Reader reader = new FileReader(fileName)) {
			CsvToBean<MatchData> csvToBean = new CsvToBeanBuilder<MatchData>(reader).withType(MatchData.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			return csvToBean.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
